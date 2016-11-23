package tigerZone;

import java.util.ArrayList;

public class TileCreator {
	public Territory[] myTerritories = new Territory[246];
	
	//Defines the preyAnimal types for tiles
	boolean[] noPreyAnim = {false, false, false, false };
	boolean[] deer = { true, false, false, false };
	boolean[] boar = { false, true, false, false };
	boolean[] buffalo = { false, false, true, false };
	boolean[] crocodile = { false, false, false, true };
	
	//Defines an empty ArrayList for non jungle tiles
	ArrayList<Integer> noBorderLakes = new ArrayList<Integer>();
	ArrayList<Integer> noBorderDens = new ArrayList<Integer>();
	ArrayList<Integer> borderLake = new ArrayList<Integer>();
	
	public TileCreator()
	{
		Territory ter = new Territory(0, ' ', 0, noPreyAnim, noBorderLakes, noBorderDens);
		myTerritories[0] = ter;
	}
	
	public Tile create(String toCreate){
		Tile created = null;
		int[] territories = new int[13];
		
		switch(toCreate){
		case "JJJJ-":
			
			break;
		case "JJJJX":
			
			break;
		case "JJTJX":
			
			break;
		case "TTTT-":
			
			break;
		case "TJTJ-":
			
			break;
		case "TJJT-":
			
			break;
		case "TJTT-":
			
			break;
		case "LLLL-":
			
			break;
		case "JLLL-":
			
			break;
		case "LLJJ-":
			
			break;
		case "JLJL-":
			
			break;
		case "LJLJ-":
			
			break;
		case "LJJJ-":
			
			break;
		case "JLLJ-":
			
			break;
		case "TLJT-":
			
			break;
		case "TLJTP":
			
			break;
		case "JLTT-":
			
			break;
		case "JLTTB":
			
			break;
		case "TLTJ-":
			
			break;
		case "TLTJD":
			ArrayList<Integer> borderLake = new ArrayList<Integer>();
			borderLake.add(1);
			
			Territory ter1 = new Territory(1, 'l', 1, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[1] = ter1;//East lake
			Territory ter2 = new Territory(2, 'j', 2, noPreyAnim, borderLake, noBorderDens); myTerritories[2] = ter2;//East Jungle
			Territory ter3 = new Territory(3, 't', 2, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[3] = ter3;//Road
			Territory ter4 = new Territory(4, 'j', 3, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[4] = ter4;//West Jungle
			ter1.containedTiles.add(new ArrayCoord (36,36));
			ter2.containedTiles.add(new ArrayCoord (36,36));
			ter3.containedTiles.add(new ArrayCoord (36,36));
			ter4.containedTiles.add(new ArrayCoord (36,36));
			
			territories[0] = 4;
			territories[1] = 3;
			territories[2] = 2;
			territories[3] = 1;
			territories[4] = 1;
			territories[5] = 1;
			territories[6] = 2;
			territories[7] = 3;
			territories[8] = 4;
			territories[9] = 4;
			territories[10] = 4;
			territories[11] = 4;
			territories[12] = 0;
			
			created = new Tile(territories, 1);
			break;
		case "TLLL-":
			
			break;
		case "TLTT-":
			
			break;
		case "TLTTP":
			
			break;
		case "TLLT-":
			
			break;
		case "TLLTB":
			
			break;
		case "LJTJ-":
			
			break;
		case "LJTJD":
			
			break;
		case "TLLLC":
			
			break;
		}
		
		return created;
	}
}
