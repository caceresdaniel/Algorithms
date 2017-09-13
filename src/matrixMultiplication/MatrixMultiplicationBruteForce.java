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
		int n = A.length;
		int[][] C = new int[n][n];

		if (n == 1) {
			C[0][0] = A[0][0] * B[0][0];
		} else{
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
			
			C1
			
		}

		return C;
	}
	
	public static int[][] add(){
		
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
			for (int j = 0, j2 = index2; j < array.length ; j++, j2++) {
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
