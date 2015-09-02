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
		System.out.println("Enter the list of titles, each title on a new line of itself:\n");
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
		System.out.println("Enter the words to ignore, each word on a new line of itself:\n");
		ArrayList<String> wordsToIgnore = new ArrayList<String>();
		while(scanner.hasNextLine()){
			String str = scanner.nextLine();
			str = str.trim();
			if (str.length() == 0) {
				break;
			}
			wordsToIgnore.add(str);
		}
		return wordsToIgnore;
	}
}
