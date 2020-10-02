package hw1_18001142;

import java.util.Scanner;

public class ArrayManipulation {
	public Scanner input = new Scanner(System.in);
	
	public <T extends Comparable<T>> void sort(T[] array) {
		for(int i = 0; i < array.length -1; i++) {
			for(int j = i + 1; j < array.length; j++) {
				if(array[i].compareTo(array[j]) > 0) {
					T temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}
	
	public void inputArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			array[i] = input.nextInt(); 
		}
	}
	
	// index of T element in array
	public <T extends Comparable<T>> int findIndex(T[] array, T element) {
		for(int i = 0; i < array.length; i++) {
			if(array[i].compareTo(element) == 0) {
				return i;
			}
		}
		return -1;
	}
	
	public <T> void printArray(T[] array){
		for(T element : array) {
			System.out.println(element);
		}
	}
	
	public static void main(String[] args) {
		ArrayManipulation am = new ArrayManipulation();
		
		int[] array_int = new int[10];
		Integer[] array_integer = new Integer[10];
		am.inputArray(array_int);
		for(int i = 0; i < array_int.length; i++) {
			array_integer[i] = array_int[i];
		}
		
		Integer element = new Integer(5);
		am.sort(array_integer);
		System.out.println("element at: " + am.findIndex(array_integer, 5));
		am.printArray(array_integer);
	}
}
