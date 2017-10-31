package com.mjr.extraplanets.handlers;

import java.lang.reflect.Method;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mjr.extraplanets.Constants;

public class GalacticraftVersionChecker {
	@SuppressWarnings("unused")
	public static void run() {
		try {
			Method m = GCCoreUtil.class.getMethod("isDeobfuscated");
		} catch (NoSuchMethodException e) {
			Logger log = LogManager.getLogger();
			log.fatal(Constants.modName + ": has detected you are using a version below the required minimum version of build #493, You can find it here https://ci.micdoodle8.com/job/Galacticraft-1.7/");
			JFrame frame = new JFrame();
			frame.setSize(600, 600);
			JOptionPane.showMessageDialog(frame, "<html><center><p><h3><font Color=red>" + Constants.modName
					+ " has detected you are using a version below the required minimum version of build #493 </font><font Color=blue> <br> You can find it here https://ci.micdoodle8.com/job/Galacticraft-1.7/", "Incompatable error", 0);
			frame.setFocusable(true);
			throw new RuntimeException(Constants.modName + ": has detected you are using a version below the required minimum version of build #493, You can find it here https://ci.micdoodle8.com/job/Galacticraft-1.7/");
		}
	}
}
