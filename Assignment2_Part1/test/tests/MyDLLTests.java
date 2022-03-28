package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.MyDLL;
import utilities.Iterator;

/**
 * @author Manleen Mavi
 *
 */
class MyDLLTests {

	MyDLL<String> list;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		list = new MyDLL<>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		list = null;
	}

	/**
	 * Test method for {@link app.MyDLL#size()}.
	 */
	@Test
	void testSizeZero() {
		assertEquals(0, list.size());
	}

	/**
	 * Test method for {@link app.MyDLL#size()}.
	 */
	@Test
	void testSizeNonZero() {
		//Adding 3 elements
		list.add("A");
		list.add("B");
		list.add("C");
		
		//Size should be 3
		assertEquals(3, list.size());
	}
	
	/**
	 * Test method for {@link app.MyDLL#size()}.
	 */
	@Test
	void testSizeAfterRemoving() {
		//Adding 6 elements
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");
		
		//Removing last 2 elements
		list.remove(5);
		list.remove(4);
		
		//Size should be 4
		assertEquals(4, list.size());
	}
	
	/**
	 * Test method for {@link app.MyDLL#size()}.
	 */
	@Test
	void testSizeAfterClear() {
		//Adding 4 elements
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		
		//Calling clear method
		list.clear();
		
		//Size should be 0
		assertEquals(0, list.size());
	}
	
	/**
	 * Test method for {@link app.MyDLL#clear()}.
	 */
	@Test
	void testClear() {
		list.add("A");
		list.add("B");
		list.add("C");
		
		//Clearing the list
		list.clear();
		
		//Checking if the size is zero
		assertEquals(0, list.size());
		
		//Checking if the isEmpty True
		assertTrue(list.isEmpty());
		
		//Checking if exception is thrown when trying to get element at index 0
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.get(0);
		});
	}

	/**
	 * Test method for {@link app.MyDLL#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntEAddingAtBeginning() {
		//Return True with successful add
		assertTrue(list.add(0, "A"));
		assertTrue(list.add(0, "B"));
		assertTrue(list.add(0, "C"));
		
		
		
		//Checking if the elements are added correct
		assertEquals("C", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals("A", list.get(2));
	}
	
	/**
	 * Test method for {@link app.MyDLL#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntEAddingAtDifferent() {
		list.add(0, "A");
		list.add(1, "B");
		list.add(2, "C");
		list.add(3, "D");
		
		//Adding at 2 index
		assertTrue(list.add(2, "E"));
		
		//DLL should be in order A, B, E, C, D
		//Checking if all elements are added correct
		assertEquals("B", list.get(1));
		assertEquals("E", list.get(2));
		assertEquals("C", list.get(3));
	}
	
	/**
	 * Test method for {@link app.MyDLL#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntEAddingWithSize() {
		
		//Checking true if element is added with the index of size of list
		assertTrue(list.add(list.size(), "A"));
		assertTrue(list.add(list.size(), "B"));
		assertTrue(list.add(2, "C"));
	}

	/**
	 * Test method for {@link app.MyDLL#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntEAddingIndexMoreThanSize() {
		
		//Checking if IndexOutOfBoundsException is thrown with Index greater than size	
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.add(2, "A");
		});
	}
	
	/**
	 * Test method for {@link app.MyDLL#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntEAddingIndexLessThanZero() {
		
		//Checking if IndexOutOfBoundsException is thrown with Index less than 0	
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.add(-1, "A");
		});
	}
	
	/**
	 * Test method for {@link app.MyDLL#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntEAddingNullElement() {
		
		//Checking if NullPointerException is thrown with null element.	
		assertThrows(NullPointerException.class, () -> {
			list.add(0, null);
		});
	}
	
	/**
	 * Test method for {@link app.MyDLL#add(java.lang.Object)}.
	 */
	@Test
	void testAddECorrectElement() {
		//Should return true with successful return
		assertTrue(list.add("A"));
		assertTrue(list.add("B"));
		assertTrue(list.add("C"));
		
		//Checking if elements are in correct order.
		assertEquals("A", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals("C", list.get(2));
	}
	
	/**
	 * Test method for {@link app.MyDLL#add(java.lang.Object)}.
	 */
	@Test
	void testAddENullElement() {
		//Checking if NullPointerException is thrown with null element.	
		assertThrows(NullPointerException.class, () -> {
			list.add(null);
		});
	}

	/**
	 * Test method for {@link app.MyDLL#addAll(utilities.ListADT)}.
	 */
	@Test
	void testAddAllToEmptyList() {
		//Initializing Another list to add
		MyDLL<String> listToAdd = new MyDLL<>();
		listToAdd.add("A");
		listToAdd.add("B");
		listToAdd.add("C");
		
		//Calling to addALL
		assertTrue(list.addAll(listToAdd));
		
		//Checking the size
		assertEquals(listToAdd.size(), list.size());
		
		//Checking if all elements are added to list in correct order
		assertEquals("A", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals("C", list.get(2));
	}
	
	/**
	 * Test method for {@link app.MyDLL#addAll(utilities.ListADT)}.
	 */
	@Test
	void testAddAllToNonEmptyList() {
		//Adding elements to existing list
		list.add("A");
		list.add("B");
		list.add("C");
		
		//Initializing Another list to add
		MyDLL<String> listToAdd = new MyDLL<>();
		listToAdd.add("D");
		listToAdd.add("E");
		listToAdd.add("F");
		
		//Calling to addALL
		assertTrue(list.addAll(listToAdd));
		
		//Checking the size
		assertEquals(6, list.size());
		
		//Checking if all elements are added to list in correct order
		assertEquals("A", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals("C", list.get(2));
		assertEquals("D", list.get(3));
		assertEquals("E", list.get(4));
		assertEquals("F", list.get(5));
	}
	
	/**
	 * Test method for {@link app.MyDLL#addAll(utilities.ListADT)}.
	 */
	@Test
	void testAddAllPassingNull() {
		//Checking if NullPointerException is thrown with null	
		assertThrows(NullPointerException.class, () -> {
			list.addAll(null);
		});
	}
	
	/**
	 * Test method for {@link app.MyDLL#get(int)}.
	 */
	@Test
	void testGetEmptyList() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.get(0);
		});
	}

	/**
	 * Test method for {@link app.MyDLL#get(int)}.
	 */
	@Test
	void testGetInRange() {
		String first = "A";
		String second = "B";
		String third = "C";
		String fourth = "D";
		
		list.add(first);
		list.add(second);
		list.add(third);
		list.add(fourth);
		
		//Checking get if all elements
		assertEquals(first, list.get(0));
		assertEquals(second, list.get(1));
		assertEquals(third, list.get(2));
		assertEquals(fourth, list.get(3));
	}
	
	/**
	 * Test method for {@link app.MyDLL#get(int)}.
	 */
	@Test
	void testGetNegativeIndex() {
		list.add("A");
		list.add("B");
		list.add("C");
		
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.get(-1);
		});
	}
	
	/**
	 * Test method for {@link app.MyDLL#get(int)}.
	 */
	@Test
	void testGetOutOfRange() {
		list.add("A");
		list.add("B");
		list.add("C");
		
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.get(4);
		});
	}

	/**
	 * Test method for {@link app.MyDLL#remove(int)}.
	 */
	@Test
	void testRemoveIntComparingElements() {
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");
		
		//Removing the element with index 2 (C) and index 4 (F)
		list.remove(2);
		list.remove(4);
		
		//Comparing the elements
		assertEquals("A", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals("D", list.get(2));
		assertEquals("E", list.get(3));
	}
	
	/**
	 * Test method for {@link app.MyDLL#remove(int)}.
	 */
	@Test
	void testRemoveIntEmptyList() {		
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.remove(-6);
		});
	}

	/**
	 * Test method for {@link app.MyDLL#remove(int)}.
	 */
	@Test
	void testRemoveIntEqualSize() {
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.remove(list.size());
		});
	}
	
	/**
	 * Test method for {@link app.MyDLL#remove(int)}.
	 */
	@Test
	void testRemoveIntGreaterThanSize() {
		list.add("A");
		list.add("B");
		list.add("C");
		
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.remove(99);
		});
	}
	
	/**
	 * Test method for {@link app.MyDLL#remove(int)}.
	 */
	@Test
	void testRemoveNegativeIndex() {
		list.add("A");
		list.add("B");
		list.add("C");
		
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.remove(-55);
		});
	}
	
	/**
	 * Test method for {@link app.MyDLL#remove(java.lang.Object)}.
	 */
	@Test
	void testRemoveENonNull() {
		String first = "A";
		String second = "B";
		String third = "C";
		String fourth = "D";
		
		list.add(first);
		list.add(second);
		list.add(third);
		list.add(fourth);
		
		//Removing element and comparing the removed element
		assertEquals(second, list.remove(second));
		
		
		//Checking the size
		assertEquals(3, list.size());
		
		//Checking the other elements
		assertEquals(first, list.get(0));
		assertEquals(third, list.get(1));
		assertEquals(fourth, list.get(2));
	}
	
	/**
	 * Test method for {@link app.MyDLL#remove(java.lang.Object)}.
	 */
	@Test
	void testRemoveENotContain() {
		String first = "A";
		String second = "B";
		String third = "C";
		String fourth = "D";
		
		list.add(first);
		list.add(second);
		list.add(third);
		list.add(fourth);
		
		//Removing element that does not contained in list and it should return null
		assertNull(list.remove("E"));
		
		//Checking the size
		assertEquals(4, list.size());
		
		//Checking if all elements are present
		assertEquals(first, list.get(0));
		assertEquals(second, list.get(1));
		assertEquals(third, list.get(2));
		assertEquals(fourth, list.get(3));
	}

	/**
	 * Test method for {@link app.MyDLL#set(int, java.lang.Object)}.
	 */
	@Test
	void testSetStartingIndex() {
		String first = "A";
		String second = "B";
		String third = "C";
		String fourth = "D";
		
		list.add(first);
		list.add(second);
		list.add(third);
		list.add(fourth);
		
		//Changing the element at position 0
		String changeEle = "Z";
		list.set(0, changeEle);
		
		//Checking if correct element is changed
		assertEquals(changeEle, list.get(0));
		assertEquals(second, list.get(1));
		assertEquals(third, list.get(2));
		assertEquals(fourth, list.get(3));		
	}
	
	/**
	 * Test method for {@link app.MyDLL#set(int, java.lang.Object)}.
	 */
	@Test
	void testSetLastIndex() {
		String first = "A";
		String second = "B";
		String third = "C";
		String fourth = "D";
		
		list.add(first);
		list.add(second);
		list.add(third);
		list.add(fourth);
		
		//Changing the element at index 3
		String changeEle = "E";
		list.set(3, changeEle);
		
		//Checking if correct element is changed
		assertEquals(first, list.get(0));
		assertEquals(second, list.get(1));
		assertEquals(third, list.get(2));
		assertEquals(changeEle, list.get(3));
	}
	
	/**
	 * Test method for {@link app.MyDLL#set(int, java.lang.Object)}.
	 */
	@Test
	void testSetRandomElement() {
		String elements[] = {"A", "B", "C", "D", "E", "F", "G"};
		
		for(String s : elements) {
			list.add(s);
		}
		
		//Element to change and its index
		String changeEle = "X";
		int indexToSet = 1 + (int) (Math.random() * (list.size() - 1));
		
		//Changing the element
		list.set(indexToSet, changeEle);
		
		//Checking if correct element is changed
		assertEquals(changeEle, list.get(indexToSet));
		
		//Checking others elements that are not changed
		for(int i = 0; i < list.size(); i++) {
			if (i != indexToSet) {
				assertEquals(elements[i], list.get(i));
			}
		}
	}
	
	/**
	 * Test method for {@link app.MyDLL#set(int, java.lang.Object)}.
	 */
	@Test
	void testSetEmptyList() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.set(0, "E");
		});
	}
	
	/**
	 * Test method for {@link app.MyDLL#set(int, java.lang.Object)}.
	 */
	@Test
	void testSetNullElement() {
		String first = "A";
		String second = "B";
		String third = "C";
		String fourth = "D";
		
		list.add(first);
		list.add(second);
		list.add(third);
		list.add(fourth);
		
		int indexToSet = (int) (Math.random() * list.size());
		
		
		assertThrows(NullPointerException.class, () -> {
			list.set(indexToSet, null);
		});
	}
	
	/**
	 * Test method for {@link app.MyDLL#set(int, java.lang.Object)}.
	 */
	@Test
	void testSetNegativeIndex() {		
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.set(-5, "N");
		});
	}
	
	/**
	 * Test method for {@link app.MyDLL#set(int, java.lang.Object)}.
	 */
	@Test
	void testSetIndexSize() {
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.set(list.size(), "S");
		});		
	}
	
	/**
	 * Test method for {@link app.MyDLL#set(int, java.lang.Object)}.
	 */
	@Test
	void testSetIndexMoreThanSize() {
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.set(5, "M");
		});		
	}

	/**
	 * Test method for {@link app.MyDLL#isEmpty()}.
	 */
	@Test
	void testIsEmptyListEmpty() {
		assertTrue(list.isEmpty());
	}
	
	/**
	 * Test method for {@link app.MyDLL#isEmpty()}.
	 */
	@Test
	void testIsEmptyNonEmptyList() {
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		
		assertFalse(list.isEmpty());
	}
	
	/**
	 * Test method for {@link app.MyDLL#isEmpty()}.
	 */
	@Test
	void testIsEmptyListEmptyAfterRemove() {
		//Adding element
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		
		//Removing element
		for(int i = list.size() - 1; i >= 0; i--) {
			list.remove(i);
		}
		
		assertTrue(list.isEmpty());
	}
	
	/**
	 * Test method for {@link app.MyDLL#isEmpty()}.
	 */
	@Test
	void testIsEmptyListEmptyAfterClear() {
		//Adding element
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		
		//Calling clear
		list.clear();
		
		assertTrue(list.isEmpty());
	}

	/**
	 * Test method for {@link app.MyDLL#contains(java.lang.Object)}.
	 */
	@Test
	void testContainsElement() {
		//Adding element
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		
		//Checking
		assertTrue(list.contains("C"));
	}
	
	/**
	 * Test method for {@link app.MyDLL#contains(java.lang.Object)}.
	 */
	@Test
	void testContainsElementNotContain() {
		//Adding element
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		
		//Checking
		assertFalse(list.contains("N"));
	}
	
	/**
	 * Test method for {@link app.MyDLL#contains(java.lang.Object)}.
	 */
	@Test
	void testContainsNullElement() {
		//Adding element
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		
		//Checking
		assertThrows(NullPointerException.class, () -> {
			list.contains(null);
		});
	}

	/**
	 * Test method for {@link app.MyDLL#toArray(E[])}.
	 */
	@Test
	void testToArrayEArraySameLength() {
		//Adding element
		String first = "A";
		String second = "B";
		String third = "C";
		String fourth = "D";
		
		list.add(first);
		list.add(second);
		list.add(third);
		list.add(fourth);
		
		//Creating array and calling method
		String toHold[] = {"Z", "Y", "X", "W"};
		
		//Passing the array
		String returnedArray[] = list.toArray(toHold);
		
		//Checking returned array is equal to array passed
		assertTrue(toHold.equals(returnedArray));
		
		//Checking the elements of the array with list
		for(int i = 0; i < list.size(); i++) {
			assertEquals(list.get(i), toHold[i]);
		}
	}
	
	/**
	 * Test method for {@link app.MyDLL#toArray(E[])}.
	 */
	@Test
	void testToArrayEArrayLessLength() {
		//Adding element
		String first = "A";
		String second = "B";
		String third = "C";
		String fourth = "D";
		
		list.add(first);
		list.add(second);
		list.add(third);
		list.add(fourth);
		
		//Creating array and calling method
		String toHold[] = {"Z", "Y"};
		
		//Passing the array
		String[] returnedArray = list.toArray(toHold);

		//Checking returned array is not equal to array passed
		assertFalse(toHold.equals(returnedArray));
		
		//Checking size and the elements of the returned array with list
		assertEquals(list.size(), returnedArray.length);
		for(int i = 0; i < list.size(); i++) {
			assertEquals(list.get(i), returnedArray[i]);
		}
	}
	
	/**
	 * Test method for {@link app.MyDLL#toArray(E[])}.
	 */
	@Test
	void testToArrayEArrayMoreLength() {
		//Creating larger array
		String toHold[] = {"A", "B", "C", "D", "E", "F", "G"};
		
		//Knowing the current array length
		int orgLength = toHold.length;
		
		//Adding element to list
		list.add("Z");
		list.add("Y");
		list.add("X");
		list.add("W");
		
		//Passing array reference to list
		list.toArray(toHold);
		
		//Checking the length of array
		assertEquals(orgLength, toHold.length);
		
		//Checking the elements of the list with array
		for(int i = 0; i < list.size(); i++) {
			assertEquals(list.get(i), toHold[i]);
		}
		
		//Checking the remaining elements of the array
		assertEquals("E", toHold[4]);
		assertEquals("F", toHold[5]);
		assertEquals("G", toHold[6]);
	}
	
	/**
	 * Test method for {@link app.MyDLL#toArray(E[])}.
	 */
	@Test
	void testToArrayEArrayNullArray() {
		//Adding element to list
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		
		assertThrows(NullPointerException.class, () -> {
			list.toArray(null);
		});
	}

	/**
	 * Test method for {@link app.MyDLL#toArray()}.
	 */
	@Test
	void testToArray() {
		//Adding element to list
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		
		Object returnedArray[] = list.toArray();
		
		//Checking size and sequence of elements
		assertEquals(list.size(), returnedArray.length);
		for(int i = 0; i < list.size(); i++) {
			assertEquals(list.get(i), returnedArray[i]);
		}
	}

	/**
	 * Test method for {@link app.MyDLL#iterator()}.
	 */
	@Test
	void testIterator() {
		//Checking if returning the iterator object class
		assertTrue(list.iterator() instanceof Iterator<?> );
	}

	/**
	 * Test method for {@link app.MyDLL#iterator()}.
	 */
	@Test
	void testHasNext() {
		//Adding elements to list
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		
		//Getting iterator
		Iterator<String> listIterator = list.iterator();
		
		//hasNext should be true till last index of iterator
		for(int i = 0; i < list.size(); i++) {
			assertTrue(listIterator.hasNext());
			
			//Going to the next element
			listIterator.next();
		}
		
		//hasNext should be false for position out of last index
		assertFalse(listIterator.hasNext());
	}

	/**
	 * Test method for {@link app.MyDLL#iterator()}.
	 */
	@Ignore
	@Test
	void testNext() {
		//Adding elements to list
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		
		//Getting iterator
		Iterator<String> listIterator = list.iterator();
		
		//next method should return the same element in same order
		for(int i = 0; i < list.size(); i++) {
			assertEquals(list.get(i), listIterator.next());
		}
		
		//Should throw NoSuchElementException after the last element
		assertThrows(NoSuchElementException.class, () -> {
			listIterator.next();
		});
	}

}
