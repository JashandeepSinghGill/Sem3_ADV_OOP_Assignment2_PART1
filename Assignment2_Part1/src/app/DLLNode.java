package app;

public class DLLNode<E> {
	private E element;
	private DLLNode<E> previous, next;
	
	/**
	 * DLLNode constructor, creates the DLLNode object with the default values for the objects.
	 */
	public DLLNode() {
		
	}
	
	/**
	 * DLLNode constructor, creates the DLLNode object and assign reference to the element object.
	 * @param element The object to store and refer.
	 */
	public DLLNode(E element) {
		this.element = element;
	}
	
	/**
	 * DLLNode constructor, creates the DLLNode object and assign reference to the element object, previous and next DLLNode objects.
	 * @param element The object to store and refer.
	 * @param previous Reference to previous DLLNode.
	 * @param next Reference to next DLLNode.
	 */
	public DLLNode(E element, DLLNode<E> previous, DLLNode<E> next) {
		this.element = element;
		this.previous = previous;
		this.next = next;
	}

	/**
	 * Return the element stored in the DLLNode.
	 * @return element of the DLLNode.
	 */
	public E getElement() {
		return element;
	}

	/**
	 * Set the element of the DLLNode to set.
	 * @param element The element to set.
	 */
	public void setElement(E element) {
		this.element = element;
	}

	/**
	 * Returns the previous DLLNode object.
	 * @return The previous DLLNode.
	 */
	public DLLNode<E> getPrevious() {
		return previous;
	}

	/**
	 * Set the previous DLLNode object.
	 * @param previous The previous DLLNode to set.
	 */
	public void setPrevious(DLLNode<E> previous) {
		this.previous = previous;
	}

	/**
	 * Returns the next DLLNode object.
	 * @return Next DLLNode object.
	 */
	public DLLNode<E> getNext() {
		return next;
	}

	/**
	 * Set the next DLLNode object.
	 * @param next The next DLLNode to set.
	 */
	public void setNext(DLLNode<E> next) {
		this.next = next;
	}
}
