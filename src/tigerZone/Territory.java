package tigerZone;

import java.util.ArrayList;
//this class serves as our represents the chained cross tile regions of the game
//This object is not held directly by tiles within their subtile arrays, instead they exist in an array called myTerritories
//from there they are accessed using a simulated pointer system
public class Territory {
	
	int id;
	char territory;
	boolean isScored;
	boolean isCompleted;
	boolean isDeleted;
	int openFaces;
	int player1Tigers;
	int player2Tigers;
//	int numDeer;
//	int numBoar;
//	int numBuffalo;
	boolean deer;
	ArrayList<ArrayCoord> containedDeer;
	boolean boar;
	ArrayList<ArrayCoord> containedBoar;
	boolean buffalo;
	ArrayList<ArrayCoord> containedBuffalo;
	boolean crocodile;
	ArrayList<ArrayCoord> containedCrocodile;
	
	
	
	ArrayList<Integer> borderingLakes;//this contains indexes in the pointer array that allow access to the true territory object of a border lake or den
									  //this way if two lakes bordering a single jungle merge the jungle only scores one lake since they point to the same territory object
	ArrayList<Integer> borderingDens;
	ArrayList<ArrayCoord> containedTiles;
	//ArrayList<Integer> containedCrocodiles = new ArrayList<Integer>();

	public Territory(int id, char type, int openFaces, boolean[] preyAnimals, ArrayList<Integer> borderingLakes, ArrayList<Integer> borderingDens) {
		this.id = id;
		this.territory = type;
		this.openFaces = openFaces;
		int player1Tigers = 0;
		int player2Tigers = 0;
		
		containedDeer = new ArrayList<ArrayCoord>();
		containedBoar = new ArrayList<ArrayCoord>();
		containedBuffalo = new ArrayList<ArrayCoord>();
		containedCrocodile = new ArrayList<ArrayCoord>();
		
		this.borderingLakes = new ArrayList<Integer>();
		this.borderingDens = new ArrayList<Integer>();
		containedTiles = new ArrayList<ArrayCoord>();
		

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
			deer = true;
		}
		if (preyAnimals[1] == true)
		{
			boar = true;
		}
		if (preyAnimals[2] == true)
		{
			buffalo = true;
		}
		if (preyAnimals[3] == true)
		{
			crocodile = true;
		}
	}
	
}

