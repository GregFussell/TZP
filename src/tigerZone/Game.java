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
		
		//Creates Territories for Starter Tile
		Territory[] territories = new Territory[13];
		
		Territory ter = new Territory(0, ' ', 0, false);
		myTerritories[0] = ter;
		
		//Tile D : starter tile
		Territory ter1 = new Territory(1, 'l', 1, false); myTerritories[1] = ter1;//North lake
		Territory ter2 = new Territory(2, 'j', 2, false); myTerritories[2] = ter2;//North Jungle
		Territory ter3 = new Territory(3, 't', 2, false); myTerritories[3] = ter3;//Road
		Territory ter4 = new Territory(4, 'j', 3, false); myTerritories[0] = ter4;//South Jungle
		ter1.containedTiles.add(new ArrayCoord (36,36));
		ter2.containedTiles.add(new ArrayCoord (36,36));
		ter3.containedTiles.add(new ArrayCoord (36,36));
		ter4.containedTiles.add(new ArrayCoord (36,36));
		
		
		territories[0] = ter1;
		territories[1] = ter1;
		territories[2] = ter1;
		territories[3] = ter2;
		territories[4] = ter3;
		territories[5] = ter4;
		territories[6] = ter4;
		territories[7] = ter4;
		territories[8] = ter4;
		territories[9] = ter4;
		territories[10] = ter3;
		territories[11] = ter2;
		territories[12] = ter;
		//
		Tile starter = new Tile(territories, 1);
		
		
		//Tile U
		Territory ter5 = new Territory(5, 'j', 3, false); myTerritories[5] = ter5;//North jungle
		Territory ter6 = new Territory(6, 't', 2, false); myTerritories[6] = ter6;//Road
		Territory ter7 = new Territory(7, 'j', 3, false); myTerritories[7] = ter7;//South Jungle
		
		territories[0] = ter5;
		territories[1] = ter5;
		territories[2] = ter5;
		territories[3] = ter5;
		territories[4] = ter6;
		territories[5] = ter7;
		territories[6] = ter7;
		territories[7] = ter7;
		territories[8] = ter7;
		territories[9] = ter7;
		territories[10] = ter6;
		territories[11] = ter5;
		territories[12] = ter;
		
		Tile A = new Tile(territories, 2);
	
		//Tile V.1 
		Territory ter8 = new Territory(8, 'j', 3, false); myTerritories[8] = ter8;//North jungle
		Territory ter9 = new Territory(9, 't', 2, false); myTerritories[9] = ter9;//Road
		Territory ter10 = new Territory(10, 'j', 2, false); myTerritories[10] = ter10;//South Jungle
		
		territories[0] = ter8;
		territories[1] = ter8;
		territories[2] = ter8;
		territories[3] = ter8;
		territories[4] = ter8;
		territories[5] = ter8;
		territories[6] = ter8;
		territories[7] = ter9;
		territories[8] = ter10;
		territories[9] = ter10;
		territories[10] = ter9;
		territories[11] = ter8;
		territories[12] = ter;
		
		Tile B = new Tile(territories, 3);
		ter8.containedTiles.add(new ArrayCoord (36,36));
		ter9.containedTiles.add(new ArrayCoord (36,36));
		ter10.containedTiles.add(new ArrayCoord (36,36));

		
		//Tile V.2
		Territory ter11 = new Territory(11, 'j', 3, false); myTerritories[11] = ter11;//North jungle
		Territory ter12 = new Territory(12, 't', 2, false); myTerritories[12] = ter12;//Road
		Territory ter13 = new Territory(13, 'j', 2, false); myTerritories[13] = ter13;//South Jungle
		
		territories[0] = ter11;
		territories[1] = ter11;
		territories[2] = ter11;
		territories[3] = ter11;
		territories[4] = ter11;
		territories[5] = ter11;
		territories[6] = ter11;
		territories[7] = ter12;
		territories[8] = ter13;
		territories[9] = ter13;
		territories[10] = ter12;
		territories[11] = ter11;
		territories[12] = ter;
		
		Tile C = new Tile(territories, 4);
		
		//Tile V.3
		Territory ter14 = new Territory(14, 'j', 3, false); myTerritories[14] = ter14;
		Territory ter15 = new Territory(15, 't', 2, false); myTerritories[15] = ter15;
		Territory ter16 = new Territory(16, 'j', 2, false); myTerritories[16] = ter16;
		
		territories[0] = ter14;
		territories[1] = ter14;
		territories[2] = ter14;
		territories[3] = ter14;
		territories[4] = ter14;
		territories[5] = ter14;
		territories[6] = ter14;
		territories[7] = ter15;
		territories[8] = ter16;
		territories[9] = ter16;
		territories[10] = ter15;
		territories[11] = ter14;
		territories[12] = ter;
		
		Tile D = new Tile(territories, 5);
		
		//Tile V.4
		Territory ter17 = new Territory(17, 'j', 3, false); myTerritories[17] = ter17;
		Territory ter18 = new Territory(18, 't', 2, false); myTerritories[18] = ter18;
		Territory ter19 = new Territory(19, 'j', 2, false); myTerritories[19] = ter19;
		
		territories[0] = ter17;
		territories[1] = ter17;
		territories[2] = ter17;
		territories[3] = ter17;
		territories[4] = ter17;
		territories[5] = ter17;
		territories[6] = ter17;
		territories[7] = ter18;
		territories[8] = ter19;
		territories[9] = ter19;
		territories[10] = ter18;
		territories[11] = ter17;
		territories[12] = ter;
		
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
		
		AI Flynn = new AI(myDeck);
		int t[] = new int[3];
		//t = Flynn.decision(board, myDeck.deck.poll(), placeablePos);

		
