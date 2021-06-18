package companies;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

/**
 * 
 * 
 * {a=null} {b=null} {c=null} {1=UserStats(visitCount=Optional.empty)}
 * {2=UserStats(visitCount=Optional.empty)}
 * {3=UserStats(visitCount=Optional.empty)}
 * {1=UserStats(visitCount=Optional[11]), 2=null,
 * 3=UserStats(visitCount=Optional.empty)}
 * {1=UserStats(visitCount=Optional.empty),
 * 2=UserStats(visitCount=Optional[23]), 3=null} {1=null,
 * 2=UserStats(visitCount=Optional.empty), 3=UserStats(visitCount=Optional[35])}
 * {1=UserStats(visitCount=Optional[14]), 2=UserStats(visitCount=Optional[15]),
 * 3=UserStats(visitCount=Optional[16])} {a=UserStats(visitCount=Optional[14]),
 * b=UserStats(visitCount=Optional[15]), c=UserStats(visitCount=Optional[16])}
 * {a=UserStats(visitCount=Optional[14]),
 * 2=UserStats(visitCount=Optional.empty), c=UserStats(visitCount=Optional[16])}
 *
 */

public class NextThink {
	public static void main(String[] args) {
		
		
		Map<String, UserStats> map = new LinkedHashMap<>();
		UserStats obj = new UserStats();
		obj.setVisitCount(Optional.of(14L));

		UserStats obj2 = new UserStats();
		obj2.setVisitCount(Optional.of(10L));

		UserStats obj3 = new UserStats();
		obj3.setVisitCount(Optional.of(11L));

		UserStats obj4 = new UserStats();
		obj4.setVisitCount(Optional.of(9L));

		map.put("1", obj);
		map.put("2", obj2);
		map.put("3", obj3);
		map.put("4", obj4);

//		Map<String, UserStats> map2 = new HashMap<>();
//		UserStats obj2 = new UserStats();
//		obj2.setVisitCount(Optional.of(15L));
//		map2.put("15", obj2);
//		
//		Map<String, UserStats> map3 = new HashMap<>();
//		UserStats obj3 = new UserStats();
//		obj3.setVisitCount(Optional.of(16L));
//		map3.put("16", obj3);

		System.out.println(new NextThink().count(map).toString());
		//System.out.println(new NextThink().test(-999));
	}

	Map<Long, Long> count(Map<String, UserStats>... visits) {
		Map<Long, Long> res = new HashMap<>();
		for (int i = 0; i < visits.length; i++) {

			Map<String, UserStats> input = visits[i];
			
			if (input == null || input.size() == 0) {
				continue;
			}

			for (Entry<String, UserStats> e : input.entrySet()) {
				String key = e.getKey();
				UserStats v = e.getValue();

				System.out.println("key:  " + key + " value:  " + v.getVisitCount());
				Long userId = convertStrToLong(e.getKey());
				if (userId == null) {
					continue;
				}
				UserStats obj = e.getValue();
				if (obj == null) {
					continue;
				}
				Long value = null;
				if (obj.getVisitCount() != null && obj.getVisitCount().isPresent()) {
					value = obj.getVisitCount().get();
				} else {
					continue;
				}

				if (value == 0 || value == null) {
					continue;
				}
				if (res.containsKey(userId)) {
					res.put(userId, value + 1);
				} else {
					res.put(userId, value);
				}

			}

		}

		return res;
	}

	private Long convertStrToLong(String key) {
		Long res = null;
		try {
			res = Long.parseLong(key);
		} catch (Exception e) {
			return res;
		}
		return res;
	}

	public int test(int N) {
		String s = String.valueOf(N);
		int maxVal = Integer.MIN_VALUE;
		for (int j = (N < 0) ? 1 : 0; j <= s.length(); j++) {
			int testVal = Integer.parseInt(insert(s, j));
			if (maxVal < testVal) {
				maxVal = testVal;

			}

		}
		return maxVal;

	}

	private String insert(String originalStr, int index) {
		StringBuffer res = new StringBuffer(originalStr);
		res.insert(index, "5");
		return res.toString();
	}
}
