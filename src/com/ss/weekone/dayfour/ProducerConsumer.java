package com.ss.weekone.dayfour;

import java.util.LinkedList;


// This Class defines the Method Produce and Consume
public class ProducerConsumer {

	LinkedList<Integer> lst = new LinkedList<>();
	int limit = 7;
	int num = 0;

	// This Method produces the int's
	public void produce() throws InterruptedException {
		while(true) {
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
		}
	}

	// This Method consumes the produced int's
	public void consume() throws InterruptedException {
		while(true) {
			synchronized(this) {
				while(lst.size() == 0){ 
					wait();
				}

				int value = lst.remove();
				System.out.println("ThreadConsume consumed the int " + value);

				notify();
				Thread.sleep(700);
			}
		}
	}

}
