package model;

import java.util.LinkedList;

public class Title {
	
	private String titleName;
	private LinkedList<String> permutations;
	
	public Title(String name) {
		this.setTitleName(name);
	}
	
	public void setTitleName(String name) {
		this.titleName = name;
	}
	
	public void setPermutations(LinkedList<String> newPermutations) {
		this.permutations = newPermutations;
	}
	
	public String getTitleName() {
		return this.titleName;
	}
	
	public LinkedList<String> getPermutations() {
		return this.permutations;
	}

}
