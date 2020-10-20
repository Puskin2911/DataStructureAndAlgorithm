package hw4_18001142;

public interface QueueInterface<E> extends Iterable<E> {
	/**
	 * Inserts the specified element into this queue
	 * 
	 * @throws IllegalStateException if the element cannot be added at this time due
	 *                               to capacity restrictions
	 * 
	 * @param element the element to add.
	 * 
	 * @throws NullPointerException if the specified element is null and this queue
	 *                              does not permit null elements
	 */
	public void enqueue(E element);

	/**
	 * Retrieves and removes the head of this queue.
	 * 
	 * @return the head of this queue.
	 * 
	 * @throws NoSuchElementException if this queue is empty.
	 */
	public E dequeue();

	/**
	 * Tests if this queue is empty.
	 * 
	 * @return <code>true</code> if and only if this queue contains no items;
	 *         <code>false</code> otherwise.
	 * 
	 * @throws NoSuchElementException if this queue is empty.
	 */
	public boolean isEmpty();

	/**
	 * Retrieves, but does not remove, the head of this queue.
	 * 
	 * @return the head of this queue.
	 * @throws NoSuchElementException if this queue is empty.
	 */
	public E front();

	/**
	 * Retrieves, but does not remove, the tail of this queue.
	 * 
	 * @return the tail of this queue.
	 * 
	 * @throws NoSuchElementException if this queue is empty.
	 */
	public E rear();
}
