package com.kazokami.okamicraft.block;


public class BlockSunlitStone extends BlockOC
{
    public BlockSunlitStone()
    {
        super();
        this.setBlockName("sunlitStone");
        this.setLightLevel(7);
        this.setHardness(2.0F);
        this.setHarvestLevel("pickaxe", 0);
    }
}
