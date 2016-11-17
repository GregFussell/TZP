package tigerZone;

import java.lang.Math;

public class Deck {
	
	//ArrayList<Tile> deck = new ArrayList<Tile>();
	Tile[] deck = new Tile[76];
	
	public Deck(Tile A, Tile B, Tile C, Tile D, Tile E, Tile F,
			Tile G, Tile H, Tile I, Tile J, Tile K, Tile L,
			Tile M, Tile N, Tile C, Tile D, Tile E, Tile F,
			Tile A, Tile B, Tile C, Tile D, Tile E, Tile F,
			Tile A, Tile B, Tile C, Tile D, Tile E, Tile F,) {	

		int random = (int)(Math.random()*50 +1);
		//random insert cards into deck effectively shuffling them.
		deck.add(A);
		deck.add(B);
		deck.add(C);
		deck.add(D);
		deck.add(E);
	}
	
	//In order from pdf representation of each unique tile
	Tile A = new Tile("jjjjj"	//all field (no prey)
					+ "jjjjj"
					+ "jjjjj"
					+ "jjjjj"
					+ "jjjjj",false,false,false);
	
	Tile B = new Tile("jjjjj"	//den surrounded by field (no prey)
					+ "jjjjj"
					+ "jjdjj"
					+ "jjjjj"
					+ "jjjjj",false,false,false); 
	
	Tile C = new Tile("jjjjj"	//den with trail (no prey)
					+ "jjjjj"
					+ "jjdjj"
					+ "jjtjj"
					+ "jjtjj",false,false,false);
	
	Tile D = new Tile("jjtjj"	//4-way crossroad (s=junction)
					+ "jjtjj"
					+ "ttstt"
					+ "jjtjj"
					+ "jjtjj",false,false,false);
	
	Tile E = new Tile("jjtjj"	//single trail
					+ "jjtjj"
					+ "jjtjj"
					+ "jjtjj"
					+ "jjtjj",false,false,false);
	
	Tile F = new Tile("jjtjj"	//90 degree angle trail
					+ "jjtjj"
					+ "tttjj"
					+ "jjjjj"
					+ "jjjjj",false,false,false);
	
	Tile G = new Tile("jjtjj"	//3-way crossroad (s=junction)
					+ "jjtjj"
					+ "ttsjj"
					+ "jjtjj"
					+ "jjtjj",false,false,false);
	
	Tile H = new Tile("lllll"	//all lake
					+ "lllll"
					+ "lllll"
					+ "lllll"
					+ "lllll",false,false,false);
	
	Tile I = new Tile("xjjjx"	//all lake, one side jungle
					+ "ljjjl"	//x=split territory
					+ "lljll"
					+ "lllll"
					+ "lllll",false,false,false);
	
	Tile J = new Tile("xllll"	//half lake, half jungle
					+ "jjlll"	//split right along the diagonal
					+ "jjjll"
					+ "jjjjl"
					+ "jjjjx",false,false,false);
	
	Tile K = new Tile("xjjjx"	//one lake going through tile, jungle on both sides
					+ "lljll"	//lake disconnects the two jungles
					+ "lllll"
					+ "lljll"
					+ "xjjjx",false,false,false);
	
	Tile L = new Tile("xlllx"	//one lake on each side
					+ "jjljj"	//jungle is connected in the middle
					+ "jjjjj"
					+ "jjljj"
					+ "xlllx",false,false,false);
	
	Tile M = new Tile("xlllx"	//lake on one side, x because cannot connect to side
					+ "jlllj"	//rest of tile is jungle
					+ "jjljj"
					+ "jjjjj"
					+ "jjjjj",false,false,false);
	
	Tile N = new Tile("jjjjx"	//one lake on two adjacent sides
					+ "jjjjl"	//lakes are not connected
					+ "jjjjl"	//rest of the tile is jungle
					+ "jjjjl"
					+ "xlllx",false,false,false);
	
	Tile O = new Tile("jjtjx"	//lake on one side, trail going right connected two sides
					+ "jjtjl"	//one jungle on side of trail
					+ "tttjl"	//other jungle in between trail and lake
					+ "jjjjl"
					+ "jjjjx",false,false,false);
	
	Tile P = new Tile("jjtjx"	//lake on one side, trail coming from other side going right connected two sides
					+ "jjtjl"	//one jungle on side of trail
					+ "tttjl"	//other jungle in between trail and lake
					+ "jjjjl"	//contains boar
					+ "jjjjx",true,false,false);
	
	Tile Q = new Tile("jjjjx"	//lake on one side, trail coming from other side going left connected two sides
					+ "jjjjl"	//one jungle on side of trail
					+ "tttjl"	//other jungle in between trail and lake
					+ "jjtjl"
					+ "jjtjx",false,false,false);
	
	Tile R = new Tile("jjjjx"	//lake on one side, trail coming from other side going left connected two sides
					+ "jjjjl"	//one jungle on side of trail
					+ "tttjl"	//other jungle in between trail and lake
					+ "jjtjl"	//contains buffalo
					+ "jjtjx",false,true,false);
	
	Tile S = new Tile("jjtjx"	//lake on one side, trail going left perpendicular to lake
					+ "jjtjl"	//jungles on each side of trail
					+ "jjtjl"
					+ "jjtjl"
					+ "jjtjx",false,false,false);
	
	Tile T = new Tile("jjtjx"	//lake on one side, trail going left perpendicular to lake
					+ "jjtjl"	//jungles on each side of trail
					+ "jjtjl"	//contains a deer
					+ "jjtjl"
					+ "jjtjx",false,false,true);
	
	Tile U = new Tile("xjtjx"	//trail connected to three sided lake
					+ "ljtjl"	//separate jungles on each side of the trail
					+ "lllll"
					+ "lllll"
					+ "lllll",false,false,false);
	
	Tile V = new Tile("jjtjx"	//lake on one side, 3-way crossroad
					+ "jjtjl"	//(s=junction)
					+ "ttsjl"	//no prey animals
					+ "jjtjl"
					+ "jjtjx",false,false,false);
	
	Tile W = new Tile("jjtjx"	//lake on one side, 3-way crossroad
					+ "jjtjl"	//(s=junction)
					+ "ttsjl"	//contains boar
					+ "jjtjl"
					+ "jjtjx",true,false,false);
	
	Tile X = new Tile("jjtjx"	//lake on two sides side, trail connecting two sides (no junction)
					+ "jjtjl"	//jungle inside the trail, jungle outside the trail is connected
					+ "tttjl"	//no prey animal
					+ "jjjjl"
					+ "xllll",false,false,false);
	
	Tile Y = new Tile("jjtjx"	//lake on two sides side, trail connecting two sides (no junction)
					+ "jjtjl"	//jungle inside the trail, jungle outside the trail is connected
					+ "tttjl"	//contains buffalo
					+ "jjjjl"
					+ "xllll",false,true,false);
	
	Tile Z = new Tile("xlllx"	//lake on one side, trail connected to lake
					+ "jjljj"	//two jungles split by the trail
					+ "jjtjj"	//no prey animal
					+ "jjtjj"
					+ "jjtjj",false,false,false);
	
	Tile AA = new Tile("xlllx"	//lake on one side, trail connected to lake
			         + "jjljj"	//two jungles split by the trail
				     + "jjtjj"	//contains deer
				     + "jjtjj"
				     + "jjtjj",false,false,true);
	}