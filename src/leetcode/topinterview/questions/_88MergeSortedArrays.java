package leetcode.topinterview.questions;

public class _88MergeSortedArrays {
	
	public static void main(String[] args) {
		int a[] = {1,2,3,0,0,0};
		int b[] = {2,5,6};
		
		new _88MergeSortedArrays().merge(a,3,b,3);
		for(int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
			
		}
	}

	public void merge(int a[], int m, int b[], int n) {
		int i = m-1;
		int j = n-1;
		int k = a.length-1;
		while (i >= 0 && j >=0) {
			if (a[i] <= b[j]) {
				a[k--] = b[j];
				j--;

			} else {
				a[k--] = a[i--];
				
			}

		}

		while (i >=0) {
			a[k--] = a[i--];
			
		}
		while (j >=0) {
			a[k--] = b[j--];
			

		}

	}
	
public void mergeD(int[] nums1, int m, int[] nums2, int n) {
        
        int i=m-1, j=n-1, k=nums1.length-1;
        while(i>=0 && j>=0){
            if(nums1[i] <= nums2[j])
                nums1[k--] = nums2[j--];
            else 
                nums1[k--] = nums1[i--];
        }
        while(i>=0) nums1[k--] = nums1[i--];
        while(j>=0) nums1[k--] = nums2[j--];
    }

}
