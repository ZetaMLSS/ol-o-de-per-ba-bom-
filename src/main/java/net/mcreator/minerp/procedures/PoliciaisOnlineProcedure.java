package net.mcreator.minerp.procedures;

public class PoliciaisOnlineProcedure {
	public static String execute() {
		return "" + Integer.toString((int) (net.neoforged.neoforge.server.ServerLifecycleHooks.getCurrentServer() != null
				? net.neoforged.neoforge.server.ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayers().stream().filter(player -> player.getTeam() != null && player.getTeam().getName().equals("policia")).count()
				: 0));
	}
}