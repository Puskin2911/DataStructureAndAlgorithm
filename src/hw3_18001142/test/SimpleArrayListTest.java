package hw3_18001142.test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hw3_18001142.SimpleArrayList;

class SimpleArrayListTest {
	private SimpleArrayList<Integer> integers;
	private SimpleArrayList<Dog> dogs;
	private Dog[] arrayDogs;

	@BeforeEach
	void setUp() throws Exception {
		integers = new SimpleArrayList<Integer>();
		dogs = new SimpleArrayList<Dog>();
		arrayDogs = new Dog[10];
		for (int i = 0; i < 10; i++) {
			Dog dog = new Dog(i);
			integers.add(i);
			dogs.add(dog);
			arrayDogs[i] = dog;
		}
	}

	@Test()
	void testAddnSizenGet() {
		assertEquals(10, integers.size());
		assertEquals(5, integers.get(5));
		assertEquals(3, integers.indexOf(3));

		assertEquals(10, dogs.size());
		assertEquals(5, dogs.get(5).getId());
		assertEquals(3, dogs.indexOf(arrayDogs[3]));
	}

	@Test
	void testRemove() {
		Exception indexOutException = assertThrows(IndexOutOfBoundsException.class, () -> integers.remove(10));
		assertEquals("Index out of range: 10", indexOutException.getMessage());
		Exception nullPointerException = assertThrows(NullPointerException.class, () -> integers.indexOf(null));
		assertEquals("Element must be not null", nullPointerException.getMessage());
		integers.remove(9);
		assertEquals(9, integers.size());
		
		dogs.remove(arrayDogs[9]);
		assertFalse(dogs.isContain(arrayDogs[9]));
		
		dogs.remove(5);
		assertFalse(dogs.isContain(arrayDogs[5]));
	}

}
