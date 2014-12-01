package com.edward.lua;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Window;
import java.lang.reflect.Method;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Loader extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static boolean isMacOSX() {
        return System.getProperty("os.name").indexOf("Mac OS X") >= 0;
    }
	public static void enableFullScreenMode(Window window) {
        String className = "com.apple.eawt.FullScreenUtilities";
        String methodName = "setWindowCanFullScreen";
 
        try {
            Class<?> clazz = Class.forName(className);
            Method method = clazz.getMethod(methodName, new Class<?>[] {
                    Window.class, boolean.class });
            method.invoke(null, window, true);
        } catch (Throwable t) {
            System.err.println("Full screen mode is not supported");
            t.printStackTrace();
        }
    }

	public Loader() {
		 if (isMacOSX()) {
	            enableFullScreenMode(this);
	        }
		setLayout(new FlowLayout());
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		JLabel l = new JLabel("Please enter project name: ");
		l.setForeground(Color.WHITE);
		l.setBackground(Color.BLACK);
		l.setLocation(1, 1);
		setContentPane(new JLabel(new ImageIcon(getClass().getResource(
				"ComBorder.png"))));
		add(l);
		setVisible(true);
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
