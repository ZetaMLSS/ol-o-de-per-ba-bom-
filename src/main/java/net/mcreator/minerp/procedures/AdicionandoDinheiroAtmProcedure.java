package net.mcreator.minerp.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.minerp.init.MinerpModMenus;
import net.mcreator.minerp.init.MinerpModItems;

import java.util.ArrayList;

public class AdicionandoDinheiroAtmProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MinerpModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MinerpModItems.VD_050.get()) {
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MinerpModMenus.MenuAccessor _menu2 ? _menu2.getSlots().get(0).getItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY)
						.copyTag().getString("nick")).equals(entityiterator.getDisplayName().getString())) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("setdinheiro " + entityiterator.getDisplayName().getString() + " " + "0.5"));
					if (entity instanceof Player _player && _player.containerMenu instanceof MinerpModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(2).set(ItemStack.EMPTY);
						_player.containerMenu.broadcastChanges();
					}
					break;
				}
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MinerpModMenus.MenuAccessor _menu9 ? _menu9.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MinerpModItems.VD_1.get()) {
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MinerpModMenus.MenuAccessor _menu11 ? _menu11.getSlots().get(0).getItem() : ItemStack.EMPTY)
						.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("nick")).equals(entityiterator.getDisplayName().getString())) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("setdinheiro " + entityiterator.getDisplayName().getString() + " " + "1"));
					if (entity instanceof Player _player && _player.containerMenu instanceof MinerpModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(2).set(ItemStack.EMPTY);
						_player.containerMenu.broadcastChanges();
					}
					break;
				}
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MinerpModMenus.MenuAccessor _menu18 ? _menu18.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MinerpModItems.VD_5.get()) {
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MinerpModMenus.MenuAccessor _menu20 ? _menu20.getSlots().get(0).getItem() : ItemStack.EMPTY)
						.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("nick")).equals(entityiterator.getDisplayName().getString())) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("setdinheiro " + entityiterator.getDisplayName().getString() + " " + "5"));
					if (entity instanceof Player _player && _player.containerMenu instanceof MinerpModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(2).set(ItemStack.EMPTY);
						_player.containerMenu.broadcastChanges();
					}
					break;
				}
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MinerpModMenus.MenuAccessor _menu27 ? _menu27.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MinerpModItems.VD_10.get()) {
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MinerpModMenus.MenuAccessor _menu29 ? _menu29.getSlots().get(0).getItem() : ItemStack.EMPTY)
						.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("nick")).equals(entityiterator.getDisplayName().getString())) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("setdinheiro " + entityiterator.getDisplayName().getString() + " " + "10"));
					if (entity instanceof Player _player && _player.containerMenu instanceof MinerpModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(2).set(ItemStack.EMPTY);
						_player.containerMenu.broadcastChanges();
					}
					break;
				}
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MinerpModMenus.MenuAccessor _menu36 ? _menu36.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MinerpModItems.VD_20.get()) {
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MinerpModMenus.MenuAccessor _menu38 ? _menu38.getSlots().get(0).getItem() : ItemStack.EMPTY)
						.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("nick")).equals(entityiterator.getDisplayName().getString())) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("setdinheiro " + entityiterator.getDisplayName().getString() + " " + "20"));
					if (entity instanceof Player _player && _player.containerMenu instanceof MinerpModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(2).set(ItemStack.EMPTY);
						_player.containerMenu.broadcastChanges();
					}
					break;
				}
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MinerpModMenus.MenuAccessor _menu45 ? _menu45.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MinerpModItems.VD_50.get()) {
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MinerpModMenus.MenuAccessor _menu47 ? _menu47.getSlots().get(0).getItem() : ItemStack.EMPTY)
						.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("nick")).equals(entityiterator.getDisplayName().getString())) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("setdinheiro " + entityiterator.getDisplayName().getString() + " " + "50"));
					if (entity instanceof Player _player && _player.containerMenu instanceof MinerpModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(2).set(ItemStack.EMPTY);
						_player.containerMenu.broadcastChanges();
					}
					break;
				}
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MinerpModMenus.MenuAccessor _menu54 ? _menu54.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MinerpModItems.VD_100.get()) {
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MinerpModMenus.MenuAccessor _menu56 ? _menu56.getSlots().get(0).getItem() : ItemStack.EMPTY)
						.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("nick")).equals(entityiterator.getDisplayName().getString())) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("setdinheiro " + entityiterator.getDisplayName().getString() + " " + "100"));
					if (entity instanceof Player _player && _player.containerMenu instanceof MinerpModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(2).set(ItemStack.EMPTY);
						_player.containerMenu.broadcastChanges();
					}
					break;
				}
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MinerpModMenus.MenuAccessor _menu63 ? _menu63.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MinerpModItems.VD_200.get()) {
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MinerpModMenus.MenuAccessor _menu65 ? _menu65.getSlots().get(0).getItem() : ItemStack.EMPTY)
						.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("nick")).equals(entityiterator.getDisplayName().getString())) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("setdinheiro " + entityiterator.getDisplayName().getString() + " " + "200"));
					if (entity instanceof Player _player && _player.containerMenu instanceof MinerpModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(2).set(ItemStack.EMPTY);
						_player.containerMenu.broadcastChanges();
					}
					break;
				}
			}
		}
	}
}