package hw1_18001142;

public interface ListInterface<T> extends Iterable<T> {
	public void add(T data);
	public T get(int position);
	public void set(int position, T data);
	public void remove(T data);
	public void isContain(T data);
	public int size();
	public boolean isEmpty();
}
