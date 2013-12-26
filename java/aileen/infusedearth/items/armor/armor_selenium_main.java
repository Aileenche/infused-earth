package aileen.infusedearth.items.armor;

import java.util.List;

import aileen.infusedearth.infusedearth;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Icon;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class armor_selenium_main extends ItemArmor implements ISpecialArmor {

	private Icon[] icons;
	private int armorType;

	public armor_selenium_main(int itemID, EnumArmorMaterial material, int renderIndex, int armorType) {
		super(itemID, material, renderIndex, armorType);

		this.armorType = armorType;

		setMaxDamage(27);
		setMaxStackSize(1);
		setCreativeTab(infusedearth.ctab_items);
		setUnlocalizedName(infusedearth.SELENIUM_ARMOR_UNLOCALIZED_NAMES[armorType]);

		if (armorType == 3) { // Register EventBus on Boots
			MinecraftForge.EVENT_BUS.register(this);
		}
	}

	// Cancels Fall Damage Event if Boots are equiped
	@ForgeSubscribe
	public void onEntityLivingFallEvent(LivingFallEvent event) {
		if (event.entity instanceof EntityLivingBase) {
			EntityLivingBase entity = (EntityLivingBase) event.entity;
			ItemStack armor = entity.getCurrentItemOrArmor(1);

			if ((armor != null) && (armor.itemID == infusedearth.seleniumArmorBoots.itemID)) {
				int fallDamage = Math.max((int) event.distance - 3 - 7, 0);

				if (true) {
					// TODO: cancel event for now, later add discharge
					event.setCanceled(true);
				}
			}
		}
	}

	// TODO: Only combined Armor should cancel all the damage
	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot) {

		if ((source == DamageSource.fall) && (this.armorType == 3)) {
			int damageLimit = 500;

			return new ISpecialArmor.ArmorProperties(0, 1.1D, damageLimit);
		}

		if (source.isUnblockable()) {
			return new ISpecialArmor.ArmorProperties(0, 1.1D, 500);
		}
		// Cancel All Damage for now!
		return new ISpecialArmor.ArmorProperties(0, 1.1D, 500);

	}

	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
		return 21;
	}

	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {
		// TODO: Discharge Armor once implemented

	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		icons = new Icon[infusedearth.SELENIUM_ARMOR_ICONS.length];
		for (int i = 0; i < icons.length; i++) {
			icons[i] = register.registerIcon("infusedearth:" + infusedearth.SELENIUM_ARMOR_ICONS[i]);
		}
		itemIcon = icons[armorType];
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer) {
		int suffix = this.armorType == 2 ? 2 : 1;

		return "infusedearth:\\textures\\armor\\selenium_Armor_" + suffix + ".png";
	}

}
