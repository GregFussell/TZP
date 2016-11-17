package tigerZone;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Tile starter = new Tile('j','l','j',
		// 't','t','t',
		// 'j','j','j',
		// 1);

		// Initializes the array lists that contain placed positions and
		// placeable positions
		Scanner sc = new Scanner(System.in);

		ArrayList<ArrayCoord> placeablePos = new ArrayList<ArrayCoord>();
		ArrayList<ArrayCoord> placedPos = new ArrayList<ArrayCoord>();
		
		Territory[] myTerritories = new Territory[246];
		TerritoryPtr terPtr = new TerritoryPtr();
		
		//Creates Territories for Starter Tile
		int[] territories = new int[13];
		
		Territory ter = new Territory(0, ' ', 0, false, false, false);
		myTerritories[0] = ter;
		
		//Tile D : starter tile
		Territory ter1 = new Territory(1, 'l', 1, false, false, false); myTerritories[1] = ter1;//North lake
		Territory ter2 = new Territory(2, 'j', 2, false, false, false); myTerritories[2] = ter2;//North Jungle
		Territory ter3 = new Territory(3, 't', 2, false, false, false); myTerritories[3] = ter3;//Road
		Territory ter4 = new Territory(4, 'j', 3, false, false, false); myTerritories[4] = ter4;//South Jungle
		ter1.containedTiles.add(new ArrayCoord (36,36));
		ter2.containedTiles.add(new ArrayCoord (36,36));
		ter3.containedTiles.add(new ArrayCoord (36,36));
		ter4.containedTiles.add(new ArrayCoord (36,36));
		/*
		 *  lll
		 * j   j
		 * t   t
		 *  jjj
		 */
		
		territories[0] = 1;
		territories[1] = 1;
		territories[2] = 1;
		territories[3] = 2;
		territories[4] = 3;
		territories[5] = 4;
		territories[6] = 4;
		territories[7] = 4;
		territories[8] = 4;
		territories[9] = 4;
		territories[10] = 3;
		territories[11] = 2;
		territories[12] = 0;
		//
		Tile starter = new Tile(territories, 1);
		
		
		//Tile U
		Territory ter5 = new Territory(5, 'j', 3, false, false, false); myTerritories[5] = ter5;//North jungle
		Territory ter6 = new Territory(6, 't', 2, false, false, false); myTerritories[6] = ter6;//Road
		Territory ter7 = new Territory(7, 'j', 3, false, false, false); myTerritories[7] = ter7;//South Jungle
		
		territories[0] = 5;
		territories[1] = 5;
		territories[2] = 5;
		territories[3] = 5;
		territories[4] = 6;
		territories[5] = 7;
		territories[6] = 7;
		territories[7] = 7;
		territories[8] = 7;
		territories[9] = 7;
		territories[10] = 6;
		territories[11] = 5;
		territories[12] = 0;
		
		Tile A = new Tile(territories, 2);
	
		//Tile V.1 
		Territory ter8 = new Territory(8, 'j', 3, false, false, false); myTerritories[8] = ter8;//North jungle
		Territory ter9 = new Territory(9, 't', 2, false, false, false); myTerritories[9] = ter9;//Road
		Territory ter10 = new Territory(10, 'j', 2, false, false, false); myTerritories[10] = ter10;//South Jungle
		
		territories[0] = 8;
		territories[1] = 8;
		territories[2] = 8;
		territories[3] = 8;
		territories[4] = 8;
		territories[5] = 8;
		territories[6] = 8;
		territories[7] = 9;
		territories[8] = 10;
		territories[9] = 10;
		territories[10] = 9;
		territories[11] = 8;
		territories[12] = 0;
		
		Tile B = new Tile(territories, 3);
		ter8.containedTiles.add(new ArrayCoord (36,36));
		ter9.containedTiles.add(new ArrayCoord (36,36));
		ter10.containedTiles.add(new ArrayCoord (36,36));

		
		//Tile V.2
		Territory ter11 = new Territory(11, 'j', 3, false, false, false); myTerritories[11] = ter11;//North jungle
		Territory ter12 = new Territory(12, 't', 2, false, false, false); myTerritories[12] = ter12;//Road
		Territory ter13 = new Territory(13, 'j', 2, false, false, false); myTerritories[13] = ter13;//South Jungle
		
		territories[0] = 11;
		territories[1] = 11;
		territories[2] = 11;
		territories[3] = 11;
		territories[4] = 11;
		territories[5] = 11;
		territories[6] = 11;
		territories[7] = 12;
		territories[8] = 13;
		territories[9] = 13;
		territories[10] = 12;
		territories[11] = 11;
		territories[12] = 0;
		
		Tile C = new Tile(territories, 4);
		
		//Tile V.3
		Territory ter14 = new Territory(14, 'j', 3, false, false, false); myTerritories[14] = ter14;
		Territory ter15 = new Territory(15, 't', 2, false, false, false); myTerritories[15] = ter15;
		Territory ter16 = new Territory(16, 'j', 2, false, false, false); myTerritories[16] = ter16;
		
		territories[0] = 14;
		territories[1] = 14;
		territories[2] = 14;
		territories[3] = 14;
		territories[4] = 14;
		territories[5] = 14;
		territories[6] = 14;
		territories[7] = 15;
		territories[8] = 16;
		territories[9] = 16;
		territories[10] = 15;
		territories[11] = 14;
		territories[12] = 0;
		
		Tile D = new Tile(territories, 5);
		
		//Tile V.4
		Territory ter17 = new Territory(17, 'j', 3, false, false, false); myTerritories[17] = ter17;
		Territory ter18 = new Territory(18, 't', 2, false, false, false); myTerritories[18] = ter18;
		Territory ter19 = new Territory(19, 'j', 2, false, false, false); myTerritories[19] = ter19;
		
		territories[0] = 17;
		territories[1] = 17;
		territories[2] = 17;
		territories[3] = 17;
		territories[4] = 17;
		territories[5] = 17;
		territories[6] = 17;
		territories[7] = 18;
		territories[8] = 19;
		territories[9] = 19;
		territories[10] = 18;
		territories[11] = 17;
		territories[12] = 0;
		
		Tile E = new Tile(territories, 6);
		
		// Creates Starter Tile
		//Tile starter = new Tile("llljtjjjjjtjR", 1);
		//Tile starter = new Tile(territories, 1);

		// Initializes the deck with tiles
//		Tile A = new Tile("jtjjjjjtjjjjR", 2);
//		Tile B = new Tile("jjjjjjjtjjtjR", 3);
//		Tile C = new Tile("jtjjtjjtjjtjR", 4);
//		Tile D = new Tile("lllllljtjlllR", 5);
//		Tile E = new Tile("llljjjjjjjjjR", 6);
		Deck myDeck = new Deck(C, D, E, A, A);
		// Initializes the board
		Tile[][] board = new Tile[77][77];
		// Starter location is added as a placeablePos, starter tile is then
		// automatically placed and the placed/placeable array lists are updated
		placeablePos.add(new ArrayCoord(36, 36));
		board[36][36] = B;
		updatePlaceable(placedPos, placeablePos, 36, 36);
		
		
		
	//TESTING POINTER
		
		//System.out.println(myTerritories[board[36][36].subtiles[7]].id);
		
	//	System.out.println(terPtr.pointers[2]);
//		E.Rotate(3);
//		
//
//		
//		System.out.println(myTerritories[terPtr.pointers[B.subtiles[7]]].id);
//		
//		int currentID = terPtr.pointers[E.subtiles[4]];
//		int rewriteID = terPtr.pointers[B.subtiles[7]];
//
//		
//		mergeTerritory(myTerritories[rewriteID], myTerritories[currentID], 36, 35);
//		terPtr.rewritePtr(currentID, rewriteID);
//		
//
//		
//		
//		System.out.println(myTerritories[terPtr.pointers[B.subtiles[7]]].id);
//		Printer.printArrayList(myTerritories[terPtr.pointers[B.subtiles[7]]].containedTiles);


Player player1 = new Player();
Player player2 = new Player();
		

///////////////////////////////////////////////////// GAMEPLAY LOOP \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		
	//	printTile(starter);

		// Users plays game
		while (myDeck.deck.size() > 2) {
			int x = 0;
			int y = 0;

			System.out.println("The current board is: ");
			Printer.printBoard(board, placedPos, myTerritories, terPtr);
			
			System.out.println("The current tile is: ");
			Tile myTile = myDeck.deck.remove();
			Printer.printTile(myTile, myTerritories, terPtr);

			boolean valid = false;
			while (valid == false) {

				System.out.println("Please choose a rotation degree for the tile (0, 1, 2, 3)");
				int degree = sc.nextInt();
				myTile.Rotate(degree);
				if (degree > 0) {
					System.out.println("The current tile is now: ");
					Printer.printTile(myTile, myTerritories, terPtr);
				}

				Printer.printPlaceable(placeablePos);
				System.out.println("Please select an X and Y coordinate to place the tile");
				x = sc.nextInt();
				y = sc.nextInt();

				valid = validPlacement(myTile, board, placeablePos, x, y, myTerritories, terPtr);
				if (valid == false) {
					System.out.println("Invalid placement, please place again");
				} else {
					System.out.println("Tile successfully placed");
				}
			}
			
			
		////////////////////////////////////////// Merge Territories Here \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
			int[] rewriteIDs = new int[12];
			int[] currentIDs = new int[12];
		//	Territory[] mergedTerritories = new Territory[12];
			
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
					mergeTerritory(myTerritories[terPtr.pointers[board[x-1][y].subtiles[7]]], myTerritories[terPtr.pointers[myTile.subtiles[1]]], x, y);
					rewriteIDs[1] = myTerritories[terPtr.pointers[board[x-1][y].subtiles[7]]].id;
					currentIDs[1] = myTerritories[terPtr.pointers[myTile.subtiles[1]]].id;
				
					myTerritories[terPtr.pointers[rewriteIDs[1]]].isDeleted = true;
					terPtr.rewritePtr(currentIDs[1], rewriteIDs[1]);	
				}
				
				
				//Merge 2 index if its a jungle
				if (myTerritories[terPtr.pointers[myTile.subtiles[2]]].territory == 'j' && myTerritories[terPtr.pointers[myTile.subtiles[2]]].id != myTerritories[terPtr.pointers[board[x-1][y].subtiles[6]]].id)
				{
					mergeTerritory(myTerritories[terPtr.pointers[board[x-1][y].subtiles[6]]], myTerritories[terPtr.pointers[myTile.subtiles[2]]], x, y);
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
					mergeTerritory(myTerritories[terPtr.pointers[board[x][y+1].subtiles[11]]], myTerritories[terPtr.pointers[myTile.subtiles[3]]], x, y);
					rewriteIDs[3] = myTerritories[terPtr.pointers[board[x][y+1].subtiles[11]]].id;
					currentIDs[3] = myTerritories[terPtr.pointers[myTile.subtiles[3]]].id;
					
					myTerritories[terPtr.pointers[rewriteIDs[3]]].isDeleted = true;
					terPtr.rewritePtr(currentIDs[3], rewriteIDs[3]);
				}

			
				//Merge 4 index
				if (myTerritories[terPtr.pointers[board[x][y+1].subtiles[10]]] != myTerritories[terPtr.pointers[myTile.subtiles[4]]])
				{
					mergeTerritory(myTerritories[terPtr.pointers[board[x][y+1].subtiles[10]]], myTerritories[terPtr.pointers[myTile.subtiles[4]]], x, y);
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
					mergeTerritory(myTerritories[terPtr.pointers[board[x][y+1].subtiles[9]]], myTerritories[terPtr.pointers[myTile.subtiles[5]]], x, y);
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
					mergeTerritory(myTerritories[terPtr.pointers[board[x+1][y].subtiles[2]]], myTerritories[terPtr.pointers[myTile.subtiles[6]]], x, y);
					rewriteIDs[6] = myTerritories[terPtr.pointers[board[x+1][y].subtiles[2]]].id;
					currentIDs[6] = myTerritories[terPtr.pointers[myTile.subtiles[6]]].id;
					
					myTerritories[terPtr.pointers[rewriteIDs[6]]].isDeleted = true;
					terPtr.rewritePtr(currentIDs[6], rewriteIDs[6]);
				}

			
				//Merge 7 index
				if (myTerritories[terPtr.pointers[board[x+1][y].subtiles[1]]] != myTerritories[terPtr.pointers[myTile.subtiles[7]]])
				{
					mergeTerritory(myTerritories[terPtr.pointers[board[x+1][y].subtiles[1]]], myTerritories[terPtr.pointers[myTile.subtiles[7]]], x, y);
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
					mergeTerritory(myTerritories[terPtr.pointers[board[x+1][y].subtiles[0]]], myTerritories[terPtr.pointers[myTile.subtiles[8]]], x, y);
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
					mergeTerritory(myTerritories[terPtr.pointers[board[x][y-1].subtiles[5]]], myTerritories[terPtr.pointers[myTile.subtiles[9]]], x, y);
					rewriteIDs[9] = myTerritories[terPtr.pointers[board[x][y-1].subtiles[5]]].id;
					currentIDs[9] = myTerritories[terPtr.pointers[myTile.subtiles[9]]].id;
					
					myTerritories[terPtr.pointers[rewriteIDs[9]]].isDeleted = true;
					terPtr.rewritePtr(currentIDs[9], rewriteIDs[9]);
				}

			
				//Merge 10 index
				if (myTerritories[terPtr.pointers[board[x][y-1].subtiles[4]]] != myTerritories[terPtr.pointers[myTile.subtiles[10]]])
				{
					mergeTerritory(myTerritories[terPtr.pointers[board[x][y-1].subtiles[4]]], myTerritories[terPtr.pointers[myTile.subtiles[10]]], x, y);
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
					mergeTerritory(myTerritories[terPtr.pointers[board[x][y-1].subtiles[3]]], myTerritories[terPtr.pointers[myTile.subtiles[11]]], x, y);
					rewriteIDs[11] = myTerritories[terPtr.pointers[board[x][y-1].subtiles[3]]].id;
					currentIDs[11] = myTerritories[terPtr.pointers[myTile.subtiles[11]]].id;
					
					myTerritories[terPtr.pointers[rewriteIDs[11]]].isDeleted = true;
					terPtr.rewritePtr(currentIDs[11], rewriteIDs[11]);
				}
			}
			////////////////////////////////// END OF MERGING \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
			
			//Place tile, update positions
			board[x][y] = myTile;
			updatePlaceable(placedPos, placeablePos, x, y);
		}

		
		System.out.println("\nThe final board is: ");
		Printer.printBoardID(board, placedPos, myTerritories, terPtr);
		
		System.out.println("Open faces on road: ");
		System.out.println(myTerritories[18].openFaces);
		
		

		
		// printPlaceable(placeablePos);
		// printPlaceable(placeablePos);
		// printPlaced(placedPos);

		// TESTING

		// System.out.println(placedPos.get(0).x);
		//
		// System.out.print(board[36][36].id);
		// System.out.println();
		// for (int i = 0; i < 9; i++) {
		// System.out.print(board[36][36].subtiles[i].territory + " ");
		// if ((i + 1) % 3 == 0) {
		// System.out.println();
		// }
		// }
		//
		// System.out.println();
		// board[36][36].Rotate();
		//
		// System.out.print(board[36][36].id);
		// System.out.println();
		// for (int i = 0; i < 9; i++) {
		// System.out.print(board[36][36].subtiles[i].territory + " ");
		// if ((i + 1) % 3 == 0) {
		// System.out.println();
		// }
		// }
		//
		// printPlaceable(placeablePos);
		// printPlaced(placedPos);

		
	//	printBoard(board, placedPos);
	}

	// METHODS


	// Method for evaluating whether continuity in territory types is preserved
	// in adjacent tiles. Returns True if valid
	public static boolean validPlacement(Tile currentTile, Tile[][] currentBoard, ArrayList<ArrayCoord> placeablePos,
			int x, int y, Territory[] myTerritories, TerritoryPtr terPtr) {

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
			if (myTerritories[terPtr.pointers[currentTile.subtiles[1]]].territory != myTerritories[terPtr.pointers[currentBoard[x - 1][y].subtiles[7]]].territory) {
				return false;
			}
		}
		if (currentBoard[x + 1][y] != null) {
			if (myTerritories[terPtr.pointers[currentTile.subtiles[7]]].territory != myTerritories[terPtr.pointers[currentBoard[x + 1][y].subtiles[1]]].territory) {
				return false;
			}
		}
		if (currentBoard[x][y + 1] != null) {
			if (myTerritories[terPtr.pointers[currentTile.subtiles[4]]].territory != myTerritories[terPtr.pointers[currentBoard[x][y + 1].subtiles[10]]].territory) {
				return false;
			}
		}
		if (currentBoard[x][y - 1] != null) {
			if (myTerritories[terPtr.pointers[currentTile.subtiles[10]]].territory != myTerritories[terPtr.pointers[currentBoard[x][y - 1].subtiles[4]]].territory) {
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
	
	/////////////////////////////////////PRINTING METHODS/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//Method for printing out a single tile, used for displaying the current tile to user

	
	
	
	//Method to merge the contents of one territory with another.
	public static void mergeTerritory(Territory toMerge, Territory currentTerritory, int x, int y)
	{	
		currentTerritory.numDeer += toMerge.numDeer;
		currentTerritory.numBoar += toMerge.numBoar;
		currentTerritory.numBuffalo += toMerge.numBuffalo;
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
				
		//return currentTerritory;
	}

/*
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
*/
	
	
	
	////////////////////////////////////////// SCORING METHODS \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	public void endGameScoring()
	{
		
	}
	
	

}
