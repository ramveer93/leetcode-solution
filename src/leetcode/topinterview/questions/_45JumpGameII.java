package leetcode.topinterview.questions;

public class _45JumpGameII {

	public static void main(String[] args) {

		int a[] = {2,3,1,1,4};
		System.out.println(new _45JumpGameII().minJumps(a));
	}

	/**
	 * https://www.youtube.com/watch?v=PEgwWGoKUaY
	 * 
	 */
	public int minJumps(int a[]) {
		int des = 0;
		int pos = 0;
		int jump = 0;
		for (int i = 0; i < a.length - 1; i++) {
			des = Math.max(des, i + a[i]);
			if (pos == i) {
				pos = des;
				jump++;

			}

		}

		return jump;
	}
}
