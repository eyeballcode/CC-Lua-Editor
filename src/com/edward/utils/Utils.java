package com.edward.utils;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.URI;

import javax.swing.ImageIcon;

public class Utils {

	private static String jvmName;
	private static int fallback;
	
	public static void createFile(String path) {
		File f = new File(path);
		try {
			FileWriter fw = new FileWriter(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static int getPID() {
		jvmName = ManagementFactory.getRuntimeMXBean().getName();
		final int index = jvmName.indexOf('@');
		if (index < 1) {
			// part before '@' empty (index = 0) / '@' not found (index = -1)
			
			return fallback;
		}

		try {
			fallback = Integer.parseInt(jvmName.substring(0, index));
			
			return fallback;
		} catch (NumberFormatException e) {
			// ignore
		}
		
		return fallback;
	}

	public static boolean checkjVersion(int ver) {
		String jVersion = System.getProperty("java.version");
		String jv = "" + jVersion.charAt(2);
		int i = Integer.parseInt(jv);

		return i >= ver;
	}

	public static void openLink(URI paramURI) {
		try {
			Desktop d = Desktop.getDesktop();
			d.browse(paramURI);
		} catch (Throwable localThrowable) {
			System.out.println("Failed to open link " + paramURI.toString());
		}
		
	}

	public ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	public static void writeToFile(File path, String text) {
		try {
			FileWriter fw = new FileWriter(path);
			fw.write(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
