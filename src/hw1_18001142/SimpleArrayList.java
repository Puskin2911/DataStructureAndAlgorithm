package hw1_18001142;

import java.util.Iterator;

public class SimpleArrayList<T> implements ListInterface<T>{
	private T[] array;
	private int n = 0;
	private int defaultSize = 100;
	
	public SimpleArrayList() {
		array = (T[]) new Object[defaultSize];
	}
	
	public SimpleArrayList(int capacity) {
		array = (T[]) new Object[capacity];
	}
	

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(T data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T get(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set(int position, T data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(T data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void isContain(T data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
