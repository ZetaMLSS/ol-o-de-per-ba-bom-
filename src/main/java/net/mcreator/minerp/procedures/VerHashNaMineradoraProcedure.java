package net.mcreator.minerp.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.minerp.network.MinerpModVariables;

public class VerHashNaMineradoraProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "moeda")).equals("catcoin")) {
			return new java.text.DecimalFormat("##").format(getBlockNBTNumber(world, BlockPos.containing(x, y, z), "frequencia")) + "mhz/" + new java.text.DecimalFormat("##").format(MinerpModVariables.MapVariables.get(world).TaxaHashCatCoin)
					+ " Hash";
		} else if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "moeda")).equals("batcoin")) {
			return new java.text.DecimalFormat("##").format(getBlockNBTNumber(world, BlockPos.containing(x, y, z), "frequencia")) + "mhz/" + new java.text.DecimalFormat("##").format(MinerpModVariables.MapVariables.get(world).TaxaHashBatCoin)
					+ " Hash";
		} else if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "moeda")).equals("etcoin")) {
			return new java.text.DecimalFormat("##").format(getBlockNBTNumber(world, BlockPos.containing(x, y, z), "frequencia")) + "mhz/" + new java.text.DecimalFormat("##").format(MinerpModVariables.MapVariables.get(world).TaxaHashEtCoin)
					+ " Hash";
		} else if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "moeda")).equals("luanacoin")) {
			return new java.text.DecimalFormat("##").format(getBlockNBTNumber(world, BlockPos.containing(x, y, z), "frequencia")) + "mhz/" + new java.text.DecimalFormat("##").format(MinerpModVariables.MapVariables.get(world).TaxaHashLuanaCoin)
					+ " Hash";
		}
		return "";
	}

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getString(tag);
		return "";
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}