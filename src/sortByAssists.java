import java.util.Comparator;

public class sortByAssists implements Comparator<Players> {

	@Override
	public int compare(Players a, Players b) {
		return b.assistsDone - a.assistsDone;
	}


}

