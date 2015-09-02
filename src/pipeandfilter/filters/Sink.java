package pipeandfilter.filters;
import java.util.ArrayList;

public class Sink extends Filter {
	@Override
	public void run() {
		ArrayList<String> titles = data.get(0);
		displayList(titles);
	}
	
	private void displayList(ArrayList<String> words) {
		for (String word : words) {
			//TODO capitalize the first word
			System.out.println(word);
		}
	}
}
