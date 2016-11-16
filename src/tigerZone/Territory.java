package tigerZone;

import java.util.ArrayList;

public class Territory {
	
	int id;
	char territory;
	boolean isComplete;
	boolean isDeleted;
	int openFaces;
	int player1Meeples;
	int player2Meeples;
	int numTiles;
	int numDeer;
	int numBoar;
	int numBuffalo;
	ArrayList<ArrayCoord> containedTiles = new ArrayList<ArrayCoord>();
	

	public Territory(int id, char type, int openFaces, boolean deer, boolean boar, boolean buffalo) {
		this.id = id;
		this.territory = type;
		this.openFaces = openFaces;
		int player1Meeples = 0;
		int player2Meeples = 0;
		numTiles = 1;
		isComplete = false;
		isDeleted = false;
		if (deer == true)
		{
			numDeer = 1;
		}
		if (boar == true)
		{
			numBoar = 1;
		}
		if (buffalo == true)
		{
			numBuffalo = 1;
		}
	}
	
}
