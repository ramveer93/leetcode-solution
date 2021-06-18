package companies;

import java.util.HashMap;
import java.util.Map;

public class TestCache {

	private static Map<String,String>map;
	private static Cache cache;
	
	public TestCache() {
		map = new HashMap<>();
		cache = new Cache(3);
	}
	
	public static void main(String[] args) {
	      
	       new TestCache().test();
	}
	
	public void test() {
		TestCache test = new TestCache();
		
		   map.put("Rajasthan", "Jaipur");
	       map.put("UP", "Agra");
	       map.put("MP", "Bhopal");
	       map.put("Karnataka", "Bangalore");
	       
	       
	       System.out.println(test.get("Rajasthan"));
	       System.out.println(test.get("Rajasthan"));
	       System.out.println(test.get("UP"));
	       System.out.println(test.get("UP"));
	       System.out.println(test.get("MP"));
	       System.out.println(test.get("MP"));
	       System.out.println(test.get("Karnataka"));
	       System.out.println(test.get("Karnataka"));
	       
	       System.out.println(test.get("Rajasthan"));
	       System.out.println(test.get("Rajasthan"));
	}
	
	public String get(String key) {
		String value = cache.get(key);
		if(value!=null) {
			return value;
		}
		if(value == null && map.containsKey(key)) {
			System.out.println("Data returning from map ");
			value = map.get(key);
			cache.put(key, value);
		}else {
			System.out.println("Cant find value in cache and map key : "+key);
		}
		return value;
	}
	
	
}
