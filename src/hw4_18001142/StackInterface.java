package hw4_18001142;

public interface StackInterface<E> extends Iterable<E> {
	/**
	 * Pushes an item onto the top of this stack.
	 * 
	 * @param element the element to be pushed onto this stack.
	 * 
	 * @throws NullPointerException if element is null.
	 * @throws StackOverflowError   if stack is full.
	 */
	public void push(E element);

	/**
	 * Removes the object at the top of this stack and returns that object as the
	 * value of this function.
	 * 
	 * @return The object at the top of this stack.
	 * 
	 * @throws EmptyStackException if this stack is empty.
	 */
	public E pop();

	/**
	 * Tests if this stack is empty.
	 * 
	 * @return <code>true</code> if and only if this stack contains no items;
	 *         <code>false</code> otherwise.
	 */
	public boolean isEmpty();

	/**
	 * Looks at the object at the top of this stack without removing it from the
	 * stack.
	 * 
	 * @return the object at the top of this stack
	 * 
	 * @throws EmptyStackException if this stack is empty.
	 */
	public E top();
}
