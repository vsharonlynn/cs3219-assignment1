package logic;

import model.DataStorage;
import java.util.ArrayList;

public class Output {
	
	private DataStorage activeStorage;
	private ArrayList<String> sortedPermutations;
	
	public Output() {
		this.activeStorage = DataStorage.getInstance();
		
	}
	
	public ArrayList<String> getSortedPermutations() {
		this.sortedPermutations = activeStorage.getSortedPermutations();
		return sortedPermutations;
	}
}
