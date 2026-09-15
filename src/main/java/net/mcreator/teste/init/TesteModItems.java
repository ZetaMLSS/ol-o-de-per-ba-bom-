/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.teste.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.teste.item.BagacoItem;
import net.mcreator.teste.TesteMod;

public class TesteModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(TesteMod.MODID);
	public static final DeferredItem<Item> BAGACO;
	public static final DeferredItem<Item> SAFADONA;
	static {
		BAGACO = REGISTRY.register("bagaco", BagacoItem::new);
		SAFADONA = block(TesteModBlocks.SAFADONA);
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