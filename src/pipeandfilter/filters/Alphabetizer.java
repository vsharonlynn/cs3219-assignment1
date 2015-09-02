package pipeandfilter.filters;
import java.util.ArrayList;
import java.util.PriorityQueue;
import commutil.StringComparator;

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
		StringComparator comparator = new StringComparator();
		PriorityQueue<String> titlesPQ = new PriorityQueue<String>(comparator);
		
		for (String title : titles) {
			titlesPQ.add(title);
		}
		
		ArrayList<String> sortedTitles = new ArrayList<String>();
		while (!titlesPQ.isEmpty()) {
			sortedTitles.add(titlesPQ.poll());
		}
		
		return sortedTitles;
	}
}
