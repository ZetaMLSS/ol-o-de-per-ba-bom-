package net.mcreator.minerp.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import net.mcreator.minerp.procedures.CaixaQuandoClicadoComOBotaoDireitoProcedure;

public class CaixaItem extends Item {
	public CaixaItem() {
		super(new Item.Properties().stacksTo(1));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		CaixaQuandoClicadoComOBotaoDireitoProcedure.execute(context.getPlayer());
		return InteractionResult.SUCCESS;
	}
}