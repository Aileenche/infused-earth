// Copyright 2013 by Aileen Kutschik (aileen.kutschik@web.de)
package aileen.infusedearth;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class recipes {
	
	public static void init(){
		initCraftingRecepies();
		initSmeltingRecipies();
	}

	private static void initSmeltingRecipies() {
		GameRegistry.addSmelting(infusedearth.seleniumOre.blockID, new ItemStack(infusedearth.seleniumIngot), 0.8F);
		GameRegistry.addSmelting(infusedearth.hempCookieBatter.itemID, new ItemStack(infusedearth.hempCookie), 0.8F);
		
		if(infusedearth.rf2leather){
			GameRegistry.addSmelting(Item.rottenFlesh.itemID, new ItemStack(Item.leather), 0.5F);
		}
	}
	
	private static void initCraftingRecepies() {

		GameRegistry.addShapelessRecipe(new ItemStack(Item.dyePowder,1,15), new ItemStack(infusedearth.bone_tiny));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.dyePowder,3,15), new ItemStack(infusedearth.bone_small));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.dyePowder,5,15), new ItemStack(infusedearth.bone_medium));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.dyePowder,8,15), new ItemStack(infusedearth.bone_large));

		
		GameRegistry.addRecipe(new ItemStack(infusedearth.seleniumTorch, 16), 
				"C  ", 
				"I  ",
				"   ",
				'C', infusedearth.seleniumstick,
				'I', Item.coal);
		
		GameRegistry.addRecipe(new ItemStack(Item.silk, 4), 
				"XXX", 
				"   ",
				"   ",
				'X', infusedearth.HempLeaves);

		GameRegistry.addRecipe(new ItemStack(Item.paper, 2), 
				"XX ", 
				"XX ",
				"   ",
				'X', infusedearth.HempLeaves);
		
		GameRegistry.addRecipe(new ItemStack(infusedearth.seleniumstick,4), 
				" X ", 
				"X  ",
				"   ",
				'X', infusedearth.seleniumIngot);
		
		
		GameRegistry.addRecipe(new ItemStack(infusedearth.glassBowl, 10), 
				" X ",
				"XXX",
				" X ",
				'X', Block.thinGlass);

		GameRegistry.addRecipe(new ItemStack(infusedearth.appleSorbet, 1),
				" Y ",
				"XXX",
				" Z ",
				'X', Item.appleRed,
				'Y', Item.snowball,
				'Z', infusedearth.glassBowl);
		

		GameRegistry.addRecipe(new ItemStack(infusedearth.seleniumPickaxe),
				"XXX",
				" I ",
				" I ",
				'X', infusedearth.seleniumIngot,
				'I', infusedearth.seleniumstick);
		
		GameRegistry.addRecipe(new ItemStack(infusedearth.seleniumAxe),
				"XX ",
				"XI ",
				" I ",
				'X', infusedearth.seleniumIngot,
				'I', infusedearth.seleniumstick);
		
		GameRegistry.addRecipe(new ItemStack(infusedearth.seleniumShovel), 
				" X ", 
				" I ",
				" I ", 
				'X', infusedearth.seleniumIngot, 
				'I', infusedearth.seleniumstick);
		
		GameRegistry.addRecipe(new ItemStack(infusedearth.seleniumSword), 
				" X ", 
				" X ",
				" I ", 
				'X', infusedearth.seleniumIngot, 
				'I', infusedearth.seleniumstick);
		
		GameRegistry.addRecipe(new ItemStack(infusedearth.seleniumArmorHelmet), 
				"XXX", 
				"X X",
				"   ", 
				'X', infusedearth.seleniumIngot);
		
		GameRegistry.addRecipe(new ItemStack(infusedearth.seleniumArmorChest), 
				"X X", 
				"XIX",
				"XXX", 
				'X', infusedearth.seleniumIngot, 
				'I', Item.diamond);
		
		GameRegistry.addRecipe(new ItemStack(infusedearth.seleniumArmorLegs), 
				"XXX", 
				"X X",
				"X X", 
				'X', infusedearth.seleniumIngot);
		
		GameRegistry.addRecipe(new ItemStack(infusedearth.seleniumArmorBoots), 
				"   ", 
				"X X",
				"X X", 
				'X', infusedearth.seleniumIngot);
		
		GameRegistry.addRecipe(new ItemStack(infusedearth.HempBlock), 
				"XXX", 
				"XXX",
				"XXX", 
				'X', infusedearth.HempLeaves);

 		
 		GameRegistry.addRecipe(new ItemStack(infusedearth.hempCookieBatter,8), 
 				"WMW", 
 			    "HHH",
 			    "WWW",
  				'W', Item.wheat,
 				'H', infusedearth.HempLeaves,
 				'M', Item.bucketMilk);
		
	}
}
