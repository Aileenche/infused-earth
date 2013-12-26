package aileen.infusedearth.network.tileentitys;

import aileen.infusedearth.libs.network;
import aileen.infusedearth.network.NetworkBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class Tilenetchest extends TileEntity implements NetworkBase {
	public boolean is_controller=false;
	public boolean can_connect_to_network=true;
	public boolean is_networkblock=true;
	public boolean is_connected=false;

	@Override
	public boolean gis_controller() {
		// TODO Auto-generated method stub
		return is_controller;
	}

	@Override
	public boolean gcan_connect_to_network() {
		// TODO Auto-generated method stub
		return can_connect_to_network;
	}

	@Override
	public boolean gis_connected() {
		int x = this.xCoord;
		int y = this.yCoord;
		int z = this.zCoord;
		if (network.checkblock(getWorldObj(), x + 1, y, z)) {
			is_connected = true;
			return true;
		}
		if (network.checkblock(getWorldObj(), x - 1, y, z)) {
			is_connected = true;
			return true;
		}
		if (network.checkblock(getWorldObj(), x, y + 1, z)) {
			is_connected = true;
			return true;
		}
		if (network.checkblock(getWorldObj(), x, y - 1, z)) {
			is_connected = true;
			return true;
		}
		if (network.checkblock(getWorldObj(), x, y, z + 1)) {
			is_connected = true;
			return true;
		}
		if (network.checkblock(getWorldObj(), x, y, z - 1)) {
			is_connected = true;
			return true;
		}
		is_connected = false;
		return false;
	}

	@Override
	public boolean gis_networkblock() {
		// TODO Auto-generated method stub
		return is_networkblock;
	}

	@Override
	public void sis_controller(boolean b) {
		is_controller = b;
	}

	@Override
	public void sis_connected(boolean b) {
		is_connected = b;
	}

	@Override
	public void sis_networkblock(boolean b) {
		is_networkblock = b;
	}

	@Override
	public void scan_connect_to_network(boolean b) {
		can_connect_to_network = b;
	}

}
