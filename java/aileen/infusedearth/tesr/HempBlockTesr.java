package aileen.infusedearth.tesr;

import aileen.infusedearth.tileentity.TileHempBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

/**
 * Created by Aileen on 31.12.13.
 */
public class HempBlockTesr extends TileEntitySpecialRenderer{
    private IModelCustom myModel;
    private ResourceLocation myTexture;

    public HempBlockTesr(){
        myModel = AdvancedModelLoader.loadModel("/assets/infusedearth/textures/customRenderer/block.obj");
        myTexture = new ResourceLocation("infusedearth", "textures/customRenderer/HempBlock.png");
    }


    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f){
        GL11.glPushMatrix();
        GL11.glTranslated(x, y, z + 1.0F);


        TileHempBlock te = null;

        if(tileEntity instanceof TileHempBlock){
            //FMLLog.getLogger().info("Found Tileentity for TESR Transforming!");
            te = (TileHempBlock) tileEntity;
        }
        if(te != null){
            GL11.glScaled(1,te.getscaleY(),1);
        }
        Minecraft.getMinecraft().renderEngine.bindTexture(myTexture);
        myModel.renderAll();
        GL11.glPopMatrix();
    }
}
