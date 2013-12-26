// Copyright 2013 by Aileen Kutschik (aileen.kutschik@web.de)
package aileen.infusedearth.items;

import aileen.infusedearth.infusedearth;
import aileen.infusedearth.omod.EnumToolMaterialCORE;
import aileen.infusedearth.omod.ItemSpateCORE;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSpade;

public class shovelSelenium extends ItemSpateCORE {

	public shovelSelenium(int id, EnumToolMaterialCORE mat) {
		super(id, mat);
		this.setCreativeTab(infusedearth.ctab_items);
		this.setUnlocalizedName("seleniumShovel");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	 public void registerIcons(IconRegister reg){
		 this.itemIcon = reg.registerIcon("infusedearth:selenium_shovel");
	 }

}
