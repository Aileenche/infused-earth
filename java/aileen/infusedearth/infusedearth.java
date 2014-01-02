// Copyright 2013 by Aileen Kutschik (aileen.kutschik@web.de)
package aileen.infusedearth;

import aileen.infusedearth.World.main;
import aileen.infusedearth.blocks.HempBlock;
import aileen.infusedearth.blocks.HempPlant;
import aileen.infusedearth.blocks.ore_selenium;
import aileen.infusedearth.entitys.EntityEatHempBlock;
import aileen.infusedearth.entitys.VanillaMobDrops;
import aileen.infusedearth.items.*;
import aileen.infusedearth.items.armor.armor_selenium_main;
import aileen.infusedearth.libs.DBController;
import aileen.infusedearth.network.blocks.netcable;
import aileen.infusedearth.network.blocks.netchest;
import aileen.infusedearth.network.blocks.netcontroller;
import aileen.infusedearth.network.tileentitys.Tilenetcable;
import aileen.infusedearth.network.tileentitys.Tilenetchest;
import aileen.infusedearth.network.tileentitys.Tilenetcontroller;
import aileen.infusedearth.omod.EnumToolMaterialCORE;
import aileen.infusedearth.other.FuelHandler;
import aileen.infusedearth.proxies.CoreCommonProxy;
import aileen.infusedearth.proxies.IProxy;
import aileen.infusedearth.tileentity.TileHempBlock;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = "infusedearth", name = "Infused Earth Mod", version = "0.0.4")
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = "infusedearth", packetHandler = PacketHandler.class)
public class infusedearth {

    @Instance("infusedearth")
    public static infusedearth instance;

    @SidedProxy(clientSide = "aileen.infusedearth.proxies.CoreClientProxy", serverSide = "aileen.infusedearth.proxies.CoreCommonProxy")
    public static CoreCommonProxy Proxy;

    public static CreativeTabs ctab_blocks = new CreativeTabs("ctab_blocks") {
        public ItemStack getIconItemStack() {
            return new ItemStack(infusedearth.seleniumOre, 1, 0);
        }
    };
    public static CreativeTabs ctab_items = new CreativeTabs("ctab_items") {
        public ItemStack getIconItemStack() {
            return new ItemStack(infusedearth.seleniumIngot, 1, 0);
        }
    };

    public static int HempBlockTesrId;

    // HARDBLOCKS
    public static Block seleniumOre;
    public static int seleniumOreId = 2000;
    public static int seleniumOreMaxHeight = 64;
    public static int seleniumOreVeins = 30;
    public static int seleniumOreClusterSize = 10;
    public static Block seleniumTorch;
    public static int seleniumTorchId = 3356;
    public static BlockFlower iceflower;
    public static int iceflowerId = 3357;
    public static Block HempPlant;
    public static int HempPlantId = 3360;
    public static Block HempBlock;
    public static int HempBlockId = 3361;

    //network
    public static Block netcontroller;
    public static int netcontrollerId = 3358;

    public static Block netchest;
    public static int netchestId = 3359;

    public static Block netcable;
    public static int netcableId = 3362;

    // ARMOR
    public static final String[] SELENIUM_ARMOR_ICONS = {"itemArmorSeleniumHelmet", "itemArmorSeleniumChestplate", "itemArmorSeleniumLegs", "itemArmorSeleniumBoots"};
    public static final String[] SELENIUM_ARMOR_UNLOCALIZED_NAMES = {"itemArmorSeleniumHelmet", "itemArmorSeleniumChestplate", "itemArmorSeleniumLegs", "itemArmorSeleniumBoots"};
    public static Item seleniumArmorHelmet;
    public static int selHeadId = 5764 - 256;
    public static Item seleniumArmorChest;
    public static int selChestId = 5763 - 256;
    public static Item seleniumArmorLegs;
    public static int selLegsId = 5765 - 256;
    public static Item seleniumArmorBoots;
    public static int selFeetId = 5766 - 256;


    // ITEMS

    public static Item seleniumIngot;
    public static int seleniumIngotId = 5744 - 256;

    public static Item seleniumPickaxe;
    public static int seleniumPickaxeId = 5745 - 256;

    public static Item seleniumAxe;
    public static int seleniumAxeId = 5746 - 256;

    public static Item seleniumShovel;
    public static int seleniumShovelId = 5747 - 256;

    public static Item appleSorbet;
    public static int appleSorbetId = 5748 - 256;

    public static Item hempCookie;
    public static int hempCookieId = 5767 - 256;

    public static Item glassBowl;
    public static int glassBowlId = 5749 - 256;

    public static Item bone_tiny;
    public static int bone_tinyID = 5754 - 256;

    public static Item bone_small;
    public static int bone_smallID = 5755 - 256;

    public static Item bone_medium;
    public static int bone_mediumID = 5756 - 256;

    public static Item bone_large;
    public static int bone_largeID = 5757 - 256;

    public static Item seleniumstick;
    public static int seleniumstickId = 5758 - 256;

    public static Item testitem;
    public static int testitemId = 5759 - 256;

    public static Item HempSeeds;
    public static int HempSeedsId = 5760 - 256;

