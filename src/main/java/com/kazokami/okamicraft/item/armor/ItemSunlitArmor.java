package com.kazokami.okamicraft.item.armor;


import com.kazokami.okamicraft.creativetab.CreativeTabOC;
import com.kazokami.okamicraft.client.render.ModelSunlitArmor;
import com.kazokami.okamicraft.okamicraft;
import com.kazokami.okamicraft.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;


public class ItemSunlitArmor extends ItemArmor
{
    public IIcon iconHelm;
    public IIcon iconChest;
    public IIcon iconLegs;
    public IIcon iconChestOver;
    public IIcon iconLegsOver;
    public IIcon iconBlank;

    public ItemSunlitArmor(ItemArmor.ArmorMaterial enumarmormaterial, int j, int k)
    {
        super(enumarmormaterial, j, k);
        setCreativeTab(CreativeTabOC.OC_TAB);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister ir)
    {
        this.iconHelm = ir.registerIcon(Reference.MOD_ID.toLowerCase() + ":sunlitArmorHelm");
        this.iconChest = ir.registerIcon(Reference.MOD_ID.toLowerCase() + ":sunlitArmorPlate");
        this.iconLegs = ir.registerIcon(Reference.MOD_ID.toLowerCase() + ":sunlitArmorLegs");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int par1)
    {
        return this.armorType == 1 ? this.iconChest : this.armorType == 0 ? this.iconHelm : this.iconLegs;
    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        return "okamicraft:textures/items/armor/sunlitArmorMod.png";
    }

    public EnumRarity getRarity(ItemStack itemstack)
    {
        return EnumRarity.uncommon;
    }

    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return par2ItemStack.isItemEqual(new ItemStack(Items.iron_ingot)) ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
    }

    ModelBiped model1 = null;
    ModelBiped model2 = null;
    ModelBiped model = null;

    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot)
    {
        int type = ((ItemArmor)itemStack.getItem()).armorType;
        if (this.model1 == null) {
            this.model1 = new ModelSunlitArmor(1.0F);
        }
        if (this.model2 == null) {
            this.model2 = new ModelSunlitArmor(0.5F);
        }
        if ((type == 1) || (type == 3)) {
            this.model = this.model1;
        } else {
            this.model = this.model2;
        }
        if (this.model != null)
        {
            this.model.bipedHead.showModel = (armorSlot == 0);
            this.model.bipedHeadwear.showModel = (armorSlot == 0);
            this.model.bipedBody.showModel = ((armorSlot == 1) || (armorSlot == 2));
            this.model.bipedRightArm.showModel = (armorSlot == 1);
            this.model.bipedLeftArm.showModel = (armorSlot == 1);
            this.model.bipedRightLeg.showModel = (armorSlot == 2);
            this.model.bipedLeftLeg.showModel = (armorSlot == 2);
            this.model.isSneak = entityLiving.isSneaking();

            this.model.isRiding = entityLiving.isRiding();
            this.model.isChild = entityLiving.isChild();
            this.model.aimedBow = false;
            this.model.heldItemRight = (entityLiving.getHeldItem() != null ? 1 : 0);
            if ((entityLiving instanceof EntityPlayer)) {
                if (((EntityPlayer)entityLiving).getItemInUseDuration() > 0)
                {
                    EnumAction enumaction = ((EntityPlayer)entityLiving).getItemInUse().getItemUseAction();
                    if (enumaction == EnumAction.block) {
                        this.model.heldItemRight = 3;
                    } else if (enumaction == EnumAction.bow) {
                        this.model.aimedBow = true;
                    }
                }
            }
        }
        return this.model;
    }
}