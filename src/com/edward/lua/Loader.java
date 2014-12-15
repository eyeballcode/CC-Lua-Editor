package com.edward.lua;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.edward.bootstrap.MainFrame.MainGIFScreen;
import com.edward.lua.editor.ProjectEditorScreen;
import com.edward.utils.EyeThrowableDealer;
import com.edward.utils.Utils;

public class Loader extends JFrame {
	JTextField tfPrivate = null;
	JTextField tf = null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton done, back = null;
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

	public Loader() {
		JButton done = done();
		setUpGUI();
		add(label());
		tf = tf();
		done.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String text = tf.getText();
				if (!text.trim().equals("")) {
					try {
					System.out.println("Project name is: " + text);
					Utils.checkFolderExists(Utils.workingDir + "Workspace/" + text);
					System.out.println("[INFO] " + new Date() + ": Opening folder: " + Utils.workingDir + "Workspace/" + text);
					dispose();
					new ProjectEditorScreen();
					} catch (Exception e1) {
						EyeThrowableDealer etd = new EyeThrowableDealer();
						etd.load(e1);
						etd.print();
						JOptionPane.showMessageDialog(new JFrame(),
							    "Project " + text + " does not exist!",
							    "ERROR",
							    JOptionPane.ERROR_MESSAGE);
						tf.requestFocus();
					}
				} else {
					System.out.println("[ERROR] " + new Date() + ": Project name cannot be empty or be spaces!");
					JOptionPane.showMessageDialog(new JFrame(),
						    "Project name cannot be empty or be spaces!",
						    "ERROR",
						    JOptionPane.ERROR_MESSAGE);
					tf.requestFocus();
							try {
								throw new ProjectException("Project name cannot be empty or be spaces!");
							} catch (ProjectException e1) {
								EyeThrowableDealer etd = new EyeThrowableDealer();
								etd.load(e1);
								etd.print();
							}
					tf.setText("");
					tf.requestFocus();
				}
			}
			});
		add(back());
		add(tf);
		add(done);
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
