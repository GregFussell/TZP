package tigerZone;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	
	////////fields to track gamestate
	private ArrayList<ArrayCoord> placeablePos;
	private ArrayList<ArrayCoord> placedPos;
	private Tile[][] board;
	private Deck myDeck;
	private Territory[] myTerritories;
	private int myTerritoriesSize;

	/////constructor
	public Game(int boardWidth, int boardLength){
		placeablePos = new ArrayList<ArrayCoord>();
		placedPos = new ArrayList<ArrayCoord>();
		board = new Tile[boardWidth][boardLength];
		myDeck = new Deck();
		myTerritories = new Territory[246];
		setMyTerritoriesSize(0);
	}
	
	
	/////getters and setters for private fields//////
	////////////pretty self explanatory//////////////
	public int getMyTerritoriesSize() {
		return myTerritoriesSize;
	}

	public void setMyTerritoriesSize(int myTerritoriesSize) {
		this.myTerritoriesSize = myTerritoriesSize;
	}
	
	public ArrayList<ArrayCoord> getPlaceable(){
		return placeablePos;
	}
	
	public void addPlaceable(int x, int y){
		placeablePos.add(new ArrayCoord(x,y));
	}
	
	public ArrayList<ArrayCoord> getPlaced(){
		return placedPos;
	}
	
	public void addPlaced(int x, int y){
		placedPos.add(new ArrayCoord(x,y));
	}
	
	public Tile[][] getBoard(){
		return board;
	}

	public Tile getTile(int x, int y){
		return board[x][y];
	}
	
	public void addToBoard(int x, int y, Tile tile){
		board[x][y] = tile;
	}
	
	public Deck getDeck(){
		return myDeck;
	}
	
	public void addToDeck(Tile tile){
		myDeck.add(tile);
	}
	
	public Tile nextTile(){
		return myDeck.remove();
	}
	
	public int deckSize(){
		return myDeck.size();
	}
	
	public Territory[] getTerritories(){
		return myTerritories;
	}
	
	public void setTerritories(Territory[] newter){
		myTerritories = newter;
	}

	//////////////// METHODS ///////////////////

	// Method for evaluating whether continuity in territory types is preserved
	// in adjacent tiles. Returns True if valid
	public boolean validPlacement(Tile currentTile, int x, int y, TerritoryPtr terPtr) {

		boolean flag = false;
		for (int i = 0; i < placeablePos.size(); i++) {
			if (x == placeablePos.get(i).x && y == placeablePos.get(i).y) {
				flag = true;
			}
		}
		if (flag == false) {
			return false;
		}

		if (board[x - 1][y] != null) {
			if (myTerritories[terPtr.pointers[currentTile.subtiles[1]]].territory != myTerritories[terPtr.pointers[board[x - 1][y].subtiles[7]]].territory) {
				return false;
			}
		}
		if (board[x + 1][y] != null) {
			if (myTerritories[terPtr.pointers[currentTile.subtiles[7]]].territory != myTerritories[terPtr.pointers[board[x + 1][y].subtiles[1]]].territory) {
				return false;
			}
		}
		if (board[x][y + 1] != null) {
			if (myTerritories[terPtr.pointers[currentTile.subtiles[4]]].territory != myTerritories[terPtr.pointers[board[x][y + 1].subtiles[10]]].territory) {
				return false;
			}
		}
		if (board[x][y - 1] != null) {
			if (myTerritories[terPtr.pointers[currentTile.subtiles[10]]].territory != myTerritories[terPtr.pointers[board[x][y - 1].subtiles[4]]].territory) {
				return false;
			}
		}
		return true;
	}

	// Method that takes the user's chosen position out of the placeablePos
	// array and adds it to the placedPos array
	// Also adds the four adjacent sides to the newly placed tile into the
	// placeablePos array
	public void updatePlaceable( int x,	int y) {

		for (int i = 0; i < placeablePos.size(); i++) {

			if (x == placeablePos.get(i).x && y == placeablePos.get(i).y) {
				placedPos.add(placeablePos.get(i));
				if (placeablePos.remove(placeablePos.get(i)) == true) {

				}
			} else {

			}
		}

		boolean north = false;
		boolean south = false;
		boolean west = false;
		boolean east = false;

		// Check if adjacent tile space has already been placed
		for (int i = 0; i < placedPos.size(); i++) {

			if ((x - 1) == placedPos.get(i).x && y == placedPos.get(i).y) {
				north = true;
			} else if ((x + 1) == placedPos.get(i).x && y == placedPos.get(i).y) {
				south = true;
			} else if (x == placedPos.get(i).x && (y - 1) == placedPos.get(i).y) {
				west = true;
			} else if (x == placedPos.get(i).x && (y + 1) == placedPos.get(i).y) {
				east = true;
			}
		}

		// Adds a placeable tile location if no tile has been placed adjacent
		if (north == false) {
			placeablePos.add(new ArrayCoord((x - 1), y));
		}
		if (south == false) {
			placeablePos.add(new ArrayCoord((x + 1), y));
		}
		if (west == false) {
			placeablePos.add(new ArrayCoord(x, (y - 1)));
		}
		if (east == false) {
			placeablePos.add(new ArrayCoord(x, (y + 1)));
		}

	}
	
	//Adds the location of the placed tile to the territories, also adds the location of any deer, buffalo, boar, or crocodile if any 
	public void addContainedTile(Tile currentTile, TerritoryPtr terPtr, int x, int y)
	{
		for (int i = 0; i < 13; i++)
		{
			boolean duplicate = false;
			for (int j = 0; j < myTerritories[terPtr.pointers[currentTile.subtiles[i]]].containedTiles.size(); j++)
			{
				if (myTerritories[terPtr.pointers[currentTile.subtiles[i]]].containedTiles.get(j).x == x && myTerritories[terPtr.pointers[currentTile.subtiles[i]]].containedTiles.get(j).y == y)
				{
					duplicate = true;
				}
			}
			if (duplicate == false)
			{
				myTerritories[terPtr.pointers[currentTile.subtiles[i]]].containedTiles.add(new ArrayCoord(x,y));
			}
				
			if (myTerritories[terPtr.pointers[currentTile.subtiles[i]]].deer == true)
			{
				myTerritories[terPtr.pointers[currentTile.subtiles[i]]].containedDeer.add(new ArrayCoord(x,y));
				myTerritories[terPtr.pointers[currentTile.subtiles[i]]].deer = false;
			}
			if (myTerritories[terPtr.pointers[currentTile.subtiles[i]]].boar == true)
			{
				myTerritories[terPtr.pointers[currentTile.subtiles[i]]].containedBoar.add(new ArrayCoord(x,y));
				myTerritories[terPtr.pointers[currentTile.subtiles[i]]].boar = false;
			}
			if (myTerritories[terPtr.pointers[currentTile.subtiles[i]]].buffalo == true)
			{
				myTerritories[terPtr.pointers[currentTile.subtiles[i]]].containedBuffalo.add(new ArrayCoord(x,y));
				myTerritories[terPtr.pointers[currentTile.subtiles[i]]].buffalo = false;
			}
			if (myTerritories[terPtr.pointers[currentTile.subtiles[i]]].crocodile == true)
			{
				myTerritories[terPtr.pointers[currentTile.subtiles[i]]].containedCrocodile.add(new ArrayCoord(x,y));
				myTerritories[terPtr.pointers[currentTile.subtiles[i]]].crocodile = false;
			}
		}
	}
	
	////////////////////////////////////////// MERGING /////////////////////////////////////////////////////////////////////

	
	public void mergeTile( Tile myTile, TerritoryPtr terPtr, ArrayList<Integer> currentDens, int x, int y)
	{
		int[] rewriteIDs = new int[12];
		int[] currentIDs = new int[12];
		
		//Merging with tile above it, if it exists
		if (board[x-1][y] != null)
		{
			//Merge 0 index if its a jungle
			if (myTerritories[terPtr.pointers[myTile.subtiles[0]]].territory == 'j' && myTerritories[terPtr.pointers[myTile.subtiles[0]]].id != myTerritories[terPtr.pointers[board[x-1][y].subtiles[8]]].id)
			{
				mergeTerritory(myTerritories[terPtr.pointers[board[x-1][y].subtiles[8]]], myTerritories[terPtr.pointers[myTile.subtiles[0]]], x, y);
				rewriteIDs[0] = myTerritories[terPtr.pointers[board[x-1][y].subtiles[8]]].id;
				currentIDs[0] = myTerritories[terPtr.pointers[myTile.subtiles[0]]].id;
				
				myTerritories[terPtr.pointers[rewriteIDs[0]]].isDeleted = true;
				terPtr.rewritePtr(currentIDs[0], rewriteIDs[0]);
			}

			//Merge 1 index
			if (myTerritories[terPtr.pointers[board[x-1][y].subtiles[7]]] != myTerritories[terPtr.pointers[myTile.subtiles[1]]])
			{
				mergeTerritory( myTerritories[terPtr.pointers[board[x-1][y].subtiles[7]]], myTerritories[terPtr.pointers[myTile.subtiles[1]]], x, y);
				rewriteIDs[1] = myTerritories[terPtr.pointers[board[x-1][y].subtiles[7]]].id;
				currentIDs[1] = myTerritories[terPtr.pointers[myTile.subtiles[1]]].id;
			
				myTerritories[terPtr.pointers[rewriteIDs[1]]].isDeleted = true;
				terPtr.rewritePtr(currentIDs[1], rewriteIDs[1]);	
			}
				
			//Merge 2 index if its a jungle
			if (myTerritories[terPtr.pointers[myTile.subtiles[2]]].territory == 'j' && myTerritories[terPtr.pointers[myTile.subtiles[2]]].id != myTerritories[terPtr.pointers[board[x-1][y].subtiles[6]]].id)
			{
				mergeTerritory( myTerritories[terPtr.pointers[board[x-1][y].subtiles[6]]], myTerritories[terPtr.pointers[myTile.subtiles[2]]], x, y);
				rewriteIDs[2] = myTerritories[terPtr.pointers[board[x-1][y].subtiles[6]]].id;
				currentIDs[2] = myTerritories[terPtr.pointers[myTile.subtiles[2]]].id;
	
				myTerritories[terPtr.pointers[rewriteIDs[2]]].isDeleted = true;
				terPtr.rewritePtr(currentIDs[2], rewriteIDs[2]);
			}
		}
		
		//Merging with tile to right, if it exists
		if (board[x][y+1] != null)
		{
			//Merge 3 index if its a jungle
			if (myTerritories[terPtr.pointers[myTile.subtiles[3]]].territory == 'j' && myTerritories[terPtr.pointers[myTile.subtiles[3]]].id != myTerritories[terPtr.pointers[board[x][y+1].subtiles[11]]].id)
			{
				mergeTerritory( myTerritories[terPtr.pointers[board[x][y+1].subtiles[11]]], myTerritories[terPtr.pointers[myTile.subtiles[3]]], x, y);
				rewriteIDs[3] = myTerritories[terPtr.pointers[board[x][y+1].subtiles[11]]].id;
				currentIDs[3] = myTerritories[terPtr.pointers[myTile.subtiles[3]]].id;
				
				myTerritories[terPtr.pointers[rewriteIDs[3]]].isDeleted = true;
				terPtr.rewritePtr(currentIDs[3], rewriteIDs[3]);
			}

			//Merge 4 index
			if (myTerritories[terPtr.pointers[board[x][y+1].subtiles[10]]] != myTerritories[terPtr.pointers[myTile.subtiles[4]]])
			{
				mergeTerritory( myTerritories[terPtr.pointers[board[x][y+1].subtiles[10]]], myTerritories[terPtr.pointers[myTile.subtiles[4]]], x, y);
				rewriteIDs[4] = myTerritories[terPtr.pointers[board[x][y+1].subtiles[10]]].id;
				currentIDs[4] = myTerritories[terPtr.pointers[myTile.subtiles[4]]].id;
			
				myTerritories[terPtr.pointers[rewriteIDs[4]]].isDeleted = true;
				terPtr.rewritePtr(currentIDs[4], rewriteIDs[4]);
			}
			else if (myTerritories[terPtr.pointers[board[x][y+1].subtiles[10]]] == myTerritories[terPtr.pointers[myTile.subtiles[4]]])
			{
				myTerritories[terPtr.pointers[myTile.subtiles[4]]].openFaces -= 2;
			}
			
			//Merge 5 index if its a jungle
			if (myTerritories[terPtr.pointers[myTile.subtiles[5]]].territory == 'j' && myTerritories[terPtr.pointers[myTile.subtiles[5]]].id != myTerritories[terPtr.pointers[board[x][y+1].subtiles[9]]].id)
			{
				mergeTerritory( myTerritories[terPtr.pointers[board[x][y+1].subtiles[9]]], myTerritories[terPtr.pointers[myTile.subtiles[5]]], x, y);
				rewriteIDs[5] = myTerritories[terPtr.pointers[board[x][y+1].subtiles[9]]].id;
				currentIDs[5] = myTerritories[terPtr.pointers[myTile.subtiles[5]]].id;
				
				myTerritories[terPtr.pointers[rewriteIDs[5]]].isDeleted = true;
				terPtr.rewritePtr(currentIDs[5], rewriteIDs[5]);
			}
		}
		
		//Merging with tile below it, if it exists
		if (board[x+1][y] != null)
		{
			//Merge 6 index if its a jungle
			if (myTerritories[terPtr.pointers[myTile.subtiles[6]]].territory == 'j' && myTerritories[terPtr.pointers[myTile.subtiles[6]]].id != myTerritories[terPtr.pointers[board[x+1][y].subtiles[2]]].id)
			{
				mergeTerritory( myTerritories[terPtr.pointers[board[x+1][y].subtiles[2]]], myTerritories[terPtr.pointers[myTile.subtiles[6]]], x, y);
				rewriteIDs[6] = myTerritories[terPtr.pointers[board[x+1][y].subtiles[2]]].id;
				currentIDs[6] = myTerritories[terPtr.pointers[myTile.subtiles[6]]].id;
				
				myTerritories[terPtr.pointers[rewriteIDs[6]]].isDeleted = true;
				terPtr.rewritePtr(currentIDs[6], rewriteIDs[6]);
			}

			//Merge 7 index
			if (myTerritories[terPtr.pointers[board[x+1][y].subtiles[1]]] != myTerritories[terPtr.pointers[myTile.subtiles[7]]])
			{
				mergeTerritory( myTerritories[terPtr.pointers[board[x+1][y].subtiles[1]]], myTerritories[terPtr.pointers[myTile.subtiles[7]]], x, y);
				rewriteIDs[7] = myTerritories[terPtr.pointers[board[x+1][y].subtiles[1]]].id;
				currentIDs[7] = myTerritories[terPtr.pointers[myTile.subtiles[7]]].id;
			
				myTerritories[terPtr.pointers[rewriteIDs[7]]].isDeleted = true;
				terPtr.rewritePtr(currentIDs[7], rewriteIDs[7]);
			}
			else if (myTerritories[terPtr.pointers[board[x+1][y].subtiles[1]]] == myTerritories[terPtr.pointers[myTile.subtiles[7]]])
			{
				myTerritories[terPtr.pointers[myTile.subtiles[7]]].openFaces -= 2;
			}
			
			//Merge 8 index if its a jungle
			if (myTerritories[terPtr.pointers[myTile.subtiles[8]]].territory == 'j' && myTerritories[terPtr.pointers[myTile.subtiles[8]]].id != myTerritories[terPtr.pointers[board[x+1][y].subtiles[0]]].id)
			{
				mergeTerritory( myTerritories[terPtr.pointers[board[x+1][y].subtiles[0]]], myTerritories[terPtr.pointers[myTile.subtiles[8]]], x, y);
				rewriteIDs[8] = myTerritories[terPtr.pointers[board[x+1][y].subtiles[0]]].id;
				currentIDs[8] = myTerritories[terPtr.pointers[myTile.subtiles[8]]].id;
				
				myTerritories[terPtr.pointers[rewriteIDs[8]]].isDeleted = true;
				terPtr.rewritePtr(currentIDs[8], rewriteIDs[8]);
			}
		}
		
		//Merging with tile to left, if it exists
		if (board[x][y-1] != null)
		{
			//Merge 9 index if its a jungle
			if (myTerritories[terPtr.pointers[myTile.subtiles[9]]].territory == 'j' && myTerritories[terPtr.pointers[myTile.subtiles[9]]].id != myTerritories[terPtr.pointers[board[x][y-1].subtiles[5]]].id)
			{
				mergeTerritory( myTerritories[terPtr.pointers[board[x][y-1].subtiles[5]]], myTerritories[terPtr.pointers[myTile.subtiles[9]]], x, y);
				rewriteIDs[9] = myTerritories[terPtr.pointers[board[x][y-1].subtiles[5]]].id;
				currentIDs[9] = myTerritories[terPtr.pointers[myTile.subtiles[9]]].id;
				
				myTerritories[terPtr.pointers[rewriteIDs[9]]].isDeleted = true;
				terPtr.rewritePtr(currentIDs[9], rewriteIDs[9]);
			}

			//Merge 10 index
			if (myTerritories[terPtr.pointers[board[x][y-1].subtiles[4]]] != myTerritories[terPtr.pointers[myTile.subtiles[10]]])
			{
				mergeTerritory( myTerritories[terPtr.pointers[board[x][y-1].subtiles[4]]], myTerritories[terPtr.pointers[myTile.subtiles[10]]], x, y);
				rewriteIDs[10] = myTerritories[terPtr.pointers[board[x][y-1].subtiles[4]]].id;
				currentIDs[10] = myTerritories[terPtr.pointers[myTile.subtiles[10]]].id;
			
				myTerritories[terPtr.pointers[rewriteIDs[10]]].isDeleted = true;
				terPtr.rewritePtr(currentIDs[10], rewriteIDs[10]);
			}
			else if (myTerritories[terPtr.pointers[board[x][y-1].subtiles[4]]] == myTerritories[terPtr.pointers[myTile.subtiles[10]]])
			{
				myTerritories[terPtr.pointers[myTile.subtiles[10]]].openFaces -= 2;
			}
			
			//Merge 11 index if its a jungle
			if (myTerritories[terPtr.pointers[myTile.subtiles[11]]].territory == 'j' && myTerritories[terPtr.pointers[myTile.subtiles[11]]].id != myTerritories[terPtr.pointers[board[x][y-1].subtiles[3]]].id)
			{
				mergeTerritory( myTerritories[terPtr.pointers[board[x][y-1].subtiles[3]]], myTerritories[terPtr.pointers[myTile.subtiles[11]]], x, y);
				rewriteIDs[11] = myTerritories[terPtr.pointers[board[x][y-1].subtiles[3]]].id;
				currentIDs[11] = myTerritories[terPtr.pointers[myTile.subtiles[11]]].id;
				
				myTerritories[terPtr.pointers[rewriteIDs[11]]].isDeleted = true;
				terPtr.rewritePtr(currentIDs[11], rewriteIDs[11]);
			}
		}
		
		//Create a Den if den exists on tile by populating Moore neighborhood
		if (myTerritories[terPtr.pointers[myTile.subtiles[12]]].territory == 'd')
		{
			//myTerritories[terPtr.pointers[myTile.subtiles[12]]].containedTiles.add(new ArrayCoord(x,y));
			populateDen( myTerritories[terPtr.pointers[myTile.subtiles[12]]], x, y);
			currentDens.add(terPtr.pointers[myTile.subtiles[12]]);
		}
	}
	
	//Method to merge the contents of one territory with another.
	public void mergeTerritory( Territory toMerge, Territory currentTerritory, int x, int y)
	{	
	
//		currentTerritory.numDeer += toMerge.numDeer;
//		currentTerritory.numBoar += toMerge.numBoar;
//		currentTerritory.numBuffalo += toMerge.numBuffalo;
		currentTerritory.openFaces += toMerge.openFaces - 2;
		currentTerritory.player1Tigers += toMerge.player1Tigers;
		currentTerritory.player2Tigers += toMerge.player2Tigers;
		
		//Merges contained tiles from the toMerge territory into the currentTerritory
		//Checks if the tile is already in the territory to prevent double scoring a tile.
		boolean duplicate = false;
		for (int i = 0; i < toMerge.containedTiles.size(); i++)
		{
			for (int j = 0; j < currentTerritory.containedTiles.size(); j++)
			{
				if (currentTerritory.containedTiles.get(j).x == toMerge.containedTiles.get(i).x && currentTerritory.containedTiles.get(j).y == toMerge.containedTiles.get(i).y)
				{
					duplicate = true;
				}			

			}
			if (duplicate == false)
			{
				currentTerritory.containedTiles.add(new ArrayCoord(toMerge.containedTiles.get(i).x,toMerge.containedTiles.get(i).y));
			}
		}
		
		//Merges arrayList of contained buffalo, deer, boar and crocodile
		mergeAnimals(toMerge, currentTerritory);
		
		
		//Updates borderingLakes and borderingDens if type is jungle
		if (currentTerritory.territory == 'j' && toMerge.territory == 'j')
		{
		
			//Checks all borderLakes in toMerge
			for (int i = 0; i < toMerge.borderingLakes.size(); i++)
			{				
				//Add the borderLake to current Territory if it is not in current Territory
				if (currentTerritory.borderingLakes.contains(toMerge.borderingLakes.get(i)) == false)
				{
					currentTerritory.borderingLakes.add(toMerge.borderingLakes.get(i));
				}
			}
			
			//Checks all borderDens in toMerge
			for (int i = 0; i < toMerge.borderingDens.size(); i++)
			{
				//Add the borderDens to current Territory if it is not in current Territory
				if (currentTerritory.borderingDens.contains(toMerge.borderingDens.get(i)) == false)
				{
					currentTerritory.borderingDens.add(toMerge.borderingDens.get(i));
				}
			}
		}
	}
	
	public void mergeAnimals(Territory toMerge, Territory currentTerritory)
	{
		//Merge deer
		boolean duplicate = false;
		for (int i = 0; i < toMerge.containedDeer.size(); i++)
		{
			for (int j = 0; j < currentTerritory.containedDeer.size(); j++)
			{
				if (currentTerritory.containedDeer.get(j).x == toMerge.containedDeer.get(i).x && currentTerritory.containedDeer.get(j).y == toMerge.containedDeer.get(i).y)
				{
					duplicate = true;
				}			

			}
			if (duplicate == false)
			{
				currentTerritory.containedDeer.add(new ArrayCoord(toMerge.containedDeer.get(i).x,toMerge.containedDeer.get(i).y));
			}
		}
		
		//Merge boar
		duplicate = false;
		for (int i = 0; i < toMerge.containedBoar.size(); i++)
		{
			for (int j = 0; j < currentTerritory.containedBoar.size(); j++)
			{
				if (currentTerritory.containedBoar.get(j).x == toMerge.containedBoar.get(i).x && currentTerritory.containedBoar.get(j).y == toMerge.containedBoar.get(i).y)
				{
					duplicate = true;
				}			

			}
			if (duplicate == false)
			{
				currentTerritory.containedBoar.add(new ArrayCoord(toMerge.containedBoar.get(i).x,toMerge.containedBoar.get(i).y));
			}
		}
		
		//Merge buffalo
		duplicate = false;
		for (int i = 0; i < toMerge.containedBuffalo.size(); i++)
		{
			for (int j = 0; j < currentTerritory.containedBuffalo.size(); j++)
			{
				if (currentTerritory.containedBuffalo.get(j).x == toMerge.containedBuffalo.get(i).x && currentTerritory.containedBuffalo.get(j).y == toMerge.containedBuffalo.get(i).y)
				{
					duplicate = true;
				}			

			}
			if (duplicate == false)
			{
				currentTerritory.containedBuffalo.add(new ArrayCoord(toMerge.containedBuffalo.get(i).x,toMerge.containedBuffalo.get(i).y));
			}
		}
		
		//Merge crocodile
		duplicate = false;
		for (int i = 0; i < toMerge.containedCrocodile.size(); i++)
		{
			for (int j = 0; j < currentTerritory.containedCrocodile.size(); j++)
			{
				if (currentTerritory.containedCrocodile.get(j).x == toMerge.containedCrocodile.get(i).x && currentTerritory.containedCrocodile.get(j).y == toMerge.containedCrocodile.get(i).y)
				{
					duplicate = true;
				}			

			}
			if (duplicate == false)
			{
				currentTerritory.containedCrocodile.add(new ArrayCoord(toMerge.containedCrocodile.get(i).x,toMerge.containedCrocodile.get(i).y));
			}
		}	
	}
	
	//Checks moore neighboorhood of den for placed tiles and adds the locations that aren't placed
	public void populateDen(Territory den, int x, int y)
	{
		//check topleft
		if (board[x-1][y-1] == null)
		{
			ArrayCoord topLeft = new ArrayCoord(x-1,y-1);
			den.containedTiles.add(topLeft);
		}
		//check top
		if (board[x-1][y] == null)
		{
			ArrayCoord top = new ArrayCoord(x-1,y);
			den.containedTiles.add(top);
		}
		//check topRight
		if (board[x-1][y+1] == null)
		{
			ArrayCoord topRight = new ArrayCoord(x-1,y+1);
			den.containedTiles.add(topRight);
		}
		//check left
		if (board[x][y-1] == null)
		{
			ArrayCoord left = new ArrayCoord(x,y-1);
			den.containedTiles.add(left);
		}
		//check right
		if (board[x][y+1] == null)
		{
			ArrayCoord right = new ArrayCoord(x,y+1);
			den.containedTiles.add(right);
		}
		//check bottomLeft
		if (board[x+1][y-1] == null)
		{
			ArrayCoord bottomLeft = new ArrayCoord(x+1,y-1);
			den.containedTiles.add(bottomLeft);
		}
		//check bottom
		if (board[x+1][y] == null)
		{
			ArrayCoord bottom = new ArrayCoord(x+1,y);
			den.containedTiles.add(bottom);
		}
		//check bottomRight
		if (board[x+1][y+1] == null)
		{
			ArrayCoord bottomRight = new ArrayCoord(x+1,y+1);
			den.containedTiles.add(bottomRight);
		}
	}

	//Checks mooreNeighborhood of dens as new tiles are placed, and scores den if it is completed
	public void checkMooreNeighborhood(Territory den, Player player1, Player player2, int x, int y)
	{
		for (int i = 0; i < den.containedTiles.size(); i++)
		{
			if (den.containedTiles.get(i).x == x && den.containedTiles.get(i).y == y)
			{
				den.containedTiles.remove(i);
			}
		}
		
		if (den.containedTiles.size() == 0)
		{
			int denScore = 9;
			//Player1 gets score if they have more tigers
			if (den.player1Tigers > den.player2Tigers)
			{
				System.out.println("Player 1 has earned " + denScore + " points for a completed den");
				player1.score += denScore;
				player1.numTigers++;
			}
			//Player2 gets score if they have more tigers
			if (den.player1Tigers < den.player2Tigers)
			{
				System.out.println("Player 2 has earned " + denScore + " points for a completed den");
				player2.score += denScore;
				player2.numTigers++;
			}
			den.isCompleted = true;
			den.isScored = true;
		}
	}

	//////////////////////////////// TIGER PLACEMENT \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	public void tigerPlacement(Tile currentTile, TerritoryPtr terPtr, Player player, Scanner sc)
	{
		//Player can only place if they have a tiger available
		if (player.numTigers > 0)
		{
			ArrayList<Integer> availableTigerLoc = new ArrayList<Integer>();
			ArrayList<Integer> zoneIndex = new ArrayList<Integer>();

			//Map for Zone 1//
			//If 0 and 11 are lakes, check if they have different ID, if so map the jungle to zone 1 (Tile JLLJ-). if not, zone is the lake in index 0
			if (myTerritories[terPtr.pointers[currentTile.subtiles[0]]].territory == 'l' && myTerritories[terPtr.pointers[currentTile.subtiles[11]]].territory == 'l')
			{
				//Lakes have different ID
				if (myTerritories[terPtr.pointers[currentTile.subtiles[0]]].id != myTerritories[terPtr.pointers[currentTile.subtiles[11]]].id)
				{
					//Ensures no tigers present on the jungle
					if (myTerritories[terPtr.pointers[currentTile.subtiles[3]]].player1Tigers == 0 && myTerritories[terPtr.pointers[currentTile.subtiles[3]]].player2Tigers == 0)
					{
						//Add the ID of the available tiger location if it is not already present and print its position
						if (availableTigerLoc.contains(myTerritories[terPtr.pointers[currentTile.subtiles[3]]].id) == false)
						{
							System.out.println("A Tiger may be placed on zone 1 which is type " + myTerritories[terPtr.pointers[currentTile.subtiles[3]]].territory);
							availableTigerLoc.add(myTerritories[terPtr.pointers[currentTile.subtiles[3]]].id);
							zoneIndex.add(1);
						}
					}
				}
				//Lakes have same ID, map zone 1 to the lake
				else
				{
					//Ensures no tigers present on the lake
					if (myTerritories[terPtr.pointers[currentTile.subtiles[0]]].player1Tigers == 0 && myTerritories[terPtr.pointers[currentTile.subtiles[0]]].player2Tigers == 0)
					{
						//Add the ID of the available tiger location if it is not already present and print its position
						if (availableTigerLoc.contains(myTerritories[terPtr.pointers[currentTile.subtiles[0]]].id) == false)
						{
								System.out.println("A Tiger may be placed on zone 1 which is type " + myTerritories[terPtr.pointers[currentTile.subtiles[0]]].territory);
								availableTigerLoc.add(myTerritories[terPtr.pointers[currentTile.subtiles[0]]].id);
								zoneIndex.add(1);
						}
					}
				}
			}
			//If index 0 is a jungle, map zone 1 to index 0
			else if (myTerritories[terPtr.pointers[currentTile.subtiles[0]]].territory == 'j')
			{
				//Ensures no tigers present on the lake
				if (myTerritories[terPtr.pointers[currentTile.subtiles[0]]].player1Tigers == 0 && myTerritories[terPtr.pointers[currentTile.subtiles[0]]].player2Tigers == 0)
				{
					//Add the ID of the available tiger location if it is not already present and print its position
					if (availableTigerLoc.contains(myTerritories[terPtr.pointers[currentTile.subtiles[0]]].id) == false)
					{
							System.out.println("A Tiger may be placed on zone 1 which is type " + myTerritories[terPtr.pointers[currentTile.subtiles[0]]].territory);
							availableTigerLoc.add(myTerritories[terPtr.pointers[currentTile.subtiles[0]]].id);
							zoneIndex.add(1);
					}
				}
			}
			//If 11 is jungle but 0 isn't, map zone 1 as that jungle
			else
			{
				//Ensures no tigers present on the jungle
				if (myTerritories[terPtr.pointers[currentTile.subtiles[11]]].player1Tigers == 0 && myTerritories[terPtr.pointers[currentTile.subtiles[11]]].player2Tigers == 0)
				{
					//Add the ID of the available tiger location if it is not already present and print its position
					if (availableTigerLoc.contains(myTerritories[terPtr.pointers[currentTile.subtiles[11]]].id) == false)
					{

							System.out.println("A Tiger may be placed on zone 1 which is type " + myTerritories[terPtr.pointers[currentTile.subtiles[11]]].territory);
							availableTigerLoc.add(myTerritories[terPtr.pointers[currentTile.subtiles[11]]].id);
							zoneIndex.add(1);
					}
				}
			}

			//Map for Zone 2//
			if (myTerritories[terPtr.pointers[currentTile.subtiles[1]]].player1Tigers == 0 && myTerritories[terPtr.pointers[currentTile.subtiles[1]]].player2Tigers == 0)
			{
				//Add the ID of the available tiger location if it is not already present and print its position
				if (availableTigerLoc.contains(myTerritories[terPtr.pointers[currentTile.subtiles[1]]].id) == false)
				{

						System.out.println("A Tiger may be placed on zone 2 which is type " + myTerritories[terPtr.pointers[currentTile.subtiles[1]]].territory);
						availableTigerLoc.add(myTerritories[terPtr.pointers[currentTile.subtiles[1]]].id);
						zoneIndex.add(2);
				}
			}
			
			//Map for Zone 3//
			//If 2 and 3 are lakes with same ID, map 2 to zone 3
			if (myTerritories[terPtr.pointers[currentTile.subtiles[2]]].territory == 'l' && myTerritories[terPtr.pointers[currentTile.subtiles[3]]].territory == 'l')
			{
				//Lakes have same ID, so map zone 3 as the lake
				if (myTerritories[terPtr.pointers[currentTile.subtiles[2]]].id == myTerritories[terPtr.pointers[currentTile.subtiles[3]]].id)
				{
					//Ensures no tigers present on the lake
					if (myTerritories[terPtr.pointers[currentTile.subtiles[2]]].player1Tigers == 0 && myTerritories[terPtr.pointers[currentTile.subtiles[2]]].player2Tigers == 0)
					{
						//Add the ID of the available tiger location if it is not already present and print its position
						if (availableTigerLoc.contains(myTerritories[terPtr.pointers[currentTile.subtiles[2]]].id) == false)
						{
								System.out.println("A Tiger may be placed on zone 3 which is type " + myTerritories[terPtr.pointers[currentTile.subtiles[2]]].territory);
								availableTigerLoc.add(myTerritories[terPtr.pointers[currentTile.subtiles[2]]].id);
								zoneIndex.add(3);
						}
					}
				}
				
			}
			//If 2 is jungle, map zone 3 as that jungle
			else if (myTerritories[terPtr.pointers[currentTile.subtiles[2]]].territory == 'j')
			{
				//Ensures no tigers present on the lake
				if (myTerritories[terPtr.pointers[currentTile.subtiles[2]]].player1Tigers == 0 && myTerritories[terPtr.pointers[currentTile.subtiles[2]]].player2Tigers == 0)
				{
					//Add the ID of the available tiger location if it is not already present and print its position
					if (availableTigerLoc.contains(myTerritories[terPtr.pointers[currentTile.subtiles[2]]].id) == false)
					{
							System.out.println("A Tiger may be placed on zone 3 which is type " + myTerritories[terPtr.pointers[currentTile.subtiles[2]]].territory);
							availableTigerLoc.add(myTerritories[terPtr.pointers[currentTile.subtiles[2]]].id);
							zoneIndex.add(3);
					}
				}	
			}
			//If 3 is jungle but 2 isn't, map zone 3 as that jungle
			else
			{
				//Ensures no tigers present on the jungle
				if (myTerritories[terPtr.pointers[currentTile.subtiles[3]]].player1Tigers == 0 && myTerritories[terPtr.pointers[currentTile.subtiles[3]]].player2Tigers == 0)
				{
					//Add the ID of the available tiger location if it is not already present and print its position
					if (availableTigerLoc.contains(myTerritories[terPtr.pointers[currentTile.subtiles[3]]].id) == false)
					{

							System.out.println("A Tiger may be placed on zone 3 which is type " + myTerritories[terPtr.pointers[currentTile.subtiles[3]]].territory);
							availableTigerLoc.add(myTerritories[terPtr.pointers[currentTile.subtiles[3]]].id);
							zoneIndex.add(3);
					}
				}
			}
			
			//Map for Zone 4//
			if (myTerritories[terPtr.pointers[currentTile.subtiles[10]]].player1Tigers == 0 && myTerritories[terPtr.pointers[currentTile.subtiles[10]]].player2Tigers == 0)
			{
				//Add the ID of the available tiger location if it is not already present and print its position
				if (availableTigerLoc.contains(myTerritories[terPtr.pointers[currentTile.subtiles[10]]].id) == false)
				{

						System.out.println("A Tiger may be placed on zone 4 which is type " + myTerritories[terPtr.pointers[currentTile.subtiles[10]]].territory);
						availableTigerLoc.add(myTerritories[terPtr.pointers[currentTile.subtiles[10]]].id);
						zoneIndex.add(4);
				}
			}
			
			//Map for Zone 5//
			//If a den is present, add it to available tiger locations
			if (myTerritories[terPtr.pointers[currentTile.subtiles[12]]].territory == 'd')
			{
				System.out.println("A Tiger may be placed on zone 5 which is type " + myTerritories[terPtr.pointers[currentTile.subtiles[12]]].territory);
				availableTigerLoc.add(myTerritories[terPtr.pointers[currentTile.subtiles[12]]].id);
				zoneIndex.add(5);
			}
			
			//Map for Zone 6//
			if (myTerritories[terPtr.pointers[currentTile.subtiles[4]]].player1Tigers == 0 && myTerritories[terPtr.pointers[currentTile.subtiles[4]]].player2Tigers == 0)
			{
				//Add the ID of the available tiger location if it is not already present and print its position
				if (availableTigerLoc.contains(myTerritories[terPtr.pointers[currentTile.subtiles[4]]].id) == false)
				{
						System.out.println("A Tiger may be placed on zone 6 which is type " + myTerritories[terPtr.pointers[currentTile.subtiles[4]]].territory);
						availableTigerLoc.add(myTerritories[terPtr.pointers[currentTile.subtiles[4]]].id);
						zoneIndex.add(6);
				}
			}
			
			//Map for Zone 7//
			//If 9 and 8 are lakes map 9 to zone 7
			if (myTerritories[terPtr.pointers[currentTile.subtiles[9]]].territory == 'l' && myTerritories[terPtr.pointers[currentTile.subtiles[8]]].territory == 'l')
			{
				//Lakes have same ID, so map zone 7 as the lake
				if (myTerritories[terPtr.pointers[currentTile.subtiles[9]]].id == myTerritories[terPtr.pointers[currentTile.subtiles[8]]].id)
				{
					//Ensures no tigers present on the lake
					if (myTerritories[terPtr.pointers[currentTile.subtiles[9]]].player1Tigers == 0 && myTerritories[terPtr.pointers[currentTile.subtiles[9]]].player2Tigers == 0)
					{
						//Add the ID of the available tiger location if it is not already present and print its position
						if (availableTigerLoc.contains(myTerritories[terPtr.pointers[currentTile.subtiles[9]]].id) == false)
						{

								System.out.println("A Tiger may be placed on zone 7 which is type " + myTerritories[terPtr.pointers[currentTile.subtiles[9]]].territory);
								availableTigerLoc.add(myTerritories[terPtr.pointers[currentTile.subtiles[9]]].id);
								zoneIndex.add(7);
						}
					}
				}

			}
			//If 9 is jungle, map zone 7 as that jungle
			else if (myTerritories[terPtr.pointers[currentTile.subtiles[9]]].territory == 'j')
			{
				//Ensures no tigers present on the lake
				if (myTerritories[terPtr.pointers[currentTile.subtiles[9]]].player1Tigers == 0 && myTerritories[terPtr.pointers[currentTile.subtiles[9]]].player2Tigers == 0)
				{
					//Add the ID of the available tiger location if it is not already present and print its position
					if (availableTigerLoc.contains(myTerritories[terPtr.pointers[currentTile.subtiles[9]]].id) == false)
					{
							System.out.println("A Tiger may be placed on zone 7 which is type " + myTerritories[terPtr.pointers[currentTile.subtiles[9]]].territory);
							availableTigerLoc.add(myTerritories[terPtr.pointers[currentTile.subtiles[9]]].id);
							zoneIndex.add(7);
					}
				}	
			}
			//If 8 is jungle but 9 isn't, map zone 7 as that jungle
			else
			{
				//Ensures no tigers present on the jungle
				if (myTerritories[terPtr.pointers[currentTile.subtiles[8]]].player1Tigers == 0 && myTerritories[terPtr.pointers[currentTile.subtiles[8]]].player2Tigers == 0)
				{
					//Add the ID of the available tiger location if it is not already present and print its position
					if (availableTigerLoc.contains(myTerritories[terPtr.pointers[currentTile.subtiles[8]]].id) == false)
					{

							System.out.println("A Tiger may be placed on zone 7 which is type " + myTerritories[terPtr.pointers[currentTile.subtiles[8]]].territory);
							availableTigerLoc.add(myTerritories[terPtr.pointers[currentTile.subtiles[8]]].id);
							zoneIndex.add(7);
					}
				}
			}
			
			//Map for Zone 8//
			if (myTerritories[terPtr.pointers[currentTile.subtiles[7]]].player1Tigers == 0 && myTerritories[terPtr.pointers[currentTile.subtiles[7]]].player2Tigers == 0)
			{
				//Add the ID of the available tiger location if it is not already present and print its position
				if (availableTigerLoc.contains(myTerritories[terPtr.pointers[currentTile.subtiles[7]]].id) == false)
				{

						System.out.println("A Tiger may be placed on zone 8 which is type " + myTerritories[terPtr.pointers[currentTile.subtiles[7]]].territory);
						availableTigerLoc.add(myTerritories[terPtr.pointers[currentTile.subtiles[7]]].id);
						zoneIndex.add(8);
				}
			}
			
			//Map for Zone 9//
			//If 5 and 6 are lakes. map 5 to zone 3
			if (myTerritories[terPtr.pointers[currentTile.subtiles[5]]].territory == 'l' && myTerritories[terPtr.pointers[currentTile.subtiles[6]]].territory == 'l')
			{
				//Lakes have same ID, so map zone 9 as the lake
				if (myTerritories[terPtr.pointers[currentTile.subtiles[5]]].id == myTerritories[terPtr.pointers[currentTile.subtiles[6]]].id)
				{
					//Ensures no tigers present on the lake
					if (myTerritories[terPtr.pointers[currentTile.subtiles[5]]].player1Tigers == 0 && myTerritories[terPtr.pointers[currentTile.subtiles[5]]].player2Tigers == 0)
					{
						//Add the ID of the available tiger location if it is not already present and print its position
						if (availableTigerLoc.contains(myTerritories[terPtr.pointers[currentTile.subtiles[5]]].id) == false)
						{

								System.out.println("A Tiger may be placed on zone 9 which is type " + myTerritories[terPtr.pointers[currentTile.subtiles[5]]].territory);
								availableTigerLoc.add(myTerritories[terPtr.pointers[currentTile.subtiles[5]]].id);
								zoneIndex.add(9);
						}
					}
				}
			}
			//If 5 is jungle, map zone 9 as that jungle
			else if (myTerritories[terPtr.pointers[currentTile.subtiles[5]]].territory == 'j')
			{
				//Ensures no tigers present on the lake
				if (myTerritories[terPtr.pointers[currentTile.subtiles[5]]].player1Tigers == 0 && myTerritories[terPtr.pointers[currentTile.subtiles[5]]].player2Tigers == 0)
				{
					//Add the ID of the available tiger location if it is not already present and print its position
					if (availableTigerLoc.contains(myTerritories[terPtr.pointers[currentTile.subtiles[5]]].id) == false)
					{
							System.out.println("A Tiger may be placed on zone 9 which is type " + myTerritories[terPtr.pointers[currentTile.subtiles[5]]].territory);
							availableTigerLoc.add(myTerritories[terPtr.pointers[currentTile.subtiles[5]]].id);
							zoneIndex.add(9);
					}
				}	
			}
			//If 6 is jungle but 5 isn't, map zone 9 as that jungle
			else
			{
				//Ensures no tigers present on the jungle
				if (myTerritories[terPtr.pointers[currentTile.subtiles[6]]].player1Tigers == 0 && myTerritories[terPtr.pointers[currentTile.subtiles[6]]].player2Tigers == 0)
				{
					//Add the ID of the available tiger location if it is not already present and print its position
					if (availableTigerLoc.contains(myTerritories[terPtr.pointers[currentTile.subtiles[6]]].id) == false)
					{
							System.out.println("A Tiger may be placed on zone 9 which is type " + myTerritories[terPtr.pointers[currentTile.subtiles[6]]].territory);
							availableTigerLoc.add(myTerritories[terPtr.pointers[currentTile.subtiles[6]]].id);
							zoneIndex.add(9);
					}
				}
			}

			zoneIndex.add(0);			
			//Collects index of tiger placement from player
			System.out.println("Please enter an available zone for tiger placement, or 0 for none");
			int tigerLoc = sc.nextInt();

			//Ensures valid index has been selected
			while (zoneIndex.contains(tigerLoc) == false)
			{
				System.out.println("Invalid Zone: Please enter an available zone for tiger placement, or 0 for none");
				tigerLoc = sc.nextInt();
			}
			
			//Do nothing if 13 is entered
			if (tigerLoc == 0)
			{
				System.out.println("No tiger has been placed");
			}
			else
			{
				System.out.println("A tiger has been placed on zone " + tigerLoc + " for player" + player.playerID);
					
				int placedLoc = availableTigerLoc.get(zoneIndex.indexOf(tigerLoc));
				//Add a tiger to tile as player1 if player1
				if (player.playerID == 1)
				{
					 myTerritories[placedLoc].player1Tigers++;
				}
				//Add a tiger to tile as player2 if player2
				else
				{
					 myTerritories[placedLoc].player2Tigers++;
				}
				//Subtract one tiger from player
				player.numTigers--;
				}
		}
	}
	
	
	/////////////////////////////// CROCODILE PLACEMENT \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	public boolean crocodilePlaceable(Tile currentTile, TerritoryPtr terPtr)
	{
		for (int i = 0; i < 12; i++)
		{
			if (myTerritories[terPtr.pointers[currentTile.subtiles[i]]].containedCrocodile.size() > 0)
			{
				return false;
			}
		}
		
		return true;
	}
	
	public void crocodilePlacement(Tile currentTile,TerritoryPtr terPtr, Player player, int x, int y)
	{
		for (int i = 0; i < 12; i++)
		{
			if (myTerritories[terPtr.pointers[currentTile.subtiles[i]]].territory == 't' || myTerritories[terPtr.pointers[currentTile.subtiles[i]]].territory == 'l')
			{
				myTerritories[terPtr.pointers[currentTile.subtiles[i]]].containedCrocodile.add(new ArrayCoord(x,y));
			}
		}
		player.numCrocodiles--;
	}
	
	
	////////////////////////////////////////// SCORING METHODS \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	public void midGameScoring(Tile currentTile,  TerritoryPtr terPtr, ArrayList<Integer> currentDens, Player player1, Player player2, int x, int y)
	{
		for (int i = 0; i < 12; i++)
		{
			//Scores trails if they are completed mid game
			if (myTerritories[terPtr.pointers[currentTile.subtiles[i]]].isScored == false && myTerritories[terPtr.pointers[currentTile.subtiles[i]]].territory == 't' 
					&& myTerritories[terPtr.pointers[currentTile.subtiles[i]]].openFaces == 0)
			{
				if ((myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player1Tigers > 0 || myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player2Tigers > 0))
				{
					int additionalPoints = myTerritories[terPtr.pointers[currentTile.subtiles[i]]].containedBoar.size() + myTerritories[terPtr.pointers[currentTile.subtiles[i]]].containedBuffalo.size() + myTerritories[terPtr.pointers[currentTile.subtiles[i]]].containedDeer.size();
					additionalPoints -= myTerritories[terPtr.pointers[currentTile.subtiles[i]]].containedCrocodile.size();
					if (additionalPoints < 0)					
					{
						additionalPoints = 0;
					}
					int trailScore = myTerritories[terPtr.pointers[currentTile.subtiles[i]]].containedTiles.size() + additionalPoints;
					
					//Player1 gets score if they have more tigers + return tigers
					if (myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player1Tigers > myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player2Tigers)
					{
						System.out.println("Player 1 has earned " + trailScore + " points for a completed game trail");
						player1.score += trailScore;
						System.out.println("Player 1 has received " + myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player1Tigers + " tiger(s) back from the completed game trail");
						System.out.println("Player 2 has received " + myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player2Tigers + " tiger(s) back from the completed game trail");
						player1.numTigers += myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player1Tigers;
						player2.numTigers += myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player2Tigers;
					}
					//Player2 gets score if they have more tigers + return tigers
					if (myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player1Tigers < myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player2Tigers)
					{
						System.out.println("Player 2 has earned " + trailScore + " points for a completed game trail");
						player2.score += trailScore;
						System.out.println("Player 1 has received " + myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player1Tigers + " tiger(s) back from the completed game trail");
						System.out.println("Player 2 has received " + myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player2Tigers + " tiger(s) back from the completed game trail");
						player1.numTigers += myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player1Tigers;
						player2.numTigers += myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player2Tigers;
					}
					//Player1 & Player2 get score if they have same amount of tigers + return tigers
					if (myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player1Tigers == myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player2Tigers)
					{
						System.out.println("Player 1 and Player 2 have both earned " + trailScore + " points for a completed game trail");
						player1.score += trailScore;
						player2.score += trailScore;
						System.out.println("Player 1 has received " + myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player1Tigers + " tiger(s) back from the completed game trail");
						System.out.println("Player 2 has received " + myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player2Tigers + " tiger(s) back from the completed game trail");
						player1.numTigers += myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player1Tigers;
						player2.numTigers += myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player2Tigers;
					}
				}
				//Marks Territory as scored and completed
				myTerritories[terPtr.pointers[currentTile.subtiles[i]]].isScored = true;
				myTerritories[terPtr.pointers[currentTile.subtiles[i]]].isCompleted = true;
			}
			
			//Scores lakes if they are completed mid game
			if (myTerritories[terPtr.pointers[currentTile.subtiles[i]]].isScored == false && myTerritories[terPtr.pointers[currentTile.subtiles[i]]].territory == 'l' 
					&& myTerritories[terPtr.pointers[currentTile.subtiles[i]]].openFaces == 0)
			{
				if (myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player1Tigers > 0 || myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player2Tigers > 0)
				{
					int multiplier = 1;
					if (myTerritories[terPtr.pointers[currentTile.subtiles[i]]].containedBoar.size() > 0)
					{
						multiplier++;
					}
					if (myTerritories[terPtr.pointers[currentTile.subtiles[i]]].containedBuffalo.size() > 0)
					{
						multiplier++;
					}
					if (myTerritories[terPtr.pointers[currentTile.subtiles[i]]].containedDeer.size() > 0)
					{
						multiplier++;
					}
					multiplier -= myTerritories[terPtr.pointers[currentTile.subtiles[i]]].containedCrocodile.size();
					if (multiplier < 1)
					{
						multiplier = 1;
					}
					
					int lakeScore = (2 * myTerritories[terPtr.pointers[currentTile.subtiles[i]]].containedTiles.size()) * multiplier;
					//Player1 gets score if they have more tigers + return tigers
					if (myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player1Tigers > myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player2Tigers)
					{
						System.out.println("Player 1 has earned " + lakeScore + " points for a completed lake");
						player1.score += lakeScore;
						System.out.println("Player 1 has received " + myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player1Tigers + " tiger(s) back from the completed lake");
						System.out.println("Player 2 has received " + myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player2Tigers + " tiger(s) back from the completed lake");
						player1.numTigers += myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player1Tigers;
						player2.numTigers += myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player2Tigers;
					}
					//Player2 gets score if they have more tigers + return tigers
					if (myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player1Tigers < myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player2Tigers)
					{
						System.out.println("Player 2 has earned " + lakeScore + " points for a completed lake");
						player2.score += lakeScore;
						System.out.println("Player 1 has received " + myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player1Tigers + " tiger(s) back from the completed lake");
						System.out.println("Player 2 has received " + myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player2Tigers + " tiger(s) back from the completed lake");
						player1.numTigers += myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player1Tigers;
						player2.numTigers += myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player2Tigers;
					}
					//Player1 & Player2 get score if they have same amount of tigers + return tigers
					if (myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player1Tigers == myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player2Tigers)
					{
						System.out.println("Player 1 and Player 2 have both earned " + lakeScore + " points for a completed lake");
						player1.score += lakeScore;
						player2.score += lakeScore;
						System.out.println("Player 1 has received " + myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player1Tigers + " tiger(s) back from the completed lake");
						System.out.println("Player 2 has received " + myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player2Tigers + " tiger(s) back from the completed lake");
						player1.numTigers += myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player1Tigers;
						player2.numTigers += myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player2Tigers;
					}
				}
				
				//Marks Territory as scored and completed
				myTerritories[terPtr.pointers[currentTile.subtiles[i]]].isScored = true;
				myTerritories[terPtr.pointers[currentTile.subtiles[i]]].isCompleted = true;
			}
			
		}
		
		//Check if newly placed tiles finish moore neighboorhood of previously placed dens
		for (int i = 0; i < currentDens.size(); i++)
		{
			checkMooreNeighborhood(myTerritories[terPtr.pointers[currentDens.get(i)]], player1, player2, x, y);
		}
	}
	
	public void endGameScoring( TerritoryPtr terPtr, Player player1, Player player2)
	{
		for (int i = 0; i < myTerritoriesSize; i++)
		{
			//Checks for existing trails that have a tiger placed and are not scored
			if (myTerritories[i].isScored == false && myTerritories[i].territory == 't' && myTerritories[i].isDeleted == false && (myTerritories[i].player1Tigers > 0 || myTerritories[i].player2Tigers > 0))
			{
				int additionalPoints = myTerritories[i].containedBoar.size() + myTerritories[i].containedBuffalo.size() + myTerritories[i].containedDeer.size();
				additionalPoints -= myTerritories[i].containedCrocodile.size();
				if (additionalPoints < 0)					
				{
					additionalPoints = 0;
				}
				int trailScore = myTerritories[i].containedTiles.size() + additionalPoints;
				
				//Player1 gets score if they have more tigers
				if (myTerritories[i].player1Tigers > myTerritories[i].player2Tigers)
				{
					System.out.println("Player 1 has earned " + trailScore + " points for an incomplete game trail");
					player1.score += trailScore;
				}
				//Player2 gets score if they have more tigers
				if (myTerritories[i].player1Tigers < myTerritories[i].player2Tigers)
				{
					System.out.println("Player 2 has earned " + trailScore + " points for an incomplete game trail");
					player2.score += trailScore;
				}
				//Player1 & Player2 get score if they have same amount of tigers
				if (myTerritories[i].player1Tigers == myTerritories[i].player2Tigers)
				{
					System.out.println("Player 1 and Player 2 have both earned " + trailScore + " points for an incomplete game trail");
					player1.score += trailScore;
					player2.score += trailScore;
				}
				//Marks Territory as scored
				myTerritories[i].isScored = true;
			}
			//Checks for existing lakes that have a tiger placed and are not scored
			if (myTerritories[i].isScored == false && myTerritories[i].territory == 'l' && myTerritories[i].isDeleted == false && (myTerritories[i].player1Tigers > 0 || myTerritories[i].player2Tigers > 0))
			{
				int multiplier = 1;
				
				if (myTerritories[i].containedBoar.size() > 0)
				{
					multiplier++;
				}
				if (myTerritories[i].containedBuffalo.size() > 0)
				{
					multiplier++;
				}
				if (myTerritories[i].containedDeer.size() > 0)
				{
					multiplier++;
				}
				multiplier -= myTerritories[i].containedCrocodile.size();
				
				if (multiplier < 1)
				{
					multiplier = 1;
				}
				
				int lakeScore = myTerritories[i].containedTiles.size() * multiplier;
				
				//Player1 gets score if they have more tigers
				if (myTerritories[i].player1Tigers > myTerritories[i].player2Tigers)
				{
					System.out.println("Player 1 has earned " + lakeScore + " points for an incomplete lake");
					player1.score += lakeScore;
				}
				//Player2 gets score if they have more tigers
				if (myTerritories[i].player1Tigers < myTerritories[i].player2Tigers)
				{
					System.out.println("Player 2 has earned " + lakeScore + " points for an incomplete lake");
					player2.score += lakeScore;
				}
				//Player1 & Player2 get score if they have same amount of tigers
				if (myTerritories[i].player1Tigers == myTerritories[i].player2Tigers)
				{
					System.out.println("Player 1 and Player 2 have both earned " + lakeScore + " points for an incomplete lake");
					player1.score += lakeScore;
					player2.score += lakeScore;
				}
				//Marks Territory as scored
				myTerritories[i].isScored = true;
			}
			
			//Checks for existing fields that have a tiger placed and are not scored
			if (myTerritories[i].isScored == false && myTerritories[i].territory == 'j' && myTerritories[i].isDeleted == false && (myTerritories[i].player1Tigers > 0 || myTerritories[i].player2Tigers > 0))
			{
				int numAdjacentLake = 0;
				int numAdjacentDen = 0;
				
				ArrayList<Integer> scoredBorderLakes = new ArrayList<Integer>();
				
				//Check borderingLakes if they are complete
				for(int j = 0; j < myTerritories[i].borderingLakes.size(); j++)
				{
					if (myTerritories[terPtr.pointers[myTerritories[i].borderingLakes.get(j)]].isCompleted == true && 
							scoredBorderLakes.contains(myTerritories[terPtr.pointers[myTerritories[i].borderingLakes.get(j)]].id) == false)
					{
						numAdjacentLake++;
						scoredBorderLakes.add(myTerritories[terPtr.pointers[myTerritories[i].borderingLakes.get(j)]].id);
					}
				}
				
				//Check borderingDens if they are complete
				for(int j = 0; j < myTerritories[i].borderingDens.size(); j++)
				{
					if (myTerritories[terPtr.pointers[myTerritories[i].borderingDens.get(j)]].isCompleted == true && 
							scoredBorderLakes.contains(myTerritories[terPtr.pointers[myTerritories[i].borderingDens.get(j)]].id) == false)
					{
						numAdjacentDen++;
						scoredBorderLakes.add(myTerritories[terPtr.pointers[myTerritories[i].borderingDens.get(j)]].id);
					}
				}
				
				//Jungle score is 3 points per adj Lake + 5 points per adj Den
				int jungleScore = (3 * numAdjacentLake) + (5 * numAdjacentDen);
				
				//Player1 gets score if they have more tigers
				if (myTerritories[i].player1Tigers > myTerritories[i].player2Tigers)
				{
					System.out.println("Player 1 has earned " + jungleScore + " points for a jungle");
					player1.score += jungleScore;
				}
				//Player2 gets score if they have more tigers
				if (myTerritories[i].player1Tigers < myTerritories[i].player2Tigers)
				{
					System.out.println("Player 2 has earned " + jungleScore + " points for a jungle");
					player2.score += jungleScore;
				}
				//Player1 & Player2 get score if they have same amount of tigers
				if (myTerritories[i].player1Tigers == myTerritories[i].player2Tigers)
				{
					System.out.println("Player 1 and Player 2 have both earned " + jungleScore + " points for a jungle");
					player1.score += jungleScore;
					player2.score += jungleScore;
				}
				//Marks Territory as scored
				myTerritories[i].isScored = true;
			}
			
			//Checks for incompleted dens that have a tiger on it
			if(myTerritories[i].isScored == false && myTerritories[i].territory == 'd' && myTerritories[i].isDeleted == false && (myTerritories[i].player1Tigers > 0 || myTerritories[i].player2Tigers > 0))
			{
				int denScore = 9 - myTerritories[i].containedTiles.size();
				//Player1 gets score if they have more tigers
				if (myTerritories[i].player1Tigers > myTerritories[i].player2Tigers)
				{
					System.out.println("Player 1 has earned " + denScore + " points for an incompleted den");
					player1.score += denScore;
				}
				//Player2 gets score if they have more tigers
				if (myTerritories[i].player1Tigers < myTerritories[i].player2Tigers)
				{
					System.out.println("Player 2 has earned " + denScore + " points for an incompleted den");
					player2.score += denScore;
				}
				myTerritories[i].isScored = true;
			}
			
		}
	}


}
