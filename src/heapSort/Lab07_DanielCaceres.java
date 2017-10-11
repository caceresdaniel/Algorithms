package heapSort;

public class Lab07_DanielCaceres {
	protected static int heapSize;

	public static void main(String[] args) {
		int[] A = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
		
		System.out.print("Before sort\n[ ");
		for (int a : A)
			System.out.print(a + " ");
		System.out.print("]\n");
		
		heapsort(A);
		
		System.out.print("After sort \n[ ");
		for (int a : A)
			System.out.print(a + " ");
		System.out.print("]");
	}

	public static void maxHeapify(int[] A, int i) {
		int l = left(i);
		int r = right(i);
		int largest;

		if (l <= heapSize  - 1 && A[l] > A[i])
			largest = l;
		else
			largest = i;

		if (r <= heapSize - 1 && A[r] > A[largest])
			largest = r;

		if (largest != i) {
			int temp = A[i];
			A[i] = A[largest];
			A[largest] = temp;
			maxHeapify(A, largest);
		}
	}

	public static void buildMaxHeap(int[] A) {
		heapSize = A.length - 1;
		for (int i = (int) Math.floor((A.length - 1) / 2); i >= 0; i--) {
			maxHeapify(A, i);
		}
	}

	public static void heapsort(int[] A) {
		buildMaxHeap(A);
		for (int i = A.length - 1; i >= 1; i--) {
			int temp = A[0];
			A[0] = A[i];
			A[i] = temp;
			heapSize = heapSize - 1;
			maxHeapify(A, 0);
		}
	}

	public static int left(int i) {
		return 2 * i ;
	}

	public static int right(int i) {
		return 2 * i + 1;
	}

}
