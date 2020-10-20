package hw4_18001142;

import java.util.EmptyStackException;
import java.util.Iterator;

public class LinkedListStack<E> implements StackInterface<E> {
	private static class Node<E> {
		E element;
		Node<E> next;

		public Node(E data) {
			element = data;
			next = null;
		}
	}

	Node<E> top = null;

	@Override
	public Iterator<E> iterator() {
		return new StackIterator();
	}

	@Override
	public void push(E element) {
		if (element == null)
			throw new NullPointerException("Element must be not null");
		Node<E> node = new Node<>(element);
		node.next = top;
		top = node;
	}

	@Override
	public E pop() {
		if (top == null)
			throw new EmptyStackException();

		E element = top.element;
		top = top.next;
		return element;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public E top() {
		if (top == null)
			throw new EmptyStackException();
		return top.element;
	}

	@Override
	public String toString() {
		String res = "";
		Node<E> node = top;
		while (node != null) {
			res = res.concat(String.valueOf(node.element)).concat(" ");
			node = node.next;
		}
		return res;
	}

	class StackIterator implements Iterator<E> {
		private Node<E> nextNode = top;

		@Override
		public boolean hasNext() {
			return nextNode != null;
		}

		@Override
		public E next() {
			E data = nextNode.element;
			nextNode = nextNode.next;
			return data;

		}
	}
}
