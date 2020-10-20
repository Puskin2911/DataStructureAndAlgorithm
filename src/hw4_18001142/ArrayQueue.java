package hw4_18001142;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<E> implements QueueInterface<E> {
	private E[] queue;
	private int top = 0;
	private int size = 0;
	private int default_size = 100;

	@SuppressWarnings("unchecked")
	public ArrayQueue() {
		queue = (E[]) new Object[default_size];
	}

	@SuppressWarnings("unchecked")
	public ArrayQueue(int capacity) {
		queue = (E[]) new Object[capacity];
	}

	@Override
	public Iterator<E> iterator() {
		return new ArrayQueueIterator();
	}

	@Override
	public void enqueue(E element) {
		if (element == null)
			throw new NullPointerException("Element must be not null");
		if (size == queue.length)
			throw new IllegalStateException("Queue is full");
		int avaiableIndex = (top + size) % queue.length;
		queue[avaiableIndex] = element;
		size++;
	}

	@Override
	public E dequeue() {
		if (size == 0)
			throw new NoSuchElementException("Queue is empty");
		E element = queue[top];
		queue[top] = null;
		top = (top + 1) % queue.length;
		size--;
		return element;
	}

	@Override
	public E front() {
		return queue[top];
	}

	@Override
	public E rear() {
		return queue[(top + size - 1) % queue.length];
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	class ArrayQueueIterator implements Iterator<E> {
		private int current = top;

		private int num = 0;

		@Override
		public boolean hasNext() {
			return num < size;
		}

		@Override
		public E next() {
			E data = queue[(current + num) % queue.length];
			num++;
			return data;
		}
	}
}
