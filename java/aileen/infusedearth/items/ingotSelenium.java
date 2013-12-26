// Copyright 2013 by Aileen Kutschik (aileen.kutschik@web.de)
package aileen.infusedearth.items;

import aileen.infusedearth.infusedearth;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ingotSelenium extends Item {

	public ingotSelenium(int id) {
		super(id);
		setCreativeTab(infusedearth.ctab_items);
		setMaxStackSize(64);
		setUnlocalizedName("seleniumIngot");
	}
	 public void registerIcons(IconRegister reg){
		 this.itemIcon = reg.registerIcon("infusedearth:ingot_selenium");
	 }

}
