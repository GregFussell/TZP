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

}
// Are we using 5 for testing or all 78?