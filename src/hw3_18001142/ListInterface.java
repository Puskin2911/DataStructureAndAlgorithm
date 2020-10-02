package hw3_18001142;

public interface ListInterface<E> extends Iterable<E> {

	/**
	 * Appends the specified element to the end of this list (optional operation)..
	 * 
	 * @param element element to be appended to this list
	 * @return {@code true} if element added, other wise return {@code false}
	 * 
	 * @throws NullPointerException if the specified element is null and this list
	 *                              does not permit null elements
	 */
	public boolean add(E element);

	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param index index of the element to return
	 * @return the element at the specified position in this list
	 * @throws IndexOutOfBoundsException if the index is out of range
	 *                                   ({@code index < 0 || index >= size()})
	 */
	public E get(int index);

	/**
	 * Replaces the element at the specified position in this list with the
	 * specified element (optional operation).
	 * 
	 * @param index   index of the element to replace
	 * @param element element to be stored at the specified position
	 * 
	 * @throws NullPointerException      if the specified element is null and this
	 *                                   list does not permit null elements
	 * @throws IndexOutOfBoundsException if the index is out of range
	 *                                   ({@code index < 0 || index >= size()})
	 */
	public void set(int index, E element);

	/**
	 * Removes the first occurrence of the specified element from this list, if it
	 * is present (optional operation). If this list does not contain the element,
	 * it is unchanged. More formally, removes the element with the lowest index
	 * {@code i} such that {@code Objects.equals(o, get(i))} (if such an element
	 * exists).
	 * 
	 * @param element element to be removed from this list, if present
	 * @return {@code true} if this list contained the specified element
	 * @throws NullPointerException if the specified element is null and this list
	 *                              does not permit null elements
	 */
	public boolean remove(E element);

	/**
	 * Removes the element at the specified position in this list.Returns the
	 * element that was removed from the list.
	 * 
	 * @param index index of element to be removed
	 * @return element have been removed
	 * @throws IndexOutOfBoundsException if the index is out of range
	 *                                   ({@code index < 0 || index >= size()})
	 */
	public E remove(int index);

	/**
	 * Returns {@code true} if this list contains the specified element.
	 * 
	 * @param element element whose presence in this list is to be tested
	 * @return {@code true} if this list contains the specified element
	 * @throws NullPointerException if the specified element is null and this list
	 *                              does not permit null elements
	 */
	public boolean isContain(E element);

	/**
	 * Returns the number of elements in this list. If this list contains more than
	 * 
	 * @return the number of elements in this list
	 */
	public int size();

	/**
	 * Returns {@code true} if this list contains no elements.
	 *
	 * @return {@code true} if this list contains no elements.
	 */
	public boolean isEmpty();
	
	/**
	 * Return position of specific element
	 * 
	 * @param element element need to find index
	 * @return position of specific element
	 * @throws NullPointerException if element is null
	 */
	public int indexOf(E element);
}
