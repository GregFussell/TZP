package tigerZone;

public class Tile {

	Subtile subtiles[];

	int position[] = new int[2];
	int id;

	boolean shield;

	public Tile(String territories, int identifier) {
		subtiles = new Subtile[9];
		for (int i = 0; i < 9; i++) {
			subtiles[i] = new Subtile(territories.charAt(i));
		}

		// subtiles[0] = new Subtile(zero);
		// subtiles[1] = new Subtile(one);
		// subtiles[2] = new Subtile(two);
		// subtiles[3] = new Subtile(three);
		// subtiles[4] = new Subtile(four);
		// subtiles[5] = new Subtile(five);
		// subtiles[6] = new Subtile(six);
		// subtiles[7] = new Subtile(seven);
		// subtiles[8] = new Subtile(eight);
		id = identifier;
	}

	public void Rotate(int rotationDegree) {
		
		for (int i = 0; i < rotationDegree; i++)
		{
		Subtile temp;
		temp = subtiles[6];
		subtiles[6] = subtiles[8];
		subtiles[8] = subtiles[2];
		subtiles[2] = subtiles[0];
		subtiles[0] = temp;

		temp = subtiles[3];
		subtiles[3] = subtiles[7];
		subtiles[7] = subtiles[5];
		subtiles[5] = subtiles[1];
		subtiles[1] = temp;
		}

	}
}
