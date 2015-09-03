package pipeandfilter.filters;
import java.util.ArrayList;

public class Sink extends Filter {
	private final String DIVIDER = "======================================================";
	
	@Override
	public void run() {
		ArrayList<String> titles = data.get(0);
		displayList(titles);
	}
	
	private void displayList(ArrayList<String> words) {
		System.out.println("The Key Word In Context (KWIC) index of the titles are:");
		
		System.out.println(DIVIDER);
		
		for (String word : words) {
			String token[] = word.split(" ", 2);
			token[0] = token[0].toUpperCase();
			if (token.length > 1) {
				token[1] = token[1].toLowerCase();
			}
			System.out.println(String.join(" ", token));
		}
		
		System.out.println(DIVIDER);
	}
}
