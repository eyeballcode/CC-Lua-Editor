package com.edward.lua;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.edward.bootstrap.MainFrame.MainGIFScreen;

public class OptionScreen extends JFrame {
	
	private static final long serialVersionUID = 1L;
	JButton back = null;

	private JButton done() {
		back = new JButton("Done!") {
			private static final long serialVersionUID = -3089163832904127158L;

			@Override
			public void setBorder(Border b) {
			}
		};
		back.setBackground(new Color(204, 76, 76));
		back.setOpaque(true);
		back.setForeground(Color.WHITE);
		back.setSize(new Dimension(100, 50));
		back.setLocation(108, 300);
		back.setFont(new Font("Minecraftia", Font.PLAIN, 17));
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				dispose();
				new MainGIFScreen(false);
			}
			
		});
		return back;
		
	}
	
	private JButton back() {
		back = new JButton("Bring me back") {
			private static final long serialVersionUID = -3089163832904127158L;

			@Override
			public void setBorder(Border b) {
			}
		};
		back.setBackground(new Color(204, 76, 76));
		back.setOpaque(true);
		back.setForeground(Color.WHITE);
		back.setSize(new Dimension(300, 50));
		back.setLocation(280, 300);
		back.setFont(new Font("Minecraftia", Font.PLAIN, 17));
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				dispose();
				new MainGIFScreen(false);
			}
			
		});
		return back;
		
	}
	private void setUpGUI() {
		setUndecorated(true);
		setContentPane(new JLabel(new ImageIcon(getClass().getResource(
				"ComBorder.png"))));
	}

	public OptionScreen() {
		setUpGUI();
		add(back());
		add(done());
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
