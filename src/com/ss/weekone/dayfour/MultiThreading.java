package com.ss.weekone.dayfour;

/**
 * @author Charvin Patel
 */


// Have two threads which acquires each others lock which leads to deadlock
public class MultiThreading{
	
	public static DeadLock d1 = new DeadLock();
	public static DeadLock d2 = new DeadLock();

	public static class ThreadOne extends Thread{

		public void run(){
			synchronized(d1){
				try {
					Thread.sleep(100);
				}
				catch(Exception e) {
					System.out.println("Exception: " + e);
				}
				System.out.println("Thread 1 waiting for Lock 2.");
				synchronized(d2) {
					System.out.println("Thread one calling MethodA " + d2.totalMethodCallsA() + " " + "times");
				}
			}
		}
	}



	public static class ThreadTwo extends Thread{
		public void run() {
			synchronized(d2){
				try {
					Thread.sleep(100);
				}
				catch(Exception e){
					System.out.println("Exception: " + e);
				}
				System.out.println("Thread 2 waiting for Lock 1.");
				synchronized(d1){
					System.out.println("Thread two calling MethodA " + d2.totalMethodCallsA() + " " + "times");
				}
			}
		}
	}
}




