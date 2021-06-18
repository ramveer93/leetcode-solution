package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DPWorld {

	/**
	 * 
	 * Dis: 4 maxSteps: 1,2
	 * 
	 * 1,1,1,1 1,1,2 2,1,1, 2,2
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		int n = 5;
		//System.out.println(new DPWorld().dp(n + 1, 2));
		List<Integer>temp = new ArrayList<>();
		temp.add(2);
		temp.add(4);
		temp.add(3);
		temp.add(4);
		temp.add(3);
		temp.add(5);
		temp.add(6);
		temp.add(1);
		
		new DPWorld().printPairs(temp, 7);
	}

	/**
	 * List: {2,4,3,5,6,1} k: 7 {2,5} {4,3} {6,1}
	 */

	public void printPairs(List<Integer> a, int target) {
//		List<List<Integer>> res = new ArrayList<>();
//		if(a.size()==0)return;
//		helper(res, target, a, new ArrayList<Integer>(), 0);
//		System.out.println(res.toString());
//		System.out.println(res.size());
		
		/**
		 * Using hashmap
		 */
		Map<Integer,Integer>map = new HashMap<>();
		Set<List<Integer>>r = new HashSet<>();
		
		for(int i=0;i<a.size();i++) {
			int com = target-a.get(i);
			if(map.containsKey(com)) {
				//System.out.println(com+", "+a.get(i));
				List<Integer>tem = new ArrayList<>();
				tem.add(com);
				tem.add(a.get(i));
				Collections.sort(tem);
				r.add(tem);
			}
			if(map.containsKey(a.get(i))) {
				map.put(a.get(i), map.get(i)+1);
			}else {
				map.put(a.get(i), 1);
			}
			
		}
		System.out.println(r.toString());
	}

	private void helper(List<List<Integer>> res, int target, List<Integer> a, List<Integer> current, int index) {
		if (target < 0) {
			return;
		}
		if (target == 0 && current.size()==2) {
			res.add(new ArrayList<>(current));
			return;
		}
		for (int i = index; i < a.size(); i++) {
			current.add(a.get(i));
			helper(res, target - a.get(i), a, current, i + 1);
			current.remove(current.size() - 1);
		}

	}

	// n: 4
	// m: 2

	public int recursive(int n, int m) {
		if (n <= 1) {
			return n;
		}
		int ways = 0;
		for (int i = 1; i <= m && i <= n; i++) {
			ways = ways + recursive(n - i, m);
		}
		return ways;
	}

	/**
	 * 1,1,1,1 1,1,2 2,1,1, 2,2
	 * 
	 * @param n
	 * @param m
	 * @return
	 */
	public int dp(int n, int m) {
		int dp[] = new int[n]; // i = n j = m
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i < n; i++) {
			for (int j = 1; j <= m && j <= i; j++) {
				System.out.print(j + " ");
				dp[i] = dp[i] + dp[i - j];
			}
			System.out.println();

		}
		return dp[n - 1];

	}

}
