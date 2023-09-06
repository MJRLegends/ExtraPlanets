package com.mjr.extraplanets.compatibility.MMPowersuitsModules;

import com.mjr.extraplanets.items.ExtraPlanets_Items;

import net.machinemuse.numina.common.module.EnumModuleCategory;
import net.machinemuse.numina.common.module.EnumModuleTarget;
import net.machinemuse.powersuits.common.base.ModuleManager;
import net.machinemuse.powersuits.common.powermodule.PowerModuleBase;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Optional;

@Optional.Interface(modid = "powersuits", iface = "net.machinemuse.numina.common.module.IPowerModule")
public class PressureModule extends PowerModuleBase {

	public int tier;

	public PressureModule(int tier) {
		super(EnumModuleTarget.ARMORONLY);
		this.tier = tier;
		if (tier == 1)
			ModuleManager.INSTANCE.addInstallCost(getDataName(), new ItemStack(ExtraPlanets_Items.TIER_1_PRESSURE_LAYER, 3));
		else if (tier == 2)
			ModuleManager.INSTANCE.addInstallCost(getDataName(), new ItemStack(ExtraPlanets_Items.TIER_2_PRESSURE_LAYER, 3));
		else if (tier == 3)
			ModuleManager.INSTANCE.addInstallCost(getDataName(), new ItemStack(ExtraPlanets_Items.TIER_3_PRESSURE_LAYER, 3));
		else if (tier == 4)
			ModuleManager.INSTANCE.addInstallCost(getDataName(), new ItemStack(ExtraPlanets_Items.TIER_4_PRESSURE_LAYER, 3));
	}

	@Override
	public EnumModuleCategory getCategory() {
		return EnumModuleCategory.CATEGORY_ENVIRONMENTAL;
	}

	@Override
	public String getDataName() {
		return "pressure_module_" + tier;
	}

	@Override
	public TextureAtlasSprite getIcon(ItemStack item) {
		if (tier == 1)
			return ModuleIcons.pressureModule1;
		else if (tier == 2)
			return ModuleIcons.pressureModule2;
		else if (tier == 3)
			return ModuleIcons.pressureModule3;
		else if (tier == 4)
			return ModuleIcons.pressureModule4;
		return null;
	}

	@Override
	public String getUnlocalizedName() {
		return "module.pressure_module_" + tier;
	}
}
