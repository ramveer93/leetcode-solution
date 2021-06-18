package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.List;

public class _77Combinations {
	
	public static void main(String[] args) {
		System.out.println(new _77Combinations().combine(4, 0).toString());
	}
	
	public List<List<Integer>> combine(int n, int k ){
		 List<List<Integer>> res = new ArrayList<>();
		 int a[] = new int[n];
		 for(int i=0;i<n;i++) a[i] = i+1;
		 dfs(res,a,k,new ArrayList<>(),0 );
		 
		 
		 return res;
		
	}
	
	private void dfs(List<List<Integer>> res, int a[], int k , List<Integer> current, int index) 
	{
		if(current.size() == k) {
			res.add(new ArrayList<>(current));
			return;
		}
		
		
		for(int i = index;i<a.length;i++) {
			current.add(a[i]);
			dfs(res,a,k,current,i+1);
			current.remove(current.size()-1);
			
		}
	}

}
