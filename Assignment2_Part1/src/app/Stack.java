package app;

import java.util.EmptyStackException;

import utilities.Iterator;
import utilities.StackADT;

public class Stack<E> implements StackADT<E> {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	
	private MyArrayList<E> stack;
	
	public Stack()
	{
		stack = new MyArrayList<E>();
	}

	@Override
	public void push(E toAdd) throws NullPointerException {
		
		if(toAdd == null) {
			throw new NullPointerException();
		}
		else
		{
			stack.add(toAdd);	
		}
	}
	
	@Override
	public E pop() throws EmptyStackException {
		if(stack.isEmpty()) {
			
			throw new EmptyStackException();
		}
		
		else {
			 
			E removeItem;
			removeItem = stack.get(stack.size() - 1);
			stack.remove(removeItem);
			return removeItem;
		}
	}

	@Override
	public E peek() throws EmptyStackException {
		if(stack.isEmpty()) {
			throw new EmptyStackException();
		}
		
		else {
			return stack.get(stack.size() - 1);
		}	
	}

	@Override
	public void clear() {
		stack.clear();
		
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public Object[] toArray() {
		return stack.toArray();
	}

	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		return stack.contains(toFind);
	}

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

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(StackADT<E> that) {
		
		boolean check = true;
		int stackSize = stack.size();
		int thatSize = that.size();
		
		if(stackSize == thatSize)
		{
			for(int i=0; i<stackSize; i++) {
				E element1 = stack.get(stack.size() - 1);
				//E element2 = that.get(that.size() - 1);
				
				//if(element1) = that.get(that.size() - 1))
				//{
					
				//}
			}
		}
		else
		{
			check = false;
		}
		
		return check;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return stack.size();
	}

}
