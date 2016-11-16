package tigerZone;

import java.util.ArrayList;
import java.util.Scanner;

public class GameLoop {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Tile starter = new Tile('j','l','j',
		// 't','t','t',
		// 'j','j','j',
		// 1);

		// Initializes the array lists that contain placed positions and
		// placeable positions
		Scanner sc = new Scanner(System.in);
		
		Game game1 = new Game();

		
		//Creates Territories for Starter Tile
		Territory[] territories = new Territory[13];
		
		Territory ter = new Territory(0, ' ', 0, false);
		game1.myTerritories[0] = ter;
		
		//Tile D : starter tile
		Territory ter1 = new Territory(1, 'l', 1, false); game1.myTerritories[1] = ter1;//North lake
		Territory ter2 = new Territory(2, 'j', 2, false); game1.myTerritories[2] = ter2;//North Jungle
		Territory ter3 = new Territory(3, 't', 2, false); game1.myTerritories[3] = ter3;//Road
		Territory ter4 = new Territory(4, 'j', 3, false); game1.myTerritories[0] = ter4;//South Jungle
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
		Territory ter5 = new Territory(5, 'j', 3, false); game1.myTerritories[5] = ter5;//North jungle
		Territory ter6 = new Territory(6, 't', 2, false); game1.myTerritories[6] = ter6;//Road
		Territory ter7 = new Territory(7, 'j', 3, false); game1.myTerritories[7] = ter7;//South Jungle
		
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
		Territory ter8 = new Territory(8, 'j', 3, false); game1.myTerritories[8] = ter8;//North jungle
		Territory ter9 = new Territory(9, 't', 2, false); game1.myTerritories[9] = ter9;//Road
		Territory ter10 = new Territory(10, 'j', 2, false); game1.myTerritories[10] = ter10;//South Jungle
		
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
		Territory ter11 = new Territory(11, 'j', 3, false); game1.myTerritories[11] = ter11;//North jungle
		Territory ter12 = new Territory(12, 't', 2, false); game1.myTerritories[12] = ter12;//Road
		Territory ter13 = new Territory(13, 'j', 2, false); game1.myTerritories[13] = ter13;//South Jungle
		
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
		Territory ter14 = new Territory(14, 'j', 3, false); game1.myTerritories[14] = ter14;
		Territory ter15 = new Territory(15, 't', 2, false); game1.myTerritories[15] = ter15;
		Territory ter16 = new Territory(16, 'j', 2, false); game1.myTerritories[16] = ter16;
		
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
		Territory ter17 = new Territory(17, 'j', 3, false); game1.myTerritories[17] = ter17;
		Territory ter18 = new Territory(18, 't', 2, false); game1.myTerritories[18] = ter18;
		Territory ter19 = new Territory(19, 'j', 2, false); game1.myTerritories[19] = ter19;
		
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
		
		// Starter location is added as a placeablePos, starter tile is then
		// automatically placed and the placed/placeable array lists are updated
		game1.placeablePos.add(new ArrayCoord(36, 36));
		game1.board[36][36] = B;
		Game.updatePlaceable(game1.placedPos, game1.placeablePos, 36, 36);
		
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
			Printer.printBoard(game1.board, game1.placedPos);
			
			System.out.println("The current tile is: ");
			Tile myTile = myDeck.deck.remove();
			Printer.printTile(myTile);

			boolean valid = false;
			while (valid == false) {
				if(turn%2 == 0){
					t = Flynn.decision(game1.board, myTile, game1.placeablePos);
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
					Printer.printTile(myTile);
				}

				Printer.printPlaceable(game1.placeablePos);
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

				valid = Game.validPlacement(myTile, game1.board, game1.placeablePos, x, y);
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
			if (game1.board[x-1][y] != null)
			{
				//Merge 0 index if its a jungle
				if (myTile.subtiles[0].territory == 'j' && myTile.subtiles[0].id != game1.board[x-1][y].subtiles[8].id)
				{
					mergedTerritories[0] = Game.mergeTerritory(game1.board[x-1][y].subtiles[8], myTile.subtiles[0], x, y);
					rewriteIDs[0] = game1.board[x-1][y].subtiles[8].id;
					currentIDs[0] = myTile.subtiles[0].id;
					
					game1.myTerritories[rewriteIDs[0]].isDeleted = true;
					game1.myTerritories[currentIDs[0]] = mergedTerritories[0];
					Game.mergeRewrite(game1.board, currentIDs[0], rewriteIDs[0], mergedTerritories[0], x, y);
				}

			
				//Merge 1 index
				if (game1.board[x-1][y].subtiles[7] != myTile.subtiles[1])
				{
					mergedTerritories[1] = Game.mergeTerritory(game1.board[x-1][y].subtiles[7], myTile.subtiles[1], x, y);
					rewriteIDs[1] = game1.board[x-1][y].subtiles[7].id;
					currentIDs[1] = myTile.subtiles[1].id;
				
					game1.myTerritories[rewriteIDs[1]].isDeleted = true;
					game1.myTerritories[currentIDs[1]] = mergedTerritories[1];
					Game.mergeRewrite(game1.board, currentIDs[1], rewriteIDs[1], mergedTerritories[1], x, y);
				}
				
				
				//Merge 2 index if its a jungle
				if (myTile.subtiles[2].territory == 'j' && myTile.subtiles[2].id != game1.board[x-1][y].subtiles[6].id)
				{
					mergedTerritories[2] = Game.mergeTerritory(game1.board[x-1][y].subtiles[6], myTile.subtiles[2], x, y);
					rewriteIDs[2] = game1.board[x-1][y].subtiles[6].id;
					currentIDs[2] = myTile.subtiles[2].id;
					
					game1.myTerritories[rewriteIDs[2]].isDeleted = true;
					game1.myTerritories[currentIDs[2]] = mergedTerritories[2];
					Game.mergeRewrite(game1.board, currentIDs[2], rewriteIDs[2], mergedTerritories[2], x, y);
				}
			}
			
			//Merging with tile to right, if it exists
			if (game1.board[x][y+1] != null)
			{
				//Merge 3 index if its a jungle
				if (myTile.subtiles[3].territory == 'j' && myTile.subtiles[3].id != game1.board[x][y+1].subtiles[11].id)
				{
					mergedTerritories[3] = Game.mergeTerritory(game1.board[x][y+1].subtiles[11], myTile.subtiles[3], x, y);
					rewriteIDs[3] = game1.board[x][y+1].subtiles[11].id;
					currentIDs[3] = myTile.subtiles[3].id;
					
					game1.myTerritories[rewriteIDs[3]].isDeleted = true;
					game1.myTerritories[currentIDs[3]] = mergedTerritories[3];
					Game.mergeRewrite(game1.board, currentIDs[3], rewriteIDs[3], mergedTerritories[3], x, y);
				}

			
				//Merge 4 index
				if (game1.board[x][y+1].subtiles[10] != myTile.subtiles[4])
				{
					mergedTerritories[4] = Game.mergeTerritory(game1.board[x][y+1].subtiles[10], myTile.subtiles[4], x, y);
					rewriteIDs[4] = game1.board[x][y+1].subtiles[10].id;
					currentIDs[4] = myTile.subtiles[4].id;
				
					game1.myTerritories[rewriteIDs[4]].isDeleted = true;
					game1.myTerritories[currentIDs[4]] = mergedTerritories[4];
					Game.mergeRewrite(game1.board, currentIDs[4], rewriteIDs[4], mergedTerritories[4], x, y);
				}
				else if (game1.board[x][y+1].subtiles[10] == myTile.subtiles[4])
				{
					myTile.subtiles[4].openFaces -= 2;
				}
				
				
				//Merge 5 index if its a jungle
				if (myTile.subtiles[5].territory == 'j' && myTile.subtiles[5].id != game1.board[x][y+1].subtiles[9].id)
				{
					mergedTerritories[5] = Game.mergeTerritory(game1.board[x][y+1].subtiles[9], myTile.subtiles[5], x, y);
					rewriteIDs[5] = game1.board[x][y+1].subtiles[9].id;
					currentIDs[5] = myTile.subtiles[5].id;
					
					game1.myTerritories[rewriteIDs[5]].isDeleted = true;
					game1.myTerritories[currentIDs[5]] = mergedTerritories[5];
					Game.mergeRewrite(game1.board, currentIDs[5], rewriteIDs[5], mergedTerritories[5], x, y);
				}
			}
			
			//Merging with tile below it, if it exists
			if (game1.board[x+1][y] != null)
			{
				//Merge 6 index if its a jungle
				if (myTile.subtiles[6].territory == 'j' && myTile.subtiles[6].id != game1.board[x+1][y].subtiles[2].id)
				{
					mergedTerritories[6] = Game.mergeTerritory(game1.board[x+1][y].subtiles[2], myTile.subtiles[6], x, y);
					rewriteIDs[6] = game1.board[x+1][y].subtiles[2].id;
					currentIDs[6] = myTile.subtiles[6].id;
					
					game1.myTerritories[rewriteIDs[6]].isDeleted = true;
					game1.myTerritories[currentIDs[6]] = mergedTerritories[6];
					Game.mergeRewrite(game1.board, currentIDs[6], rewriteIDs[6], mergedTerritories[6], x, y);
				}

			
				//Merge 7 index
				if (game1.board[x+1][y].subtiles[1] != myTile.subtiles[7])
				{
					mergedTerritories[7] = Game.mergeTerritory(game1.board[x+1][y].subtiles[1], myTile.subtiles[7], x, y);
					rewriteIDs[7] = game1.board[x+1][y].subtiles[1].id;
					currentIDs[7] = myTile.subtiles[7].id;
				
					game1.myTerritories[rewriteIDs[7]].isDeleted = true;
					game1.myTerritories[currentIDs[7]] = mergedTerritories[7];
					Game.mergeRewrite(game1.board, currentIDs[7], rewriteIDs[7], mergedTerritories[7], x, y);
				}
				else if (game1.board[x+1][y].subtiles[1] == myTile.subtiles[7])
				{
					myTile.subtiles[7].openFaces -= 2;
				}
				
				
				//Merge 8 index if its a jungle
				if (myTile.subtiles[8].territory == 'j' && myTile.subtiles[8].id != game1.board[x+1][y].subtiles[0].id)
				{
					mergedTerritories[8] = Game.mergeTerritory(game1.board[x+1][y].subtiles[0], myTile.subtiles[8], x, y);
					rewriteIDs[8] = game1.board[x+1][y].subtiles[0].id;
					currentIDs[8] = myTile.subtiles[8].id;
					
					game1.myTerritories[rewriteIDs[8]].isDeleted = true;
					game1.myTerritories[currentIDs[8]] = mergedTerritories[8];
					Game.mergeRewrite(game1.board, currentIDs[8], rewriteIDs[8], mergedTerritories[8], x, y);
				}
			}
			
			//Merging with tile to left, if it exists
			if (game1.board[x][y-1] != null)
			{
				//Merge 9 index if its a jungle
				if (myTile.subtiles[9].territory == 'j' && myTile.subtiles[9].id != game1.board[x][y-1].subtiles[5].id)
				{
					mergedTerritories[9] = Game.mergeTerritory(game1.board[x][y-1].subtiles[5], myTile.subtiles[9], x, y);
					rewriteIDs[9] = game1.board[x][y-1].subtiles[5].id;
					currentIDs[9] = myTile.subtiles[9].id;
					
					game1.myTerritories[rewriteIDs[9]].isDeleted = true;
					game1.myTerritories[currentIDs[9]] = mergedTerritories[9];
					Game.mergeRewrite(game1.board, currentIDs[9], rewriteIDs[9], mergedTerritories[9], x, y);
				}

			
				//Merge 10 index
				if (game1.board[x][y-1].subtiles[4] != myTile.subtiles[10])
				{
					mergedTerritories[10] = Game.mergeTerritory(game1.board[x][y-1].subtiles[4], myTile.subtiles[10], x, y);
					rewriteIDs[10] = game1.board[x][y-1].subtiles[4].id;
					currentIDs[10] = myTile.subtiles[10].id;
				
					game1.myTerritories[rewriteIDs[10]].isDeleted = true;
					game1.myTerritories[currentIDs[10]] = mergedTerritories[10];
					Game.mergeRewrite(game1.board, currentIDs[10], rewriteIDs[10], mergedTerritories[10], x, y);
				}
				else if (game1.board[x][y-1].subtiles[4] == myTile.subtiles[10])
				{
					myTile.subtiles[10].openFaces -= 2;
				}
				
				
				//Merge 11 index if its a jungle
				if (myTile.subtiles[11].territory == 'j' && myTile.subtiles[11].id != game1.board[x][y-1].subtiles[3].id)
				{
					mergedTerritories[11] = Game.mergeTerritory(game1.board[x][y-1].subtiles[3], myTile.subtiles[11], x, y);
					rewriteIDs[11] = game1.board[x][y-1].subtiles[3].id;
					currentIDs[11] = myTile.subtiles[11].id;
					
					game1.myTerritories[rewriteIDs[11]].isDeleted = true;
					game1.myTerritories[currentIDs[11]] = mergedTerritories[11];
					Game.mergeRewrite(game1.board, currentIDs[11], rewriteIDs[11], mergedTerritories[11], x, y);
				}
			}
			////////////////////////////////// END OF MERGING \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
			
			//Place tile, update positions
			game1.board[x][y] = myTile;
			Game.updatePlaceable(game1.placedPos, game1.placeablePos, x, y);
		}

		
		System.out.println("\nThe final board is: ");
		Printer.printBoardID(game1.board, game1.placedPos);
		
		System.out.println("Open faces on road is : " + game1.board[36][36].subtiles[10].openFaces);
		
		
		System.out.println("Current IDs are: ");
		System.out.println(game1.board[36][36].subtiles[0].id);
		System.out.println(game1.board[36][36].subtiles[1].id);
		System.out.println(game1.board[36][36].subtiles[2].id);
		System.out.println(game1.board[36][36].subtiles[3].id);
		System.out.println(game1.board[36][36].subtiles[4].id);
		System.out.println(game1.board[36][36].subtiles[5].id);
		System.out.println(game1.board[36][36].subtiles[6].id);
		
		
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
}
