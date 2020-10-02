package hw3_18001142;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinkedList<E> implements ListInterface<E> {
	private static class Node<E> {
		E data;
		Node<E> next;

		Node(E element) {
			this.data = element;
			next = null;
		}
	}

	private Node<E> top = null;
	private Node<E> bot = null;
	private int size = 0;

	/**
	 * Constructs an empty list.
	 */
	public SimpleLinkedList() {
	}

	@Override
	public boolean add(E element) {
		return addBot(element);
	}

	/**
	 * Add an element at last of list
	 * 
	 * @param element element to be appended to this list
	 * @throws NullPointerException if the specified element is null and this list
	 *                              does not permit null elements
	 * 
	 */
	public boolean addBot(E element) {
		if (element == null)
			throw new NullPointerException("Element must be not null");
		final Node<E> newNode = new Node<>(element);
		if (top == null) {
			top = bot = newNode;
		} else {
			bot.next = newNode;
			bot = newNode;
		}
		size++;
		return true;
	}

	/**
	 * Add an element at first of list
	 * 
	 * @param element element to be insert at first to this list
	 * @throws NullPointerException if the specified element is null and this list
	 *                              does not permit null elements
	 * 
	 */
	public boolean addTop(E element) {
		if (element == null)
			throw new NullPointerException("Element must be not null");
		final Node<E> newNode = new Node<>(element);
		if (top == null) {
			top = bot = newNode;
		} else {
			newNode.next = top;
			top = newNode;
		}
		size++;
		return true;
	}

	@Override
	public E get(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException(index);
		int i = 0;
		Node<E> node = top;
		while (i < index - 1) {
			i++;
			node = node.next;
		}

		E element = node.data;

		return element;
	}

	@Override
	public void set(int index, E element) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException(index);
		if (element == null)
			throw new NullPointerException("Element must be not null");
		// Get Node at index
		int i = 0;
		Node<E> node = top;
		while (i < index - 1 && node != null) {
			i++;
			node = node.next;
		}

		node.data = element;
	}

	public boolean isContain(E data) {
		Node<E> node = top;

		while (node != null) {
			if (node.data.equals(data)) {
				return true;
			}
			node = node.next;
		}

		return false;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E removeTop() {
		if (size == 0)
			throw new NoSuchElementException("List is empty");
		E data = top.data;
		top = top.next;
		size--;
		return data;
	}

	/**
	 * Remove last element of list
	 * 
	 * @return element removed
	 * @throws IllegalStateException if list is empty
	 */
	public E removeBot() {
		if (size == 0)
			throw new NoSuchElementException("List is empty");

		// size = 1
		if (top.next == null) {
			E element = top.data;
			top = bot = null;
			size = 0;
			return element;
		}

		// Get previous Node of tail
		Node<E> node = top;
		while (node.next.next != null) {
			node = node.next;
		}

		E element = node.next.data;
		bot = node;
		bot.next = null;
		size--;

		return element;
	}

	@Override
	public E remove(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException(index);
		if (index == 0)
			return removeTop();
		if (index == size - 1)
			return removeBot();
		else {
			Node<E> oldNode = top;
			// Find node at index - 1;
			while (oldNode != null && index > 1) {
				index--;
				oldNode = oldNode.next;
			}
			E element = oldNode.data;
			oldNode.next = oldNode.next.next;
			size--;
			return element;
		}
	}

	@Override
	public boolean remove(E element) {
		if (element == null)
			throw new NullPointerException("Element must be not null");
		if (top == null)
			return false;
		Node<E> node = top;
		while (node.next != null) {
			if (node.next.data.equals(element)) {
				node.next = node.next.next;
				size--;
				return true;
			}
			node = node.next;
		}
		if (top.data.equals(element)) {
			top = top.next;
			size--;
			return true;
		}
		return false;
	}

	@Override
	public int indexOf(E element) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<E> iterator() {
		Iterator<E> iter = new Iterator<E>() {
			private Node<E> lastReturned;
			private Node<E> next = top;
			private int nextIndex = 0;

			@Override
			public boolean hasNext() {
				return next != null;
			}

			@Override
			public E next() {
				if (!hasNext())
					throw new NoSuchElementException("List is empty");
				lastReturned = next;
				next = next.next;
				nextIndex++;

				return lastReturned.data;
			}

			@Override
			public void remove() {
				if (lastReturned == null)
					throw new IllegalStateException();
				SimpleLinkedList.this.remove(nextIndex - 1);
				nextIndex--;
				lastReturned = null;
			}
		};
		return iter;
	}

	/**
	 * Returns an backward iterator over elements of type E.
	 * 
	 * @return an iterator
	 */
	public Iterator<E> backwardIterator() {
		return new BackwardIterator();
	}

	private class BackwardIterator implements Iterator<E> {
//		private Node<E> lastReturned;
		private Node<E> next;
//		private int nextIndex;

		public BackwardIterator() {
//			lastReturned = null;
			next = bot;
//			nextIndex = size - 1;
		}

		@Override
		public boolean hasNext() {
			return next != null;
		}

		@Override
		public E next() {
			// TODO Doubly Linked Implement for this
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			Iterator.super.remove();
		}

	}
}
