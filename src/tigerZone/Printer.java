package tigerZone;

import java.util.ArrayList;

public class Printer {
	// Method for printing out all of the placeable positions in (X,Y)
	// coordinate form. Outputs to user for tile placement selection
	public static void printPlaceable(ArrayList<ArrayCoord> placeablePos) {
		int size = placeablePos.size();
		if (size < 1) {
			System.out.println("There are no placeable positions available");
		} 
		else {

			System.out.print("The placeable positions are: ");
			printArrayList(placeablePos);
		}

	}

	// Method for printing out all of the placed positions in (X,Y) coordinate
	// form. Only used for testing
	public static void printPlaced(ArrayList<ArrayCoord> placedPos) {

		System.out.print("The placed positions are: ");
		printArrayList(placedPos);
	}

	static void printTile(Tile tile) {
		// System.out.print(tile.id);
		
		System.out.println(" " + tile.subtiles[0].territory + tile.subtiles[1].territory + tile.subtiles[2].territory + " ");
		System.out.println(tile.subtiles[11].territory + "   " + tile.subtiles[3].territory);
		System.out.println(tile.subtiles[10].territory + " " + tile.subtiles[12].territory + " " + tile.subtiles[4].territory);
		System.out.println(tile.subtiles[9].territory + "   " + tile.subtiles[5].territory);
		System.out.println(" " + tile.subtiles[8].territory + tile.subtiles[7].territory + tile.subtiles[6].territory + " ");
		System.out.println();
	}
	
	static char[] subtilePrintFormatter(Tile tile)
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
							System.out.print(subtilePrintFormatter(board[i][j])[k]);
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
	
	static String[] idPrintFormatter(Tile tile)
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
							System.out.printf("%2s", idPrintFormatter(board[i][j])[k]);
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
