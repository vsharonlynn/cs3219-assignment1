package logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

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
		PriorityQueue<String> titlesPQ = new PriorityQueue<String>(comparator);
		
		for (String title : allPermutations) {
			titlesPQ.add(title);
		}
		
		allPermutations.clear();
		while (!titlesPQ.isEmpty()) {
			allPermutations.add(titlesPQ.poll());
		}
		
		activeStorage.setSortedPermutations(allPermutations);
	}

}
