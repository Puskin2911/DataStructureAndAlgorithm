package hw2_18001142;

public class SelectionSort {
	public static void sort(int[] array) {
		int compareTimes = 0;
		int swapTimes = 0;
		for(int i = 0; i < array.length; i++) {
			int flagMin = i;
			for(int j = i + 1; j < array.length; j++) {
				if(array[j] < array[flagMin]) {
					flagMin = j;
				}
				compareTimes++;
			}
			if(i != flagMin) {
				int temp = array[i];
				array[i] = array[flagMin];
				array[flagMin] = temp;
				swapTimes++;
				SortArray.printArray(array);
			}
		}
		System.out.println("Comparisons: " + compareTimes);
		System.out.println("Swaps: " + swapTimes);
	}
	
	public static void main(String[] args) {
		int[] array = SortArray.getArray(20, 100);
		
		sort(array);
	}
}
