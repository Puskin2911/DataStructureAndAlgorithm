package hw6_18001142;

public interface PriorityQueueInterface<K, E> {
	public int size();
	public boolean isEmpty();
	public void insert(Entry<K, E> entry);
	public void insert(K key, E element);
	public Entry<K, E> removeMin();
	public Entry<K, E> min();
}
