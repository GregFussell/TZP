package tigerZone;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.Queue;

public class Deck {
	
	//ArrayList<Tile> deck = new ArrayList<Tile>();
	Queue<Tile> deck = new LinkedList<Tile>();
	
	public Deck(Tile A, Tile B, Tile C, Tile D, Tile E) {	

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
	Tile E = new Tile("jjtjj"	//single road
					+ "jjtjj"
					+ "jjtjj"
					+ "jjtjj"
					+ "jjtjj",false,false,false);
	Tile F = new Tile("jjtjj"	//90 degree angle road
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
					+ "ljjjl"
					+ "lllll"
					+ "lllll",false,false,false);
	Tile J = new Tile("jjjjjjjtjjtjR");
	Tile K = new Tile("jtjjjjjtjjjjR");
	Tile L = new Tile("jjjjjjjtjjtjR");
	Tile M = new Tile("jtjjjjjtjjjjR");
	Tile N = new Tile("jjjjjjjtjjtjR");
	Tile O = new Tile("jtjjjjjtjjjjR");
	Tile P = new Tile("jjjjjjjtjjtjR");
	Tile Q = new Tile("jtjjjjjtjjjjR");
	Tile R = new Tile("jjjjjjjtjjtjR");
	Tile S = new Tile("jtjjjjjtjjjjR");
	Tile T = new Tile("jjjjjjjtjjtjR");
	Tile U = new Tile("jtjjjjjtjjjjR");
	Tile V = new Tile("jjjjjjjtjjtjR");
	Tile W = new Tile("jtjjjjjtjjjjR");
	Tile X = new Tile("jjjjjjjtjjtjR");
	Tile Y = new Tile("jtjjjjjtjjjjR");
	Tile Z = new Tile("jjjjjjjtjjtjR");
	Tile AA = new Tile("jtjjjjjtjjjjR");
	Tile BB = new Tile("jjjjjjjtjjtjR");


}