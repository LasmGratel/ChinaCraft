package unstudio.chinacraft.common;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityNote;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.oredict.OreDictionary;
import unstudio.chinacraft.event.ListenerRegister;
import unstudio.chinacraft.recipes.BuhrimillRecipe;
import unstudio.chinacraft.tileentity.*;
import unstudio.chinacraft.util.GuiHandler;
import unstudio.chinacraft.util.config.ConfigLoader;
import unstudio.chinacraft.world.gen.WorldGenCCFlower;
import unstudio.chinacraft.world.gen.WorldGenMulberryTree;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        new ConfigLoader(new Configuration(event.getSuggestedConfigurationFile()));

        ChinaCraft.bronzeHelmet = (ItemArmor) new ItemArmor(ItemArmor.ArmorMaterial.IRON, ChinaCraft.bronzeArmorTexture, 0).setUnlocalizedName("bronze_helmet").setMaxStackSize(1).setCreativeTab(ChinaCraft.tabTool);//青铜头盔
        ChinaCraft.bronzeChestplate = (ItemArmor) new ItemArmor(ItemArmor.ArmorMaterial.IRON, ChinaCraft.bronzeArmorTexture, 1).setUnlocalizedName("bronze_body").setMaxStackSize(1).setCreativeTab(ChinaCraft.tabTool);//青铜胸甲
        ChinaCraft.bronzeLeggings = (ItemArmor) new ItemArmor(ItemArmor.ArmorMaterial.IRON, ChinaCraft.bronzeArmorTexture, 2).setUnlocalizedName("bronze_legs").setMaxStackSize(1).setCreativeTab(ChinaCraft.tabTool);//青铜护腿
        ChinaCraft.bronzeBoots = (ItemArmor) new ItemArmor(ItemArmor.ArmorMaterial.IRON, ChinaCraft.bronzeArmorTexture, 3).setUnlocalizedName("bronze_helmet").setMaxStackSize(1).setCreativeTab(ChinaCraft.tabTool);//青铜靴子
    }

    public void init(FMLInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(ChinaCraft.instance, new GuiHandler());
        ListenerRegister.commonInit();
//        GameRegistry.registerBlock(ChinaCraft.lanternScaldfish,"LanternScaldfish");
//        GameRegistry.registerBlock(ChinaCraft.lanternScaldfishOpenable,"lanternScaldfishOpenable");
        GameRegistry.registerBlock(ChinaCraft.copperOre, "CopperOre");
        GameRegistry.registerWorldGenerator(ChinaCraft.copperOre, 3);
        OreDictionary.registerOre("oreCopper", ChinaCraft.copperOre);
        GameRegistry.registerBlock(ChinaCraft.bronzeBlock, "BronzeBlock");
        GameRegistry.registerBlock(ChinaCraft.tinOre, "TinOre");
        OreDictionary.registerOre("tinOre", ChinaCraft.tinOre);
        GameRegistry.registerWorldGenerator(ChinaCraft.tinOre, 3);
        GameRegistry.registerBlock(ChinaCraft.jadeOre, "JadeOre");
        OreDictionary.registerOre("oreJade", ChinaCraft.jadeOre);
        GameRegistry.registerWorldGenerator(ChinaCraft.jadeOre, 3);
        GameRegistry.registerBlock(ChinaCraft.marble, "Marble");
        GameRegistry.registerWorldGenerator(ChinaCraft.marble, 127);
        GameRegistry.registerBlock(ChinaCraft.marbleStair, "MarbleStair");
        GameRegistry.registerBlock(ChinaCraft.marbleSlab, "MarbleSlab");
        GameRegistry.registerBlock(ChinaCraft.marbleDoubleSlab, "MarbleDoubleSlab");
        GameRegistry.registerBlock(ChinaCraft.smoothMarble, "SmoothMarble");
        GameRegistry.registerBlock(ChinaCraft.pillarMarble, "PillarMarble");
        GameRegistry.registerBlock(ChinaCraft.chiseledMarble, "ChiseledMarble");
        GameRegistry.registerBlock(ChinaCraft.silverOre, "SilverOre");
        GameRegistry.registerWorldGenerator(ChinaCraft.silverOre, 3);
        OreDictionary.registerOre("oreSilver", ChinaCraft.silverOre);
        GameRegistry.registerBlock(ChinaCraft.riceGrow, "RiceGrow");
        GameRegistry.registerBlock(ChinaCraft.woodenWindow1, "WoodenWindow1");//木窗户
        GameRegistry.registerBlock(ChinaCraft.woodenWindow2, "WoodenWindow2");
        GameRegistry.registerBlock(ChinaCraft.woodenWindow3, "WoodenWindow3");
        GameRegistry.registerBlock(ChinaCraft.woodenWindow4, "WoodenWindow4");
        GameRegistry.registerBlock(ChinaCraft.woodenWindowdragon, "WoodenWindowDragon"); //龙腾木窗格
        GameRegistry.registerBlock(ChinaCraft.soyGrow, "SoyGrow");
        GameRegistry.registerBlock(ChinaCraft.blockBamboo, "BlockBamboo"); //竹子
        GameRegistry.registerBlock(ChinaCraft.bambooSlab, "BambooSlab"); //竹木板
        GameRegistry.registerBlock(ChinaCraft.azalea,"Azalea");
        GameRegistry.registerWorldGenerator(new WorldGenCCFlower(),1);
        GameRegistry.registerBlock(ChinaCraft.peony,"Peony");
        GameRegistry.registerItem(ChinaCraft.glutinousRice,"GlutinousRice");
        GameRegistry.registerBlock(ChinaCraft.blockGlutinousRice,"BlockGlutinousRice");
        GameRegistry.registerBlock(ChinaCraft.mulberryLog, "MulberryLog");
        GameRegistry.registerBlock(ChinaCraft.mulberryLeaf, "MulberryLeaf");
        GameRegistry.registerBlock(ChinaCraft.mulberrySapling, "MulberrySapling");
        GameRegistry.registerBlock(ChinaCraft.mulberryWood, "MulberryWood");
        GameRegistry.registerWorldGenerator(new WorldGenMulberryTree(true), 1);
        GameRegistry.registerBlock(ChinaCraft.bambooShoot, "BambooShoot");
        GameRegistry.registerWorldGenerator(ChinaCraft.bambooShoot, 1);

        GameRegistry.registerBlock(ChinaCraft.jadeWorkingTable, "JadeWorkingTable"); //玉石工作台
        GameRegistry.registerTileEntity(TileJadeBench.class, "tileEntityJadeWorkingTable"); //玉石工作台TileEntity

        GameRegistry.registerBlock(ChinaCraft.blockDrum,"Drum");
        GameRegistry.registerTileEntity(TileDrum.class,"tileEntityDrum");

        GameRegistry.registerBlock(ChinaCraft.buhrimill, "Buhrimill"); //石磨
        GameRegistry.registerTileEntity(TileBuhrimill.class, "tileEntityBuhrimill"); //石磨TileEntity
        GameRegistry.registerItem(ChinaCraft.itemBuhrimill, "ItemBuhrimill");

    	GameRegistry.registerBlock(ChinaCraft.lantern, "Lantern"); //灯笼
        GameRegistry.registerBlock(ChinaCraft.cooking_bench_on, "CookingBenchOn");
        GameRegistry.registerBlock(ChinaCraft.cooking_bench_off, "CookingBenchOff");
        GameRegistry.registerTileEntity(TileCookingBench.class, "tileEntityCookingBench");

    	GameRegistry.registerBlock(ChinaCraft.sericultureFrame, "SericultureFrame"); //养蚕架
    	GameRegistry.registerTileEntity(TileSericultureFrame.class, "tileEntitySericultureFrame"); //养蚕架TileEntity
    	GameRegistry.registerItem(ChinaCraft.itemSericultureFrame, "ItemSericultureFrame");

    	GameRegistry.registerBlock(ChinaCraft.potteryTable, "PotteryTable"); //陶瓷工作台
    	GameRegistry.registerTileEntity(TilePotteryTable.class, "tileEntityPotteryTable"); 
    	GameRegistry.registerItem(ChinaCraft.itemPotteryTable, "ItemPotteryTable");
    	
        GameRegistry.registerBlock(ChinaCraft.blockPotteryBase, "Pottery"); //陶瓷
        GameRegistry.registerBlock(ChinaCraft.blockBuckpot,"Buckpot"); //陶罐

        GameRegistry.registerItem(ChinaCraft.copperIngot, "CopperIngot");//铜锭
        OreDictionary.registerOre("ingotCopper", ChinaCraft.copperIngot);
        GameRegistry.registerItem(ChinaCraft.bronzeIngot, "BronzeIngot");//青铜锭
        OreDictionary.registerOre("ingotBronze", ChinaCraft.bronzeIngot);
        GameRegistry.registerItem(ChinaCraft.copperTinMixedPowder, "CopperTinMixedPowder");
        GameRegistry.registerItem(ChinaCraft.silverIngot, "SilverIngot");//银锭
        OreDictionary.registerOre("ingotSilver", ChinaCraft.silverOre);

        GameRegistry.registerItem(ChinaCraft.bronzeSword, "BronzeSword");//青铜剑

        GameRegistry.registerItem(ChinaCraft.bronzeBroadSword, "BronzeBroadSword");//青铜大刀
        GameRegistry.registerItem(ChinaCraft.bronzeBroadSwordGreen, "bronzeBroadSwordGreen");//青铜大刀
        GameRegistry.registerItem(ChinaCraft.bronzeBroadSwordGreen2, "bronzeBroadSwordGreen2");//青铜大刀
        GameRegistry.registerItem(ChinaCraft.bronzeBroadSwordPink, "bronzeBroadSwordPink");//青铜大刀
        GameRegistry.registerItem(ChinaCraft.bronzeBroadSwordPurple, "bronzeBroadSwordPurple");//青铜大刀
        GameRegistry.registerItem(ChinaCraft.jiuqu_tang, "JiuQuTang");//九曲镋刀
        GameRegistry.registerItem(ChinaCraft.mace, "Mace");
        GameRegistry.registerItem(ChinaCraft.blGiantSword, "YanLungGiantknife");//炎龙巨刀
        GameRegistry.registerItem(ChinaCraft.bronzePickaxe, "BronzePickaxe");//青铜稿
        GameRegistry.registerItem(ChinaCraft.bronzeAxe, "BronzeAxe");//青铜斧
        GameRegistry.registerItem(ChinaCraft.bronzeHoe, "BronzeHoe");//青铜锄
        GameRegistry.registerItem(ChinaCraft.bronzeShovel, "BronzeShovel");//青铜铲
        GameRegistry.registerItem(ChinaCraft.hammerStone, "StoneHammer");//石锤
        GameRegistry.registerItem(ChinaCraft.hammerIron, "IronHammer");//铁锤
        GameRegistry.registerItem(ChinaCraft.hammerBronze, "DiamondBronze");//Bronze锤
        GameRegistry.registerItem(ChinaCraft.hammerDiamond, "DiamondHammer");//钻石锤
        GameRegistry.registerItem(ChinaCraft.chinaCrown, "ChinaCrown");

        GameRegistry.registerItem(ChinaCraft.nightClothes[0], "NightClothesHead");
        GameRegistry.registerItem(ChinaCraft.nightClothes[1], "NightClothesBody");
        GameRegistry.registerItem(ChinaCraft.nightClothes[2], "NightClothesLeg");
        GameRegistry.registerItem(ChinaCraft.nightClothes[3], "NightClothesShoe");
        GameRegistry.registerItem(ChinaCraft.tinIngot, "TinIngot");//锡锭
        OreDictionary.registerOre("ingotTin", ChinaCraft.tinIngot);
        OreDictionary.registerOre("oreTin", ChinaCraft.tinOre);
        GameRegistry.registerItem(ChinaCraft.rices, "Rices");//米
        GameRegistry.registerItem(ChinaCraft.lcker, "Lckers");//水稻
        GameRegistry.registerItem(ChinaCraft.soy, "Soy"); //大豆
        GameRegistry.registerItem(ChinaCraft.soyPod, "SoyPod");//大豆荚
        GameRegistry.registerItem(ChinaCraft.bamboo, "Bamboo");//竹子
        GameRegistry.registerItem(ChinaCraft.itemMulberryLeaf, "ItemMulberryLeaf");//桑叶
        GameRegistry.registerItem(ChinaCraft.woodenBucket, "WoodenBucket");//木桶
        GameRegistry.registerBlock(ChinaCraft.blockWoodenBucket, "BlockWoodenBucket");//木桶(方块)
        //GameRegistry.addRecipe(new ItemStack(ChinaCraft.blockWoodenBucket, 1), new Object[]{"# #", " # ", "   ", '#', Item.getItemFromBlock(Blocks.wooden_slab)});
        //GameRegistry.addRecipe(new ItemStack(ChinaCraft.blockWoodenBucket, 1), new Object[]{"   ", "# #", " # ", '#', Item.getItemFromBlock(Blocks.wooden_slab)});
        GameRegistry.registerItem(ChinaCraft.woodenBucket_Water, "WoodenBucket_Water");//木桶 (水)
        GameRegistry.registerItem(ChinaCraft.silkworm, "Silkworm");//蚕
        GameRegistry.registerItem(ChinaCraft.silkwormChrysalis, "SilkwormChrysalis");
        GameRegistry.registerItem(ChinaCraft.redPacket, "RedPacket");//红包
        GameRegistry.registerItem(ChinaCraft.firecracker, "Firecracker");
        GameRegistry.registerItem(ChinaCraft.bomb, "Bomb");
        GameRegistry.registerItem(ChinaCraft.blackDogBlood, "BlackDogBlood");//黑狗血
        GameRegistry.registerItem(ChinaCraft.moonCake, "MoonCake");//月饼
        GameRegistry.registerItem(ChinaCraft.artKnife, "ItemArtKnife");//美工切割刀
        GameRegistry.registerBlock(ChinaCraft.xinjiangNutCake, "XinjiangNutCake");
        GameRegistry.registerBlock(ChinaCraft.appleCake, "BLockAppleCake");
        GameRegistry.registerItem(ChinaCraft.itemAppleCake, "AppleCake");

        //青铜套
        GameRegistry.registerItem(ChinaCraft.bronzeHelmet, "BronzeHelmet");//青铜头盔
        GameRegistry.registerItem(ChinaCraft.bronzeChestplate, "BronzeChestplate");//青铜护胸
        GameRegistry.registerItem(ChinaCraft.bronzeLeggings, "BronzeLeggings");//青铜护腿
        GameRegistry.registerItem(ChinaCraft.bronzeBoots, "BronzeBoots");//青铜鞋

        //耐火砖
        GameRegistry.registerBlock(ChinaCraft.blockFirebrickStructure, "blockFirebrickStructure");
        GameRegistry.registerTileEntity(TileFirebrickStructure.class, "tileFirebrickStructure");
        GameRegistry.registerBlock(ChinaCraft.blockPotteryKiln, "blockPotteryKiln");
        GameRegistry.registerTileEntity(TilePotteryKiln.class, "tilePotteryKiln");
        GameRegistry.registerBlock(ChinaCraft.blockFirebrick, "BlockFirebrick");//耐火砖方块
        GameRegistry.registerItem(ChinaCraft.firebrick, "Firebrick");//耐火砖物品
        GameRegistry.registerItem(ChinaCraft.claySandMixture, "ClaySandMixture");//粘土沙子混合物

        //Jade
        GameRegistry.registerItem(ChinaCraft.jadeGreenItem, "JadeGreen");
        GameRegistry.registerItem(ChinaCraft.jadeGreen2Item, "JadeGreen2");
        GameRegistry.registerItem(ChinaCraft.jadePinkItem, "JadePink");
        GameRegistry.registerItem(ChinaCraft.jadePurpleItem, "JadePurple");
        GameRegistry.registerItem(ChinaCraft.jadeKnife, "JadeKnife");//玉石切割刀

        //Drink、Food
//    	GameRegistry.registerItem(ChinaCraft.cup, "Cup");
//    	GameRegistry.registerItem(ChinaCraft.cup_Clay, "ClayCup");
//    	GameRegistry.registerItem(ChinaCraft.cupChocolate, "ChocolateDrink");
//		GameRegistry.registerItem(ChinaCraft.cupChrysanthemum, "ChrysanthemumDrink");
        GameRegistry.registerItem(ChinaCraft.cocoa, "Cocoa");
        GameRegistry.registerItem(ChinaCraft.ladyfinger, "Ladyfinger");
        GameRegistry.registerItem(ChinaCraft.flour, "Flour");
        GameRegistry.registerItem(ChinaCraft.riceFlour, "RiceFlour");
        GameRegistry.registerItem(ChinaCraft.barleyRice, "BarleyRice");

        //石磨合成
        BuhrimillRecipe.registerBuhrimillReciper(new ItemStack(ChinaCraft.barleyRice), null, new ItemStack(ChinaCraft.flour), null, 360);
        BuhrimillRecipe.registerBuhrimillReciper(new ItemStack(ChinaCraft.rices), null, new ItemStack(ChinaCraft.riceFlour), null, 360);
        BuhrimillRecipe.registerBuhrimillReciper(new ItemStack(ChinaCraft.copperOre), new ItemStack(ChinaCraft.tinOre), new ItemStack(ChinaCraft.copperTinMixedPowder), null, 720);
        //玉石工作台合成

        //spiritual_magic_figures
        GameRegistry.registerItem(ChinaCraft.spiritualMagicFigures, "SpiritualMagicFigures");
        GameRegistry.registerItem(ChinaCraft.smfFire, "SpiritualMagicFiguresFire");
        GameRegistry.registerItem(ChinaCraft.smfNightVision, "SpiritualMagicFiguresNightVision");
        GameRegistry.registerItem(ChinaCraft.smfPoison, "SpiritualMagicFiguresPoison");
        GameRegistry.registerItem(ChinaCraft.smfPower, "SpiritualMagicFiguresPower");
        GameRegistry.registerItem(ChinaCraft.smfHeal, "SpiritualMagicFiguresHeal");
        GameRegistry.registerItem(ChinaCraft.smfProtect, "SpiritualMagicFiguresProtect");
        GameRegistry.registerItem(ChinaCraft.smfSuper, "SpiritualMagicFiguresSuper");

        GameRegistry.registerBlock(ChinaCraft.redCarpet, "red_carpet");
        GameRegistry.registerBlock(ChinaCraft.silkCarpet, "silk_carpet");
        GameRegistry.registerBlock(ChinaCraft.slik_right, "slik_right");
        GameRegistry.registerBlock(ChinaCraft.slik_left, "slik_left");
        GameRegistry.registerBlock(ChinaCraft.silk_right_down, "silk_right_down");
        GameRegistry.registerBlock(ChinaCraft.silk_right_up, "silk_right_up");
        GameRegistry.registerBlock(ChinaCraft.silk_left_up, "silk_left_up");
        GameRegistry.registerBlock(ChinaCraft.silk_left_down, "silk_left_down");

        //disc
        GameRegistry.registerItem(ChinaCraft.three_stanzas,"three_stanzas_of_plum-blossoms");
        GameRegistry.registerItem(ChinaCraft.mountain_stream,"mountain_stream");
        GameRegistry.registerItem(ChinaCraft.the_march_of_the_volunteers,"the_march_of_the_volunteers");
        
        GameRegistry.registerItem(ChinaCraft.itemSilk, "silk");

        GameRegistry.registerItem(ChinaCraft.debug, "Debug");

        Recipes.init();
    }

    public void postInit(FMLPostInitializationEvent event) {

    }
}