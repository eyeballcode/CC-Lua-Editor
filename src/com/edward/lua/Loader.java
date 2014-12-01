package com.edward.lua;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Loader extends JFrame {
	JTextField tf = null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Loader() {
		JButton done = new JButton("Done") {@Override public void setBorder(Border b) {}};
		done.setBackground(new Color(204, 76, 76));
		done.repaint();
		done.setOpaque(true);
		done.setForeground(Color.WHITE);
		done.setSize(new Dimension(100, 30));
		done.setLocation(400,  80);
		done.setFont(new Font("Minecraftia", Font.PLAIN, 17));
		tf = new JTextField() {
			private static final long serialVersionUID = 1L;
			@Override public void setBorder(Border border) {}
		};
		
		tf.setBackground(Color.BLACK);
		tf.setForeground(Color.WHITE);
		tf.setVisible(true);
		tf.setSize(new Dimension(305, 50));
		tf.setLocation(340, 21);
		tf.setFont(new Font("Minecraftia", Font.PLAIN, 17));
		done.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!tf.getText().equals("")) {
				System.out.println("Project name is: "+tf.getText());
				} else {
					System.out.println("Project name cannot be empty");
				}
			}
			
		});
		JLabel label = new JLabel("Please enter project name: ");
		label.setVisible(true);
		label.setForeground(Color.WHITE);
		label.setSize(new Dimension(500, 50));
		label.setLocation(25, 17);
		label.setFont(new Font("Minecraftia", Font.PLAIN, 17));
		setUndecorated(false);
		setContentPane(new JLabel(new ImageIcon(getClass().getResource(
				"ComBorder.png"))));
		add(label);	
		add(tf);
		add(done);
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
