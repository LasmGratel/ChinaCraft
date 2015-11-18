package unstudio.chinacraft.recipes;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;

public class JadeBenchRepair{
	private final ItemStack tool;
	private final ItemStack item;
	private final ItemStack out;

	/**
	 * ������ʯ�䷽
	 * @param tool ����
	 * @param item ��Ʒ
	 * @param out ���
	 */
	public JadeBenchRepair(ItemStack tool,ItemStack item,ItemStack out){
		this.tool = tool;
		this.item = item;
		this.out = out;
	}
	public ItemStack getTool(){
		return tool;
	}
	public ItemStack getIn(){
		return item;
	}
	public ItemStack getOut(){
		return out;
	}
	
	private static ArrayList<JadeBenchRepair> recipes = new ArrayList<JadeBenchRepair>();

	public static void registerJadeBenchRepair(ItemStack tool,ItemStack item,ItemStack out) {
		if(tool == null&&item == null)return;
		recipes.add(new JadeBenchRepair(tool, item, out));
	}


	public static JadeBenchRepair getJadeBenchRepair(ItemStack tool,ItemStack item) {
		for (JadeBenchRepair r :recipes) {
			if(r.getTool().isItemEqual(tool)&&r.getIn().isItemEqual(item)||r == null) {
				return r;
			}
		}
		return null;
	}
	
	public static void clearJadeBenchReciper() {
		recipes.clear();
	}
}
