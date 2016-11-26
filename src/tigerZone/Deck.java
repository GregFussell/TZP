package tigerZone;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.Queue;

public class Deck {
	
	private ArrayList<Tile> deck;
	
	public Deck() {	
		deck = new ArrayList<Tile>();
	}

	public void add(Tile tile){
		deck.add(tile);
	}
	
	public int size(){
		return deck.size();
	}
	
	public Tile remove(){
		return deck.remove(0);
	}
	
}
