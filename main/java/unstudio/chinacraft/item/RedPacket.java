package unstudio.chinacraft.item;

import unstudio.chinacraft.ChinaCraft;
import unstudio.chinacraft.GuiID;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RedPacket extends Item{

	public RedPacket() {
		setCreativeTab(ChinaCraft.tabCore);
		setUnlocalizedName("redpacket");
		setMaxStackSize(1);
	}
	
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer)
    {
    	entityPlayer.openGui(ChinaCraft.instance, GuiID.GUI_RedPacket, world, entityPlayer.chunkCoordX, entityPlayer.chunkCoordY, entityPlayer.chunkCoordZ);
        return itemStack;
    }
}