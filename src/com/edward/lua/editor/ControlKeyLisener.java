package com.edward.lua.editor;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.PrintWriter;
import java.net.Socket;

import com.edward.utils.EyeThrowableDealer;

public class ControlKeyLisener implements KeyListener {
	
		Socket socket = null;
		PrintWriter out = null;

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
			System.out.println("Control! Yay!");
			ProjectEditorScreen.shouldBreak = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
