/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minerp.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;

import net.minecraft.world.item.Item;

import net.mcreator.minerp.item.VD5Item;
import net.mcreator.minerp.item.VD1Item;
import net.mcreator.minerp.item.VD050Item;
import net.mcreator.minerp.MinerpMod;

public class MinerpModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(MinerpMod.MODID);
	public static final DeferredItem<Item> VD_1;
	public static final DeferredItem<Item> VD_050;
	public static final DeferredItem<Item> VD_5;
	static {
		VD_1 = REGISTRY.register("vd_1", VD1Item::new);
		VD_050 = REGISTRY.register("vd_050", VD050Item::new);
		VD_5 = REGISTRY.register("vd_5", VD5Item::new);
	}
	// Start of user code block custom items
	// End of user code block custom items
}