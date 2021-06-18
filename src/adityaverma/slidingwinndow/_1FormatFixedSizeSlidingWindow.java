package adityaverma.slidingwinndow;

public class _1FormatFixedSizeSlidingWindow {

	public int fixedSize(int a[], int k ) {
		int i=0;
		int j=0;
		int sum = 0;
		int ans = 0;
		while(j<a.length) {
			//calculation
			sum+=a[j];
			if(j-i+1<k) {
				j++;
			}else if(j-i+1 == k) {
				//we hit the window size so collect a candidate
				
				ans = Math.max(ans,sum);
				//slide the window to maintain the window size
				//remove the ith calculcation and add jth calculation
				sum = sum-a[i];
				i++;
				j++;
			}
			
		}
		return ans;
	}
}
