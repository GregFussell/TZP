package tigerZone;

public class Subtile {

	TerritoryPointer territoryPointer;
	char territoryType;
	ArrayCoord loc;
	boolean visited;
	public Subtile(char ter, int x, int y) {
		territoryType = ter;
		this.loc = new ArrayCoord(x,y);
	}
	public Territory getMyTerritory(){
		return this.territoryPointer.getTerritory();
	}

}
