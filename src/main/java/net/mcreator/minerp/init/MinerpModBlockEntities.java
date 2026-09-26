/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minerp.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.minerp.block.entity.*;
import net.mcreator.minerp.MinerpMod;

@EventBusSubscriber
public class MinerpModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, MinerpMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AsicV1BlockEntity>> ASIC_V_1 = register("asic_v_1", MinerpModBlocks.ASIC_V_1, AsicV1BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ATMSupBlockEntity>> ATM_SUP = register("atm_sup", MinerpModBlocks.ATM_SUP, ATMSupBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MonitorBlockEntity>> MONITOR = register("monitor", MinerpModBlocks.MONITOR, MonitorBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CarregadorCelularBlockEntity>> CARREGADOR_CELULAR = register("carregador_celular", MinerpModBlocks.CARREGADOR_CELULAR, CarregadorCelularBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MaquinaCartaoBlockEntity>> MAQUINA_CARTAO = register("maquina_cartao", MinerpModBlocks.MAQUINA_CARTAO, MaquinaCartaoBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TransferidorDeEnergiaBlockEntity>> TRANSFERIDOR_DE_ENERGIA = register("transferidor_de_energia", MinerpModBlocks.TRANSFERIDOR_DE_ENERGIA,
			TransferidorDeEnergiaBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<Geradorv1BlockEntity>> GERADORV_1 = register("geradorv_1", MinerpModBlocks.GERADORV_1, Geradorv1BlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<T> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ASIC_V_1.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ATM_SUP.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MONITOR.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CARREGADOR_CELULAR.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MAQUINA_CARTAO.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TRANSFERIDOR_DE_ENERGIA.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, GERADORV_1.get(), SidedInvWrapper::new);
	}
}