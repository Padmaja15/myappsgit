package edu.seminolestate.SpellCheck;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class SpellCheckTrial3 {

	@Test
	void test() {
		DictionaryProcessor test = new DictionaryProcessor();
		List <String> output = Arrays.asList("Mary","had", "a","lamb", "trial");
		test.readFiles("dictionaryFile.txt","test1.txt");
		ArrayList<String> output1 = test.getUnknownWords();
		assertTrue(output1.equals(output));
	}

}
