package tigerZone;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
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
	public static final int BOARD_LENGTH = 156;
	public static final int TILE_WIDTH = 100;
	int WIDTH = 800;
	int HEIGHT = 800;
	ImageIcon icon;
	BufferedImage ima;
	Graphics2D g;
	//JPanel panel;
	
	public canvas(){
		
		super();
		//this.setBounds(0, 0, 800, 800);
		
		ima = new BufferedImage(3000,3000, BufferedImage.TYPE_INT_RGB);
		g = ima.createGraphics();
		
		
		//panel = new JPanel();
		//this.setViewportView(panel);
		//panel.setPreferredSize(new Dimension(5000, 5000));
		//this.getViewport().setViewPosition(new java.awt.Point(2500,2500));
		//setPreferredSize(new Dimension(WIDTH, HEIGHT));
		//setFocusable(true);
		//requestFocus();
		//setBackground(Color.BLACK);
		//this.getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE);
		//setPreferredSize(new Dimension(5000, 5000));
		
	}
	
	public void paintComponent(Graphics g) {
		
		//super.paintComponent(g);
		
	}
	
	public void render(BufferedImage image, int x, int y, int turn) throws IOException{
		
		int correctX = (x - BOARD_WIDTH/2) * 100;
		int correctY = (y - BOARD_WIDTH/2) * 100;
		g.drawImage(image,correctY,correctX, null);
		
		
		if(turn >= 76){
			
			System.out.println("Here");
			g.dispose();
			File file = new File("ImageTest.png");
			ImageIO.write(ima, "png",file);
		}
		
		

	}
	
	public BufferedImage getIma(){
		
		return ima;
	}
	
	
}
