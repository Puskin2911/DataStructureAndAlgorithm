package hw6_18001142;

public class SortedArrayPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {

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
	public SortedArrayPriorityQueue() {
		array = new SortedArrayPriorityQueue.ArrEntry[defaultsize];
	}

	@SuppressWarnings("unchecked")
	public SortedArrayPriorityQueue(int capacity) {
		array = new SortedArrayPriorityQueue.ArrEntry[capacity];
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

		if (n == 0) {
			array[n++] = (ArrEntry) entry;
			return;
		}

		if (entry.getKey().compareTo(this.min().getKey()) < 0) {
			array[n++] = (ArrEntry) entry;
			return;
		}

		for (int i = n - 1; i >= 0; i--) {
			if (entry.getKey().compareTo(array[i].getKey()) < 0) {
				for (int j = n; j > i + 1; j--) {
					array[j] = array[j - 1];
				}
				array[i + 1] = (ArrEntry) entry;
				n++;
				return;
			}
		}

		for (int i = n; i > 0; i--) {
			array[i] = array[i - 1];
		}
		n++;
		array[0] = (ArrEntry) entry;
	}

	@Override
	public void insert(K key, E element) {
		if (n == array.length)
			return;

		if (n == 0) {
			array[n++] = new ArrEntry(key, element);
			return;
		}

		if (key.compareTo(this.min().getKey()) < 0) {
			array[n++] = new ArrEntry(key, element);
			return;
		}

		for (int i = n - 1; i >= 0; i--) {
			if (key.compareTo(array[i].getKey()) < 0) {
				for (int j = n; j > i + 1; j--) {
					array[j] = array[j - 1];
				}
				array[i + 1] = new ArrEntry(key, element);
				n++;
				return;
			}
		}

		for (int i = n; i > 0; i--) {
			array[i] = array[i - 1];
		}
		n++;
		array[0] = new ArrEntry(key, element);
	}

	@Override
	public Entry<K, E> removeMin() {
		if (n == 0)
			return null;
		Entry<K, E> minEntry = array[n - 1];
		array[n - 1] = null;
		n--;
		return minEntry;
	}

	@Override
	public Entry<K, E> min() {
		if (n == 0)
			return null;
		return array[n - 1];
	}

	public void print() {
		for (int i = 0; i < n; i++) {
			System.out.print(array[i].getValue() + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		SortedArrayPriorityQueue<Integer, String> pQueue = new SortedArrayPriorityQueue<Integer, String>();

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
