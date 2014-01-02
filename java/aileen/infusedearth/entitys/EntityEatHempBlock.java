package aileen.infusedearth.entitys;

import aileen.infusedearth.tileentity.TileHempBlock;
import net.minecraft.entity.passive.*;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent;

public class EntityEatHempBlock {
    public static double rand;

    @ForgeSubscribe
    public void onEntityIsNear(LivingEvent event) {
        if (event.entityLiving instanceof EntitySheep) {
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
                                if ((event.entityLiving).getDistance((double) newX, (double) newY, (double) newZ) < 3) {
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
                                if ((event.entityLiving).getDistance((double) newX, (double) newY, (double) newZ) < 3) {
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
                                if ((event.entityLiving).getDistance((double) newX, (double) newY, (double) newZ) < 3) {
                                    ((EntityPig) event.entityLiving).inLove = 1200;
                                    ((TileHempBlock) te).getEaten(event.entityLiving);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (event.entityLiving instanceof EntityHorse) {
            if (event.entityLiving.getActivePotionEffects().size() == 0) {
                int xCoord = (int) ((EntityHorse) event.entityLiving).posX;
                int yCoord = (int) ((EntityHorse) event.entityLiving).posY;
                int zCoord = (int) ((EntityHorse) event.entityLiving).posZ;
                for (int i = 0; i < 32; i++) {
                    for (int j = 0; j < 32; j++) {
                        for (int k = 0; k < 32; k++) {
                            int newX = (xCoord - 16) + i;
                            int newY = (yCoord - 16) + j;
                            int newZ = (zCoord - 16) + k;
                            TileEntity te = ((EntityHorse) event.entityLiving).worldObj.getBlockTileEntity(newX, newY, newZ);
                            if (te instanceof TileHempBlock) {
                                PathEntity path = ((EntityHorse) event.entityLiving).getNavigator().getPathToXYZ((double) newX, (double) newY, (double) newZ);
                                ((EntityHorse) event.entityLiving).getNavigator().setPath(path, 1.0F);
                                if ((event.entityLiving).getDistance((double) newX, (double) newY, (double) newZ) < 3) {
                                    ((EntityHorse) event.entityLiving).inLove = 1200;
                                    ((TileHempBlock) te).getEaten(event.entityLiving);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (event.entityLiving instanceof EntityWolf) {
            if (event.entityLiving.getActivePotionEffects().size() == 0) {
                int xCoord = (int) ((EntityWolf) event.entityLiving).posX;
                int yCoord = (int) ((EntityWolf) event.entityLiving).posY;
                int zCoord = (int) ((EntityWolf) event.entityLiving).posZ;
                for (int i = 0; i < 32; i++) {
                    for (int j = 0; j < 32; j++) {
                        for (int k = 0; k < 32; k++) {
                            int newX = (xCoord - 16) + i;
                            int newY = (yCoord - 16) + j;
                            int newZ = (zCoord - 16) + k;
                            TileEntity te = ((EntityWolf) event.entityLiving).worldObj.getBlockTileEntity(newX, newY, newZ);
                            if (te instanceof TileHempBlock) {
                                PathEntity path = ((EntityWolf) event.entityLiving).getNavigator().getPathToXYZ((double) newX, (double) newY, (double) newZ);
                                ((EntityWolf) event.entityLiving).getNavigator().setPath(path, 1.0F);
                                if ((event.entityLiving).getDistance((double) newX, (double) newY, (double) newZ) < 3) {
                                    ((EntityWolf) event.entityLiving).inLove = 1200;
                                    ((TileHempBlock) te).getEaten(event.entityLiving);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (event.entityLiving instanceof EntityMooshroom) {
            if (event.entityLiving.getActivePotionEffects().size() == 0) {
                int xCoord = (int) ((EntityMooshroom) event.entityLiving).posX;
                int yCoord = (int) ((EntityMooshroom) event.entityLiving).posY;
                int zCoord = (int) ((EntityMooshroom) event.entityLiving).posZ;
                for (int i = 0; i < 32; i++) {
                    for (int j = 0; j < 32; j++) {
                        for (int k = 0; k < 32; k++) {
                            int newX = (xCoord - 16) + i;
                            int newY = (yCoord - 16) + j;
                            int newZ = (zCoord - 16) + k;
                            TileEntity te = ((EntityMooshroom) event.entityLiving).worldObj.getBlockTileEntity(newX, newY, newZ);
                            if (te instanceof TileHempBlock) {
                                PathEntity path = ((EntityWolf) event.entityLiving).getNavigator().getPathToXYZ((double) newX, (double) newY, (double) newZ);
                                ((EntityMooshroom) event.entityLiving).getNavigator().setPath(path, 1.0F);
                                if ((event.entityLiving).getDistance((double) newX, (double) newY, (double) newZ) < 3) {
                                    ((EntityMooshroom) event.entityLiving).inLove = 1200;
                                    ((TileHempBlock) te).getEaten(event.entityLiving);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (event.entityLiving instanceof EntityOcelot) {
            if (event.entityLiving.getActivePotionEffects().size() == 0) {
                int xCoord = (int) ((EntityOcelot) event.entityLiving).posX;
                int yCoord = (int) ((EntityOcelot) event.entityLiving).posY;
                int zCoord = (int) ((EntityOcelot) event.entityLiving).posZ;
                for (int i = 0; i < 32; i++) {
                    for (int j = 0; j < 32; j++) {
                        for (int k = 0; k < 32; k++) {
                            int newX = (xCoord - 16) + i;
                            int newY = (yCoord - 16) + j;
                            int newZ = (zCoord - 16) + k;
                            TileEntity te = ((EntityOcelot) event.entityLiving).worldObj.getBlockTileEntity(newX, newY, newZ);
                            if (te instanceof TileHempBlock) {
                                PathEntity path = ((EntityOcelot) event.entityLiving).getNavigator().getPathToXYZ((double) newX, (double) newY, (double) newZ);
                                ((EntityOcelot) event.entityLiving).getNavigator().setPath(path, 1.0F);
                                if ((event.entityLiving).getDistance((double) newX, (double) newY, (double) newZ) < 3) {
                                    ((EntityOcelot) event.entityLiving).inLove = 1200;
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
                                if ((event.entityLiving).getDistance((double) newX, (double) newY, (double) newZ) < 3) {
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
