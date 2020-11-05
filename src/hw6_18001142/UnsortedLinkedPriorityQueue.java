package hw6_18001142;

public class UnsortedLinkedPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {

	protected class NodeEntry implements Entry<K, E> {
		private K key;
		private E element;
		private NodeEntry next;

		public NodeEntry(K key, E element) {
			this.key = key;
			this.element = element;
		}

		@Override
		public K getKey() {
			return this.key;
		}

		@Override
		public E getValue() {
			return this.element;
		}
	}

	private NodeEntry head;
	int n = 0;

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
		NodeEntry nodeEntry = (NodeEntry) entry;
		nodeEntry.next = head;
		head = nodeEntry;
		n++;
	}

	@Override
	public void insert(K key, E element) {
		NodeEntry nodeEntry = new NodeEntry(key, element);
		nodeEntry.next = head;
		head = nodeEntry;
		n++;
	}

	@Override
	public Entry<K, E> removeMin() {
		if (head == null)
			return null;

		NodeEntry nodeEntry = head;
		Entry<K, E> minEntry = this.min();

		if (head.getKey().compareTo(minEntry.getKey()) == 0) {
			head = head.next;
			n--;
			return minEntry;
		}

		while (nodeEntry.next != null) {
			if (nodeEntry.next.getKey().compareTo(minEntry.getKey()) == 0) {
				nodeEntry.next = nodeEntry.next.next;
				n--;
				return minEntry;
			}
			nodeEntry = nodeEntry.next;
		}

		return minEntry;
	}

	@Override
	public Entry<K, E> min() {
		NodeEntry nodeItem = head;
		NodeEntry minEntry = head;
		while (nodeItem != null) {
			if (minEntry.getKey().compareTo(nodeItem.getKey()) >= 0) {
//				minEntry = new NodeEntry(nodeEntry.getKey(), nodeEntry.getValue());
				minEntry = nodeItem;
			}
			nodeItem = nodeItem.next;
		}

		return minEntry;
	}

	public void print() {
		NodeEntry nodeItem = head;

		while (nodeItem != null) {
			System.out.print(nodeItem.getValue() + " ");
			nodeItem = nodeItem.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		UnsortedLinkedPriorityQueue<Integer, String> pQueue = new UnsortedLinkedPriorityQueue<Integer, String>();

		pQueue.insert(1, "Hulk");
		pQueue.insert(2, "Puskin");
		pQueue.insert(3, "Panda");

		pQueue.insert(6, "Thanh");
		pQueue.insert(7, "An");

		pQueue.insert(5, "Dang");
		pQueue.insert(10, "Phuong");

		pQueue.print();

		System.out.println(pQueue.size());
		System.out.println(pQueue.min().getValue());

		pQueue.removeMin();

		pQueue.print();
		System.out.println(pQueue.size());

		pQueue.removeMin();

		pQueue.print();
		System.out.println(pQueue.size());
	}
}
