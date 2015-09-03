package pipeandfilter.filters;
import java.util.ArrayList;
import java.util.Scanner;

public class Pump extends Filter {
	private Scanner scanner = new Scanner(System.in);
	
	@Override
	public void run() {
		outPipe.addData(readWordsToIgnore());
		outPipe.addData(readTitles());
		
		outPipe.close();
	}
	
	private ArrayList<String> readTitles() {
		System.out.println("Enter the titles. Enter an empty line to finish.");
		ArrayList<String> titles = new ArrayList<String>();
		System.out.print("Enter a title: ");
		while(scanner.hasNextLine()){
			String str = scanner.nextLine();
			str = str.trim();
			if (str.length() == 0) {
				break;
			}
			titles.add(str);
			
			System.out.print("Enter a title: ");
		}
		System.out.println("\nTitles have been entered!\n");
		return titles;
	}
	
	private ArrayList<String> readWordsToIgnore() {
		System.out.println("Enter the words to ignore. Enter an empty line to finish.");
		ArrayList<String> wordsToIgnore = new ArrayList<String>();
		System.out.print("Enter a word to ignore: ");
		while(scanner.hasNextLine()){
			String str = scanner.nextLine();
			str = str.trim().toLowerCase();
			if (str.length() == 0) {
				break;
			}
			wordsToIgnore.add(str);
			System.out.print("Enter a word to ignore: ");
		}
		System.out.println("\nWords to ignore have been entered!\n");
		return wordsToIgnore;
	}
}
