package tigerZone;
//this class serves as a Java simulation of pointer mechanics
public class TerritoryPtr {
	
	//the values in this array of integers are representative of territory index values in the myTerritories array in Game
	//every tile contains a set integers that refer to indexes of this pointer array, these are indicative of what territory a subtile is part of
	//whenever one territory merges with another the value held at their index in the pointer array becomes the same
	//that way they both "point" to the same territory object after merging
	int[] pointers;
	int myTerritoriesSize;
	
	public TerritoryPtr(int myTerritoriesSize) {
		this.myTerritoriesSize = myTerritoriesSize;
		pointers = new int[myTerritoriesSize];
		
		for(int i=0; i<myTerritoriesSize; i++)
		{
			pointers[i] = i;
		}
		
	}
	
	public void rewritePtr(int currentID, int rewriteID)//this is where the pointer values are set to the same value during merging
	{
		for(int i=0; i<myTerritoriesSize; i++)
		{
			if(pointers[i] == rewriteID)
			{
				pointers[i] = currentID;
			}
		}
	}
	
	
}
