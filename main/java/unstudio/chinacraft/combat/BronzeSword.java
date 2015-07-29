package unstudio.chinacraft.combat;

import net.minecraft.item.ItemSword;
import unstudio.chinacraft.ChinaCraft;

public class BronzeSword  extends ItemSword{
	public BronzeSword() {
		super(ChinaCraft.BRONZE);
		setUnlocalizedName("bronze_sword");
		setCreativeTab(ChinaCraft.tabTool);

	}
}
