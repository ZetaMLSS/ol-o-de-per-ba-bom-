package net.mcreator.minerp.procedures;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.minerp.init.MinerpModItems;

public class VincularComCodigoAlgemaProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double slot = 0;
		slot = 0;
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 9).copy()).getItem() == MinerpModItems.CHAVE_ALGEMA_SEM_CODIGO.get()) {
			for (int _i1 = 0; _i1 < 8; _i1++) {
				if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slot).copy()).getItem() == MinerpModItems.ALGEMA.get()) {
					{
						final String _tagName = "codigoalgema";
						final double _tagValue = ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slot).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("codigoalgema"));
						CustomData.update(DataComponents.CUSTOM_DATA, (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 9).copy()), tag -> tag.putDouble(_tagName, _tagValue));
					}
					break;
				}
				slot = slot + 1;
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