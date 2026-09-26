package net.mcreator.minerp.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.minerp.network.MinerpModVariables;

public class SISTEMAMINERACAOMINERADORAV1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "moeda")).equals("catcoin")) {
			if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "status") == true && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "tempo") >= 2000 * (1000 / MinerpModVariables.MapVariables.get(world).TaxaHashCatCoin)
					&& (getBlockNBTString(world, BlockPos.containing(x, y, z), "player")).equals("") && !(MinerpModVariables.MapVariables.get(world).CatCoinQuantidade >= MinerpModVariables.MapVariables.get(world).CatCoinLimite)) {
				{
					MinerpModVariables.PlayerVariables _vars = entity.getData(MinerpModVariables.PLAYER_VARIABLES);
					_vars.CatCoinSaldo = 1 * (MinerpModVariables.MapVariables.get(world).TaxaHashCatCoin / 1000);
					_vars.markSyncDirty();
				}
				MinerpModVariables.MapVariables.get(world).TaxaHashCatCoin = 1 * (MinerpModVariables.MapVariables.get(world).TaxaHashCatCoin / 1000);
				MinerpModVariables.MapVariables.get(world).markSyncDirty();
			} else if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "status") == true && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "tempo") < 14000
					&& (getBlockNBTString(world, BlockPos.containing(x, y, z), "player")).equals("")) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("tempo", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "tempo") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
	}

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getString(tag);
		return "";
	}

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBoolean(tag);
		return false;
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}