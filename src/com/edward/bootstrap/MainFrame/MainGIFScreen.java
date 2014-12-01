package com.edward.bootstrap.MainFrame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.edward.lua.Loader;
import com.edward.lua.NewProjectManager;

public class MainGIFScreen extends JFrame {

	private static final long serialVersionUID = 8909753882658408770L;

	ImageIcon image = new ImageIcon();

	public MainGIFScreen() {
		super("");
		try {
			JButton load = new JButton();
			load.setVisible(true);
			load.setIcon(new ImageIcon(getClass().getResource("load.png")));
			load.setSize(new Dimension(131, 52));
			load.setLocation(205, 95);
			load.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					new Loader();
				}

			});

			JButton newp = new JButton();
			newp.setVisible(true);
			newp.setIcon(new ImageIcon(getClass().getResource("new.png")));
			newp.setSize(new Dimension(117, 48));
			newp.setLocation(345, 96);
			newp.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					new NewProjectManager();
				}

			});
			JButton op = new JButton();
			op.setVisible(true);
			op.setIcon(new ImageIcon(getClass().getResource("options.png")));
			op.setSize(new Dimension(131, 49));
			op.setLocation(204, 177);
			op.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("options");
				}

			});
			JButton quit = new JButton();
			quit.setVisible(true);
			quit.setIcon(new ImageIcon(getClass().getResource("quit.png")));
			quit.setSize(new Dimension(121, 50));
			quit.setLocation(346, 178);
			quit.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}

			});
			JLabel l = new JLabel();
			ImageIcon i = new ImageIcon(getClass().getResource("Opening.gif"));
			l.setIcon(i);
			add(l);
			setUndecorated(true);
			pack();
			setLocationRelativeTo(null);
			setVisible(true);
			Thread.sleep(580);
			setContentPane(new JLabel(new ImageIcon(getClass().getResource(
					"Menu.png"))));
			add(load);
			add(newp);
			add(op);
			add(quit);
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
