// Copyright 2013 by Aileen Kutschik (aileen.kutschik@web.de)
package aileen.infusedearth.items;

import aileen.infusedearth.infusedearth;
import aileen.infusedearth.omod.EnumToolMaterialCORE;
import aileen.infusedearth.omod.ItemAxeCORE;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Util;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class axeSelenium extends ItemAxeCORE {

	public axeSelenium(int id, EnumToolMaterialCORE mat) {
		super(id, mat);
		this.efficiencyOnProperMaterial = 40.0F;
		this.setCreativeTab(infusedearth.ctab_items);
		setUnlocalizedName("seleniumAxe");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	 public void registerIcons(IconRegister reg){
		 this.itemIcon = reg.registerIcon("infusedearth:selenium_axe");
	 }

	  static int lastx = 0;
	  static int lasty = 0;
	  static int lastz = 0;
	  static double lastdistance = 0.0D;
	  protected String getHarvestType()
	  {
	    return "axe";
	  }
	  static int count = 0;
	  static int count2 = 0;
	  
	
	  public boolean onBlockStartBreak(ItemStack stack, int x, int y, int z, EntityPlayer player)
	  {
	    World world = player.worldObj;
	    int woodID = world.getBlockId(x, y, z);
	    Block wood = Block.blocksList[woodID];
	    if (wood == null)
	    {
	      return super.onBlockStartBreak(stack, x, y, z, player);
	    }
	    if ((wood.isWood(world, x, y, z)) || (wood.blockMaterial == Material.wood))
	    {
	      int height = y;
	      boolean foundTop = false;
	      do
	      {
	        height++;
	        int blockID = world.getBlockId(x, height, z);
	        if (blockID == woodID)
	          continue;
	        height--;
	        foundTop = true;
	      }
	      while (!foundTop);

	      int numLeaves = 0;
	      if (height - y < 50)
	      {
	        for (int xPos = x - 1; xPos <= x + 1; xPos++)
	        {
	          for (int yPos = height - 1; yPos <= height + 1; yPos++)
	          {
	            for (int zPos = z - 1; zPos <= z + 1; zPos++)
	            {
	              Block leaves = Block.blocksList[world.getBlockId(xPos, yPos, zPos)];
	              if ((leaves != null) && (leaves.isLeaves(world, xPos, yPos, zPos))) {
	                numLeaves++;
	              }
	            }
	          }
	        }
	      }
	      int meta = world.getBlockMetadata(x, y, z);
	      if (numLeaves > 3)
	        breakTree(world, x, y, z, stack, woodID, meta, player);
	      else {
	        destroyWood(world, x, y, z, stack, player);
	      }
	      if (!world.isRemote)
	        world.playAuxSFX(2001, x, y, z, woodID + (meta << 12));
	    }
	    else if (wood.blockMaterial == Material.wood)
	    {
	      int meta = world.getBlockMetadata(x, y, z);
	      destroyWood(world, x, y, z, stack, player);
	      if (!world.isRemote)
	        world.playAuxSFX(2001, x, y, z, woodID + (meta << 12));
	    }
	    return super.onBlockStartBreak(stack, x, y, z, player);
	  }

	  void breakTree(World world, int x, int y, int z, ItemStack stack, int bID, int meta, EntityPlayer player)
	  {
	    for (int xPos = x - 1; xPos <= x + 1; xPos++)
	    {
	      for (int yPos = y; yPos <= y + 1; yPos++)
	      {
	        for (int zPos = z - 1; zPos <= z + 1; zPos++)
	        {
	          int localblockID = world.getBlockId(xPos, yPos, zPos);
	          if (bID != localblockID)
	            continue;
	          Block block = Block.blocksList[localblockID];
	          meta = world.getBlockMetadata(xPos, yPos, zPos);
	          int hlvl = MinecraftForge.getBlockHarvestLevel(block, meta, getHarvestType());
	          boolean cancelHarvest = false;

	          if (cancelHarvest)
	          {
	            breakTree(world, xPos, yPos, zPos, stack, bID, meta, player);
	          }
	          else
	          {
	            if ((localblockID != bID) || (world.getBlockMetadata(xPos, yPos, zPos) % 4 != meta % 4))
	            {
	              continue;
	            }

	            if (!player.capabilities.isCreativeMode)
	            {
	              if (block.removeBlockByPlayer(world, player, xPos, yPos, zPos))
	              {
	                block.onBlockDestroyedByPlayer(world, xPos, yPos, zPos, meta);
	              }
	              block.harvestBlock(world, player, xPos, yPos, zPos, meta);
	              block.onBlockHarvested(world, xPos, yPos, zPos, meta, player);
	              onBlockDestroyed(stack, world, localblockID, xPos, yPos, zPos, player);
	            }
	            else
	            {
	              world.setBlockToAir(xPos, yPos, zPos);
	            }
	            breakTree(world, xPos, yPos, zPos, stack, bID, meta, player);
	          }
	        }
	      }
	    }
	  }
	  

	  void destroyWood(World world, int x, int y, int z, ItemStack stack, EntityPlayer player)
	  {
	    for (int xPos = x - 1; xPos <= x + 1; xPos++)
	    {
	      for (int yPos = y - 1; yPos <= y + 1; yPos++)
	      {
	        for (int zPos = z - 1; zPos <= z + 1; zPos++)
	        {
	          int localblockID = world.getBlockId(xPos, yPos, zPos);
	          Block block = Block.blocksList[localblockID];
	          int meta = world.getBlockMetadata(xPos, yPos, zPos);
	          int hlvl = MinecraftForge.getBlockHarvestLevel(block, meta, getHarvestType());

	          if ((block == null) || (block.blockMaterial != Material.wood))
	            continue;
	          boolean cancelHarvest = false;
	          if (cancelHarvest)
	            continue;
	          world.setBlockToAir(xPos, yPos, zPos);
	          if (player.capabilities.isCreativeMode)
	              continue;
	          block.harvestBlock(world, player, xPos, yPos, zPos, meta);
	          onBlockDestroyed(stack, world, localblockID, xPos, yPos, zPos, player);
	        }
	      }
	    }
	  }
  }
