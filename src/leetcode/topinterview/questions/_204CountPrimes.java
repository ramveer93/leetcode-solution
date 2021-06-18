package leetcode.topinterview.questions;

import java.util.Arrays;

public class _204CountPrimes {

	public static void main(String[] args) {
		System.out.println(new _204CountPrimes().primes(1));

	}

	/**
	 * https://www.youtube.com/watch?v=PypkiVlTRa4&feature=emb_title create an array
	 * of size n , mark all the multiples of i to false(if i=2, then 2,4,6,8... cant
	 * be prime) count trues in array
	 * 
	 * 
	 * https://assets.leetcode.com/static_assets/public/images/solutions/Sieve_of_Eratosthenes_animation.gif
	 * 
	 * 
	 */
	public int countPrimes(int n) {
		int primeCount = 0;
		boolean a[] = new boolean[n];
		Arrays.fill(a, true);// lets say initially all the numbers are prime
		// get every number less than n starting from 2 , because 0 and 1 are not prime numbers
		for (int i = 2; i < n; i++) {
			if (a[i] == true) { // if true that means we have to process that number, if false means we have already mark that as false 

				for (int j = 2; j * i < n; j++) { // to get multiples of i, we have to check every i*j i starts from 2 and j starts from 2
					a[i * j] = false; // i*j will be multiple of i , so mark that also as not prime

				}
			}

		}
		for (int i = 2; i < n; i++) {
			if (a[i] == true)
				primeCount++;

		}

		return primeCount;

	}

	public int primes(int n) {
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (IsPrime(i))
				count++;
		}
		return count;

	}

	public boolean IsPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;

			}

		}
		return true;

	}
}
