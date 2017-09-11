package maxSubarray;

public class maxSubarray {

	public static void main(String[] args) {
		maxSubarray pleaseRun = new maxSubarray();
		pleaseRun.monitor();
	}

	public void monitor() {
		int[] mainArray = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };

		SubArray answer = findMaximumSubarray(mainArray, 0, 15);

		System.out.println(answer.toString());

	}

	public SubArray findMaximumSubarray(int[] a, int low, int high) {
		if (high == low) {
			return new SubArray(low, high, a[low]);
		} else {
			int mid = (int) Math.floor((low + high) / 2);

			SubArray leftSub = findMaximumSubarray(a, low, mid);
			SubArray rightSub = findMaximumSubarray(a, mid + 1, high);
			SubArray crossSub = findMaxCrossingSubarray(a, low, mid, high);

			if (leftSub.sum >= rightSub.sum && leftSub.sum >= crossSub.sum) {
				return leftSub;
			} else if (rightSub.sum >= leftSub.sum && rightSub.sum >= crossSub.sum) {
				return rightSub;
			} else
				return crossSub;
		}
	}

	public SubArray findMaxCrossingSubarray(int[] a, int low, int mid, int high) {
		int leftSum = Integer.MIN_VALUE;
		int sum = 0, maxRight = 0, maxLeft = 0;

		for (int i = mid; i > low; i--) {
			sum += a[i];
			if (sum > leftSum) {
				leftSum = sum;
				maxLeft = i;
			}
		}
		int rightSum = Integer.MIN_VALUE;
		sum = 0;
		for (int j = mid + 1; j < high; j++) {
			sum += a[j];
			if (sum > rightSum) {
				rightSum = sum;
				maxRight = j;
			}
		}
		return new SubArray(maxLeft, maxRight, leftSum + rightSum);
	}

	class SubArray {
		int left;
		int right;
		int sum;

		SubArray(int left, int right, int sum) {
			this.left = left;
			this.right = right;
			this.sum = sum;
		}

		public String toString() {
			return "left value is = " + left + " right value is = " + right + " sum is = " + sum + " using divide and conquor";
		}
	}
}
