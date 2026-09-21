package net.mcreator.minerp.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.minerp.world.inventory.ResultadoBancoComputadorMenu;
import net.mcreator.minerp.network.MinerpModVariables;
import net.mcreator.minerp.init.MinerpModMenus;

import java.util.ArrayList;

import io.netty.buffer.Unpooled;

public class PesquisarPessoaPcBancoProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean Encontrado = false;
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if (((entity instanceof Player _entity0 && _entity0.containerMenu instanceof MinerpModMenus.MenuAccessor _menu0) ? _menu0.getMenuState(0, "Pesquisar", "") : "").equals(entityiterator.getDisplayName().getString())) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putString("nick", (entityiterator.getDisplayName().getString()));
						_blockEntity.getPersistentData().putDouble("DinheiroBanco", entityiterator.getData(MinerpModVariables.PLAYER_VARIABLES).DinheiroBanco);
						_blockEntity.getPersistentData().putDouble("CreditoBanco", entityiterator.getData(MinerpModVariables.PLAYER_VARIABLES).CreditoBanco);
						_blockEntity.getPersistentData().putDouble("LimiteDoCredito", entityiterator.getData(MinerpModVariables.PLAYER_VARIABLES).LimiteDoCredito);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					_ent.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("ResultadoBancoComputador");
						}

						@Override
						public boolean shouldTriggerClientSideContainerClosingOnOpen() {
							return false;
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new ResultadoBancoComputadorMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
				Encontrado = true;
				break;
			}
		}
		if (Encontrado == false) {
			if (entity instanceof Player _player && _player.containerMenu instanceof MinerpModMenus.MenuAccessor _menu)
				_menu.sendMenuStateUpdate(_player, 0, "Pesquisar", "Player n\u00E3o encontrado.", true);
		}
	}
}