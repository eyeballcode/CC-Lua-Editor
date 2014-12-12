package com.edward.bootstrap.MainFrame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.edward.lua.Loader;
import com.edward.lua.NewProjectManager;
import com.edward.lua.OptionScreen;

public class MainGIFScreen extends JFrame {

	private static final long serialVersionUID = 8909753882658408770L;

	ImageIcon image = new ImageIcon();
	JFrame f = null;

	protected int pY;

	protected int pX;

	private JButton load() {

		JButton load = new JButton();
		load.setVisible(true);
		load.setIcon(new ImageIcon(getClass().getResource("load.png")));
		load.setSize(new Dimension(131, 52));
		load.setLocation(205, 95);
		load.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				new Loader();
			}

		});
		return load;
	}

	private JButton newP() {

		JButton newp = new JButton();
		newp.setVisible(true);
		newp.setIcon(new ImageIcon(getClass().getResource("new.png")));
		newp.setSize(new Dimension(117, 48));
		newp.setLocation(345, 96);
		newp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				new NewProjectManager();
			}

		});
		return newp;
	}

	private JButton op() {

		JButton op = new JButton();
		op.setVisible(true);
		op.setIcon(new ImageIcon(getClass().getResource("options.png")));
		op.setSize(new Dimension(131, 49));
		op.setLocation(204, 177);
		op.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				new OptionScreen();
			}

		});
		return op;
	}

	private JButton quit() {

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
		return quit;
	}

	public void animate() {

		JLabel l = new JLabel();
		ImageIcon i = new ImageIcon(getClass().getResource("Opening.gif"));
		l.setIcon(i);
		add(l);
	}

	public void menu() {
		f = new JFrame();
		f.setContentPane(new JLabel(new ImageIcon(getClass().getResource(
				"Menu.png"))));
		f.add(load());
		f.add(newP());
		f.add(op());
		f.add(quit());
		f.setUndecorated(true);
		f.setVisible(true);
		f.pack();
		f.setLocationRelativeTo(null);
		dispose();
	}

	public MainGIFScreen(boolean animate) {
		super("");
		if (animate) {
			animate();
			setUndecorated(true);
			pack();
			setLocationRelativeTo(null);
			setVisible(true);
			try {
				Thread.sleep(600);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			menu();
			pack();
		} else {
			menu();
		}

	}


}
