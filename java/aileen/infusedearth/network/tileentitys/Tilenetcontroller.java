package aileen.infusedearth.network.tileentitys;

import cpw.mods.fml.common.FMLLog;
import aileen.infusedearth.network.NetworkBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class Tilenetcontroller extends TileEntity implements NetworkBase {
	
	private String networkId = "[None]";
	public boolean is_controller = true;
	public boolean can_connect_to_network = true;
	public boolean is_networkblock = true;
	public boolean is_connected = false;
	public int conx;
	public int cony;
	public int conz;

	public boolean snetworkId(String Id){
		FMLLog.getLogger().info("Changing " + this.networkId + " to " + Id);
		  if (this.networkId.equals("[None]")) {
		      this.networkId = Id;
		      return true;
		    }
		    return false;
	}
	public void scon_pos(int x,int y, int z){
		this.conx = x;
		this.cony = y;
		this.conz = z;
	}
	public String gnetworkId(){
		return networkId;
	}
	@Override
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
    	super.readFromNBT(par1NBTTagCompound);
        this.networkId = par1NBTTagCompound.getString("networkId");
        this.conx = par1NBTTagCompound.getInteger("conx");
        this.cony = par1NBTTagCompound.getInteger("cony");
        this.conz = par1NBTTagCompound.getInteger("conz");
    	
    }

    @Override
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
    	super.writeToNBT(par1NBTTagCompound);     
        par1NBTTagCompound.setString("networkId", this.networkId); 
        par1NBTTagCompound.setInteger("conx", this.conx); 
        par1NBTTagCompound.setInteger("cony", this.cony); 
        par1NBTTagCompound.setInteger("conz", this.conz);   
    }
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
		// TODO Auto-generated method stub
		return is_connected;
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
