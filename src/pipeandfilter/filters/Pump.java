package pipeandfilter.filters;
import java.util.ArrayList;
import java.util.Scanner;

public class Pump extends Filter {
	private Scanner scanner = new Scanner(System.in);
	
	@Override
	public void run() {
		outPipe.addData(readTitles());
		outPipe.addData(readWordsToIgnore());
		
		outPipe.close();
	}
	
	private ArrayList<String> readTitles() {
		System.out.println("\nEnter the titles, each on a new line of itself: (Enter an empty line to finish)");
		ArrayList<String> titles = new ArrayList<String>();
		while(scanner.hasNextLine()){
			String str = scanner.nextLine();
			str = str.trim();
			if (str.length() == 0) {
				break;
			}
			titles.add(str);
		}
		return titles;
	}
	
	private ArrayList<String> readWordsToIgnore() {
		System.out.println("Enter the words to ignore, each on a new line of itself: (Enter an empty line to finish)");
		ArrayList<String> wordsToIgnore = new ArrayList<String>();
		while(scanner.hasNextLine()){
			String str = scanner.nextLine();
			str = str.trim().toLowerCase();
			if (str.length() == 0) {
				break;
			}
			wordsToIgnore.add(str);
		}
		return wordsToIgnore;
	}
}
