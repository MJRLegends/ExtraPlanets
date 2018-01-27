package com.mjr.extraplanets.handlers;

import com.mjr.extraplanets.Constants;
import com.mjr.mjrlegendslib.util.MessageUtilities;

public class GalacticraftVersionChecker {
	@SuppressWarnings("unused")
	public static void run() {
		if (micdoodle8.mods.galacticraft.core.Constants.LOCALBUILDVERSION >= 128 || micdoodle8.mods.galacticraft.core.Constants.LOCALBUILDVERSION >= -1) {
			MessageUtilities.infoMessageToLog(Constants.modID, "Correct Galacticraft Version Found!, " + Constants.modName + " has detected you are using the required minimum version or higher of Galacticraft!");
		} else {
			MessageUtilities.fatalErrorMessageToLog(Constants.modID, "has detected you are using a version below the required minimum version of build #128, You can find it here https://micdoodle8.com/mods/galacticraft/downloads");
			MessageUtilities.errorMessageBox(Constants.modID, "Incompatable error",
					"has detected you are using a version below the required minimum version of build #128 </font><font Color=blue> <br> You can find it here https://micdoodle8.com/mods/galacticraft/downloads", 600, 600);
			MessageUtilities.throwCrashError(Constants.modName + ": has detected you are using a version below the required minimum version of build #128, You can find it here https://micdoodle8.com/mods/galacticraft/downloads");
		}
	}
}
