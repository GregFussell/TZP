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
		Tile starter = new Tile("jljtttjjj", 1);

		// Initializes the deck with tiles
		Tile A = new Tile("jtjjtjjtj", 2);
		Tile B = new Tile("jjjttjjtj", 3);
		Tile C = new Tile("jtjtjtjtj", 4);
		Tile D = new Tile("lllllljtj", 5);
		Tile E = new Tile("jljjjjjjj", 6);
		Deck myDeck = new Deck(A, B, C, D, E);

		// Initializes the board
		Tile[][] board = new Tile[77][77];
		// Starter location is added as a placeablePos, starter tile is then
		// automatically placed and the placed/placeable array lists are updated
		placeablePos.add(new ArrayCoord(36, 36));
		board[36][36] = starter;
		updatePlaceable(placedPos, placeablePos, 36, 36);

		// Users plays game
		while (myDeck.deck.size() > 0) {
			int x = 0;
			int y = 0;

			System.out.print("The current tile is: ");
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

		printBoard(board);
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
		if (currentBoard[x][y - 1] != null) {
			if (currentTile.subtiles[3].territory != currentBoard[x][y - 1].subtiles[5].territory) {
				return false;
			}
		}
		if (currentBoard[x][y + 1] != null) {
			if (currentTile.subtiles[5].territory != currentBoard[x][y + 1].subtiles[3].territory) {
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
		System.out.println();
		for (int i = 0; i < 9; i++) {
			System.out.print(tile.subtiles[i].territory + " ");
			if ((i + 1) % 3 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}

	static void printBoard(Tile[][] board) {
		int x = 0;
		for (int i = 0; i < 77; i++) {// i is row
			for (int h = 0; h < 3; h++) {
				for (int j = 0; j < 77; j++) {// j is column
					for (int k = x; k < x + 3; k++)// k is subtile, x is
													// iteration over tile
					{
						if (board[i][j] == null)
							System.out.print(" ");
						else
							System.out.print(board[i][j].subtiles[k].territory);
						if (k == x + 2)
							System.out.print("|");
					}
				}
				x = x + 3;
				System.out.println();
			}
			x = 0;
		}
	}
}
