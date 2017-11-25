package edu.seminolestate.SpellCheck;

/*
* Author: P Parise
* Date: 11/24/2017
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DictionaryProcessor {

	String fileString;
	String dictionaryString;

	String[] fileArray;
	String[] dictionaryArray;

	private String readFile(String dataFilePath) {
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new FileReader(dataFilePath));
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				sb.append(" ");
				line = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	private String[] convertToArray(String str) {
		String separators = " ";
		return str.split(separators);
	}

	public void readFiles(String dictionaryFilePath, String dataFilePath) {

		fileString = readFile(dataFilePath);
		dictionaryString = readFile(dictionaryFilePath);

		fileArray = convertToArray(fileString);
		dictionaryArray = convertToArray(dictionaryString);
	}

	public ArrayList<String> getUnknownWords() {
		ArrayList<String> result = new ArrayList<String>();
		for (String word : fileArray) {

			// if it is just a number, ignore
			boolean hasLetters = false;
			for (int i = 0; i < word.length(); i++) {
				Character ch = word.charAt(i);
				if (Character.isAlphabetic(ch)) {
					hasLetters = true;
					break;
				}
			}
			if (!hasLetters)
				continue;

			boolean found = false;
			for (String dictionaryWord : dictionaryArray) {
				if (word.compareToIgnoreCase(dictionaryWord) == 0) {
					found = true;
					break;
				}
			}

			if (!found)
				result.add(word);
		}

		return result;
	}
}
