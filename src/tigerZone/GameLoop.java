package tigerZone;

import java.util.ArrayList;
import java.util.Scanner;

public class GameLoop {
	public static final int BOARD_WIDTH = 156;
	public static final int BOARD_LENGTH = 156;
	
	private TileCreator tileEngine;
	private Game game;
	private Player player1;
	private Player player2;
	private ArrayList<Integer> currentDens;
	Scanner sc = new Scanner(System.in);	
	AI Flynn; //Flynn is the good AI
	AI Clu; //Clu is the less good AI
	
	
	/*	
	 * 	Constructor to initialize a new game
	 * 	with a new tile set
	 */
	public GameLoop(String[] tileSet, int startRotation){
		//initializes tile creation engine
		tileEngine = new TileCreator();
		// Initializes the game
		game = new Game(BOARD_WIDTH, BOARD_LENGTH);
				
		//initializes starting position
		game.addPlaceable(BOARD_WIDTH / 2, BOARD_LENGTH / 2);
		
		//places starting tile
		Tile temp = tileEngine.create(tileSet[0]);
		temp.Rotate(startRotation);
		game.addToBoard(BOARD_WIDTH / 2, BOARD_LENGTH / 2, temp);
		//fills up the game deck
		for(int i = 1; i < tileSet.length; i++){
			game.addToDeck(tileEngine.create(tileSet[i]));
		}
		
		//sets myTerritories created by the tile engine
		game.setTerritories(tileEngine.getMyTerritories());
		game.setMyTerritoriesSize(tileEngine.getTerritoriesSize());
		
		// Starter location is added as a placeablePos, starter tile is then
		// automatically placed and the placed/placeable array lists are updated
		game.updatePlaceable(BOARD_WIDTH / 2, BOARD_LENGTH / 2);
		game.addContainedTile(game.getTile(BOARD_WIDTH / 2, BOARD_LENGTH / 2), BOARD_WIDTH / 2, BOARD_LENGTH / 2);
		
		player1 = new Player(1);
		player2 = new Player(2);
		currentDens = new ArrayList<Integer>();
		
		Flynn = new AI(game.getDeck());
		Clu = new AI(game.getDeck());
	}
	
	/*
	 * Method to make player1 moves from ManualPlay controller
	 */
	public void manualMove1(){
		Tile myTile = game.nextTile();
		
		int degree = 0, x = 0, y = 0;
		System.out.println("Enter x coordinate: ");
		x = sc.nextInt();
		System.out.println("Enter y coordinate: ");
		y = sc.nextInt();
		System.out.println("Enter clockwise rotation (0, 1, 2 or 3): ");
		degree = sc.nextInt();
		int tempX = x;
    	x = (GameLoop.BOARD_WIDTH / 2) - y;
    	y = (GameLoop.BOARD_LENGTH / 2) + tempX;
		myTile.Rotate(degree);
		game.addContainedTile(myTile, x, y);
		game.mergeTile(myTile, currentDens, x, y);
		ArrayList<Integer> availableTigerLoc = new ArrayList<Integer>();
		ArrayList<Integer> zoneIndex = new ArrayList<Integer>();
		ArrayList<Character> tigerTerritory = new ArrayList<Character>();
		
		System.out.println("Enter 1(place Tiger) 2(place crocodile) or 3(no placement): ");
		int choice = sc.nextInt();
		System.out.println("Enter tiger zone placemnet(0 if no tiger): ");
		int zone = sc.nextInt();
		if(choice == 1){
			game.tigerPlacementLoc(myTile, availableTigerLoc, zoneIndex, tigerTerritory);
			game.tigerPlacementAI(myTile, player1, zone, availableTigerLoc, zoneIndex);	
		} 
		else if(choice == 2){
			if(game.crocodilePlaceable(myTile) == true && player1.numCrocodiles > 0){
				game.crocodilePlacement(myTile, player1, x, y);
			}
		}
		game.midGameScoringPrint(myTile, currentDens, player1, player2, x, y);
		game.addToBoard(x, y, myTile);
		game.updatePlaceable(x, y);
	}
	
