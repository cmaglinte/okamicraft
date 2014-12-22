package com.kazokami.okamicraft.init;

import com.kazokami.okamicraft.block.BlockOC;
import com.kazokami.okamicraft.block.BlockSunlitStone;
import com.kazokami.okamicraft.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static final BlockOC sunlitStone = new BlockSunlitStone();

    public static void init()
    {
        GameRegistry.registerBlock(sunlitStone, "sunlitStone");
    }
}
