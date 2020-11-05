package hw6_18001142;

public class MinHeapPriorityQueue<K extends Comparable<K>, E> extends SortedArrayPriorityQueue<K, E> {

	ArrEntry heapPQ[];

	protected void upHeap() {
		int i = n;
		while (i > 1 && heapPQ[i / 2].getKey().compareTo(heapPQ[i].getKey()) > 0) {
			ArrEntry entry = heapPQ[i / 2];
			heapPQ[i / 2] = heapPQ[i];
			heapPQ[i] = entry;

			i /= 2;
		}
	}

	protected void downHeap() {
		int i = 1;
		while (i < n) {
			if (2 * i + 1 < n) {
				if (heapPQ[i].getKey().compareTo(heapPQ[2 * i].getKey()) < 0
						&& heapPQ[i].getKey().compareTo(heapPQ[2 * i + 1].getKey()) < 0) {
					return;
				} else {
					int j;
					if (heapPQ[2 * i].getKey().compareTo(heapPQ[2 * i + 1].getKey()) < 0)
						j = 2 * i;
					else
						j = 2 * i + 1;

					ArrEntry entry = heapPQ[i];
					heapPQ[i] = heapPQ[j];
					heapPQ[j] = entry;
					i = j;
				}
			} else {
				if(2 * i < n) {
					if(heapPQ[i].getKey().compareTo(heapPQ[2 * i].getKey()) > 0) {
						ArrEntry entry = heapPQ[i];
						heapPQ[i] = heapPQ[2 * i];
						heapPQ[2 * i] = entry;
					}
					return;
				}
				return;
			}
		}
	}

	@SuppressWarnings("unchecked")
	public MinHeapPriorityQueue() {
		heapPQ = new SortedArrayPriorityQueue.ArrEntry[defaultsize];
	}

	@SuppressWarnings("unchecked")
	public MinHeapPriorityQueue(int capacity) {
		heapPQ = new SortedArrayPriorityQueue.ArrEntry[capacity];
	}

	@Override
	public void insert(K key, E element) {
		if (n == heapPQ.length)
			return;
		heapPQ[++n] = new ArrEntry(key, element);
		upHeap();
	}

	@Override
	public Entry<K, E> min() {
		return heapPQ[1];
	}

	@Override
	public Entry<K, E> removeMin() {
		ArrEntry entry = heapPQ[1];
		heapPQ[1] = heapPQ[n];
		n--;
		downHeap();
		
		return entry;
	}

	@Override
	public void print() {
		for (int i = 1; i <= n; i++) {
			System.out.print(heapPQ[i].getValue() + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		MinHeapPriorityQueue<Integer, String> pQueue = new MinHeapPriorityQueue<Integer, String>(10);

		pQueue.insert(1, "Hulk");
		pQueue.insert(2, "Puskin");
		pQueue.insert(3, "Panda");
		pQueue.insert(6, "Thanh");
		pQueue.insert(7, "An");

		pQueue.insert(0, "Dang");
		pQueue.print();
		pQueue.insert(10, "Phuong");
		pQueue.insert(100, "@@");

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
