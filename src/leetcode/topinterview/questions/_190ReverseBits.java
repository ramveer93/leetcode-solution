package leetcode.topinterview.questions;

public class _190ReverseBits {

	public static void main(String[] args) {
		//System.out.println(new _190ReverseBits().reverseBits(10100101000001111010011100));
	}

	/**
	 * https://www.youtube.com/watch?v=LJiMk8lPJNc
	 * 
	 */
	public int reverseBits(int n) 
	{
		int result = 0;
		for(int i=0;i<32;i++)
		{
			// first & with last bit 
			int lsb = n&1 ; // this will give info if the last bit is set or not 
			int reversedLsb = lsb<<(31-i); // this is once we know that ith bit is set or not , we will accordingly set or unset the ith bit from starting in result 
			result = result | reversedLsb;
			n = n>>1; // this is so that we will talk about next digit from right 
		}
		
		
		return result;
	
	}

}
