package tigerZone;

public class Square {

	int leftCornerX;
	int leftCornerY;
	
	Square(int x, int y){
		
		leftCornerX = x;
		leftCornerY = y;
	}
	
	public int returnX(){
		
		return leftCornerX;
	}
	
	public int returnY(){
		
		return leftCornerY;
	}
}
