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

public class NewProjectManager extends JFrame {
	JTextField tfPrivate = null;
	JTextField tf = null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton done = null;
	JLabel label = null;

	private JButton done() {
		done = new JButton("Done") {
			private static final long serialVersionUID = -3089163832904127158L;

			@Override
			public void setBorder(Border b) {
			}
		};
		done.setBackground(new Color(204, 76, 76));
		done.setOpaque(true);
		done.setForeground(Color.WHITE);
		done.setSize(new Dimension(100, 30));
		done.setLocation(400, 80);
		done.setFont(new Font("Minecraftia", Font.PLAIN, 17));
		return done;
	}

	private JTextField tf() {

		tfPrivate = new JTextField() {
			private static final long serialVersionUID = 1L;
			
			@Override
			public void setBorder(Border b) {
				
			}
			
		};

		tfPrivate.setBackground(Color.BLACK);
		tfPrivate.setForeground(Color.WHITE);
		tfPrivate.setVisible(true);
		tfPrivate.setSize(new Dimension(305, 50));
		tfPrivate.setLocation(340, 21);
		tfPrivate.setFont(new Font("Minecraftia", Font.PLAIN, 17));
		return tfPrivate;
	}

	private JLabel label() {
		label = new JLabel("Please enter project name: ");
		label.setVisible(true);
		label.setForeground(Color.WHITE);
		label.setSize(new Dimension(500, 50));
		label.setLocation(25, 17);
		label.setFont(new Font("Minecraftia", Font.PLAIN, 17));
		return label;
	}
	private void setUpGUI() {

		setUndecorated(false);
		setContentPane(new JLabel(new ImageIcon(getClass().getResource(
				"ComBorder.png"))));
	}

	public NewProjectManager() {
		JButton done = done();
		setUpGUI();
		add(label());
		tf = tf();
		done.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String text = tf.getText();
				if (!text.trim().equals("")) {
					System.out.println("Project name is: " + text);
				} else {
					System.out.println("Project name cannot be empty or be spaces");
					tf.setText("");
					tf.requestFocus();
				}
			}

		});
		add(tf);
		add(done);
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
