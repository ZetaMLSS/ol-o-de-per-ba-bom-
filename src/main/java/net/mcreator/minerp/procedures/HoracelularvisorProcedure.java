package net.mcreator.minerp.procedures;

import net.minecraft.world.level.LevelAccessor;

public class HoracelularvisorProcedure {
	public static String execute(LevelAccessor world) {
		return new java.text.DecimalFormat("00").format(Math.round((world.dayTime() / 1000d + 6) % 24));
	}
}