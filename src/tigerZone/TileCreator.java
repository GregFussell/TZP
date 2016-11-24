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
	
	int count;
	
	//Defines an empty ArrayList for non jungle tiles
	ArrayList<Integer> noBorderLakes = new ArrayList<Integer>();
	ArrayList<Integer> noBorderDens = new ArrayList<Integer>();
	
	public TileCreator()
	{
		count = 0;
		//Creates a blank territory for tiles with no defining center (12 index)
		Territory ter = new Territory(count, ' ', 0, noPreyAnim, noBorderLakes, noBorderDens);
		myTerritories[count] = ter;
		count++;
	}
	
	public Tile create(String toCreate){
		Tile created = null;
		int[] territories = new int[13];
		
		switch(toCreate){
		case "JJJJ-":
			Territory ter1 = new Territory(count, 'j', 0, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter1;
			territories[0] = count;
			territories[1] = count;
			territories[2] = count;
			territories[3] = count;
			territories[4] = count;
			territories[5] = count;
			territories[6] = count;
			territories[7] = count;
			territories[8] = count;
			territories[9] = count;
			territories[10] = count;
			territories[11] = count;
			territories[12] = 0;
			
			created = new Tile(territories, "JJJJ-");
			count++;
			break;
		case "JJJJX":

			Territory ter2 = new Territory(count, 'd', 0, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter2;
			ArrayList<Integer> borderDen = new ArrayList<Integer>();
			borderDen.add(count);
			count++;
			Territory ter3 = new Territory(count, 'j', 0, noPreyAnim, noBorderLakes, borderDen); myTerritories[count] = ter3;
			territories[0] = count;
			territories[1] = count;
			territories[2] = count;
			territories[3] = count;
			territories[4] = count;
			territories[5] = count;
			territories[6] = count;
			territories[7] = count;
			territories[8] = count;
			territories[9] = count;
			territories[10] = count;
			territories[11] = count;
			territories[12] = count-1;
			
			created = new Tile(territories, "JJJJX");
			count++;	
			break;
		case "JJTJX":
			Territory ter4 = new Territory(count, 'd', 0, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter4;
			ArrayList<Integer> borderDen1 = new ArrayList<Integer>();
			borderDen1.add(count);
			count++;
			Territory ter5 = new Territory(count, 't', 1, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter5;
			count++;
			Territory ter6 = new Territory(count, 'j', 0, noPreyAnim, noBorderLakes, borderDen1); myTerritories[count] = ter6;
			
			territories[0] = count;
			territories[1] = count;
			territories[2] = count;
			territories[3] = count;
			territories[4] = count;
			territories[5] = count;
			territories[6] = count;
			territories[7] = count-1;
			territories[8] = count;
			territories[9] = count;
			territories[10] = count;
			territories[11] = count;
			territories[12] = count-2;
			
			created = new Tile(territories, "JJTJX");
			count++;
			break;
		case "TTTT-":
			Territory ter7 = new Territory(count, 'j', 0, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter7;
			count++;
			Territory ter8 = new Territory(count, 't', 1, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter8;
			count++;
			Territory ter9 = new Territory(count, 'j', 0, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter9;
			count++;
			Territory ter10 = new Territory(count, 't', 1, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter10;
			count++;
			Territory ter11 = new Territory(count, 'j', 0, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter11;
			count++;
			Territory ter12 = new Territory(count, 't', 1, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter12;
			count++;
			Territory ter13 = new Territory(count, 'j', 0, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter13;
			count++;
			Territory ter14 = new Territory(count, 't', 1, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter14;
			
			territories[0] = count-7;
			territories[1] = count-6;
			territories[2] = count-5;
			territories[3] = count-5;
			territories[4] = count-4;
			territories[5] = count-3;
			territories[6] = count-3;
			territories[7] = count-2;
			territories[8] = count-1;
			territories[9] = count-1;
			territories[10] = count;
			territories[11] = count-7;
			territories[12] = 0;
			
			created = new Tile(territories, "TTTT-");
			count++;
			break;
		case "TJTJ-":
			Territory ter15 = new Territory(count, 'j', 0, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter15;//East jungle
			count++;
			Territory ter16 = new Territory(count, 't', 2, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter16;//Road
			count++;
			Territory ter17 = new Territory(count, 'j', 0, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter17;//West Jungle
			
			territories[0] = count-2;
			territories[1] = count-1;
			territories[2] = count;
			territories[3] = count;
			territories[4] = count;
			territories[5] = count;
			territories[6] = count;
			territories[7] = count-1;
			territories[8] = count-2;
			territories[9] = count-2;
			territories[10] = count-2;
			territories[11] = count-2;
			territories[12] = 0;
			
			created = new Tile(territories, "TJTJ-");
			count++;
			break;
		case "TJJT-":
			Territory ter18 = new Territory(count, 'j', 0, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter18;
			count++;
			Territory ter19 = new Territory(count, 't', 2, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter19;
			count++;
			Territory ter20 = new Territory(count, 'j', 0, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter20;
			
			territories[0] = count-2;
			territories[1] = count-1;
			territories[2] = count;
			territories[3] = count;
			territories[4] = count;
			territories[5] = count;
			territories[6] = count;
			territories[7] = count;
			territories[8] = count;
			territories[9] = count;
			territories[10] = count-1;
			territories[11] = count-2;
			territories[12] = 0;
			
			created = new Tile(territories, "TJJT-");
			count++;
			break;
		case "TJTT-":
			Territory ter21 = new Territory(count, 'j', 0, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter21;
			count++;
			Territory ter22 = new Territory(count, 't', 1, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter22;
			count++;
			Territory ter23 = new Territory(count, 'j', 0, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter23;
			count++;
			Territory ter24 = new Territory(count, 't', 1, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter24;
			count++;
			Territory ter25 = new Territory(count, 'j', 0, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter25;
			count++;
			Territory ter26 = new Territory(count, 't', 1, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter26;
			
			territories[0] = count-5;
			territories[1] = count-4;
			territories[2] = count-3;
			territories[3] = count-3;
			territories[4] = count-3;
			territories[5] = count-3;
			territories[6] = count-3;
			territories[7] = count-2;
			territories[8] = count-1;
			territories[9] = count-1;
			territories[10] = count;
			territories[11] = count-5;
			territories[12] = 0;
			
			created = new Tile(territories, "TJJT-");
			count++;
			break;
		case "LLLL-":
			Territory ter27 = new Territory(count, 'l', 4, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter27;
			
			territories[0] = count;
			territories[1] = count;
			territories[2] = count;
			territories[3] = count;
			territories[4] = count;
			territories[5] = count;
			territories[6] = count;
			territories[7] = count;
			territories[8] = count;
			territories[9] = count;
			territories[10] = count;
			territories[11] = count;
			territories[12] = 0;
			
			created = new Tile(territories, "LLLL-");
			count++;
			break;
		case "JLLL-":
			Territory ter28 = new Territory(count, 'l', 4, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter28;
			ArrayList<Integer> borderLake = new ArrayList<Integer>();
			borderLake.add(count);
			count++;
			Territory ter29 = new Territory(count, 'j', 0, noPreyAnim, borderLake, noBorderDens); myTerritories[count] = ter29;
			
			territories[0] = count;
			territories[1] = count;
			territories[2] = count;
			territories[3] = count-1;
			territories[4] = count-1;
			territories[5] = count-1;
			territories[6] = count-1;
			territories[7] = count-1;
			territories[8] = count-1;
			territories[9] = count-1;
			territories[10] = count-1;
			territories[11] = count-1;
			territories[12] = 0;
			
			created = new Tile(territories, "JLLL-");
			count++;
			break;
		case "LLJJ-":
			Territory ter30 = new Territory(count, 'l', 2, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter30;
			ArrayList<Integer> borderLake1 = new ArrayList<Integer>();
			borderLake1.add(count);
			count++;
			Territory ter31 = new Territory(count, 'j', 0, noPreyAnim, borderLake1, noBorderDens); myTerritories[count] = ter31;
			
			territories[0] = count-1;
			territories[1] = count-1;
			territories[2] = count-1;
			territories[3] = count-1;
			territories[4] = count-1;
			territories[5] = count-1;
			territories[6] = count;
			territories[7] = count;
			territories[8] = count;
			territories[9] = count;
			territories[10] = count;
			territories[11] = count;
			territories[12] = 0;
			
			created = new Tile(territories, "LLJJ-");
			count++;
			break;
		case "JLJL-":
			Territory ter32 = new Territory(count, 'l', 2, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter32;
			ArrayList<Integer> borderLake2 = new ArrayList<Integer>();
			borderLake2.add(count);
			count++;
			Territory ter33 = new Territory(count, 'j', 0, noPreyAnim, borderLake2, noBorderDens); myTerritories[count] = ter33;
			count++;
			Territory ter34 = new Territory(count, 'j', 0, noPreyAnim, borderLake2, noBorderDens); myTerritories[count] = ter34;
			
			territories[0] = count;
			territories[1] = count;
			territories[2] = count;
			territories[3] = count-2;
			territories[4] = count-2;
			territories[5] = count-2;
			territories[6] = count-1;
			territories[7] = count-1;
			territories[8] = count-1;
			territories[9] = count-2;
			territories[10] = count-2;
			territories[11] = count-2;
			territories[12] = 0;
			
			created = new Tile(territories, "JLJL-");
			count++;
			break;
		case "LJLJ-":
			Territory ter35 = new Territory(count, 'l', 1, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter35;
			ArrayList<Integer> borderLake3 = new ArrayList<Integer>();
			borderLake3.add(count);
			count++;
			Territory ter36 = new Territory(count, 'l', 1, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter36;
			borderLake3.add(count);
			count++;
			Territory ter37 = new Territory(count, 'j', 0, noPreyAnim, borderLake3, noBorderDens); myTerritories[count] = ter37;
			
			territories[0] = count-2;
			territories[1] = count-2;
			territories[2] = count-2;
			territories[3] = count;
			territories[4] = count;
			territories[5] = count;
			territories[6] = count-1;
			territories[7] = count-1;
			territories[8] = count-1;
			territories[9] = count;
			territories[10] = count;
			territories[11] = count;
			territories[12] = 0;
			
			created = new Tile(territories, "LJLJ-");
			count++;
			break;
		case "LJJJ-":
			Territory ter38 = new Territory(count, 'l', 1, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter38;
			ArrayList<Integer> borderLake4 = new ArrayList<Integer>();
			borderLake4.add(count);
			count++;
			Territory ter39 = new Territory(count, 'j', 0, noPreyAnim, borderLake4, noBorderDens); myTerritories[count] = ter39;
			
			territories[0] = count-1;
			territories[1] = count-1;
			territories[2] = count-1;
			territories[3] = count;
			territories[4] = count;
			territories[5] = count;
			territories[6] = count;
			territories[7] = count;
			territories[8] = count;
			territories[9] = count;
			territories[10] = count;
			territories[11] = count;
			territories[12] = 0;
			
			created = new Tile(territories, "LJJJ-");
			count++;
			break;
		case "JLLJ-":
			Territory ter40 = new Territory(count, 'l', 1, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter40;
			ArrayList<Integer> borderLake5 = new ArrayList<Integer>();
			borderLake5.add(count);
			count++;
			Territory ter41 = new Territory(count, 'l', 1, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter41;
			borderLake5.add(count);
			count++;
			Territory ter42 = new Territory(count, 'j', 0, noPreyAnim, borderLake5, noBorderDens); myTerritories[count] = ter42;
			
			territories[0] = count;
			territories[1] = count;
			territories[2] = count;
			territories[3] = count-2;
			territories[4] = count-2;
			territories[5] = count-2;
			territories[6] = count-1;
			territories[7] = count-1;
			territories[8] = count-1;
			territories[9] = count;
			territories[10] = count;
			territories[11] = count;
			territories[12] = 0;
			
			created = new Tile(territories, "JLLJ-");
			count++;
			break;
		case "TLJT-":
			Territory ter43 = new Territory(count, 'l', 1, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter43;
			ArrayList<Integer> borderLake6 = new ArrayList<Integer>();
			borderLake6.add(count);
			count++;
			Territory ter44 = new Territory(count, 'j', 0, noPreyAnim, borderLake6, noBorderDens); myTerritories[count] = ter44;
			count++;
			Territory ter45 = new Territory(count, 't', 2, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter45;
			count++;
			Territory ter46 = new Territory(count, 'j', 0, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter46;
			
			territories[0] = count;
			territories[1] = count-1;
			territories[2] = count-2;
			territories[3] = count-3;
			territories[4] = count-3;
			territories[5] = count-3;
			territories[6] = count-2;
			territories[7] = count-2;
			territories[8] = count-2;
			territories[9] = count-2;
			territories[10] = count-1;
			territories[11] = count;
			territories[12] = 0;
			
			created = new Tile(territories, "TLJT-");
			count++;
			break;
		case "TLJTP":
			Territory ter47 = new Territory(count, 'l', 1, boar, noBorderLakes, noBorderDens); myTerritories[count] = ter47;
			ArrayList<Integer> borderLake7 = new ArrayList<Integer>();
			borderLake7.add(count);
			count++;
			Territory ter48 = new Territory(count, 'j', 0, noPreyAnim, borderLake7, noBorderDens); myTerritories[count] = ter48;
			count++;
			Territory ter49 = new Territory(count, 't', 2, boar, noBorderLakes, noBorderDens); myTerritories[count] = ter49;
			count++;
			Territory ter50 = new Territory(count, 'j', 0, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter50;
			
			territories[0] = count;
			territories[1] = count-1;
			territories[2] = count-2;
			territories[3] = count-3;
			territories[4] = count-3;
			territories[5] = count-3;
			territories[6] = count-2;
			territories[7] = count-2;
			territories[8] = count-2;
			territories[9] = count-2;
			territories[10] = count-1;
			territories[11] = count;
			territories[12] = 0;
			
			created = new Tile(territories, "TLJTP");
			count++;
			
			break;
		case "JLTT-":
			
			break;
		case "JLTTB":
			
			break;
		case "TLTJ-":
			
			break;
		case "TLTJD":
//			ArrayList<Integer> borderLake = new ArrayList<Integer>();
//			borderLake.add(1);
//			
//			Territory ter1 = new Territory(1, 'l', 1, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[1] = ter1;//East lake
//			Territory ter2 = new Territory(2, 'j', 2, noPreyAnim, borderLake, noBorderDens); myTerritories[2] = ter2;//East Jungle
//			Territory ter3 = new Territory(3, 't', 2, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[3] = ter3;//Road
//			Territory ter4 = new Territory(4, 'j', 3, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[4] = ter4;//West Jungle
//			
//			territories[0] = 4;
//			territories[1] = 3;
//			territories[2] = 2;
//			territories[3] = 1;
//			territories[4] = 1;
//			territories[5] = 1;
//			territories[6] = 2;
//			territories[7] = 3;
//			territories[8] = 4;
//			territories[9] = 4;
//			territories[10] = 4;
//			territories[11] = 4;
//			territories[12] = 0;
//			
//			created = new Tile(territories, 1);
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
