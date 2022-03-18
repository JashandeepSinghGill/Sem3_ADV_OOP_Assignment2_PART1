/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.MyArrayList;

/**
 * @author JashanGill
 *
 */
class MyArrayListTests {
	
	MyArrayList<String> arr;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		
		arr = new MyArrayList<String>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		
		arr = null;
		
	}


	/**
	 * Test method for {@link app.MyArrayList#size()}.
	 */
	@Test
	void testSizeZero() {
		assertEquals(0, arr.size());
	}
	

	/**
	 * Test method for {@link app.MyArrayList#size()}.
	 */
	@Test
	void testSizeNonZero() {
		arr.add("A");
		arr.add("B");
		arr.add("C");
		
		assertEquals(3, arr.size());
	}

	/**
	 * Test method for {@link app.MyArrayList#clear()}.
	 */
	@Test
	void testClear() {
		arr.add("A");
		arr.add("B");
		arr.add("C");
		
		arr.clear();
		
		assertEquals(0,arr.size());
	}

	/**
	 * Test method for {@link app.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddToBeginning() {
		arr.add(0, "A");
		
		assertEquals("A", arr.get(0));
		
	}
	
	/**
	 * Test method for {@link app.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddToMiddle() {

		arr.add("C");
		arr.add("A");
		arr.add("L");
		arr.add("G");
		arr.add("R");
		arr.add("Y");
		arr.add(4, "A");
		
		assertEquals("A", arr.get(4));
		
	}

	/**
	 * Test method for {@link app.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	void testAddE() {

		arr.add("A");
		
		assertEquals("A", arr.get(arr.size()-1));	
		
	}

	/**
	 * Test method for {@link app.MyArrayList#addAll(utilities.ListADT)}.
	 */
	@Test
	void testAddAll() {
		
		MyArrayList<String>	arr2 = new MyArrayList<String>();
		
		arr2.add("A");
		arr2.add("B");
		arr2.add("C");
		
		arr.add("X");
		arr.add("Y");
		arr.add("Z");
		
		arr.addAll(arr2);
		
		String result = "";
		for (int i = 0;i<arr.size();i++) {
			result += arr.get(i);
		}
		assertEquals("XYZABC", result);
		
	}

	/**
	 * Test method for {@link app.MyArrayList#get(int)}.
	 */
	@Test
	void testGetFromBeginnig() {
		arr.add("C");
		arr.add("A");
		arr.add("L");
		arr.add("G");
		arr.add("A");
		arr.add("R");
		arr.add("Y");
		
		assertEquals("C", arr.get(0));
	}	
	
	/**
	 * Test method for {@link app.MyArrayList#get(int)}.
	 */
	@Test
	void testGetFromMiddle() {
		arr.add("C");
		arr.add("A");
		arr.add("L");
		arr.add("G");
		arr.add("A");
		arr.add("R");
		arr.add("Y");
		
		assertEquals("G", arr.get(3));	
		
	}
	
	/**
	 * Test method for {@link app.MyArrayList#get(int)}.
	 */
	@Test
	void testGetFromEnd() {
		arr.add("C");
		arr.add("A");
		arr.add("L");
		arr.add("G");
		arr.add("A");
		arr.add("R");
		arr.add("Y");
		
		assertEquals("Y", arr.get(6));	
		
	}
	
	/**
	 * Test method for {@link app.MyArrayList#get(int)}.
	 */
	@Test
	void testGetFromBadIndex() {
		arr.add("C");
		arr.add("A");
		arr.add("L");
		arr.add("G");
		arr.add("A");
		arr.add("R");
		arr.add("Y");
		
		assertThrows(IndexOutOfBoundsException.class, ()-> {
			arr.get(9);
		});
	}

	/**
	 * Test method for {@link app.MyArrayList#remove(int)}.
	 */
	@Test
	void testRemoveFromBeginning() {
		arr.add("C");
		arr.add("A");
		arr.add("L");
		arr.add("G");
		arr.add("A");
		arr.add("R");
		arr.add("Y");
		
		assertEquals("C", arr.remove(0));	
	}
	
	/**
	 * Test method for {@link app.MyArrayList#remove(int)}.
	 */
	@Test
	void testRemoveFromMiddle() {
		arr.add("C");
		arr.add("A");
		arr.add("L");
		arr.add("G");
		arr.add("A");
		arr.add("R");
		arr.add("Y");
		
		assertEquals("R", arr.remove(5));
	}
	
	/**
	 * Test method for {@link app.MyArrayList#remove(int)}.
	 */
	@Test
	void testRemoveFromEnd() {
		arr.add("C");
		arr.add("A");
		arr.add("L");
		arr.add("G");
		arr.add("A");
		arr.add("R");
		arr.add("Y");
		
		assertEquals("Y", arr.remove(6));
	}
	
	/**
	 * Test method for {@link app.MyArrayList#remove(int)}.
	 */
	@Test
	void testRemoveFromBadIndex() {
		arr.add("C");
		arr.add("A");
		arr.add("L");
		arr.add("G");
		arr.add("A");
		arr.add("R");
		arr.add("Y");
		
		assertThrows(IndexOutOfBoundsException.class, ()-> {
			arr.remove(8);
		});
	}


	/**
	 * Test method for {@link app.MyArrayList#remove(java.lang.Object)}.
	 */
	@Test
	void testRemoveGoodValue() {
		arr.add("C");
		arr.add("A");
		arr.add("L");
		arr.add("G");
		arr.add("A");
		arr.add("R");
		arr.add("Y");
		
		assertEquals("L", arr.remove("L"));
	}
	
	/**
	 * Test method for {@link app.MyArrayList#remove(java.lang.Object)}.
	 */
	@Test
	void testRemoveBadValue() {
		arr.add("C");
		arr.add("A");
		arr.add("L");
		arr.add("G");
		arr.add("A");
		arr.add("R");
		arr.add("Y");
		
		assertThrows(NullPointerException.class, ()-> {
			arr.remove("X");
		});
	}

	/**
	 * Test method for {@link app.MyArrayList#set(int, java.lang.Object)}.
	 */
	@Test
	void testSetAtIndex() {
		arr.add("C");
		arr.add("A");
		arr.add("L");
		arr.add("G");
		arr.add("A");
		arr.add("R");
		arr.add("Y");
		
		arr.set(3, "M");
		assertEquals("M", arr.get(3));
		
	}
	
	/**
	 * Test method for {@link app.MyArrayList#set(int, java.lang.Object)}.
	 */
	@Test
	void testSetNullObject() {
		arr.add("C");
		arr.add("A");
		arr.add("L");
		arr.add("G");
		arr.add("A");
		arr.add("R");
		arr.add("Y");
		
		assertThrows(NullPointerException.class, ()-> {
			arr.set(8, null);
		});
	}
	
	/**
	 * Test method for {@link app.MyArrayList#isEmpty()}.
	 */
	@Test
	void testIsEmptyForEmpty() {
		
		if(arr.size() == 0) {
			assertTrue(true);
		}else {assertTrue(false);}
		
	}
	
	/**
	 * Test method for {@link app.MyArrayList#isEmpty()}.
	 */
	@Test
	void testIsEmptyForNonEmpty() {
		
		arr.add("A");
		arr.add("B");
		arr.add("C");
		
		assertEquals(3, arr.size());
		
	}

	/**
	 * Test method for {@link app.MyArrayList#contains(java.lang.Object)}.
	 */
	@Test
	void testContainsGoodValue() {
		arr.add("C");
		arr.add("A");
		arr.add("L");
		arr.add("G");
		arr.add("A");
		arr.add("R");
		arr.add("Y");
		
		assertTrue(arr.contains("L"));
	}
	
	/**
	 * Test method for {@link app.MyArrayList#contains(java.lang.Object)}.
	 */
	@Test
	void testContainsBadValue() {
		arr.add("C");
		arr.add("A");
		arr.add("L");
		arr.add("G");
		arr.add("A");
		arr.add("R");
		arr.add("Y");
		
		assertFalse(arr.contains("x"));
	}
	

	/**
	 * Test method for {@link app.MyArrayList#toArray(E[])}.
	 */
	@Test
	void testToArrayEArray() {
		
	}

	/**
	 * Test method for {@link app.MyArrayList#toArray()}.
	 */
	@Test
	void testToArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link app.MyArrayList#iterator()}.
	 */
	@Test
	void testIterator() {
		fail("Not yet implemented");
	}

}
