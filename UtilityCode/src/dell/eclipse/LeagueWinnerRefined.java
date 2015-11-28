package dell.eclipse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class LeagueWinnerRefined {
	// This fixture is used to store the matches played between any two players in String
	// That List is used to get the players played against the Top player of the League 
	private static List<String> fixtures = new ArrayList<String>();
	private static Logger theLogger = Logger.getLogger(LeagueWinnerRefined.class.getName());
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		List<Player> players = new ArrayList<Player>();
		List<Player> winners = new ArrayList<Player>();
		List<Player> actualPlayers, runnerUp;
		LeagueWinnerRefined leagueWinner = new LeagueWinnerRefined();
		int noOfPlayers, i=1;
		boolean isRankUnique;
		
		System.out.println("*************************************************************");
		System.out.println("          Welcome to Knock-out Tournament");
		System.out.println("*************************************************************");

		System.out.println("Enter the no of Players present in the League :");
		noOfPlayers = scanner.nextInt();
		
		while(players.size()!=noOfPlayers){
			Player player = new Player();
			
			do{
				isRankUnique = true;
				System.out.println("Enter the rank of a Player "+i);
				player.setRank(scanner.nextInt());
				
				theLogger.info("Validating the rank accepted.");
				theLogger.info("Validating the rank accepted..");
				if(player.getRank()<=0){
					System.out.println("\n\n\nPlease try again with a valid rank(non-negative, non-zero value)\n\n\n");
					isRankUnique = false;
				}
				else{
					theLogger.info("Validating the rank accepted...");
					for(Player spPlayer : players){
						if(spPlayer.getRank()==player.getRank()){
							isRankUnique = false;
							break;
						}
					}
				}
				theLogger.info("Validation of rank done!!!");
			}while(!isRankUnique);
			i++;
			
			
			players.add(player);
		}
		scanner.close();
		actualPlayers = new ArrayList<Player>(players);
		i=0;
		do{
			System.out.println("\n Round : "+ ++i +" starts!!! \n");
			winners = leagueWinner.winnersOfTheRound(players, noOfPlayers);
			System.out.println("Players list after Round : "+ i);
			for(Player winner : winners){
				System.out.println("Players : "+winner.getRank());
			}
			
			noOfPlayers = winners.size();
			players = new ArrayList<Player>(winners);
			
		}while(winners.size()>1);
		
		
		
		System.out.println("\n\n\n*************************************************************");
		System.out.println("    Best Player in the League is the Player with the rank "+winners.get(0).getRank());
		System.out.println("*************************************************************");
		
		System.out.println("\n\n\n A sub-League starts to determine 'Who is the Second Best Player in the League'!!!");
		
		theLogger.info("Analysing the players played with the Winner... to get the deserving second best player in the League...");
		runnerUp = new ArrayList<Player>();
		Iterator<String> iterator = new LeagueWinnerRefined().getFixtures().iterator();
		while(iterator.hasNext()){
			String playersPlaying[] = iterator.next().split(" is playing with ");
			if((playersPlaying[0].equals(String.valueOf(winners.get(0).getRank())))||(playersPlaying[1].equals(String.valueOf(winners.get(0).getRank())))){
				theLogger.info("creating the list of players played with the Winner of the League...");
				if(winners.get(0).getRank() == Integer.valueOf(playersPlaying[0])){
					for(Player player : actualPlayers){
						if(player.getRank() == Integer.valueOf(playersPlaying[1])){
							runnerUp.add(player);
							break;
						}
					}
				}
				else if(winners.get(0).getRank() == Integer.valueOf(playersPlaying[1])){
					for(Player player : actualPlayers){
						if(player.getRank() == Integer.valueOf(playersPlaying[0])){
							runnerUp.add(player);
							break;
						}
					}
				}
			}
		}
		
		System.out.println("\n\n\n Players with Rank, competing in the sub-league to be the second-best Player in the League are :\n");
		for(Player player : runnerUp){
			System.out.println("Players : "+player.getRank());
		}
		
		noOfPlayers = runnerUp.size();
		winners.clear();
		i=0;
		do{
			System.out.println("\n Sub-round : "+ ++i +" starts!!! \n");
			winners = leagueWinner.winnersOfTheRound(runnerUp, noOfPlayers);
			System.out.println("Players list after Round : "+ i);
			for(Player winner : winners){
				System.out.println("Players : "+winner.getRank());
			}
			
			noOfPlayers = winners.size();
			runnerUp = new ArrayList<Player>(winners);
			
		}while(winners.size()>1);
		
		System.out.println("\n\n\n**************************************************************************");
		System.out.println("    Second Best player in the League is the Player with the rank "+winners.get(0).getRank());
		System.out.println("**************************************************************************");
	}
	
	/* This method returns the winners of any Round or Leg of the League*/
	private List<Player> winnersOfTheRound(List<Player> players, int noOfPlayers){
		List<Player> winners = new ArrayList<Player>();
		List<Player> playersPlayed = new ArrayList<Player>();
		LeagueWinnerRefined winnerRefined = new LeagueWinnerRefined();
		Player winner;
		int uniqueRandomNo, i=0;
		while(playersPlayed.size()!=players.size()){
			uniqueRandomNo = getUniqueRandomNumber(players, playersPlayed, i);
			if((playersPlayed.size()+1)!=players.size()){
				winner = (players.get(i)).whoIsTheWinner(players.get(uniqueRandomNo));
				winners.add(winner);
				playersPlayed.add(players.get(i));
				playersPlayed.add(players.get(uniqueRandomNo));
				winnerRefined.setFixtures(players.get(i).getRank()+" is playing with "+players.get(uniqueRandomNo).getRank());
			}else{
				winners.add(players.get(uniqueRandomNo));
				playersPlayed.add(players.get(uniqueRandomNo));
				winnerRefined.setFixtures(players.get(i).getRank()+" is playing with "+players.get(uniqueRandomNo).getRank());
				continue;
			}
			i=getUniqueRandomNumber(players, playersPlayed, (players.size()+1));
		}
		return winners;
	}
	
	/*This method returns a unique random number based on which the two players of any Match is decided */
	private int getUniqueRandomNumber(List<Player> players, List<Player> playersPlayed, int i){
		int uniqueRandomNo=0;
		mainLoop:
		do{
			if((playersPlayed.size()+1)==(players.size())){
				for(int j=0;j<(players.size());j++){
					if(!playersPlayed.contains(players.get(j))){
						uniqueRandomNo = j;
						break mainLoop;
					}
				}
			}
			else if(playersPlayed.size() == players.size()){
				break mainLoop;
			}
			uniqueRandomNo = (int)(Math.random()*(players.size()));
		}while(playersPlayed.contains(players.get(uniqueRandomNo))||(uniqueRandomNo==i));
		return uniqueRandomNo;
	}

	public List<String> getFixtures() {
		return fixtures;
	}

	public void setFixtures(String fixtures) {
		LeagueWinnerRefined.fixtures.add(fixtures);
	}
}
