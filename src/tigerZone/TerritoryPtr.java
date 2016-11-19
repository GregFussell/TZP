package tigerZone;

public class TerritoryPtr {

	int[] pointers = new int[246];
	
	public TerritoryPtr() {
	
		for(int i=0; i<246; i++)
		{
			pointers[i] = i;
		}
		
	}
	
	public void rewritePtr(int currentID, int rewriteID)
	{
		for(int i=0; i<246; i++)
		{
			if(pointers[i] == rewriteID)
			{
				pointers[i] = currentID;
			}
		}
	}
	
	
}
