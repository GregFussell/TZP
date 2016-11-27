package tigerZone;

import java.util.ArrayList;

import java.util.Random;

public class AI {
	int RotationValue;
	int XPlacement;
	int YPlacement;
	int Animal_Placement;
	int Tiger_ZoneNum;
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
	
	public void setAnimal_Placement(int zoneNum){
		Animal_Placement = zoneNum;
	}
	
	public void setTiger_ZoneNum(int crocNum){
		Tiger_ZoneNum = crocNum;
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
	
	public int getAnimal_Placement(){
		return Animal_Placement;
	}
	
	public int getTiger_ZoneNum(){
		return Tiger_ZoneNum;
	}
	
	public void rank( int[] PlacementArray ){
		
	}
	
	public int[] decision(Tile[][] board, Tile t, ArrayList<ArrayCoord> placeable, Game game, Integer numTigers){
		
		ArrayList<Integer> currentDens = new ArrayList<Integer>();
		
		Game copy = new Game(155,155);
		
		int priority = 0;
		
		int[] PlacementArray = new int[placeable.size()*4];
		int[] animalPlacementArray = new int[placeable.size()*4];
		this.boardView = board;
		//Assigning values to certain moves, making invalid moves -1
		boolean isvalid = true;
		for(int i = 0; i < placeable.size(); i++){
			for(int j = 0; j < 4; j++){
				PlacementArray[(4*i) + j] = 0;
				animalPlacementArray[(4*i)+j] = 0;
				isvalid = game.validPlacement(t, placeable.get(i).x, placeable.get(i).y);
				if (!isvalid){
					PlacementArray[(4*i)+j] = -1;
					animalPlacementArray[(4*i)+j] = -1;
				}
				else{
					copy.cloneGame(game);
					ArrayList<Integer> availableTigerLoc = new ArrayList<Integer>();
					ArrayList<Integer> zoneIndex = new ArrayList<Integer>();
					ArrayList<Character> tigerTerritory = new ArrayList<Character>();
					copy.addContainedTile(t, placeable.get(i).x, placeable.get(i).y);
					copy.mergeTile(t, currentDens, placeable.get(i).x, placeable.get(i).y);
					copy.tigerPlacementLoc(t, availableTigerLoc, zoneIndex, tigerTerritory);
					priority = 0;
					
					//places a tiger if there is a den zone
					for(int p = 0; p < zoneIndex.size(); p++){	
						if(zoneIndex.get(p) == 5 && numTigers > 2){
							animalPlacementArray[(4*i)+j] = 5;
							priority = 5;
							continue;
						}
						
						// If no den, and lake place a tiger while numTigers is higher than 3
						else if(tigerTerritory.get(p) == 'l' && numTigers > 3 && priority < 5){
							animalPlacementArray[(4*i)+j] = zoneIndex.get(p);
							priority = 4;
							continue;
						}
						// If no lake, and trail place a tiger while numTigers is higher than 4
						else if(tigerTerritory.get(p) == 't' && numTigers > 4 && priority < 4){
							animalPlacementArray[(4*i)+j] = zoneIndex.get(p);
							//System.out.println(zoneIndex.get(p));
							priority = 3;
							continue;
						}
						// If no trail, and jungle place a tiger while numTigers is higher than 5
						else if(tigerTerritory.get(p) == 'j' && numTigers > 5 && priority < 3){
							animalPlacementArray[(4*i)+j] = zoneIndex.get(p);
							priority = 2;
							continue;
						}
						
					}
					
				}
				t.Rotate(1);
			}
		}
		
	
		//to replace random ranking with intelligent ranking
		//rank(PlacementArray);
		
		//Rando
		Random rn = new Random();
		for(int i = 0; i < PlacementArray.length; i++){
			if(PlacementArray[i] != -1){
			PlacementArray[i] = rn.nextInt(50);
			}
		}
		
		//////TEST PRITING//////////
		//for(int i = 0; i < PlacementArray.length; i++){
			//System.out.print(PlacementArray[i] + " ");
		//}
//		Printer.printPlaceable(placeable);
		////////////////////////////
		
		int bestMove = -1;
		int bestMoveindex = 0;
		
		for(int y = 0; y < PlacementArray.length; y++){
			if(bestMove < PlacementArray[y]){
				bestMoveindex = y;
				bestMove = PlacementArray[y];
			}
		}
		
		int d[] = new int[5];
		
		//-1 indicates a pass if there are no valid moves
		if(bestMove == -1){
			d[0] = -1;
			return  d;
		}

		
		d[3] = 3;
		d[4] = 1;
		
		//if the bestMoveindex is 0, it makes no animal placement
		if(animalPlacementArray[bestMoveindex] == 0){
			d[3] = 3;
		}
		
		//if the bestMoveindex is 10, it places a crocodile
		else if(animalPlacementArray[bestMoveindex] == 10){
			d[3] = 2;
		}
		
		//if the bestMoveindex is between 1 and 10, it places a tiger at that zoneNum
		else{
			d[3] = 1;
			d[4] = animalPlacementArray[bestMoveindex];
		}
		
		setRotationValue(bestMoveindex%4);
		
		bestMoveindex = bestMoveindex/4;
		
		setXPlacement(placeable.get(bestMoveindex).x);
		setYPlacement(placeable.get(bestMoveindex).y);
		//1 is Tiger, 2 is Crocodile, 3 is None
//		setAnimal_Placement(1);
		//integer is the zoneNum for tigerPlacement
//		setTiger_ZoneNum(5);
		d[0] = getRotationValue();
		d[1] = getXPlacement();
		d[2] = getYPlacement();
//		d[3] = getAnimal_Placement();
//		d[4] = getTiger_ZoneNum();
		return d;
		
		
	}
	
	public int[] randomGreed(Tile[][] board, Tile t, ArrayList<ArrayCoord> placeable, Game game, Integer numTigers){
		
		ArrayList<Integer> currentDens = new ArrayList<Integer>();
		
		Game copy = new Game(155,155);
		
		int priority = 0;
		
		int[] PlacementArray = new int[placeable.size()*4];
		int[] animalPlacementArray = new int[placeable.size()*4];
		this.boardView = board;
		//Assigning values to certain moves, making invalid moves -1
		boolean isvalid = true;
		for(int i = 0; i < placeable.size(); i++){
			for(int j = 0; j < 4; j++){
				PlacementArray[(4*i) + j] = 0;
				animalPlacementArray[(4*i)+j] = 0;
				isvalid = game.validPlacement(t, placeable.get(i).x, placeable.get(i).y);
				if (!isvalid){
					PlacementArray[(4*i)+j] = -1;
					animalPlacementArray[(4*i)+j] = -1;
				}
				//Perhaps place greedy stuff here
				t.Rotate(1);
			}
		}
		
	
		//to replace random ranking with intelligent ranking
		//rank(PlacementArray);
		
		//Rando
		Random rn = new Random();
		for(int i = 0; i < PlacementArray.length; i++){
			if(PlacementArray[i] != -1){
			PlacementArray[i] = rn.nextInt(50);
			}
		}
		
		//////TEST PRITING//////////
		//for(int i = 0; i < PlacementArray.length; i++){
			//System.out.print(PlacementArray[i] + " ");
		//}
//		Printer.printPlaceable(placeable);
		////////////////////////////
		
		int bestMove = -1;
		int bestMoveindex = 0;
		
		for(int y = 0; y < PlacementArray.length; y++){
			if(bestMove < PlacementArray[y]){
				bestMoveindex = y;
				bestMove = PlacementArray[y];
			}
		}
		
		int d[] = new int[5];
		
		//-1 indicates a pass if there are no valid moves
		if(bestMove == -1){
			d[0] = -1;
			return  d;
		}

		
		d[3] = 3;
		d[4] = 1;
		
		//if the bestMoveindex is 0, it makes no animal placement
		if(animalPlacementArray[bestMoveindex] == 0){
			d[3] = 3;
		}
		
		//if the bestMoveindex is 10, it places a crocodile
		else if(animalPlacementArray[bestMoveindex] == 10){
			d[3] = 2;
		}
		
		//if the bestMoveindex is between 1 and 10, it places a tiger at that zoneNum
		else{
			d[3] = 1;
			d[4] = animalPlacementArray[bestMoveindex];
		}
		
		setRotationValue(bestMoveindex%4);
		
		bestMoveindex = bestMoveindex/4;
		
		setXPlacement(placeable.get(bestMoveindex).x);
		setYPlacement(placeable.get(bestMoveindex).y);
		//1 is Tiger, 2 is Crocodile, 3 is None
//		setAnimal_Placement(1);
		//integer is the zoneNum for tigerPlacement
//		setTiger_ZoneNum(5);
		d[0] = getRotationValue();
		d[1] = getXPlacement();
		d[2] = getYPlacement();
//		d[3] = getAnimal_Placement();
//		d[4] = getTiger_ZoneNum();
		return d;
		
		
	}
	
}