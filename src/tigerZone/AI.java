package tigerZone;

import java.util.ArrayList;

public class AI {
	int RotationValue;
	int XPlacement;
	int YPlacement;
	
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
	
	public int[] decision(Tile[][] bored, Tile t, ArrayList<ArrayCoord> placeable){
		
		AI Flynn = new AI();
		
		int[] PlacementArray = new int[placeable.size()*4];
		
		//Assigning values to certain moves, making invalid moves -1
		
		PlacementArray[10] = 50;
		PlacementArray[2] = 5;
		
		int bestMove = -1;
		
		for(int y = 0; y < PlacementArray.length; y++){
			if(bestMove < PlacementArray[y]){
				bestMove = y;
			}
		}
		
		Flynn.setRotationValue(bestMove%4);
		
		bestMove = bestMove/4;
		
		Flynn.setXPlacement(placeable.get(bestMove).x);
		Flynn.setYPlacement(placeable.get(bestMove).y);
		
		int d[] = new int[3];
		d[0] = Flynn.getRotationValue();
		d[1] = Flynn.getXPlacement();
		d[2] = Flynn.getYPlacement();
		return d;
		
		
	}
	
}