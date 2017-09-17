package matrixMultiplication;

public class MatrixMultiplicationBruteForce {
	public static void main(String[] args) {

		int[][] A = { { 2, 8, 1, 7 }, { 3, 4, 5, 8 }, { 9, 7, 6, 1 }, { 3, 7, 9, 2 } };

		int[][] B = { { 7, 9, 2, 5 }, { 3, 4, 1, 7 }, { 6, 8, 5, 2 }, { 1, 2, 4, 3 } };

		int[][] C = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				for (int k = 0; k < A.length; k++) {
					C[i][j] = C[i][j] + A[i][k] * B[k][j];
				}
			}
		}

		printer(C);
	}

	public static int[][] bruteForce(int[][] A, int[][] B, int n) {
		n = A.length;
		int[][] C = new int[n][n];

		if (n == 1) {
			C[0][0] = A[0][0] * B[0][0];
		} else {
			int[][] A11 = new int[n / 2][n / 2];
			int[][] A12 = new int[n / 2][n / 2];
			int[][] A21 = new int[n / 2][n / 2];
			int[][] A22 = new int[n / 2][n / 2];
			int[][] B11 = new int[n / 2][n / 2];
			int[][] B12 = new int[n / 2][n / 2];
			int[][] B21 = new int[n / 2][n / 2];
			int[][] B22 = new int[n / 2][n / 2];
			int[][] C11 = new int[n / 2][n / 2];
			int[][] C12 = new int[n / 2][n / 2];
			int[][] C21 = new int[n / 2][n / 2];
			int[][] C22 = new int[n / 2][n / 2];

			int[][] R1 = bruteForce(A11, B11, n / 2);
			int[][] R2 = bruteForce(A12, B21, n / 2);
			int[][] R3 = bruteForce(A11, B12, n / 2);
			int[][] R4 = bruteForce(A12, B22, n / 2);
			int[][] R5 = bruteForce(A21, B11, n / 2);
			int[][] R6 = bruteForce(A22, B21, n / 2);
			int[][] R7 = bruteForce(A21, B12, n / 2);
			int[][] R8 = bruteForce(A22, B22, n / 2);

			C11 = add(R1, R2);
			C12 = add(R3, R4);
			C21 = add(R5, R6);
			C22 = add(R7, R8);

			combine(C11, C, 0, 0);
			combine(C12, C, 0, n / 2);
			combine(C21, C, n / 2, 0);
			combine(C22, C, n / 2, n / 2);

		}

		return C;
	}

	public static int[][] add(int[][] arrayOne, int[][] arrayTwo) {
		int[][] result = new int[arrayOne.length][arrayOne.length];
		for (int i = 0; i < arrayOne.length; i++) {
			for (int j = 0; j < arrayOne.length; j++) {
				result[i][j] = arrayOne[i][j] + arrayTwo[i][j];
			}
		}
		return result;
	}

	public static void combine(int[][] array, int[][] combination, int index1, int index2) {
		for (int i = 0, i2 = index1; i < array.length; i++, i2++) {
			for (int j = 0, j2 = index2; j < array.length; j++, j2++) {
				combination[i2][j2] = array[i][j];
			}
		}
	}

	public static void printer(int[][] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.print("Row " + i + ": ");
			for (int j = 0; j < A.length; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println("\n");
		}
	}

}
