package com.edward.utils;

public class EyeThrowableDealer {
	
	private Throwable caught = null;

	public void load(Throwable toCatch) {
		caught = toCatch;
	}
	
	public void print() {
		StackTraceElement[] elements = caught.getStackTrace();
		System.err.println("[ERROR] " + new java.util.Date()+": " + caught.getClass().getCanonicalName() + ": " + caught.getMessage());
		for (int i = 0; i < elements.length; i++) {
			StackTraceElement ele = elements[i];
			System.err.println("[ERROR] " + new java.util.Date()+":		 at " + ele.getClassName() + "." + ele.getMethodName() + "("+ele.getFileName() + "." + ele.getLineNumber() + ")");
		}
		
	}

}
