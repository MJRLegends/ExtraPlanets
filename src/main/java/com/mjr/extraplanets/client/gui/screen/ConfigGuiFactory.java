package com.mjr.extraplanets.client.gui.screen;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.mjrlegendslib.client.gui.ConfigGuiFactoryBase;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.config.GuiConfig;

public class ConfigGuiFactory extends ConfigGuiFactoryBase {
	public static class ConfigGUI extends GuiConfig {
		public ConfigGUI(GuiScreen parent) {
			super(parent, Config.getConfigElements(), Constants.modID, false, true, Constants.modName);
		}
	}

	@Override
	public Class<? extends GuiScreen> mainConfigGuiClass() {
		return ConfigGUI.class;
	}
}