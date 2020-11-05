package hw6_18001142;

import java.util.Arrays;
import java.util.Random;

public class SortAlgorithm {
	private int[] array;

	public SortAlgorithm(int length) {
		array = new int[length];
		for (int i = 0; i < array.length; i++) {
			array[i] = new Random().nextInt(100);
		}
	}

	public static double bubbleSort(int[] array) {
		long before = System.nanoTime();
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		return (System.nanoTime() - before) * 1.0 / 1000000;
	}

	public static double insertionSort(int[] array) {
		long before = System.nanoTime();
		for (int i = 1; i < array.length; i++) {
			int key = array[i];
			int left = i - 1;
			while (left >= 0 && array[left] > key) {
				array[left + 1] = array[left];
				array[left] = key;
				left--;
			}
		}
		return (System.nanoTime() - before) * 1.0 / 1000000;
	}

	public static double selectionSort(int[] array) {
		long before = System.nanoTime();
		for (int i = 0; i < array.length; i++) {
			int flagMin = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[flagMin]) {
					flagMin = j;
				}
			}
			if (i != flagMin) {
				int temp = array[i];
				array[i] = array[flagMin];
				array[flagMin] = temp;
			}
		}
		return (System.nanoTime() - before) * 1.0 / 1000000;
	}

	static int partition(int arr[], int low, int high) {
		int pivot = arr[high];
		int i = (low - 1); // index of smaller element
		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				i++;

				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}

	public static double quickSort(int arr[], int low, int high) {
		long before = System.nanoTime();
		if (low < high) {
			int pi = partition(arr, low, high);

			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
		return (System.nanoTime() - before) * 1.0 / 1000000;
	}

	public static void merge(int arr[], int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		int i = 0, j = 0;

		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	public static double mergeSort(int arr[], int l, int r) {
		long before = System.nanoTime();
		if (l < r) {
			int m = (l + r) / 2;

			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);

			merge(arr, l, m, r);
		}
		return (System.nanoTime() - before) * 1.0 / 1000000;
	}

	public static double heapSort(int[] array) {
		long before = System.nanoTime();

		MinHeapPriorityQueue<Integer, String> pQueue = new MinHeapPriorityQueue<Integer, String>(array.length + 1);

		for (int i = 0; i < array.length; i++) {
			pQueue.insert(array[i], "@@");
		}

		for (int i = 0; i < array.length; i++) {
			array[i] = pQueue.removeMin().getKey();
		}

		return (System.nanoTime() - before) * 1.0 / 1000000;
	}

	public void printArray() {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int length = 10;
		while(length <= 100000) {
			int[] array = new int[length];
			for (int i = 0; i < array.length; i++) {
				array[i] = new Random().nextInt(10000);
			}

//			System.out.println("Bubble sort: " + bubbleSort(Arrays.copyOf(array, array.length)) + "ms");
			System.out.println("Insertion sort: " + insertionSort(Arrays.copyOf(array, array.length)) + "ms");
			System.out.println("Selection sort: " + selectionSort(Arrays.copyOf(array, array.length)) + "ms");
			System.out.println("Quick sort: " + quickSort(Arrays.copyOf(array, array.length), 0, array.length - 1) + "ms");
			System.out.println("Merge sort: " + mergeSort(Arrays.copyOf(array, array.length), 0, array.length - 1) + "ms");
			System.out.println("Heap sort: " + heapSort(Arrays.copyOf(array, array.length)) + "ms");
			
			System.out.println("======================");
			
			length *= 10;
		}
		
	}
}
