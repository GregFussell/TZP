package tigerZone;

import java.util.ArrayList;
import java.util.Random;

public class AI {
	int RotationValue;
	int XPlacement;
	int YPlacement;
	Tile[][] boardView;
	Deck deck;
	
	// CONSTRUCTOR
	public AI(Deck newDeck){
		deck = newDeck;
	}
	
	public void setRotationValue(int rot){
		RotationValue = rot;
	}
	
	public void setXPlacement(int xval){
		XPlacement = xval;
	}
	
	public void setYPlacement(int yval){
		YPlacement = yval;
	}
	
	public int getRotationValue(){
		return RotationValue;
	}
	
	public int getXPlacement(){
		return XPlacement;
	}
	
	public int getYPlacement(){
		return YPlacement;
	}
	
	public int[] decision(Tile[][] board, Tile t, ArrayList<ArrayCoord> placeable){
		
		int[] PlacementArray = new int[placeable.size()*4];
		this.boardView = board;
		
		//Assigning values to certain moves, making invalid moves -1
		boolean isvalid = true;
		for(int i = 0; i < placeable.size(); i++){
			for(int j = 0; j < 4; j++){
				isvalid = Game.validPlacement(t, board, placeable, placeable.get(i).x, placeable.get(i).y);
				t.Rotate(1);
				if (!isvalid){
					PlacementArray[(4*i)+j] = -1;
				}
			}
		}
		
		//Rando
		Random rn = new Random();
		for(int i = 0; i < PlacementArray.length; i++){
			if(PlacementArray[i] != -1){
				PlacementArray[i] = rn.nextInt(50);
			}
		}
		
		//////TEST PRITING//////////
		for(int i = 0; i < PlacementArray.length; i++){
			System.out.print(PlacementArray[i] + " ");
		}
		Printer.printPlaceable(placeable);
		////////////////////////////
		
		PlacementArray[10] = 1;
		
		int bestMove = -1;
		int bestMoveindex = 0;
		
		for(int y = 0; y < PlacementArray.length; y++){
			if(bestMove < PlacementArray[y]){
				bestMoveindex = y;
				bestMove = PlacementArray[y];
			}
		}
		
		setRotationValue(bestMoveindex%4);
		
		bestMoveindex = bestMoveindex/4;
		
		setXPlacement(placeable.get(bestMoveindex).x);
		setYPlacement(placeable.get(bestMoveindex).y);
		int d[] = new int[3];
		d[0] = getRotationValue();
		d[1] = getXPlacement();
		d[2] = getYPlacement();
		return d;
		
		
	}
	
}