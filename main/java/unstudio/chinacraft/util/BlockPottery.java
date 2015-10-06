package unstudio.chinacraft.util;

import unstudio.chinacraft.block.BlockPotteryBase;
import unstudio.chinacraft.block.model.ModelPotteryBase;
import unstudio.chinacraft.item.ItemPotteryBase;
import unstudio.chinacraft.tileentity.TilePotteryBase;

public class BlockPottery {

	private String name;
	private ModelPotteryBase model;
	private BlockPotteryBase block;
	
	public BlockPottery(String name,BlockPotteryBase block,ModelPotteryBase model) {
		this.name = name;
		this.model = model;
		this.block = block;
	}
	
	public BlockPottery(String name,ModelPotteryBase model) {
		this(name,new BlockPotteryBase(),model);
	}

	public String getName() {
		return name;
	}

	public ModelPotteryBase getModel() {
		return model;
	}

	public BlockPotteryBase getBlock() {
		return block;
	}
}