package com.mjr.extraplanets.handlers;

import java.lang.reflect.Method;

import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.util.MessageUtilities;

public class GalacticraftVersionChecker {
	@SuppressWarnings("unused")
	public static void run() {
		try {
			Method m = GCCoreUtil.class.getMethod("isDeobfuscated");
		} catch (NoSuchMethodException e) {
			MessageUtilities.fatalErrorMessageToLog(Constants.modName + ": has detected you are using a version below the required minimum version of build #493, You can find it here https://ci.micdoodle8.com/job/Galacticraft-1.7/");
			MessageUtilities.errorMessageBox("Incompatable error",
					"has detected you are using a version below the required minimum version of build #493 </font><font Color=blue> <br> You can find it here https://ci.micdoodle8.com/job/Galacticraft-1.7/", 600, 600);
			MessageUtilities.throwCrashError(Constants.modName + ": has detected you are using a version below the required minimum version of build #493, You can find it here https://ci.micdoodle8.com/job/Galacticraft-1.7/");
		}
	}
}
