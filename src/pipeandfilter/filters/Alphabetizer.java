package pipeandfilter.filters;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Alphabetizer extends Filter{
	ArrayList<String> titles = new ArrayList<String>();
	
	@Override
	public void run() {
		titles = data.get(0);
		
		ArrayList<String> sortedTitles = sort();
		
		outPipe.addData(sortedTitles);
		
		outPipe.close();
	}
	
	private ArrayList<String> sort() {
		PriorityQueue<String> titlesPQ= new PriorityQueue<String>();
		
		for (String title : titles) {
			titlesPQ.add(title);
		}
		
		ArrayList<String> sortedTitles = new ArrayList<String>();
		for (String title : titlesPQ) {
			sortedTitles.add(title);
		}
		
		return sortedTitles;
	}
}
