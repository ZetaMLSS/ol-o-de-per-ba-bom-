package net.mcreator.minerp.procedures;

import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.minerp.network.MinerpModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ValorDoCatCoinMudarProcedure {
	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent.Post event) {
		execute(event, event.getLevel());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (world.dayTime() > 0 && world.dayTime() < 2) {
			if (MinerpModVariables.MapVariables.get(world).CatCoinQuantidade <= 100 && MinerpModVariables.MapVariables.get(world).CatCoinQuantidade >= 0) {
				if (MinerpModVariables.MapVariables.get(world).CatCoinValor <= 5 && MinerpModVariables.MapVariables.get(world).CatCoinValor >= 0) {
					MinerpModVariables.MapVariables.get(world).CatCoinValor = MinerpModVariables.MapVariables.get(world).CatCoinValor + Mth.nextInt(RandomSource.create(), -5, 20);
					MinerpModVariables.MapVariables.get(world).markSyncDirty();
				}
				if (MinerpModVariables.MapVariables.get(world).CatCoinValor <= 10 && MinerpModVariables.MapVariables.get(world).CatCoinValor >= 6) {
					MinerpModVariables.MapVariables.get(world).CatCoinValor = MinerpModVariables.MapVariables.get(world).CatCoinValor + Mth.nextInt(RandomSource.create(), -6, 18);
					MinerpModVariables.MapVariables.get(world).markSyncDirty();
				}
				if (MinerpModVariables.MapVariables.get(world).CatCoinValor <= 20 && MinerpModVariables.MapVariables.get(world).CatCoinValor >= 11) {
					MinerpModVariables.MapVariables.get(world).CatCoinValor = MinerpModVariables.MapVariables.get(world).CatCoinValor + Mth.nextInt(RandomSource.create(), -7, 16);
					MinerpModVariables.MapVariables.get(world).markSyncDirty();
				}
				if (MinerpModVariables.MapVariables.get(world).CatCoinValor <= 40 && MinerpModVariables.MapVariables.get(world).CatCoinValor >= 21) {
					MinerpModVariables.MapVariables.get(world).CatCoinValor = MinerpModVariables.MapVariables.get(world).CatCoinValor + Mth.nextInt(RandomSource.create(), -8, 15);
					MinerpModVariables.MapVariables.get(world).markSyncDirty();
				}
				if (MinerpModVariables.MapVariables.get(world).CatCoinValor <= 60 && MinerpModVariables.MapVariables.get(world).CatCoinValor >= 41) {
					MinerpModVariables.MapVariables.get(world).CatCoinValor = MinerpModVariables.MapVariables.get(world).CatCoinValor + Mth.nextInt(RandomSource.create(), -9, 14);
					MinerpModVariables.MapVariables.get(world).markSyncDirty();
				}
				if (MinerpModVariables.MapVariables.get(world).CatCoinValor >= 61) {
					MinerpModVariables.MapVariables.get(world).CatCoinValor = MinerpModVariables.MapVariables.get(world).CatCoinValor + Mth.nextInt(RandomSource.create(), -40, 35);
					MinerpModVariables.MapVariables.get(world).markSyncDirty();
				}
				if (MinerpModVariables.MapVariables.get(world).CatCoinQuantidade <= 500 && MinerpModVariables.MapVariables.get(world).CatCoinQuantidade >= 101) {
					if (MinerpModVariables.MapVariables.get(world).CatCoinValor <= 5 && MinerpModVariables.MapVariables.get(world).CatCoinValor >= 0) {
						MinerpModVariables.MapVariables.get(world).CatCoinValor = MinerpModVariables.MapVariables.get(world).CatCoinValor + Mth.nextInt(RandomSource.create(), -5, 15);
						MinerpModVariables.MapVariables.get(world).markSyncDirty();
					}
					if (MinerpModVariables.MapVariables.get(world).CatCoinValor <= 10 && MinerpModVariables.MapVariables.get(world).CatCoinValor >= 6) {
						MinerpModVariables.MapVariables.get(world).CatCoinValor = MinerpModVariables.MapVariables.get(world).CatCoinValor + Mth.nextInt(RandomSource.create(), -7, 13);
						MinerpModVariables.MapVariables.get(world).markSyncDirty();
					}
					if (MinerpModVariables.MapVariables.get(world).CatCoinValor <= 20 && MinerpModVariables.MapVariables.get(world).CatCoinValor >= 11) {
						MinerpModVariables.MapVariables.get(world).CatCoinValor = MinerpModVariables.MapVariables.get(world).CatCoinValor + Mth.nextInt(RandomSource.create(), -8, 11);
						MinerpModVariables.MapVariables.get(world).markSyncDirty();
					}
					if (MinerpModVariables.MapVariables.get(world).CatCoinValor <= 40 && MinerpModVariables.MapVariables.get(world).CatCoinValor >= 21) {
						MinerpModVariables.MapVariables.get(world).CatCoinValor = MinerpModVariables.MapVariables.get(world).CatCoinValor + Mth.nextInt(RandomSource.create(), -10, 10);
						MinerpModVariables.MapVariables.get(world).markSyncDirty();
					}
					if (MinerpModVariables.MapVariables.get(world).CatCoinValor <= 60 && MinerpModVariables.MapVariables.get(world).CatCoinValor >= 41) {
						MinerpModVariables.MapVariables.get(world).CatCoinValor = MinerpModVariables.MapVariables.get(world).CatCoinValor + Mth.nextInt(RandomSource.create(), -10, 8);
						MinerpModVariables.MapVariables.get(world).markSyncDirty();
					}
					if (MinerpModVariables.MapVariables.get(world).CatCoinValor >= 61) {
						MinerpModVariables.MapVariables.get(world).CatCoinValor = MinerpModVariables.MapVariables.get(world).CatCoinValor + Mth.nextInt(RandomSource.create(), -40, 30);
						MinerpModVariables.MapVariables.get(world).markSyncDirty();
					}
				}
			}
			if (MinerpModVariables.MapVariables.get(world).CatCoinQuantidade >= 501) {
				if (MinerpModVariables.MapVariables.get(world).CatCoinValor <= 5 && MinerpModVariables.MapVariables.get(world).CatCoinValor >= 0) {
					MinerpModVariables.MapVariables.get(world).CatCoinValor = MinerpModVariables.MapVariables.get(world).CatCoinValor + Mth.nextInt(RandomSource.create(), -5, 12);
					MinerpModVariables.MapVariables.get(world).markSyncDirty();
				}
				if (MinerpModVariables.MapVariables.get(world).CatCoinValor <= 10 && MinerpModVariables.MapVariables.get(world).CatCoinValor >= 6) {
					MinerpModVariables.MapVariables.get(world).CatCoinValor = MinerpModVariables.MapVariables.get(world).CatCoinValor + Mth.nextInt(RandomSource.create(), -7, 10);
					MinerpModVariables.MapVariables.get(world).markSyncDirty();
				}
				if (MinerpModVariables.MapVariables.get(world).CatCoinValor <= 20 && MinerpModVariables.MapVariables.get(world).CatCoinValor >= 11) {
					MinerpModVariables.MapVariables.get(world).CatCoinValor = MinerpModVariables.MapVariables.get(world).CatCoinValor + Mth.nextInt(RandomSource.create(), -8, 8);
					MinerpModVariables.MapVariables.get(world).markSyncDirty();
				}
				if (MinerpModVariables.MapVariables.get(world).CatCoinValor <= 40 && MinerpModVariables.MapVariables.get(world).CatCoinValor >= 21) {
					MinerpModVariables.MapVariables.get(world).CatCoinValor = MinerpModVariables.MapVariables.get(world).CatCoinValor + Mth.nextInt(RandomSource.create(), -10, 6);
					MinerpModVariables.MapVariables.get(world).markSyncDirty();
				}
				if (MinerpModVariables.MapVariables.get(world).CatCoinValor <= 60 && MinerpModVariables.MapVariables.get(world).CatCoinValor >= 41) {
					MinerpModVariables.MapVariables.get(world).CatCoinValor = MinerpModVariables.MapVariables.get(world).CatCoinValor + Mth.nextInt(RandomSource.create(), -10, 5);
					MinerpModVariables.MapVariables.get(world).markSyncDirty();
				}
				if (MinerpModVariables.MapVariables.get(world).CatCoinValor >= 61) {
					MinerpModVariables.MapVariables.get(world).CatCoinValor = MinerpModVariables.MapVariables.get(world).CatCoinValor + Mth.nextInt(RandomSource.create(), -45, 25);
					MinerpModVariables.MapVariables.get(world).markSyncDirty();
				}
			}
		}
		if (MinerpModVariables.MapVariables.get(world).CatCoinValor < 0) {
			MinerpModVariables.MapVariables.get(world).CatCoinValor = 0;
			MinerpModVariables.MapVariables.get(world).markSyncDirty();
		}
		if (MinerpModVariables.MapVariables.get(world).CatCoinGeradas <= 249 && MinerpModVariables.MapVariables.get(world).CatCoinGeradas >= 100) {
			MinerpModVariables.MapVariables.get(world).TaxaHashCatCoin = 500;
			MinerpModVariables.MapVariables.get(world).markSyncDirty();
		}
		if (MinerpModVariables.MapVariables.get(world).CatCoinGeradas <= 999 && MinerpModVariables.MapVariables.get(world).CatCoinGeradas >= 250) {
			MinerpModVariables.MapVariables.get(world).TaxaHashCatCoin = 250;
			MinerpModVariables.MapVariables.get(world).markSyncDirty();
		}
		if (MinerpModVariables.MapVariables.get(world).CatCoinGeradas <= 1499 && MinerpModVariables.MapVariables.get(world).CatCoinGeradas >= 1000) {
			MinerpModVariables.MapVariables.get(world).TaxaHashCatCoin = 150;
			MinerpModVariables.MapVariables.get(world).markSyncDirty();
		}
		if (MinerpModVariables.MapVariables.get(world).CatCoinGeradas <= 1999 && MinerpModVariables.MapVariables.get(world).CatCoinGeradas >= 1500) {
			MinerpModVariables.MapVariables.get(world).TaxaHashCatCoin = 100;
			MinerpModVariables.MapVariables.get(world).markSyncDirty();
		}
		if (MinerpModVariables.MapVariables.get(world).CatCoinGeradas <= 2499 && MinerpModVariables.MapVariables.get(world).CatCoinGeradas >= 2000) {
			MinerpModVariables.MapVariables.get(world).TaxaHashCatCoin = 50;
			MinerpModVariables.MapVariables.get(world).markSyncDirty();
		}
		if (MinerpModVariables.MapVariables.get(world).CatCoinGeradas <= 19999 && MinerpModVariables.MapVariables.get(world).CatCoinGeradas >= 10000) {
			MinerpModVariables.MapVariables.get(world).TaxaHashCatCoin = 25;
			MinerpModVariables.MapVariables.get(world).markSyncDirty();
		}
		if (MinerpModVariables.MapVariables.get(world).CatCoinGeradas <= 24999 && MinerpModVariables.MapVariables.get(world).CatCoinGeradas >= 20000) {
			MinerpModVariables.MapVariables.get(world).TaxaHashCatCoin = 15;
			MinerpModVariables.MapVariables.get(world).markSyncDirty();
		}
		if (MinerpModVariables.MapVariables.get(world).CatCoinGeradas >= 25000) {
			MinerpModVariables.MapVariables.get(world).TaxaHashCatCoin = 10;
			MinerpModVariables.MapVariables.get(world).markSyncDirty();
		}
	}
}