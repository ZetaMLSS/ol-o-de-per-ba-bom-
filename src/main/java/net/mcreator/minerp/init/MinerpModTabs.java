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
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MINERP_MONEY = REGISTRY.register("minerp_money",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.minerp.minerp_money")).icon(() -> new ItemStack(MinerpModItems.VD_1.get())).displayItems((parameters, tabData) -> {
				tabData.accept(MinerpModItems.VD_050.get());
				tabData.accept(MinerpModItems.VD_1.get());
				tabData.accept(MinerpModItems.VD_5.get());
				tabData.accept(MinerpModItems.VD_10.get());
				tabData.accept(MinerpModItems.VD_20.get());
				tabData.accept(MinerpModItems.VD_50.get());
				tabData.accept(MinerpModItems.VD_100.get());
				tabData.accept(MinerpModItems.VD_200.get());
				tabData.accept(MinerpModItems.CARTEIRA.get());
			}).build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MINERP_TEC = REGISTRY.register("minerp_tec",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.minerp.minerp_tec")).icon(() -> new ItemStack(MinerpModBlocks.ASIC_V_1.get())).displayItems((parameters, tabData) -> {
				tabData.accept(MinerpModBlocks.ASIC_V_1.get().asItem());
				tabData.accept(MinerpModItems.CELULAR.get());
				tabData.accept(MinerpModBlocks.ATM_SUP.get().asItem());
				tabData.accept(MinerpModBlocks.AT_MINF.get().asItem());
				tabData.accept(MinerpModBlocks.COMPUTADOR.get().asItem());
				tabData.accept(MinerpModBlocks.MONITOR.get().asItem());
				tabData.accept(MinerpModItems.CAIXA.get());
			}).withTabsBefore(MINERP_MONEY.getId()).build());
}