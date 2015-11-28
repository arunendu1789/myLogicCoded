package dell.eclipse;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeagueWinner {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Player> players = new ArrayList<Player>();
		List<Player> winners = new ArrayList<Player>();
		int noOfPlayers, i=1, n;
		boolean isRankUnique, isInputValid = true;
		
		System.out.println("*************************************************************");
		System.out.println("          Welcome to Knock-out Tournament");
		System.out.println("*************************************************************");

		do{
			isInputValid = true;
			System.out.println("Enter the no of Players present in the League(should be an Even number) :");
			noOfPlayers = scanner.nextInt();
			n=noOfPlayers;
			if(n%2 == 0){
				while(n>0){
					n=n/2;
					if((n%2 != 0) && (n>1)){
						System.out.println("\nPlease enter again... as the League is a Knock-out League!!!");
						isInputValid = false;
						break;
					}
				}
			}
			else{
				System.out.println("\nPlease enter again... as the League is a Knock-out League!!!");
				isInputValid = false;
			}
		}while(!isInputValid);
		
	//	noOfPlayers = (int) Math.pow(2, noOfRounds);
		
		while(players.size()!=noOfPlayers){
			Player player = new Player();
			
			do{
				isRankUnique = true;
				System.out.println("Enter the rank of a Player "+i);
				player.setRank(scanner.nextInt());
				
				if(player.getRank()<0){
					System.out.println("\n\n\nPlease try again with a valid rank(non-negative, non-zero value)\n\n\n");
					isRankUnique = false;
				}
				else{
					for(Player spPlayer : players){
						if(spPlayer.getRank()==player.getRank()){
							isRankUnique = false;
							break;
						}
					}
				}
				
			}while(!isRankUnique);
			i++;
			
			players.add(player);
		}
		scanner.close();
		
		do{
			i=1;
			winners.clear();
			for(Player player : players){
				if((i+1)==(noOfPlayers/2)){
					break;
				}
				Player winner = player.whoIsTheWinner(players.get(noOfPlayers-i));
				i++;
				winners.add(winner);
			}
			if(!winners.isEmpty()){
				noOfPlayers = winners.size();
				players = new ArrayList<Player>(winners);
			}
		}while(noOfPlayers>4);
		
		for(Player player : players){
			System.out.println("Players : "+player.getRank());
		}
		
		do{
			i=1;
			winners.clear();
			for(Player player : players){
				Player winner = player.whoIsTheWinner(players.get(noOfPlayers-i));
				i++;
				winners.add(winner);
				if(i==2){
					break;
				}
			}
			if(!winners.isEmpty()){
				noOfPlayers = winners.size();
				players = new ArrayList<Player>(winners);
			}
		}while(noOfPlayers>1);
		
		System.out.println(players.size());
		
		System.out.println("\n\n\n*************************************************************");
		System.out.println("    Winner of the League is the Player with the rank "+players.get(0).getRank());
		System.out.println("*************************************************************");
		
	}

}
