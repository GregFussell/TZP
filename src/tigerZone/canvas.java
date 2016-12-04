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
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class canvas extends JScrollPane{

	
	public static final int BOARD_WIDTH = 156;
	public static final int BOARD_LENGTH = 156;
	public static final int TILE_WIDTH = 100;
	int WIDTH = 800;
	int HEIGHT = 800;
	JPanel panel;
	
	public canvas(){
		
		super();
		this.setBounds(0, 0, 800, 800);
		
		panel = new JPanel();
		this.setViewportView(panel);
		panel.setPreferredSize(new Dimension(6000, 6000));
		this.getViewport().setViewPosition(new java.awt.Point(3000,3000));
		//setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
		//setBackground(Color.BLACK);
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
	}
	
	public void render(BufferedImage image, int x, int y){
		
		Graphics g = this.getGraphics();
		int correctX = (x - BOARD_WIDTH/2) * 100;
		int correctY = (y - BOARD_WIDTH/2) * 100;
		g.drawImage(image,correctY,correctX, null);

	}
	
	
}
