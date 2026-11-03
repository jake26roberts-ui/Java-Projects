import java.util.Arrays;

public class ArrayManipulation {
	
	public static void main(String[] args) {

			// Storing the values in the arrays
		int[] numbers1 = {4, 11, 5, 10, 7, 6, 8, 9};	// No duplicates
		int[] numbers2 = {5, 6, 3, 8, 8, 7, 4, 5};		// 5 & 8 duplicate twice
		int[] numbers3 = {3, 3, 4, 3, 6, 3};			// 3 is duplicated 4 times
		
			// Displaying the original arrays
		
		System.out.println("*************************************");
		System.out.println("Origional Arrays");
		System.out.println("*************************************\n");
		
		display(numbers1, "numbers1");
		display(numbers2, "numbers2");
		display(numbers3, "numbers3");
		
			// Reassigning the arrays to new arrays without duplicates and sorting them
		int[] numbers1WithoutDuplicates = createArrayWithoutDuplicates(numbers1);
		int[] numbers2WithoutDuplicates = createArrayWithoutDuplicates(numbers2);
		int[] numbers3WithoutDuplicates = createArrayWithoutDuplicates(numbers3);
		
		
		Arrays.sort(numbers1WithoutDuplicates);
		Arrays.sort(numbers2WithoutDuplicates);
		Arrays.sort(numbers3WithoutDuplicates);
		System.out.println("\n");
			// Displaying the final arrays without duplicates and sorted
		System.out.println("**********************");
		System.out.println("No Duplicates and Sorted");
		System.out.println("**********************");
		
		display(numbers1WithoutDuplicates, "numbers 1 - No Duplicate Values & Sorted");
		System.out.println("\n");
		
		display(numbers2WithoutDuplicates, "numbers 2 - No Duplicate Values & Sorted");
		System.out.println("\n");
		
		display(numbers3WithoutDuplicates, "numbers 3 - No Duplicate Values & Sorted");
		System.out.println("\n");
		
		
			// Displaying common elements
		int[] commonElements = findCommonElements(numbers1WithoutDuplicates, numbers2WithoutDuplicates);
		
		commonElements = findCommonElements(commonElements, numbers3WithoutDuplicates);
		
		System.out.println("**********************");
		System.out.println("Finding Common Elements");
		System.out.println("**********************");
		
		display(commonElements, "Common Elements Between 3 Arrays");
		
		
	}	// end main method
	
	
	public static void display(int[] array, String ArrayName) {
		System.out.println("\n" + ArrayName);
		System.out.println("\n--------------------------------------------------\n");
		for (int i = 0; i < array.length; i++) {
			System.out.print("Array[" + i + "] = " + array[i] + "\n");
		}	// end for loop

	}	// end display method
	
	
	public static int[] createArrayWithoutDuplicates(int[] arrayWithDuplicates) {
		
			// A temporary array to assign values to.
		int[] tempArray = new int[arrayWithDuplicates.length];
			// keep track of the number of unique numbers
		int uniqueCount = 0;
		for (int i = 0; i < arrayWithDuplicates.length; i++) {
				// boolean starts as false so that when it runs through the for loop, it can change to true
			boolean duplicate = false;
			
			for (int j = 0; j < uniqueCount; j++) {
				if (arrayWithDuplicates[i] == tempArray[j]) {
					duplicate = true;
				}	// end inner for loop
			
			
			}	// end outer for loop
			if (!duplicate) {
				tempArray[uniqueCount] = arrayWithDuplicates[i];
				uniqueCount++;
			}	// end if statement
		
			
		}	// end for loop
		
		int [] uniqueArray = new int[uniqueCount];
		
		for (int i = 0; i < uniqueCount; i++) {
			uniqueArray[i] = tempArray[i];
		}	// end for loop
		
		return uniqueArray;
	}	// end createArrayWithoutDuplicates method
	
	public static int[] findCommonElements(int[] array1, int[] array2) {
		
		int [] tempArray = new int[Math.min(array1.length, array2.length)];
		int commonCount = 0;
		
		for (int i = 0; i < array1.length; i++) {
			for (int j=0; j < array2.length; j++) {
				if (array1[i] == array2[j]) {
					tempArray[commonCount] = array1[i];
					commonCount++;
					break;	// Break to avoid counting duplicates in array2
				}	// end if statement
			}	// end inner for loop
		}	// end for loop
		int[] commonArray = new int[commonCount];
		for (int i = 0; i < commonCount; i++) {
			commonArray[i] = tempArray[i];
		}	// end for loop
		return commonArray;
		
	}	// end findCommonElements method

}	// end class
