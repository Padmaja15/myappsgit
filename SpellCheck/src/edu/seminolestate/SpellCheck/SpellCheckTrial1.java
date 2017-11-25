package edu.seminolestate.SpellCheck;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class SpellCheckTrial1 {

	@Test
	void test() {
		DictionaryProcessor test = new DictionaryProcessor();
		List <String> output = Arrays.asList("the", "and", "geo", "ver1.9", "an", "12the", "here", "firefox", "done");
		test.readFiles("dictionaryFile.txt","testFile.txt");
		ArrayList<String> output1 = test.getUnknownWords();
		assertTrue(output1.equals(output));
	}

}

