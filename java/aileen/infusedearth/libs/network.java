package aileen.infusedearth.libs;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import aileen.infusedearth.network.NetworkBase;

public class network {
	public static boolean checkblock(World world, int x, int y, int z) {
		TileEntity tile = world.getBlockTileEntity(x, y, z);
		if (tile != null) {
			if (((NetworkBase) tile).gis_networkblock() && ((NetworkBase) tile).gcan_connect_to_network()) {
				return true;
			}
		}
		return false;
	}
}
