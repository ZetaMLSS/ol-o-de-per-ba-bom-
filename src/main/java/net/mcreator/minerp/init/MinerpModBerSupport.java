package net.mcreator.minerp.init;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.common.util.TriState;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.Container;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.minerp.MinerpMod;

import java.util.Optional;

@EventBusSubscriber(modid = MinerpMod.MODID)
public class MinerpModBerSupport {
	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != InteractionHand.MAIN_HAND)
			return;
		Level world = event.getLevel();
		BlockPos pos = event.getPos();
		BlockState blockstate = world.getBlockState(pos);
		Player entity = event.getEntity();
		Block block = blockstate.getBlock();
		if (block == MinerpModBlocks.CARREGADOR_CELULAR.get()) {
			if (entity.isShiftKeyDown())
				return;
			if (areSlotsLocked(world, pos))
				return;
			ItemStack itemstack = entity.getItemInHand(event.getHand());
			int slotid = -1;
			boolean handled = false;
			if (!world.isClientSide())
				slotid = insertOrExtractNext(world, pos, entity, event.getHand());
			handled = true;
			if (handled) {
				event.setCanceled(true);
				event.setCancellationResult(InteractionResult.sidedSuccess(world.isClientSide()));
				event.setUseBlock(TriState.FALSE);
				event.setUseItem(TriState.FALSE);
			}
		}
		if (block == MinerpModBlocks.TRANSFERIDOR_DE_ENERGIA.get()) {
			if (entity.isShiftKeyDown())
				return;
			if (areSlotsLocked(world, pos))
				return;
			ItemStack itemstack = entity.getItemInHand(event.getHand());
			int slotid = -1;
			boolean handled = false;
			if (!world.isClientSide())
				slotid = insertOrExtractNext(world, pos, entity, event.getHand());
			handled = true;
			if (handled) {
				event.setCanceled(true);
				event.setCancellationResult(InteractionResult.sidedSuccess(world.isClientSide()));
				event.setUseBlock(TriState.FALSE);
				event.setUseItem(TriState.FALSE);
			}
		}
	}

	public static int getLookedSlot(LevelAccessor world, BlockPos pos, Entity entity) {
		if (world == null || pos == null || entity == null)
			return -1;
		BlockState state = world.getBlockState(pos);
		Block block = state.getBlock();
		if (block == MinerpModBlocks.CARREGADOR_CELULAR.get())
			return hitTest_ver_celular_carregando_na_base(pos, state, entity);
		if (block == MinerpModBlocks.TRANSFERIDOR_DE_ENERGIA.get())
			return hitTest_transferidor_de_energia_visual(pos, state, entity);
		return -1;
	}

	public static int getDisplaySlotCount(LevelAccessor world, BlockPos pos) {
		if (world == null || pos == null)
			return 0;
		Block block = world.getBlockState(pos).getBlock();
		if (block == MinerpModBlocks.CARREGADOR_CELULAR.get())
			return 1;
		if (block == MinerpModBlocks.TRANSFERIDOR_DE_ENERGIA.get())
			return 1;
		return 0;
	}

	public static int getInventorySlot(LevelAccessor world, BlockPos pos, int displayIndex) {
		if (world == null || pos == null || displayIndex < 0)
			return -1;
		Block block = world.getBlockState(pos).getBlock();
		if (block == MinerpModBlocks.CARREGADOR_CELULAR.get()) {
			int[] map = INV_ver_celular_carregando_na_base;
			return displayIndex < map.length ? map[displayIndex] : -1;
		}
		if (block == MinerpModBlocks.TRANSFERIDOR_DE_ENERGIA.get()) {
			int[] map = INV_transferidor_de_energia_visual;
			return displayIndex < map.length ? map[displayIndex] : -1;
		}
		return -1;
	}

	public static ItemStack getDisplayItem(LevelAccessor world, BlockPos pos, int displayIndex) {
		int inv = getInventorySlot(world, pos, displayIndex);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (inv < 0 || !(blockEntity instanceof Container container) || inv >= container.getContainerSize())
			return ItemStack.EMPTY;
		return container.getItem(inv);
	}

	public static void setDisplayItem(LevelAccessor world, BlockPos pos, int displayIndex, ItemStack stack) {
		int inv = getInventorySlot(world, pos, displayIndex);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (inv < 0 || !(blockEntity instanceof Container container) || inv >= container.getContainerSize())
			return;
		container.setItem(inv, stack == null ? ItemStack.EMPTY : stack);
		blockEntity.setChanged();
		if (world instanceof Level level && !level.isClientSide())
			level.sendBlockUpdated(pos, level.getBlockState(pos), level.getBlockState(pos), 3);
	}

	public static int getFirstEmptyDisplaySlot(LevelAccessor world, BlockPos pos) {
		int count = getDisplaySlotCount(world, pos);
		for (int i = 0; i < count; i++) {
			if (getDisplayItem(world, pos, i).isEmpty())
				return i;
		}
		return -1;
	}

	public static boolean swapLookedSlot(LevelAccessor world, BlockPos pos, Entity entity, InteractionHand hand) {
		if (areSlotsLocked(world, pos))
			return false;
		int slot = getLookedSlot(world, pos, entity);
		if (slot < 0 || !(entity instanceof Player player))
			return false;
		return swapDisplaySlot(world, pos, player, hand, slot);
	}

	public static void setSlotsLocked(LevelAccessor world, BlockPos pos, boolean locked) {
		if (world == null || pos == null)
			return;
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity == null)
			return;
		if (locked)
			blockEntity.getPersistentData().putBoolean("cbjBerSlotsLocked", true);
		else
			blockEntity.getPersistentData().remove("cbjBerSlotsLocked");
		blockEntity.setChanged();
		if (world instanceof Level level && !level.isClientSide())
			level.sendBlockUpdated(pos, level.getBlockState(pos), level.getBlockState(pos), 3);
	}

	public static boolean areSlotsLocked(LevelAccessor world, BlockPos pos) {
		if (world == null || pos == null)
			return false;
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity != null && blockEntity.getPersistentData().getBoolean("cbjBerSlotsLocked");
	}

	public static int insertIntoNextEmpty(LevelAccessor world, BlockPos pos, Entity entity, InteractionHand hand) {
		if (areSlotsLocked(world, pos))
			return -1;
		if (!(entity instanceof Player player))
			return -1;
		ItemStack held = player.getItemInHand(hand);
		if (held.isEmpty())
			return -1;
		int display = getFirstEmptyDisplaySlot(world, pos);
		if (display < 0)
			return -1;
		boolean creative = player.getAbilities().instabuild;
		setDisplayItem(world, pos, display, creative ? held.copy() : held.split(held.getCount()));
		play(world, pos, player, SoundEvents.ITEM_FRAME_ADD_ITEM);
		return display;
	}

	public static int insertOrExtractNext(LevelAccessor world, BlockPos pos, Player player, InteractionHand hand) {
		if (areSlotsLocked(world, pos))
			return -1;
		ItemStack held = player.getItemInHand(hand);
		if (held.isEmpty())
			return extractLastOccupied(world, pos, player);
		return insertIntoNextEmpty(world, pos, player, hand);
	}

	private static int extractLastOccupied(LevelAccessor world, BlockPos pos, Player player) {
		int count = getDisplaySlotCount(world, pos);
		for (int i = count - 1; i >= 0; i--) {
			ItemStack stack = getDisplayItem(world, pos, i);
			if (!stack.isEmpty()) {
				if (!player.addItem(stack.copy()))
					player.drop(stack.copy(), false);
				setDisplayItem(world, pos, i, ItemStack.EMPTY);
				play(world, pos, player, SoundEvents.ITEM_FRAME_REMOVE_ITEM);
				return i;
			}
		}
		return -1;
	}

	private static boolean swapDisplaySlot(LevelAccessor world, BlockPos pos, Player player, InteractionHand hand, int displayIndex) {
		int inv = getInventorySlot(world, pos, displayIndex);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (inv < 0 || !(blockEntity instanceof Container container) || inv >= container.getContainerSize())
			return false;
		ItemStack inSlot = container.getItem(inv);
		ItemStack inHand = player.getItemInHand(hand);
		boolean creative = player.getAbilities().instabuild;
		boolean changed = false;
		SoundEvent sound = SoundEvents.ITEM_FRAME_ADD_ITEM;
		if (inSlot.isEmpty()) {
			if (!inHand.isEmpty()) {
				container.setItem(inv, creative ? inHand.copyWithCount(1) : inHand.split(1));
				changed = true;
			}
		} else if (inHand.isEmpty()) {
			if (!player.addItem(inSlot.copy()))
				player.drop(inSlot.copy(), false);
			container.setItem(inv, ItemStack.EMPTY);
			sound = SoundEvents.ITEM_FRAME_REMOVE_ITEM;
			changed = true;
		} else if (ItemStack.isSameItemSameComponents(inSlot, inHand) && inSlot.getCount() < inSlot.getMaxStackSize()) {
			inSlot.grow(1);
			container.setItem(inv, inSlot);
			if (!creative)
				inHand.shrink(1);
			changed = true;
		} else {
			container.setItem(inv, inHand.copy());
			player.setItemInHand(hand, inSlot.copy());
			sound = SoundEvents.ITEM_FRAME_ROTATE_ITEM;
			changed = true;
		}
		if (changed) {
			blockEntity.setChanged();
			play(world, pos, player, sound);
		}
		return changed;
	}

	private static void play(LevelAccessor world, BlockPos pos, Player player, SoundEvent sound) {
		if (world instanceof Level level) {
			level.playSound(null, pos, sound, SoundSource.BLOCKS, 1.0f, 1.0f);
			if (!level.isClientSide()) {
				level.sendBlockUpdated(pos, level.getBlockState(pos), level.getBlockState(pos), 3);
				player.containerMenu.broadcastChanges();
			}
		}
	}

	private static Direction facingFrom(BlockState state) {
		if (state.hasProperty(BlockStateProperties.HORIZONTAL_FACING))
			return state.getValue(BlockStateProperties.HORIZONTAL_FACING);
		if (state.hasProperty(BlockStateProperties.FACING))
			return state.getValue(BlockStateProperties.FACING);
		if (state.hasProperty(BlockStateProperties.AXIS)) {
			return switch (state.getValue(BlockStateProperties.AXIS)) {
				case X -> Direction.EAST;
				case Z -> Direction.SOUTH;
				default -> Direction.NORTH;
			};
		}
		return Direction.NORTH;
	}

	private static Vec3 worldToLocal(Vec3 world, BlockPos pos, BlockState state, boolean geckoLibBlock) {
		Vec3 rel = world.subtract(pos.getX(), pos.getY(), pos.getZ()).subtract(0.5, 0.5, 0.5);
		Direction facing = facingFrom(state);
		rel = switch (facing) {
			case SOUTH -> new Vec3(-rel.x, rel.y, -rel.z);
			case WEST -> geckoLibBlock ? new Vec3(-rel.z, rel.y, rel.x) : new Vec3(rel.z, rel.y, -rel.x);
			case EAST -> geckoLibBlock ? new Vec3(rel.z, rel.y, -rel.x) : new Vec3(-rel.z, rel.y, rel.x);
			case UP -> new Vec3(rel.x, rel.z, -rel.y);
			case DOWN -> new Vec3(rel.x, -rel.z, rel.y);
			default -> rel;
		};
		return rel.add(0.5, 0.5, 0.5);
	}

	private static int closestSlot(Vec3 start, Vec3 end, double[][] slots) {
		int best = -1;
		double bestDist = Double.MAX_VALUE;
		for (int i = 0; i < slots.length; i++) {
			double hx = slots[i][3];
			double hy = slots[i][4];
			double hz = slots[i][5];
			AABB box = new AABB(slots[i][0] - hx, slots[i][1] - hy, slots[i][2] - hz, slots[i][0] + hx, slots[i][1] + hy, slots[i][2] + hz);
			Optional<Vec3> hit = box.clip(start, end);
			if (hit.isPresent()) {
				double dist = start.distanceToSqr(hit.get());
				if (dist < bestDist) {
					bestDist = dist;
					best = (int) slots[i][6];
				}
			}
		}
		return best;
	}

	private static final int[] INV_ver_celular_carregando_na_base = new int[]{0};

	private static int hitTest_ver_celular_carregando_na_base(BlockPos pos, BlockState state, Entity entity) {
		double reach = entity instanceof Player player ? player.blockInteractionRange() : 5.0;
		Vec3 eye = entity.getEyePosition(1.0f);
		Vec3 lookEnd = eye.add(entity.getViewVector(1.0f).scale(reach));
		Vec3 start = worldToLocal(eye, pos, state, false);
		Vec3 end = worldToLocal(lookEnd, pos, state, false);
		double[][] slots = new double[][]{{0.49000000000000005, 0.08, 0.55, 0.175, 0.175, 0.175, 0}};
		return closestSlot(start, end, slots);
	}

	private static final int[] INV_transferidor_de_energia_visual = new int[]{0};

	private static int hitTest_transferidor_de_energia_visual(BlockPos pos, BlockState state, Entity entity) {
		double reach = entity instanceof Player player ? player.blockInteractionRange() : 5.0;
		Vec3 eye = entity.getEyePosition(1.0f);
		Vec3 lookEnd = eye.add(entity.getViewVector(1.0f).scale(reach));
		Vec3 start = worldToLocal(eye, pos, state, false);
		Vec3 end = worldToLocal(lookEnd, pos, state, false);
		double[][] slots = new double[][]{{0.5, 0.35000000000000003, 0.5, 0.175, 0.175, 0.175, 0}};
		return closestSlot(start, end, slots);
	}
}