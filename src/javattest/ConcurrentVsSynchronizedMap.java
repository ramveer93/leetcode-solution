package javattest;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/**
 * https://www.youtube.com/watch?v=7KNaYXtOHVs
 *
 */
public class ConcurrentVsSynchronizedMap {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		//Map<Integer,String>syncMap = Collections.synchronizedMap(map);
		Map<Integer,String>syncMap = new ConcurrentHashMap<Integer, String>();
		final Runnable thread1 = () -> {
			syncMap.put(1, "one");
		};
		final Runnable thread2 = () -> {
			syncMap.put(2, "two");
		};
		final Runnable thread3 = () -> {
			syncMap.put(3, "three");
		};
		final Runnable thread4 = () -> {
			syncMap.put(4, "four");
		};
		new Thread(thread1).start();
		new Thread(thread2).start();
		new Thread(thread3).start();
		new Thread(thread4).start();
		
		for(Entry<Integer,String>e:syncMap.entrySet()) {
			System.out.println(e.getValue()+" "+e.getKey());
			
		}
	}
}
