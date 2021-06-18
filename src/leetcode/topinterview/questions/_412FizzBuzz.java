package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.List;

public class _412FizzBuzz {

	public static void main(String[] args) {

		System.out.println(new _412FizzBuzz().fizzBuzz(15).toString());
	}

	public List<String> fizzBuzz(int n) {
		List<String> res = new ArrayList<>();
		if (n == 0)
			return res;
		int i = 1;
		while (i <= n) {
			if(i % 3 == 0 && i % 5 == 0) {
				res.add("FizzBuzz");
			}
			else if (i % 3 == 0) {
				res.add("Fizz");
			} else if (i % 5 == 0) {
				res.add("Buzz");

			}  else {
				res.add(String.valueOf(i));
			}
			i++;
		}

		return res;
	}
}
