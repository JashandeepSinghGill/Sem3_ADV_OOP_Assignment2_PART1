package app;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

import utilities.Iterator;
import utilities.ListADT;

/**
 * 
 * Implements the ListADT and create the doubly linked list.
 * 
 * @author Manleen Mavi
 *
 * @param <E> Specifies the object type to handle the element.
 */
public class MyDLL<E> implements ListADT<E>{
	private static final long serialVersionUID = 1L;
	
	// Reference to head and tail node
	private DLLNode<E> head, tail;
	
	// Reference to the size
	private int size;

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		//Set head and tail to null.
		head = null;
		tail = null;
		
		//Set the size to zero
		size = 0;
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if(toAdd == null) {
			throw new NullPointerException();
		}
		
		if(index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		
		
		if (index == size()) {
			//If index is equal to size, set the new tail.
			return add(toAdd);
			
		} else if (index == 0) {
			//If index is 0 set the new head and set previous of new head to current head.
			DLLNode<E> newHead = new DLLNode<>(toAdd, null, head);
			head.setPrevious(newHead);
			head = newHead;
			
		} else {
			DLLNode<E> currAtIndex = head;
			for(int i = 0; i < index; i++) {
				currAtIndex = currAtIndex.getNext();
			}
			
			//Creating new node
			DLLNode<E> newElement = new DLLNode<> (toAdd, currAtIndex.getPrevious(), currAtIndex);
			
			//Setting next of element at (index - 1)
			currAtIndex.getPrevious().setNext(newElement);
			
			//Setting previous of current element at index
			currAtIndex.setPrevious(newElement);
		}
		
		//Increment the size and return true
		size++;
		return true;
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		//Checking if the Element provided is null
		if (toAdd == null) {
			throw new NullPointerException();
		}
		
		if(size() == 0) {
			DLLNode<E> newHead = new DLLNode<>(toAdd);
			head = newHead;
			tail = newHead;
			
		} else {
			//Adding element and set tail
			DLLNode<E> newTail = new DLLNode<>(toAdd, tail, null);
			tail.setNext(newTail);
			tail = newTail;
		}
		
		//Incrementing size and return true
		size++;
		return true;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		//Checking if the provided list is not Null
		if (toAdd == null) {
			throw new NullPointerException();
		}
		
		//Passing the elements to add at list
		for(int i = 0; i < toAdd.size(); i++) {
			add(toAdd.get(i));
		}
		
		return true;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		//Checking index range
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		DLLNode<E> nodeAtIndex = head;
		
		if(index == size() -1) {
			return tail.getElement();
		} else {
			//Getting node at given index
			for (int i = 0; i < index; i++) {
				nodeAtIndex = nodeAtIndex.getNext();
			}
		}
		
		return nodeAtIndex.getElement();
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		//Checking index range
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		DLLNode<E> nodeAtIndex = head;
		
		if (index == 0) {			
			//Setting new head
			head = head.getNext();
			
			//Changing previous of new head
			if(head != null)
				head.setPrevious(null);
			
		} else if(index == size() -1) {
			nodeAtIndex = tail;
			
			//Setting new tail
			tail = tail.getPrevious();
			
			//Changing next of new tail
			tail.setNext(null);
			
		} else {
			//Getting node at given index
			for (int i = 0; i < index; i++) {
				nodeAtIndex = nodeAtIndex.getNext();
			}
			
			//Changing the next and previous nodes
			nodeAtIndex.getPrevious().setNext(nodeAtIndex.getNext());
			nodeAtIndex.getNext().setPrevious(nodeAtIndex.getPrevious());
			
		}
				
		//Decrementing size
		size--;
		
		return nodeAtIndex.getElement();
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		//Checking the null reference
		if (toRemove == null) {
			throw new NullPointerException();
		}
		
		int indexOfElement = -1;
		DLLNode<E> nodeToRemove = head;
		
		// Finding the node reference containing the element
		for (int i = 0; i < size(); i++) {
			if(nodeToRemove.getElement().equals(toRemove)) {
				indexOfElement = i;
				break;
			} else {
				nodeToRemove = nodeToRemove.getNext();
			}			
		}
		
		if(indexOfElement != -1) {
			return remove(indexOfElement);
		}
		
		return null;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		// Checking element is null and range of index
		if(toChange == null) {
			throw new NullPointerException();
		}
		
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		// Finding node at provided index
		DLLNode<E> nodeAtIndex = head;
		
		if(index == size() -1) {
			nodeAtIndex = tail;
		} else {
			//Getting node at given index
			for (int i = 0; i < index; i++) {
				nodeAtIndex = nodeAtIndex.getNext();
			}
		}
		
		E previousElement = nodeAtIndex.getElement();
		
		//Setting new element
		nodeAtIndex.setElement(toChange);
		
		return previousElement;
	}

	@Override
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if (toFind == null) {
			throw new NullPointerException();
		}
		
		boolean isElementFound = false;
		DLLNode<E> nodeToRemove = head;
		
		// Finding the node reference containing the element
		for (int i = 0; i < size(); i++) {
			if(nodeToRemove.getElement().equals(toFind)) {
				isElementFound = true;
			} else {
				nodeToRemove = nodeToRemove.getNext();
			}			
		}
		return isElementFound;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		//Checking for null reference
		if (toHold == null) {
			throw new NullPointerException();
		}
		
		// Checking if the length of the provided array is big enough
		if(toHold.length < size()) {
			toHold = (E[]) Array.newInstance(toHold.getClass().getComponentType(), size());
		}
		
		//Assigning the elements of the provided array
		for(int i = 0; i < size(); i++) {
			toHold[i] = get(i);
		}
		
		return toHold;
	}

	@Override
	public Object[] toArray() {
		// Initializing array to hold elements
		Object[] toHold = new Object[size()];
		
		// Assigning the elements
		for(int i = 0; i < size(); i++) {
			toHold[i] = get(i);
		}
		
		return toHold;
	}

	@Override
	public Iterator<E> iterator() {
		return new MyDLLIterator();		
	}
	
	/*
	 * Private class that implements the Iterator
	 */
	private class MyDLLIterator implements Iterator<E> {
		////Know the current position of the iterator
		private int currPosition;
		
		/**
		 * Initialize the Iterator.
		 */
		public MyDLLIterator() {
			this.currPosition = -1;
		}

		@Override
		public boolean hasNext() {
			//Checks next position and compares with size, returns true if next element can be returned
			if(currPosition + 1 < size()) {
				return true;
			} else {
				return false;
			}
		}

		@Override
		public E next() throws NoSuchElementException {
			if(currPosition + 1 >= size()) {
				throw new NoSuchElementException();
			} else {
				//Return the next element
				currPosition++;
				return get(currPosition);
			}
		}
		
	}

}
