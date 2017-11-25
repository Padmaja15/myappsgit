package DictionaryList;

import java.io.BufferedReader;

import java.io.FileReader;

import java.io.IOException;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.Scanner;

public class SpellChecker {

private static ArrayList<String> dictionaryWordsList = new ArrayList<String>(); // Will contain dictionary words.

private static ArrayList<String> fileCheckWordsList = new ArrayList<String>(); //Will contain words from file to check

public static void main(String[] args) throws IOException {

// The program should accept two text file names on the command line.

// The program should read both files into string variables.

// The first is the file to check, and the second is the dictionary

if(args.length < 2){
System.out.println("Please provide file names <File To Check> as argument");
}
Scanner s = new Scanner(System.in); 
String fileToCheck = s.nextLine(); // First argument contains file To Check
System.out.println("Please provide file names <Dictionary File> as argument");
Scanner s1 = new Scanner(System.in); 
String dictionaryFile = s1.nextLine(); // Second argument contains dictionary file
readFileAndSpellCheck(fileToCheck,dictionaryFile); // readFiles
}

/*

* Method read both dictionary and normal file and

* create 2 array list of words from 2 files.

*/

private static void readFileAndSpellCheck(String fileToCheck,String dictFile) throws IOException {

String line;

try(BufferedReader br = new BufferedReader(new FileReader(fileToCheck))){

// Read each line of file to check and add each line to arrayList of

while ((line = br.readLine()) != null) {

fileCheckWordsList.add(line);

}

}

try(BufferedReader br2 = new BufferedReader(new FileReader(dictFile))){

// Read each line of dictionary file and add each line to arrayList

while ((line = br2.readLine()) != null) {

dictionaryWordsList.add(line);

}

}

// Iterate list which contains words to check

Iterator<String> iterator = fileCheckWordsList.iterator();

while (iterator.hasNext()) { // Check if list contains new word

String word = iterator.next(); // read each word

if (!dictionaryWordsList.contains(word)) { // if word is not available in dictionary words list

System.out.println("Unkonwn Word---> "+word); // Print Unknown word

}

}

}

}