//Loop of gameplay
		int turn = 0;
		
	//	printTile(starter);

		// Users plays game
		while (myDeck.deck.size() > 2) {
			int x = 0;
			int y = 0;

			System.out.println("The current board is: ");
			printBoard(board, placedPos);
			
			System.out.println("The current tile is: ");
			Tile myTile = myDeck.deck.remove();
			printTile(myTile);

			boolean valid = false;
			while (valid == false) {
				if(turn%2 == 0){
					t = Flynn.decision(board, myTile, placeablePos);
				}
				System.out.println("Please choose a rotation degree for the tile (0, 1, 2, 3)");
				
				int degree = 0;
				//int degree = sc.nextInt();
				if (turn%2 == 0){
					degree = t[0]; 
				}
				else{
					degree = sc.nextInt();
				}
				myTile.Rotate(degree);
				if (degree > 0) {
					System.out.println("The current tile is now: ");
					printTile(myTile);
				}

				printPlaceable(placeablePos);
				System.out.println("Please select an X and Y coordinate to place the tile");
				//x = sc.nextInt();
				if (turn%2 == 0){
					x = t[1]; System.out.println(t[0]); System.out.println(t[1]);
					y = t[2]; System.out.println(t[2]);
				}
				else{
					x = sc.nextInt();
					y = sc.nextInt();
				}
				//y = sc.nextInt();
				turn++;

				valid = validPlacement(myTile, board, placeablePos, x, y);
				if (valid == false) {
					System.out.println("Invalid placement, please place again");
				} else {
					System.out.println("Tile successfully placed");
				}
			}
			
			
		////////////////////////////////////////// Merge Territories Here \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
			int[] rewriteIDs = new int[12];
			int[] currentIDs = new int[12];
			Territory[] mergedTerritories = new Territory[12];
			
			//Merging with tile above it, if it exists
			if (board[x-1][y] != null)
			{
				//Merge 0 index if its a jungle
				if (myTile.subtiles[0].territory == 'j' && myTile.subtiles[0].id != board[x-1][y].subtiles[8].id)
				{
					mergedTerritories[0] = mergeTerritory(board[x-1][y].subtiles[8], myTile.subtiles[0], x, y);
					rewriteIDs[0] = board[x-1][y].subtiles[8].id;
					currentIDs[0] = myTile.subtiles[0].id;
					
					myTerritories[rewriteIDs[0]].isDeleted = true;
					myTerritories[currentIDs[0]] = mergedTerritories[0];
					mergeRewrite(board, currentIDs[0], rewriteIDs[0], mergedTerritories[0], x, y);
				}

			
				//Merge 1 index
				if (board[x-1][y].subtiles[7] != myTile.subtiles[1])
				{
					mergedTerritories[1] = mergeTerritory(board[x-1][y].subtiles[7], myTile.subtiles[1], x, y);
					rewriteIDs[1] = board[x-1][y].subtiles[7].id;
					currentIDs[1] = myTile.subtiles[1].id;
				
					myTerritories[rewriteIDs[1]].isDeleted = true;
					myTerritories[currentIDs[1]] = mergedTerritories[1];
					mergeRewrite(board, currentIDs[1], rewriteIDs[1], mergedTerritories[1], x, y);
				}
				
				
				//Merge 2 index if its a jungle
				if (myTile.subtiles[2].territory == 'j' && myTile.subtiles[2].id != board[x-1][y].subtiles[6].id)
				{
					mergedTerritories[2] = mergeTerritory(board[x-1][y].subtiles[6], myTile.subtiles[2], x, y);
					rewriteIDs[2] = board[x-1][y].subtiles[6].id;
					currentIDs[2] = myTile.subtiles[2].id;
					
					myTerritories[rewriteIDs[2]].isDeleted = true;
					myTerritories[currentIDs[2]] = mergedTerritories[2];
					mergeRewrite(board, currentIDs[2], rewriteIDs[2], mergedTerritories[2], x, y);
				}
			}
			
			//Merging with tile to right, if it exists
			if (board[x][y+1] != null)
			{
				//Merge 3 index if its a jungle
				if (myTile.subtiles[3].territory == 'j' && myTile.subtiles[3].id != board[x][y+1].subtiles[11].id)
				{
					mergedTerritories[3] = mergeTerritory(board[x][y+1].subtiles[11], myTile.subtiles[3], x, y);
					rewriteIDs[3] = board[x][y+1].subtiles[11].id;
					currentIDs[3] = myTile.subtiles[3].id;
					
					myTerritories[rewriteIDs[3]].isDeleted = true;
					myTerritories[currentIDs[3]] = mergedTerritories[3];
					mergeRewrite(board, currentIDs[3], rewriteIDs[3], mergedTerritories[3], x, y);
				}

			
				//Merge 4 index
				if (board[x][y+1].subtiles[10] != myTile.subtiles[4])
				{
					mergedTerritories[4] = mergeTerritory(board[x][y+1].subtiles[10], myTile.subtiles[4], x, y);
					rewriteIDs[4] = board[x][y+1].subtiles[10].id;
					currentIDs[4] = myTile.subtiles[4].id;
				
					myTerritories[rewriteIDs[4]].isDeleted = true;
					myTerritories[currentIDs[4]] = mergedTerritories[4];
					mergeRewrite(board, currentIDs[4], rewriteIDs[4], mergedTerritories[4], x, y);
				}
				else if (board[x][y+1].subtiles[10] == myTile.subtiles[4])
				{
					myTile.subtiles[4].openFaces -= 2;
				}
				
				
				//Merge 5 index if its a jungle
				if (myTile.subtiles[5].territory == 'j' && myTile.subtiles[5].id != board[x][y+1].subtiles[9].id)
				{
					mergedTerritories[5] = mergeTerritory(board[x][y+1].subtiles[9], myTile.subtiles[5], x, y);
					rewriteIDs[5] = board[x][y+1].subtiles[9].id;
					currentIDs[5] = myTile.subtiles[5].id;
					
					myTerritories[rewriteIDs[5]].isDeleted = true;
					myTerritories[currentIDs[5]] = mergedTerritories[5];
					mergeRewrite(board, currentIDs[5], rewriteIDs[5], mergedTerritories[5], x, y);
				}
			}
			
			//Merging with tile below it, if it exists
			if (board[x+1][y] != null)
			{
				//Merge 6 index if its a jungle
				if (myTile.subtiles[6].territory == 'j' && myTile.subtiles[6].id != board[x+1][y].subtiles[2].id)
				{
					mergedTerritories[6] = mergeTerritory(board[x+1][y].subtiles[2], myTile.subtiles[6], x, y);
					rewriteIDs[6] = board[x+1][y].subtiles[2].id;
					currentIDs[6] = myTile.subtiles[6].id;
					
					myTerritories[rewriteIDs[6]].isDeleted = true;
					myTerritories[currentIDs[6]] = mergedTerritories[6];
					mergeRewrite(board, currentIDs[6], rewriteIDs[6], mergedTerritories[6], x, y);
				}

			
				//Merge 7 index
				if (board[x+1][y].subtiles[1] != myTile.subtiles[7])
				{
					mergedTerritories[7] = mergeTerritory(board[x+1][y].subtiles[1], myTile.subtiles[7], x, y);
					rewriteIDs[7] = board[x+1][y].subtiles[1].id;
					currentIDs[7] = myTile.subtiles[7].id;
				
					myTerritories[rewriteIDs[7]].isDeleted = true;
					myTerritories[currentIDs[7]] = mergedTerritories[7];
					mergeRewrite(board, currentIDs[7], rewriteIDs[7], mergedTerritories[7], x, y);
				}
				else if (board[x+1][y].subtiles[1] == myTile.subtiles[7])
				{
					myTile.subtiles[7].openFaces -= 2;
				}
				
				
				//Merge 8 index if its a jungle
				if (myTile.subtiles[8].territory == 'j' && myTile.subtiles[8].id != board[x+1][y].subtiles[0].id)
				{
					mergedTerritories[8] = mergeTerritory(board[x+1][y].subtiles[0], myTile.subtiles[8], x, y);
					rewriteIDs[8] = board[x+1][y].subtiles[0].id;
					currentIDs[8] = myTile.subtiles[8].id;
					
					myTerritories[rewriteIDs[8]].isDeleted = true;
					myTerritories[currentIDs[8]] = mergedTerritories[8];
					mergeRewrite(board, currentIDs[8], rewriteIDs[8], mergedTerritories[8], x, y);
				}
			}
			
			//Merging with tile to left, if it exists
			if (board[x][y-1] != null)
			{
				//Merge 9 index if its a jungle
				if (myTile.subtiles[9].territory == 'j' && myTile.subtiles[9].id != board[x][y-1].subtiles[5].id)
				{
					mergedTerritories[9] = mergeTerritory(board[x][y-1].subtiles[5], myTile.subtiles[9], x, y);
					rewriteIDs[9] = board[x][y-1].subtiles[5].id;
					currentIDs[9] = myTile.subtiles[9].id;
					
					myTerritories[rewriteIDs[9]].isDeleted = true;
					myTerritories[currentIDs[9]] = mergedTerritories[9];
					mergeRewrite(board, currentIDs[9], rewriteIDs[9], mergedTerritories[9], x, y);
				}

			
				//Merge 10 index
				if (board[x][y-1].subtiles[4] != myTile.subtiles[10])
				{
					mergedTerritories[10] = mergeTerritory(board[x][y-1].subtiles[4], myTile.subtiles[10], x, y);
					rewriteIDs[10] = board[x][y-1].subtiles[4].id;
					currentIDs[10] = myTile.subtiles[10].id;
				
					myTerritories[rewriteIDs[10]].isDeleted = true;
					myTerritories[currentIDs[10]] = mergedTerritories[10];
					mergeRewrite(board, currentIDs[10], rewriteIDs[10], mergedTerritories[10], x, y);
				}
				else if (board[x][y-1].subtiles[4] == myTile.subtiles[10])
				{
					myTile.subtiles[10].openFaces -= 2;
				}
				
				
				//Merge 11 index if its a jungle
				if (myTile.subtiles[11].territory == 'j' && myTile.subtiles[11].id != board[x][y-1].subtiles[3].id)
				{
					mergedTerritories[11] = mergeTerritory(board[x][y-1].subtiles[3], myTile.subtiles[11], x, y);
					rewriteIDs[11] = board[x][y-1].subtiles[3].id;
					currentIDs[11] = myTile.subtiles[11].id;
					
					myTerritories[rewriteIDs[11]].isDeleted = true;
					myTerritories[currentIDs[11]] = mergedTerritories[11];
					mergeRewrite(board, currentIDs[11], rewriteIDs[11], mergedTerritories[11], x, y);
				}
			}
			////////////////////////////////// END OF MERGING \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
			
			//Place tile, update positions
			board[x][y] = myTile;
			updatePlaceable(placedPos, placeablePos, x, y);
		}

		
		System.out.println("\nThe final board is: ");
		printBoardID(board, placedPos);
		
		System.out.println("Open faces on road is : " + board[36][36].subtiles[10].openFaces);
		
		
		System.out.println("Current IDs are: ");
		System.out.println(board[36][36].subtiles[0].id);
		System.out.println(board[36][36].subtiles[1].id);
		System.out.println(board[36][36].subtiles[2].id);
		System.out.println(board[36][36].subtiles[3].id);
		System.out.println(board[36][36].subtiles[4].id);
		System.out.println(board[36][36].subtiles[5].id);
		System.out.println(board[36][36].subtiles[6].id);
		
		
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

	// Method for printing out all of the placeable positions in (X,Y)
	// coordinate form. Outputs to user for tile placement selection
	public static void printPlaceable(ArrayList<ArrayCoord> placeablePos) {
		int size = placeablePos.size();
		if (size < 1) {
			System.out.println("There are no placeable positions available");
		} else {

			System.out.print("The placeable positions are: ");
			for (int i = 0; i < size; i++) {
				System.out.print("(" + placeablePos.get(i).x + "," + placeablePos.get(i).y + ")  ");
			}
			System.out.println();
		}

	}

	// Method for printing out all of the placed positions in (X,Y) coordinate
	// form. Only used for testing
	public static void printPlaced(ArrayList<ArrayCoord> placedPos) {

		System.out.print("The placed positions are: ");
		for (int i = 0; i < placedPos.size(); i++) {
			System.out.print("(" + placedPos.get(i).x + "," + placedPos.get(i).y + ")  ");
		}
		System.out.println();
	}

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
	
	/////////////////////////////////////PRINTING METHODS/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//Method for printing out a single tile, used for displaying the current tile to user
	static void printTile(Tile tile) {
		// System.out.print(tile.id);
		
		System.out.println(" " + tile.subtiles[0].territory + tile.subtiles[1].territory + tile.subtiles[2].territory + " ");
		System.out.println(tile.subtiles[11].territory + "   " + tile.subtiles[3].territory);
		System.out.println(tile.subtiles[10].territory + " " + tile.subtiles[12].territory + " " + tile.subtiles[4].territory);
		System.out.println(tile.subtiles[9].territory + "   " + tile.subtiles[5].territory);
		System.out.println(" " + tile.subtiles[8].territory + tile.subtiles[7].territory + tile.subtiles[6].territory + " ");
		System.out.println();
	}
	
	static char[] printer(Tile tile)
	{
		char[] subtiles = new char[30];
		subtiles[0] = ' ';
		subtiles[4] =' ';
		subtiles[20] =' ';
		subtiles[24] = ' ';
		
		subtiles[6] = ' ';
		subtiles[7] = ' ';
		subtiles[8] = ' ';
		subtiles[11] = ' ';		
		subtiles[13] = ' ';
		subtiles[16] = ' ';
		subtiles[17] = ' ';
		subtiles[18] = ' ';
		subtiles[25] = '-';
		subtiles[26] = '-';		
		subtiles[27] = '-';
		subtiles[28] = '-';
		subtiles[29] = '-';
		
		subtiles[1] = tile.subtiles[0].territory;
		subtiles[2] = tile.subtiles[1].territory;
		subtiles[3] = tile.subtiles[2].territory;
		subtiles[5] = tile.subtiles[11].territory;
		subtiles[9] = tile.subtiles[3].territory;
		subtiles[10] = tile.subtiles[10].territory;
		subtiles[12] = tile.subtiles[12].territory;
		subtiles[14] = tile.subtiles[4].territory;
		subtiles[15] = tile.subtiles[9].territory;
		subtiles[19] = tile.subtiles[5].territory;
		subtiles[23] = tile.subtiles[6].territory;
		subtiles[22] = tile.subtiles[7].territory;
		subtiles[21] = tile.subtiles[8].territory;
		return subtiles;
	}
	//Method for printing out the entire board
	static void printBoard(Tile[][] board, ArrayList<ArrayCoord> placedPos) {
		int minx = 77;
		int miny = 77;
		int maxx = 0;
		int maxy = 0;
		for(int i =0; i <placedPos.size(); i++)
		{
			if(placedPos.get(i).x<minx)
				minx=placedPos.get(i).x;
			if(placedPos.get(i).y<miny)
				miny=placedPos.get(i).y;
			if(placedPos.get(i).x>maxx)
				maxx=placedPos.get(i).x;
			if(placedPos.get(i).y>maxy)
				maxy=placedPos.get(i).y;
		}
//		System.out.println("min x " + minx);
//		System.out.println("min y " + miny);
//		System.out.println("max x " + maxx);
//		System.out.println("max y " + maxy);
		int x = 0;
		for (int i = minx; i <= maxx; i++) {// i is row
			for (int h = 0; h < 6; h++) {
				for (int j = miny; j <= maxy; j++) {// j is column
					for (int k = x; k < x + 5; k++)// k is subtile, x is
													// iteration over tile
					{
						if (board[i][j] == null)
						{
							System.out.print(" ");
						}
						else
						{
							System.out.print(printer(board[i][j])[k]);
						}
						if (k == x + 4){
							System.out.print("|");
						}
					}
				}
				x = x + 5;
				System.out.println();
			}
			x = 0;
		}
	}
	
	//TESTING PURPOSES ONLY DELETE LATER
	
	static String[] printerID(Tile tile)
	{
		String[] subtiles = new String[30];
		subtiles[0] = Character.toString ((char) ' ');
		subtiles[4] = Character.toString ((char) ' ');
		subtiles[20] =Character.toString ((char) ' ');
		subtiles[24] =Character.toString ((char) ' ');
		
		subtiles[6] = Character.toString ((char) ' ');
		subtiles[7] = Character.toString ((char) ' ');
		subtiles[8] = Character.toString ((char) ' ');
		subtiles[11] = Character.toString ((char) ' ');		
		subtiles[13] = Character.toString ((char) ' ');
		subtiles[16] = Character.toString ((char) ' ');
		subtiles[17] = Character.toString ((char) ' ');
		subtiles[18] = Character.toString ((char) ' ');
		subtiles[25] = Character.toString ((char) '-');
		subtiles[26] = Character.toString ((char) '-');		
		subtiles[27] = Character.toString ((char) '-');
		subtiles[28] = Character.toString ((char) '-');
		subtiles[29] = Character.toString ((char) '-');
		
		subtiles[1] = Integer.toString(tile.subtiles[0].id);
		subtiles[2] = Integer.toString(tile.subtiles[1].id);
		subtiles[3] = Integer.toString(tile.subtiles[2].id);
		subtiles[5] = Integer.toString(tile.subtiles[11].id);
		subtiles[9] = Integer.toString(tile.subtiles[3].id);
		subtiles[10] = Integer.toString(tile.subtiles[10].id);
		subtiles[12] = Integer.toString(tile.subtiles[12].id);
		subtiles[14] = Integer.toString(tile.subtiles[4].id);
		subtiles[15] = Integer.toString(tile.subtiles[9].id);
		subtiles[19] = Integer.toString(tile.subtiles[5].id);
		subtiles[23] = Integer.toString(tile.subtiles[6].id);
		subtiles[22] = Integer.toString(tile.subtiles[7].id);
		subtiles[21] = Integer.toString(tile.subtiles[8].id);
		return subtiles;
	}
	
	//Method for printing out the entire board
	static void printBoardID(Tile[][] board, ArrayList<ArrayCoord> placedPos) {
		int minx = 77;
		int miny = 77;
		int maxx = 0;
		int maxy = 0;
		for(int i =0; i < placedPos.size(); i++)
		{
			if(placedPos.get(i).x<minx)
				minx=placedPos.get(i).x;
			if(placedPos.get(i).y<miny)
				miny=placedPos.get(i).y;
			if(placedPos.get(i).x>maxx)
				maxx=placedPos.get(i).x;
			if(placedPos.get(i).y>maxy)
				maxy=placedPos.get(i).y;
		}

		int x = 0;
		for (int i = minx; i <= maxx; i++) {// i is row
			for (int h = 0; h < 6; h++) {
				for (int j = miny; j <= maxy; j++) {// j is column
					for (int k = x; k < x + 5; k++)// k is subtile, x is
													// iteration over tile
					{
						if (board[i][j] == null)
						{
							System.out.print("  ");
						}
						else
						{
							System.out.printf("%2s", printerID(board[i][j])[k]);
						}
						if (k == x + 4){
							System.out.print("|");
						}
					}
				}
				x = x + 5;
				System.out.println();
			}
			x = 0;
		}
	}
	
	
	//END TESTING 

	public static void printArrayList(ArrayList<ArrayCoord> toPrint)
	{
		for(int i = 0; i < toPrint.size(); i++)
		{
			System.out.print("(" + toPrint.get(i).x + "," + toPrint.get(i).y + ") ");
		}
		System.out.println();
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
	
	
//OLD PRINT METHOD
//	static void printBoard(Tile[][] board) {
//		int x = 0;
//		for (int i = 0; i < 77; i++) {// i is row
//			for (int h = 0; h < 3; h++) {
//				for (int j = 0; j < 77; j++) {// j is column
//					for (int k = x; k < x + 3; k++)// k is subtile, x is
//													// iteration over tile
//					{
//						if (board[i][j] == null)
//							System.out.print(" ");
//						else
//							System.out.print(board[i][j].subtiles[k].territory);
//						if (k == x + 2)
//							System.out.print("|");
//					}
//				}
//				x = x + 3;
//				System.out.println();
//			}
//			x = 0;
//		}
//	}
}
