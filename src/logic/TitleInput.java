package logic;

import model.DataStorage;
import java.util.Scanner;

public class TitleInput {

	private DataStorage activeStorage;
	private Scanner sc;

	public TitleInput() {
		this.activeStorage = DataStorage.getInstance();
		this.sc = new Scanner(System.in);
	}

	public void addTitle(String name) {
		activeStorage.addTitle(name);
	}

	public void addIgnoredWord(String word) {
		activeStorage.addIgnoredWord(word);
	}

	public void processInput() {
		inputIgnoredWords();
		inputTitles();
	}

	private void inputTitles() {
		System.out.print("\nHow many titles? ");
		int numOfTitles = readInteger();

		for (int i = 0; i < numOfTitles; i++) {
			System.out.print("Enter Title #" + (i + 1) + " = ");
			String title = sc.nextLine().trim();
			addTitle(title);
		}
	}

	private void inputIgnoredWords() {
		System.out.print("How many ignored words? ");
		int numOfIgnoredWords = readInteger();

		for (int i = 0; i < numOfIgnoredWords; i++) {
			System.out.print("Enter Ignored Word #" + (i + 1) + " = ");
			String word = sc.nextLine().trim().toLowerCase();
			addIgnoredWord(word);
		}
	}

	private int readInteger() {
		int num = sc.nextInt();
		sc.nextLine();
		return num;
	}

}
