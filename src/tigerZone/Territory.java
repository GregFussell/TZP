package tigerZone;

import java.util.ArrayList;

public class Territory {
	
	int id;
	char territory;
	boolean isScored;
	boolean isCompleted;
	boolean isDeleted;
	int openFaces;
	int player1Tigers;
	int player2Tigers;
	int numDeer;
	int numBoar;
	int numBuffalo;
	ArrayList<Integer> borderingLakes = new ArrayList<Integer>();
	ArrayList<Integer> borderingDens = new ArrayList<Integer>();
	ArrayList<ArrayCoord> containedTiles = new ArrayList<ArrayCoord>();
	//ArrayList<Integer> mergedTiles = new ArrayList<Integer>();

	public Territory(int id, char type, int openFaces, boolean[] preyAnimals, ArrayList<Integer> borderingLakes, ArrayList<Integer> borderingDens) {
		this.id = id;
		this.territory = type;
		this.openFaces = openFaces;
		int player1Tigers = 0;
		int player2Tigers = 0;

		isScored = false;
		isCompleted = false;
		isDeleted = false;
		
		if (type == 'j' && borderingLakes.size() > 0)
		{
			this.borderingLakes = borderingLakes;
		
		}
		if (type == 'j' && borderingDens.size() > 0)
		{
			this.borderingDens = borderingDens;
		}

		if (preyAnimals[0] == true)
		{
			numDeer = 1;
		}
		if (preyAnimals[1] == true)
		{
			numBoar = 1;
		}
		if (preyAnimals[2] == true)
		{
			numBuffalo = 1;
		}
	}
	
}

