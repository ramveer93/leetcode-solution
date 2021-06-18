package leetcode.topinterview.questions;

import java.math.BigDecimal;

public class PowOfXn50 {
	public static void main(String[] args) {
		double d = new PowOfXn50().calPow(2.00000, -2);
		String doubleValue = String.format("%.5f", d);
		System.out.println(doubleValue);

		System.out.println(Double.parseDouble(doubleValue));
	}

	public double finalPowMethod(double x, int n) {
		boolean flag = false;
		if (x == 0)
			return 0;
		if (n < 0)
			flag = true;
		double res = calPowEfficient(x, n);

		return flag ? 1 / res : res;

	}

	// https://cp-algorithms.com/algebra/binary-exp.html
	// efficient method
	public double calPowEfficient(double x, int n) {
		if (n == 0)
			return 1.0;
		double res = calPowEfficient(x, n / 2);
		if (n % 2 == 0) {
			return res;
		} else {
			return x * res;
		}
	}

// not efficient method
	public double calPow(double x, int n) {
		if (x == 0)
			return 0;
		boolean flag = false;
		if (n < 0)
			flag = true;
		n = Math.abs(n);
		double res = 1.00000;
		while (n > 0) {
			res = res * x;
			n--;

		}
		if (flag)
			return 1 / res;
//		System.out.println(String.format("%.5f", res));
//		return Double.parseDouble(String.format("%.4f",res));
////		BigDecimal value = new BigDecimal(res);
//		value.setScale(5);

		return res;

	}

}
