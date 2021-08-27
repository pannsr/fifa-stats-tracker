import java.util.Comparator;

public class sortByDraws implements Comparator<Team> {

	@Override
	public int compare(Team a, Team b) {
		return b.amountOfDraws - a.amountOfDraws;
	}


}
