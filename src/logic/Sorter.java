package logic;

import java.util.ArrayList;
import java.util.Collections;

import model.DataStorage;

public class Sorter {

	private DataStorage activeStorage;
	private ArrayList<String> allPermutations;

	public Sorter() {
		this.activeStorage = DataStorage.getInstance();
	}

	public void sort() {
		this.allPermutations = activeStorage.getUnsortedPermutations();
		Collections.sort(allPermutations);
		activeStorage.setSortedPermutations(allPermutations);
	}

}
