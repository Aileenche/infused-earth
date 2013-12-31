package aileen.infusedearth.proxies;

/**
 * Created by Aileen on 28.12.13.
 */

import cpw.mods.fml.common.network.Player;
import net.minecraft.world.World;

import java.io.File;

public abstract interface IProxy {


    public abstract World getPlayerWorld(Player paramPlayer);

    public abstract File getWorldDir(World paramWorld);


}
