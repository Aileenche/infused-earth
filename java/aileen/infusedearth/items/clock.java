package aileen.infusedearth.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.World;

public class clock extends Item {

	public int selected_time = 0;
	public clock(int par1) {
		super(par1);
		setUnlocalizedName("clock");
		setMaxStackSize(1);
		setMaxDamage(9999);
	}
	public void registerIcons(IconRegister reg) {
		this.itemIcon = reg.registerIcon("infusedearth:clock");
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		if (par3EntityPlayer.isSneaking()) {
			par2World.setWorldTime(0);
			par2World.toggleRain();
		} else {
			
			if (par3EntityPlayer.capabilities.isCreativeMode) {
				par3EntityPlayer.setGameType(EnumGameType.SURVIVAL);
			} else {
				par3EntityPlayer.setGameType(EnumGameType.CREATIVE);
			}
		}
		return par1ItemStack;
	}
}
