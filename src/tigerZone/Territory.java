package tigerZone;

import java.util.ArrayList;

public class Territory {
	
	int id;
	char territory;
	boolean isComplete;
	boolean isDeleted;
	ArrayList<Territory> Lakes = new ArrayList<Territory>();
	ArrayList<Territory> Dens = new ArrayList<Territory>();
	int openFaces;
	int player1Meeples;
	int player2Meeples;
	int numTiles;
	int numShields;
	ArrayList<ArrayCoord> containedTiles = new ArrayList<ArrayCoord>();
	

	public Territory(int id, char type, int openFaces, boolean shield) {
		this.id = id;
		this.territory = type;
		this.openFaces = openFaces;
		int player1Meeples = 0;
		int player2Meeples = 0;
		numTiles = 1;
		isComplete = false;
		isDeleted = false;
		if (shield == true)
		{
			numShields = 1;
		}
	}
	
}
