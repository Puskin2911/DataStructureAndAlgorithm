package hw2_18001142;

import java.util.Random;
import java.util.Scanner;

public class SortArray {
	public static Scanner scanner = new Scanner(System.in);
	
	public static int[] inputArray(int length) {
		int[] array = new int[length];
		for(int i = 0; i < length; i++) {
			array[i] = scanner.nextInt();
		}
		return array;
	}
	
	public static int[] getArray(int length, int bound) {
		Random random = new Random();
		int[] array = new int[length];
		for(int i = 0; i < length; i++) {
			array[i] = random.nextInt(bound);
		}
		return array;
	}
	
	public static void printArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] array = getArray(15, 100);
		
		System.out.println("Bubble sort --------------");
		BubbleSort.sort(array);
		System.out.println("Selection sort --------------");
		SelectionSort.sort(array);
		System.out.println("Insertion sort --------------");
		InsertionSort.sort(array);
	}

	public static <T> void printArray(T[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
