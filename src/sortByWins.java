import java.util.Comparator;

public class sortByWins implements Comparator<Team> {

	@Override
	public int compare(Team a, Team b) {
		return b.amountOfWins - a.amountOfWins;
	}


}
