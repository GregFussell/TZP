package tigerZone;

import java.util.ArrayList;
import java.util.Scanner;

public class GameLoop {
	public static final int BOARD_WIDTH = 155;
	public static final int BOARD_LENGTH = 155;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Initializes the array lists that contain placed positions and
		// placeable positions
		Scanner sc = new Scanner(System.in);
		
		
		
		// Initializes the game
		Game game = new Game(BOARD_WIDTH, BOARD_LENGTH);
		
		//initializes starting position
		game.addPlaceable(BOARD_WIDTH / 2, BOARD_LENGTH / 2);
		
		//initializes tile creation engine
		TileCreator tileEngine = new TileCreator();
		
		//initializes values which will be input from the server
		String start = null;			// taken from NetworkInterface
		String tileSet[] = null;		//	
		
		///temporary start and tileset/////////////////////////
		start = "TLTJD";
		String temp[] = {"TJTJ-",
				"LJJJ-",
				"TJJT-",
				"TLTTP",
				"LJLJ-",
				"TJTJ-",
				"TJTT-",
				"TLLTB",
				"JLJL-",
				"LJJJ-",
				"JLTT-",
				"TJTJ-",
				"TJJT-",
				"JLLL-",
				"TJJT-",
				"TJTJ-",
				"TJJT-",
				"LLJJ-",
				"TLTJD",
				"LLJJ-",
				"JJJJX",
				"TJJT-",
				"TJJT-",
				"TLTT-",
				"TLJTP",
				"JJJJX",
				"TJTJ-",
				"JJTJX",
				"JLJL-",
				"LJTJD",
				"LJLJ-",
				"TLLTB",
				"TLTTP",
				"JLTTB",
				"TLTJ-",
				"TLLT-",
				"LJTJ-",
				"LJTJD",
				"JJJJX",
				"TJTT-",
				"TLLL-",
				"TJJT-",
				"TLLLC",
				"JLLJ-",
				"TLTJD",
				"LLJJ-",
				"JJTJX",
				"TJTT-",
				"TLJT-",
				"TLLT-",
				"TLLT-",
				"JLLL-",
				"LLLL-",
				"TLJTP",
				"JLLL-",
				"JLLJ-",
				"LJJJ-",
				"TJJT-",
				"TJTJ-",
				"TLLLC",
				"LJLJ-",
				"LLJJ-",
				"JLTTB",
				"JJJJ-",
				"TJTJ-",
				"TJTT-",
				"TLTJ-",
				"JLJL-",
				"LJJJ-",
				"JLLL-",
				"LJJJ-",
				"TJJT-",
				"TJTJ-",
				"LLJJ-",
				"TTTT-",
				"JJJJX"};
		tileSet = temp;
		/////////////////////////////////////////////////////
		
		//places starting tile
		game.addToBoard(BOARD_WIDTH / 2, BOARD_LENGTH / 2, tileEngine.create(start));
		//fills up the game deck
		for(int i = 0; i < tileSet.length; i++){
			game.addToDeck(tileEngine.create(tileSet[i]));
		}
		
		
		//sets myTerritories created by the tile engine
		game.setTerritories(tileEngine.getMyTerritories());
		game.setMyTerritoriesSize(tileEngine.getTerritoriesSize());
		
		// Starter location is added as a placeablePos, starter tile is then
		// automatically placed and the placed/placeable array lists are updated
		game.updatePlaceable(BOARD_WIDTH / 2, BOARD_LENGTH / 2);
		game.addContainedTile(game.getTile(BOARD_WIDTH / 2, BOARD_LENGTH / 2), BOARD_WIDTH / 2, BOARD_LENGTH / 2);
		
