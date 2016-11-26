//Test case for unit test of placeablePos[] and placedPos[]
package tigerZone;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class TilePlacementTest {
	//TODO: check placeableUpdate()
	//TODO: check validPlacement() (actually uses tiles)
	//TODO: 
	
	
	@Test
	public void testUpdatePlaceable() {
		Game thisGame = new Game(77, 77);
		thisGame.updatePlaceable(36, 36);
		//placeable should be --> (35,36)(37,36)(36,35)(36,37)
		
		ArrayList<ArrayCoord> expectedPlaceables = new ArrayList<ArrayCoord>();
		
		//add expected coordinate values to arrayLists
		ArrayCoord a = new ArrayCoord(35, 36);
		ArrayCoord b = new ArrayCoord(37, 36);
		ArrayCoord c = new ArrayCoord(36, 35);
		ArrayCoord d = new ArrayCoord(36, 37);
		expectedPlaceables.add(a);
		expectedPlaceables.add(b);
		expectedPlaceables.add(c);
		expectedPlaceables.add(d);
		
		System.out.println("Method result: " + thisGame.getPlaceable().toString());
		System.out.println("Expected result: " + expectedPlaceables.toString());
		System.out.println("Placed result: " + thisGame.getPlaced().toString());
		System.out.println();
		
		assertTrue(expectedPlaceables.toString().equals(thisGame.getPlaceable().toString()));
		
		//Another tile placed...
		thisGame.updatePlaceable(35, 36);
		expectedPlaceables.remove(expectedPlaceables.indexOf(a));
		ArrayCoord e = new ArrayCoord(34, 36);
		ArrayCoord f = new ArrayCoord(36, 36);
		ArrayCoord g = new ArrayCoord(35, 35);
		ArrayCoord h = new ArrayCoord(35, 37);
		expectedPlaceables.add(e);
		expectedPlaceables.add(f);
		expectedPlaceables.add(g);
		expectedPlaceables.add(h);
		
		System.out.println("Method result: " + thisGame.getPlaceable().toString());
		System.out.println("Expected result: " + expectedPlaceables.toString());
		System.out.println("Placed result: " + thisGame.getPlaced().toString());
		System.out.println();
		
		assertTrue(expectedPlaceables.toString().equals(thisGame.getPlaceable().toString()));
		
		//Another tile placed...
				thisGame.updatePlaceable(37, 36);
				expectedPlaceables.remove(expectedPlaceables.indexOf(b));
				ArrayCoord i = new ArrayCoord(36, 36);
				ArrayCoord j = new ArrayCoord(38, 36);
				ArrayCoord k = new ArrayCoord(37, 35);
				ArrayCoord l = new ArrayCoord(37, 37);
				expectedPlaceables.add(i);
				expectedPlaceables.add(j);
				expectedPlaceables.add(k);
				expectedPlaceables.add(l);
				
				System.out.println("Method result: " + thisGame.getPlaceable().toString());
				System.out.println("Expected result: " + expectedPlaceables.toString());
				System.out.println("Placed result: " + thisGame.getPlaced().toString());
				System.out.println();
				
				assertTrue(expectedPlaceables.toString().equals(thisGame.getPlaceable().toString()));
	}

}
