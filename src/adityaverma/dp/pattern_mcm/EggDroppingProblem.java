package adityaverma.dp.pattern_mcm;

/**
 * https://www.youtube.com/watch?v=S49zeUjeUL0&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=43
 * 
 * @author sramveer
 *
 */
public class EggDroppingProblem {

	private static int dp[][];

	public static void main(String[] args) {
		int e = 3;
		int f = 5;
		dp = new int[e + 1][f + 1];
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				dp[i][j] = -1;
				
			}
			
		}
		System.out.println(new EggDroppingProblem().solve(e, f));
		
	}

	/**
	 * Given no of eggs and no of floors find min no of attempts 
	 * in worst case so
	 * that we can identify critical floor
	 * 
	 * base condition: e==0 is not valid input so 
	 * 1) e==1 -> if there is just one egg in worst case we have to go through every egg 
	 * 2) f == 0 - if there is only zero floors then 0 min attempts 
	 * 3) f==1 - if there is  one floor then min attempts in worst case = 1
	 * 
	 * so bc: if(e==1)-> return f; if(f==0 || f==1) return f;
	 * 
	 * 
	 * Now k-loop we will start from k = 1 to k<=f , k++ temp answer ===> solve(e,f)
	 *           /    \
	 * egg breaks      egg doesnt breaks 
	 * solve(e-1,k-1)   solve(e,f-k)
	 * 
	 * 
	 * 
	 */
	public int solve(int e, int f) {
		if (e == 1)
			return f;
		if (f == 0 || f == 1)
			return f;

		if (dp[e][f] != -1)
			return dp[e][f];

		int min = Integer.MAX_VALUE;
		for (int k = 1; k <= f; k++) {
			int temp = 1 + Math.max(solve(e - 1, k - 1), solve(e, f - k));
			min = Math.min(min, temp);

		}
		return dp[e][f] = min;
	}
}
