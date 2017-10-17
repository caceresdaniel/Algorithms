package quicksort;

import java.util.Random;

public class QuickSort {
	public static void main(String[] args) {
		int[] A = { 13, 19, 9, 5, 12, 8, 7, 4, 21, 2, 6, 11 };
		
		System.out.print("Array before quicksort:\n{ ");
		for(int a : A)
			System.out.print(a + " ");
		System.out.print("}\n");
		
		quicksort(A, 0, A.length - 1);
		
		System.out.print("Array after quicksort:\n{ ");
		for(int a : A)
			System.out.print(a + " ");
		System.out.print("}\n");
		
		int[] B = {5, 7, 2, 4, 98, 12, 32, 43, 23,11,1};
		
		System.out.print("\nArray before randomized quicksort:\n{ ");
		for(int b : B)
			System.out.print(b + " ");
		System.out.print("}\n");
		
		quicksort(B, 0, B.length - 1);
		
		System.out.print("Array after randomized quicksort:\n{ ");
		for(int b : B)
			System.out.print(b + " ");
		System.out.print("}\n");
		
	}

	public static void quicksort(int[] A, int p, int r) {
		if (p < r) {
		int	q = partition(A, p, r);
			quicksort(A, p, q - 1);
			quicksort(A, q + 1, r);
		}
	}

	public static int partition(int[] A, int p, int r) {
		int x = A[r];
		int i = p - 1;
		for (int j = p; j < r; j++) {
			if (A[j] <= x) {
				i = i + 1;
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}
		int temp2 = A[i + 1];
		A[i + 1] = A[r];
		A[r] = temp2;
		return i + 1;
	}

	public static int randomizedPartition(int[] A, int p, int r) {
		int i = random(p, r);
		int temp = A[r];
		A[r] = A[i];
		A[i] = temp;
		return partition(A, p, r);
	}

	public static void randomizedQuickSort(int[] A, int p, int r) {
		if (p < r) {
			int q = randomizedPartition(A, p, r);
			randomizedQuickSort(A, p, q - 1);
			randomizedQuickSort(A, q + 1, r);
		}
	}

	public static int random(int p, int r) {
		int random = (int) new Random().nextInt(r - p) + p;
		return random;
	}
}
