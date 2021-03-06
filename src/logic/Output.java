package logic;

import model.DataStorage;
import java.util.ArrayList;

public class Output {

	private DataStorage activeStorage;
	private ArrayList<String> sortedPermutations;
	private final String DIVIDER = "======================================================";

	public Output() {
		this.activeStorage = DataStorage.getInstance();
	}

	private void setSortedPermutations() {
		this.sortedPermutations = activeStorage.getSortedPermutations();
	}

	public void processOutput() {
		this.setSortedPermutations();
		System.out.println("The Key Word In Context (KWIC) index of the titles are:");
		System.out.println(DIVIDER);
		printAllPermutations();
		System.out.println(DIVIDER);
	}

	private void printAllPermutations() {
		for (int i = 1; i <= sortedPermutations.size(); i++) {
			System.out.println(sortedPermutations.get(i - 1));
		}
	}

}
