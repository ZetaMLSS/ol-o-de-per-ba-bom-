package net.mcreator.minerp.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.minerp.init.MinerpModItems;
import net.mcreator.minerp.init.MinerpModBlocks;

public class PegarEnergiaTransferidorEPassarPraCimaProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		ItemStack Itemdentro = ItemStack.EMPTY;
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == MinerpModItems.BATERIA.get()) {
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("bateria") >= 0) {
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == MinerpModBlocks.CARREGADOR_CELULAR.get()) {
					Itemdentro = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).copy();
					{
						final String _tagName = "usado";
						final boolean _tagValue = true;
						CustomData.update(DataComponents.CUSTOM_DATA, Itemdentro, tag -> tag.putBoolean(_tagName, _tagValue));
					}
					if (getBlockNBTNumber(world, BlockPos.containing(x, y + 1, z), "energia") < 100) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y + 1, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("energia", (getBlockNBTNumber(world, BlockPos.containing(x, y + 1, z), "energia") + 2));
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						{
							final String _tagName = "bateria";
							final double _tagValue = (Itemdentro.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("bateria") - 2);
							CustomData.update(DataComponents.CUSTOM_DATA, Itemdentro, tag -> tag.putDouble(_tagName, _tagValue));
						}
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							ItemStack _setstack = Itemdentro.copy();
							_setstack.setCount(1);
							_itemHandlerModifiable.setStackInSlot(0, _setstack);
						}
					}
				}
			}
		}
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}