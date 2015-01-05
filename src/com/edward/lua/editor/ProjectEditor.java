package com.edward.lua.editor;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Date;

import javax.swing.JTextPane;
import javax.swing.border.Border;

import com.edward.utils.EyeThrowableDealer;
import com.edward.utils.Utils;

public class ProjectEditor extends JTextPane {

	private static final long serialVersionUID = 4859236933649991436L;

	@Override
	public void setBorder(Border b) {

	}

	public ProjectEditor() {
		setOpaque(true);
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		setFont(new Font("Minecraftia", Font.PLAIN, 17));
		setSize(623, 354);
		setLocation(23, 21);
		addKeyListener(new ControlKeyLisener());
		addKeyListener(new KeyWordListener());
	}
	
	public boolean open(String fileName, String projectName) {
		try{
		setText("");
		fileName = Utils.workingDir + "Workspace/" + projectName + "/" + fileName;
		System.out.println("[INFO] " + new Date()
		+ ": Opening " + fileName + "!");
			String textRead = readStream(new FileInputStream(new File(fileName)));
		setText(textRead);
		} catch (FileNotFoundException e) {
			EyeThrowableDealer etd = new EyeThrowableDealer();
			etd.load(e);
			etd.print();
		}
		return true;
	}
	
	private static String readStream(InputStream is) {
	    StringBuilder sb = new StringBuilder(512);
	    try {
	        Reader r = new InputStreamReader(is, "UTF-8");
	        int c = 0;
	        while ((c = r.read()) != -1) {
	            sb.append((char) c);
	        }
	    } catch (IOException e) {
	        throw new RuntimeException(e);
	    }
	    return sb.toString();
	}


}