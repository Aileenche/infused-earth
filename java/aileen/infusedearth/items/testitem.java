package aileen.infusedearth.items;

import aileen.infusedearth.infusedearth;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.World;

public class testitem extends Item {

	public testitem(int par1) {
		super(par1);
		setCreativeTab(infusedearth.ctab_items);
		setMaxStackSize(1);
		// TODO Auto-generated constructor stub
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.itemIcon = reg.registerIcon("infusedearth:testitem");
	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {

		// if (par3EntityPlayer.capabilities.isCreativeMode) {
		//
		// par3EntityPlayer.addChatMessage(""+(MathHelper.floor_double((double)((par3EntityPlayer.rotationYaw
		// if (mc.objectMouseOver != null) {
		// int x = mc.objectMouseOver.blockX;
		// int y = mc.objectMouseOver.blockY;
		// int z = mc.objectMouseOver.blockZ;
		// int blockId = par2World.getBlockId(x, y, z);
		// Block target = Block.blocksList[blockId];
		// if (target != null) {
		//
		// par3EntityPlayer.addChatMessage("" );
		// }
		//
		// }
		// }
		if (par3EntityPlayer.isSneaking()) {
			par2World.setWorldTime(0);
			par2World.toggleRain();
		} else {
			if (par3EntityPlayer.capabilities.isCreativeMode) {
				par3EntityPlayer.setGameType(EnumGameType.SURVIVAL);
			} else {
				par3EntityPlayer.setGameType(EnumGameType.CREATIVE);
			}
		}
		return par1ItemStack;
	}
}
