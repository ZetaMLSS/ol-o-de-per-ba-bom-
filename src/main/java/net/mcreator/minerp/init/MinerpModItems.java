/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minerp.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.minerp.item.*;
import net.mcreator.minerp.MinerpMod;

public class MinerpModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(MinerpMod.MODID);
	public static final DeferredItem<Item> VD_1;
	public static final DeferredItem<Item> VD_050;
	public static final DeferredItem<Item> VD_5;
	public static final DeferredItem<Item> ASIC_V_1;
	public static final DeferredItem<Item> CELULAR;
	public static final DeferredItem<Item> ATM_SUP;
	public static final DeferredItem<Item> AT_MINF;
	public static final DeferredItem<Item> COMPUTADOR;
	public static final DeferredItem<Item> MONITOR;
	public static final DeferredItem<Item> VD_10;
	public static final DeferredItem<Item> VD_20;
	public static final DeferredItem<Item> VD_50;
	public static final DeferredItem<Item> VD_100;
	public static final DeferredItem<Item> VD_200;
	public static final DeferredItem<Item> CARTEIRA;
	static {
		VD_1 = REGISTRY.register("vd_1", VD1Item::new);
		VD_050 = REGISTRY.register("vd_050", VD050Item::new);
		VD_5 = REGISTRY.register("vd_5", VD5Item::new);
		ASIC_V_1 = block(MinerpModBlocks.ASIC_V_1, new Item.Properties().stacksTo(1));
		CELULAR = REGISTRY.register("celular", CelularItem::new);
		ATM_SUP = block(MinerpModBlocks.ATM_SUP, new Item.Properties().stacksTo(1));
		AT_MINF = block(MinerpModBlocks.AT_MINF, new Item.Properties().stacksTo(1));
		COMPUTADOR = block(MinerpModBlocks.COMPUTADOR);
		MONITOR = block(MinerpModBlocks.MONITOR);
		VD_10 = REGISTRY.register("vd_10", VD10Item::new);
		VD_20 = REGISTRY.register("vd_20", VD20Item::new);
		VD_50 = REGISTRY.register("vd_50", VD50Item::new);
		VD_100 = REGISTRY.register("vd_100", VD100Item::new);
		VD_200 = REGISTRY.register("vd_200", VD200Item::new);
		CARTEIRA = REGISTRY.register("carteira", CarteiraItem::new);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
	}
}