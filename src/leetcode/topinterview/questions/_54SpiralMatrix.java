package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.List;

public class _54SpiralMatrix {
	public static void main(String[] args) 
	{
		int a[][] = {
				
				{ 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 8, 9 }
				
		};
		System.out.println(new _54SpiralMatrix().printSpiralMatrix(a).toString());

	}

	/**
	 * 
	 * 
	 * https://www.youtube.com/watch?v=3joo9yAZVh8
	 * 
	 * 
	 * 
	 * [1,2,3] 
	 * [4,5,6]
	 * [7,8,9]
	 * ---->
	 *  
	 *  ->  |
	 * |	|
	 * |    |
	 *  ---\/
	 * 
	 * @param a
	 * @return
	 */
	public List<Integer> printSpiralMatrix(int a[][]) {
		List<Integer> res = new ArrayList<>();

		/**
		 * define boundaries
		 */
		int rs = 0;
		int re = a.length - 1;
		int cs = 0;
		int ce = a[0].length - 1;

		while (rs <= re && cs <= ce) {
			// iterate first row(left to right), so row is fixed , just column will vary
			// from cs to ce
			for (int i = cs; i <= ce; i++) {
				res.add(a[rs][i]);

			}
			rs++; // as we are done with first row so rs will be next row

			// now we will iterate from top left too bottom left , here column will be fixed
			// , and row will vary

			for (int i = rs; i <= re; i++) {
				res.add(a[i][ce]);

			}

			ce--; // as we are done with this column so we will have one less column

			if (rs <= re) {
				for (int i = ce; i >= cs; i--) {
					res.add(a[re][i]);

				}
				re--;

			}

			if (cs <= ce) {
				for (int i = re; i >= rs; i--) {
					res.add(a[i][cs]);

				}
                cs++;
			}

		}

		return res;

	}

}
