package tigerZone;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
//please clap
	public static void updatePlaceable(ArrayList<ArrayCoord> placedPos, 
								ArrayList<ArrayCoord> placeablePos,
								int x, int y)
	{
		for(int i=0;i<placeablePos.size();i++){
			if(x== placeablePos.get(i).x && y == placeablePos.get(i).y){
				placedPos.add(placeablePos.get(i));
				if (placeablePos.remove(placeablePos.get(i)) == true)
				{
					System.out.println("Hello world");
				}	
			}
			else {
				System.out.println("Goodbye world");
			}
		}

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Tile starter = new Tile('j','l','j',
//								't','t','t',
//								'j','j','j',
//								1);
		Tile starter = new Tile( "jljtttjjj", 1 );
		
		Tile[][] board = new Tile[77][77];
		board[36][36]=starter;
		
		ArrayList<ArrayCoord> placeablePos = new ArrayList<ArrayCoord>();
		
		ArrayList<ArrayCoord> placedPos = new ArrayList<ArrayCoord>();
		
		
		
		placeablePos.add(new ArrayCoord(36,36));
		
		updatePlaceable(placedPos, placeablePos, 36, 36);
		
		
		
		
		
		//TESTING
		
		System.out.println(placedPos.get(0).x);
		
		System.out.print(board[36][36].id);
		System.out.println();
		for (int i=0;i<9;i++){
			System.out.print(board[36][36].fields[i].territory + " ");
			if ((i+1)%3==0)
			{
				System.out.println();
			}
			
		}
		
		System.out.println();
		board[36][36].Rotate();
		
		System.out.print(board[36][36].id);
		System.out.println();
		for (int i=0;i<9;i++){
			System.out.print(board[36][36].fields[i].territory + " ");
			if ((i+1)%3==0)
			{
				System.out.println();
			}
			
		}
		printBoard(board);
		
		
				
		}
	static void printBoard(Tile[][] board){
		int x=0;
		for(int i = 0; i<77; i++ ){//i is row
			for(int h = 0; h<3; h++){
			for(int j= 0; j<77; j++){//j is column
					for(int k=x; k<x+3; k++)//k is subtile, x is iteration over tile
					{
						if(board[i][j]==null) System.out.print(" ");
						else System.out.print(board[i][j].fields[k].territory);
						if(k == x+2) System.out.print("|");
					}
			}
				x=x+3;
			System.out.println();
			}
			x=0;
		}
	}
}
	
