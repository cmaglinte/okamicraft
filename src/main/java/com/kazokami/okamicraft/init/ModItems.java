package com.kazokami.okamicraft.init;


import com.kazokami.okamicraft.item.ItemHOPF;
import com.kazokami.okamicraft.item.ItemOC;
import com.kazokami.okamicraft.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
    public static final ItemOC heartOfPraxicFire = new ItemHOPF();

    public static void init()
    {
        GameRegistry.registerItem(heartOfPraxicFire, "heartOfPraxicFire");
    }
}
