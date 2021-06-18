package companies;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

//LRU 
public class Cache {
	private static Map<String, String> cache;
	int capacity;

	public Cache(int capacity) {
		this.capacity = capacity;
		cache = new LinkedHashMap<String,String>();
		//Collections.synchronizedMap(cache);
	}
	
	public void put(String key, String value) {
		System.out.println("Cache called for put key :"+key+" value : "+value);
		if(cache.containsKey(key)) {
			 cache.remove(key);
		}else {
			if(capacity == cache.size()) {
				System.out.println("cache full !!");
				String keyToBeRemoved = cache.keySet().iterator().next();
				cache.remove(keyToBeRemoved);
				double d = (double)cache.size()/16.0;
				//https://www.javatpoint.com/load-factor-in-hashmap
				//how many elements we have in a bucket will be the cost of remove method 
				System.out.println("eviction function: "+d);
			}
		}
		 cache.put(key, value);
		 System.out.println("map after put "+cache.toString());
	}

	public String get(String key) {
		System.out.println("Cache get :"+key+" map: "+cache.toString());
		if (cache.containsKey(key)) {
			String value = cache.get(key);
			cache.remove(key);
			cache.put(key, value);
			return value;
		} else {
			return null;
		}
	}
}
