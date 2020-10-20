package hw4_18001142;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListQueue<E> implements QueueInterface<E> {
	private static class Node<E> {
		E data;
		Node<E> next;

		Node(E element) {
			data = element;
			next = null;
		}
	}

	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;

	@Override
	public Iterator<E> iterator() {
		return new QueueIterator();
	}

	@Override
	public void enqueue(E element) {
		if (element == null)
			throw new NullPointerException("Element must be not null");
		Node<E> node = new Node<>(element);
		if (head == null) {
			head = tail = node;
		} else {
			tail.next = node;
			tail = node;
			size++;
		}
	}

	@Override
	public E dequeue() {
		if (head == null)
			throw new NoSuchElementException("Queue is empty");
		E element = head.data;
		head = head.next;
		size--;
		return element;
	}

	@Override
	public E front() {
		if (head == null)
			throw new NoSuchElementException("Queue is empty");
		return head.data;
	}

	@Override
	public E rear() {
		if (head == null)
			throw new NoSuchElementException("Queue is empty");
		return tail.data;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public String toString() {
		String res = "";

		Node<E> node = head;
		while (node != null) {
			res = res.concat(String.valueOf(node.data)).concat(" ");
			node = node.next;
		}

		return res;
	}

	class QueueIterator implements Iterator<E> {
		private Node<E> currentNode = head;

		@Override
		public boolean hasNext() {
			return currentNode != null;
		}

		@Override
		public E next() {
			E element = currentNode.data;
			currentNode = currentNode.next;
			return element;
		}

	}
}
