package matrixMultiplication;

public class MatrixMultiplicationBruteForce {
	public static void main(String[] args) {

		int[][] A = { { 2, 8, 1, 7 }, { 3, 4, 5, 8}, { 9, 7, 6, 1}, { 3, 7, 9, 2 } };
		
		int[][] B = { { 7, 9, 2, 5 }, { 3, 4, 1, 7 }, { 6, 8, 5, 2 }, { 1, 2, 4, 3 } };

		int[][] C = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		
		for (int i = 0; i < A.length; i++) {
			for(int j = 0; j < B.length; j++){
				for(int k = 0; k < A.length; k++){
					C[i][j] = C[i][j] + A[i][k] * B[k][j];
				}	
			}
		}
		
		printer(C);
	}
	
	public static void printer(int[][] A){
		for(int i = 0; i < A.length; i++ ){
			System.out.print("Row " + i + ": ");
			for (int j = 0; j < A.length; j++){
				System.out.print(A[i][j] + " ");
			}
			System.out.println("\n");
		}
	}

}
