package hw3_18001142;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArrayList<E> implements ListInterface<E> {
	private E[] array;
	private int n = 0;
	private static final int defaultSize = 100;
	private int capacity;
	private static final int expandSize = 32;

	/**
	 * Constructs an empty list.
	 */
	@SuppressWarnings("unchecked")
	public SimpleArrayList() {
		array = (E[]) new Object[defaultSize];
		capacity = defaultSize;
	}

	/**
	 * Constructs an empty list with init capacity
	 * 
	 * @param capacity number of init element
	 */
	@SuppressWarnings("unchecked")
	public SimpleArrayList(int capacity) {
		if (capacity < 0)
			throw new IllegalArgumentException("Illegal Capacity: " + capacity);
		this.capacity = capacity;
		array = (E[]) new Object[capacity];
	}

	@Override
	public Iterator<E> iterator() {
		Iterator<E> it = new Iterator<E>() {

			private int currentIndex = 0;

			@Override
			public boolean hasNext() {
				return currentIndex < n;
			}

			@Override
			public E next() {
				if (!hasNext())
					throw new NoSuchElementException("Current iterator have no next element");
				return array[currentIndex++];
			}
		};
		return it;
	}

	@Override
	public boolean add(E element) {
		if (element == null)
			throw new NullPointerException("Element must be not null");
		if (n >= capacity) {
			array = Arrays.copyOf(array, array.length + expandSize);
		}
		array[n] = element;
		n++;
		return true;
	}

	@Override
	public E get(int index) {
		if (index < 0 || index >= n)
			throw new IndexOutOfBoundsException(index);
		return array[index];
	}

	@Override
	public void set(int index, E element) {
		if (index < 0 || index >= n)
			throw new IndexOutOfBoundsException(index);
		if (element == null)
			throw new NullPointerException("Element must be not null");
		array[index] = element;
	}

	@Override
	public E remove(int index) {
		if (index < 0 || index >= n)
			throw new IndexOutOfBoundsException(index);

		E element = array[index];
		for (int i = index; i < n - 1; i++) {
			array[i] = array[i + 1];
		}
		array[n - 1] = null;
		n--;

		return element;
	}

	@Override
	public boolean remove(E element) {
		if (element == null)
			throw new NullPointerException("Element must be not null");
		if (n == 0)
			throw new NoSuchElementException("List is empty");
		for (int i = 0; i < n; i++) {
			if (Objects.equals(array[i], element)) {
				for (int index = i; index < n - 1; index++) {
					array[index] = array[index + 1];
				}
				n--;
				return true;
			}
		}
		return false;
	}

	@Override
	public int indexOf(E element) {
		if (element == null)
			throw new NullPointerException("Element must be not null");
		for (int i = 0; i < n; i++) {
			if (Objects.equals(array[i], element)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean isContain(E element) {
		if (element == null)
			throw new NullPointerException("Element must be not null");
		for (int i = 0; i < n; i++) {
			if (Objects.equals(array[i], element))
				return true;
		}
		return false;
	}

	@Override
	public int size() {
		return n;
	}

	@Override
	public boolean isEmpty() {
		return n == 0;
	}

	@Override
	public String toString() {
		String res = "";
		for (E element : this) {
			res += element + "\n";
		}
		return res;
	}
}