package net.mcreator.minerp.procedures;

import net.neoforged.neoforge.server.ServerLifecycleHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.client.Minecraft;

public class PlayersOnlineProcedure {
	public static String execute(LevelAccessor world) {
		return "" + (world.isClientSide() ? Minecraft.getInstance().getConnection().getOnlinePlayers().size() : ServerLifecycleHooks.getCurrentServer().getPlayerCount());
	}
}