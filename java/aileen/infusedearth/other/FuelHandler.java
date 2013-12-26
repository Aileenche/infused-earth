package aileen.infusedearth.other;

import aileen.infusedearth.infusedearth;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		int var1 = fuel.itemID;
		
	//	if(var1 == infusedearth.seleniumCoalDust.itemID){
	//		return infusedearth.seleniumCoalDustBurnTime;
	//	} else {
	//		return 0;
	//	}
		return 0;
	}

}
