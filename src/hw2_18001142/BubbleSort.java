package hw2_18001142;

import java.util.Scanner;

public class BubbleSort{
	public static void sort(int[] array) {
		int compareTimes = 0;
		int swapTimes =  0;
		for(int i = 0; i < array.length; i++) {
			boolean sorted = true;
			for(int j = 0; j < array.length - 1; j++) {
				if(array[j] > array[j + 1]) {
					int temp = array[j];
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
	
	public static void main(String[] args) {
		int[] array = SortArray.getArray(20, 100);
		
		sort(array);
	}
}
