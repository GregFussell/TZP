package tigerZone;
//hello
//test
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	Tile[][] board = new Tile[160][160];
	public Game()
	{
		
	}
	public Game(Tile[][] board,ArrayList<ArrayCoord> placeablePos){
		
	}
	
	public void Placement(Tile tile, ArrayCoord location){
		//if is valid move
		board[location.x][location.y] = tile;
		
		if(location.x>0 && board[location.x-1][location.y] !=null)
			merge(board[location.x-1][y], tile);//should be left
	}
	public void merge(Tile existing, Tile brandNew){
		existing.subtiles[4][2]//rename for clarity, [4][2] is the middle of the right side
	}
	public void dfs(Subtile subtile, TerritoryPointer terP){
		
	}


}
