package tigerZone;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;



public class GameLoop {
	public static final int BOARD_WIDTH = 156;
	public static final int BOARD_LENGTH = 156;
	
	public static void main(String args[]){
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
		start = "TLTJ-";
		String temp[] = {"LLJJ-",
				"TLTJ-",
				"TLLL-",
				"JLLL-",
				"TJTJ-",
				"LLJJ-",
				"JLLJ-",
				"JLTTB",
				"JJTJX",
				"TJTT-",
				"TLJT-",
				"JLLJ-",
				"JLJL-",
				"TJTT-",
				"LLLL-",
				"TJJT-",
				"TLJTP",
				"TLLTB",
				"TLTT-",
				"TLLTB",
				"LJJJ-",
				"JJTJX",
				"JJJJX",
				"TLLT-",
				"TJTJ-",
				"TLTTP",
				"TJTJ-",
				"JLJL-",
				"TJJT-",
				"TLTJD",
				"TJJT-",
				"TJTT-",
				"TJTJ-",
				"LJTJD",
				"TJJT-",
				"TJJT-",
				"TJJT-",
				"TJTJ-",
				"LJJJ-",
				"LJJJ-",
				"TJTJ-",
				"TLTJ-",
				"LLJJ-",
				"TLLT-",
				"TLLLC",
				"JLLL-",
				"TJJT-",
				"TLLLC",
				"TLTJD",
				"LJTJD",
				"JLTT-",
				"TJTT-",
				"LJTJ-",
				"LJLJ-",
				"LJJJ-",
				"TLJTP",
				"JJJJX",
				"JJJJX",
				"JJJJ-",
				"JLJL-",
				"JLLL-",
				"TJJT-",
				"TTTT-",
				"TJTJ-",
				"JLTTB",
				"LLJJ-",
				"JLLL-",
				"JJJJX",
				"TLLT-",
				"LJLJ-",
				"TLTTP",
				"LJJJ-",
				"LLJJ-",
				"TJJT-",
				"LJLJ-",
				"TJTJ-"};
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
		
		AI Clu = new AI(game.getDeck());



Player player1 = new Player(1);
Player player2 = new Player(2);
ArrayList<Integer> currentDens = new ArrayList<Integer>();

int[] t;
t = new int[3];

int[] c;
c = new int[5];


// Jframe here

JFrame window = new JFrame("Game");
canvas panel = new canvas();
window.setPreferredSize(new Dimension(800,800));

window.setContentPane(panel);
window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
window.setResizable(false);
window.pack();
window.setVisible(true);


int position = 400;



///////////////////////////////////////////////////// GAMEPLAY LOOP \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		
	//	printTile(starter);
		int turn = 1;
		long startTime = System.currentTimeMillis();
		// Users plays game
		while (game.deckSize() > 0) {
			
			
			int x = 0;
			int y = 0;
			Tile myTile = game.nextTile();	
			//player2's Turn
			if (turn%2 == 0)
			{	
				c = Clu.randomGreed(game.getBoard(), myTile, game.getPlaceable(), game, player2.numTigers);
				
				if(c[0] == -1){
					game.nextTile();
					System.out.println("Unplaceable Tile");
					continue;
				}

				boolean valid = false;
				while (valid == false) {

//					System.out.println("Please choose a rotation degree for the tile (0, 1, 2, 3)");
					int degree = 0;
					
					degree = c[0];

					myTile.Rotate(degree);

					x = c[1];
					y = c[2];

					valid = game.validPlacement(myTile, x, y);
					if (valid == false) {
//						System.out.println("Invalid placement, please place again");
					} else {
//						System.out.println("Tile successfully placed");
					}
				}
				
				//Adds the coordinate of the tile to the tile
				game.addContainedTile(myTile, x, y);
				
				//Merges Tile contents
				game.mergeTile(myTile, currentDens, x, y);
			}
			
			
			//player1's Turn
			else
			{
				t = Flynn.decision(game.getBoard(), myTile, game.getPlaceable(), game, player1, player2);
//				System.out.println(t[1] + " " + t[2] + " " + t[3] + " " + t[4]);
				
				if(t[0] == -1){
					game.nextTile();
					System.out.println("Unplaceable Tile");
					continue;
				}

				boolean valid = false;
				while (valid == false) {

//					System.out.println("Please choose a rotation degree for the tile (0, 1, 2, 3)");
					int degree = 0;
					
					degree = t[0];
					if(degree > 3){
						System.out.println(degree);
					}
					if(degree < 0){
						System.out.println(degree);
					}

					myTile.Rotate(degree);

					x = t[1];
					y = t[2];

					valid = game.validPlacement(myTile, x, y);
					if (valid == false) {
//						System.out.println("Invalid placement, please place again");
					} else {
//						System.out.println("Tile successfully placed");
					}
				}
				
				//Adds the coordinate of the tile to the tile
				game.addContainedTile(myTile, x, y);
				
				//Merges Tile contents
				game.mergeTile( myTile, currentDens, x, y);
				
			}	
			
			//if there are no available moves, it passes
			

						
			//Crocodile & Tiger placement
			ArrayList<Integer> availableTigerLoc = new ArrayList<Integer>();
			ArrayList<Integer> zoneIndex = new ArrayList<Integer>();
			ArrayList<Character> tigerTerritory = new ArrayList<Character>();

			
			//player2's Turn Clu
			if (turn%2 == 0)
			{
				//RUN GREEED
				//public int[] animalPlacementAI(Game game, Tile currentTile, Territory[] myTerritories, TerritoryPtr terPtr, ArrayList<Integer> availableTigerLoc, ArrayList<Integer> zoneIndex, Player player)
				
				game.tigerPlacementLoc(myTile, availableTigerLoc, zoneIndex, tigerTerritory);
				
				int[] animalPlacement = new int[2];
				
				animalPlacement = Clu.animalPlacementAI(game, myTile, game.getTerritories(), game.getTerPtr(), availableTigerLoc, zoneIndex, player2);
				
				
				int choice;
				choice = animalPlacement[0];
			//	System.out.println("Choice is " + choice);
				
				while (choice != 1 && choice != 2 && choice != 3)
				{
					System.out.println("Invalid input, please enter 1 for tiger, 2 for crocodile, or 3 for none");
//					choice = sc.nextInt();
				}	
				
				//Place tiger
				if (choice == 1)
				{
					if (player2.numTigers > 0)
					{
						game.tigerPlacementLoc(myTile, availableTigerLoc, zoneIndex, tigerTerritory);
						//Do AI stuff
						game.tigerPlacementAI(myTile, player2, animalPlacement[1], availableTigerLoc, zoneIndex);
					}
					else
					{
//						System.out.println("No tigers remaining");
					}
				}
				//Place crocodile
				else if (choice == 2)
				{
					if (game.crocodilePlaceable(myTile) == true && player2.numCrocodiles > 0)
					{
//						System.out.println("A crocodile has been placed on the tile");
						game.crocodilePlacement(myTile, player2, x, y);
					}
					else
					{
//						System.out.println("Crocodile can not be placed or no crocodiles remaining");
					}
				}
				
				
				//Displaying try
				panel.render(myTile.tile, x, y);
			}
			
			
			//player1's Turn
			else
			{
//				System.out.println("The current player has " + player1.numTigers + " tigers and " + player1.numCrocodiles + " crocodiles");	
				int choice;
//				System.out.println("Would you like to place a (1) tiger, (2) crocodile, or (3) none?");
				choice = t[3];
				//choice = sc.nextInt();
				while (choice != 1 && choice != 2 && choice != 3)
				{
//					System.out.println("Invalid input, please enter 1 for tiger, 2 for crocodile, or 3 for none");
					choice = sc.nextInt();
				}	
				
				//Place tiger
				if (choice == 1)
				{
					if (player1.numTigers > 0)
					{
						game.tigerPlacementLoc(myTile, availableTigerLoc, zoneIndex, tigerTerritory);
						//Do AI stuff
						//
						game.tigerPlacementAI(myTile, player1, t[4], availableTigerLoc, zoneIndex);
			
					}
					else
					{
//						System.out.println("No tigers remaining");
					}
				}
				//Place crocodile
				else if (choice == 2)
				{
					if (game.crocodilePlaceable(myTile) == true && player1.numCrocodiles > 0)
					{
//						System.out.println("A crocodile has been placed on the tile");
						game.crocodilePlacement(myTile, player1, x, y);
					}
					else
					{
//						System.out.println("Crocodile can not be placed or no crocodiles remaining");
					}
				}
				
				
				//////////////// displaying try
				panel.render(myTile.tile, x, y);
				
			}
		
			//Scoring
			game.midGameScoring(myTile, currentDens, player1, player2, x, y);
//			if(game.deckSize() == 1 ){
//				System.out.println(player1.score);
//			}
//			
			//Place tile, update positions and turn
			turn++;
			game.addToBoard(x, y, myTile);
			game.updatePlaceable( x, y);
//			System.out.println("P1: " + player1.numTigers + " P2: " + player2.numTigers);
		}

//		Printer.printScores(player1, player2);
		sc.close();		
		final long endTime = System.currentTimeMillis();
//		Printer.printBoard(game.getBoard(), game.getPlaced(), game.getTerritories(), game.getTerPtr());
//		Printer.printBoardID(game.getBoard(), game.getPlaced(), game.getTerritories(), game.getTerPtr());
//		System.out.println("P1: " + player1.numTigers + " P2: " + player2.numTigers);
//		System.out.println("P1: " + player1.numCrocodiles + " P2: " + player2.numCrocodiles);
		
//		System.out.println("Total execution time: " + (endTime - startTime));
		game.endGameScoring(player1, player2);
//		Printer.printScores(player1, player2);
//		System.out.println(player1.score);
		
		//return player1.score - player2.score;
		//Printer.printArrayList(ter18.containedTiles);
		System.out.println("P1: " + player1.score + " P2: " + player2.score);
	}
	

	
}
