
public class Players {
	String playerName;
	int goalsScored;
	int assistsDone;
	
	public Players(String name) {
		playerName = name;
	}
	
	public String getName() {
		return playerName;
	}
	
	public void scored(int g) {
		goalsScored += g;
		System.out.println("Result saved. " + playerName + " has scored " + goalsScored + " goals.");
	}
	public void assisted(int a) {
		assistsDone += a;
		System.out.println("Result saved. " + playerName + " has assisted " + assistsDone + " times.");
	}
	public int getGoals() {
		return goalsScored;
	}
	public int getAssists() {
		return assistsDone;
	}
	public String toString()
    {
        return this.playerName + " " + this.goalsScored + " " + this.assistsDone; 
                           
    }
}
