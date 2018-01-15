package com.mjr.extraplanets.client.gui.screen;

import java.util.Set;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.GuiConfig;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;

public class ConfigGuiFactory implements IModGuiFactory
{
    public static class ConfigGUI extends GuiConfig
    {
        public ConfigGUI(GuiScreen parent)
        {
            super(parent, Config.getConfigElements(), Constants.modID, false, true, Constants.modName);
        }
    }

    @Override
    public void initialize(Minecraft minecraftInstance)
    {
    }

    @Override
    public Class<? extends GuiScreen> mainConfigGuiClass()
    {
        return ConfigGUI.class;
    }

    @Override
    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories()
    {
        return null;
    }

    @Override
    public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element)
    {
        return null;
    }
}