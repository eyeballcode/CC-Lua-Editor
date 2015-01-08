package com.edward.lua.editor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

public class ControlKeyLisener implements KeyListener {
	
	public ControlKeyLisener(String prjName) {
		
	}
	
	JFrame ctrlFrame = new JFrame();

	Socket socket = null;
	PrintWriter out = null;

	private void setUpGUI() {
		ctrlFrame.setUndecorated(true);
		ctrlFrame.setContentPane(new JLabel(new ImageIcon(getClass().getResource(
				"PocketComBorder.png"))));
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
			setUpGUI();
			ctrlFrame.add(pastebinButton());
			ctrlFrame.add(saveButton());
			ctrlFrame.setAlwaysOnTop(true);
			ctrlFrame.pack();
			ctrlFrame.setVisible(true);
			ctrlFrame.setLocationRelativeTo(null);
		}
	}

	private JButton pastebinButton() {
		JButton b = new JButton("Push to pastebin.com") {

			private static final long serialVersionUID = -6854946250009631166L;

			public void setBorder(Border b) {}
		};
		b.setBackground(new Color(204, 76, 76));
		b.setOpaque(true);
		b.setForeground(Color.WHITE);
		b.setSize(new Dimension(300, 30));
		b.setLocation(35, 23);
		b.setFont(new Font("Minecraftia", Font.PLAIN, 17));
		return b;
	}
	

	private JButton saveButton() {
		JButton b = new JButton("Save File") {

			private static final long serialVersionUID = 7920731056949257626L;

			public void setBorder(Border b) {}
		};
		b.setBackground(new Color(204, 76, 76));
		b.setOpaque(true);
		b.setForeground(Color.WHITE);
		b.setSize(new Dimension(300, 30));
		b.setLocation(35, 68);
		b.setFont(new Font("Minecraftia", Font.PLAIN, 17));
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(new JFrame(), "Save to file ");
			}
			
		});
		return b;
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
