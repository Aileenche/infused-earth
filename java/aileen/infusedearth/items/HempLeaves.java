package aileen.infusedearth.items;

import aileen.infusedearth.infusedearth;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class HempLeaves extends Item {

	public HempLeaves(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
		setUnlocalizedName("HempLeaves");
		setCreativeTab(infusedearth.ctab_items);
	}
	public void registerIcons(IconRegister reg) {
		this.itemIcon = reg.registerIcon("infusedearth:item_HempLeaves");
	}
}
