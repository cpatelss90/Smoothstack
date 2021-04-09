package com.ss.weekone.dayfour;

/**
 * @author Charvin Patel
 */


// This class make sure's there's only one instance of this class
// at any given point of time
public class Singleton {

	private static volatile Singleton instance;
	private Singleton() {}

	public static Singleton getInstance() {

		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;	
	}
}
