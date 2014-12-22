package com.kazokami.okamicraft;

import com.kazokami.okamicraft.handler.ConfigurationHandler;
import com.kazokami.okamicraft.init.ModBlocks;
import com.kazokami.okamicraft.init.ModItems;
import com.kazokami.okamicraft.proxy.IProxy;
import com.kazokami.okamicraft.reference.Reference;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID , name = Reference.MOD_NAME , version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class okamicraft
{
    @Mod.Instance(Reference.MOD_ID)
    public static okamicraft instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

        ModItems.init();
        ModBlocks.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
