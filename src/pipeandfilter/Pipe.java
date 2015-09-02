package pipeandfilter;
import java.util.ArrayList;
import pipeandfilter.filters.Filter;

public class Pipe {
	private Filter outFilter;
	private ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();
	
	public Pipe() {
	}
	
	public void setOutputFilter(Filter filter) {
		outFilter = filter;
	}
	
	public void addData(ArrayList<String> data) {
		datas.add(data);
	}
	
	public void close() {
		for (ArrayList<String> data : datas) {
			outFilter.addData(data);
		}
		
		outFilter.run();
	}
}
