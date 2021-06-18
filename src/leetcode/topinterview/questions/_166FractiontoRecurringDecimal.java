package leetcode.topinterview.questions;

public class _166FractiontoRecurringDecimal 
{
	public static void main(String[] args) {
		System.out.println(new _166FractiontoRecurringDecimal().solve(2, 3));
	}
	public String solve(int n, int d)
	{
		if(n>d)return String.valueOf(n);
		double res = (double)n/d;
		return String.valueOf(res);
		
	}

}
