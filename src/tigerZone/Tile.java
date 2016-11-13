package tigerZone;

public class Tile {

	Territory subtiles[];

	int position[] = new int[2];
	int id;

	boolean shield;

	public Tile(Territory[] territories, int identifier) {
		subtiles = new Territory[13];
		for (int i = 0; i < 13; i++) {
			
			subtiles[i] = territories[i];
			//subtiles[i] = new Territory(territories.charAt(i));
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
			Territory t1 = subtiles[3];
			Territory t2 = subtiles[4];
			Territory t3 = subtiles[5];
			
			subtiles[3] = subtiles[0];
			subtiles[4] = subtiles[1];
			subtiles[5] = subtiles[2];
			
			subtiles[0] = subtiles[9];
			subtiles[1] = subtiles[10];
			subtiles[2] = subtiles[11];
			
			subtiles[9] = subtiles[6];
			subtiles[10] = subtiles[7];
			subtiles[11] = subtiles[8];
			
			subtiles[6] = t1;
			subtiles[7] = t2;
			subtiles[8] = t3;
//		Subtile temp;
//		temp = subtiles[6];
//		subtiles[6] = subtiles[8];
//		subtiles[8] = subtiles[2];
//		subtiles[2] = subtiles[0];
//		subtiles[0] = temp;
//
//		temp = subtiles[3];
//		subtiles[3] = subtiles[7];
//		subtiles[7] = subtiles[5];
//		subtiles[5] = subtiles[1];
//		subtiles[1] = temp;
		}

	}
}
