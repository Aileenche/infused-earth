package aileen.infusedearth.items;

import aileen.infusedearth.infusedearth;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class BoneTiny extends Item {

	public BoneTiny(int par1) {
		super(par1);
		setMaxStackSize(64);
		setUnlocalizedName("bone_tiny");
		setCreativeTab(infusedearth.ctab_items);
	}
	 public void registerIcons(IconRegister reg){
		 this.itemIcon = reg.registerIcon("infusedearth:bone1");
	 }

}
