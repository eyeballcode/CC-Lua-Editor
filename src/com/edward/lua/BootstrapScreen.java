package com.edward.lua;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

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
			for (int i = 0; i < 150; i++) {
				System.out.println(i);
				bar.setValue(i);
				Thread.sleep(1);
			}
			f.dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
