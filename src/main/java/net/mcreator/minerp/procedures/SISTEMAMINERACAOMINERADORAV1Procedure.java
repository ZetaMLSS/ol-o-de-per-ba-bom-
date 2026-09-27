package net.mcreator.minerp.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.minerp.network.MinerpModVariables;

import java.util.ArrayList;

public class SISTEMAMINERACAOMINERADORAV1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "energia") > 0) {
			if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "moeda")).equals("catcoin")) {
				for (Entity entityiterator : new ArrayList<>(world.players())) {
					if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "player")).equals(entityiterator.getDisplayName().getString())) {
						if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "status") == true) {
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "tempo") >= 2000 * (MinerpModVariables.MapVariables.get(world).TaxaHashCatCoin / 1000)
									* (1000 / getBlockNBTNumber(world, BlockPos.containing(x, y, z), "frequencia")) && !(MinerpModVariables.MapVariables.get(world).CatCoinGeradas >= MinerpModVariables.MapVariables.get(world).CatCoinLimite)) {
								{
									MinerpModVariables.PlayerVariables _vars = entityiterator.getData(MinerpModVariables.PLAYER_VARIABLES);
									_vars.CatCoinSaldo = entityiterator.getData(MinerpModVariables.PLAYER_VARIABLES).CatCoinSaldo + 1 * (1000 / MinerpModVariables.MapVariables.get(world).TaxaHashCatCoin);
									_vars.markSyncDirty();
								}
								MinerpModVariables.MapVariables.get(world).CatCoinGeradas = MinerpModVariables.MapVariables.get(world).CatCoinGeradas + 1 * (1000 / MinerpModVariables.MapVariables.get(world).TaxaHashCatCoin);
								MinerpModVariables.MapVariables.get(world).markSyncDirty();
								if (entityiterator.getData(MinerpModVariables.PLAYER_VARIABLES).NotificacaoCriptoMoedasMineradas == true) {
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Sua(s) mineradora(s) tranferiram Cripto moedas a sua conta."), false);
								}
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x, y, z);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null) {
										_blockEntity.getPersistentData().putDouble("tempo", 0);
										_blockEntity.getPersistentData().putDouble("energia", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "energia") - 0.04 * (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "frequencia") / 1000)));
									}
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
								break;
							} else if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "status") == true && !(getBlockNBTString(world, BlockPos.containing(x, y, z), "player")).equals("")) {
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x, y, z);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null) {
										_blockEntity.getPersistentData().putDouble("energia", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "energia") - 0.04 * (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "frequencia") / 1000)));
										_blockEntity.getPersistentData().putDouble("tempo", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "tempo") + 1));
									}
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
								break;
							}
						}
					}
				}
			}
		} else {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("status", false);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
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
}