package logic;

import model.DataStorage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;

public class Shifter {

	private DataStorage activeStorage;
	private HashMap<String, Integer> ignoredWords;
	private ArrayList<String> titles;

	public Shifter() {
		this.activeStorage = DataStorage.getInstance();
		this.ignoredWords = new HashMap<String, Integer>();
	}

	public void shiftAndStore() {
		this.titles = activeStorage.getTitleNames();
		setIgnoredWords();
		permuteAndStore();
	}

	private void setIgnoredWords() {
		DataStorage str = activeStorage;
		ArrayList<String> ignoredWordsList = str.getIgnoredWords();
		storeIgnoredWords(ignoredWordsList);
	}

	private void storeIgnoredWords(ArrayList<String> ignoredWordsList) {
		for (String s : ignoredWordsList) {
			this.ignoredWords.put(s, 1);
		}
	}

	private void permuteAndStore() {
		for (String s : titles) {
			ArrayList<String> permutations = new ArrayList<String>();
			permute(s, permutations);
			activeStorage.setPermutations(s, permutations);
		}
	}

	private void permute(String s, ArrayList<String> permutations) {
		LinkedList<String> words = generateLinkedList(s);

		for (int i = 0; i < words.size(); i++) {
			String firstWord = words.get(0);

			if (!ignoredWords.containsKey(firstWord.toLowerCase())) {
				addToList(words, permutations);
			}

			circulate(words);
		}

	}

	private void circulate(LinkedList<String> words) {
		String last = words.removeLast();
		words.addFirst(last);
	}

	private void addToList(LinkedList<String> words, ArrayList<String> permutations) {
		String toBeAdded = "";
		for (String s : words) {
			s += " ";
			toBeAdded += s;
		}

		toBeAdded = capitalizeAndTrim(toBeAdded);
		permutations.add(toBeAdded);
	}

	private String capitalizeAndTrim(String toBeAdded) {
		toBeAdded = toBeAdded.substring(0, 1).toUpperCase() + toBeAdded.substring(1).trim();
		return toBeAdded;
	}

	private LinkedList<String> generateLinkedList(String s) {
		String[] splitted = s.split(" ");
		LinkedList<String> words = new LinkedList<String>();

		for (String st : splitted) {
			words.add(st);
		}

		return words;
	}

}
