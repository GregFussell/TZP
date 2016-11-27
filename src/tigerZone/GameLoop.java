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
		String temp[] = { "JJJJ-", "JJJJX", "JJTJX", "TTTT-" };
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
		

		//test
		
		Game copy = new Game(BOARD_WIDTH, BOARD_LENGTH);
		
		copy.cloneGame(game);

		
		copy.getBoard()[36][36] = tileEngine.create(start);
		
		System.out.println(game.getMyTerritoriesSize());
		
		System.out.println(copy.getBoard()[36][36].subtiles[0]);
		
		System.out.println(game.getBoard()[36][36].subtiles[0]);



Player player1 = new Player(1);
Player player2 = new Player(2);
ArrayList<Integer> currentDens = new ArrayList<Integer>();

///////////////////////////////////////////////////// GAMEPLAY LOOP \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		
	//	printTile(starter);
		int turn = 1;
		// Users plays game
		while (game.deckSize() > 0) {
			
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
			Printer.printBoard(game.getBoard(), game.getPlaced(), game.getTerritories(), game.getTerPtr());
			
			System.out.println("The current tile is: ");
			Tile myTile = game.nextTile();
			Printer.printTile(myTile, game.getTerritories(), game.getTerPtr());

			boolean valid = false;
			while (valid == false) {

				System.out.println("Please choose a rotation degree for the tile (0, 1, 2, 3)");
				int degree = sc.nextInt();
				myTile.Rotate(degree);
				if (degree > 0) {
					System.out.println("The current tile is now: ");
					Printer.printTile(myTile, game.getTerritories(), game.getTerPtr());
				}

				Printer.printPlaceable(game.getPlaceable());
				System.out.println("Please select an X and Y coordinate to place the tile");
				x = sc.nextInt();
				y = sc.nextInt();

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
			
			//player2's Turn
			if (turn%2 == 0)
			{
				System.out.println("The current player has " + player2.numTigers + " tigers and " + player2.numCrocodiles + " crocodiles");	
				int choice;
				System.out.println("Would you like to place a (1) tiger, (2) crocodile, or (3) none?");
				choice = sc.nextInt();
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
						game.tigerPlacementLoc(myTile, player2, sc, availableTigerLoc, zoneIndex);
						//Do AI stuff
						
						game.tigerPlacement(myTile, player2, sc, availableTigerLoc, zoneIndex);
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
				choice = sc.nextInt();
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
						game.tigerPlacementLoc(myTile, player1, sc, availableTigerLoc, zoneIndex);
						//Do AI stuff
						
						//
						game.tigerPlacement(myTile, player1, sc, availableTigerLoc, zoneIndex);
			
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
						System.out.println("Crocodile can not be placed or no crocodiles remaining");
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
		Printer.printBoardID(game.getBoard(), game.getPlaced(), game.getTerritories(), game.getTerPtr());
		
		game.endGameScoring(player1, player2);
		Printer.printScores(player1, player2);
		
		
		//Printer.printArrayList(ter18.containedTiles);
	}
}
