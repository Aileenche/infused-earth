package aileen.infusedearth.entitys;

import aileen.infusedearth.tileentity.TileHempBlock;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent;

public class EntityEatHempBlock {
    public static double rand;

    @ForgeSubscribe
    public void onEntityIsNear(LivingEvent event) {
        if (event.entityLiving instanceof EntitySheep || event.entityLiving instanceof EntityCow || event.entityLiving instanceof EntityPig || event.entityLiving instanceof EntityChicken) {
            if (event.entityLiving.getActivePotionEffects().size() == 0) {
                int xCoord = (int) ((EntitySheep) event.entityLiving).posX;
                int yCoord = (int) ((EntitySheep) event.entityLiving).posY;
                int zCoord = (int) ((EntitySheep) event.entityLiving).posZ;
                for (int i = 0; i < 32; i++) {
                    for (int j = 0; j < 32; j++) {
                        for (int k = 0; k < 32; k++) {
                            int newX = (xCoord - 16) + i;
                            int newY = (yCoord - 16) + j;
                            int newZ = (zCoord - 16) + k;
                            TileEntity te = ((EntitySheep) event.entityLiving).worldObj.getBlockTileEntity(newX, newY, newZ);
                            if (te instanceof TileHempBlock) {
                                PathEntity path = ((EntitySheep) event.entityLiving).getNavigator().getPathToXYZ((double) newX, (double) newY, (double) newZ);
                                ((EntitySheep) event.entityLiving).getNavigator().setPath(path, 1.0F);
                                if ((event.entityLiving).getDistance((double) newX, (double) newY, (double) newZ) < 2) {
                                    ((EntitySheep) event.entityLiving).inLove = 1200;
                                    ((TileHempBlock) te).getEaten(event.entityLiving);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (event.entityLiving instanceof EntityCow) {
            if (event.entityLiving.getActivePotionEffects().size() == 0) {
                int xCoord = (int) ((EntityCow) event.entityLiving).posX;
                int yCoord = (int) ((EntityCow) event.entityLiving).posY;
                int zCoord = (int) ((EntityCow) event.entityLiving).posZ;
                for (int i = 0; i < 32; i++) {
                    for (int j = 0; j < 32; j++) {
                        for (int k = 0; k < 32; k++) {
                            int newX = (xCoord - 16) + i;
                            int newY = (yCoord - 16) + j;
                            int newZ = (zCoord - 16) + k;
                            TileEntity te = ((EntityCow) event.entityLiving).worldObj.getBlockTileEntity(newX, newY, newZ);
                            if (te instanceof TileHempBlock) {
                                PathEntity path = ((EntityCow) event.entityLiving).getNavigator().getPathToXYZ((double) newX, (double) newY, (double) newZ);
                                ((EntityCow) event.entityLiving).getNavigator().setPath(path, 1.0F);
                                if ((event.entityLiving).getDistance((double) newX, (double) newY, (double) newZ) < 2) {
                                    ((EntityCow) event.entityLiving).inLove = 1200;
                                    ((TileHempBlock) te).getEaten(event.entityLiving);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (event.entityLiving instanceof EntityPig) {
            if (event.entityLiving.getActivePotionEffects().size() == 0) {
                int xCoord = (int) ((EntityPig) event.entityLiving).posX;
                int yCoord = (int) ((EntityPig) event.entityLiving).posY;
                int zCoord = (int) ((EntityPig) event.entityLiving).posZ;
                for (int i = 0; i < 32; i++) {
                    for (int j = 0; j < 32; j++) {
                        for (int k = 0; k < 32; k++) {
                            int newX = (xCoord - 16) + i;
                            int newY = (yCoord - 16) + j;
                            int newZ = (zCoord - 16) + k;
                            TileEntity te = ((EntityPig) event.entityLiving).worldObj.getBlockTileEntity(newX, newY, newZ);
                            if (te instanceof TileHempBlock) {
                                PathEntity path = ((EntityPig) event.entityLiving).getNavigator().getPathToXYZ((double) newX, (double) newY, (double) newZ);
                                ((EntityPig) event.entityLiving).getNavigator().setPath(path, 1.0F);
                                if ((event.entityLiving).getDistance((double) newX, (double) newY, (double) newZ) < 2) {
                                    ((EntityPig) event.entityLiving).inLove = 1200;
                                    ((TileHempBlock) te).getEaten(event.entityLiving);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (event.entityLiving instanceof EntityChicken) {
            if (event.entityLiving.getActivePotionEffects().size() == 0) {
                int xCoord = (int) ((EntityChicken) event.entityLiving).posX;
                int yCoord = (int) ((EntityChicken) event.entityLiving).posY;
                int zCoord = (int) ((EntityChicken) event.entityLiving).posZ;
                for (int i = 0; i < 32; i++) {
                    for (int j = 0; j < 32; j++) {
                        for (int k = 0; k < 32; k++) {
                            int newX = (xCoord - 16) + i;
                            int newY = (yCoord - 16) + j;
                            int newZ = (zCoord - 16) + k;
                            TileEntity te = ((EntityChicken) event.entityLiving).worldObj.getBlockTileEntity(newX, newY, newZ);
                            if (te instanceof TileHempBlock) {
                                PathEntity path = ((EntityChicken) event.entityLiving).getNavigator().getPathToXYZ((double) newX, (double) newY, (double) newZ);
                                ((EntityChicken) event.entityLiving).getNavigator().setPath(path, 1.0F);
                                if ((event.entityLiving).getDistance((double) newX, (double) newY, (double) newZ) < 2) {
                                    ((EntityChicken) event.entityLiving).inLove = 1200;
                                    ((TileHempBlock) te).getEaten(event.entityLiving);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
