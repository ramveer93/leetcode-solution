package javattest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://www.youtube.com/watch?v=UOr9kMCCa5g
 */
public class MyBlockingQueue<E> {

	int max = 16;
	private Queue<E> queue;
	private ReentrantLock lock = new ReentrantLock(true);

	private Condition notFull = lock.newCondition();
	private Condition notEmpty = lock.newCondition();

	public MyBlockingQueue(int size) {
		queue = new LinkedList<E>();
		max = size;
	}

	public void put(E e) { // queue can be full
		lock.lock();
		try {
			if (queue.size() == max) {
				// wait dont put
				notFull.await();// 
			}
			queue.add(e);
			notEmpty.signalAll();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} finally {
			lock.unlock();
		}

	}

	public E get() { // queue can be empty
		lock.lock();
		try {
			while (queue.size() == 0) {
				// queue is empty so dont get
				notEmpty.await();

			}
			E e = queue.poll();
			notFull.signalAll();
			return e;
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} finally {
			lock.unlock();
		}
		return null;
	}
}
