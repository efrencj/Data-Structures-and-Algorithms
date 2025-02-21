package prac4.ex1;

import java.util.*;
import java.io.*;
import java.text.Collator;

public class Indexer {
    /*
    Use the README.md to see what this function needs to do
    */

	public static Map<String, SortedSet<Integer>> createIndex(File file) throws IOException {
		BufferedReader br = null;
		String line;
		Map<String, SortedSet<Integer>> map = new TreeMap<>(Collator.getInstance()::compare);

		try {
			br = new BufferedReader(new FileReader(file));
			int lineNumber = 1;

			while ((line = br.readLine()) != null) {
				String[] words = line.split("[\\s!?\"',;:.-//()]+");
				for (String word : words) {
					if (word.length() >= 5 && Character.isUpperCase(word.charAt(0))) {
						word = word.toUpperCase();
						map.computeIfAbsent(word, k -> new TreeSet<>()).add(lineNumber);
					}
				}
				lineNumber++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} finally {
			if (br != null) {
				br.close();
			}
		}

		return map;
	}

	/*
    This method returns a string of the parameter index prettyfied.
    Needs to return for every key, the key two points (:) space and all the elements in the value inside [] and separated by comma and space (, )
    For example:
        WORD: [1, 2]
        WORD2: [4, 8]
    */
	public static String prettyStringIndex(Map<String, SortedSet<Integer>> index) {
		StringBuilder sb = new StringBuilder();

		for (Map.Entry<String, SortedSet<Integer>> entry : index.entrySet()) {
			sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
		}

		return sb.toString();
	}
}
