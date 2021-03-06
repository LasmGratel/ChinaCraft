package unstudio.chinacraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSoup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import unstudio.chinacraft.common.ChinaCraft;

public class CupDrink extends ItemSoup {

    public CupDrink(int p_i45330_1_) {
        super(p_i45330_1_);
        this.setMaxStackSize(1);
        setCreativeTab(ChinaCraft.tabFarming);
    }

    @Override
    public ItemStack onEaten(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_) {
        super.onEaten(p_77654_1_, p_77654_2_, p_77654_3_);
        return new ItemStack(ChinaCraft.cup);
    }
}
