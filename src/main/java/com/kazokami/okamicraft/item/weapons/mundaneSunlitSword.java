package com.kazokami.okamicraft.item.weapons;

import com.kazokami.okamicraft.creativetab.CreativeTabOC;
import com.kazokami.okamicraft.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.IIcon;

/**
 * Created by Cyrus on 9/4/2015.
 */
public class mundaneSunlitSword extends ItemSword
{

    public mundaneSunlitSword(String unlocalizedName, ToolMaterial material)
    {
        super(material);
        setCreativeTab(CreativeTabOC.OC_TAB);
        this.setUnlocalizedName(unlocalizedName);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister ir)
    {
        this.itemIcon = ir.registerIcon(Reference.MOD_ID.toLowerCase() + ":mundaneSunlitSword");
    }

}
