package net.mcreator.teste.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;

import net.minecraft.world.item.Item;

import net.mcreator.teste.item.BagacoItem;
import net.mcreator.teste.TesteMod;

public class TesteModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(TesteMod.MODID);
	public static final DeferredItem<Item> BAGACO;
	static {
		BAGACO = REGISTRY.register("bagaco", BagacoItem::new);
	}
	// Start of user code block custom items
	// End of user code block custom items
}