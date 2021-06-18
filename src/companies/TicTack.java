package companies;

import java.util.Scanner;

/**
 * 
 * @author sramveer
 *
 */
public class TicTack {

	private static int matrix[][];
	static int rows;
	static int cols;
	static int dc1 = 0;
	static int dc2 = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		rows = sc.nextInt();
		cols = sc.nextInt();
		matrix = new int[rows][cols];
		boolean user = false;// p1 user
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.println("======================================================");
				printMatrix();

				System.out.println(" USER " + (user == false ? "P1" : "P2") + " TURN===================");
				int x = sc.nextInt();
				int y = sc.nextInt();
				String res = findWinner(x, y, user);
				if (!res.equals("")) {
					System.out.println("The winner is : " + res);
					System.out.println("Game over !!");
					System.exit(0);
				} else {
					printMatrix();
					System.out.println("======================================================");
					user = !user;
				}
			}
		}
	}

	private static void printMatrix() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();

		}
	}

	private static String findWinner(int x, int y, boolean user) {
		int valueToBeFilled = (user == false ? 1 : -1);
		// p1 -> 1
		// p2 -> -1
		matrix[x][y] = valueToBeFilled;

		int count = 0;
		// now check the xth row and yth col
		for (int i = 0; i < rows; i++) {
			if (matrix[x][i] == valueToBeFilled) {
				count++;
			} else {
				break;
			}
		}

		if (count == rows) {
			return (user == false ? "P1" : "P2");
		}
		count = 0;

		// check the cols
		for (int i = 0; i < cols; i++) {
			if (matrix[i][y] == valueToBeFilled) {
				count++;
			} else {
				break;
			}
		}
		if (count == rows) {
			return (user == false ? "P1" : "P2");
		}
		count = 0;
		// check diagonals
		for (int i = 0; i < rows; i++) {
			if (matrix[i][i] == valueToBeFilled) {
				count++;
			} else {
				break;
			}
		}
		if (count == rows) {
			return (user == false ? "P1" : "P2");
		}

		// reverse diagonal
		count = 0;
		for (int i = 0; i < rows; i++) {
			if (matrix[i][rows - i - 1] == valueToBeFilled) {
				count++;
			} else {
				break;
			}
		}
		if (count == rows) {
			return (user == false ? "P1" : "P2");
		}

		return "";
	}

}
