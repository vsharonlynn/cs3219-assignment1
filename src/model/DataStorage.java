package model;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;

public class DataStorage {

	private LinkedList<Title> titles;
	private HashMap<String, Title> titleMap; //for easy Title retrieval
	
	private ArrayList<String> ignoredWords;
	private static DataStorage activeStorage;
	
	private ArrayList<String> sortedPermutations;

	/*
	 * DataStorage is implemented as a Singleton. It is guaranteed that there
	 * will only be one instance of Data Storage. DataStorage is the shared
	 * memory used in all processes, hence we only need one instance of it.
	 */

	private DataStorage() {
		this.titles = new LinkedList<Title>();
		this.ignoredWords = new ArrayList<String>();
		this.titleMap = new HashMap<String, Title>();
	}

	public static DataStorage getInstance() {
		if (activeStorage == null) {
			activeStorage = new DataStorage();
		}

		return activeStorage;
	}

	public void addIgnoredWord(String word) {
		ignoredWords.add(word);
	}

	public ArrayList<String> getIgnoredWords() {
		return ignoredWords;
	}

	public void addTitle(String titleName) {
		Title newTitle = new Title(titleName);
		titles.add(newTitle);
		titleMap.put(titleName, newTitle);
	}
	
	

	public ArrayList<String> getPermutations(Title titleName) {
		return titleName.getPermutations();
	}

	public void setPermutations(String titleName, ArrayList<String> permutations) {
		Title curTitle = titleMap.get(titleName);
		curTitle.setPermutations(permutations);
	}

	public ArrayList<String> getTitleNames() {
		ArrayList<String> names = new ArrayList<String>();

		for (Title t : titles) {
			String curName = t.getTitleName();
			names.add(curName);
		}

		return names;
	}

	public ArrayList<String> getUnsortedPermutations() {
		ArrayList<String> permutations = new ArrayList<String>();

		for (Title t : titles) {
			ArrayList<String> curPermutations = getPermutations(t);

			for (String s : curPermutations) {
				permutations.add(s);
			}
		}

		return permutations;
	}
	
	public void setSortedPermutations(ArrayList<String> sorted) {
		this.sortedPermutations = sorted;
	}
	
	public ArrayList<String> getSortedPermutations() {
		return sortedPermutations;
	}

}
