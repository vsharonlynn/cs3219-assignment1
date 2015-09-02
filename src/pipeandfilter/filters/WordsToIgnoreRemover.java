package pipeandfilter.filters;
import java.util.ArrayList;

public class WordsToIgnoreRemover extends Filter{
	private ArrayList<String> titles = new ArrayList<String>();
	private ArrayList<String> wordsToIgnore = new ArrayList<String>();
	
	@Override
	public void run() {
		titles = data.get(0);
		wordsToIgnore = data.get(1);
		
		removeWordsToIgnore();
		
		outPipe.addData(titles);
		outPipe.addData(wordsToIgnore);
		
		outPipe.close();
	}
	
	private void removeWordsToIgnore() {
		for (String title : titles) {
			String token[] = title.split(" ", 2);
			if (wordsToIgnore.contains(token[0])) {
				titles.remove(title);
			}
		}
	}
}