		AI Flynn = new AI(game.getDeck());



Player player1 = new Player(1);
Player player2 = new Player(2);
ArrayList<Integer> currentDens = new ArrayList<Integer>();

int[] t;
t = new int[3];

///////////////////////////////////////////////////// GAMEPLAY LOOP \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		
	//	printTile(starter);
		int turn = 1;
		long startTime = System.currentTimeMillis();
		// Users plays game
		while (game.deckSize() > 0) {
			
			if(game.deckSize() == 1){
				startTime = System.currentTimeMillis();
			}
			
			//player2's Turn
			if (turn%2 == 0)
			{
				System.out.println();
				System.out.println("Player2's Turn: ");

				System.out.println();
			}
			//player1's Turn
			else
			{
				System.out.println();
				System.out.println("Player1's Turn: ");
				System.out.println();
			}
			
			int x = 0;
			int y = 0;

			System.out.println("The current board is: ");
//			Printer.printBoard(game.getBoard(), game.getPlaced(), game.getTerritories(), game.getTerPtr());
			
			System.out.println("The current tile is: ");
			Tile myTile = game.nextTile();
//			Printer.printTile(myTile, game.getTerritories(), game.getTerPtr());
			
			t = Flynn.decision(game.getBoard(), myTile, game.getPlaceable(), game, player2.numTigers);
			//if there are no available moves, it passes
			if(t[0] == -1){
				game.nextTile();
				continue;
			}
			for(int z = 0; z < 3; z++){
				System.out.println(t[z]);
			}

			boolean valid = false;
			while (valid == false) {

				System.out.println("Please choose a rotation degree for the tile (0, 1, 2, 3)");
				int degree = 0;
				degree = t[0];
				//degree = sc.nextInt();
				myTile.Rotate(degree);
				if (degree > 0) {
					System.out.println("The current tile is now: ");
//					Printer.printTile(myTile, game.getTerritories(), game.getTerPtr());
				}

//				Printer.printPlaceable(game.getPlaceable());
				System.out.println("Please select an X and Y coordinate to place the tile");
				//x = sc.nextInt();
				//y = sc.nextInt();
				x = t[1];
				y = t[2];

				valid = game.validPlacement(myTile, x, y);
				if (valid == false) {
					System.out.println("Invalid placement, please place again");
				} else {
					System.out.println("Tile successfully placed");
				}
			}
			
			//Adds the coordinate of the tile to the tile
			game.addContainedTile(myTile, x, y);
			
			//Merges Tile contents
			game.mergeTile( myTile, currentDens, x, y);
			
			
			//Crocodile & Tiger placement
			ArrayList<Integer> availableTigerLoc = new ArrayList<Integer>();
			ArrayList<Integer> zoneIndex = new ArrayList<Integer>();
			ArrayList<Character> tigerTerritory = new ArrayList<Character>();

			
			//player2's Turn
			if (turn%2 == 0)
			{
				System.out.println("The current player has " + player2.numTigers + " tigers and " + player2.numCrocodiles + " crocodiles");	
				int choice;
				System.out.println("Would you like to place a (1) tiger, (2) crocodile, or (3) none?");
				choice = t[3];
				//choice = sc.nextInt();
				while (choice != 1 && choice != 2 && choice != 3)
				{
					System.out.println("Invalid input, please enter 1 for tiger, 2 for crocodile, or 3 for none");
					choice = sc.nextInt();
				}	
				
				//Place tiger
				if (choice == 1)
				{
					if (player2.numTigers > 0)
					{
						game.tigerPlacementLoc(myTile, availableTigerLoc, zoneIndex, tigerTerritory);
						//Do AI stuff
						System.out.println("Poss Tgr Loc: " + zoneIndex.toString());
						System.out.println("On Territory: " + tigerTerritory.toString());
						System.out.println("Selected Location: " + t[4]);

						
						game.tigerPlacementAI(myTile, player2, t[4], availableTigerLoc, zoneIndex);
					}
					else
					{
						System.out.println("No tigers remaining");
					}
				}
				//Place crocodile
				else if (choice == 2)
				{
					if (game.crocodilePlaceable(myTile) == true && player2.numCrocodiles > 0)
					{
						System.out.println("A crocodile has been placed on the tile");
						game.crocodilePlacement(myTile, player2, x, y);
					}
					else
					{
						System.out.println("Crocodile can not be placed or no crocodiles remaining");
					}
				}	
			}
			//player1's Turn
			else
			{
				System.out.println("The current player has " + player1.numTigers + " tigers and " + player1.numCrocodiles + " crocodiles");	
				int choice;
				System.out.println("Would you like to place a (1) tiger, (2) crocodile, or (3) none?");
				choice = t[3];
				//choice = sc.nextInt();
				while (choice != 1 && choice != 2 && choice != 3)
				{
					System.out.println("Invalid input, please enter 1 for tiger, 2 for crocodile, or 3 for none");
					choice = sc.nextInt();
				}	
				
				//Place tiger
				if (choice == 1)
				{
					if (player1.numTigers > 0)
					{
						game.tigerPlacementLoc(myTile, availableTigerLoc, zoneIndex, tigerTerritory);
						//Do AI stuff
						System.out.println("Poss Tgr Loc: " + zoneIndex.toString());
						System.out.println("On Territory: " + tigerTerritory.toString());
						System.out.println("Selected Location: " + t[4]);

						//
						game.tigerPlacementAI(myTile, player1, t[4], availableTigerLoc, zoneIndex);
			
					}
					else
					{
						System.out.println("No tigers remaining");
					}
				}
				//Place crocodile
				else if (choice == 2)
				{
					if (game.crocodilePlaceable(myTile) == true && player1.numCrocodiles > 0)
					{
						System.out.println("A crocodile has been placed on the tile");
						game.crocodilePlacement(myTile, player1, x, y);
					}
					else
					{
//						System.out.println("Crocodile can not be placed or no crocodiles remaining");
					}
				}		
			}
		
			//Scoring
			game.midGameScoring(myTile, currentDens, player1, player2, x, y);
			
			//Place tile, update positions and turn
			turn++;
			game.addToBoard(x, y, myTile);
			game.updatePlaceable( x, y);
		}

		
		System.out.println("\nThe final board is: ");
		//Printer.printBoardID(game.getBoard(), game.getPlaced(), game.getTerritories(), game.getTerPtr());
		
		game.endGameScoring(player1, player2);
//		Printer.printScores(player1, player2);
		sc.close();
		
		final long endTime = System.currentTimeMillis();
		
		System.out.println("Total execution time: " + (endTime - startTime));
		
		
		//Printer.printArrayList(ter18.containedTiles);
	}
}
