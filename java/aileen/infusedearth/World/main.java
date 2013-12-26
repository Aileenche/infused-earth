// Copyright 2013 by Aileen Kutschik (aileen.kutschik@web.de)
package aileen.infusedearth.World;

import java.util.Random;

import aileen.infusedearth.infusedearth;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.IWorldGenerator;

public class main implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId){
		case -1: genNether();
			break;
		case 0: 
			genWorld(world, random, chunkX*16, chunkZ*16);
			gen_flowers(world, random, chunkX*16, chunkZ*16);
			break;
		case 1: genEnd();
			break;
		}
		
	}

	private void genEnd() {
		// TODO Auto-generated method stub
		
	}

	private void genWorld(World world, Random rand, int chunkX,int chunkZ) {
		for(int i = 0; i < infusedearth.seleniumOreVeins; i++){
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(infusedearth.seleniumOreMaxHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			new WorldGenMinable(infusedearth.seleniumOre.blockID, infusedearth.seleniumOreClusterSize).generate(world, rand, randPosX, randPosY, randPosZ);
		}
		
	}

	private void genNether() {
		// TODO Auto-generated method stub
		
	}

    public void gen_flowers(World par1World, Random par2Random, int x, int z)
    {
        for (int tries = 0; tries < 60; tries++)
        {
          int i1 = x + par2Random.nextInt(16);
          int j1 = 64 + par2Random.nextInt(128);
          int k1 = z + par2Random.nextInt(16);
          if ((!par1World.isAirBlock(i1, j1, k1)) || (!((BlockFlower)Block.blocksList[infusedearth.iceflower.blockID]).canBlockStay(par1World, i1, j1, k1)))
            continue;
          if(par1World.setBlock(i1, j1, k1, infusedearth.iceflower.blockID)){
        	  //FMLLog.getLogger().info("[InfusedEarth][Flowergen] "+infusedearth.iceflower.blockID+" planted: X="+i1+" Y="+j1+" Z="+k1);
          } else {
        	  //FMLLog.getLogger().info("[InfusedEarth][Flowergen] "+infusedearth.iceflower.blockID+" NOT planted: X="+i1+" Y="+j1+" Z="+k1);
          }
        }
}}