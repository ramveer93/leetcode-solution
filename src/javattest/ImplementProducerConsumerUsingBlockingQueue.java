package javattest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ImplementProducerConsumerUsingBlockingQueue {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
		
		final Runnable producer = () ->{
			int i=0;
			while(i<=100) {
				try {
					queue.put(i++);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		new Thread(producer).start();
		new Thread(producer).start();
		
		
		final Runnable consumer = ()->{
			while(true) {
				try {
					System.out.println(queue.take());
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				}
			}
		};
		new Thread(consumer).start();
		new Thread(consumer).start();
		
		Thread.sleep(1000);
		
	}
}
