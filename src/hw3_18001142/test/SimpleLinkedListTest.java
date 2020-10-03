package hw3_18001142.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hw3_18001142.SimpleLinkedList;

class SimpleLinkedListTest {

	private SimpleLinkedList<Dog> dogs;
	private Dog[] arrayDogs;

	@BeforeEach
	void setUp() throws Exception {
		dogs = new SimpleLinkedList<Dog>();
		arrayDogs = new Dog[10];
		for (int i = 0; i < 10; i++) {
			Dog dog = new Dog(i);
			dogs.add(dog);
			arrayDogs[i] = dog;
		}
	}

	@Test
	void testSet() {
		Exception indexOutException = assertThrows(IndexOutOfBoundsException.class, () -> dogs.set(100, null));
		assertEquals("Index out of range: 100", indexOutException.getMessage());
		Exception nullPointerException = assertThrows(NullPointerException.class, () -> dogs.set(5, null));
		assertEquals("Element must be not null", nullPointerException.getMessage());

		dogs.set(5, new Dog(100));
		assertEquals(100, dogs.get(5).getId());
	}

	@Test
	void test() {
		assertEquals(10, dogs.size());
		assertEquals(5, dogs.get(5).getId());
		assertEquals(3, dogs.indexOf(arrayDogs[3]));
		Dog dog10 = new Dog(10);
		assertEquals(-1, dogs.indexOf(dog10));

		dogs.addTop(dog10);
		assertEquals(11, dogs.size());
		assertEquals(0, dogs.indexOf(dog10));
	}

	@Test
	void testRemove() {
		Exception indexOutException = assertThrows(IndexOutOfBoundsException.class, () -> dogs.remove(10));
		assertEquals("Index out of range: 10", indexOutException.getMessage());

		dogs.remove(5);
		assertFalse(dogs.isContain(arrayDogs[5]));

		assertEquals(9, dogs.size());
		assertEquals(6, dogs.get(5).getId());

		dogs.remove(8); // Remove Bot
		dogs.remove(0); // Remove Top

		assertEquals(7, dogs.size());
	}

	@Test
	void testRemoveObject() {
		Exception nullPointerException = assertThrows(NullPointerException.class, () -> dogs.remove(null));
		assertEquals("Element must be not null", nullPointerException.getMessage());

		dogs.remove(arrayDogs[9]);
		assertEquals(9, dogs.size());

		assertFalse(dogs.remove(arrayDogs[9])); // Not remove
		assertTrue((dogs.remove(arrayDogs[0]))); // Removed

		assertEquals(8, dogs.size());
	}

	@Test
	void testIterator() {
		Iterator<Dog> it = dogs.iterator();

		int i = 0;
		while (it.hasNext()) {
			assertEquals(i, it.next().getId());
			if (i == 4) {
				it.remove();
				Exception illegalStateException = assertThrows(IllegalStateException.class, () -> it.remove());
				assertEquals("Just one remove for one next() call", illegalStateException.getMessage());
			}
			i++;
		}

		// dog4 have been removed
		assertEquals(9, dogs.size());
		assertFalse(dogs.isContain(arrayDogs[4]));

		Exception noSuchElementException = assertThrows(NoSuchElementException.class, () -> it.next());
		assertEquals("Current iterator have no next element", noSuchElementException.getMessage());
	}

	@Test
	void testException() {
		dogs = new SimpleLinkedList<Dog>();

		Exception indexOutException = assertThrows(IndexOutOfBoundsException.class, () -> dogs.get(100));
		assertEquals("Index out of range: 100", indexOutException.getMessage());

		Exception nullPointerException = assertThrows(NullPointerException.class, () -> dogs.addTop(null));
		assertEquals("Element must be not null", nullPointerException.getMessage());

		nullPointerException = assertThrows(NullPointerException.class, () -> dogs.addBot(null));
		assertEquals("Element must be not null", nullPointerException.getMessage());

		nullPointerException = assertThrows(NullPointerException.class, () -> dogs.indexOf(null));
		assertEquals("Element must be not null", nullPointerException.getMessage());

		Exception noSuchElementException = assertThrows(NoSuchElementException.class, () -> dogs.removeTop());
		assertEquals("List is empty", noSuchElementException.getMessage());

		noSuchElementException = assertThrows(NoSuchElementException.class, () -> dogs.removeBot());
		assertEquals("List is empty", noSuchElementException.getMessage());

		noSuchElementException = assertThrows(NoSuchElementException.class, () -> dogs.remove(arrayDogs[0]));
		assertEquals("List is empty", noSuchElementException.getMessage());

		dogs.addTop(arrayDogs[0]);
		assertTrue(dogs.isContain(arrayDogs[0]));
		assertFalse(dogs.isEmpty());

		dogs.removeBot();
		assertTrue(dogs.isEmpty());
	}

}
