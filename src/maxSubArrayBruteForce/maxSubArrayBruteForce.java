package maxSubArrayBruteForce;

public class maxSubArrayBruteForce {
	public static void main(String[] args){
		
		int[] array = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12 , -5, -22, 15, -4, 7};
		int leftIndex = 0, rightIndex = 0, maxSum = 0;
		
		for(int i = 0; i < array.length; i++){
			if(array[i] > maxSum){
				leftIndex = i;
				rightIndex = i;
				maxSum = array[i];
			}
			for(int j = i; j < array.length; j++){
				int currentSum = array[i] + array[j];
				if(currentSum > maxSum && i != j){
					sum = currentSum;
					leftIndex = i;
					rightIndex = j;
				}
			}
		}		
		System.out.println("left index is: " + leftIndex + " rightIndex is: " + rightIndex + " sum is: " + sum + " using the brute force method");
	}
}