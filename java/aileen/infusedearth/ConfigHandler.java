package aileen.infusedearth;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ConfigHandler {
	public static void load(FMLPreInitializationEvent event){
	Configuration config = new Configuration(event.getSuggestedConfigurationFile());
	config.load();
	infusedearth.HempPlantId = config.get("BlockIds", "HempPlant", infusedearth.HempPlantId).getInt();
	infusedearth.seleniumOreId = config.get("BlockIds", "SeleniumOre", infusedearth.seleniumOreId).getInt();
	infusedearth.seleniumTorchId = config.get("BlockIds", "Selenium Torch", infusedearth.seleniumTorchId).getInt();
	infusedearth.seleniumstickId = config.get("ItemIds", "Selenium Stick", infusedearth.seleniumstickId).getInt();
	infusedearth.iceflowerId = config.get("BlockIds", "Ice  Flower", infusedearth.iceflowerId).getInt();
	infusedearth.netcontrollerId = config.get("NetworkBlockIds", "NetController", infusedearth.netcontrollerId).getInt();
	infusedearth.netchestId = config.get("NetworkBlockIds", "NetChest", infusedearth.netchestId).getInt();
	infusedearth.seleniumOreMaxHeight = config.get("Oreconfig", "SeleniumOreMaxHeight", infusedearth.seleniumOreMaxHeight).getInt();
	infusedearth.seleniumOreVeins = config.get("OreConfig", "SeleniumOreVeins", infusedearth.seleniumOreVeins).getInt();
	infusedearth.seleniumOreClusterSize = config.get("OreConfig","SeleniumOreClusterSize", infusedearth.seleniumOreClusterSize).getInt();
	infusedearth.seleniumIngotId = config.get("ItemIds", "SeleniumIngot", infusedearth.seleniumIngotId).getInt();
	infusedearth.seleniumPickaxeId = config.get("ItemIds", "SeleniumPickaxe", infusedearth.seleniumPickaxeId).getInt();
	infusedearth.seleniumAxeId = config.get("ItemIds", "SeleniumAxe", infusedearth.seleniumAxeId).getInt();
	infusedearth.seleniumShovelId = config.get("ItemIds", "SeleniumShovel", infusedearth.seleniumShovelId).getInt();
	infusedearth.seleniumSwordId = config.get("ItemIds", "SeleniumSword", infusedearth.seleniumSwordId).getInt();
	infusedearth.appleSorbetId = config.get("ItemIds", "AppleSorbet", infusedearth.appleSorbetId).getInt();
	infusedearth.glassBowlId = config.get("ItemIds", "GlassBowl", infusedearth.glassBowlId).getInt();
	infusedearth.bone_tinyID = config.get("ItemIds", "BoneTiny", infusedearth.bone_tinyID).getInt();
	infusedearth.bone_smallID = config.get("ItemIds", "BoneSmall", infusedearth.bone_smallID).getInt();
	infusedearth.bone_mediumID = config.get("ItemIds", "BoneMedium", infusedearth.bone_mediumID).getInt();
	infusedearth.bone_largeID = config.get("ItemIds", "BoneLarge", infusedearth.bone_largeID).getInt();
	infusedearth.HempSeedsId = config.get("ItemIds", "HempSeeds", infusedearth.HempSeedsId).getInt();
	infusedearth.hempCookieId = config.get("ItemIds", "Hemp Cookie", infusedearth.hempCookieId).getInt();
	infusedearth.selChestId = config.get("ItemIds", "Selenium Chest", infusedearth.selChestId).getInt();
	infusedearth.selHeadId = config.get("ItemIds", "Selenium Helmet", infusedearth.selHeadId).getInt();
	infusedearth.selLegsId = config.get("ItemIds", "Selenium Legs", infusedearth.selLegsId).getInt();
	infusedearth.selFeetId = config.get("ItemIds", "Selenium Boots", infusedearth.selFeetId).getInt();
	infusedearth.rf2leather = config.get("Misc Settings", "Rotten Flesh to Leather", infusedearth.rf2leather).getBoolean(infusedearth.rf2leather);
	config.save();
	System.out.print("[Infused Earth] Config Geladen");
	}
}