	/*
	 * Method to make player1 moves from ManualPlay controller
	 */
	public void manualMove2(){
		Tile myTile = game.nextTile();
		
		int degree = 0, x = 0, y = 0;
		System.out.println("Enter x coordinate: ");
		x = sc.nextInt();
		System.out.println("Enter y coordinate: ");
		y = sc.nextInt();
		System.out.println("Enter clockwise rotation (0, 1, 2 or 3): ");
		degree = sc.nextInt();
		int tempX = x;
    	x = (GameLoop.BOARD_WIDTH / 2) - y;
    	y = (GameLoop.BOARD_LENGTH / 2) + tempX;
		myTile.Rotate(degree);
		game.addContainedTile(myTile, x, y);
		game.mergeTile(myTile, currentDens, x, y);
		ArrayList<Integer> availableTigerLoc = new ArrayList<Integer>();
		ArrayList<Integer> zoneIndex = new ArrayList<Integer>();
		ArrayList<Character> tigerTerritory = new ArrayList<Character>();
		
		System.out.println("Enter 1(place Tiger) 2(place crocodile) or 3(no placement): ");
		int choice = sc.nextInt();
		System.out.println("Enter tiger zone placemnet(0 if no tiger): ");
		int zone = sc.nextInt();
		if(choice == 1){
			game.tigerPlacementLoc(myTile, availableTigerLoc, zoneIndex, tigerTerritory);
			game.tigerPlacementAI(myTile, player2, zone, availableTigerLoc, zoneIndex);	
		} 
		else if(choice == 2){
			if(game.crocodilePlaceable(myTile) == true && player2.numCrocodiles > 0){
				game.crocodilePlacement(myTile, player2, x, y);
			}
		}
		game.midGameScoringPrint(myTile, currentDens, player1, player2, x, y);
		game.addToBoard(x, y, myTile);
		game.updatePlaceable(x, y);
	}
	
	/*
	 * Method to make move for the Flynn AI
	 */
	public int[] makeMoveClu(String tile){
		int move[] = new int[5];
		Tile myTile = game.nextTile();
		move = Clu.randomGreed(game.getBoard(), myTile, game.getPlaceable(), game, player1.numTigers);
		int degree = 0, x = 0, y = 0;
		if(move[0] == -1){
			return move;
		}
		degree = move[0];
		myTile.Rotate(degree);
		x = move[1];
		y = move[2];
		game.addContainedTile(myTile, x, y);
		game.mergeTile(myTile, currentDens, x, y);
		ArrayList<Integer> availableTigerLoc = new ArrayList<Integer>();
		ArrayList<Integer> zoneIndex = new ArrayList<Integer>();
		ArrayList<Character> tigerTerritory = new ArrayList<Character>();
		
		game.tigerPlacementLoc(myTile, availableTigerLoc, zoneIndex, tigerTerritory);
		int[] animalPlacement = new int[2];
		animalPlacement = Clu.animalPlacementAI(game, myTile, game.getTerritories(), game.getTerPtr(), availableTigerLoc, zoneIndex, player1);
		int choice = animalPlacement[0];
		move[3] = animalPlacement[0];
		move[4] = 0;

		if(choice == 1){
			if(player1.numTigers > 0){		
				move[4] = animalPlacement[1];
				game.tigerPlacementAI(myTile, player1, move[4], availableTigerLoc, zoneIndex);
			}
		} 
		else if(choice == 2){
			if(game.crocodilePlaceable(myTile) == true && player1.numCrocodiles > 0){
				game.crocodilePlacement(myTile, player1, x, y);
			}
		}
		game.midGameScoringPrint(myTile, currentDens, player1, player2, x, y);
		game.addToBoard(x, y, myTile);
		game.updatePlaceable(x, y);
		
		return move;
	}
	
