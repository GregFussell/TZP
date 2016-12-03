package tigerZone;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class canvas extends JPanel{

	int WIDTH = 800;
	int HEIGHT = 800;
	BufferedImage ima;
	private Graphics2D g;
	
	public canvas(){
		
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
		ima = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		
		g = (Graphics2D)ima.getGraphics();
	}
	
	public void draw(BufferedImage im, int x, int y, int rotation, int animal, int zone, String s) {
		
		//System.out.println(s);
		g.drawImage(im, (int)x, (int)y, null);
		g.drawLine(100, 100, 500, 500);
		//repaint();
		
		
	}
	
}
