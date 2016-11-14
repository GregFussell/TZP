package tigerZone;

public class Subtile {

	Territory territory;
	char territoryType;
	ArrayCoord loc;
	bool visited;
	public Subtile(char ter, int x, int y) {
		territoryType = ter;
		this.loc = new ArrayCoord(x,y);
	}

}
