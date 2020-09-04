package telran.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static telran.words.Anagram.*;


class AnagramTests {
	String word = "yellow";

	@Test
	void testAnagramTrue() {
		assertTrue(isAnagram(word, "loweyl"));
		assertTrue(isAnagram(word, "elolyw"));
		assertTrue(isAnagram(word, "wolley"));
		assertTrue(isAnagram(word, "loleyw"));

	}

	@Test
	void testAnagramFalse() {
		assertFalse(isAnagram(word, ""));
		assertFalse(isAnagram("", ""));
		assertFalse(isAnagram(word, "yello"));
		assertFalse(isAnagram(word, "yelllo"));
		assertFalse(isAnagram(word, word));

	}
	
}
