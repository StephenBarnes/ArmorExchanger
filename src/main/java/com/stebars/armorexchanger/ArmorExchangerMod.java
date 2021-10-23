package com.stebars.armorexchanger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;


@Mod(ArmorExchangerMod.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ArmorExchangerMod {
	public final static String MOD_ID = "armorexchanger";

	public ArmorExchangerMod() {
		MinecraftForge.EVENT_BUS.register(this);
	}

}