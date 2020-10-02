package hw2_18001142;

public class GenericSort<T> {
	public <T extends Comparable<T>> void bubbleSort(T[] array) {
		int compareTimes = 0;
		int swapTimes =  0;
		for(int i = 0; i < array.length; i++) {
			boolean sorted = true;
			for(int j = 0; j < array.length - 1; j++) {
				if(array[j].compareTo(array[j + 1]) > 0) {
					T temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					sorted = false;
					swapTimes++;
					SortArray.printArray(array);
				}
				compareTimes++;	
			}
		}
		System.out.println("Comparisons: " + compareTimes);
		System.out.println("Swaps: " + swapTimes);
	}
	
	public <T extends Comparable<T>> void selectionSort(T[] array) {
		int compareTimes = 0;
		int swapTimes = 0;
		for(int i = 0; i < array.length; i++) {
			int flagMin = i;
			for(int j = i + 1; j < array.length; j++) {
				if(array[j].compareTo(array[flagMin]) < 0) {
					flagMin = j;
				}
				compareTimes++;
			}
			if(i != flagMin) {
				T temp = array[i];
				array[i] = array[flagMin];
				array[flagMin] = temp;
				swapTimes++;
				SortArray.printArray(array);
			}
		}
		System.out.println("Comparisons: " + compareTimes);
		System.out.println("Swaps: " + swapTimes);
	}
	
	public <T extends Comparable<T>> void insertionSort(T[] array) {
		int compareTimes = 0;
		int swapTimes = 0;
		for(int i = 1; i < array.length; i++) {
			T key = array[i];
			int left = i - 1;
//			while(left >= 0 && array[left] > key) {
//				array[left + 1] = array[left];
//				left--;
//				swapTimes++;
//			}
//			compareTimes++;
//			array[left + 1] = key;
//			SortArray.printArray(array);
			if(array[left].compareTo(key) <= 0) compareTimes++;
			while(left >= 0 && array[left].compareTo(key) > 0) {
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
}
