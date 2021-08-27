import java.util.Comparator;

public class sortByLosses implements Comparator<Team> {

	@Override
	public int compare(Team a, Team b) {
		return b.amountOfLosses - a.amountOfLosses;
	}


}
