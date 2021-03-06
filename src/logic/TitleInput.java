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
		System.out.println("Enter the titles. Enter an empty line to finish.");
		int numOfTitles = 0;
		System.out.print("Enter a title: ");
		while (sc.hasNextLine()) {
			String title = sc.nextLine().trim();
			if (title.length() == 0) {
				break;
			}
			addTitle(title);
			numOfTitles += 1;
			
			System.out.print("Enter a title: ");
		}
		
		System.out.println("\n" + numOfTitles + " titles have been entered!\n");
	}

	private void inputIgnoredWords() {
		System.out.println("Enter the words to ignore. Enter an empty line to finish.");
		int numOfWords = 0;
		System.out.print("Enter a word to ignore: ");
		while(sc.hasNextLine()) {
			String word = sc.nextLine().trim().toLowerCase();
			if (word.length() == 0) {
				break;
			}
			addIgnoredWord(word);
			numOfWords += 1;
			
			System.out.print("Enter a word to ignore: ");
		}
		
		System.out.println("\n" + numOfWords + " words to ignore have been entered!\n");
	}

	private int readInteger() {
		int num = sc.nextInt();
		sc.nextLine();
		return num;
	}

}
