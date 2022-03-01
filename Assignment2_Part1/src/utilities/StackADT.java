/**
 * 
 */
package utilities;
import java.io.*;

/**
 * @author JashanGill
 *
 */
public interface StackADT<E> extends Serializable 
{
	/**
	 * The size method will return the current element count contained
	 * in list
	 * 
	 * @return The current element count
	 */
	public int size();
	
	
	/**
	 * Returns <code>true</code> if this stack contains no elements.
	 * 
	 * @return <code>true</code> if this stack contains no elements.
	 */
	public boolean empty();
	
	
	
	/**
	 * Appends the specified element to to the top of the list.
	 * Implementations that support this operation may place limitations 
	 * on what elements may be added to this list. In particular, some
	 * implementations will refuse to add <code>null</code> elements.
	 * 
	 * @param item 
	 * 			Element to be appended to the Stack 
	 * @return the item argument
	 */
	public E push(E item);
	
	
	
	/**
	 * Removes the object at the top of this stack and 
	 * returns that object as the value of this function.
	 * 
	 * @return The object at the top of this stack
	 * @throws gives an error if no element in stack
	 */
	public E pop() throws  NullPointerException,
							IndexOutOfBoundsException;
	
	/**
	 * Looks at the object at the top of this stack 
	 * without removing it from the stack.
	 * 
	 * @return the object at the top of this stack.
	 * @throws gives an error if no element in stack
	 */
	public E peek() throws  NullPointerException,
	IndexOutOfBoundsException;
	
	
	/**
	 * Returns the 1-based position where an object is on this stack.
	 *  If the object o occurs as an item in this stack,
	 *  this method returns the distance from the top of the stack of the occurrence nearest the top of the stack;
	 *  the topmost item on the stack is considered to be at distance 1.
	 *  The equals method is used to compare o to the items in this stack.
	 *  
	 *  @param item
	 *  		The desired Item
	 *  @return the 1-based position from the top of the stack where the object is located;
	 *   the return value -1 indicates that the object is not on the stack.
	 */
	public int search(E item);
}

