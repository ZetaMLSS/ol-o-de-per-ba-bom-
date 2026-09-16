/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minerp.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.minerp.MinerpMod;

public class MinerpModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MinerpMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MINERP_TEC = REGISTRY.register("minerp_tec",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.minerp.minerp_tec")).icon(() -> new ItemStack(MinerpModBlocks.ASIC_V_1.get())).displayItems((parameters, tabData) -> {
				tabData.accept(MinerpModBlocks.ASIC_V_1.get().asItem());
			}).build());
}