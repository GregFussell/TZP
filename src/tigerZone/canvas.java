package tigerZone;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

public class canvas {

	
	public static final int BOARD_WIDTH = 156;
	public static final int TILE_WIDTH = 100;
	int WIDTH = 800;
	int HEIGHT = 800;
	ImageIcon icon;
	BufferedImage ima;
	BufferedImage startingTile;
	Graphics2D g;
	Grid grid;
	
	public canvas(){
		
		// the image is that big so that every tile could fit in the semi worst case, 77 tiles next to each other
		//worst case would be starting from the center of the grid and 76 tiles next to one another
		ima = new BufferedImage(7800,7800, BufferedImage.TYPE_INT_RGB);
		g = ima.createGraphics();
		
		// grid to keep track of the pixel locations
		grid = new Grid();
		grid.setCorners();
		
		// Place starting Tile
		try {
			startingTile = ImageIO.read(getClass().getResourceAsStream("/TLTJ-.png"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		g.drawImage(startingTile,grid.getSquare(39, 39).returnX(),grid.getSquare(39, 39).returnY(),null);
		
		//Font
		g.setFont(new Font("TimesRoman", Font.PLAIN, 18));
		
	}
	
	public void render(BufferedImage image, int x, int y, int rotation, int animalselected, int zone, int turn){
			
		//receive the position from The Ais, Gameloop´s grid starts at 0,0 ends at 156,156
		// Math below fixes that to the 78 by 78 board size used by GUI, why 78? because..
		int cX = x - (BOARD_WIDTH/4);
		int cY = y - (BOARD_WIDTH/4);
		
		//Rotation
		double rotationRequired = (Math.toRadians(90))* rotation;
		double locationX = image.getWidth() / 2;
		double locationY = image.getWidth() / 2;
		AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		
		// Apply rotation and display image at correct location
		g.drawImage(op.filter(image,null),grid.getSquare(cX, cY).returnX(),grid.getSquare(cX, cY).returnY(),null);
		
		
		//AIs selected a tiger
		if(animalselected == 1){
			
			//If the tiger belongs to player 2
			if(turn%2 == 0){
				
				g.setColor(Color.BLUE);
				g.drawString("P2 Tiger@" + zone,grid.getSquare(cX, cY).returnX() + 7,grid.getSquare(cX, cY).returnY() + 50);
			}
			
			//Belongs to player 1
			else{
				
				g.setColor(Color.RED);
				g.drawString("P1 Tiger@" + zone,grid.getSquare(cX, cY).returnX() + 7,grid.getSquare(cX, cY).returnY() + 50);
			}
			
		}
		
		//Ai selected a croc
		else if(animalselected == 2){
			
			//Player2
			if(turn%2 == 0){
				
				g.setColor(Color.BLUE);
				g.drawString("P2 Croc@" + zone,grid.getSquare(cX, cY).returnX() + 7,grid.getSquare(cX, cY).returnY() + 50);
			}
			//Player1
			else{
				
				g.setColor(Color.RED);
				g.drawString("P1 Croc@" + zone,grid.getSquare(cX, cY).returnX() + 7,grid.getSquare(cX, cY).returnY() + 50);
			}
		}
		
		/*
		if(turn >= 76){
			
			System.out.println("Here");
			g.dispose();
			File file = new File("ImageTest.png");
			ImageIO.write(ima, "png",file);
		}
		*/
		
	}
	
	// Returns the image so that they could be displayed on the fly instead of at the end of game
	public BufferedImage getIma(){
		
		return ima;
	}
	
	public void saveImage() throws IOException{
		
		File file = new File("ImageTest.png");
		ImageIO.write(ima, "png",file);
	}
	
	
}
