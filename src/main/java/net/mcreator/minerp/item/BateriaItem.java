package net.mcreator.minerp.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import net.mcreator.minerp.procedures.BateriaRightclickedOnBlockProcedure;

public class BateriaItem extends Item {
	public BateriaItem() {
		super(new Item.Properties().stacksTo(1));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		BateriaRightclickedOnBlockProcedure.execute(context.getPlayer(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}
}