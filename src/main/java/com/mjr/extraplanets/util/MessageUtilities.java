package com.mjr.extraplanets.util;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mjr.extraplanets.Constants;

public class MessageUtilities {

	private static Logger log = LogManager.getLogger();

	public static void throwCrashError(String message) {
		throw new RuntimeException(message);
	}

	public static void errorMessageToLog(String error) {
		log.error(Constants.modName + ": " + error);
	}

	public static void infoMessageToLog(String error) {
		log.info(Constants.modName + ": " + error);
	}

	public static void fatalErrorMessageToLog(String error) {
		log.fatal(Constants.modName + ": " + error);
	}

	public static void warnErrorMessageToLog(String error) {
		log.warn(Constants.modName + ": " + error);
	}

	public static void debugMessageToLog(String error) {
		infoMessageToLog(error);
	}

	public static void errorMessageBox(String errorType, String errorMessage, int width, int height) {
		JFrame frame = new JFrame();
		frame.setSize(width, height);
		JOptionPane.showMessageDialog(frame, "<html><center><p><h3><font Color=red>" + Constants.modName + " " + errorMessage, errorType, 0);
		frame.setFocusable(true);

	}
}
