package tigerZone;

import java.util.ArrayList;

public class Territory {
	static public int counter;
	int id;
	public int openFaces;
	public ArrayList<Territory> Lakes = new ArrayList<Territory>();
	public ArrayList<Territory> Dens = new ArrayList<Territory>();
	int numtiles;
	int numShields;
	int player1Meeples;
	int player2Meeples;
	char type;
	public Territory(char type){
		counter++;
		id=counter;
		this.type=type;
	}
	public void merge(Territory territory){
		this.numShields+=territory.numShields;
		this.numtiles+=territory.numtiles;
		this.openFaces+=territory.openFaces;
		this.player1Meeples+=territory.player1Meeples;
		this.player2Meeples+=territory.player2Meeples;
		for(Territory lake:Lakes){
			if(!Lakes.contains(lake)){
				Lakes.add(lake);
			}
		}
		for(Territory den:Dens){
			if(!Dens.contains(den)){
				Dens.add(den);
			}
		}
		if(this.openFaces==0){
			//complete()
		}
		
	}

}
