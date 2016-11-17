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
	Tile A = new Tile("jjjjj"
					+ "jjjjj"
					+ "jjjjj"
					+ "jjjjj"
					+ "jjjjj");
	Tile B = new Tile("jjjjj"
					+ "jjjjj"
					+ "jjdjj"
					+ "jjjjj"
					+ "jjjjj"); 
	Tile C = new Tile("jjjjjjjjjjjjdjjjjtjjjjtjj");
	Tile D = new Tile("jjjjjjjtjjtjR");
	Tile E = new Tile("jtjjjjjtjjjjR");
	Tile F = new Tile("jjjjjjjtjjtjR");
	Tile G = new Tile("jtjjjjjtjjjjR");
	Tile H = new Tile("jjjjjjjtjjtjR");
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