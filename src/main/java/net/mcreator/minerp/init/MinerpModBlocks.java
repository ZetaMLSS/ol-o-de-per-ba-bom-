/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minerp.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.minerp.block.ComputadorBlock;
import net.mcreator.minerp.block.AsicV1Block;
import net.mcreator.minerp.block.ATMinfBlock;
import net.mcreator.minerp.block.ATMSupBlock;
import net.mcreator.minerp.MinerpMod;

public class MinerpModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(MinerpMod.MODID);
	public static final DeferredBlock<Block> ASIC_V_1;
	public static final DeferredBlock<Block> ATM_SUP;
	public static final DeferredBlock<Block> AT_MINF;
	public static final DeferredBlock<Block> COMPUTADOR;
	static {
		ASIC_V_1 = REGISTRY.register("asic_v_1", AsicV1Block::new);
		ATM_SUP = REGISTRY.register("atm_sup", ATMSupBlock::new);
		AT_MINF = REGISTRY.register("at_minf", ATMinfBlock::new);
		COMPUTADOR = REGISTRY.register("computador", ComputadorBlock::new);
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}