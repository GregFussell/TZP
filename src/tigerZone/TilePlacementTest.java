//Test case for unit test of placeablePos[] and placedPos[]
package tigerZone;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class TilePlacementTest {
	//test placeableUpdate()
	//test validPlacement() (actually uses tiles)
	
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
		
//		System.out.println("Method result: " + thisGame.getPlaceable().toString());
//		System.out.println("Expected result: " + expectedPlaceables.toString());
//		System.out.println("Placed result: " + thisGame.getPlaced().toString());
//		System.out.println();
		
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
		
//		System.out.println("Method result: " + thisGame.getPlaceable().toString());
//		System.out.println("Expected result: " + expectedPlaceables.toString());
//		System.out.println("Placed result: " + thisGame.getPlaced().toString());
//		System.out.println();
		
		assertTrue(expectedPlaceables.toString().equals(thisGame.getPlaceable().toString()));
		
		//Another tile placed...
		thisGame.updatePlaceable(37, 36);
		expectedPlaceables.remove(expectedPlaceables.indexOf(b));
		ArrayCoord i = new ArrayCoord(38, 36);
		ArrayCoord j = new ArrayCoord(37, 35);
		ArrayCoord k = new ArrayCoord(37, 37);
		expectedPlaceables.add(i);
		expectedPlaceables.add(j);
		expectedPlaceables.add(k);

//		System.out.println("Method result: " + thisGame.getPlaceable().toString());
//		System.out.println("Expected result: " + expectedPlaceables.toString());
//		System.out.println("Placed result: " + thisGame.getPlaced().toString());
//		System.out.println();
		
		assertTrue(expectedPlaceables.toString().equals(thisGame.getPlaceable().toString()));
	}

	@Test
	public void testValidPlacement(){
		Game thisGame = new Game(77, 77);
		TileCreator tileEngine = new TileCreator();
		
		//create first tile "LLLL-"	
		Tile tile1 = tileEngine.create("LLLL-");
		Tile tile2 = tileEngine.create("TLLL-");
		Tile tile3 = tileEngine.create("TTTT-");
		Tile tile4 = tileEngine.create("JJJJ-");
		thisGame.addToBoard(36, 36, tile1);
		//sets myTerritories created by the tile engine
		thisGame.setTerritories(tileEngine.getMyTerritories());
		thisGame.setMyTerritoriesSize(tileEngine.getTerritoriesSize());
			
		TerritoryPtr terPtr = new TerritoryPtr(tileEngine.getTerritoriesSize());
		
		// Starter location is added as a placeablePos, starter tile is then
		// automatically placed and the placed/placeable array lists are updated
		thisGame.updatePlaceable(36, 36);
		thisGame.addContainedTile(thisGame.getTile(36, 36), 36, 36);
		
		assertTrue(thisGame.validPlacement(tile2, 35, 36));
		thisGame.updatePlaceable(35, 36);
		assertTrue(thisGame.validPlacement(tile3, 34, 36));
		thisGame.updatePlaceable(34, 36);
		assertFalse(thisGame.validPlacement(tile4, 37, 36));
	}
	
	@Test
	public void testMergeTile(){
		Game thisGame = new Game(77, 77);
		TileCreator tileEngine = new TileCreator();
		
		//create first tile "LLLL-"	
		Tile tile1 = tileEngine.create("LLLL-");
		Tile tile2 = tileEngine.create("TLLL-");
		//decktester(tileEngine,tiles);
		Tile tile3 = tileEngine.create("TTTT-");
		Tile tile4 = tileEngine.create("LJLJ-");
		ArrayList<Integer> currentDens = new ArrayList<Integer>();
		thisGame.addToBoard(36, 36, tile1);
		//sets myTerritories created by the tile engine
		thisGame.setTerritories(tileEngine.getMyTerritories());
		thisGame.setMyTerritoriesSize(tileEngine.getTerritoriesSize());
			
		//TerritoryPtr terPtr = new TerritoryPtr(tileEngine.getTerritoriesSize());
		int[] thePointers = thisGame.getTerPtr().pointers;
		//System.out.println("From game:  " +Arrays.toString(thePointers));
		
		thisGame.mergeTile(tile2, currentDens, 35, 36);
		thisGame.addToBoard(35, 36, tile2);
		//System.out.println("Post Merge1:" + Arrays.toString(thePointers));
		
		//create expected pointersArray
		int[] expectedPointers = new int[300];
		for(int i = 0; i<300; i++)
		{ expectedPointers[i] = i; }
		expectedPointers[1] = 2;
		//System.out.println("expected:   " + Arrays.toString(expectedPointers));
		assertTrue(Arrays.equals(expectedPointers, thePointers));
		
		//Second merge
		thisGame.mergeTile(tile3, currentDens, 34, 36);
		thisGame.addToBoard(34, 36, tile3);
		expectedPointers[3] = 12;
		expectedPointers[4] = 11;
		expectedPointers[5] = 10;
		//System.out.println("Post Merge2:" + Arrays.toString(thePointers));
		assertTrue(Arrays.equals(expectedPointers, thePointers));
		
		//Third merge
		thisGame.mergeTile(tile4, currentDens, 37, 36);
		thisGame.addToBoard(37, 36, tile4);
		expectedPointers[1] = 14;
		expectedPointers[2] = 14;
		//System.out.println("Post Merge3:" + Arrays.toString(thePointers));
		
		assertTrue(Arrays.equals(expectedPointers, thePointers));
	}

	public void testEndGameScoring(){
		
	}
}