    public static Item HempLeaves;
    public static int HempLeavesId = 5761 - 256;

    public static Item seleniumSword;
    public static int seleniumSwordId = 5762 - 256;

    public static Item hempCookieBatter;
    public static int hempCookieBatterId = 5768 - 256;

    public static Item clock;
    public static int clockId = 5769 - 256;

    public static ItemStack HempSeeds2Drop;
    public static boolean rf2leather = true;

    public static Icon torchFX;
    public IProxy proxy;
    public static DBController database = DBController.getInstance();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ConfigHandler.load(event);
        database.initDBConnection(event.getModConfigurationDirectory().getAbsolutePath() + "\\infusedearth.db");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        GameRegistry.registerWorldGenerator(new main());
        seleniumOre = new ore_selenium(seleniumOreId, Material.rock);

        netcontroller = new netcontroller(netcontrollerId, Material.piston);
        netchest = new netchest(netchestId, Material.piston);
        netcable = new netcable(netcableId, Material.piston);

        testitem = new testitem(testitemId);
        HempPlant = new HempPlant(this.HempPlantId);
        HempBlock = new HempBlock(this.HempBlockId);
        HempLeaves = new HempLeaves(this.HempLeavesId);
        HempSeeds = new HempSeeds(this.HempSeedsId, HempPlantId, Block.tilledField.blockID);

        seleniumIngot = new ingotSelenium(this.seleniumIngotId);
        seleniumstick = new seleniumstick(this.seleniumstickId);
        hempCookieBatter = new hempCookieBatter(this.hempCookieBatterId);

        clock = new clock(this.clockId);

        seleniumSword = new swordSelenium(this.seleniumSwordId, EnumToolMaterialCORE.SELENIUM);
        seleniumPickaxe = new pickaxeSelenium(this.seleniumPickaxeId, EnumToolMaterialCORE.SELENIUM);
        seleniumAxe = new axeSelenium(this.seleniumAxeId, EnumToolMaterialCORE.SELENIUM);
        seleniumShovel = new shovelSelenium(this.seleniumShovelId, EnumToolMaterialCORE.SELENIUM);

        appleSorbet = new ItemAppleSorbet(appleSorbetId, 8, 1.8F, false).setCreativeTab(infusedearth.ctab_items).setUnlocalizedName("appleSorbet");
        hempCookie = new ItemHempCookie(hempCookieId, 4, 10.0F, false).setCreativeTab(infusedearth.ctab_items).setUnlocalizedName("hempCookie");
        glassBowl = new ItemGlassBowl(glassBowlId).setCreativeTab(infusedearth.ctab_items).setUnlocalizedName("glassBowl");

        seleniumTorch = new SeleniumTorch(seleniumTorchId).setHardness(0.0F).setLightValue(1F).setUnlocalizedName("seleniumTorch");

        iceflower = (BlockFlower) new aileen.infusedearth.blocks.iceflower(iceflowerId).setHardness(0.0F).setUnlocalizedName("iceflower").setCreativeTab(ctab_items);

        bone_tiny = new BoneTiny(bone_tinyID);
        bone_small = new BoneSmall(bone_smallID);
        bone_medium = new BoneMedium(bone_mediumID);
        bone_large = new BoneLarge(bone_largeID);

        seleniumArmorHelmet = new armor_selenium_main(selHeadId, EnumArmorMaterial.DIAMOND, 0, 0);
        seleniumArmorChest = new armor_selenium_main(selChestId, EnumArmorMaterial.DIAMOND, 0, 1);
        seleniumArmorLegs = new armor_selenium_main(selLegsId, EnumArmorMaterial.DIAMOND, 0, 2);
        seleniumArmorBoots = new armor_selenium_main(selFeetId, EnumArmorMaterial.DIAMOND, 0, 3);


        registerBlocks();
        registerItems();
        registerTiles();
        registerItemStack();
        updateLanguages();
        oreDictionary();
        recipes.init();


