package aileen.infusedearth.libs;

import aileen.infusedearth.network.NetworkBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class network {
	public static int checkNetBlockId(World world, int x, int y, int z) {
		TileEntity tile = world.getBlockTileEntity(x, y, z);
        if(tile != null && tile instanceof NetworkBase){
            return ((NetworkBase)tile).get_internal_id();
        }
        return 0;
	}
}
