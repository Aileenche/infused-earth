// Copyright 2013 by Aileen Kutschik (aileen.kutschik@web.de)
package aileen.infusedearth.proxies;

import aileen.infusedearth.World.PlayerTickHandler;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class CoreClientProxy extends CoreCommonProxy
{
	public void registerHandlers() {
		TickRegistry.registerTickHandler(new PlayerTickHandler(), Side.CLIENT);
		TickRegistry.registerTickHandler(new PlayerTickHandler(), Side.SERVER);
	}
}