        MinecraftForge.addGrassSeed(HempSeeds2Drop, 15);
        MinecraftForge.EVENT_BUS.register(new VanillaMobDrops());
        MinecraftForge.EVENT_BUS.register(new EntityEatHempBlock());
        GameRegistry.registerFuelHandler(new FuelHandler());
        Proxy.registerHandlers();
        Proxy.initRenderers();
    }

    @EventHandler
    public static void postInit(FMLPostInitializationEvent event) {

    }

    @EventHandler
    public void handleIMCMessages(FMLInterModComms.IMCEvent event){

    }

    private void registerItemStack() {
        HempSeeds2Drop = new ItemStack(HempSeeds, 1);
    }

    private void registerTiles() {
        GameRegistry.registerTileEntity(Tilenetcontroller.class, "NetControllerTileEntity");
        GameRegistry.registerTileEntity(Tilenetchest.class, "NetChestTileEntity");
        GameRegistry.registerTileEntity(Tilenetcable.class, "NetCableTileEntity");
        GameRegistry.registerTileEntity(TileHempBlock.class, "HempBlockTileEntity");
    }

    private void registerBlocks() {
        GameRegistry.registerBlock(seleniumOre, "Selenium Ore");
        GameRegistry.registerBlock(seleniumTorch, "Selenium Torch");
        GameRegistry.registerBlock(iceflower, "Iceflower");
        GameRegistry.registerBlock(netcontroller, "Network Controller");
        GameRegistry.registerBlock(netchest, "Network Chest");
        GameRegistry.registerBlock(netcable, "Network Cable");
        GameRegistry.registerBlock(HempPlant, "Hemp Plant");
        GameRegistry.registerBlock(HempBlock, "Hemp Block");
    }

    private void registerItems() {
        GameRegistry.registerItem(seleniumIngot, "Selenium Ingot");
        GameRegistry.registerItem(appleSorbet, "Apple Sorbet");
        GameRegistry.registerItem(glassBowl, "Glass Bowl");
        GameRegistry.registerItem(bone_tiny, "Tiny Bone");
        GameRegistry.registerItem(bone_small, "Small Bone");
        GameRegistry.registerItem(bone_medium, "Medium Bones");
        GameRegistry.registerItem(bone_large, "Large Bones");
        GameRegistry.registerItem(seleniumPickaxe, "Selenium Pickaxe");
        GameRegistry.registerItem(seleniumAxe, "Selenium Axe");
        GameRegistry.registerItem(seleniumstick, "Selenium Stick");
        GameRegistry.registerItem(seleniumShovel, "Selenium Shovel");
        GameRegistry.registerItem(testitem, "Test Item");
        GameRegistry.registerItem(HempSeeds, "Hemp Seeds");
        GameRegistry.registerItem(seleniumArmorHelmet, "Selenium Helmet");
        GameRegistry.registerItem(seleniumArmorChest, "Selenium Chestplate");
        GameRegistry.registerItem(seleniumArmorLegs, "Selenium Legs");
        GameRegistry.registerItem(seleniumArmorBoots, "Selenium Boots");
        GameRegistry.registerItem(HempLeaves, "Hemp Leaves");
        GameRegistry.registerItem(hempCookie, "Hemp Cookie");
        GameRegistry.registerItem(hempCookieBatter, "Hemp Cookie Batter");
        GameRegistry.registerItem(seleniumSword, "Selenium Sword (OneHitter)");
    }

    private void oreDictionary() {
        OreDictionary.registerOre("oreSelenium", new ItemStack(seleniumOre));
        OreDictionary.registerOre("ingotSelenium", new ItemStack(seleniumIngot));
        OreDictionary.registerOre("stickSelenium", new ItemStack(seleniumstick));
        OreDictionary.registerOre("hempLeaves", new ItemStack(HempLeaves));
    }

    private void updateLanguages() {
        LanguageRegistry.addName(hempCookie, "Hemp Cookie");
        LanguageRegistry.addName(HempBlock, "Hemp Block");
        LanguageRegistry.addName(hempCookieBatter, "Hemp Cookie Batter");
        LanguageRegistry.addName(seleniumArmorHelmet, "Selenium Helmet");
        LanguageRegistry.addName(seleniumArmorChest, "Selenium Chestplate");
        LanguageRegistry.addName(seleniumArmorLegs, "Selenium Legs");
        LanguageRegistry.addName(seleniumArmorBoots, "Selenium Boots");
        LanguageRegistry.addName(HempSeeds, "Hemp Seeds");
        LanguageRegistry.addName(seleniumSword, "Selenium Sword (OneHitter)");
        LanguageRegistry.addName(HempLeaves, "Hemp Leaves");
        LanguageRegistry.addName(HempPlant, "Hemp Plant");
        LanguageRegistry.addName(seleniumOre, "Selenium Ore");
        LanguageRegistry.addName(testitem, "Test Item");
        LanguageRegistry.addName(iceflower, "Iceflower");
        LanguageRegistry.addName(seleniumTorch, "Selenium Torch");
        LanguageRegistry.addName(seleniumIngot, "Selenium Ingot");
        LanguageRegistry.addName(bone_tiny, "Tiny Bone");
        LanguageRegistry.addName(bone_small, "Small Bone");
        LanguageRegistry.addName(bone_medium, "Medium Bones");
        LanguageRegistry.addName(bone_large, "Large Bones");
        LanguageRegistry.addName(appleSorbet, "Apple Sorbet");
        LanguageRegistry.addName(glassBowl, "Glass Bowl");
        LanguageRegistry.addName(seleniumPickaxe, "Selenium Pickaxe");
        LanguageRegistry.addName(seleniumAxe, "Selenium Axe");
        LanguageRegistry.addName(seleniumShovel, "Selenium Shovel");
        LanguageRegistry.addName(seleniumstick, "Selenium Stick");
        LanguageRegistry.addName(netcontroller, "Network Controller");
        LanguageRegistry.addName(netchest, "Network Chest");
        LanguageRegistry.addName(netcable, "Network Cable");
        LanguageRegistry.instance().addStringLocalization("itemGroup.ctab_blocks", "Infused Earth Blocks");
        LanguageRegistry.instance().addStringLocalization("itemGroup.ctab_items", "Infused Earth Items");
    }
}