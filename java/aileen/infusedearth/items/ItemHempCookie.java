// Copyright 2013 by Aileen Kutschik (aileen.kutschik@web.de)
package aileen.infusedearth.items;

import aileen.infusedearth.infusedearth;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemHempCookie extends ItemFood {

	public ItemHempCookie(int id, int healAmount, float saturationModifier, boolean isWolfsFavoriteMeat) {
		super(id, healAmount, saturationModifier, isWolfsFavoriteMeat);
		setPotionEffect(10, 25, 2, 2.0F);
		setPotionEffect(9, 3, 1, 0.2F);
		setMaxStackSize(64);
	}

	public void registerIcons(IconRegister reg) {
		this.itemIcon = reg.registerIcon("infusedearth:hempCookie");
	}

	@Override
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		--par1ItemStack.stackSize;
		par3EntityPlayer.getFoodStats().addStats(this);
		par2World.playSoundAtEntity(par3EntityPlayer, "random.burp", 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);
		this.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
		return par1ItemStack;
	}
}
