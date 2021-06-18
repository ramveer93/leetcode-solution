package leetcode.topinterview.questions;

public class _852PeakIndexinaMountainArray {

	public static void main(String[] args) {
		int a[] = { 0,1,0 };

		System.out.println(new _852PeakIndexinaMountainArray().peakIndexInMountainArray(a));
}

	public int peakIndexInMountainArray(int a[]) {

		int index = 0;
		for(int i=1;i<a.length-1;i++) {
			if(a[i]>a[i-1] && a[i]>a[i+1]) {
				index = i;
			}
			
		}
		return index;
	}
}
