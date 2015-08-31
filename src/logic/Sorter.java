package logic;

import java.util.ArrayList;
import java.util.Collections;

import model.DataStorage;

public class Sorter {

	private DataStorage activeStorage;
	private ArrayList<String> allPermutations;

	public Sorter() {
		this.activeStorage = DataStorage.getInstance();
		this.allPermutations = activeStorage.getUnsortedPermutations();
	}

	public void sort() {
		Collections.sort(allPermutations);
		activeStorage.setSortedPermutations(allPermutations);
	}

}
