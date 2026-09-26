package net.mcreator.minerp.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;

import net.mcreator.minerp.procedures.RemoverAlgemaProcedure;

public class ChaveAlgemaItem extends Item {
	public ChaveAlgemaItem() {
		super(new Item.Properties().stacksTo(1));
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		RemoverAlgemaProcedure.execute(entity, sourceentity);
		return retval;
	}
}