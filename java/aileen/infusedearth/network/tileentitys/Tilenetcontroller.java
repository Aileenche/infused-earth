package aileen.infusedearth.network.tileentitys;

import aileen.infusedearth.entitys.Particles;
import aileen.infusedearth.infusedearth;
import aileen.infusedearth.libs.BlockPosition;
import aileen.infusedearth.network.IColorable;
import aileen.infusedearth.network.NetworkBase;
import cpw.mods.fml.common.FMLLog;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class Tilenetcontroller extends TileEntity implements NetworkBase, IColorable {

    private String networkId = "[None]";
    private int pulsecounter = 1;

    @Override
    public int get_internal_id() {
        return 1;
    }

    @Override
    public void set_Icon(int i) {
        infusedearth.database.changestyle(xCoord, yCoord, zCoord, worldObj.provider.dimensionId, i);
    }

    @Override
    public int get_Icon() {
        return infusedearth.database.getcolorized(xCoord, yCoord, zCoord, worldObj.provider.dimensionId);
    }


    public void trigger(ForgeDirection direction, int pulsecounter, int controllerX, int controllerY, int controllerZ) {

    }

    public void updateEntity() {
        if (((int) (Math.random() * 10)) == 1) {
            if (!worldObj.isRemote) {
                colorizeFlame(pulsecounter);
                sendPulse();
            } else {
                Minecraft.getMinecraft().renderGlobal.markBlockForUpdate(xCoord, yCoord, zCoord);
                Minecraft.getMinecraft().renderGlobal.markBlockForRenderUpdate(xCoord, yCoord, zCoord);
            }
        }
    }

    public void colorizeFlame(int i) {
        if (i == 1) {
            Particles.FLAME.spawnParticle(worldObj, xCoord + 0.5, yCoord + 0.5, zCoord + 0.5, 0.0D, 0.0D, 0.0D);
        }
        if (i == 2) {
            Particles.FLAMERED.spawnParticle(worldObj, xCoord + 0.5, yCoord + 0.5, zCoord + 0.5, 0.0D, 0.0D, 0.0D);
        }
        if (i == 3) {
            Particles.FLAMEBLUE.spawnParticle(worldObj, xCoord + 0.5, yCoord + 0.5, zCoord + 0.5, 0.0D, 0.0D, 0.0D);
        }
        if (i == 4) {
            Particles.FLAMEGREEN.spawnParticle(worldObj, xCoord + 0.5, yCoord + 0.5, zCoord + 0.5, 0.0D, 0.0D, 0.0D);
        }
    }

    public void sendPulse() {
        for (ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS) {
            TileEntity neighbour = BlockPosition.getTileInDirection(worldObj.getBlockTileEntity(xCoord, yCoord, zCoord), direction);
            if ((neighbour != null) && ((neighbour instanceof NetworkBase))) {
                ((NetworkBase) neighbour).trigger(direction, pulsecounter, xCoord, yCoord, zCoord);
            }
        }
        if (pulsecounter == 4) {
            pulsecounter = 1;
        } else {
            pulsecounter++;
        }
    }

    public Tilenetcontroller() {
    }

    public boolean snetworkId() {
        String Id = System.currentTimeMillis() + ((int) (Math.random() * 40)) + "";
        FMLLog.getLogger().info("Changing " + this.networkId + " to " + Id);
        if (this.networkId.equals("[None]")) {
            this.networkId = Id;
            infusedearth.database.createNetwork(Id);
            infusedearth.database.registerBlockToNetwork(Id, get_internal_id(), xCoord, yCoord, zCoord, worldObj.provider.dimensionId, -1, xCoord, yCoord, zCoord,0);
            return true;
        }
        return false;
    }

    public String gnetworkId() {
        return networkId;
    }

    @Override
    public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readFromNBT(par1NBTTagCompound);
        this.networkId = par1NBTTagCompound.getString("networkId");
    }

    @Override
    public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setString("networkId", this.networkId);
    }
}
