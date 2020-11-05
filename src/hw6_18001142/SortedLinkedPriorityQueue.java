package hw6_18001142;

public class SortedLinkedPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {
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
		if (head == null) {
			head = (NodeEntry) entry;
			n++;
			return;
		}

		NodeEntry nodeItem = head;
		NodeEntry nodeEntry = (NodeEntry) entry;

		if (n == 1) {
			if (head.getKey().compareTo(nodeEntry.getKey()) > 0) {
				nodeEntry.next = head;
				head = nodeEntry;
			} else {
				head.next = nodeEntry;
			}
			n++;
			return;
		}

		while (nodeItem.next != null) {
			if (nodeItem.next.getKey().compareTo(nodeEntry.getKey()) > 0) {
				nodeEntry.next = nodeItem.next;
				nodeItem.next = nodeEntry;
				n++;
				return;
			}
			nodeItem = nodeItem.next;
		}

		nodeItem.next = nodeEntry;
		n++;
	}

	@Override
	public void insert(K key, E element) {
		if (head == null) {
			head = new NodeEntry(key, element);
			n++;
			return;
		}

		NodeEntry nodeItem = head;
		NodeEntry nodeEntry = new NodeEntry(key, element);

		if (n == 1) {
			if (head.getKey().compareTo(nodeEntry.getKey()) > 0) {
				nodeEntry.next = head;
				head = nodeEntry;
			} else {
				head.next = nodeEntry;
			}
			n++;
			return;
		}

		while (nodeItem.next != null) {
			if (nodeItem.next.getKey().compareTo(nodeEntry.getKey()) > 0) {
				nodeEntry.next = nodeItem.next;
				nodeItem.next = nodeEntry;
				n++;
				return;
			}
			nodeItem = nodeItem.next;
		}

		nodeItem.next = nodeEntry;
		n++;
	}

	@Override
	public Entry<K, E> removeMin() {
		if (n == 0)
			return null;
		Entry<K, E> nodeEntry = head;
		head = head.next;
		n--;
		return nodeEntry;
	}

	@Override
	public Entry<K, E> min() {
		return this.head;
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
		SortedLinkedPriorityQueue<Integer, String> pQueue = new SortedLinkedPriorityQueue<Integer, String>();

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
	}

}
