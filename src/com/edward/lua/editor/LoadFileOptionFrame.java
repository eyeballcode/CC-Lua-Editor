package com.edward.lua.editor;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.edward.lua.ProjectException;
import com.edward.utils.EyeThrowableDealer;
import com.edward.utils.Utils;

public class LoadFileOptionFrame extends JFrame {

	private JTextField tf = fileName();

	private String prjName;

	private static final long serialVersionUID = -4553059206223841886L;

	private JLabel newFile() {
		JLabel b = new JLabel("File name: ") {

			private static final long serialVersionUID = 1823200263505489039L;

			public void setBorder(Border b) {
			}
		};

		b.setBackground(new Color(204, 76, 76));
		b.setBackground(Color.BLACK);
		b.setOpaque(true);
		b.setForeground(Color.WHITE);
		b.setSize(new Dimension(300, 50));
		b.setLocation(22, 22);
		b.setFont(new Font("Minecraftia", Font.PLAIN, 14));
		return b;
	}

	private JTextField fileName() {
		JTextField b = new JTextField("") {

			private static final long serialVersionUID = 1823200263505489039L;

			public void setBorder(Border b) {
			}
		};

		b.setBackground(Color.BLACK);
		b.setOpaque(true);
		b.setForeground(Color.WHITE);
		b.setSize(new Dimension(224, 50));
		b.setLocation(120, 22);
		b.setFont(new Font("Minecraftia", Font.PLAIN, 14));
		return b;
	}

	private JButton done() {
		JButton b = new JButton("Done!") {

			private static final long serialVersionUID = 1823200263505489039L;

			public void setBorder(Border b) {
			}
		};

		b.setBackground(new Color(204, 76, 76));
		b.setOpaque(true);
		b.setForeground(Color.WHITE);
		b.setSize(new Dimension(300, 50));
		b.setLocation(37, 340);
		b.setFont(new Font("Minecraftia", Font.PLAIN, 17));
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String text = tf.getText();

				if (text.trim().equals("")) {
					System.out.println("[ERROR] " + new Date()
							+ ": File name cannot be empty or be spaces!");
					JOptionPane.showMessageDialog(new JFrame(),
							"File name cannot be empty or be spaces!",
							"ERROR", JOptionPane.ERROR_MESSAGE);
					try {
						throw new ProjectException(
								"File name cannot be empty or be spaces!");
					} catch (ProjectException e1) {
						EyeThrowableDealer etd = new EyeThrowableDealer();
						etd.load(e1);
						etd.print();
					}
					tf.setText("");
					tf.requestFocus();
				} else {
					boolean shouldNotComplain = new File(Utils.workingDir + "Workspace/" + prjName +"/" +  text).exists();
					System.out.println(shouldNotComplain);
					if(shouldNotComplain) {
						System.out.println("[ERROR] " + new Date()
								+ ": Opening " + text);
				setVisible(false);
				System.out.println(prjName);
				ProjectEditorScreen.tp.open(prjName, text);
				new ProjectEditorScreen().setOppositeVisible();
				
					} else {
						System.out.println("[ERROR] " + new Date()
						+ ": File " + text +" does not exist!");
				JOptionPane.showMessageDialog(new JFrame(),
						"File " + text +" does not exist!",
						"ERROR", JOptionPane.ERROR_MESSAGE);
				tf.requestFocus();
				try {
					throw new ProjectException(
							"File " + text +" does not exist!");
				} catch (ProjectException e1) {
					EyeThrowableDealer etd = new EyeThrowableDealer();
					etd.load(e1);
					etd.print();
				}
						
					}
				}
			}

		});
		return b;
	}

	private void setUpGUI() {
		setUndecorated(true);
		setContentPane(new JLabel(new ImageIcon(getClass().getResource(
				"PocketComBorder.png"))));
	}

	public LoadFileOptionFrame(String prjName) {
		this.prjName = prjName;
		setUpGUI();
		add(newFile());
		add(tf);
		add(done());
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
	}

}
