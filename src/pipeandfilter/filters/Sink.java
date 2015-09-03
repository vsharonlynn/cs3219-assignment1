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
			String token[] = word.split(" ", 2);
			token[0] = token[0].toUpperCase();
			token[1] = token[1].toLowerCase();
			System.out.println(String.join(" ", token));
		}
	}
}
