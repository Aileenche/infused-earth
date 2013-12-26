package aileen.infusedearth.blocks;

import static net.minecraftforge.common.EnumPlantType.Cave;
import static net.minecraftforge.common.EnumPlantType.Crop;
import static net.minecraftforge.common.EnumPlantType.Desert;
import static net.minecraftforge.common.EnumPlantType.Nether;
import static net.minecraftforge.common.EnumPlantType.Plains;
import static net.minecraftforge.common.EnumPlantType.Water;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;

public class iceflower extends BlockFlower implements IPlantable {
	public iceflower(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setTickRandomly(true);
		float f = 0.2F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 3.0F,
				0.5F + f);
	}

	public iceflower(int par1) {
		this(par1, Material.plants);
	}

	public void registerIcons(IconRegister reg) {
		this.blockIcon = reg.registerIcon("infusedearth:iceflower");
	}
 
	@Override
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return Item.snowball.itemID;
    }
//	public void breakBlock(World world, int x, int y, int z, int id, int meta) {
//		ItemStack is = new ItemStack(Item.snowball);
//
//		if (is != null) {
//			float spawnX = x + world.rand.nextFloat();
//			float spawnY = y + world.rand.nextFloat();
//			float spawnZ = z + world.rand.nextFloat();
//
//			EntityItem droppedItem = new EntityItem(world, spawnX, spawnY,
//					spawnZ, is);
//
//			float mult = 0.05F;
//
//			droppedItem.motionX = (-0.5F + world.rand.nextFloat()) * mult;
//			droppedItem.motionY = (4 + world.rand.nextFloat()) * mult;
//			droppedItem.motionZ = (-0.5F + world.rand.nextFloat()) * mult;
//
//			world.spawnEntityInWorld(droppedItem);
//		}
//	}
	protected boolean canThisPlantGrowOnThisBlockID(int par1) {
		return par1 == Block.grass.blockID || par1 == Block.dirt.blockID || par1 == Block.tilledField.blockID || par1 == Block.sand.blockID; 
	}
}
