package aileen.infusedearth.entitys;

import aileen.infusedearth.infusedearth;
import net.minecraft.entity.passive.*;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class VanillaMobDrops {
	public static double rand;





	@ForgeSubscribe
	public void onEntityDrop(LivingDropsEvent event) {
		rand = Math.random();

		if (event.entityLiving instanceof EntitySheep) {
			if (rand < 1D) {
				event.entityLiving.dropItem(infusedearth.bone_medium.itemID, 2);
			}
		}
		if (event.entityLiving instanceof EntityPig) {
			if (rand < 1D) {
				event.entityLiving.dropItem(infusedearth.bone_medium.itemID, 2);
			}
		}
		if (event.entityLiving instanceof EntityChicken) {
			if (rand < 1D) {
				event.entityLiving.dropItem(infusedearth.bone_tiny.itemID, 3);
			}
		}
		if (event.entityLiving instanceof EntityCow) {
			if (rand < 1D) {
				event.entityLiving.dropItem(infusedearth.bone_large.itemID, 3);
			}
		}
		if (event.entityLiving instanceof EntityHorse) {
			if (rand < 1D) {
				event.entityLiving.dropItem(infusedearth.bone_large.itemID, 4);
			}
		}
		if (event.entityLiving instanceof EntityOcelot) {
			if (rand < 1D) {
				event.entityLiving.dropItem(infusedearth.bone_small.itemID, 2);
			}
		}
		if (event.entityLiving instanceof EntityWolf) {
			if (rand < 1D) {
				event.entityLiving.dropItem(infusedearth.bone_small.itemID, 2);
			}
		}
		if (event.entityLiving instanceof EntityMooshroom) {
			if (rand < 1D) {
				event.entityLiving.dropItem(infusedearth.bone_large.itemID, 3);
			}
		}
	}
}