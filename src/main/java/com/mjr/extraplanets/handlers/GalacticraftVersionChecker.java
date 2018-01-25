package com.mjr.extraplanets.handlers;

import java.lang.reflect.Method;

import micdoodle8.mods.galacticraft.core.dimension.WorldProviderMoon;

import com.mjr.extraplanets.Constants;
import com.mjr.mjrlegendslib.util.MessageUtilities;

public class GalacticraftVersionChecker {
	@SuppressWarnings("unused")
	public static void run() {
		try {
			Method m = WorldProviderMoon.class.getMethod("getSurfaceBlocks");
		} catch (NoSuchMethodException e) {
			MessageUtilities.fatalErrorMessageToLog(Constants.modID, "has detected you are using a version below the required minimum version of build #122, You can find it here https://micdoodle8.com/mods/galacticraft/downloads");
			MessageUtilities.errorMessageBox(Constants.modID, "Incompatable error",
					"has detected you are using a version below the required minimum version of build #122 </font><font Color=blue> <br> You can find it here https://micdoodle8.com/mods/galacticraft/downloads", 600, 600);
			MessageUtilities.throwCrashError(Constants.modName + ": has detected you are using a version below the required minimum version of build #122, You can find it here https://micdoodle8.com/mods/galacticraft/downloads");
		}
//		if (micdoodle8.mods.galacticraft.core.Constants.LOCALBUILDVERSION >= 119) {
//			MessageUtilities.infoMessageToLog(Constants.modID, "Correct Galacticraft Version Found!, " + Constants.modName + " has detected you are using the required minimum version or higher of Galacticraft!");
//		} else {
//			MessageUtilities.fatalErrorMessageToLog(Constants.modID, "has detected you are using a version below the required minimum version of build #119, You can find it here https://micdoodle8.com/mods/galacticraft/downloads");
//			MessageUtilities.errorMessageBox(Constants.modID, "Incompatable error",
//					"has detected you are using a version below the required minimum version of build #119 </font><font Color=blue> <br> You can find it here https://micdoodle8.com/mods/galacticraft/downloads", 600, 600);
//			MessageUtilities.throwCrashError(Constants.modName + ": has detected you are using a version below the required minimum version of build #119, You can find it here https://micdoodle8.com/mods/galacticraft/downloads");
//		}
	}
}
