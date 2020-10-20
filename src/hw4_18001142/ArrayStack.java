package hw4_18001142;

import java.util.EmptyStackException;
import java.util.Iterator;

public class ArrayStack<E> implements StackInterface<E> {
	private E[] arr;
	private int defaultSize = 100;
	private int index = 0;

	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity) {
		arr = (E[]) new Object[capacity];
	}

	@SuppressWarnings("unchecked")
	public ArrayStack() {
		arr = (E[]) new Object[defaultSize];
	}

	@Override
	public Iterator<E> iterator() {
		Iterator<E> it = new Iterator<E>() {
			private int currentIndex = index - 1;

			@Override
			public boolean hasNext() {
				return currentIndex >= 0;
			}

			@Override
			public E next() {
				return arr[currentIndex--];
			}
		};
		return it;
	}

	@Override
	public void push(E element) {
		if (element == null)
			throw new NullPointerException("Element must be not null");
		if (index == arr.length) {
			throw new StackOverflowError("Stack is full");
		}
		arr[index] = element;
		index++;
	}

	@Override
	public E pop() {
		if (index == 0) {
			throw new EmptyStackException();
		}
		E data = arr[index - 1];
		index--;
		return data;
	}

	@Override
	public boolean isEmpty() {
		return index == 0;
	}

	@Override
	public E top() {
		if (index == 0) {
			throw new EmptyStackException();
		}
		return arr[index - 1];
	}

	@Override
	public String toString() {
		String result = "";

		for (int i = 0; i < index; i++) {
			result = result.concat(String.valueOf(arr[i])).concat(" ");
		}

		return result;
	}
}
