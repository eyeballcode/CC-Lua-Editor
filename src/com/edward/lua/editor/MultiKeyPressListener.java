package com.edward.lua.editor;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class MultiKeyPressListener implements KeyListener {

    private final Set<Character> pressed = new HashSet<Character>();
    
    @Override
    public synchronized void keyPressed(KeyEvent e) {
        pressed.add(e.getKeyChar());
        if (pressed.size() > 1) {
        	for (int i = 0; i < pressed.size(); i++) {
        		System.out.println(pressed.toArray()[i]);
        	}
        }
    }

    @Override
    public synchronized void keyReleased(KeyEvent e) {
        pressed.remove(e.getKeyChar());
    }

    @Override
    public void keyTyped(KeyEvent e) {}

}