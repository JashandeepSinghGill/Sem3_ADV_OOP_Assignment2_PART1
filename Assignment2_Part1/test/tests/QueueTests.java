/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.Queue;
import exceptions.EmptyQueueException;

/**
 * @author Monty
 *
 */
class QueueTests {

	/**
	 * @throws java.lang.Exception
	 */
	
	private Queue<String> queue;
	@BeforeEach
	void setUp() throws Exception {
		queue=new Queue<String>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		queue=null;
	}

	/**
	 * Test method for {@link app.Queue#Queue()}.
	 * @throws EmptyQueueException 
	 */
	@Test
	void testQueue() throws EmptyQueueException {
		queue.enqueue("first");
		queue.enqueue("Second");
		assertEquals("first",queue.dequeue());
		
	}

	/**
	 * Test method for {@link app.Queue#enqueue(java.lang.Object)}.
	 */
	@Test
	void testEnqueue() {
		queue.enqueue("first");
		queue.enqueue("Second");
		assertEquals(2,queue.size());
	}
	
	@Test
	void testEnqueueNull()
	{
		assertThrows(NullPointerException.class,()->{queue.enqueue(null);});
	}

	/**
	 * Test method for {@link app.Queue#dequeue()}.
	 * @throws EmptyQueueException 
	 */
	@Test
	void testDequeue() throws EmptyQueueException {
		queue.enqueue("first");
		queue.enqueue("second");
		assertEquals("first",queue.dequeue());
	}
	
	@Test
	void testDequeueNull()
	{
		assertThrows(EmptyQueueException.class,()->{queue.dequeue();});
	}

	/**
	 * Test method for {@link app.Queue#peek()}.
	 * @throws EmptyQueueException 
	 */
	@Test
	void testPeek() throws EmptyQueueException {
		queue.enqueue("hi");
		queue.enqueue("hello");
		assertEquals("hi",queue.peek());
	}
	
	@Test
	void testPeekEmpty()
	{
		assertThrows(EmptyQueueException.class,()->{queue.peek();});
	}

	/**
	 * Test method for {@link app.Queue#dequeueAll()}.
	 */
	@Test
	void testDequeueAll() {
		queue.enqueue("hello");
		queue.enqueue("hey");
		queue.dequeueAll();
		assertEquals(0,queue.size());
	}
	
	@Test
	void testDequeueAllEmpty()
	{
		queue.dequeueAll();
		assertEquals(0,queue.size());
	}

	/**
	 * Test method for {@link app.Queue#isEmpty()}.
	 */
	@Test
	void testIsEmpty() {
		assertEquals(true,queue.isEmpty());
	}
	
	@Test
	void testIsEmptyWhenNotEmpty()
	{
		queue.enqueue("hello");
		assertEquals(false,queue.isEmpty());
		
	}

	/**
	 * Test method for {@link app.Queue#iterator()}.
	 */
	@Test
	void testIterator() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link app.Queue#equals(utilities.QueueADT)}.
	 */
	@Test
	void testEqualsQueueADTOfE() {
		
	}

	/**
	 * Test method for {@link app.Queue#toArray()}.
	 */
	@Test
	void testToArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link app.Queue#toArray(E[])}.
	 */
	@Test
	void testToArrayEArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link app.Queue#isFull()}.
	 */
	@Test
	void testIsFull() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link app.Queue#size()}.
	 */
	@Test
	void testSize() {
		queue.enqueue("hey");
		assertEquals(1,queue.size());
	}
	
	@Test
	void testSizeWhenEmpty()
	{
		assertEquals(0,queue.size());
	}

}
