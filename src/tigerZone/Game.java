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
		
		//Defines the preyAnimal types for tiles
		boolean[] noPreyAnim = new boolean[3];
		noPreyAnim[0] = false; noPreyAnim[1] = false; noPreyAnim[2] = false;
		boolean[] deer = new boolean[3];
		deer[0] = true; deer[1] = false; deer[2] = false;
		boolean[] boar = new boolean[3];
		boar[0] = false; boar[1] = true; boar[2] = false;
		boolean[] buffalo = new boolean[3];
		buffalo[0] = false; buffalo[1] = false; buffalo[2] = true;
		
		//Defines an empty ArrayList for non jungle tiles
		ArrayList<Integer> noBorderLakes = new ArrayList<Integer>();
		ArrayList<Integer> noBorderDens = new ArrayList<Integer>();
		
		//Creates Territories for Starter Tile
		int[] territories = new int[13];
		
		Territory ter = new Territory(0, ' ', 0, noPreyAnim, noBorderLakes, noBorderDens);
		myTerritories[0] = ter;
		
		//Tile D : starter tile
		ArrayList<Integer> borderLake = new ArrayList<Integer>();
		borderLake.add(1);
		
		Territory ter1 = new Territory(1, 'l', 1, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[1] = ter1;//North lake
		Territory ter2 = new Territory(2, 'j', 2, noPreyAnim, borderLake, noBorderDens); myTerritories[2] = ter2;//North Jungle
		Territory ter3 = new Territory(3, 't', 2, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[3] = ter3;//Road
		Territory ter4 = new Territory(4, 'j', 3, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[4] = ter4;//South Jungle
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
		Territory ter5 = new Territory(5, 'j', 3, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[5] = ter5;//North jungle
		Territory ter6 = new Territory(6, 't', 2, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[6] = ter6;//Road
		Territory ter7 = new Territory(7, 'j', 3, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[7] = ter7;//South Jungle
		
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
		Territory ter8 = new Territory(8, 'j', 3, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[8] = ter8;//North jungle
		Territory ter9 = new Territory(9, 't', 2, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[9] = ter9;//Road
		Territory ter10 = new Territory(10, 'j', 2, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[10] = ter10;//South Jungle
		
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
		Territory ter11 = new Territory(11, 'j', 3, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[11] = ter11;//North jungle
		Territory ter12 = new Territory(12, 't', 2, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[12] = ter12;//Road
		Territory ter13 = new Territory(13, 'j', 2, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[13] = ter13;//South Jungle
		
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
		Territory ter14 = new Territory(14, 'j', 3, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[14] = ter14;
		Territory ter15 = new Territory(15, 't', 2, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[15] = ter15;
		Territory ter16 = new Territory(16, 'j', 2, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[16] = ter16;
		
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
		Territory ter17 = new Territory(17, 'j', 3, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[17] = ter17;
		Territory ter18 = new Territory(18, 't', 2, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[18] = ter18;
		Territory ter19 = new Territory(19, 'j', 2, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[19] = ter19;
		
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
		
		
		//New tile type D
		ArrayList<Integer> borderLake21 = new ArrayList<Integer>();
		borderLake21.add(20);
		
		Territory ter20 = new Territory(20, 'l', 1, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[20] = ter20;//North lake
		Territory ter21 = new Territory(21, 'j', 2, noPreyAnim, borderLake21, noBorderDens); myTerritories[21] = ter21;//North Jungle
		Territory ter22 = new Territory(22, 't', 2, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[22] = ter22;//Road
		Territory ter23 = new Territory(23, 'j', 3, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[23] = ter23;//South Jungle

		/*
		 *  lll
		 * j   j
		 * t   t
		 * j   j
		 *  jjj
		 */
		
		territories[0] = 20;
		territories[1] = 20;
		territories[2] = 20;
		territories[3] = 21;
		territories[4] = 22;
		territories[5] = 23;
		territories[6] = 23;
		territories[7] = 23;
		territories[8] = 23;
		territories[9] = 23;
		territories[10] = 22;
		territories[11] = 21;
		territories[12] = 0;
		//
		Tile F = new Tile(territories, 7);
		
		// Creates Starter Tile
		//Tile starter = new Tile("llljtjjjjjtjR", 1);
		//Tile starter = new Tile(territories, 1);

		// Initializes the deck with tiles
//		Tile A = new Tile("jtjjjjjtjjjjR", 2);
//		Tile B = new Tile("jjjjjjjtjjtjR", 3);
//		Tile C = new Tile("jtjjtjjtjjtjR", 4);
//		Tile D = new Tile("lllllljtjlllR", 5);
//		Tile E = new Tile("llljjjjjjjjjR", 6);
		Deck myDeck = new Deck(F, D, E, A, A);
		// Initializes the board
		Tile[][] board = new Tile[77][77];
		// Starter location is added as a placeablePos, starter tile is then
		// automatically placed and the placed/placeable array lists are updated
		placeablePos.add(new ArrayCoord(36, 36));
		board[36][36] = starter;
		updatePlaceable(placedPos, placeablePos, 36, 36);
		
		//Closed road test: Start = B; decklist = C D E A A
		//Current Test: start = starter

		//ter21.borderingLakes.add(0);
		System.out.println("Bordering Lakes size is " + ter23.borderingLakes.size());
		
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



Player player1 = new Player(1);
Player player2 = new Player(2);

//ter15.player1Tigers = 2;
//ter15.player2Tigers = 1;

///////////////////////////////////////////////////// GAMEPLAY LOOP \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		
	//	printTile(starter);
		int turn = 1;
		// Users plays game
		while (myDeck.deck.size() > 2) {
			int x = 0;
			int y = 0;

			System.out.println("The current board is: ");
			Printer.printBoardID(board, placedPos, myTerritories, terPtr);
			
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
					mergeTerritory(myTerritories, myTerritories[terPtr.pointers[board[x-1][y].subtiles[8]]], myTerritories[terPtr.pointers[myTile.subtiles[0]]], x, y);
					rewriteIDs[0] = myTerritories[terPtr.pointers[board[x-1][y].subtiles[8]]].id;
					currentIDs[0] = myTerritories[terPtr.pointers[myTile.subtiles[0]]].id;
					
					myTerritories[terPtr.pointers[rewriteIDs[0]]].isDeleted = true;
					terPtr.rewritePtr(currentIDs[0], rewriteIDs[0]);
				}

			
				//Merge 1 index
				if (myTerritories[terPtr.pointers[board[x-1][y].subtiles[7]]] != myTerritories[terPtr.pointers[myTile.subtiles[1]]])
				{
					mergeTerritory(myTerritories, myTerritories[terPtr.pointers[board[x-1][y].subtiles[7]]], myTerritories[terPtr.pointers[myTile.subtiles[1]]], x, y);
					rewriteIDs[1] = myTerritories[terPtr.pointers[board[x-1][y].subtiles[7]]].id;
					currentIDs[1] = myTerritories[terPtr.pointers[myTile.subtiles[1]]].id;
				
					myTerritories[terPtr.pointers[rewriteIDs[1]]].isDeleted = true;
					terPtr.rewritePtr(currentIDs[1], rewriteIDs[1]);	
				}
				
				
				//Merge 2 index if its a jungle
				if (myTerritories[terPtr.pointers[myTile.subtiles[2]]].territory == 'j' && myTerritories[terPtr.pointers[myTile.subtiles[2]]].id != myTerritories[terPtr.pointers[board[x-1][y].subtiles[6]]].id)
				{
					mergeTerritory(myTerritories, myTerritories[terPtr.pointers[board[x-1][y].subtiles[6]]], myTerritories[terPtr.pointers[myTile.subtiles[2]]], x, y);
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
					mergeTerritory(myTerritories, myTerritories[terPtr.pointers[board[x][y+1].subtiles[11]]], myTerritories[terPtr.pointers[myTile.subtiles[3]]], x, y);
					rewriteIDs[3] = myTerritories[terPtr.pointers[board[x][y+1].subtiles[11]]].id;
					currentIDs[3] = myTerritories[terPtr.pointers[myTile.subtiles[3]]].id;
					
					myTerritories[terPtr.pointers[rewriteIDs[3]]].isDeleted = true;
					terPtr.rewritePtr(currentIDs[3], rewriteIDs[3]);
				}

			
				//Merge 4 index
				if (myTerritories[terPtr.pointers[board[x][y+1].subtiles[10]]] != myTerritories[terPtr.pointers[myTile.subtiles[4]]])
				{
					mergeTerritory(myTerritories, myTerritories[terPtr.pointers[board[x][y+1].subtiles[10]]], myTerritories[terPtr.pointers[myTile.subtiles[4]]], x, y);
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
					mergeTerritory(myTerritories, myTerritories[terPtr.pointers[board[x][y+1].subtiles[9]]], myTerritories[terPtr.pointers[myTile.subtiles[5]]], x, y);
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
					mergeTerritory(myTerritories, myTerritories[terPtr.pointers[board[x+1][y].subtiles[2]]], myTerritories[terPtr.pointers[myTile.subtiles[6]]], x, y);
					rewriteIDs[6] = myTerritories[terPtr.pointers[board[x+1][y].subtiles[2]]].id;
					currentIDs[6] = myTerritories[terPtr.pointers[myTile.subtiles[6]]].id;
					
					myTerritories[terPtr.pointers[rewriteIDs[6]]].isDeleted = true;
					terPtr.rewritePtr(currentIDs[6], rewriteIDs[6]);
				}

			
				//Merge 7 index
				if (myTerritories[terPtr.pointers[board[x+1][y].subtiles[1]]] != myTerritories[terPtr.pointers[myTile.subtiles[7]]])
				{
					mergeTerritory(myTerritories, myTerritories[terPtr.pointers[board[x+1][y].subtiles[1]]], myTerritories[terPtr.pointers[myTile.subtiles[7]]], x, y);
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
					mergeTerritory(myTerritories, myTerritories[terPtr.pointers[board[x+1][y].subtiles[0]]], myTerritories[terPtr.pointers[myTile.subtiles[8]]], x, y);
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
					mergeTerritory(myTerritories, myTerritories[terPtr.pointers[board[x][y-1].subtiles[5]]], myTerritories[terPtr.pointers[myTile.subtiles[9]]], x, y);
					rewriteIDs[9] = myTerritories[terPtr.pointers[board[x][y-1].subtiles[5]]].id;
					currentIDs[9] = myTerritories[terPtr.pointers[myTile.subtiles[9]]].id;
					
					myTerritories[terPtr.pointers[rewriteIDs[9]]].isDeleted = true;
					terPtr.rewritePtr(currentIDs[9], rewriteIDs[9]);
				}

			
				//Merge 10 index
				if (myTerritories[terPtr.pointers[board[x][y-1].subtiles[4]]] != myTerritories[terPtr.pointers[myTile.subtiles[10]]])
				{
					mergeTerritory(myTerritories, myTerritories[terPtr.pointers[board[x][y-1].subtiles[4]]], myTerritories[terPtr.pointers[myTile.subtiles[10]]], x, y);
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
					mergeTerritory(myTerritories, myTerritories[terPtr.pointers[board[x][y-1].subtiles[3]]], myTerritories[terPtr.pointers[myTile.subtiles[11]]], x, y);
					rewriteIDs[11] = myTerritories[terPtr.pointers[board[x][y-1].subtiles[3]]].id;
					currentIDs[11] = myTerritories[terPtr.pointers[myTile.subtiles[11]]].id;
					
					myTerritories[terPtr.pointers[rewriteIDs[11]]].isDeleted = true;
					terPtr.rewritePtr(currentIDs[11], rewriteIDs[11]);
				}
			}
			
			//Tiger placing
			
			//player2's Turn
			if (turn%2 == 0)
			{
				tigerPlacement(myTile, myTerritories, terPtr, player2, sc);
			}
			//player1's Turn
			else
			{
				tigerPlacement(myTile, myTerritories, terPtr, player1, sc);
			}
			
			//
			
			
			//Scoring
			
			midGameScoring(myTile, myTerritories, terPtr, player1, player2);
			
			//
			
			
			
			////////////////////////////////// END OF MERGING \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
			turn++;
			//Place tile, update positions
			board[x][y] = myTile;
			updatePlaceable(placedPos, placeablePos, x, y);
		}

		
		System.out.println("\nThe final board is: ");
		Printer.printBoardID(board, placedPos, myTerritories, terPtr);
		
		endGameScoring(myTerritories, terPtr, player1, player2);
		Printer.printScores(player1, player2);
		
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
	
	////////////////////////////////////////// MERGING /////////////////////////////////////////////////////////////////////

	//CHANGE to not pass in territories, rather locations
	
	//Method to merge the contents of one territory with another.
	public static void mergeTerritory(Territory[] myTerritories, Territory toMerge, Territory currentTerritory, int x, int y)
	{	
		System.out.println("Merging Territories " + toMerge.id + " and " + currentTerritory.id);
		System.out.println(toMerge.borderingLakes.size() + " and " + currentTerritory.borderingLakes.size());
		
		currentTerritory.numDeer += toMerge.numDeer;
		currentTerritory.numBoar += toMerge.numBoar;
		currentTerritory.numBuffalo += toMerge.numBuffalo;
		currentTerritory.openFaces += toMerge.openFaces - 2;
		currentTerritory.player1Tigers += toMerge.player1Tigers;
		currentTerritory.player2Tigers += toMerge.player2Tigers;
		
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
		
		
		//Updates borderingLakes and borderingDens if type is jungle
		if (currentTerritory.territory == 'j' && toMerge.territory == 'j')
		{
			currentTerritory.borderingLakes.add(10);
			System.out.println("Bordering Lakes size is " + myTerritories[23].borderingLakes.size());
			
			
			//SOMETHING IS WRONG HERE
			
			//Checks all borderLakes in toMerge
			for (int i = 0; i < toMerge.borderingLakes.size(); i++)
			{				
				//Add the borderLake to current Territory if it is not in current Territory
				if (currentTerritory.borderingLakes.contains(toMerge.borderingLakes.get(i)) == false)
				{
					
					System.out.println(toMerge.borderingLakes.get(i));
					//currentTerritory.borderingLakes.add(toMerge.borderingLakes.get(i));
				}
			}
			
			
			System.out.println("Bordering Lakes size is " + myTerritories[23].borderingLakes.size());
			
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
	//////////////////////////////// TIGER PLACEMENT \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	public static void tigerPlacement(Tile currentTile, Territory[] myTerritories, TerritoryPtr terPtr, Player player, Scanner sc)
	{
		//Player can only place if they have a tiger available
		if (player.numTigers > 0)
		{
			ArrayList<Integer> availableTigerLoc = new ArrayList<Integer>();
			ArrayList<Integer> tileIndex = new ArrayList<Integer>();

			for (int i = 0; i < 12; i++)
			{
				//Can only place on territories with no tigers
				if (myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player1Tigers == 0 && myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player2Tigers == 0)
				{
					//Add the ID of the available tiger location if it is not already present and print its position
					if (availableTigerLoc.contains(myTerritories[terPtr.pointers[currentTile.subtiles[i]]].id) == false)
					{
						System.out.println("A Tiger may be placed on index " + i + " which is type " + myTerritories[terPtr.pointers[currentTile.subtiles[i]]].territory + " ");
						availableTigerLoc.add(myTerritories[terPtr.pointers[currentTile.subtiles[i]]].id);
						tileIndex.add(i);
					}
				}
			}
			
			//If a den is present, add it to available tiger locations
			if (myTerritories[terPtr.pointers[currentTile.subtiles[12]]].territory == 'd')
			{
				availableTigerLoc.add(myTerritories[terPtr.pointers[currentTile.subtiles[13]]].id);
				tileIndex.add(12);
				System.out.println("A Tiger may be placed on index 13 which is type " + myTerritories[terPtr.pointers[currentTile.subtiles[13]]].territory);
			}
			
			tileIndex.add(13);			
			//Collects index of tiger placement from player
			System.out.println("Please enter an available index for tiger placement, or 13 for none");
			int tigerLoc = sc.nextInt();

			//Ensures valid index has been selected
			while (tileIndex.contains(tigerLoc) == false)
			{
				System.out.println("Invalid Index: Please enter an available index for tiger placement, or 13 for none");
				tigerLoc = sc.nextInt();
			}
			
			//Do nothing if 13 is entered
			if (tigerLoc == 13)
			{
				System.out.println("No tiger has been placed");
			}
			else
			{
				System.out.println("A tiger has been placed on index " + tigerLoc + " for player" + player.playerID);
					
				int placedLoc = availableTigerLoc.get(tileIndex.indexOf(tigerLoc));
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
		else
		{
			System.out.println("The player has no tigers available to place");
		}
	}

	
	
	////////////////////////////////////////// SCORING METHODS \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	public static void midGameScoring(Tile currentTile, Territory[] myTerritories, TerritoryPtr terPtr, Player player1, Player player2)
	{
		for (int i = 0; i < 12; i++)
		{
			//Scores trails if they are completed mid game
			if (myTerritories[terPtr.pointers[currentTile.subtiles[i]]].isScored == false && myTerritories[terPtr.pointers[currentTile.subtiles[i]]].territory == 't' 
					&& myTerritories[terPtr.pointers[currentTile.subtiles[i]]].openFaces == 0)
			{
				if ((myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player1Tigers > 0 || myTerritories[terPtr.pointers[currentTile.subtiles[i]]].player2Tigers > 0))
				{
					int additionalPoints = myTerritories[terPtr.pointers[currentTile.subtiles[i]]].numBoar + myTerritories[terPtr.pointers[currentTile.subtiles[i]]].numBuffalo + myTerritories[terPtr.pointers[currentTile.subtiles[i]]].numDeer;
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
					if (myTerritories[terPtr.pointers[currentTile.subtiles[i]]].numBoar > 0)
					{
						multiplier++;
					}
					if (myTerritories[terPtr.pointers[currentTile.subtiles[i]]].numBuffalo > 0)
					{
						multiplier++;
					}
					if (myTerritories[terPtr.pointers[currentTile.subtiles[i]]].numDeer > 0)
					{
						multiplier++;
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
	}
	
	public static void endGameScoring(Territory[] myTerritories, TerritoryPtr terPtr, Player player1, Player player2)
	{
		/////////////////////////////////// ****CHANGE LATER For-loop set to 20 for testing CHANGE LATER**** \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		for (int i = 0; i < 24; i++)
		{
			//Checks for existing trails that have a tiger placed and are not scored
			if (myTerritories[i].isScored == false && myTerritories[i].territory == 't' && myTerritories[i].isDeleted == false && (myTerritories[i].player1Tigers > 0 || myTerritories[i].player2Tigers > 0))
			{
				int additionalPoints = myTerritories[i].numBoar + myTerritories[i].numBuffalo + myTerritories[i].numDeer;
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
				
				if (myTerritories[i].numBoar > 0)
				{
					multiplier++;
				}
				if (myTerritories[i].numBuffalo > 0)
				{
					multiplier++;
				}
				if (myTerritories[i].numDeer > 0)
				{
					multiplier++;
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
				
				//test
				System.out.println("The size of bordering lakes is " + myTerritories[i].borderingLakes.size());
				for (int j = 0 ; j < myTerritories[i].borderingLakes.size(); j++)
				{
					System.out.println(myTerritories[i].borderingLakes.get(j));
					System.out.println(terPtr.pointers[myTerritories[i].borderingLakes.get(j)]);
				}

				
				//
				
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
				
				System.out.println("Number of adjacent lakes is " + numAdjacentLake + " Number of adj dens is " + numAdjacentDen);
				
				//Jungle score is 3 points per adj Lake + 5 points per adj Den
				int jungleScore = (3 * numAdjacentLake) + (5 * numAdjacentDen);
				
				//Player1 gets score if they have more tigers
				if (myTerritories[i].player1Tigers > myTerritories[i].player2Tigers)
				{
					System.out.println("Player 1 has earned " + jungleScore + " points for a completed jungle");
					player1.score += jungleScore;
				}
				//Player2 gets score if they have more tigers
				if (myTerritories[i].player1Tigers < myTerritories[i].player2Tigers)
				{
					System.out.println("Player 2 has earned " + jungleScore + " points for a completed jungle");
					player2.score += jungleScore;
				}
				//Player1 & Player2 get score if they have same amount of tigers
				if (myTerritories[i].player1Tigers == myTerritories[i].player2Tigers)
				{
					System.out.println("Player 1 and Player 2 have both earned " + jungleScore + " points for a completed jungle");
					player1.score += jungleScore;
					player2.score += jungleScore;
				}
				//Marks Territory as scored
				myTerritories[i].isScored = true;
			}
		}
		
	}
	
	

}
