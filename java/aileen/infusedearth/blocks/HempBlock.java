package aileen.infusedearth.blocks;

import aileen.infusedearth.infusedearth;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class HempBlock extends Block {

	public HempBlock(int par1) {
		super(par1, Material.grass);
		setCreativeTab(infusedearth.ctab_blocks);
		setUnlocalizedName("HempBlock");
		setStepSound(soundGrassFootstep);
		// TODO Auto-generated constructor stub
	}
	
	 public void registerIcons(IconRegister reg){
		 this.blockIcon = reg.registerIcon("infusedearth:HempBlock");
	 }
	@Override
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
       if(!par1World.isRemote){
    	   par5EntityPlayer.addPotionEffect(new PotionEffect(Potion.confusion.id, 1200));
    	   par5EntityPlayer.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 1200));
    	   par5EntityPlayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 1200));
    	   par5EntityPlayer.addPotionEffect(new PotionEffect(Potion.hunger.id, 1200));
    	   par5EntityPlayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 1200));
    	   par5EntityPlayer.addPotionEffect(new PotionEffect(Potion.nightVision.id, 1200));
    	   par5EntityPlayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1200));
    	   par5EntityPlayer.addPotionEffect(new PotionEffect(Potion.resistance.id, 1200));
    	   par5EntityPlayer.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 1200));
       }
       return true;
    }

}
