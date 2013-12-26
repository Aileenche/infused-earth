// Copyright 2013 by Aileen Kutschik (aileen.kutschik@web.de)
package aileen.infusedearth.items;

import aileen.infusedearth.infusedearth;
import aileen.infusedearth.omod.EnumToolMaterialCORE;
import aileen.infusedearth.omod.ItemPickAxeCORE;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class pickaxeSelenium extends ItemPickAxeCORE {

	public pickaxeSelenium(int id, EnumToolMaterialCORE mat) {
		super(id, mat);
		this.setCreativeTab(infusedearth.ctab_items);
		setUnlocalizedName("seleniumPickaxe");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.itemIcon = reg.registerIcon("infusedearth:selenium_pickaxe");
	}
}
