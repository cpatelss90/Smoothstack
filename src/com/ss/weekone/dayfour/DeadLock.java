package com.ss.weekone.dayfour;

/**
 * @author Charvin Patel
 */


// Main Class where we execute both threads
public class DeadLock{
	
	int totalA = 0;
	
	// Method for both Threads to access
	public int totalMethodCallsA() {
		return totalA=+1;
	}

	
	// runs both thread
	public static void main(String[] args) {		
		
		MultiThreading.ThreadOne t1 = new MultiThreading.ThreadOne();
		MultiThreading.ThreadTwo t2 = new MultiThreading.ThreadTwo();
		
		t1.start();
		t2.start();

	}

}
