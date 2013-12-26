// Copyright 2013 by Aileen Kutschik (aileen.kutschik@web.de)
package aileen.infusedearth.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemGlassBowl extends Item {

	public ItemGlassBowl(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
	}
	 public void registerIcons(IconRegister reg){
		 this.itemIcon = reg.registerIcon("infusedearth:item_glassBowl");
	 }


}
