package hireAssistant;

import java.util.Random;
import java.util.TreeMap;

public class permuteHireAssistant {

	public static void main(String[] args){
		int[] assistants = { 1, 3, 5, 6, 9, 10};
		System.out.println("Array before randomization");
		printer(assistants);
		
		permuteBySorting(assistants);
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
	
	public static void permuteBySorting(int[] assistants){
		int n = assistants.length;
		int[] P = new int[n];
		for( int i = 0; i < n; i ++){
			P[i] = random(1, Math.pow(n, 3));
		}
		//Calls method that creates a TreeMap from the 2 arrays
		TreeMap<Integer, Integer> map = createMap(P, assistants);
		
		Object[] newAssistants = map.values().toArray();
		
		for(int i = 0; i < assistants.length; i++){
			assistants[i] = (int) newAssistants[i];
			
		}
		
	}
	
	public static int random(int i, double n){
		int x = (int) n;
        int random = (int) new Random().nextInt(x - i) + i;
        return random;
	}
	
	
	public static TreeMap<Integer, Integer> createMap(int[] P, int[] assistants){
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for(int i =0; i < P.length; i++){
			map.put(P[i], assistants[i]);
		}
		return map;
	}
	
	public static void printer(int[] array){
		System.out.print("{ ");
		for(int a : array){
			System.out.print(a + " ");
		}
		System.out.print("}");
	}
}
