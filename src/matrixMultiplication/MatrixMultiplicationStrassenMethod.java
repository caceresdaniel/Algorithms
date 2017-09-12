package matrixMultiplication;

public class MatrixMultiplicationStrassenMethod {
	public static void main(String[] args) {
		int[][] A = { { 2, 8, 1, 7 }, { 3, 4, 5, 8 }, { 9, 7, 6, 1 }, { 3, 7, 9, 2 } };

		int[][] B = { { 7, 9, 2, 5 }, { 3, 4, 1, 7 }, { 6, 8, 5, 2 }, { 1, 2, 4, 3 } };\
		
		
	}
	
	public static void recMatMult(int[][] A, int[][]B, int n){
		int[][] C = new int[n][n];
		if(n == 1){
			C[1][1] = A[1][1] * B[1][1];
		} else {
			
		}
		
	}
}
