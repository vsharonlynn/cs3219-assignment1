package model;

import java.util.ArrayList;

public class Title {

	private String titleName;

	/*
	 * permutations: contains all possible permutations of titleName, without those beginning
	 * with ignored words.
	 */
	
	private ArrayList<String> permutations;

	public Title(String name) {
		this.setTitleName(name);
	}

	void setTitleName(String name) {
		this.titleName = name;
	}

	void setPermutations(ArrayList<String> newPermutations) {
		this.permutations = newPermutations;
	}

	String getTitleName() {
		return this.titleName;
	}

	ArrayList<String> getPermutations() {
		return this.permutations;
	}

}
