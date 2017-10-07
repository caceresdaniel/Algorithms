//PERMUTE-BY-SORTING(A)
// n = A:length
// let P [1 .... n] be a new array
// for i = 1 to n
// 		P [i] = RANDOM(1, n3)
//sort A, using P as sort keys

//RANDOMIZE-IN-PLACE.A/
//n D A:length
//for i = 1 to n
//swap A[i] with A[RANDOM(i,n)]


package hireAssistant;

public class RandomHireAssistant {
	public static void main(String[] args){
		
	}
	
	public void randomizedHireAssistant(int[] assistants){
		int bestAssistant = 0;
		for(int assistant : assistants){
			if(assistant > bestAssistant){
				bestAssistant = assistant;
			}
		}
	}
	
	public void randomizeInPlace(int[] assistants){
		int n = assistants.length;
		for(int assistant : assistants){
			
		}
		
	}
	
}
