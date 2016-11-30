package tigerZone;

public class Player {

	int score;
	int playerID;
	int numTigers;
	int numCrocodiles;
	
	public Player(int playerID)
	{
		this.playerID = playerID;
		score = 0;
		numTigers = 7;
		numCrocodiles = 2;
	}
	
	public void clonePlayer(Player toClone){
		this.playerID = toClone.playerID;
		this.score = toClone.score;
		this.numTigers = toClone.numTigers;
		this.numCrocodiles = toClone.numCrocodiles;
	}
	
}
