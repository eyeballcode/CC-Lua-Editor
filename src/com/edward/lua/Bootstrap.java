package com.edward.lua;

import java.util.Date;

import com.edward.bootstrap.MainFrame.MainGIFScreen;
import com.edward.utils.Utils;

public class Bootstrap {
	static String verID = "1.0.0";

	public static void main(String[] args) {
		System.out.println("[INFO] " + new Date() + ": CCLua " + verID
				+ " started on " + System.getProperty("os.name") + "...");
		System.out.println("[INFO] " + new Date()
		+ ": System.getProperty(\"os.name\") == \""
		+ System.getProperty("os.name") + "\"");
		System.out.println("[INFO] " + new Date()
		+ ": System.getProperty(\"os.arch\") == \""
		+ System.getProperty("os.arch") + "\"");
		System.out.println("[INFO] " + new Date()
		+ ": System.getProperty(\"os.version\") == \""
		+ System.getProperty("os.version") + "\"");
		System.out.println("[INFO] " + new Date()
		+ ": System.getProperty(\"java.version\") == \""
		+ System.getProperty("java.version") + "\"");
		System.out.println("[INFO] " + new Date()
		+ ": System.getProperty(\"java.vendor\") == \""
		+ System.getProperty("java.vendor") + "\"");
		System.out.println("[INFO] " + new Date()
		+ ": System.getProperty(\"sun.arch.data.model\") == \""
		+ System.getProperty("sun.arch.data.model") + "\"");
		System.out.println("[INFO] " + new Date() + ": Util.getPID() == \""
				+ Utils.getPID() + "\"");
		System.out.println("[INFO] " + new Date() + ": Checking Java version!");
		if (Utils.checkjVersion(6)) {
			System.out.println("[INFO] " + new Date() + ": Java version good!");
			new BootstrapScreen();
			new MainGIFScreen(true);
		}
	}
}