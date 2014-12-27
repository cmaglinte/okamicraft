package com.kazokami.okamicraft.item.armor;


import com.kazokami.okamicraft.client.render.ModelHeirsArmor;
import com.kazokami.okamicraft.creativetab.CreativeTabOC;
import com.kazokami.okamicraft.init.ModItems;
import com.kazokami.okamicraft.okamicraft;
import com.kazokami.okamicraft.reference.Reference;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;


public class ItemHeirsArmor extends ItemArmor implements ISpecialArmor
{
    public IIcon iconHelm;
    public IIcon iconChest;
    public IIcon iconLegs;
    public IIcon iconChestOver;
    public IIcon iconLegsOver;
    public IIcon iconBlank;

    final float speed = 0.035F;
    final float jump = 0.2F;
    final float fallBuffer = 2.0F;

    public ItemHeirsArmor(int k)//ItemArmor.ArmorMaterial enumarmormaterial, int j, int k)
    {
        super(ModItems.materialSolairium, 0, k);
        setCreativeTab(CreativeTabOC.OC_TAB);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister ir)
    {
        this.iconHelm = ir.registerIcon(Reference.MOD_ID.toLowerCase() + ":heirsHelm");
        this.iconChest = ir.registerIcon(Reference.MOD_ID.toLowerCase() + ":heirsChest");
        this.iconLegs = ir.registerIcon(Reference.MOD_ID.toLowerCase() + ":heirsTrunks");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int par1)
    {
        return this.armorType == 1 ? this.iconChest : this.armorType == 0 ? this.iconHelm : this.iconLegs;
    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        return "okamicraft:textures/items/armor/heirsArmorMod.png";
    }

    public EnumRarity getRarity(ItemStack itemstack)
    {
        return EnumRarity.epic;
    }

    public ISpecialArmor.ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot)
    {
        return new ISpecialArmor.ArmorProperties(0, getArmorMaterial().getDamageReductionAmount(slot) * 0.0425D, 2147483647);
    }

    public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot)
    {
        return getArmorMaterial().getDamageReductionAmount(slot);
    }

    public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {}

    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
        if(this.armorType == 1)
        {
            player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 2, 9, true));
            player.extinguish();
        }
        if(this.armorType == 2)
        {
            if (((player.onGround) || (player.capabilities.isFlying)) && (player.moveForward > 0.0F) && (!player.isInsideOfMaterial(Material.water)))
            {
                player.moveFlying(0.0F, 1.0F, player.capabilities.isFlying ? this.speed : this.speed * 2.0F);
            }
            if (player.isSneaking()) {
                player.stepHeight = 0.50001F;
            } else if (player.stepHeight == 0.50001F) {
                player.stepHeight = 1.0F;
            }
        }
    }
    /*
    private void setImmunity(Entity entity, boolean immune)
    {
        ReflectionHelper.setPrivateValue(Entity.class, entity, Boolean.valueOf(immune), "isImmuneToFire");
    }
    */


    ModelBiped model1 = null;
    ModelBiped model2 = null;
    ModelBiped model = null;

    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot)
    {
        int type = ((ItemArmor)itemStack.getItem()).armorType;
        if (this.model1 == null) {
            this.model1 = new ModelHeirsArmor(1.0F);
        }
        if (this.model2 == null) {
            this.model2 = new ModelHeirsArmor(0.5F);
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