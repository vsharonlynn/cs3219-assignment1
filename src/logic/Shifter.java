package logic;

import model.DataStorage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;

public class Shifter {

	private DataStorage activeStorage;
	private HashMap<String, Boolean> ignoredWords;
	private ArrayList<String> titles;

	public Shifter() {
		this.activeStorage = DataStorage.getInstance();
		this.titles = activeStorage.getTitleNames();
		setIgnoredWords();
	}

	private void setIgnoredWords() {
		DataStorage str = activeStorage;
		ArrayList<String> ignoredWordsList = str.getIgnoredWords();

		for (String s : ignoredWordsList) {
			this.ignoredWords.put(s, true);
		}
	}

	public void shiftAndStore() {
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

			if (!ignoredWords.containsKey(firstWord)) {
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
			toBeAdded += s;
		}
		permutations.add(toBeAdded);
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
