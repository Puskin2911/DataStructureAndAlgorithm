package hw3_18001142.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hw3_18001142.SimpleArrayList;

class SimpleArrayListTest {
	private SimpleArrayList<Dog> dogs;
	private SimpleArrayList<Dog> emptyList;
	private Dog[] arrayDogs;

	@BeforeEach
	void setUp() throws Exception {
		dogs = new SimpleArrayList<Dog>();
		arrayDogs = new Dog[10];
		for (int i = 0; i < 10; i++) {
			Dog dog = new Dog(i);
			dogs.add(dog);
			arrayDogs[i] = dog;
		}
		emptyList = new SimpleArrayList<Dog>();
	}

	@Test()
	void testAdd() {
		assertEquals(10, dogs.size());
		Exception nullPointerException = assertThrows(NullPointerException.class, () -> dogs.add(null));
		assertEquals("Element must be not null", nullPointerException.getMessage());
		assertEquals(10, dogs.size());

		dogs.add(new Dog(11));
		assertEquals(11, dogs.size());

		// Expand
		IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
				() -> new SimpleArrayList<Dog>(-2));
		assertEquals("Illegal Capacity: -2", illegalArgumentException.getMessage());

		emptyList = new SimpleArrayList<Dog>(2);
		for (int i = 0; i < 100; i++) {
			emptyList.add(new Dog(i));
		}
		assertEquals(100, emptyList.size());
	}

	@Test
	void testRemove() {
		Exception nullPointerException = assertThrows(NullPointerException.class, () -> dogs.remove(null));
		assertEquals("Element must be not null", nullPointerException.getMessage());

		Exception noSuchElementException = assertThrows(NoSuchElementException.class,
				() -> emptyList.remove(arrayDogs[0]));
		assertEquals("List is empty", noSuchElementException.getMessage());

		Exception indexOutOfBoundException = assertThrows(IndexOutOfBoundsException.class, () -> emptyList.remove(0));
		assertEquals("Index out of range: 0", indexOutOfBoundException.getMessage());

		dogs.remove(arrayDogs[7]);
		assertFalse(dogs.isContain(arrayDogs[7]));
		assertEquals(9, dogs.size());

		dogs.remove(5);
		assertFalse(dogs.isContain(arrayDogs[5]));
		assertEquals(8, dogs.size());

		// Not remove
		assertFalse(dogs.remove(new Dog(100)));
		assertEquals(8, dogs.size());
	}

	@Test
	void testSetGetIsContain() {
		Exception indexOutOfBoundException = assertThrows(IndexOutOfBoundsException.class,
				() -> dogs.set(100, new Dog(10)));
		assertEquals("Index out of range: 100", indexOutOfBoundException.getMessage());

		indexOutOfBoundException = assertThrows(IndexOutOfBoundsException.class, () -> dogs.get(100));
		assertEquals("Index out of range: 100", indexOutOfBoundException.getMessage());

		Exception nullPointerException = assertThrows(NullPointerException.class, () -> dogs.set(5, null));
		assertEquals("Element must be not null", nullPointerException.getMessage());

		nullPointerException = assertThrows(NullPointerException.class, () -> dogs.isContain(null));
		assertEquals("Element must be not null", nullPointerException.getMessage());

		assertFalse(dogs.isEmpty());
		Dog dog11 = new Dog(11);
		dogs.set(0, dog11);
		assertEquals(dog11, dogs.get(0));
		assertTrue(dogs.isContain(dog11));
	}

	@Test
	void testIndexOf() {
		Exception nullPointerException = assertThrows(NullPointerException.class, () -> dogs.indexOf(null));
		assertEquals("Element must be not null", nullPointerException.getMessage());

		assertEquals(0, dogs.indexOf(arrayDogs[0]));

		// Not contain
		Dog dog100 = new Dog(100);
		assertEquals(-1, dogs.indexOf(dog100));
		assertFalse(dogs.isContain(dog100));
	}

	@Test
	void testIterator() {
		Iterator<Dog> it = dogs.iterator();
		int i = 0;
		while (it.hasNext()) {
			assertEquals(arrayDogs[i++], it.next());
		}

		Exception noSuchElementException = assertThrows(NoSuchElementException.class, () -> it.next());
		assertEquals("Current iterator have no next element", noSuchElementException.getMessage());
	}
}
