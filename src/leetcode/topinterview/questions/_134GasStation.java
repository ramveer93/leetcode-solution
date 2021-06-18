package leetcode.topinterview.questions;

public class _134GasStation {

	/**
	 * https://www.youtube.com/watch?v=xmJZSYSvgfE
	 * 
	 * https://www.youtube.com/watch?v=zcnVaVJkLhY
	 * 
	 * idea is if surpus is negative , reset it to 0 and starting point will be from
	 * where the surplus became negative
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {

		int n = gas.length;
		int totalSurplus = 0;
		int currentSurplus = 0;
		int startingPoint = 0;
		for (int i = 0; i < n; i++) {
			totalSurplus += gas[i] - cost[i];
			currentSurplus += gas[i] - cost[i];
			if (currentSurplus < 0) {
				currentSurplus = 0;
				startingPoint = i + 1;
			}
		}
		return (totalSurplus < 0) ? -1 : startingPoint;

	}

}
