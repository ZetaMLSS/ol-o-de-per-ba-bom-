package net.mcreator.minerp.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.component.DataComponents;

import net.mcreator.minerp.init.MinerpModItems;

public class GerarCodigoAlgemaProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MinerpModItems.ALGEMA.get()
				&& itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("codigoalgema") == 0) {
			{
				final String _tagName = "codigoalgema";
				final double _tagValue = (Mth.nextInt(RandomSource.create(), 1000, 9999));
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
	}
}