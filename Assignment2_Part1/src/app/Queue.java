/**
 * 
 */
package app;

import exceptions.EmptyQueueException;
import utilities.Iterator;
import utilities.QueueADT;

/**
 * @author Manpreet Singh
 *
 */


/**
 * Class to implement queue with help of QueueADT
 * @param E
 * */
public class Queue<E> implements QueueADT<E> {

	
	
	private static final long serialVersionUID = 1L;
	private MyDLL<E> queue;
	public Queue()
	{
	
		queue= new MyDLL<E>();
	}
	
	/**
	 * Enqueue function to add elements into queue
	 * @param toAdd
	 * @return none
	 * @throws NullPointerException
	 * */
	@Override
	public void enqueue(E toAdd) throws NullPointerException {
		// TODO Auto-generated method stub
		
		if(toAdd==null)
		{
			throw new NullPointerException();
			
		}
		
		else
		{
			queue.add(toAdd);
		}
	}
	/**
	 * Dequeue function to delete elements from queue
	 * @param none
	 * @return removeItem
	 * @throws EmptyQueueException
	 * */
	@Override
	public E dequeue() throws EmptyQueueException {
		
		if(queue.isEmpty())
		{
			throw new EmptyQueueException();
		}
		else
		{
			E removeItem;
			removeItem= queue.get(0);
			queue.remove(removeItem);
			return removeItem;
		}
		 
	}
	
	/**
	 * Peek function to retrieve elements from queue
	 * @param none
	 * @return first element of queue
	 * @throws EmptyQueueException
	 * */
	@Override
	public E peek() throws EmptyQueueException {
		// TODO Auto-generated method stub
		if(queue.isEmpty())
		{
			throw new EmptyQueueException();
			
		}
		else
		{
			return queue.get(0);
			
		}
		
	}
	/**
	 * Dequeue function to remove all elements from queue
	 * @param none
	 * @return none
	 * */

	@Override
	public void dequeueAll() {
		// TODO Auto-generated method stub
		queue.clear();
		
	}
	
	/**
	 * isEmpty function to check whether queue is empty or not.
	 * @param none
	 * @return true(If empty), false(if not empty)
	 * */

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return queue.isEmpty();
	}
	
	/**
	 * Iterator function to iterate all elements in queue
	 * @param E
	 * @return iterator
	 * */
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return queue.iterator();
	}
	/**
	 * equals function to check where queue is equal or not
	 * @param queueADT<E> that (element)
	 * @return true(if condition satisfies), false(if condition not satisfies)
	 * */
	
	@Override
	public boolean equals(QueueADT<E> that) {
		// TODO Auto-generated method stub
		boolean check=true;
		for(int i=0;i<that.size();i++)
		{
			try
			{
				if(this.dequeue()!=that.dequeue())
				{
					check=false;
				}
				
			}
			catch(EmptyQueueException e)
			{
				e.printStackTrace();
			}
		}
		return check;
	}
	/**
	 * toArray method assign the elements 
	 * 
	 * @return array
	 * */
	
	@Override
	public Object[] toArray() {
		Object[] array= queue.toArray();
		return array;
		
	}
	/**
	 * toArray(E[] holder) method assign the elements of the provided linked list
	 * 
	 * @param holder
	 * @return tohold element
	 * @throws NullPointerException
	 * 
	 * */
	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		if(holder==null)
		{
			throw new NullPointerException();
		}
		
		return queue.toArray(holder);
	}
	/**
	 * isFull method checks whether queue is full or not
	 * @param none
	 * @return false (based on condition)
	 * */

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		
		
		return false;
	}
	/**
	 * size method returns the size of the queue
	 * @param none
	 * @return size of queue
	 * 
	 * */

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return queue.size();
	}

}
