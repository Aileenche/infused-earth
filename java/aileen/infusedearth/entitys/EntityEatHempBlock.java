package aileen.infusedearth.entitys;

import aileen.infusedearth.tileentity.TileHempBlock;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent;

/**
 * Created by Aileen on 30.12.13.
 */
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
                                if (((EntitySheep) event.entityLiving).getDistance((double) newX, (double) newY, (double) newZ) < 2) {
                                    ((EntitySheep) event.entityLiving).inLove = 1200;
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
