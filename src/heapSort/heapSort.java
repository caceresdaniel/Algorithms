package heapSort;

public class heapSort {
	public static void main(String[] args) {

	}

	public void maxHeapify(int[] A, int i) {
		int l = left(i);
		int r = right(i);
		int largest;
		
		if(l <= A.length && A[l] > A[i]) largest = l;
		else largest = i;

		if(r <= A.length && A[r] > A[largest]) largest = r;
		else largest = i;
		
		if(largest != i){
			//to do swap properly.
			A[i] = A[largest];
			maxHeapify(A, largest);
		}
		
		
	}

	public void buildMaxHeap(int[] A) {
//		A.heap-size = A.length;
//		for(int i = Math.floor(A.length/2))
	}

	public void heapsort(int[] A) {

	}

	public int left(int i) {
		return 2 * i;
	}

	public int right(int i) {
		return 2 * i + 1;
	}

}
