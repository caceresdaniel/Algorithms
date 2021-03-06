package matrixMultiplication;

public class MatrixMultiplicationStrassenMethod {
	public static void main(String[] args) {
		int[][] A = { { 2, 8, 1, 7 }, { 3, 4, 5, 8 }, { 9, 7, 6, 1 }, { 3, 7, 9, 2 } };

		int[][] B = { { 7, 9, 2, 5 }, { 3, 4, 1, 7 }, { 6, 8, 5, 2 }, { 1, 2, 4, 3 } };

		int[][] result = new int[A.length][A.length];

		int n = A.length;

		result = strassen(A, B);

		System.out.println("Using Strassen's Algorithm");
		printer(result);

	}

	public static int[][] strassen(int[][] A, int[][] B) {
		int n = A.length;
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

			partition(A, A11, 0, 0);
			partition(A, A12, 0, n / 2);
			partition(A, A21, n / 2, 0);
			partition(A, A22, n / 2, n / 2);
			partition(B, B11, 0, 0);
			partition(B, B12, 0, n / 2);
			partition(B, B21, n / 2, 0);
			partition(B, B22, n / 2, n / 2);

			int[][] S1 = new int[n / 2][n / 2];
			int[][] S2 = new int[n / 2][n / 2];
			int[][] S3 = new int[n / 2][n / 2];
			int[][] S4 = new int[n / 2][n / 2];
			int[][] S5 = new int[n / 2][n / 2];
			int[][] S6 = new int[n / 2][n / 2];
			int[][] S7 = new int[n / 2][n / 2];
			int[][] S8 = new int[n / 2][n / 2];
			int[][] S9 = new int[n / 2][n / 2];
			int[][] S10 = new int[n / 2][n / 2];

			S1 = subtract(B12, B22);
			S2 = add(A11, A12);
			S3 = add(A21, A22);
			S4 = subtract(B21, B11);
			S5 = add(A11, A22);
			S6 = add(B11, B22);
			S7 = subtract(A12, A22);
			S8 = add(B21, B22);
			S9 = subtract(A21, A11);
			S10 = add(B11, B12);

			int[][] P1 = new int[n / 2][n / 2];
			int[][] P2 = new int[n / 2][n / 2];
			int[][] P3 = new int[n / 2][n / 2];
			int[][] P4 = new int[n / 2][n / 2];
			int[][] P5 = new int[n / 2][n / 2];
			int[][] P6 = new int[n / 2][n / 2];
			int[][] P7 = new int[n / 2][n / 2];

			P3 = strassen(A11, S1);
			P5 = strassen(S2, B22);
			P2 = strassen(S3, B11);
			P4 = strassen(A22, S4);
			P1 = strassen(S5, S6);
			P7 = strassen(S7, S8);
			P6 = strassen(S9, S10);

			int[][] C11 = new int[n / 2][n / 2];
			int[][] C12 = new int[n / 2][n / 2];
			int[][] C21 = new int[n / 2][n / 2];
			int[][] C22 = new int[n / 2][n / 2];

			C11 = add(subtract(add(P1, P4), P5), P7);
			C12 = add(P3, P5);
			C21 = add(P2, P4);
			C22 = add(subtract(add(P1, P3), P2), P6);

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

	public static int[][] subtract(int[][] arrayOne, int[][] arrayTwo) {
		int[][] result = new int[arrayOne.length][arrayOne.length];
		for (int i = 0; i < arrayOne.length; i++) {
			for (int j = 0; j < arrayOne.length; j++) {
				result[i][j] = arrayOne[i][j] - arrayTwo[i][j];
			}
		}
		return result;
	}

	public static void partition(int[][] array, int[][] partitionedArray, int index1, int index2) {
		for (int i = 0, i2 = index1; i < partitionedArray.length; i++, i2++) {
			for (int j = 0, j2 = index2; j < partitionedArray.length; j++, j2++) {
				partitionedArray[i][j] = array[i2][j2];
			}
		}
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
