package net.mcreator.minerp.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.minerp.init.MinerpModItems;

public class CarregadorCelularOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double Bateria = 0;
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == MinerpModItems.CELULAR.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("bateria") <= 10000) {
			Bateria = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("bateria");
			{
				final String _tagName = "bateria";
				final double _tagValue = (Bateria + 1);
				CustomData.update(DataComponents.CUSTOM_DATA, (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()), tag -> tag.putDouble(_tagName, _tagValue));
			}
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).copy();
				_setstack.setCount(1);
				_itemHandlerModifiable.setStackInSlot(0, _setstack);
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
}