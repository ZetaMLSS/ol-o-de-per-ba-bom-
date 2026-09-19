package net.mcreator.minerp.procedures;

public class PoliciaisOnlineProcedure {
	public static String execute() {
		return "" + Integer.toString((int) world.players().stream().filter(player -> player.getTeam() != null && player.getTeam().getName().equals("policia")).count());
	}
}