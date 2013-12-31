package aileen.infusedearth.network;

import net.minecraftforge.common.ForgeDirection;

public interface NetworkBase {


    //  Return The Internal ID for the Network
    // 0 = NO RETURN!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // 1 = NetworkController
    // 2 = NetworkChest
    // 3 = NetworkCable
    public int get_internal_id();

    public  void trigger(ForgeDirection direction,int pulsecounter,int controllerX,int controllerY,int controllerZ);
}
