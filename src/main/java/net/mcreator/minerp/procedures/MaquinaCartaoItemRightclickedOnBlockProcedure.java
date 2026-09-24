package net.mcreator.minerp.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.minerp.world.inventory.GuiMaquinaConfigMenu;
import net.mcreator.minerp.init.MinerpModBlocks;

import io.netty.buffer.Unpooled;

public class MaquinaCartaoItemRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("pronto") == false) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("GuiMaquinaConfig");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new GuiMaquinaConfigMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("pronto") == true) {
				world.setBlock(BlockPos.containing(x, y + 1, z), MinerpModBlocks.MAQUINA_CARTAO.get().defaultBlockState(), 3);
				{
					Direction _dir = (entity.getDirection());
					BlockPos _pos = BlockPos.containing(x, y + 1, z);
					BlockState _bs = world.getBlockState(_pos);
					Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
						world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
					} else {
						_property = _bs.getBlock().getStateDefinition().getProperty("axis");
						if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
							world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
					}
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y + 1, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(10, _setstack);
				}
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack12 = new ItemStack(Blocks.AIR).copy();
					_setstack12.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack12);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			}
		}
	}
}