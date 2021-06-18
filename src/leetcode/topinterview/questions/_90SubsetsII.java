package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _90SubsetsII {
	
	/**
	 * res: []
	 * 
	 * 
	 * 				  []       \
	 *             /      \     x
	 *           [1]       [2]
	 *          /   \       \
	 *      [1 2]    x      [2 2]
	 *      /    \
	 *  [1 2 2]   x
	 *      
	 *      
	 *      
	 *      
	 */      
	public static void main(String[] args) {
		int a[] = {1,2,2};
		System.out.println(new _90SubsetsII().subsetsWithDup(a).toString());
	}
	
	/**
	 * https://www.youtube.com/watch?v=U-wDFv9Hklo&list=PLzffTJx5aHaQM-twdYq0Flzmqfiv05u6c&index=2
	 * 
	 */
	public List<List<Integer>> subsetsWithDup(int a[]){
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(a);
		backtracking(res, a, 0, new ArrayList<>());
		
		return res;
		
	}
	
	private void backtracking(List<List<Integer>> res, int a[], int index, List<Integer> current) {
		res.add(new ArrayList<>(current));
		for(int i=index;i<a.length;i++) {
			if(i>index && a[i]==a[i-1])continue;
			current.add(a[i]);
			backtracking(res,a,i+1,current);
			current.remove(current.size()-1);
			
		}
		
	}

}
