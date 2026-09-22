package net.mcreator.minerp.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.minerp.world.inventory.ATMTELA2Menu;
import net.mcreator.minerp.network.MinerpModVariables;
import net.mcreator.minerp.init.MinerpModMenus;
import net.mcreator.minerp.init.MinerpModItems;

import java.util.ArrayList;

import io.netty.buffer.Unpooled;

public class ATMLERCARTAODECREDITOProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean Validade = false;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MinerpModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MinerpModItems.CARTAO_DE_CREDITO.get()) {
			if (new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity2 && _entity2.containerMenu instanceof MinerpModMenus.MenuAccessor _menu2)
					? _menu2.getMenuState(0, "Senha", "")
					: "") == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MinerpModMenus.MenuAccessor _menu3 ? _menu3.getSlots().get(0).getItem() : ItemStack.EMPTY)
							.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("senha")) {
				for (Entity entityiterator : new ArrayList<>(world.players())) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MinerpModMenus.MenuAccessor _menu5 ? _menu5.getSlots().get(0).getItem() : ItemStack.EMPTY)
							.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("codigo") == entityiterator.getData(MinerpModVariables.PLAYER_VARIABLES).CartaoVinculado) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MinerpModMenus.MenuAccessor _menu)
							_menu.sendMenuStateUpdate(_player, 0, "Senha", "Senha correta.", true);
						if (entity instanceof ServerPlayer _ent) {
							BlockPos _bpos = BlockPos.containing(x, y, z);
							_ent.openMenu(new MenuProvider() {
								@Override
								public Component getDisplayName() {
									return Component.literal("ATMTELA2");
								}

								@Override
								public boolean shouldTriggerClientSideContainerClosingOnOpen() {
									return false;
								}

								@Override
								public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
									return new ATMTELA2Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
								}
							}, _bpos);
						}
						Validade = true;
						break;
					}
				}
				if (Validade == false) {
					if (entity instanceof Player _player && _player.containerMenu instanceof MinerpModMenus.MenuAccessor _menu)
						_menu.sendMenuStateUpdate(_player, 0, "Senha", "Cart\u00E3o invalido.", true);
				}
			} else {
				if (entity instanceof Player _player && _player.containerMenu instanceof MinerpModMenus.MenuAccessor _menu)
					_menu.sendMenuStateUpdate(_player, 0, "Senha", "Senha invalida.", true);
			}
		}
	}
}