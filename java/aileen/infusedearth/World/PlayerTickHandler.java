package aileen.infusedearth.World;

import java.util.EnumSet;

import aileen.infusedearth.infusedearth;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class PlayerTickHandler implements ITickHandler {

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		playerTick((EntityPlayer) tickData[0]);

	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {

	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.PLAYER);
	}

	@Override
	public String getLabel() {
		return "Titancraft_Tickhandler";
	}

	private void playerTick(EntityPlayer player) {
		/*
		 * if (player.inventory.armorInventory[2] != null) {
		 * player.capabilities.allowFlying =
		 * (player.inventory.armorInventory[2].itemID ==
		 * Items.titanArmorChest.itemID); } else {
		 * player.capabilities.allowFlying = player.capabilities.isCreativeMode;
		 * }
		 */
		try {
			player.capabilities.allowFlying = (player.inventory.armorInventory[2].itemID == infusedearth.seleniumArmorChest.itemID || player.capabilities.isCreativeMode);
		} catch (Exception e) {
			player.capabilities.allowFlying = player.capabilities.isCreativeMode;
		}

	}

}