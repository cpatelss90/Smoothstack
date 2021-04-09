package com.ss.weekone.dayfour;


// Main Produce/Consume Class where we have two threads
// produce and consume sequentially
public class ProducerConsumerMain {
	final static ProducerConsumer proCon = new ProducerConsumer();

	public static void main(String[] args) throws InterruptedException {
		ProducerConsumerMain.ThreadProduce tp = new ProducerConsumerMain.ThreadProduce();
		ProducerConsumerMain.ThreadConsume tc = new ProducerConsumerMain.ThreadConsume();

		tp.start();
		tc.start();		 
	} 

	// This Thread is responsible to Produce int's
	public static class ThreadProduce extends Thread{

		public void run() {
			try {
				proCon.produce();
			}
			catch(Exception e){
				System.out.println("Exception in ThreadProduce " + e);
			}
		}
	}


	// This Thread is responsible to Consume int's
	public static class ThreadConsume extends Thread{
		//final ProducerConsumer proCon = new ProducerConsumer();
		public void run() {
			try {
				proCon.consume();
			}
			catch(Exception e){
				System.out.println("Exception in ThreadConsume: " + e);
			}
		}
	}
}
