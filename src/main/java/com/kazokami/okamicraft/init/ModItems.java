package com.kazokami.okamicraft.init;


import com.kazokami.okamicraft.item.ItemHOPF;
import com.kazokami.okamicraft.item.ItemOC;
import com.kazokami.okamicraft.item.ItemSunlitIngot;
import com.kazokami.okamicraft.item.armor.ItemHeirsArmor;
import com.kazokami.okamicraft.item.armor.ItemSunlitArmor;
import com.kazokami.okamicraft.item.weapons.SunlitSword;
import com.kazokami.okamicraft.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
    /*Establish Materials*/
    public static ItemArmor.ArmorMaterial materialSolairium;
    public static Item.ToolMaterial toolMaterialSolairium;

    public static final ItemOC heartOfPraxicFire = new ItemHOPF();
    public static final ItemOC sunlitIngot = new ItemSunlitIngot();

    public static Item sunlitArmorHelmet;
    public static Item sunlitArmorPlate;
    public static Item sunlitArmorLegs;

    public static Item heirsHelm;
    public static Item heirsChest;
    public static Item heirsTrunks;

    public static Item sunlitSword;

    public static void init()
    {

        /*Set Materials*/
        materialSolairium = EnumHelper.addArmorMaterial("HEIRS", 0, new int[]{3, 8, 6, 3}, 20);
        toolMaterialSolairium = EnumHelper.addToolMaterial("SOLAIRIUM", 4, -1, 15.0F, 6.0F, 25);

        sunlitArmorHelmet = new ItemSunlitArmor(ItemArmor.ArmorMaterial.DIAMOND, 4, 0).setUnlocalizedName("sunlitArmorHelm");
        sunlitArmorPlate = new ItemSunlitArmor(ItemArmor.ArmorMaterial.DIAMOND, 4, 1).setUnlocalizedName("sunlitArmorPlate");
        sunlitArmorLegs = new ItemSunlitArmor(ItemArmor.ArmorMaterial.DIAMOND, 4, 2).setUnlocalizedName("sunlitArmorLegs");

        //ItemArmor.ArmorMaterial.DIAMOND, 4
        heirsHelm = new ItemHeirsArmor(0).setUnlocalizedName("heirsHelm");
        heirsChest = new ItemHeirsArmor(1).setUnlocalizedName("heirsChest");
        heirsTrunks = new ItemHeirsArmor(2).setUnlocalizedName("heirsTrunks");

        sunlitSword = new SunlitSword("sunlitSword", toolMaterialSolairium);

        GameRegistry.registerItem(heartOfPraxicFire, "heartOfPraxicFire");
        GameRegistry.registerItem(sunlitIngot, "sunlitIngot");

        GameRegistry.registerItem(sunlitArmorHelmet, "sunlitArmorHelm");
        GameRegistry.registerItem(sunlitArmorPlate, "sunlitArmorPlate");
        GameRegistry.registerItem(sunlitArmorLegs, "sunlitArmorLegs");

        GameRegistry.registerItem(heirsHelm, "heirsHelm");
        GameRegistry.registerItem(heirsChest, "heirsChest");
        GameRegistry.registerItem(heirsTrunks, "heirsTrunks");

        GameRegistry.registerItem(sunlitSword, "sunlitSword");
    }
}
