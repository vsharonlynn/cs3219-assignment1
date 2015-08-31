package logic;

import model.DataStorage;

public class TitleInput {
	
	private DataStorage activeStorage;
	
	public TitleInput() {
		this.activeStorage = DataStorage.getInstance();
	}
	
	public void addTitle(String name) {
		activeStorage.addTitle(name);
	}
	
	public void addIgnoredWord(String word) {
		activeStorage.addIgnoredWord(word);
	}

}
