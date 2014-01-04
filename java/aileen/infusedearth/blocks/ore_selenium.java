// Copyright 2013 by Aileen Kutschik (aileen.kutschik@web.de)
package aileen.infusedearth.blocks;

import aileen.infusedearth.infusedearth;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class ore_selenium extends Block {
	public ore_selenium(int id, Material mat) {
		super(id, mat);
		setCreativeTab(infusedearth.ctab_blocks);
		setHardness(3.4F);
		setResistance(10000.0F);
		setUnlocalizedName("ore_selenium");
	}
	 public void registerIcons(IconRegister reg){
		 this.blockIcon = reg.registerIcon("infusedearth:block_selenium");
	 }
}
