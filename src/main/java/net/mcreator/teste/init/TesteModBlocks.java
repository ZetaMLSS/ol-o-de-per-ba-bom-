/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.teste.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.teste.block.SafadaBlock;
import net.mcreator.teste.TesteMod;

public class TesteModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(TesteMod.MODID);
	public static final DeferredBlock<Block> SAFADA;
	static {
		SAFADA = REGISTRY.register("safada", SafadaBlock::new);
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}