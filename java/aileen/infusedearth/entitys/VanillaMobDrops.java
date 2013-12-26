package aileen.infusedearth.entitys;

import aileen.infusedearth.infusedearth;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.item.Item;
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