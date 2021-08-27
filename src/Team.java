
public class Team {
	String teamName;
	int amountOfWins;
	int amountOfDraws;
	int amountOfLosses;
	
	public Team(String name) {
		teamName = name;
	}
	
	public String getName() {
		return teamName;
	}
	//---------------
	public void win() {
		amountOfWins ++;
		howManyWins();
	}
	
	public int getWins() {
		return amountOfWins;
	}
	
	public void howManyWins() {
		System.out.println("Result saved. Your team have won " + teamName + " " + amountOfWins + " times.");
	}
	//---------------
	public void draw() {
		amountOfDraws ++;
		howManyDraws();
	}
	
	public int getDraws() {
		return amountOfDraws;
	}
	
	public void howManyDraws() {
		System.out.println("Result saved. Your team have drawn to " + teamName + " " + amountOfDraws + " times.");
	}
	//---------------
	public void loss() {
		amountOfLosses ++;
		howManyLosses();
	}
	public int getLosses() {
		return amountOfLosses;
	}
	
	public void howManyLosses() {
		System.out.println("Result saved. Your team have lost to " + teamName + " " + amountOfLosses + " times.");
	}
}
