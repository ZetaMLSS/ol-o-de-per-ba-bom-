package net.mcreator.minerp.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.minerp.network.MinerpModVariables;

public class PoliciaisOnlineProcedure {
	public static void execute(LevelAccessor world) {
		MinerpModVariables.MapVariables.get(world).ContadorPoliciais = 0;
		MinerpModVariables.MapVariables.get(world).markSyncDirty();
	}
}