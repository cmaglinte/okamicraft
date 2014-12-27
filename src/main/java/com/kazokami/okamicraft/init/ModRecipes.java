package com.kazokami.okamicraft.init;


import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ModRecipes
{
    public static void init()
    {
        /*
         *  Example of ShapedOreRecipe(); rather than ItemStack, use oreDictionary name entry.
         *  Useful if other mods has the same items.
         *  GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.heartOfPraxicFire), " s ", "sss", " s ", 's', "stickWood"));
         *
         *  Example of ShapelessOreRecipe()
         *  GameRegistry.addRecipe(new ShapelessOreRecipe());
         */
        GameRegistry.addRecipe(new ItemStack(ModItems.heartOfPraxicFire), " s ", "sss", " s ", 's', new ItemStack(ModItems.sunlitIngot) );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.sunlitStone), "xsx", "sxs", "xsx", 's', new ItemStack(ModItems.sunlitIngot), 'x', new ItemStack(Blocks.stone));

    }

}
