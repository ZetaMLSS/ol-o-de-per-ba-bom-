package net.mcreator.minerp.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.minerp.init.MinerpModMenus;

public class DeletarContatoProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (((entity instanceof Player _entity0 && _entity0.containerMenu instanceof MinerpModMenus.MenuAccessor _menu0) ? _menu0.getMenuState(2, "slidercontatos", 0.0) : 0.0) == 1) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCapability(Capabilities.ItemHandler.ITEM, null) instanceof IItemHandlerModifiable _modHandlerItemSetSlot) {
				ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
				_setstack.setCount(1);
				_modHandlerItemSetSlot.setStackInSlot(1, _setstack);
			}
		} else if (((entity instanceof Player _entity3 && _entity3.containerMenu instanceof MinerpModMenus.MenuAccessor _menu3) ? _menu3.getMenuState(2, "slidercontatos", 0.0) : 0.0) == 2) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCapability(Capabilities.ItemHandler.ITEM, null) instanceof IItemHandlerModifiable _modHandlerItemSetSlot) {
				ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
				_setstack.setCount(1);
				_modHandlerItemSetSlot.setStackInSlot(2, _setstack);
			}
		} else if (((entity instanceof Player _entity6 && _entity6.containerMenu instanceof MinerpModMenus.MenuAccessor _menu6) ? _menu6.getMenuState(2, "slidercontatos", 0.0) : 0.0) == 3) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCapability(Capabilities.ItemHandler.ITEM, null) instanceof IItemHandlerModifiable _modHandlerItemSetSlot) {
				ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
				_setstack.setCount(1);
				_modHandlerItemSetSlot.setStackInSlot(3, _setstack);
			}
		} else if (((entity instanceof Player _entity9 && _entity9.containerMenu instanceof MinerpModMenus.MenuAccessor _menu9) ? _menu9.getMenuState(2, "slidercontatos", 0.0) : 0.0) == 4) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCapability(Capabilities.ItemHandler.ITEM, null) instanceof IItemHandlerModifiable _modHandlerItemSetSlot) {
				ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
				_setstack.setCount(1);
				_modHandlerItemSetSlot.setStackInSlot(4, _setstack);
			}
		} else if (((entity instanceof Player _entity12 && _entity12.containerMenu instanceof MinerpModMenus.MenuAccessor _menu12) ? _menu12.getMenuState(2, "slidercontatos", 0.0) : 0.0) == 5) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCapability(Capabilities.ItemHandler.ITEM, null) instanceof IItemHandlerModifiable _modHandlerItemSetSlot) {
				ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
				_setstack.setCount(1);
				_modHandlerItemSetSlot.setStackInSlot(5, _setstack);
			}
		} else if (((entity instanceof Player _entity15 && _entity15.containerMenu instanceof MinerpModMenus.MenuAccessor _menu15) ? _menu15.getMenuState(2, "slidercontatos", 0.0) : 0.0) == 6) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCapability(Capabilities.ItemHandler.ITEM, null) instanceof IItemHandlerModifiable _modHandlerItemSetSlot) {
				ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
				_setstack.setCount(1);
				_modHandlerItemSetSlot.setStackInSlot(6, _setstack);
			}
		} else if (((entity instanceof Player _entity18 && _entity18.containerMenu instanceof MinerpModMenus.MenuAccessor _menu18) ? _menu18.getMenuState(2, "slidercontatos", 0.0) : 0.0) == 7) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCapability(Capabilities.ItemHandler.ITEM, null) instanceof IItemHandlerModifiable _modHandlerItemSetSlot) {
				ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
				_setstack.setCount(1);
				_modHandlerItemSetSlot.setStackInSlot(7, _setstack);
			}
		} else if (((entity instanceof Player _entity21 && _entity21.containerMenu instanceof MinerpModMenus.MenuAccessor _menu21) ? _menu21.getMenuState(2, "slidercontatos", 0.0) : 0.0) == 8) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCapability(Capabilities.ItemHandler.ITEM, null) instanceof IItemHandlerModifiable _modHandlerItemSetSlot) {
				ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
				_setstack.setCount(1);
				_modHandlerItemSetSlot.setStackInSlot(8, _setstack);
			}
		} else if (((entity instanceof Player _entity24 && _entity24.containerMenu instanceof MinerpModMenus.MenuAccessor _menu24) ? _menu24.getMenuState(2, "slidercontatos", 0.0) : 0.0) == 9) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCapability(Capabilities.ItemHandler.ITEM, null) instanceof IItemHandlerModifiable _modHandlerItemSetSlot) {
				ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
				_setstack.setCount(1);
				_modHandlerItemSetSlot.setStackInSlot(9, _setstack);
			}
		} else if (((entity instanceof Player _entity27 && _entity27.containerMenu instanceof MinerpModMenus.MenuAccessor _menu27) ? _menu27.getMenuState(2, "slidercontatos", 0.0) : 0.0) == 10) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCapability(Capabilities.ItemHandler.ITEM, null) instanceof IItemHandlerModifiable _modHandlerItemSetSlot) {
				ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
				_setstack.setCount(1);
				_modHandlerItemSetSlot.setStackInSlot(10, _setstack);
			}
		}
	}
}