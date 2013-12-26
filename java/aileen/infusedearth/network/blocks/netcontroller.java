package aileen.infusedearth.network.blocks;

import cpw.mods.fml.common.FMLLog;
import aileen.infusedearth.infusedearth;
import aileen.infusedearth.network.tileentitys.Tilenetcontroller;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class netcontroller extends BlockContainer {

	public netcontroller(int par1, Material par2Material) {
		super(par1, par2Material);
		setUnlocalizedName("netcontroller");
		setCreativeTab(infusedearth.ctab_blocks);
	}

	public void registerIcons(IconRegister reg) {
		this.blockIcon = reg.registerIcon("infusedearth:nb_controller");
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new Tilenetcontroller();
	}

	@Override
	public void onBlockPlacedBy(World par1World, int x, int y, int z, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
		if (!par1World.isRemote) {
			Tilenetcontroller te = (Tilenetcontroller) par1World.getBlockTileEntity(x, y, z);
			if (te != null) {
				te.scon_pos(x, y, z);
				String id = ((EntityPlayer) par5EntityLivingBase).username + System.currentTimeMillis();
				te.snetworkId(id);
			}
		}
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		if (!world.isRemote) {
			if (player.isSneaking()) {
				Tilenetcontroller te = (Tilenetcontroller) world.getBlockTileEntity(x, y, z);
				if (te != null) {
					if (te.gcan_connect_to_network() == true) {
						FMLLog.getLogger().info(te.gcan_connect_to_network() + " --> false");
						te.scan_connect_to_network(false);
					} else {
						te.scan_connect_to_network(true);
						FMLLog.getLogger().info(te.gcan_connect_to_network() + " --> true");
					}
				}
			} else {
				Tilenetcontroller te = (Tilenetcontroller) world.getBlockTileEntity(x, y, z);
				if (te != null) {
					player.addChatMessage("NetworkId: " + te.gnetworkId());
				}
			}
		}
		return true;
	}
}
