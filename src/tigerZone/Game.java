package tigerZone;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	
	ArrayList<ArrayCoord> placeablePos;
	ArrayList<ArrayCoord> placedPos;
	Tile[][] board;
	Territory[] myTerritories;
	
	
	
	public Game(){
		board = new Tile[77][77];
		placeablePos = new ArrayList<ArrayCoord>();
		placedPos = new ArrayList<ArrayCoord>();
		myTerritories = new Territory[246];

	}

	// METHODS
	// Method for evaluating whether continuity in territory types is preserved
	// in adjacent tiles. Returns True if valid
	public static boolean validPlacement(Tile currentTile, Tile[][] currentBoard, ArrayList<ArrayCoord> placeablePos,
			int x, int y) {

		boolean flag = false;
		for (int i = 0; i < placeablePos.size(); i++) {
			if (x == placeablePos.get(i).x && y == placeablePos.get(i).y) {
				flag = true;
			}
		}
		if (flag == false) {
			return false;
		}

		if (currentBoard[x - 1][y] != null) {
			if (currentTile.subtiles[1].territory != currentBoard[x - 1][y].subtiles[7].territory) {
				return false;
			}
		}
		if (currentBoard[x + 1][y] != null) {
			if (currentTile.subtiles[7].territory != currentBoard[x + 1][y].subtiles[1].territory) {
				return false;
			}
		}
		if (currentBoard[x][y + 1] != null) {
			if (currentTile.subtiles[4].territory != currentBoard[x][y + 1].subtiles[10].territory) {
				return false;
			}
		}
		if (currentBoard[x][y - 1] != null) {
			if (currentTile.subtiles[10].territory != currentBoard[x][y - 1].subtiles[4].territory) {
				return false;
			}
		}

		return true;
	}

	// Method that takes the user's chosen position out of the placeablePos
	// array and adds it to the placedPos array
	// Also adds the four adjacent sides to the newly placed tile into the
	// placeablePos array
	public static void updatePlaceable(ArrayList<ArrayCoord> placedPos, ArrayList<ArrayCoord> placeablePos, int x,
			int y) {

		for (int i = 0; i < placeablePos.size(); i++) {

			if (x == placeablePos.get(i).x && y == placeablePos.get(i).y) {
				placedPos.add(placeablePos.get(i));
				if (placeablePos.remove(placeablePos.get(i)) == true) {
					// System.out.println("Hello world");
				}
			} else {
				// System.out.println("Goodbye world");
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
	
	//Method to merge the contents of one territory with another.
	public static Territory mergeTerritory(Territory toMerge, Territory currentTerritory, int x, int y)
	{	
		currentTerritory.numShields += toMerge.numShields;
		currentTerritory.numTiles += toMerge.numTiles;
		currentTerritory.openFaces += toMerge.openFaces - 2;
		currentTerritory.player1Meeples += toMerge.player1Meeples;
		currentTerritory.player2Meeples += toMerge.player2Meeples;
		
		//Checks if the tile is already in the territory to prevent double scoring a tile.
		currentTerritory.containedTiles = toMerge.containedTiles;
		boolean duplicate = false;
		for (int i = 0; i < currentTerritory.containedTiles.size(); i++)
		{
			if (currentTerritory.containedTiles.get(i).x == x && currentTerritory.containedTiles.get(i).y == y)
			{
				duplicate = true;
			}
		}
		if (duplicate == false)
		{
			currentTerritory.containedTiles.add(new ArrayCoord(x,y));
		}
		
		toMerge.numTiles = 0;
				
		return currentTerritory;
	}
	
	//Recursive call to rewrite previous territories into the newly placed territory
	public static void mergeRewrite(Tile[][] board, int myID, int rewriteID, Territory merged, int x, int y)
	{
		//Check up tile
		if (board[x-1][y] != null)
		{
			boolean up = false;
			for (int i=0; i < 12; i++)
			{
				if (board[x-1][y].subtiles[i].id == rewriteID)
				{
					board[x-1][y].subtiles[i] = merged;
					up = true;
				}
			}
			if (up == true)
			{
				mergeRewrite(board, myID, rewriteID, merged, x-1, y);
			}
		}
		//Check right tile
		if (board[x][y+1] != null)
		{
			boolean right = false;
			for (int i=0; i < 12; i++)
			{
				if (board[x][y+1].subtiles[i].id == rewriteID)
				{
					board[x][y+1].subtiles[i] = merged;
					right = true;
				}
			}
			if (right == true)
			{
				mergeRewrite(board, myID, rewriteID, merged, x, y+1);
			}
		}
		//Check down tile	
		if (board[x+1][y] != null)
		{
			boolean down = false;
			for (int i=0; i < 12; i++)
			{
				if (board[x+1][y].subtiles[i].id == rewriteID)
				{
					board[x+1][y].subtiles[i] = merged;
					down = true;
				}
			}
			if (down == true)
			{
				mergeRewrite(board, myID, rewriteID, merged, x+1, y);
			}
		}
		//Check left tile
		if (board[x][y-1] != null)
		{
			boolean left = false;
			for (int i=0; i < 12; i++)
			{
				if (board[x][y-1].subtiles[i].id == rewriteID)
				{
					board[x][y-1].subtiles[i] = merged;
					left = true;
				}
			}
			if (left == true)
			{
				mergeRewrite(board, myID, rewriteID, merged, x, y-1);
			}
		}


	
	}
}
	
	


