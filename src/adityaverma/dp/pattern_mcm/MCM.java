package adityaverma.dp.pattern_mcm;

public class MCM {

	private static int[][] t;

	public static void main(String[] args) {
		int a[] = { 40, 20, 30, 10, 30 };
		int n = a.length;
		t = new int[n + 1][n + 1];
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[0].length; j++) {
				t[i][j] = -1;
			}

		}
		/**
		 * Why start from 1 to a.length-1
		 * because if we take i=0 then matrix will be a(i-1)*a(i)->a(-1)*a(0) which is wrong
		 * so we have to take i=1 
		 * same for j 
		 */
		System.out.println(new MCM().mcmRecursion(a, 1, a.length - 1));
		System.out.println(new MCM().memozation(a, 1, a.length - 1));
		
		
		
	}
/**
 * Question is we have given the size of matrixes and we need to get min cost of multiplying 
 * the matrix 
 * 
 * if array size is n then there are n-1 matrixes
 * e.g: arr[40,20,30,10,30]
 * matrixes: 
 * a1: 40*20
 * a2: 20*30
 * a3: 30*10
 * a4: 10*30
 * 
 * so for any a(i) dimentions are => arr(i-1)*arr(i)
 * 
 */
	public int mcmRecursion(int a[], int i, int j) {
		// base invalid input
		if (i >= j)
			return 0;
		int min = Integer.MAX_VALUE;
		for (int k = i; k <= j - 1; k++) {
			int temp = mcmRecursion(a, i, k) + mcmRecursion(a, k + 1, j) + a[i - 1] * a[k] * a[j];
			if (temp < min)
				min = temp;
		}
		return min;
	}

	public int memozation(int a[], int i, int j) {
		if (i >= j)
			return 0;
		if (t[i][j] != -1)
			return t[i][j];
		int min = Integer.MAX_VALUE;
		for (int k = i; k <= j - 1; k++) {
			int temp = memozation(a, i, k) + memozation(a, k + 1, j) + a[i - 1] * a[k] * a[j];
			if (temp < min)
				min = temp;
		}
		return t[i][j] = min;

	}
}
