package com.edward.lua.editor;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import com.edward.utils.EyeThrowableDealer;

public class ProjectEditorScreen extends JFrame {
	

	private static final long serialVersionUID = 8935429240415542618L;

	private JTextArea ta = new JTextArea() {

		private static final long serialVersionUID = -6844411656911961723L;

		public void setBorder(Border b) {

		}
	};

	private JTextArea getEditorField() {
		ta.addKeyListener(new ControlKeyLisener());
		ta.setOpaque(true);
		ta.setBackground(Color.BLACK);
		ta.setForeground(Color.WHITE);
		ta.setFont(new Font("Minecraftia", Font.PLAIN, 17));
		ta.setSize(623, 354);
		ta.setLocation(23, 21);
		return ta;
	}


	public ProjectEditorScreen() {
		try {
			JTextArea temp = getEditorField();
			JScrollPane s = new JScrollPane(temp);
			setUpGUI();
			add(temp);
			add(s);
			pack();
			setVisible(true);
			setLocationRelativeTo(null);
		} catch (Exception e) {
			EyeThrowableDealer etd = new EyeThrowableDealer();
			etd.load(e);
			etd.print();
		}
	}

	private void setUpGUI() {
		setUndecorated(true);
		setContentPane(new JLabel(new ImageIcon(getClass().getResource(
				"ComBorder.png"))));
	}
}
