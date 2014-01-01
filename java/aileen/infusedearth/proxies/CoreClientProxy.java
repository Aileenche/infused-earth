// Copyright 2013 by Aileen Kutschik (aileen.kutschik@web.de)
package aileen.infusedearth.proxies;

import aileen.infusedearth.World.PlayerTickHandler;
import aileen.infusedearth.infusedearth;
import aileen.infusedearth.tesr.HempBlockTesr;
import aileen.infusedearth.tileentity.TileHempBlock;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class CoreClientProxy extends CoreCommonProxy
{
	public void registerHandlers() {
		TickRegistry.registerTickHandler(new PlayerTickHandler(), Side.CLIENT);
		TickRegistry.registerTickHandler(new PlayerTickHandler(), Side.SERVER);
	}

    @Override
	public void initRenderers() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileHempBlock.class, new HempBlockTesr());

		infusedearth.HempBlockTesrId = RenderingRegistry.getNextAvailableRenderId();
	}
}