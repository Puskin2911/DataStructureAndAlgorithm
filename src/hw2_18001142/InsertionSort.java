package hw2_18001142;

public class InsertionSort {
	public static void sort(int[] array) {
		int compareTimes = 0;
		int swapTimes = 0;
		for(int i = 1; i < array.length; i++) {
			int key = array[i];
			int left = i - 1;
			if(array[left] <= key) compareTimes++;
			while(left >= 0 && array[left] > key) {
				array[left + 1] = array[left];
				array[left] = key;
				left--;
				swapTimes++;
				compareTimes++;
				SortArray.printArray(array);
			}
		}
		System.out.println("Comparisons: " + compareTimes);
		System.out.println("Swaps: " + swapTimes);
	}
	
	public static void main(String[] args) {
		int[] array = SortArray.getArray(15, 100);
		
		sort(array);
	}
}
