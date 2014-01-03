package aileen.infusedearth.network.tileentitys;

import aileen.infusedearth.entitys.Particles;
import aileen.infusedearth.infusedearth;
import aileen.infusedearth.libs.BlockPosition;
import aileen.infusedearth.network.IColorable;
import aileen.infusedearth.network.INetworkTile;
import aileen.infusedearth.network.NetworkBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class Tilenetcable extends TileEntity implements NetworkBase, INetworkTile, IColorable {
    private int lastpulse = 0;
    private int style = 0;
    private int meta = 0;

    @Override
    public int get_internal_id() {
        return 3;
    }

    @Override
    public void trigger(ForgeDirection direction, int pulsecounter, int controllerX, int controllerY, int controllerZ) {
        if (!worldObj.isRemote) {
            if (lastpulse != pulsecounter) {
                lastpulse = pulsecounter;
                if (infusedearth.database.check4DB(xCoord, yCoord, zCoord, worldObj.provider.dimensionId)) {
                    colorizeFlame(pulsecounter);
                    sendPulse(direction, pulsecounter, controllerX, controllerY, controllerZ);
                } else {
                    infusedearth.database.registerBlockToNetwork(infusedearth.database.getNetworkId(controllerX, controllerY, controllerZ, worldObj.provider.dimensionId), get_internal_id(), xCoord, yCoord, zCoord, worldObj.provider.dimensionId, infusedearth.database.getOwnDBId(controllerX, controllerY, controllerZ, worldObj.provider.dimensionId), controllerX, controllerY, controllerZ,style,meta);
                    colorizeFlame(pulsecounter);
                    sendPulse(direction, pulsecounter, controllerX, controllerY, controllerZ);
                }
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

    @Override
    public void sendPulse(ForgeDirection d, int pulsecounter, int controllerX, int controllerY, int controllerZ) {
        for (ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS) {
            ForgeDirection opposite = BlockPosition.getOppositeDirection(d);
            if (opposite != direction) {
                TileEntity neighbour = BlockPosition.getTileInDirection(worldObj.getBlockTileEntity(xCoord, yCoord, zCoord), direction);
                if ((neighbour != null) && ((neighbour instanceof NetworkBase))) {
                    ((NetworkBase) neighbour).trigger(direction, pulsecounter, controllerX, controllerY, controllerZ);
                }
            }
        }
    }

    @Override
    public boolean linkActive() {
        if (infusedearth.database.getNetworkId(xCoord, yCoord, zCoord, worldObj.provider.dimensionId) != "") {
            return true;
        }
        return false;
    }

    @Override
    public void set_Icon(int i,int meta) {
        this.style = i;
        this.meta = meta;
        infusedearth.database.changestyle(xCoord, yCoord, zCoord, worldObj.provider.dimensionId, i,meta);
    }

    @Override
    public String get_Icon() {
        return infusedearth.database.getcolorized(xCoord, yCoord, zCoord, worldObj.provider.dimensionId);
    }


    @Override
    public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readFromNBT(par1NBTTagCompound);
        this.style = par1NBTTagCompound.getInteger("style");
        this.meta = par1NBTTagCompound.getInteger("meta");
    }

    @Override
    public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("style", this.style);
        par1NBTTagCompound.setInteger("meta", this.meta);
    }
}
