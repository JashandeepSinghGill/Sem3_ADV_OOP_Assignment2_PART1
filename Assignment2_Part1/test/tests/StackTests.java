package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.Stack;

class StackTests {
	
	private Stack<String> stack;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		stack = new Stack<String>();
	}
	
	
	@AfterEach
	void tearDown() throws Exception {
		stack = null;
	}

	@Test
	void testPush() {
		stack.push("Hello");
		stack.push("bye");
		assertEquals(2, stack.size());
	}
	
	@Test
	void testPushNull() {
		
		assertThrows(NullPointerException.class,
				()-> {stack.push(null);});
	}

	@Test
	void testPop() {
		stack.push("Hello");
		stack.push("bye");
		assertEquals("bye",stack.pop() );
	}
	
	@Test
	void testPop2() {
		stack.push("a");
		stack.push("b");
		stack.push("c");
		stack.push("d");
		stack.push("e");
		stack.pop();
		stack.pop();
		assertEquals("c", stack.pop());
	}
	
	@Test
	void testPopEmpty() {
		assertThrows(EmptyStackException.class, ()-> {stack.pop();});
	}
	
	

	@Test
	void testPeek() {
		stack.push("Hello");
		stack.push("bye");
		assertEquals("bye",stack.peek() );
	}
	
	@Test
	void testPeekEmpty() {
		assertThrows(EmptyStackException.class, ()-> {
			stack.peek();});
	}
	
	@Test
	void testClear() {
		stack.push("Hello");
		stack.push("bye");
		stack.clear();
		assertEquals(0,stack.size() );
	}
	
	@Test
	void testClearWhenEmpty() {
		stack.clear();
		assertEquals(0,stack.size() );
	}

	@Test
	void testIsEmptyWhenEmpty() {
		assertEquals(true, stack.isEmpty());
	}
	
	@Test
	void testIsEmptyWhenNotEmpty() {
		stack.push("Hello");
		stack.push("bye");
		assertEquals(false, stack.isEmpty());
	}

	@Test
	void testToArray() {
		stack.push("Hello");
		stack.push("Bye");
		Object[] copyArray = stack.toArray();
		assertEquals(copyArray[stack.size - 1], stack.peek());
	}

//	@Test
//	void testToArrayEArray() {
//
//	}

	@Test
	void testContains() {
		stack.push("Hello");
		assertEquals(true, stack.contains("Hello"));
	}
	
	@Test
	void testContainsWhenNotContains() {
		assertEquals(false, stack.contains("Hello"));
	}

	@Test
	void testSearchWhenPresent() {
		stack.push("Hello");
		stack.push("bye");
		assertEquals(1,stack.search("Hello")); 
	}
	
	@Test
	void testSearchWhenNotPresent() {
		assertEquals(-1,stack.search("Hello")); 
	}
	
	@Test
	void testSearchWhenSearchingNull() {
		assertEquals(-1,stack.search(null)); 
	}
	
	

//	@Test
//	void testIterator() {
//		fail("Not yet implemented");
//	}

//	@Test
//	void testEqualsStackADTOfE() {
//	
//	}

	@Test
	void testSizeNonZero() {
		stack.push("Hello");
		stack.push("bye");
		assertEquals(2, stack.size());
	}
	
	@Test
	void testSizeZero(){
		assertEquals(0, stack.size());
	}

}
