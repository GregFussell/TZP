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
