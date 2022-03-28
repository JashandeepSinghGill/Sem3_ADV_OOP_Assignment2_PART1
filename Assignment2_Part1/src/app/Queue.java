/**
 * 
 */
package app;

import exceptions.EmptyQueueException;
import utilities.Iterator;
import utilities.QueueADT;

/**
 * @author Monty
 *
 */
public class Queue<E> implements QueueADT<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MyDLL<E> queue;
	public Queue()
	{
	
		queue= new MyDLL<E>();
	}
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

	@Override
	public void dequeueAll() {
		// TODO Auto-generated method stub
		queue.clear();
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return queue.isEmpty();
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return queue.iterator();
	}

	@Override
	public boolean equals(QueueADT<E> that) {
		// TODO Auto-generated method stub
		boolean check=true;
		int queueSize=queue.size();
		int thatSize=that.size();
		
		if(queueSize==thatSize)
		{
			for(int i=0;i<queueSize;i++)
			{
				E element1=queue.get(i);
			}
		}
		else
		{
			check=false;
		}
		return check;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return queue.toArray();
	}

	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		// TODO Auto-generated method stub
		return queue.toArray(holder);
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		
		
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return queue.size();
	}

}
