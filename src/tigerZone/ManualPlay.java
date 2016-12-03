package tigerZone;
//this was a class created to determine a score discrepancy between the server and our own scoring methods
public class ManualPlay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Printer.createNewLog();
		
		String[] tileSet = { 
			"TLTJ-",
			"TJTT-",
			"LLJJ-",
			"TLLT-",
			"TJTJ-",
			"LJLJ-",
			"TJJT-",
			"JLTTB",
			"TLTTP",
			"TJJT-",
			"JLLL-",
			"JJJJ-",
			"TLLLC",
			"LJLJ-",
			"TLTJ-"
		};
		
		GameLoop gameA = new GameLoop(tileSet, 0);
		
		int turn = 1;
		while(turn < 15){
			System.out.println("Player 1 move " + turn + " place " + tileSet[turn]);
			gameA.manualMove1();
			turn++;
			if(turn >= 15) { break; }
			System.out.println("Player 2 move " + turn + " place " + tileSet[turn]);
			gameA.manualMove2();
			turn++;
		}
		//
		gameA.scoreEndGame();
		Printer.closeLog();

	}

}