	/*	Method to make move for the Flynn AI
	 *	move[] = { rotation, x, y, placement, zone } 
	 */
	public int[] makeMoveFlynn(String tile){
		int move[] = new int[5];
		Tile myTile = game.nextTile();
		//change decision parameters if using Flynn
		move = Flynn.decision(game.getBoard(), myTile, game.getPlaceable(), game, player1, player2);
		int degree = 0, x = 0, y = 0;
		if(move[0] == -1){
			return move;
		}
		degree = move[0];
		myTile.Rotate(degree);
		x = move[1];
		y = move[2];
		game.addContainedTile(myTile, x, y);
		game.mergeTile(myTile, currentDens, x, y);
		ArrayList<Integer> availableTigerLoc = new ArrayList<Integer>();
		ArrayList<Integer> zoneIndex = new ArrayList<Integer>();
		ArrayList<Character> tigerTerritory = new ArrayList<Character>();
		
		int choice = move[3];

		if(choice == 1){
			if(player1.numTigers > 0){		
				game.tigerPlacementLoc(myTile, availableTigerLoc, zoneIndex, tigerTerritory);
				game.tigerPlacementAI(myTile, player1, move[4], availableTigerLoc, zoneIndex);
			}
		} 
		else if(choice == 2){
			if(game.crocodilePlaceable(myTile) == true && player1.numCrocodiles > 0){
				game.crocodilePlacement(myTile, player1, x, y);
			}
		}
		game.midGameScoringPrint(myTile, currentDens, player1, player2, x, y);
		game.addToBoard(x, y, myTile);
		game.updatePlaceable(x, y);
		
		return move;
	}
	
	/*	method to place move for the opponent player
	 * 	move[] = { rotation, x, y, placement, zone } 
	 */
	public void opponentMove(String tile, int[] move){
		Tile myTile = game.nextTile();
		int degree = 0, x = 0, y = 0;
		degree = move[0];
		myTile.Rotate(degree);
		x = move[1];
		y = move[2];
		game.addContainedTile(myTile, x, y);
		game.mergeTile(myTile, currentDens, x, y);
		ArrayList<Integer> availableTigerLoc = new ArrayList<Integer>();
		ArrayList<Integer> zoneIndex = new ArrayList<Integer>();
		ArrayList<Character> tigerTerritory = new ArrayList<Character>();
		int choice = move[3];
		if(choice == 1){
			game.tigerPlacementLoc(myTile, availableTigerLoc, zoneIndex, tigerTerritory);
			game.tigerPlacementAI(myTile, player2, move[4], availableTigerLoc, zoneIndex);	
		} 
		else if(choice == 2){
			if(game.crocodilePlaceable(myTile) == true && player2.numCrocodiles > 0){
				game.crocodilePlacement(myTile, player2, x, y);
			}
		}
		game.midGameScoringPrint(myTile, currentDens, player1, player2, x, y);
		game.addToBoard(x, y, myTile);
		game.updatePlaceable(x, y);
		
	}
	
	public void scoreEndGame(){
		System.out.println("End Game Score is: ");
		game.endGameScoringPrint(player1, player2);
		Printer.printScores(player1, player2);
		Printer.printBoard(game.getBoard(), game.getPlaced(), game.getTerritories(), game.getTerPtr());
	}
	
	public void removeUnplaceable(){
		game.nextTile();
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Initializes the array lists that contain placed positions and
		// placeable positions
		Scanner sc = new Scanner(System.in);	
		
		
		//initializes tile creation engine
		TileCreator tileEngine = new TileCreator();
		
		// Initializes the game
		Game game = new Game(BOARD_WIDTH, BOARD_LENGTH);
				
		//initializes starting position
		game.addPlaceable(BOARD_WIDTH / 2, BOARD_LENGTH / 2);
		
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
						game.tigerPlacement(myTile, player2, sc);
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
						game.tigerPlacement(myTile, player1, sc);
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
		
		game.endGameScoring( player1, player2);
		Printer.printScores(player1, player2);
		
		
		//Printer.printArrayList(ter18.containedTiles);
	}*/
}
