package app;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import utilities.Iterator;
import utilities.StackADT;
/**
 * @author Guryuvraj Singh
 * 
 */

/**
 * Stack class to implement function with stackADT
 * 
 * 
 * */
public class Stack<E> implements StackADT<E> {

	private static final long serialVersionUID = 1L;
	public int size;
	
	
	
	private MyArrayList<E> stack;
	
	public Stack()
	{
		stack = new MyArrayList<E>();
		size = 0;
	}
	
	/**
	 * push method to add elements into stack
	 * @param toAdd
	 * @return none
	 * @throws NullPointerException
	 * */

	@Override
	public void push(E toAdd) throws NullPointerException {
		
		if(toAdd == null) {
			throw new NullPointerException();
		}
		else
		{
			stack.add(toAdd);	
			size++;
		}
	}
	
	/**
	 * pop method to remove elements from stack
	 * @return removeItem
	 * @throws EmptyStackException
	 * */
	
	@Override
	public E pop() throws EmptyStackException {
		if(stack.isEmpty()) {
			
			throw new EmptyStackException();
		}
		
		else {
			 
			E removeItem;
			removeItem = stack.get(stack.size() - 1);
			stack.remove(removeItem);
			size--;
			return removeItem;
			
		}
	}
	
	/**
	 * peek method to retrieve elements from stack
	 * @return retrieve the last element from stack
	 * @throws EmptyStackException
	 * */

	@Override
	public E peek() throws EmptyStackException {
		if(stack.isEmpty()) {
			throw new EmptyStackException();
		}
		
		else {
			return stack.get(stack.size() - 1);
		}	
	}
	/**
	 * clear method to remove all elements from stack
	 * */
	@Override
	public void clear() {
		stack.clear();
		size = 0;
		
	}
	/**
	 * isEmpty method check whether stack is empty or not
	 * @return true(if empty), false(if not empty)
	 * */

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public Object[] toArray() {
		Object[] array = stack.toArray();
		return array;
	}

	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		if(holder == null) {
			throw new NullPointerException();
		}
		
		return stack.toArray(holder);
	}
	/**
	 * contains method to find if element is present in stack or not
	 * @return element retrieved
	 * @throws NullPointerException
	 * */
	@Override
	public boolean contains(E toFind) throws NullPointerException {
		return stack.contains(toFind);
	}

	/**
	 * search method to search element in stack
	 * @param toFind
	 * @return 1(if element found), -1 (if element not found)
	 * 
	 * */
	@Override
	public int search(E toFind) {
	for(int i=0; i< stack.size(); i++)
	{
		if(toFind.equals(stack.get(i))) {
			return 1;
		}
	}
		return -1;
	}
	
	/**
	 * iterator method to iterate elements
	 * @return toReturn
	 * @throws NoSuchElementException
	 * */
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new ArrayBasedIterator();
		}
		
		public class ArrayBasedIterator implements Iterator<E>{

			private int pos;

			@Override
			public boolean hasNext() {
			return pos < size;
			}


			@Override
			public E next() throws NoSuchElementException {
			if(pos >= size) {
			throw new NoSuchElementException();
			}
			E toReturn = stack.get(pos);
			pos--;
			return toReturn;
			}
		}
		/**
		 * equals method to check elements are same or not from stack
		 * @return true(if elements are same) else false
		 * @throws EmptyStackException
		 * */

	@Override
	public boolean equals(StackADT<E> that) {
		
		boolean check = true;
		int stackSize = stack.size();
		int thatSize = that.size();
		
		if(stackSize == thatSize)
		{
			for(int i=0; i<stackSize; i++) {
				E element1 = stack.get(stack.size() - 1);
				E element2 = that.peek();
				
				if(element1 == element2)
				{
					stack.remove(element1);
					that.pop();
				}
				else
				{
					check = false;
				}
			}
		}
		else
		{
			check = false;
		}
		
		return check;
	}

	/**
	 * size method returns the size of the stack
	 * @return size of stack
	 * */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return stack.size();
	}

}
