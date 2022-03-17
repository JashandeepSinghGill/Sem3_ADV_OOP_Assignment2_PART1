/**
 * 
 */
package app;

import java.lang.reflect.Array;

import utilities.Iterator;
import utilities.ListADT;

/**
 * @author JashanGill
 *
 */
public class MyArrayList<E> implements ListADT<E> {
	//the actual size of the arrayList
	private int size;
	//The length of the array that contains the ArrayList
	private int arrayLength;
	//The array that contains the ArrayList
	private  Object[] array;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * constructor
	 */
	public MyArrayList() {
	
		this.size = 0;
		this.arrayLength = 10;
		this.array = new Object[arrayLength];
	}
	/**
	 * This function returns the size of the arrrayList
	 */
	@Override
	public int size() {
		
		return size;
	}
	/**
	 * This method clears the whole arrayList
	 */
	@Override
	public void clear() {
		
		array = null;
		size = 0;
	}
	/**
	 * This method counts the elements in the List
	 * @return the count of elements
	 */
	private int elementCount()
	{
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				count++;
			}
		}
		return count;
	}
	/**
	 * This Method adds the new element to the array
	 */
	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		int indexDiff = 0;
		
		//checks if the index to which the element is being added is less than the length of the Array
		if(this.size!=this.arrayLength && index<this.arrayLength)
		{
			//if YES, It adds the element
			array[index] = toAdd;
		}
		else
		{
			//If No, It creates a new Array with size that can contain 10 more elements
			Object[] tempArr  = new Object[this.arrayLength];
			arrayLength += 10;
			//then we transfer all the elements from the old array to the new array by using a Temp array
			for (int i = 0; i < array.length; i++) {
				tempArr[i] = array[i];
			}
			array = new Object[arrayLength];
			
			for (int i = 0; i < tempArr.length; i++) {
				array[i] = tempArr[i];
			}
			tempArr = null;
			
			//Then we add the element
			array[index] = toAdd;	
		}
		//this is an additional component that updates the size of the arrayList 
		/*
		 * For Example:
		 * if list has only one element at index 5 the the size of the List should be 6 not 1
		 * and, if the list has one element at a index 3 and the new one is added at the index 6 then the size should be 7 not 5
		 */
		for (int i = index-1; i >= 0; i--) {
			if (elementCount() == 1) {
				indexDiff = index;
				break;
			}
			if (array[i] != null) {
				indexDiff = index - i - 1;
				break;
			}
		}
		this.size += indexDiff+1;
		
		return true;
	}
	/**
	 * adds the element to the arrayList at the end of the list
	 */
	@Override
	public boolean add(E toAdd) throws NullPointerException {
		add(this.size, toAdd);
		return true;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		
		for (int i = 0; i < toAdd.size(); i++) {
			add(toAdd.get(i));
		}

		return true;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if(index > this.size-1) {
			throw new IndexOutOfBoundsException();
		}
		Object getValue = array[index];
		return (E)getValue;
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if(index > this.size-1) {
			throw new IndexOutOfBoundsException();
		}
		// this the removed element that needs to be returned by the method
		Object getValue = array[index];
		// deleting the element
		array[index] = null;
		
		//this loop move all the items in the array to the left to fill the space created by the deleted element
		for (int i = 0; i < this.size; i++) {
			array[index] = array[index+1];
		}
		
		//this loop check for the last element in the list to set the size of the list to that element
		for (int i = index-1; i >= 0; i--) {
			if (array[i] != null) {
				this.size = i+1;
				break;
			}
		//this if will see if the element removed was the last element then set List size to zero 	
		}if(elementCount() == 0) {
			this.size = 0;
		}
		return (E)getValue;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		int indexToBeRemoved = -1;
		for (int i = 0; i < this.size; i++) {
			if (array[i] == toRemove) {
				indexToBeRemoved = i;
			}
		}
		if(indexToBeRemoved == -1) {
			throw new UnsupportedOperationException();
		}
		return remove(indexToBeRemoved);
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if(toChange == null) {
			throw new NullPointerException();
		}
		
		array[index] = toChange;
		return toChange;
	}

	@Override
	public boolean isEmpty() {
		if (this.size == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == toFind) {
				return true;
			}
		}
		return false;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		Object[] convertedArray = new Object[this.size];
		for (int i = 0; i < toHold.length; i++) {
			convertedArray[i] = (Object)toHold[i];
		}
		return (E[])convertedArray;
	}

	@Override
	public Object[] toArray() {
		Object[] convertedArray = new Object[this.size];
		for (int i = 0; i < this.size; i++) {
			convertedArray[i] = array[i];
		}
		return convertedArray;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}

	