package tigerZone;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Tile {

	int subtiles[];

	int position[] = new int[2];
	String id;
	BufferedImage tile;
	String test;

	boolean shield;

	public Tile(int[] territories, String identifier) {
		subtiles = new int[13];
		for (int i = 0; i < 13; i++) {
			subtiles[i] = territories[i];
		}

		id = identifier;
	}

	//Method to rotate a tile 90 degrees clockwise, rotationDegree times
	public void Rotate(int rotationDegree) {
		
		for (int i = 0; i < rotationDegree; i++)
		{
			int t1 = subtiles[3];
			int t2 = subtiles[4];
			int t3 = subtiles[5];
			
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

		}

	}
	
	public void setImage(String s){
		
		test = s;
		// Passes the path as a string and loads it in an image
		// i.e., Resources/SomeTile.png
		try {
			tile = ImageIO.read(getClass().getResourceAsStream(s));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
