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
		ArrayCoord i = new ArrayCoord(36, 36);
		ArrayCoord j = new ArrayCoord(38, 36);
		ArrayCoord k = new ArrayCoord(37, 35);
		ArrayCoord l = new ArrayCoord(37, 37);
		expectedPlaceables.add(i);
		expectedPlaceables.add(j);
		expectedPlaceables.add(k);
		expectedPlaceables.add(l);

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
		thisGame.addContainedTile(thisGame.getTile(36, 36), terPtr, 36, 36);
		
		assertTrue(thisGame.validPlacement(tile2, 35, 36, terPtr));
		thisGame.updatePlaceable(35, 36);
		assertTrue(thisGame.validPlacement(tile3, 34, 36, terPtr));
		thisGame.updatePlaceable(34, 36);
		assertFalse(thisGame.validPlacement(tile4, 37, 36, terPtr));
	}
	
	String[] tiles = new String[] {
			"JJJJ-",
			"JJJJX",
			"JJJJX",
			"JJJJX",
			"JJJJX",
			"JJTJX", 
			"JJTJX",
			"TTTT-", 
			"TJTJ-", 
			"TJTJ-", 
			"TJTJ-", 
			"TJTJ-", 
			"TJTJ-", 
			"TJTJ-", 
			"TJTJ-", 
			"TJTJ-",
			"TJJT-", 
			"TJJT-", 
			"TJJT-", 
			"TJJT-", 
			"TJJT-", 
			"TJJT-", 
			"TJJT-", 
			"TJJT-", 
			"TJJT-",
			"TJTT-", 
			"TJTT-",
			"TJTT-",
			"TJTT-",
			"LLLL-",
			"JLLL-",
			"JLLL-",
			"JLLL-",
			"JLLL-",
			"LLJJ-",
			"LLJJ-",
			"LLJJ-",
			"LLJJ-",
			"LLJJ-",
			"JLJL-",
			"JLJL-",
			"JLJL-",
			"LJLJ-",
			"LJLJ-",
			"LJLJ-",
			"LJJJ-",
			"LJJJ-",
			"LJJJ-",
			"LJJJ-",
			"LJJJ-",
			"JLLJ-",
			"JLLJ-",
			"TLJT-",
			"TLJTP",
			"TLJTP",
			"JLTT-",
			"JLTTB",
			"JLTTB",
			"TLTJ-",
			"TLTJ-",
			"TLTJD",
			"TLTJD",
			"TLLL-",
			"TLTT-",
			"TLTTP",
			"TLTTP",
			"TLLT-",
			"TLLT-",
			"TLLT-",
			"TLLTB",
			"TLLTB",
			"LJTJ-",
			"LJTJD",
			/*"LJTJD",
			/*"TLLLC",
			"TLLLC"*/
	};
	
	public void decktester(TileCreator tileEngine, String[] tiles){
		for(String tile: tiles){
			tileEngine.create(tile);
		}
	}
	
	@Test
	public void testMergeTile(){
		Game thisGame = new Game(77, 77);
		TileCreator tileEngine = new TileCreator();
		
		//create first tile "LLLL-"	
		//Tile tile1 = tileEngine.create("LLLL-");
		//Tile tile2 = tileEngine.create("TLLL-");
		decktester(tileEngine,tiles);
		//Tile tile3 = tileEngine.create("TTTT-");
		//Tile tile4 = tileEngine.create("JJJJ-");
		ArrayList<Integer> currentDens = new ArrayList<Integer>();
		//thisGame.addToBoard(36, 36, tile1);
		//sets myTerritories created by the tile engine
		thisGame.setTerritories(tileEngine.getMyTerritories());
		thisGame.setMyTerritoriesSize(tileEngine.getTerritoriesSize());
			
		TerritoryPtr terPtr = new TerritoryPtr(tileEngine.getTerritoriesSize());
		int[] thePointers = terPtr.pointers;
		System.out.println("territoryPtr: " + Arrays.toString(thePointers));
		
		// Starter location is added as a placeablePos, starter tile is then
		// automatically placed and the placed/placeable array lists are updated
		thisGame.updatePlaceable(36, 36);
		thisGame.addContainedTile(thisGame.getTile(36, 36), terPtr, 36, 36);
		
		//public void mergeTile(Tile myTile, TerritoryPtr terPtr, ArrayList<Integer> currentDens, int x, int y)
		//thisGame.mergeTile(tile2, terPtr, currentDens, 35, 36);
		//System.out.println("updatedTerritoryPtr: " + Arrays.toString(thePointers));

		//assertTrue(expectedCurrentIDs?.equal(thisGame.currentIDs));
	}
}
