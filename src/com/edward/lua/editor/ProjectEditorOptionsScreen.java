package com.edward.lua.editor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class ProjectEditorOptionsScreen extends JFrame {
	
	String projectName = "";

	private static final long serialVersionUID = -4553059206223841886L;

	private JButton newFile() {
		JButton b = new JButton("New File") {

			private static final long serialVersionUID = 1823200263505489039L;

			public void setBorder(Border b) {
			}
		};
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new NewFileOptionFrame(projectName);
			}

		});

		b.setBackground(new Color(204, 76, 76));
		b.setOpaque(true);
		b.setForeground(Color.WHITE);
		b.setSize(new Dimension(300, 50));
		b.setLocation(37, 21);
		b.setFont(new Font("Minecraftia", Font.PLAIN, 17));
		return b;
	}
	
	private JButton loadFile() {
		JButton b = new JButton("Load File") {

			private static final long serialVersionUID = 1823200263505489039L;

			public void setBorder(Border b) {
			}
		};
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoadFileOptionFrame(projectName);
			}

		});

		b.setBackground(new Color(204, 76, 76));
		b.setOpaque(true);
		b.setForeground(Color.WHITE);
		b.setSize(new Dimension(300, 50));
		b.setLocation(37, 86);
		b.setFont(new Font("Minecraftia", Font.PLAIN, 17));
		return b;
	}

	private void setUpGUI() {
		setUndecorated(true);
		setContentPane(new JLabel(new ImageIcon(getClass().getResource(
				"PocketComBorder.png"))));
	}

	public ProjectEditorOptionsScreen(String projectName) {
		this.projectName = projectName;
		setUpGUI();
		add(newFile());
		add(loadFile());
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
	}

}
