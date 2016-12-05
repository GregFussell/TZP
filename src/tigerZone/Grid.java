package tigerZone;

public class Grid {

	final int SIZE = 78;
	Square[][] squares;
	
	public Grid(){
		
		squares = new Square[78][78];
	}
	
	public void setCorners(){
		
		int startingPixelX = 0;
		int startingPixelY = 0;
		
		for(int i = 0; i < 78; i++){
			
			startingPixelX = 0;
			
			for(int j = 0; j < 78; j++){
				
				squares[i][j] = new Square(startingPixelX,startingPixelY);
				startingPixelX += 100;
			}
			startingPixelY += 100;
		}
	}
	
	public Square getSquare(int x, int y){
		
		return squares[x][y];
	}
	public void print(){
		
		for(int i = 0; i < 78; i++){
			
			for(int j = 0; j < 78; j++){
				
				System.out.println(squares[i][j].returnX()+ ":" + squares[i][j].returnY());				
			}
		}
	}
}
