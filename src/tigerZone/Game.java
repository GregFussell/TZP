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

		// Creates Starter Tile
		Tile starter = new Tile("llljtjjjjjtjR", 1);

		// Initializes the deck with tiles
		Tile A = new Tile("jtjjjjjtjjjjR", 2);
		Tile B = new Tile("jjjjjjjtjjtjR", 3);
		Tile C = new Tile("jtjjtjjtjjtjR", 4);
		Tile D = new Tile("lllllljtjlllR", 5);
		Tile E = new Tile("llljjjjjjjjjR", 6);
		Deck myDeck = new Deck(A, B, C, D, E);

		// Initializes the board
		Tile[][] board = new Tile[77][77];
		// Starter location is added as a placeablePos, starter tile is then
		// automatically placed and the placed/placeable array lists are updated
		placeablePos.add(new ArrayCoord(36, 36));
		board[36][36] = starter;
		updatePlaceable(placedPos, placeablePos, 36, 36);
		
		
		printTile(starter);

		// Users plays game
		while (myDeck.deck.size() > 0) {
			int x = 0;
			int y = 0;

			System.out.println("The current tile is: ");
			Tile myTile = myDeck.deck.remove();
			printTile(myTile);

			boolean valid = false;
			while (valid == false) {

				System.out.println("Please choose a rotation degree for the tile (0, 1, 2, 3)");
				int degree = sc.nextInt();
				myTile.Rotate(degree);
				if (degree > 0) {
					System.out.println("The current tile is now: ");
					printTile(myTile);
				}

				printPlaceable(placeablePos);
				System.out.println("Please select an X and Y coordinate to place the tile");
				x = sc.nextInt();
				y = sc.nextInt();

				valid = validPlacement(myTile, board, placeablePos, x, y);
				if (valid == false) {
					System.out.println("Invalid placement, please place again");
				} else {
					System.out.println("Tile successfully placed");
				}
			}

			board[x][y] = myTile;
			updatePlaceable(placedPos, placeablePos, x, y);
		}

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

		printBoard(board, placedPos);
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

	static void printTile(Tile tile) {
		// System.out.print(tile.id);
		
		System.out.println(" " + tile.subtiles[0].territory + tile.subtiles[1].territory + tile.subtiles[2].territory + " ");
		System.out.println(tile.subtiles[11].territory + "   " + tile.subtiles[3].territory);
		System.out.println(tile.subtiles[10].territory + " " + tile.subtiles[12].territory + " " + tile.subtiles[4].territory);
		System.out.println(tile.subtiles[9].territory + "   " + tile.subtiles[5].territory);
		System.out.println(" " + tile.subtiles[8].territory + tile.subtiles[7].territory + tile.subtiles[6].territory + " ");
		
		
		
//		System.out.println();
//		for (int i = 0; i < 13; i++) {
//			System.out.print(tile.subtiles[i].territory + " ");
//			if ((i + 1) % 3 == 0) {
//				System.out.println();
//			}
//		}
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
		System.out.println("min x " + minx);
		System.out.println("min y " + miny);
		System.out.println("max x " + maxx);
		System.out.println("max y " + maxy);
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
