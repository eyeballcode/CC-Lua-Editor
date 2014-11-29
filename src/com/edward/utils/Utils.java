package com.edward.utils;

import java.lang.management.ManagementFactory;
import java.net.URI;

import javax.swing.ImageIcon;

public class Utils {
	
	private static String jvmName;
	private static int fallback;
	
	public static int getPID() {
	    jvmName = ManagementFactory.getRuntimeMXBean().getName();
	    final int index = jvmName.indexOf('@');
	    if (index < 1) {
	        // part before '@' empty (index = 0) / '@' not found (index = -1)
	        System.gc();
	        return fallback;
	    }

	    try {
	    	String s = Long.toString(Long.parseLong(jvmName.substring(0, index)));
	        fallback = Integer.parseInt(s);
	        System.gc();
	        return fallback;
	    } catch (NumberFormatException e) {
	        // ignore
	    }
        System.gc();
	    return fallback;
		}
		public static boolean checkjVersion(int ver) {
			String jVersion = System.getProperty("java.version");
			String jv = ""+jVersion.charAt(2);
			int i = Integer.parseInt(jv);
			
			return i >= ver;
		}
	 public static void openLink(URI paramURI) {
		 try {
			 Object localObject = Class.forName("java.awt.Desktop").getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
			 localObject.getClass().getMethod("browse", new Class[] { URI.class }).invoke(localObject, new Object[] { paramURI });
		 } catch (Throwable localThrowable) {
			 System.out.println("Failed to open link " + paramURI.toString());
		 }
	        System.gc();
	 }

	public static void openLink(String string) {
		try {
		 Object localObject = Class.forName("java.awt.Desktop").getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
		 localObject.getClass().getMethod("browse", new Class[] { URI.class }).invoke(localObject, new Object[] { string });
	 } catch (Throwable localThrowable) {
		 System.out.println("Failed to open link " + string.toString());
	 }
        System.gc();
	}
	public ImageIcon createImageIcon(String path, String description) {
			java.net.URL imgURL = getClass().getResource(path);
			if (imgURL != null) {
				return new ImageIcon(imgURL, description);
			} else {
				System.err.println("Couldn't find file: " + path);
				return null;
}
}


}
