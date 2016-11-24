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
	
	public Territory[] getMyTerritories(){
		return myTerritories;
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
			Territory ter51 = new Territory(count, 'l', 1, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter51;
			ArrayList<Integer> borderLake8 = new ArrayList<Integer>();
			borderLake8.add(count);
			count++;
			Territory ter52 = new Territory(count, 'j', 0, noPreyAnim, borderLake8, noBorderDens); myTerritories[count] = ter52;
			count++;
			Territory ter53 = new Territory(count, 't', 2, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter53;
			count++;
			Territory ter54 = new Territory(count, 'j', 0, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter54;
			
			territories[0] = count-2;
			territories[1] = count-2;
			territories[2] = count-2;
			territories[3] = count-3;
			territories[4] = count-3;
			territories[5] = count-3;
			territories[6] = count-2;
			territories[7] = count-1;
			territories[8] = count;
			territories[9] = count;
			territories[10] = count-1;
			territories[11] = count-2;
			territories[12] = 0;
			
			created = new Tile(territories, "JLTT-");
			count++;
			break;
		case "JLTTB":
			Territory ter55 = new Territory(count, 'l', 1, buffalo, noBorderLakes, noBorderDens); myTerritories[count] = ter55;
			ArrayList<Integer> borderLake9 = new ArrayList<Integer>();
			borderLake9.add(count);
			count++;
			Territory ter56 = new Territory(count, 'j', 0, noPreyAnim, borderLake9, noBorderDens); myTerritories[count] = ter56;
			count++;
			Territory ter57 = new Territory(count, 't', 2, buffalo, noBorderLakes, noBorderDens); myTerritories[count] = ter57;
			count++;
			Territory ter58 = new Territory(count, 'j', 0, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter58;
			
			territories[0] = count-2;
			territories[1] = count-2;
			territories[2] = count-2;
			territories[3] = count-3;
			territories[4] = count-3;
			territories[5] = count-3;
			territories[6] = count-2;
			territories[7] = count-1;
			territories[8] = count;
			territories[9] = count;
			territories[10] = count-1;
			territories[11] = count-2;
			territories[12] = 0;
			
			created = new Tile(territories, "JLTTB");
			count++;
			break;
		case "TLTJ-":
			Territory ter59 = new Territory(count, 'l', 1, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter59;
			ArrayList<Integer> borderLake10 = new ArrayList<Integer>();
			borderLake10.add(count);
			count++;
			Territory ter60 = new Territory(count, 'j', 0, noPreyAnim, borderLake10, noBorderDens); myTerritories[count] = ter60;
			count++;
			Territory ter61 = new Territory(count, 't', 2, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter61;
			count++;
			Territory ter62 = new Territory(count, 'j', 0, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter62;
			
			territories[0] = count;
			territories[1] = count-1;
			territories[2] = count-2;
			territories[3] = count-3;
			territories[4] = count-3;
			territories[5] = count-3;
			territories[6] = count-2;
			territories[7] = count-1;
			territories[8] = count;
			territories[9] = count;
			territories[10] = count;
			territories[11] = count;
			territories[12] = 0;
			
			created = new Tile(territories, "TLTJ-");
			count++;
			break;
		case "TLTJD":
			Territory ter63 = new Territory(count, 'l', 1, deer, noBorderLakes, noBorderDens); myTerritories[count] = ter63;
			ArrayList<Integer> borderLake11 = new ArrayList<Integer>();
			borderLake11.add(count);
			count++;
			Territory ter64 = new Territory(count, 'j', 0, noPreyAnim, borderLake11, noBorderDens); myTerritories[count] = ter64;
			count++;
			Territory ter65 = new Territory(count, 't', 2, deer, noBorderLakes, noBorderDens); myTerritories[count] = ter65;
			count++;
			Territory ter66 = new Territory(count, 'j', 0, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter66;
			
			territories[0] = count;
			territories[1] = count-1;
			territories[2] = count-2;
			territories[3] = count-3;
			territories[4] = count-3;
			territories[5] = count-3;
			territories[6] = count-2;
			territories[7] = count-1;
			territories[8] = count;
			territories[9] = count;
			territories[10] = count;
			territories[11] = count;
			territories[12] = 0;
			
			created = new Tile(territories, "TLTJD");
			count++;
			break;
		case "TLLL-":
			Territory ter67 = new Territory(count, 'l', 3, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter67;
			ArrayList<Integer> borderLake12 = new ArrayList<Integer>();
			borderLake12.add(count);
			count++;
			Territory ter68 = new Territory(count, 'j', 0, noPreyAnim, borderLake12, noBorderDens); myTerritories[count] = ter68;
			count++;
			Territory ter69 = new Territory(count, 't', 1, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter69;
			count++;
			Territory ter70 = new Territory(count, 'j', 0, noPreyAnim, borderLake12, noBorderDens); myTerritories[count] = ter70;
			
			territories[0] = count-2;
			territories[1] = count-1;
			territories[2] = count;
			territories[3] = count-3;
			territories[4] = count-3;
			territories[5] = count-3;
			territories[6] = count-3;
			territories[7] = count-3;
			territories[8] = count-3;
			territories[9] = count-3;
			territories[10] = count-3;
			territories[11] = count-3;
			territories[12] = 0;
			
			created = new Tile(territories, "TLLL-");
			count++;
			break;
		case "TLTT-":
			Territory ter71 = new Territory(count, 'l', 1, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter71;
			ArrayList<Integer> borderLake13 = new ArrayList<Integer>();
			borderLake13.add(count);
			count++;
			Territory ter72 = new Territory(count, 'j', 0, noPreyAnim, borderLake13, noBorderDens); myTerritories[count] = ter72;
			count++;
			Territory ter73 = new Territory(count, 't', 1, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter73;
			count++;
			Territory ter74 = new Territory(count, 'j', 0, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter74;
			count++;
			Territory ter75 = new Territory(count, 't', 1, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter75;
			count++;
			Territory ter76 = new Territory(count, 'j', 0, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter76;
			count++;
			Territory ter77 = new Territory(count, 't', 1, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter77;
			
			territories[0] = count-3;
			territories[1] = count-4;
			territories[2] = count-5;
			territories[3] = count-6;
			territories[4] = count-6;
			territories[5] = count-6;
			territories[6] = count-5;
			territories[7] = count-2;
			territories[8] = count-1;
			territories[9] = count-1;
			territories[10] = count;
			territories[11] = count-3;
			territories[12] = 0;
			
			created = new Tile(territories, "TLTT-");
			count++;
			break;
		case "TLTTP":
			Territory ter78 = new Territory(count, 'l', 1, boar, noBorderLakes, noBorderDens); myTerritories[count] = ter78;
			ArrayList<Integer> borderLake14 = new ArrayList<Integer>();
			borderLake14.add(count);
			count++;
			Territory ter79 = new Territory(count, 'j', 0, noPreyAnim, borderLake14, noBorderDens); myTerritories[count] = ter79;
			count++;
			Territory ter80 = new Territory(count, 't', 1, boar, noBorderLakes, noBorderDens); myTerritories[count] = ter80;
			count++;
			Territory ter81 = new Territory(count, 'j', 0, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter81;
			count++;
			Territory ter82 = new Territory(count, 't', 1, boar, noBorderLakes, noBorderDens); myTerritories[count] = ter82;
			count++;
			Territory ter83 = new Territory(count, 'j', 0, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter83;
			count++;
			Territory ter84 = new Territory(count, 't', 1, boar, noBorderLakes, noBorderDens); myTerritories[count] = ter84;
			
			territories[0] = count-3;
			territories[1] = count-4;
			territories[2] = count-5;
			territories[3] = count-6;
			territories[4] = count-6;
			territories[5] = count-6;
			territories[6] = count-5;
			territories[7] = count-2;
			territories[8] = count-1;
			territories[9] = count-1;
			territories[10] = count;
			territories[11] = count-3;
			territories[12] = 0;
			
			created = new Tile(territories, "TLTTP");
			count++;
			break;
		case "TLLT-":
			Territory ter85 = new Territory(count, 'l', 2, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter85;
			ArrayList<Integer> borderLake15 = new ArrayList<Integer>();
			borderLake15.add(count);
			count++;
			Territory ter86 = new Territory(count, 'j', 0, noPreyAnim, borderLake15, noBorderDens); myTerritories[count] = ter86;
			count++;
			Territory ter87 = new Territory(count, 't', 2, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter87;
			count++;
			Territory ter88 = new Territory(count, 'j', 0, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter88;
			
			territories[0] = count;
			territories[1] = count-1;
			territories[2] = count-2;
			territories[3] = count-3;
			territories[4] = count-3;
			territories[5] = count-3;
			territories[6] = count-3;
			territories[7] = count-3;
			territories[8] = count-3;
			territories[9] = count-2;
			territories[10] = count-1;
			territories[11] = count;
			territories[12] = 0;
		
			created = new Tile(territories, "TLLT-");
			count++;
			break;
		case "TLLTB":
			Territory ter89 = new Territory(count, 'l', 2, buffalo, noBorderLakes, noBorderDens); myTerritories[count] = ter89;
			ArrayList<Integer> borderLake16 = new ArrayList<Integer>();
			borderLake16.add(count);
			count++;
			Territory ter90 = new Territory(count, 'j', 0, noPreyAnim, borderLake16, noBorderDens); myTerritories[count] = ter90;
			count++;
			Territory ter91 = new Territory(count, 't', 2, buffalo, noBorderLakes, noBorderDens); myTerritories[count] = ter91;
			count++;
			Territory ter92 = new Territory(count, 'j', 0, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter92;
			
			territories[0] = count;
			territories[1] = count-1;
			territories[2] = count-2;
			territories[3] = count-3;
			territories[4] = count-3;
			territories[5] = count-3;
			territories[6] = count-3;
			territories[7] = count-3;
			territories[8] = count-3;
			territories[9] = count-2;
			territories[10] = count-1;
			territories[11] = count;
			territories[12] = 0;
		
			created = new Tile(territories, "TLLTB");
			count++;
			break;
		case "LJTJ-":
			Territory ter93 = new Territory(count, 'l', 1, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter93;
			ArrayList<Integer> borderLake17 = new ArrayList<Integer>();
			borderLake17.add(count);
			count++;
			Territory ter94 = new Territory(count, 'j', 0, noPreyAnim, borderLake17, noBorderDens); myTerritories[count] = ter94;
			count++;
			Territory ter95 = new Territory(count, 't', 1, noPreyAnim, noBorderLakes, noBorderDens); myTerritories[count] = ter95;
			count++;
			Territory ter96 = new Territory(count, 'j', 0, noPreyAnim, borderLake17, noBorderDens); myTerritories[count] = ter96;
			
			territories[0] = count-3;
			territories[1] = count-3;
			territories[2] = count-3;
			territories[3] = count-2;
			territories[4] = count-2;
			territories[5] = count-2;
			territories[6] = count-2;
			territories[7] = count-1;
			territories[8] = count;
			territories[9] = count;
			territories[10] = count;
			territories[11] = count;
			territories[12] = 0;
		
			created = new Tile(territories, "LJTJ-");
			count++;
			break;
		case "LJTJD":
			Territory ter97 = new Territory(count, 'l', 1, deer, noBorderLakes, noBorderDens); myTerritories[count] = ter97;
			ArrayList<Integer> borderLake18 = new ArrayList<Integer>();
			borderLake18.add(count);
			count++;
			Territory ter98 = new Territory(count, 'j', 0, noPreyAnim, borderLake18, noBorderDens); myTerritories[count] = ter98;
			count++;
			Territory ter99 = new Territory(count, 't', 1, deer, noBorderLakes, noBorderDens); myTerritories[count] = ter99;
			count++;
			Territory ter100 = new Territory(count, 'j', 0, noPreyAnim, borderLake18, noBorderDens); myTerritories[count] = ter100;
			
			territories[0] = count-3;
			territories[1] = count-3;
			territories[2] = count-3;
			territories[3] = count-2;
			territories[4] = count-2;
			territories[5] = count-2;
			territories[6] = count-2;
			territories[7] = count-1;
			territories[8] = count;
			territories[9] = count;
			territories[10] = count;
			territories[11] = count;
			territories[12] = 0;
		
			created = new Tile(territories, "LJTJD");
			count++;
			break;
		case "TLLLC":
			Territory ter101 = new Territory(count, 'l', 3, crocodile, noBorderLakes, noBorderDens); myTerritories[count] = ter101;
			ArrayList<Integer> borderLake19 = new ArrayList<Integer>();
			borderLake19.add(count);
			count++;
			Territory ter102 = new Territory(count, 'j', 0, noPreyAnim, borderLake19, noBorderDens); myTerritories[count] = ter102;
			count++;
			Territory ter103 = new Territory(count, 't', 1, crocodile, noBorderLakes, noBorderDens); myTerritories[count] = ter103;
			count++;
			Territory ter104 = new Territory(count, 'j', 0, noPreyAnim, borderLake19, noBorderDens); myTerritories[count] = ter104;
			
			territories[0] = count-2;
			territories[1] = count-1;
			territories[2] = count;
			territories[3] = count-3;
			territories[4] = count-3;
			territories[5] = count-3;
			territories[6] = count-3;
			territories[7] = count-3;
			territories[8] = count-3;
			territories[9] = count-3;
			territories[10] = count-3;
			territories[11] = count-3;
			territories[12] = 0;
			
			created = new Tile(territories, "TLLLC");
			count++;
			break;
		}
		
		return created;
	}
}
