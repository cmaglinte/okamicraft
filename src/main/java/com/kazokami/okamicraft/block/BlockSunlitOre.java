package com.kazokami.okamicraft.block;

public class BlockSunlitOre extends BlockOC
{
    public BlockSunlitOre()
    {
        super();
        this.setBlockName("sunlitOre");
        this.setLightLevel(1);
        this.setHardness(5.0F);
        this.setHarvestLevel("pickaxe", 3);

    }
}
