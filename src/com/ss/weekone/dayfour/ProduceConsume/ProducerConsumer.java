package com.ss.weekone.dayfour.ProduceConsume;

import java.util.LinkedList;

/**
 * @author Charvin Patel
 */


// This Class defines the Method Produce and Consume
public class ProducerConsumer{


	LinkedList<Integer> lst = new LinkedList<>();
	int limit = 7;
	public int num = 0;

	// This Method produces the ints and thread runs 10 times
	public void produce() throws InterruptedException {
		int totalRun = 10;
		do {
			synchronized(this) {
				while(lst.size() == limit) { 
					wait();
				}

				lst.add(num);

				System.out.println("ThreadProduce produced the int "  + num);

				num++;
				notify();
				Thread.sleep(700);
			}
			totalRun--;
		}while(totalRun > 0);
	}

	// This Method consumes the produced int's and the thread runs 10 times
	public void consume() throws InterruptedException {
		int totalRun = 10;
		do {
			synchronized(this) {
				while(lst.size() == 0){ 
					wait();
				}

				int value = lst.removeFirst();

				System.out.println("ThreadConsume consumed the int " + value);

				notify();
				Thread.sleep(700);
			}
			totalRun--;

		}while(totalRun > 0);
	}

}
