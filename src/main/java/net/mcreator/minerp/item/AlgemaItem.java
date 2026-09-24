package net.mcreator.minerp.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;

import net.mcreator.minerp.procedures.GerarCodigoAlgemaProcedure;

public class AlgemaItem extends Item {
	public AlgemaItem() {
		super(new Item.Properties().stacksTo(1));
	}

	@Override
	public boolean hasCraftingRemainingItem(ItemStack stack) {
		return true;
	}

	@Override
	public ItemStack getCraftingRemainingItem(ItemStack itemstack) {
		return new ItemStack(this);
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		GerarCodigoAlgemaProcedure.execute(entity, itemstack);
	}
}