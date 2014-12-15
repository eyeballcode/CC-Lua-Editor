package com.edward.lua;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

import com.edward.utils.Utils;

public class BootstrapScreen {
	JFrame f = null;

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
		if (!new File(Utils.workingDir)
				.exists()) {
			f = new JFrame("Font check");

			new File(Utils.workingDir)
					.mkdirs();
			System.out.println("[WARN] " + new Date() + ": Folder "
					+ Utils.workingDir);
			System.out.println("[INFO] " + new Date() + ": Generating "
					+ Utils.workingDir + "!");
			JButton y = new JButton("Yes");
			JButton n = new JButton("No");
			y.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					f.dispose();
				}

			});
			n.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					f.dispose();
					JOptionPane.showMessageDialog(f, "Go to options, then click \"Download Minecraftia font\".");
				}

			});
			JLabel text = new JLabel("Right is Test, Left is image. Match? ");
			JLabel l = new JLabel("Test");
			JLabel l1 = new JLabel();
			l1.setIcon(new ImageIcon(getClass().getResource("test.png")));
			l.setFont(new Font("Minecraftia", Font.PLAIN, 15));
			f.setLayout(new FlowLayout());
			f.setAlwaysOnTop(true);
			f.add(text);
			f.add(l1);
			f.add(l);
			f.add(y);
			f.add(n);
			f.pack();
			f.setLocationRelativeTo(null);
			f.setVisible(true);
		}

		if (!new File(Utils.workingDir + "options.txt").exists()) {
			Utils.createFile(Utils.workingDir + "options.txt");

			System.out.println("[WARN] " + new Date()
					+ ": Options.txt not found!");
			System.out.println("[INFO] " + new Date()
					+ ": Generating options.txt!");
			Utils.createFile(Utils.workingDir + "options.txt");
		}

		return true;
	}

}
