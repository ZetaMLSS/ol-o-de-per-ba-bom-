package net.mcreator.minerp.procedures;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

import net.mcreator.minerp.init.MinerpModMenus;

public class InformacoesContatosProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (((entity instanceof Player _entity0 && _entity0.containerMenu instanceof MinerpModMenus.MenuAccessor _menu0) ? _menu0.getMenuState(2, "slidercontatos", 0.0) : 0.0) == 1) {
			if (!((getItemStackFromItemStackSlot(1, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))).getItem() == Blocks.AIR.asItem())) {
				return ((getItemStackFromItemStackSlot(1, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("nome")) + " - ("
						+ ((getItemStackFromItemStackSlot(1, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("numero")) + ")";
			}
			return "";
		} else if (((entity instanceof Player _entity10 && _entity10.containerMenu instanceof MinerpModMenus.MenuAccessor _menu10) ? _menu10.getMenuState(2, "slidercontatos", 0.0) : 0.0) == 2) {
			if (!((getItemStackFromItemStackSlot(2, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))).getItem() == Blocks.AIR.asItem())) {
				return ((getItemStackFromItemStackSlot(2, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("nome")) + " - ("
						+ ((getItemStackFromItemStackSlot(2, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("numero")) + ")";
			}
			return "";
		} else if (((entity instanceof Player _entity20 && _entity20.containerMenu instanceof MinerpModMenus.MenuAccessor _menu20) ? _menu20.getMenuState(2, "slidercontatos", 0.0) : 0.0) == 3) {
			if (!((getItemStackFromItemStackSlot(3, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))).getItem() == Blocks.AIR.asItem())) {
				return ((getItemStackFromItemStackSlot(3, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("nome")) + " - ("
						+ ((getItemStackFromItemStackSlot(3, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("numero")) + ")";
			}
			return "";
		} else if (((entity instanceof Player _entity30 && _entity30.containerMenu instanceof MinerpModMenus.MenuAccessor _menu30) ? _menu30.getMenuState(2, "slidercontatos", 0.0) : 0.0) == 4) {
			if (!((getItemStackFromItemStackSlot(4, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))).getItem() == Blocks.AIR.asItem())) {
				return ((getItemStackFromItemStackSlot(4, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("nome")) + " - ("
						+ ((getItemStackFromItemStackSlot(4, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("numero")) + ")";
			}
			return "";
		} else if (((entity instanceof Player _entity40 && _entity40.containerMenu instanceof MinerpModMenus.MenuAccessor _menu40) ? _menu40.getMenuState(2, "slidercontatos", 0.0) : 0.0) == 5) {
			if (!((getItemStackFromItemStackSlot(5, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))).getItem() == Blocks.AIR.asItem())) {
				return ((getItemStackFromItemStackSlot(5, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("nome")) + " - ("
						+ ((getItemStackFromItemStackSlot(5, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("numero")) + ")";
			}
			return "";
		} else if (((entity instanceof Player _entity50 && _entity50.containerMenu instanceof MinerpModMenus.MenuAccessor _menu50) ? _menu50.getMenuState(2, "slidercontatos", 0.0) : 0.0) == 6) {
			if (!((getItemStackFromItemStackSlot(6, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))).getItem() == Blocks.AIR.asItem())) {
				return ((getItemStackFromItemStackSlot(6, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("nome")) + " - ("
						+ ((getItemStackFromItemStackSlot(6, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("numero")) + ")";
			}
			return "";
		} else if (((entity instanceof Player _entity60 && _entity60.containerMenu instanceof MinerpModMenus.MenuAccessor _menu60) ? _menu60.getMenuState(2, "slidercontatos", 0.0) : 0.0) == 7) {
			if (!((getItemStackFromItemStackSlot(6, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))).getItem() == Blocks.AIR.asItem())) {
				return ((getItemStackFromItemStackSlot(7, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("nome")) + " - ("
						+ ((getItemStackFromItemStackSlot(7, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("numero")) + ")";
			}
			return "";
		} else if (((entity instanceof Player _entity70 && _entity70.containerMenu instanceof MinerpModMenus.MenuAccessor _menu70) ? _menu70.getMenuState(2, "slidercontatos", 0.0) : 0.0) == 8) {
			if (!((getItemStackFromItemStackSlot(8, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))).getItem() == Blocks.AIR.asItem())) {
				return ((getItemStackFromItemStackSlot(8, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("nome")) + " - ("
						+ ((getItemStackFromItemStackSlot(8, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("numero")) + ")";
			}
			return "";
		} else if (((entity instanceof Player _entity80 && _entity80.containerMenu instanceof MinerpModMenus.MenuAccessor _menu80) ? _menu80.getMenuState(2, "slidercontatos", 0.0) : 0.0) == 9) {
			if (!((getItemStackFromItemStackSlot(9, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))).getItem() == Blocks.AIR.asItem())) {
				return ((getItemStackFromItemStackSlot(9, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("nome")) + " - ("
						+ ((getItemStackFromItemStackSlot(9, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("numero")) + ")";
			}
			return "";
		} else if (((entity instanceof Player _entity90 && _entity90.containerMenu instanceof MinerpModMenus.MenuAccessor _menu90) ? _menu90.getMenuState(2, "slidercontatos", 0.0) : 0.0) == 10) {
			if (!((getItemStackFromItemStackSlot(10, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))).getItem() == Blocks.AIR.asItem())) {
				return ((getItemStackFromItemStackSlot(10, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("nome")) + " - ("
						+ ((getItemStackFromItemStackSlot(10, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("numero")) + ")";
			}
			return "";
		}
		return "";
	}

	private static ItemStack getItemStackFromItemStackSlot(int slotID, ItemStack itemStack) {
		IItemHandler itemHandler = itemStack.getCapability(Capabilities.ItemHandler.ITEM, null);
		if (itemHandler != null)
			return itemHandler.getStackInSlot(slotID).copy();
		return ItemStack.EMPTY;
	}
}