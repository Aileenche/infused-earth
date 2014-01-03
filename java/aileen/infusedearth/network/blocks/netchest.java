package aileen.infusedearth.network.blocks;

import aileen.infusedearth.infusedearth;
import aileen.infusedearth.network.tileentitys.Tilenetchest;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class netchest extends BlockContainer {

    private Icon iconorig;
    private Icon iconoverride;


    public netchest(int par1, Material par2Material) {
        super(par1, par2Material);
        setUnlocalizedName("netchest");
        setCreativeTab(infusedearth.ctab_blocks);
        setHardness(5.0F);
        setResistance(100.0F);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister ir) {
        this.iconorig = ir.registerIcon("infusedearth:nb_chest_g");
    }


    @SideOnly(Side.CLIENT)
    @Override
    public Icon getIcon(int side, int meta) {
        if (meta == 0) {
            return this.iconorig;
        }
        return null;
    }

    public Icon getBlockTexture(IBlockAccess world, int x, int y, int z, int side) {
        int meta = world.getBlockMetadata(x, y, z);
        TileEntity te = world.getBlockTileEntity(x, y, z);
        if ((te instanceof Tilenetchest)) {
            String tempID = ((Tilenetchest) te).get_Icon();
            String[] TEMPID = tempID.split(";");

            if (Integer.parseInt(TEMPID[0]) != 0 && TEMPID[1] != "") {
                Block tempBlock = blocksList[Integer.parseInt(TEMPID[0])];
                ItemStack tempItemStack = new ItemStack(tempBlock,1, Integer.parseInt(TEMPID[1]));
                return tempItemStack.getIconIndex();
            }
            return this.iconorig;

        }
        return getIcon(side, meta);
    }

    public void onNeighborBlockChange(World world, int x, int y, int z, int id) {
        if (!world.isRemote) {
            TileEntity te = world.getBlockTileEntity(x, y, z);
            if ((te != null) && ((te instanceof Tilenetchest))) {
                //((Tilenetchest) te).connectivitycheck(x, y, z, world.provider.dimensionId);
            }
        }
    }

    @Override
    public void onBlockPlacedBy(World par1World, int x, int y, int z, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
        if (!par1World.isRemote) {
            Tilenetchest te = (Tilenetchest) par1World.getBlockTileEntity(x, y, z);
            if (te != null) {
                // te.connectivitycheck(x, y, z, par1World.provider.dimensionId);
            }
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        // TODO Auto-generated method stub
        return new Tilenetchest();
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
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
        if (!world.isRemote) {
            Tilenetchest te = (Tilenetchest) world.getBlockTileEntity(x, y, z);
            if (te != null) {
                if (player.isSneaking()) {
                    player.addChatMessage("NetWorkID [" + te.get_Icon()/*infusedearth.database.getNetworkId(x, y, z, te.worldObj.provider.dimensionId)*/ + "]");
                } else {
                    ItemStack held = player.getHeldItem();
                    if (held != null && held.itemID < 4096) {
                        Block tempBlock = blocksList[held.itemID];
                        if (tempBlock.blockResistance > 0.0 || held.itemID == 351) {
                            if (held.itemID == 351) {
                                te.set_Icon(35, held.getItemDamage());
                            } else if (held.itemID == 35) {
                                te.set_Icon(35, (~held.getItemDamage() & 15));
                            } else {
                                te.set_Icon(tempBlock.blockID, held.getItemDamage());
                            }
                            iconoverride = held.getIconIndex();
                        } else {
                            te.set_Icon(0, 0);
                        }
                    } else {
                        te.set_Icon(0, 0);
                    }
                }
            }
        }
        return true;
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
        if (!world.isRemote) {
            Tilenetchest te = (Tilenetchest) world.getBlockTileEntity(x, y, z);
            if (te != null) {
                String networkId = infusedearth.database.getNetworkId(te.xCoord, te.yCoord, te.zCoord, te.worldObj.provider.dimensionId);
                infusedearth.database.deleteFromNetwork(networkId);
                te.worldObj.removeBlockTileEntity(x, y, z);
            }
        }
    }
}
