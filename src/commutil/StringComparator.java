package commutil;
import java.util.Comparator;

public class StringComparator implements Comparator<String>{
	
	@Override
	public int compare(String x, String y) {
		return x.toLowerCase().compareTo(y.toLowerCase());
	}
}
