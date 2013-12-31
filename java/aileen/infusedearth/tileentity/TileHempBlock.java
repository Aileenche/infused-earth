package aileen.infusedearth.tileentity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Aileen on 30.12.13.
 */
public class TileHempBlock extends TileEntity {
    public void getEaten(EntityLivingBase entity) {
        if (!worldObj.isRemote) {
            entity.addPotionEffect(new PotionEffect(Potion.confusion.id, 1200));
            entity.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 1200));
            entity.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 1200));
            entity.addPotionEffect(new PotionEffect(Potion.hunger.id, 1200));
            entity.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 1200));
            entity.addPotionEffect(new PotionEffect(Potion.nightVision.id, 1200));
            entity.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1200));
            entity.addPotionEffect(new PotionEffect(Potion.resistance.id, 1200));
            entity.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 1200));
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
