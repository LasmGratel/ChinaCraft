package unstudio.chinacraft.item.combat;

import com.typesafe.config.ConfigException;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import unstudio.chinacraft.ChinaCraft;


public class ModelArmor extends ItemArmor {
    private String TextureName = "";
    private ModelBiped armorModel;
    private int textureType;

    public ModelArmor(ArmorMaterial armorMaterial, String name, String textureName, int type, int render_idx) {
        this(armorMaterial,name,textureName,0,type,render_idx);
    }

    /**
     * ModelArmor BasicClass
     * @param armorMaterial ���ײ���
     * @param name          ��������
     * @param textureName   ��������
     * @param textureType   ��������
     * @param type          ��������
     * @param render_idx    ��ȾID
     */
    public ModelArmor(ArmorMaterial armorMaterial, String name, String textureName,int textureType, int type, int render_idx) {
        super(armorMaterial, render_idx, type);
        setUnlocalizedName(name);
        TextureName = textureName;
        this.textureType=textureType;
        setMaxStackSize(1);
        setCreativeTab(ChinaCraft.tabTool);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemstack, int armorSlot) {
        if (armorModel != null) {
            armorModel.bipedHead.showModel = armorSlot == 0;
            armorModel.bipedHeadwear.showModel = false;
            armorModel.bipedBody.showModel = armorSlot == 1 || armorSlot == 2;
            armorModel.bipedRightArm.showModel = armorSlot == 1;
            armorModel.bipedLeftArm.showModel = armorSlot == 1;
            armorModel.bipedRightLeg.showModel = armorSlot == 2 || armorSlot == 3;
            armorModel.bipedLeftLeg.showModel = armorSlot == 2 || armorSlot == 3;

            armorModel.isSneak = entityLiving.isSneaking();
            armorModel.isRiding = entityLiving.isRiding();
            armorModel.isChild = entityLiving.isChild();

            armorModel.heldItemRight = 0;
            armorModel.aimedBow = false;

            EntityPlayer player = (EntityPlayer) entityLiving;

            ItemStack held_item = player.getEquipmentInSlot(0);

            if (held_item != null) {
                armorModel.heldItemRight = 1;

                if (player.getItemInUseCount() > 0) {

                    EnumAction enumaction = held_item.getItemUseAction();

                    if (enumaction == EnumAction.bow) {
                        armorModel.aimedBow = true;
                    } else if (enumaction == EnumAction.block) {
                        armorModel.heldItemRight = 3;
                    }


                }

            }


        }


        return armorModel;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon("chinacraft:" + getUnlocalizedName().substring(5));
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer) {
        if (textureType == 0) {
            return String.format("chinacraft:textures/models/armor/%s.png", TextureName);
        }
        return String.format("chinacraft:textures/models/armor/%s_layer_%d.png", TextureName, slot == 2 ? 2 : 1);
    }

    public void setArmorModel(ModelBiped armorModel) {
        this.armorModel = armorModel;
    }
}