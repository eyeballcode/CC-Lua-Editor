package com.edward.lua.editor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import com.edward.utils.EyeThrowableDealer;

public class ProjectEditorScreen extends JFrame {
	

	private static final long serialVersionUID = 8935429240415542618L;

	public static ProjectEditor tp = new ProjectEditor();
	
	public void setOppositeVisible() {
		setVisible(!isVisible());
	}
	
	public ProjectEditorScreen() {
		try {
			JScrollPane s = new JScrollPane(tp);
			setUpGUI();
			add(tp);
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
	
	public void hide() {
		
	}

	private void setUpGUI() {
		setUndecorated(true);
		setContentPane(new JLabel(new ImageIcon(getClass().getResource(
				"ComBorder.png"))));
	}
	
	public void destroy() {
		dispose();
		setVisible(true);
	}
}
