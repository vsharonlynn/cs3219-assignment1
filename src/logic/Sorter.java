package logic;

import java.util.ArrayList;
import java.util.Collections;

import model.DataStorage;
import commutil.StringComparator;

public class Sorter {

	private DataStorage activeStorage;
	private ArrayList<String> allPermutations;

	public Sorter() {
		this.activeStorage = DataStorage.getInstance();
	}

	public void sort() {
		this.allPermutations = activeStorage.getUnsortedPermutations();
		StringComparator comparator = new StringComparator();
		Collections.sort(allPermutations, comparator);
		activeStorage.setSortedPermutations(allPermutations);
	}

}
