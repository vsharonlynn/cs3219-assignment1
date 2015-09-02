package pipeandfilter.filters;
import java.util.ArrayList;
import pipeandfilter.Pipe;

public abstract class Filter implements Runnable {
	protected Pipe outPipe;
	protected ArrayList<ArrayList<String>> data;
	
	public void setOutputPipe(Pipe pipe) {
		outPipe = pipe;
	}
	
	public void addData(ArrayList<String> list) {
		data.add(new ArrayList<String>(list));
	}
}
