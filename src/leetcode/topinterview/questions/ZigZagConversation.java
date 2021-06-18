package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 * 
 * @author sramveer
 *
 */

public class ZigZagConversation {

	public static String zigZagConv(String s, int rowNum) {
		List<StringBuilder> rows = new ArrayList<>();
		for (int i = 0; i < Math.min(rowNum, s.length()); i++) {
			rows.add(new StringBuilder());
		}
		int curr_row = 0;
		boolean goingDown = false;
		for (char c : s.toCharArray()) {
			rows.get(curr_row).append(c);

			if (curr_row == 0 || curr_row == rowNum - 1) {
				goingDown = !goingDown;

			}
			curr_row += (goingDown ? 1 : -1);

		}
		StringBuilder sb = new StringBuilder();
		for (StringBuilder row : rows) {
			sb.append(row);

		}
		return sb.toString();

	}

}
