package com.kazokami.okamicraft.creativetab;


import com.kazokami.okamicraft.init.ModItems;
import com.kazokami.okamicraft.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabOC
{
    public static final CreativeTabs OC_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase())
    {
        @Override
        public Item getTabIconItem()
        {
            return ModItems.heartOfPraxicFire;
        }

    };
}
