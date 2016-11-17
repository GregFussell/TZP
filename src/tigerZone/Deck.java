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
	Tile A = new Tile("jjjjj"	//all field 
					+ "jjjjj"
					+ "jjjjj"
					+ "jjjjj"
					+ "jjjjj");
	Tile B = new Tile("jjjjj"	//den surrounded by field
					+ "jjjjj"
					+ "jjdjj"
					+ "jjjjj"
					+ "jjjjj"); 
	Tile C = new Tile("jjjjj"	//den with trail
					+ "jjjjj"
					+ "jjdjj"
					+ "jjtjj"
					+ "jjtjj");
	Tile D = new Tile("jjtjj"	//4-way crossroad (s=junction)
					+ "jjtjj"
					+ "ttstt"
					+ "jjtjj"
					+ "jjtjj");
	Tile E = new Tile("jjtjj"	//single road
					+ "jjtjj"
					+ "jjtjj"
					+ "jjtjj"
					+ "jjtjj");
	Tile F = new Tile("jjtjj"	//90 degree angle road
					+ "jjtjj"
					+ "tttjj"
					+ "jjjjj"
					+ "jjjjj");
	Tile G = new Tile("jjtjj"	//3-way crossroad (s=junction)
					+ "jjtjj"
					+ "ttsjj"
					+ "jjtjj"
					+ "jjtjj");
	Tile H = new Tile("lllll"	//all lake
					+ "lllll"
					+ "lllll"
					+ "lllll"
					+ "lllll");
	Tile I = new Tile("jtjjjjjtjjjjR");
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