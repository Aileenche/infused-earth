package aileen.infusedearth.network;

import net.minecraftforge.common.ForgeDirection;

/**
 * Created by Aileen on 30.12.13.
 */
public interface INetworkTile {
    public abstract void sendPulse(ForgeDirection d, int pulsecounter, int controllerX, int controllerY, int controllerZ);
    public abstract boolean linkActive();
}
