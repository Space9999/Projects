import java.util.Arrays;
import java.util.Random;

public class SortingComp {

	public static void main(String[] args) {
		int[] array = new int[1000]; 
		Random rand = new Random();
		long before = 0;
		
		for (int i = 0; i < 999; i++) {array[i] = rand.nextInt(-1000, 1000);}
		int[] array2 = Arrays.copyOf(array, 1000), array3 = Arrays.copyOf(array, 1000);
		
		before = System.currentTimeMillis();
		doQuickSort(array, 0, 999);
		System.out.println("Time to sort in ms: " + (System.currentTimeMillis() - before));
		for (int i : array) {System.out.print(i + " ");}
		System.out.println("");
		
		before = System.currentTimeMillis();
		doInsertionSort(array2);
		System.out.println("Time to sort in ms: " + (System.currentTimeMillis() - before));
		for (int i : array2) {System.out.print(i + " ");}
		System.out.println("");
		
		
		before = System.currentTimeMillis();
		doBubbleSort(array3);
		System.out.println("Time to sort in ms: " + (System.currentTimeMillis() - before));
		for (int i : array3) {System.out.print(i + " ");}
		System.out.println("");
		
	}
	
	public static void doQuickSort(int[] array, int low, int high) {
		int pivotIndex = 0;
		if (high > low) {
			pivotIndex = partition(array, low, high);
			doQuickSort(array, low, pivotIndex-1);
	        doQuickSort(array, pivotIndex+1, high);
		}
	}
	
	private static int partition(int[] arr, int begin, int end) {
		int pivot = arr[end];
	    int i = (begin-1);

	    for (int j = begin; j < end; j++) {
	        if (arr[j] <= pivot) {
	            i++;
	            int swapTemp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = swapTemp;
	        }
	    }

	    int swapTemp = arr[i+1];
	    arr[i+1] = arr[end];
	    arr[end] = swapTemp;

	    return i+1;
	}
	
	public static void doInsertionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i];
			int j = i;
			while (j > 0 && arr[j - 1] > temp) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = temp;
		}
	}
	
	public static void doBubbleSort(int[] arr) {
		int i = 0;
		while (i < arr.length - 1) {
			int j = i + 1;
			while (j < arr.length) {
				if (arr[i] > arr[j]) {
					int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
				}
				j++;
			}
			i++;
		}
	}
	
}
