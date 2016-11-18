package tigerZone;

import java.util.ArrayList;

public class ArrayCoord {
	int x;
	int y;

	public ArrayCoord(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public boolean equals(Object o){
		ArrayCoord arraycoord = (ArrayCoord) o;
		if(arraycoord==null)
			return false;
		if(arraycoord.x==this.x && arraycoord.y==this.y)
			return true;
		else return false;
	}

	
}
