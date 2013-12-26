package aileen.infusedearth.network.blocks;

import aileen.infusedearth.infusedearth;
import aileen.infusedearth.network.tileentitys.Tilenetchest;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class netchest extends BlockContainer {

    public netchest(int par1, Material par2Material) {
        super(par1, par2Material);
        setUnlocalizedName("netchest");
        setCreativeTab(infusedearth.ctab_blocks);
    }

    public void registerIcons(IconRegister reg) {
        this.blockIcon = reg.registerIcon("infusedearth:nb_chest");
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        // TODO Auto-generated method stub
        return new Tilenetchest();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
        if (!world.isRemote) {
            Tilenetchest te = (Tilenetchest) world.getBlockTileEntity(x, y, z);
            if (te != null) {
                player.addChatMessage("is_controller: " + te.gis_controller() + ", can_connect_to_network: " + te.gcan_connect_to_network() + ", is_connected: " + te.gis_connected()
                        + ", is_networkBlock: " + te.gis_networkblock());
            }
        }
        return true;
    }
}
