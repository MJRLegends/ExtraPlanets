package com.mjr.extraplanets.handlers;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mjr.extraplanets.Constants;

public class GalacticraftVersionChecker {
	public static void run() {
		Logger log = LogManager.getLogger();
		if (micdoodle8.mods.galacticraft.core.Constants.LOCALBUILDVERSION >= 119)
			log.info(Constants.modName + ": Correct Galacticraft Version Found!, " + Constants.modName + " has detected you are using the required minimum version or higher of Galacticraft!");
		else{
			log.fatal(Constants.modName + ": has detected you are using a version below the required minimum version of build #119, You can find it here https://micdoodle8.com/mods/galacticraft/downloads");
			JFrame frame = new JFrame();
			frame.setSize(600, 600);
			JOptionPane.showMessageDialog(frame, "<html><center><p><h3><font Color=red>" + Constants.modName
					+ " has detected you are using a version below the required minimum version of build #119 </font><font Color=blue> <br> You can find it here https://micdoodle8.com/mods/galacticraft/downloads", "Incompatable error", 0);
			frame.setFocusable(true);
			throw new RuntimeException(Constants.modName + ": has detected you are using a version below the required minimum version of build #119, You can find it here https://micdoodle8.com/mods/galacticraft/downloads");
		}
	}
}
