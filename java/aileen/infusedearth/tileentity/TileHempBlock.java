package aileen.infusedearth.tileentity;

import cpw.mods.fml.common.FMLLog;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Aileen on 30.12.13.
 */

public class TileHempBlock extends TileEntity {
    public int uses_left = 13;

/*    public AxisAlignedBB getRenderBoundingBox(){
        double x1 = xCoord;
        double x2 = yCoord;
        double y1 = zCoord;
        double y2 = xCoord + 1;
        double z1 = yCoord + 1;
        double z2 = zCoord + 1;

        switch(state){
            case 16:
            default:
                break;
            case 15:
                y2 -= 0.05F;
                break;
            case 14:
                y2 -= 0.1F;
                break;
            case 13:
                y2 -= 0.15F;
                break;
            case 12:
                y2 -= 0.2F;
                break;
            case 11:
                y2 -= 0.25F;
                break;
            case 10:
                y2 -= 0.3F;
                break;
            case 9:
                y2 -= 0.35F;
                break;
            case 8:
                y2 -= 0.4F;
                break;
            case 7:
                y2 -= 0.45F;
                break;
            case 6:
                y2 -= 0.5F;
                break;
            case 5:
                y2 -= 0.55F;
                break;
            case 4:
                y2 -= 0.6F;
                break;
            case 3:
                y2 -= 0.65F;
                break;
            case 2:
                y2 -= 0.7F;
                break;
            case 1:
                y2 -= 0.75F;
                break;

        }

        AxisAlignedBB bb = AxisAlignedBB.getAABBPool().getAABB(x1,y1,z1,x2,y2,z2);
        return bb;
    }*/

    public Float getscaleY(){
        FMLLog.getLogger().info("Sending new scale to TESR state: " + this.uses_left);
        switch (this.uses_left){
            case 16:
                return 1.0F;
            case 15:
                return 0.94F;
            case 14:
                return 0.88F;
            case 13:
                return 0.82F;
            case 12:
                return 0.76F;
            case 11:
                return 0.70F;
            case 10:
                return 0.64F;
            case 9:
                return 0.58F;
            case 8:
                return 0.52F;
            case 7:
                return 0.46F;
            case 6:
                return 0.40F;
            case 5:
                return 0.34F;
            case 4:
                return 0.28F;
            case 3:
                return 0.22F;
            case 2:
                return 0.16F;
            case 1:
                return 0.8F;
        }
        return 0F;
    }

    public void getEaten(EntityLivingBase entity) {
        if (!worldObj.isRemote) {
            FMLLog.getLogger().info("called....");
            entity.addPotionEffect(new PotionEffect(Potion.confusion.id, 1200));
            entity.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 1200));
            entity.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 1200));
            entity.addPotionEffect(new PotionEffect(Potion.hunger.id, 1200));
            entity.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 1200));
            entity.addPotionEffect(new PotionEffect(Potion.nightVision.id, 1200));
            entity.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1200));
            entity.addPotionEffect(new PotionEffect(Potion.resistance.id, 1200));
            entity.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 1200));
            if(uses_left > 1){
                uses_left = uses_left-1;
                FMLLog.getLogger().info("New State: "+uses_left);
            } else {
                worldObj.setBlockToAir(xCoord,yCoord,zCoord);
                worldObj.removeBlockTileEntity(xCoord,yCoord,zCoord);
                FMLLog.getLogger().info("Removed!");
            }
            worldObj.markBlockForRenderUpdate(xCoord,yCoord,zCoord);
        }
    }
        @Override
    public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readFromNBT(par1NBTTagCompound);
    }

    @Override
    public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeToNBT(par1NBTTagCompound);
    }
}
