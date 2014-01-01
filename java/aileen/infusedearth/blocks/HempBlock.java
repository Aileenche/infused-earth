package aileen.infusedearth.blocks;

import aileen.infusedearth.infusedearth;
import aileen.infusedearth.tileentity.TileHempBlock;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class HempBlock extends BlockContainer {

    public HempBlock(int par1) {
        super(par1, Material.grass);
        setCreativeTab(infusedearth.ctab_blocks);
        setUnlocalizedName("HempBlock");
        setStepSound(soundGrassFootstep);
        setHardness(0.1F);
        setResistance(0.1F);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileHempBlock();
    }

    public void registerIcons(IconRegister reg) {
        this.blockIcon = reg.registerIcon("infusedearth:HempBlock");
    }

    @Override
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
        if (!par1World.isRemote) {
            TileEntity te = par1World.getBlockTileEntity(par2,par3,par4);
            if(te != null){
                ((TileHempBlock)te).getEaten(par5EntityPlayer);
            }
        }
        return true;
    }

    @Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public int getRenderType() {
		return infusedearth.HempBlockTesrId;
	}

}
