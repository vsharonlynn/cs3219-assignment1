package MasterController;

import logic.TitleInput;

import java.util.Scanner;
import java.util.ArrayList;

import logic.Shifter;
import logic.Sorter;
import logic.Output;

public class Controller {

	Scanner sc = new Scanner(System.in);

	private TitleInput input;
	private Shifter shifter;
	private Sorter sorter;
	private Output output;

	public Controller() {
		input = new TitleInput();
		shifter = new Shifter();
		sorter = new Sorter();
		output = new Output();
	}

	public void run() {
		System.out.println("How many ignored words?");
		int numOfIgnoredWords = readInteger();

		for (int i = 0; i < numOfIgnoredWords; i++) {
			String word = sc.nextLine();
			addIgnoredWord(word);
		}

		System.out.println("How many titles?");
		int numOfTitles = readInteger();

		for (int i = 0; i < numOfTitles; i++) {
			String title = sc.nextLine();
			addTitle(title);
		}

		System.out.println("____________________________");

		shifter.shiftAndStore();
		sorter.sort();

		ArrayList<String> sorted = output.getSortedPermutations();
		for (String s : sorted) {
			System.out.println(s);
		}

	}

	private int readInteger() {
		int num = sc.nextInt();
		sc.nextLine();
		return num;
	}

	private void addIgnoredWord(String word) {
		input.addIgnoredWord(word);
	}

	private void addTitle(String title) {
		input.addTitle(title);
	}

	public static void main() {
		Controller c = new Controller();
		c.run();
	}
}
