import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class mainClass {
	//Variables
	static ArrayList<Team> listOfTeams = new ArrayList<>();
	static ArrayList<Players> listOfPlayers = new ArrayList<>();
	static Scanner mainScan = new Scanner(System.in);
	
	//Introduction
	public static void main(String[] args) {
		System.out.println("Hello! What would you like to do?");
		start();
	}
	
	//Asks for first action
	private static void start() {
		System.out.println("1. Add a new game");
		System.out.println("2. View top scorers and assist makers");
		System.out.println("3. View statistics against other teams");
		System.out.print("Please enter your option: ");
		String nextIntString = mainScan.nextLine(); //get the number as a single line
		int option = Integer.parseInt(nextIntString); //convert the string to an int
		if(option == 1) {
			newGame();
		}
		else if(option == 2) {
			viewTop();
		}
		else if(option == 3) {
			viewStats();
		}
		else {
			System.out.println("Sorry, please enter a valid option: 1, 2, or 3.");
			start();
		}
	}
	
	//Checks if opponent already exists or not. Updates if opponent is new.
	private static void newGame() {
		System.out.print("Please enter the opponent team's name (case-sensitive): ");
		String opponent = mainScan.nextLine();
		for(int i = 0; i < listOfTeams.size(); i ++){
			if(listOfTeams.get(i).getName().equals(opponent)) {
				askResult(opponent);
				return;
			}
		}
		System.out.println("New team detected. The team has now been added.");
		listOfTeams.add(new Team(opponent));
		askResult(opponent);
	}
		
	//---------------------------------------------------------------------
	//Asks for result, updates it
	private static void askResult(String o) {
		String opponent = o;
		System.out.println("Please enter the result for your team: ");
		System.out.println("1. Win");
		System.out.println("2. Draw");
		System.out.println("3. Loss");
		String nextIntString = mainScan.nextLine();
		int result = Integer.parseInt(nextIntString); 
		
		for(int i = 0; i < listOfTeams.size(); i ++) {
			if(listOfTeams.get(i).getName().equals(opponent)) {
				if(result == 1) {
					listOfTeams.get(i).win();
				}
				else if (result == 2) {
					listOfTeams.get(i).draw();
				}
				else if(result == 3) {
					listOfTeams.get(i).loss();
				}
				else {
					System.out.println("Sorry, please enter a valid option: 1, 2, or 3.");
					askResult(opponent);
				}
			}
		}
		anotherGoal();
		anotherAssist();
		pressToCont();
	}
	
	//Checks if goal scorer already exists or not. Updates if player is new.
	private static void whoScored() {
		System.out.println("Who scored?");
		String scorer = mainScan.nextLine();
		for(int i = 0; i < listOfPlayers.size(); i ++){
			if(listOfPlayers.get(i).getName().equals(scorer)) {
				askGoals(scorer);
				anotherGoal();
				return;
			}
		}
		System.out.println("New player detected. The player has now been added.");
		listOfPlayers.add(new Players(scorer));
		askGoals(scorer);
		anotherGoal();
	}
	
	//Asks if someone else scored a goal
	private static void anotherGoal() {
		System.out.println("Did anyone or anyone else score a goal?");
		System.out.println("1. Yes");
		System.out.println("2. No");
		String nextIntString = mainScan.nextLine();
		int ans = Integer.parseInt(nextIntString);
		if(ans == 1) {
			whoScored();
		}
		else if(ans == 2) {
			return;
		}
		else {
			System.out.println("Sorry, please enter a valid option: 1, 2, or 3.");
			anotherGoal();
		}
	}
	
	//Asks how many goals a certain player scored in a game
	private static void askGoals(String s) {
		String scorer = s;
		System.out.println("How many goals did he/she score? ");
		String nextIntString = mainScan.nextLine();
		int goals = Integer.parseInt(nextIntString); 
		for(int i = 0; i < listOfPlayers.size(); i ++) {
			if(listOfPlayers.get(i).getName().equals(scorer)) {
				listOfPlayers.get(i).scored(goals);
			}
		}
	}
	
	//Checks if assist maker already exists or not. Updates if player is new.
	private static void whoAssisted() {
		System.out.println("Who made an assist?");
		String assistor = mainScan.nextLine();
		for(int i = 0; i < listOfPlayers.size(); i ++){
			if(listOfPlayers.get(i).getName().equals(assistor)) {
				askAssists(assistor);
				anotherAssist();
				return;
			}
		}
		System.out.println("New player detected. The player has now been added.");
		listOfPlayers.add(new Players(assistor));
		askAssists(assistor);
		anotherAssist();
	}
	
	//Asks if someone else made an assist
	private static void anotherAssist() {
		System.out.println("Did anyone else make an assist?");
		System.out.println("1. Yes");
		System.out.println("2. No");
		String nextIntString = mainScan.nextLine();
		int ans = Integer.parseInt(nextIntString);
		if(ans == 1) {
			whoAssisted();
		}
		else if(ans == 2) {
			return;
		}
		else {
			System.out.println("Sorry, please enter a valid option: 1, 2, or 3.");
			anotherAssist();
		}
		
	}
	
	//Asks how many goals a certain player scored in a game
	private static void askAssists(String s) {
		String assistMaker = s;
		System.out.println("How many assists did he/she make? ");
		String nextIntString = mainScan.nextLine();
		int assists = Integer.parseInt(nextIntString); 
		for(int i = 0; i < listOfPlayers.size(); i ++) {
			if(listOfPlayers.get(i).getName().equals(assistMaker)) {
				listOfPlayers.get(i).assisted(assists);
			}
		}
	}
	
	//---------------------------------------------------------------------
	//Menu to view top goal scorers and assist makers in the team
	private static void viewTop() {
		System.out.println("What would you like to sort by?");
		System.out.println("1. Goals");
		System.out.println("2. Assists");
		String nextIntString = mainScan.nextLine();
		int ans = Integer.parseInt(nextIntString); 
		if(ans == 1) {
			sortGoals();
			viewTopPlayers();
			pressToCont();
		}
		else if(ans == 2) {
			sortAssists();
			viewTopPlayers();
			pressToCont();
		}
		else {
			System.out.println("Sorry, please enter a valid option: 1, 2, or 3.");
			viewTop();
		}
		
	}
	
	//Sorts from highest goal scorer to least. Prints out the players and their goals and assists.
	private static void viewTopPlayers() {
		for(int i = 0; i < listOfPlayers.size(); i ++) {
			Players currentPlayer = listOfPlayers.get(i);
			System.out.println(currentPlayer.getName() + " - " + currentPlayer.getGoals() + " goal(s)" + " and " + currentPlayer.getAssists() + " assist(s)");
		}
	}
	private static void sortGoals() {
	Collections.sort(listOfPlayers, new sortByGoals());
	}
	
	private static void sortAssists() {
		Collections.sort(listOfPlayers, new sortByAssists());
	}
	//---------------------------------------------------------------------
	private static void viewStats() {
		System.out.println("What would you like to sort by?");
		System.out.println("1. Wins");
		System.out.println("2. Draws");
		System.out.println("3. Losses");
		String nextIntString = mainScan.nextLine();
		int ans = Integer.parseInt(nextIntString); 
		if(ans == 1) {
			sortWins();
			viewTopTeams();
			pressToCont();
		}
		else if(ans == 2) {
			sortDraws();
			viewTopTeams();
			pressToCont();
		}
		else if(ans == 3){
			sortLosses();
			viewTopTeams();
			pressToCont();
		}
		else {
			System.out.println("Sorry, please enter a valid option: 1, 2, or 3.");
			viewTop();
		}
	}
	
	private static void viewTopTeams() {
		for(int i = 0; i < listOfTeams.size(); i ++) {
			Team currentTeam = listOfTeams.get(i);
			System.out.println(currentTeam.getName() + " - " + currentTeam.getWins() + " win(s), " + currentTeam.getDraws() + " draws, and " + currentTeam.getLosses() + " losses");
		}
	}
	private static void sortWins() {
		Collections.sort(listOfTeams, new sortByWins());
	}
	
	private static void sortDraws() {
		Collections.sort(listOfTeams, new sortByDraws());
	}
	
	private static void sortLosses() {
		Collections.sort(listOfTeams, new sortByLosses());
	}
	//---------------------------------------------------------------------
	//Press "/" to go back to main page
	private static void pressToCont() {
		System.out.println("Press / to continue");
		String next = mainScan.nextLine();
		if(next.equals("/")) {
			start();
		}
	}
}
