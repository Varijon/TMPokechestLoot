package com.varijon.tinies.TMPokechestLoot;

import com.pixelmonmod.pixelmon.Pixelmon;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid="tmpokechestloot", version="1.0.0", acceptableRemoteVersions="*")
public class TMPokechestLoot
{
	public static String MODID = "modid";
	public static String VERSION = "version";
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e)
	{
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e)
	{
		TierDataManager.loadStorage();		
	}

	 @EventHandler
	 public void serverLoad(FMLServerStartingEvent event)
	 {
		 event.registerServerCommand(new TMPokechestLootCommand());
	 }
}