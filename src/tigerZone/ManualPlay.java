package tigerZone;

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
			System.out.println("Player 1 move: " + turn);
			gameA.manualMove1();
			turn++;
			System.out.println("Player 2 move: " + turn);
			gameA.manualMove2();
			turn++;
		}
		//
		gameA.scoreEndGame();
		Printer.closeLog();

	}

}
