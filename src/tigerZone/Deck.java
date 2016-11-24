package tigerZone;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.Queue;

public class Deck {
	
	//ArrayList<Tile> deck = new ArrayList<Tile>();
	private ArrayList<Tile> deck = new ArrayList<Tile>();
	private int size;
	
	public Deck() {	
		size = 0;
	}

	public void add(Tile tile){
		deck.add(tile);
	}
	
	public int size(){
		return size;
	}
	
	public Tile remove(){
		return deck.remove(0);
	}
	
}
// Are we using 5 for testing or all 78?