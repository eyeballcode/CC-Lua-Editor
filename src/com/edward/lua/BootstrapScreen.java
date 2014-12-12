package com.edward.lua;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

import com.edward.utils.Utils;

public class BootstrapScreen {
	public BootstrapScreen() {
		try {
			JFrame f = new JFrame();
			f.setUndecorated(true);

			JProgressBar bar = new JProgressBar();
			bar.setLocation(150, 328);
			bar.setPreferredSize(new Dimension(371, 19));
			bar.setValue(0);
			bar.setVisible(true);
			bar.setBackground(Color.WHITE);
			bar.setForeground(Color.BLACK);
			f.add(bar);
			f.setVisible(true);
			f.pack();
			f.setLocationRelativeTo(null);
			checkOpFileExists();
			bar.setValue(100);
			f.dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean checkOpFileExists() {
		if (!new File(System.getProperty("user.home") + "/luaprojects/")
				.exists()) {
			new File(System.getProperty("user.home") + "/luaprojects/")
					.mkdirs();
			System.out.println("[WARN] " + new Date() + ": Folder "
					+ System.getProperty("user.home")
					+ "/luaprojects/ does not exists!");
			System.out.println("[INFO] " + new Date() + ": Generating "
					+ System.getProperty("user.home") + "/luaprojects/" + "!");
		}

		if (!new File(System.getProperty("user.home")
				+ "/luaprojects/options.txt").exists()) {
			Utils.createFile(System.getProperty("user.home")
					+ "/luaprojects/options.txt");

			try {

				System.out.println("[WARN] " + new Date()
						+ ": Options.txt not found!");
				System.out.println("[INFO] " + new Date()
						+ ": Generating options.txt!");
				FileWriter fw = new FileWriter((new File(
						System.getProperty("user.home")
								+ "/luaprojects/options.txt")));
				fw.write("user.hasVerifiedFont=0");
				fw.close();
			} catch (IOException e) {
				System.out.println("[ERROR] " + new Date()
						+ ": Cannot make options.txt!");
				System.exit(1);
			}
		}

		return true;
	}

}
