package model;

import java.util.LinkedList;
import java.util.ArrayList;

public class DataStorage {

	private LinkedList<Title> titles;
	private DataStorage activeStorage;

	/*
	 * DataStorage is implemented as a Singleton. It is guaranteed that there
	 * will only be one instance of Data Storage. DataStorage is the shared
	 * memory used in all processes, hence we only need one instance of it.
	 */

	private DataStorage() {
		this.titles = new LinkedList<Title>();
	}

	public DataStorage getInstance() {
		if (activeStorage == null) {
			activeStorage = new DataStorage();
			return activeStorage;
		} else {
			return activeStorage;
		}
	}

	public void addTitle(String titleName) {
		Title newTitle = new Title(titleName);
		titles.add(newTitle);
	}

	public LinkedList<String> getPermutations(Title titleName) {
		return titleName.getPermutations();
	}

	public void setPermutations(Title titleName, LinkedList<String> permutations) {
		titleName.setPermutations(permutations);
	}

	public ArrayList<String> getAllPermutations() {
		ArrayList<String> permutations = new ArrayList<String>();

		for (Title t : titles) {
			LinkedList<String> curPermutations = getPermutations(t);

			for (String s : curPermutations) {
				permutations.add(s);
			}
		}

		return permutations;
	}

}
