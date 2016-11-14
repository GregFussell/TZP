package tigerZone;

public class Territory {
	public int openFaces;
	public int borderCities;
	int numtiles;
	int numShields;
	int player1Meeples;
	int player2Meeples;
	char type;
	public void merge(Territory territory){
		this.numShields+=territory.numShields;
		this.numtiles+=territory.numtiles;
		this.openFaces+=territory.openFaces;
		this.player1Meeples+=territory.player1Meeples;
		this.player2Meeples+=territory.player2Meeples;
		this.borderCities+=territory.borderCities;
		if(this.openFaces==0){
			//complete()
		}
		
	}

}
