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
		Game game1 = new Game(BOARD_WIDTH, BOARD_LENGTH);
		
		//initializes starting position
		game1.addPlaceable(BOARD_WIDTH / 2, BOARD_LENGTH / 2);
		
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
		game1.addToBoard(BOARD_WIDTH / 2, BOARD_LENGTH / 2, tileEngine.create(start));
		//fills up the game deck
		for(int i = 0; i < tileSet.length; i++){
			game1.addToDeck(tileEngine.create(tileSet[i]));
		}
		
		TerritoryPtr terPtr = new TerritoryPtr(tileEngine.getTerritoriesSize());
		
		//sets myTerritories created by the tile engine
		game1.setTerritories(tileEngine.getMyTerritories());
		game1.setMyTerritoriesSize(tileEngine.getTerritoriesSize());
		
		// Starter location is added as a placeablePos, starter tile is then
		// automatically placed and the placed/placeable array lists are updated
		game1.updatePlaceable(BOARD_WIDTH / 2, BOARD_LENGTH / 2);
		game1.addContainedTile(game1.getTile(BOARD_WIDTH / 2, BOARD_LENGTH / 2), terPtr, BOARD_WIDTH / 2, BOARD_LENGTH / 2);



Player player1 = new Player(1);
Player player2 = new Player(2);
ArrayList<Integer> currentDens = new ArrayList<Integer>();

///////////////////////////////////////////////////// GAMEPLAY LOOP \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		
	//	printTile(starter);
		int turn = 1;
		// Users plays game
		while (game1.deckSize() > 0) {
			
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
			Printer.printBoard(game1.getBoard(), game1.getPlaced(), game1.getTerritories(), terPtr);
			
			System.out.println("The current tile is: ");
			Tile myTile = game1.nextTile();
			Printer.printTile(myTile, game1.getTerritories(), terPtr);

			boolean valid = false;
			while (valid == false) {

				System.out.println("Please choose a rotation degree for the tile (0, 1, 2, 3)");
				int degree = sc.nextInt();
				myTile.Rotate(degree);
				if (degree > 0) {
					System.out.println("The current tile is now: ");
					Printer.printTile(myTile, game1.getTerritories(), terPtr);
				}

				Printer.printPlaceable(game1.getPlaceable());
				System.out.println("Please select an X and Y coordinate to place the tile");
				x = sc.nextInt();
				y = sc.nextInt();

				valid = game1.validPlacement(myTile, x, y, terPtr);
				if (valid == false) {
					System.out.println("Invalid placement, please place again");
				} else {
					System.out.println("Tile successfully placed");
				}
			}
			
			//Adds the coordinate of the tile to the tile
			game1.addContainedTile(myTile, terPtr, x, y);
			
			//Merges Tile contents
			game1.mergeTile( myTile, terPtr, currentDens, x, y);
			
			
			//Crocodile & Tiger placement
			
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
						game1.tigerPlacement(myTile, terPtr, player2, sc);
					}
					else
					{
						System.out.println("No tigers remaining");
					}
				}
				//Place crocodile
				else if (choice == 2)
				{
					if (game1.crocodilePlaceable(myTile, terPtr) == true && player2.numCrocodiles > 0)
					{
						System.out.println("A crocodile has been placed on the tile");
						game1.crocodilePlacement(myTile, terPtr, player2, x, y);
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
						game1.tigerPlacement(myTile, terPtr, player1, sc);
					}
					else
					{
						System.out.println("No tigers remaining");
					}
				}
				//Place crocodile
				else if (choice == 2)
				{
					if (game1.crocodilePlaceable(myTile, terPtr) == true && player1.numCrocodiles > 0)
					{
						System.out.println("A crocodile has been placed on the tile");
						game1.crocodilePlacement(myTile, terPtr, player1, x, y);
					}
					else
					{
						System.out.println("Crocodile can not be placed or no crocodiles remaining");
					}
				}		
			}
		
			//Scoring
			game1.midGameScoring(myTile, terPtr, currentDens, player1, player2, x, y);
			
			//Place tile, update positions and turn
			turn++;
			game1.addToBoard(x, y, myTile);
			game1.updatePlaceable( x, y);
		}

		
		System.out.println("\nThe final board is: ");
		Printer.printBoardID(game1.getBoard(), game1.getPlaced(), game1.getTerritories(), terPtr);
		
		game1.endGameScoring( terPtr, player1, player2);
		Printer.printScores(player1, player2);
		
		
		//Printer.printArrayList(ter18.containedTiles);
	}
}
