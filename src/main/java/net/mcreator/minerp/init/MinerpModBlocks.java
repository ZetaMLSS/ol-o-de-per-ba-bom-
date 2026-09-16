/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minerp.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.minerp.block.AsicV1Block;
import net.mcreator.minerp.MinerpMod;

public class MinerpModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(MinerpMod.MODID);
	public static final DeferredBlock<Block> ASIC_V_1;
	static {
		ASIC_V_1 = REGISTRY.register("asic_v_1", AsicV1Block::new);
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}