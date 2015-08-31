package model;

import java.util.ArrayList;

public class Title {
	
	private String titleName;
	private ArrayList<String> permutations;
	
	public Title(String name) {
		this.setTitleName(name);
	}
	
	public void setTitleName(String name) {
		this.titleName = name;
	}
	
	public void setPermutations(ArrayList<String> newPermutations) {
		this.permutations = newPermutations;
	}
	
	public String getTitleName() {
		return this.titleName;
	}
	
	public ArrayList<String> getPermutations() {
		return this.permutations;
	}

}
