package aileen.infusedearth.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class hempCookieBatter extends Item {

	public hempCookieBatter(int par1) {
		super(par1);
		setUnlocalizedName("hempCookieBatter");
		// TODO Auto-generated constructor stub
	}
	public void registerIcons(IconRegister reg) {
		this.itemIcon = reg.registerIcon("infusedearth:hempCookieBatter");
	}
}
