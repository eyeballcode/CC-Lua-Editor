package com.edward.lua.editor;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class MultiKeyPressListener implements KeyListener {

	private final Set<Integer> pressed = new HashSet<Integer>();

	@Override
	public synchronized void keyPressed(KeyEvent e) {
		pressed.add(e.getKeyCode());
		if (pressed.size() == 2) {
			Integer[] keys = pressed.toArray(new Integer[0]);
			
			if(keys[0] == KeyEvent.VK_CONTROL && keys[1] == KeyEvent.VK_S) {
				System.out.println("Ctrl+S");
			}
		}	
		if (pressed.size() == 2) {
			Integer[] keys = pressed.toArray(new Integer[0]);
			
			if(keys[0] == KeyEvent.VK_CONTROL && keys[1] == KeyEvent.VK_Q) {
				 new ProjectEditorScreen().destroy();
			}
		}
	}

	@Override
	public synchronized void keyReleased(KeyEvent e) {
		pressed.remove(e.getKeyChar());
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}