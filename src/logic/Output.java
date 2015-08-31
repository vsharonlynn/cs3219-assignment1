package logic;

import model.DataStorage;
import java.util.ArrayList;

public class Output {
	
	private DataStorage activeStorage;
	private ArrayList<String> sortedPermutations;
	
	public Output() {
		this.activeStorage = DataStorage.getInstance();
		this.sortedPermutations = activeStorage.getSortedPermutations();
	}
	
	public ArrayList<String> getSortedPermutations() {
		return sortedPermutations;
	}
}
