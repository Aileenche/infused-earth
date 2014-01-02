package aileen.infusedearth.tileentity;

import aileen.infusedearth.infusedearth;
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
    public Float getscaleY() {
        switch (infusedearth.database.getHempBlockState(xCoord, yCoord, zCoord, worldObj.provider.dimensionId)) {
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
                return 0.08F;
        }
        return 0F;
    }





    public void deleteHempBlock(){
        infusedearth.database.deleteHempBlock(xCoord,yCoord,zCoord,worldObj.provider.dimensionId);
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
            int temp = infusedearth.database.getHempBlockState(xCoord, yCoord, zCoord, worldObj.provider.dimensionId);
            if (temp > 1) {
                temp = temp - 1;
                infusedearth.database.updateHempBlockState(xCoord, yCoord, zCoord, worldObj.provider.dimensionId, temp);
                FMLLog.getLogger().info("New State: " + temp);
            } else {
                worldObj.setBlockToAir(xCoord, yCoord, zCoord);
                deleteHempBlock();
                worldObj.removeBlockTileEntity(xCoord, yCoord, zCoord);
                FMLLog.getLogger().info("Removed!");
            }
            worldObj.markBlockForRenderUpdate(xCoord, yCoord, zCoord);
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
