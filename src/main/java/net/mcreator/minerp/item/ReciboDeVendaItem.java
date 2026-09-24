package net.mcreator.minerp.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;

import net.mcreator.minerp.procedures.ReciboDeVendaMostrarNoChatProcedure;

public class ReciboDeVendaItem extends Item {
	public ReciboDeVendaItem() {
		super(new Item.Properties().stacksTo(1));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ReciboDeVendaMostrarNoChatProcedure.execute(entity);
		return ar;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		ReciboDeVendaMostrarNoChatProcedure.execute(context.getPlayer());
		return InteractionResult.SUCCESS;
	}
}