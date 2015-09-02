package pipeandfilter;
import java.util.ArrayList;
import pipeandfilter.filters.Filter;

public class Pipeline implements Runnable {
	private ArrayList<Filter> filters;
	
	public Pipeline() {
		filters = new ArrayList<Filter>();
	}

	public void addFilter(Filter filter) {
		filters.add(filter);
	}
	
	public void connect() {
		for (int i = 0; i < filters.size() - 1; i++) {
			Pipe pipe = new Pipe();
			filters.get(i).setOutputPipe(pipe);
			pipe.setOutputFilter(filters.get(i+1));
		}
	}

	@Override
	public void run() {
		//TODO if filters is empty, do something
		filters.get(0).run();
	}
}
