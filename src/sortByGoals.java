import java.util.Comparator;

public class sortByGoals implements Comparator<Players> {

	@Override
	public int compare(Players a, Players b) {
		return b.goalsScored - a.goalsScored;
	}


}
