package tigerZone;
import java.util.ArrayList;

public class TerritoryPointer {
	static int counter =0;
	public int pointer;
	public ArrayList<Integer> mergedTerritories = new ArrayList<Integer>();
	public static Territory[] territories = new Territory[246];
	public static int[] territoryIndexes = new int[246];
	
	public TerritoryPointer(){
		pointer=counter;
		counter++;
		territoryIndexes[counter] = counter;
		this.mergedTerritories.add(this.pointer);
	}
	public Territory getTerritory(){//should get the territory by accessing the index of the territory from
		return territories[(territoryIndexes[pointer])]; // the array of territory indexes at index "pointer"
	}
	public void merge(TerritoryPointer territoryPointer, int x, int y){
		for(int i:territoryPointer.mergedTerritories){
			
			territoryIndexes[i] = territoryIndexes[this.pointer];
			this.mergedTerritories.add(i);
		}
		this.getTerritory().numBoar += territoryPointer.getTerritory().numBoar;
		this.getTerritory().numBuffalo += territoryPointer.getTerritory().numBuffalo;
		this.getTerritory().numDeer += territoryPointer.getTerritory().numDeer;
		this.getTerritory().numTiles += territoryPointer.getTerritory().numTiles;
		this.getTerritory().openFaces += territoryPointer.getTerritory().openFaces - 2;
		this.getTerritory().player1Meeples += territoryPointer.getTerritory().player1Meeples;
		this.getTerritory().player2Meeples += territoryPointer.getTerritory().player2Meeples;
		
		//Checks if the tile is already in the territory to prevent double scoring a tile.
		this.getTerritory().containedTiles = territoryPointer.getTerritory().containedTiles;
		boolean duplicate = false;
		for (int i = 0; i < this.getTerritory().containedTiles.size(); i++)
		{
			if (this.getTerritory().containedTiles.get(i).x == x && this.getTerritory().containedTiles.get(i).y == y)
			{
				duplicate = true;
			}
		}
		if (duplicate == false)
		{
			this.getTerritory().containedTiles.add(new ArrayCoord(x,y));
		}
	}
	
}