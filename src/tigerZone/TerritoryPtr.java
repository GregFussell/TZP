package tigerZone;

public class TerritoryPtr {

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
	
	public void rewritePtr(int currentID, int rewriteID)
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
