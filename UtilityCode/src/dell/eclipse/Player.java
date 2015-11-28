package dell.eclipse;

public class Player {
	private int rank;

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public Player whoIsTheWinner(Player player){
		System.out.println(this.getRank()+" is playing with "+player.getRank());
		if(this.rank < player.getRank()){
			return this;
		}
		else{
			return player;
		}
	}
}
