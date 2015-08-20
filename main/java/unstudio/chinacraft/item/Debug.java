package unstudio.chinacraft.item;

import java.util.Iterator;
import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import unstudio.chinacraft.ChinaCraft;
import unstudio.chinacraft.tileentity.TileBuhrimill;
import unstudio.chinacraft.tileentity.TileSericultureFrame;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class Debug extends Item{

	public Debug() {
		setCreativeTab(ChinaCraft.tabCore);
		setUnlocalizedName("debug");
		setMaxStackSize(1);
	}
	
    public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
    	if(world.isRemote) return false;
    	TileEntity tile = world.getTileEntity(x, y, z);
    	if(tile instanceof TileBuhrimill) {
    		
    	}else if(tile instanceof TileSericultureFrame) {
    		player.addChatMessage(new ChatComponentText("调试信息:"));
    		player.addChatMessage(new ChatComponentText("死亡率:"+((TileSericultureFrame)tile).mortality));
    		player.addChatMessage(new ChatComponentText("进度:"+((TileSericultureFrame)tile).schedule));
    	}
		return true;
    }
}
