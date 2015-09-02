package pipeandfilter.filters;
import java.util.ArrayList;

public class CircularShifter extends Filter {
	private ArrayList<String> rawTitles = new ArrayList<String>();
	private ArrayList<String> circularShiftedTitles = new ArrayList<String>();
	
	@Override
	public void run() {
		rawTitles = data.get(0);
		
		for (String title : rawTitles) {
			circularShiftedTitles.addAll(circularShift(title));
		}
		
		outPipe.addData(circularShiftedTitles);
		outPipe.addData(data.get(1));
		
		outPipe.close();
	}
	
	private ArrayList<String> circularShift(String string) {
		ArrayList<String> titles = new ArrayList<String>();
		String tokens[] = string.split("\\s");
		for (int i = 0; i < tokens.length; i++) {
			titles.add(String.join(" ", tokens));
			
			//Circular shift
			String temp = tokens[0];
			for (int j = 0; j < tokens.length-1; j++) {
				tokens[j] = tokens[j+1];
			}
			tokens[tokens.length-1] = temp;
		}
		return titles;
	}
}
