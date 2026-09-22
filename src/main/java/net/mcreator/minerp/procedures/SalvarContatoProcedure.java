package net.mcreator.minerp.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.minerp.world.inventory.TelaCelularMenssagensMenu;
import net.mcreator.minerp.world.inventory.TelaAdionarContatoMenu;
import net.mcreator.minerp.network.MinerpModVariables;
import net.mcreator.minerp.init.MinerpModMenus;

import io.netty.buffer.Unpooled;

public class SalvarContatoProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (MinerpModVariables.MapVariables.get(world).numeros_registrados
				.contains(((entity instanceof Player _entity0 && _entity0.containerMenu instanceof MinerpModMenus.MenuAccessor _menu0) ? _menu0.getMenuState(0, "input_numero", "") : "") + ",")) {
			if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_nome_1")).equals("")
					&& ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_numero_1")).equals("")) {
				{
					final String _tagName = "contato_nome_1";
					final String _tagValue = ((entity instanceof Player _entity5 && _entity5.containerMenu instanceof MinerpModMenus.MenuAccessor _menu5) ? _menu5.getMenuState(0, "input_nome", "") : "");
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = "contato_numero_1";
					final String _tagValue = ((entity instanceof Player _entity8 && _entity8.containerMenu instanceof MinerpModMenus.MenuAccessor _menu8) ? _menu8.getMenuState(0, "input_numero", "") : "");
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					_ent.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("TelaCelularMenssagens");
						}

						@Override
						public boolean shouldTriggerClientSideContainerClosingOnOpen() {
							return false;
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new TelaCelularMenssagensMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			} else if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_nome_2")).equals("")
					&& ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_numero_2")).equals("")) {
				{
					final String _tagName = "contato_nome_2";
					final String _tagValue = ((entity instanceof Player _entity16 && _entity16.containerMenu instanceof MinerpModMenus.MenuAccessor _menu16) ? _menu16.getMenuState(0, "input_nome", "") : "");
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = "contato_numero_2";
					final String _tagValue = ((entity instanceof Player _entity19 && _entity19.containerMenu instanceof MinerpModMenus.MenuAccessor _menu19) ? _menu19.getMenuState(0, "input_numero", "") : "");
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					_ent.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("TelaCelularMenssagens");
						}

						@Override
						public boolean shouldTriggerClientSideContainerClosingOnOpen() {
							return false;
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new TelaCelularMenssagensMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			} else if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_nome_3")).equals("")
					&& ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_numero_3")).equals("")) {
				{
					final String _tagName = "contato_nome_3";
					final String _tagValue = ((entity instanceof Player _entity27 && _entity27.containerMenu instanceof MinerpModMenus.MenuAccessor _menu27) ? _menu27.getMenuState(0, "input_nome", "") : "");
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = "contato_numero_3";
					final String _tagValue = ((entity instanceof Player _entity30 && _entity30.containerMenu instanceof MinerpModMenus.MenuAccessor _menu30) ? _menu30.getMenuState(0, "input_numero", "") : "");
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					_ent.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("TelaCelularMenssagens");
						}

						@Override
						public boolean shouldTriggerClientSideContainerClosingOnOpen() {
							return false;
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new TelaCelularMenssagensMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			} else if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_nome_4")).equals("")
					&& ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_numero_4")).equals("")) {
				{
					final String _tagName = "contato_nome_4";
					final String _tagValue = ((entity instanceof Player _entity38 && _entity38.containerMenu instanceof MinerpModMenus.MenuAccessor _menu38) ? _menu38.getMenuState(0, "input_nome", "") : "");
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = "contato_numero_4";
					final String _tagValue = ((entity instanceof Player _entity41 && _entity41.containerMenu instanceof MinerpModMenus.MenuAccessor _menu41) ? _menu41.getMenuState(0, "input_numero", "") : "");
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					_ent.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("TelaCelularMenssagens");
						}

						@Override
						public boolean shouldTriggerClientSideContainerClosingOnOpen() {
							return false;
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new TelaCelularMenssagensMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			} else if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_nome_5")).equals("")
					&& ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_numero_5")).equals("")) {
				{
					final String _tagName = "contato_nome_5";
					final String _tagValue = ((entity instanceof Player _entity49 && _entity49.containerMenu instanceof MinerpModMenus.MenuAccessor _menu49) ? _menu49.getMenuState(0, "input_nome", "") : "");
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = "contato_numero_5";
					final String _tagValue = ((entity instanceof Player _entity52 && _entity52.containerMenu instanceof MinerpModMenus.MenuAccessor _menu52) ? _menu52.getMenuState(0, "input_numero", "") : "");
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					_ent.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("TelaCelularMenssagens");
						}

						@Override
						public boolean shouldTriggerClientSideContainerClosingOnOpen() {
							return false;
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new TelaCelularMenssagensMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			} else if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_nome_6")).equals("")
					&& ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_numero_6")).equals("")) {
				{
					final String _tagName = "contato_nome_6";
					final String _tagValue = ((entity instanceof Player _entity60 && _entity60.containerMenu instanceof MinerpModMenus.MenuAccessor _menu60) ? _menu60.getMenuState(0, "input_nome", "") : "");
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = "contato_numero_6";
					final String _tagValue = ((entity instanceof Player _entity63 && _entity63.containerMenu instanceof MinerpModMenus.MenuAccessor _menu63) ? _menu63.getMenuState(0, "input_numero", "") : "");
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					_ent.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("TelaCelularMenssagens");
						}

						@Override
						public boolean shouldTriggerClientSideContainerClosingOnOpen() {
							return false;
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new TelaCelularMenssagensMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			} else if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_nome_7")).equals("")
					&& ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_numero_7")).equals("")) {
				{
					final String _tagName = "contato_nome_7";
					final String _tagValue = ((entity instanceof Player _entity71 && _entity71.containerMenu instanceof MinerpModMenus.MenuAccessor _menu71) ? _menu71.getMenuState(0, "input_nome", "") : "");
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = "contato_numero_7";
					final String _tagValue = ((entity instanceof Player _entity74 && _entity74.containerMenu instanceof MinerpModMenus.MenuAccessor _menu74) ? _menu74.getMenuState(0, "input_numero", "") : "");
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					_ent.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("TelaCelularMenssagens");
						}

						@Override
						public boolean shouldTriggerClientSideContainerClosingOnOpen() {
							return false;
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new TelaCelularMenssagensMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			} else if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_nome_8")).equals("")
					&& ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_numero_8")).equals("")) {
				{
					final String _tagName = "contato_nome_8";
					final String _tagValue = ((entity instanceof Player _entity82 && _entity82.containerMenu instanceof MinerpModMenus.MenuAccessor _menu82) ? _menu82.getMenuState(0, "input_nome", "") : "");
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = "contato_numero_8";
					final String _tagValue = ((entity instanceof Player _entity85 && _entity85.containerMenu instanceof MinerpModMenus.MenuAccessor _menu85) ? _menu85.getMenuState(0, "input_numero", "") : "");
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					_ent.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("TelaCelularMenssagens");
						}

						@Override
						public boolean shouldTriggerClientSideContainerClosingOnOpen() {
							return false;
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new TelaCelularMenssagensMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			} else if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_nome_9")).equals("")
					&& ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_numero_9")).equals("")) {
				{
					final String _tagName = "contato_nome_9";
					final String _tagValue = ((entity instanceof Player _entity93 && _entity93.containerMenu instanceof MinerpModMenus.MenuAccessor _menu93) ? _menu93.getMenuState(0, "input_nome", "") : "");
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = "contato_numero_9";
					final String _tagValue = ((entity instanceof Player _entity96 && _entity96.containerMenu instanceof MinerpModMenus.MenuAccessor _menu96) ? _menu96.getMenuState(0, "input_numero", "") : "");
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					_ent.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("TelaCelularMenssagens");
						}

						@Override
						public boolean shouldTriggerClientSideContainerClosingOnOpen() {
							return false;
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new TelaCelularMenssagensMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			} else if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_nome_10")).equals("")
					&& ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("contato_numero_10")).equals("")) {
				{
					final String _tagName = "contato_nome_10";
					final String _tagValue = ((entity instanceof Player _entity104 && _entity104.containerMenu instanceof MinerpModMenus.MenuAccessor _menu104) ? _menu104.getMenuState(0, "input_nome", "") : "");
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = "contato_numero_10";
					final String _tagValue = ((entity instanceof Player _entity107 && _entity107.containerMenu instanceof MinerpModMenus.MenuAccessor _menu107) ? _menu107.getMenuState(0, "input_numero", "") : "");
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					_ent.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("TelaCelularMenssagens");
						}

						@Override
						public boolean shouldTriggerClientSideContainerClosingOnOpen() {
							return false;
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new TelaCelularMenssagensMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		} else {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("TelaAdionarContato");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new TelaAdionarContatoMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
			{
				MinerpModVariables.PlayerVariables _vars = entity.getData(MinerpModVariables.PLAYER_VARIABLES);
				_vars.NumeroInesistente = "Erro: Este n\u00FAmero n\u00E3o existe!";
				_vars.markSyncDirty();
			}
		}
	}
}