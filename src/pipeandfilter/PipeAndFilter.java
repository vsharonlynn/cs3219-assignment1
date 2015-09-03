package pipeandfilter;
import pipeandfilter.filters.Pump;
import pipeandfilter.filters.Sink;
import pipeandfilter.filters.CircularShifter;
import pipeandfilter.filters.WordsToIgnoreRemover;
import pipeandfilter.filters.Alphabetizer;

public class PipeAndFilter implements Runnable{
	Pipeline pipeline;
	
	public PipeAndFilter() {
		pipeline = new Pipeline();
		
		pipeline.addFilter(new Pump());
		pipeline.addFilter(new CircularShifter());
		pipeline.addFilter(new WordsToIgnoreRemover());
		pipeline.addFilter(new Alphabetizer());
		pipeline.addFilter(new Sink());
		
		pipeline.connect();
	}
	
	public void run() {
		pipeline.run();
	}
}
