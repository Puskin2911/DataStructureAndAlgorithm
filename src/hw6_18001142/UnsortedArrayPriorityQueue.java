package hw6_18001142;

public class UnsortedArrayPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {
	protected class ArrEntry implements Entry<K, E> {
		K key;
		E element;

		public ArrEntry(K key, E element) {
			this.key = key;
			this.element = element;
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public E getValue() {
			return element;
		}
	}

	ArrEntry[] array;
	int n = 0;
	int defaultsize = 1000;

	@SuppressWarnings("unchecked")
	public UnsortedArrayPriorityQueue() {
		array =  new UnsortedArrayPriorityQueue.ArrEntry[defaultsize];
	}

	@SuppressWarnings("unchecked")
	public UnsortedArrayPriorityQueue(int capacity) {
		array = new UnsortedArrayPriorityQueue.ArrEntry[capacity];
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
	public void insert(Entry<K, E> entry) {
		if (n == array.length)
			return;
		array[n++] = (ArrEntry) entry;
	}

	@Override
	public void insert(K key, E element) {
		if (n == array.length)
			return;
		array[n++] = new ArrEntry(key, element);
	}

	@Override
	public Entry<K, E> removeMin() {
		Entry<K, E> minEntry = this.min();
		for (int i = 0; i < n; i++) {
			if (minEntry.getKey().compareTo(array[i].getKey()) == 0) {
				for (int j = i; j < n - 1; j++) {
					array[j] = array[j + 1];
				}
				array[n - 1] = null;
				n--;
				return minEntry;
			}
		}
		return minEntry;
	}

	@Override
	public Entry<K, E> min() {
		Entry<K, E> minEntry = array[0];
		for (int i = 0; i < n; i++) {
			if (minEntry.getKey().compareTo(array[i].getKey()) > 0) {
				minEntry = array[i];
			}
		}
		return minEntry;
	}

	public void print() {
		for (int i = 0; i < n; i++) {
			System.out.print(array[i].getValue() + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		UnsortedArrayPriorityQueue<Integer, String> pQueue = new UnsortedArrayPriorityQueue<Integer, String>();

		pQueue.insert(1, "Hulk");
		pQueue.insert(2, "Puskin");
		pQueue.insert(3, "Panda");

		pQueue.insert(6, "Thanh");
		pQueue.insert(7, "An");

		pQueue.insert(5, "Dang");
		pQueue.insert(10, "Phuong");
		pQueue.insert(0, "@@");

		pQueue.print();

		System.out.println("Size: " + pQueue.size());
		System.out.println(pQueue.min().getValue());

		pQueue.removeMin();

		pQueue.print();
		System.out.println("Size: " + pQueue.size());

		pQueue.removeMin();

		pQueue.print();
		System.out.println("Size: " + pQueue.size());
	}
}
