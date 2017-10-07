package hireAssistant;

import java.util.Random;

public class RandomHireAssistant {
	public static void main(String[] args){
		int[] assistants = { 1, 3, 5, 6, 9, 10};
		System.out.println("Array before randomization");
		printer(assistants);
		randomizeInPlace(assistants);
		System.out.println();
		System.out.println("Array after randomization");
		printer(assistants);
		
		System.out.println();
		System.out.println("Assistant # " + randomizedHireAssistant(assistants) +" hired.");
	}
	
	public static int randomizedHireAssistant(int[] assistants){
		int bestAssistant = 0;
		for(int assistant : assistants){
			if(assistant > bestAssistant){
				bestAssistant = assistant;
			}
		}
		return bestAssistant;
	}
	
	public static void randomizeInPlace(int[] assistants){
		int n = assistants.length;
		for(int i = 0; i < n; i++){
			int randomIndex = random(i, n);
			int t = assistants[i];
			assistants[i] = assistants[randomIndex];
			assistants[randomIndex] = t;
		}
	}
	
	public static int random(int i, int n){
        int random = (int) new Random().nextInt(n - i) + i;
        return random;
	}
	
	public static void printer(int[] array){
		System.out.print("{ ");
		for(int a : array){
			System.out.print(a + " ");
		}
		System.out.print("}");
	}
	
	
}
