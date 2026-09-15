/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minerp.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.minerp.block.SAFADONABlock;
import net.mcreator.minerp.block.PandomicaBlock;
import net.mcreator.minerp.MinerpMod;

public class MinerpModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(MinerpMod.MODID);
	public static final DeferredBlock<Block> SAFADONA;
	public static final DeferredBlock<Block> PANDOMICA;
	static {
		SAFADONA = REGISTRY.register("safadona", SAFADONABlock::new);
		PANDOMICA = REGISTRY.register("pandomica", PandomicaBlock::new);
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}