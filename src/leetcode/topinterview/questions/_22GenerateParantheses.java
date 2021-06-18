package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.youtube.com/watch?v=sz1qaKt0KGQ
 * 
 * 
 * https://www.youtube.com/watch?v=qBbZ3tS0McI&t=634s
 * 
 * 
 * @author sramveer
 *
 */

public class _22GenerateParantheses {
	public static void main(String[] args) {

		System.out.println(new _22GenerateParantheses().generateAllValidParamthesis(4));
	}

	public List<String> generateAllValidParamthesis(int n) {
		List<String> result = new ArrayList<String>();
		backtracking(result, "", 0, 0, n);
		return result;
	}

	/**
	 * Three things:
	 * 
	 * https://www.youtube.com/watch?v=R6RddNeX3ug
	 * 
	 * 
	 * 
	 * 1. choices: either ( or ) 
	 * 2. constraints: we can't have an closing
	 * parenthesis until we have opening 
	 * 3. goal: we can't have more than 2*max
	 * parenthesis
	 * 
	 * @param result
	 * @param currentString
	 * @param open
	 * @param close
	 * @param max
	 */
	private void backtracking(List<String> result, String currentString, int open, int close, int max) {
		if (currentString.length() == 2 * max) {
			result.add(currentString);
			return;
		}
		if (open < max)
			backtracking(result, currentString + "(", open + 1, close, max);
		if (close < open)
			backtracking(result, currentString + ")", open, close + 1, max);

	}

}
