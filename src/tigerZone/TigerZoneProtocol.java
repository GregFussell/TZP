package tigerZone;

import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.io.*;
 

public class TigerZoneProtocol {
//    private static final int WAITING = 0;
//    private static final int SENTKNOCKKNOCK = 1;
//    private static final int SENTCLUE = 2;
//    private static final int ANOTHER = 3;
// 
//    private static final int NUMJOKES = 5;
	
	private static final int welcome = 0;
	private static final int identify = 1;
	private static final int authenticate = 2;
	private static final int beginTournament = 3;
	private static final int beginChallenge = 4;
	private static final int beginRound = 5;
	private static final int MoveP1 = 6;
	private static final int MoveP2 = 7;
	private static final int matchOver = 8;
	private static final int roundOver = 9;
	private static final int challengeOver = 10;
	private static final int tournamentOver = 11;
	private static final int rounds = 3;
	public static StringBuilder log;
    private int state = welcome;
    private int currentJoke = 0;
    private String gid; 
    private String pid;
    //private String rid;
    private int cid;
    private int rid;
    static int move = 0;
    private String password;
    private ArrayList<String> tiles = new ArrayList<String>(Arrays.asList( "JJJJ-",
    		"JJJJX","JJJJX","JJJJX","JJJJX",
    		"JJTJX", "JJTJX",
    		"TTTT-", 
    		"TJTJ-", "TJTJ-", "TJTJ-", "TJTJ-", "TJTJ-", "TJTJ-", "TJTJ-", "TJTJ-",
    		"TJJT-", "TJJT-", "TJJT-", "TJJT-", "TJJT-", "TJJT-", "TJJT-", "TJJT-", "TJJT-",
    		"TJTT-", "TJTT-","TJTT-","TJTT-",
    		"LLLL-",
    		"JLLL-","JLLL-","JLLL-","JLLL-",
    		"LLJJ-","LLJJ-","LLJJ-","LLJJ-","LLJJ-",
    		"JLJL-","JLJL-","JLJL-",
    		"LJLJ-","LJLJ-","LJLJ-",
    		"LJJJ-","LJJJ-","LJJJ-","LJJJ-","LJJJ-",
    		"JLLJ-","JLLJ-",
    		"TLJT-",
    		"TLJTP","TLJTP",
    		"JLTT-",
    		"JLTTB","JLTTB",
    		"TLTJ-","TLTJ-",
    		"TLTJD","TLTJD",
    		"TLLL-",
    		"TLTT-",
    		"TLTTP","TLTTP",
    		"TLLT-","TLLT-","TLLT-",
    		"TLLTB","TLLTB",
    		"LJTJ-",
    		"LJTJD","LJTJD",
    		"TLLLC","TLLLC"));
    private List<String> useDeck = new ArrayList<String>(Arrays.asList(
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
    		"LJTJD",
    		"TLLLC",
    		"TLLLC"));
    private String buildDeck (){
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < useDeck.size(); i++) {
            r.append(useDeck.get(i));
            r.append(" ");
            
        }
        return r.toString();
    }
    private String[] deck;
    
    public String processInput(String theInput) {
        String theOutput = null;
        System.out.println("user says: " + theInput);
        //System.out.println("does this do anything?");
        if(theInput==null)
        {
        	state=identify;
        	return "THIS IS SPARTA!";
        	
        }
        StringTokenizer input = new StringTokenizer(theInput, " ");
        
        String x;
        String y;
        String orientation;
        String Tile;
        if(state==welcome){
        	theOutput="THIS IS SPARTA!";
        	state = identify;
        }
        else if(state==identify){
        	System.out.println("made it here");
        	if(input.hasMoreTokens()){
        		if(input.nextToken().equals("JOIN")){
        			gid = input.nextToken();
        		}
        		theOutput="HELLO!";
        		state = authenticate;
        	}
//        	if(input.hasMoreElements()){
//        		if(input.nextToken().equals("I") && input.nextToken().equals("AM")){
//        			System.out.println(password + pid);
//        			pid = input.nextToken();
//        			password = input.nextToken();
//        			
//        			theOutput = "WELCOME " + pid + " PLEASE WAIT FOR THE NEXT CHALLENGE" + "\n" 
//        					+ "NEW CHALLENGE " + cid 
//                			+ " YOU WILL PLAY " + rid + "MATCH \n" 
//                			+ "BEGIN ROUND " + rid + " OF " + rounds + "\n"
//                			+  "YOUR OPPONENT IS PLAYER " + pid + "\n"
//                			+ "STARTING TILE IS TLTJ- AT 000" + "\n" 
//                			+ "THE REMAINING " + useDeck.size()
//                			+ "TILES ARE"
//                			+ " [ " + buildDeck() + "]" + "\n"
//                			+ "MATCH BEGINS IN 15 SECONDS" +"\n"
//                			+ "MAKE YOUR MOVE IN GAME A WITHIN 1 SECOND: MOVE 1 PLACE JJJJ-";
//        			state=MoveP1;
//        		}
//        }
        }
        else if(state==authenticate)
        {
        	if(input.hasMoreElements()){
        		if(input.nextToken().equals("I") && input.nextToken().equals("AM")){
        			pid = input.nextToken();
        			password = input.nextToken();
        			System.out.println(useDeck.size());
        			theOutput = "WELCOME " + pid + " PLEASE WAIT FOR THE NEXT CHALLENGE" + "\n" 
        					+ "NEW CHALLENGE " + cid 
                			+ " YOU WILL PLAY " + rid + " MATCH \n" 
                			+ "BEGIN ROUND " + rid + " OF " + rounds + "\n"
                			+  "YOUR OPPONENT IS PLAYER " + pid + "\n"
                			+ "STARTING TILE IS TLTJ- AT " + "0 " + "0 " +"0" + "\n" 
                			+ "THE REMAINING " + useDeck.size()
                			+ " TILES ARE"
                			+ " [ " + buildDeck() + "]" + "\n"
                			+ "MATCH BEGINS IN 15 SECONDS" +"\n"
                			+ "MAKE YOUR MOVE IN GAME A WITHIN 1 SECOND: MOVE 1 PLACE JJJJ-";
        			state=MoveP1;
        		}
        		
        	}
        	
    }
        /*
        else if(state==beginTournament){
        	state = beginChallenge;
        }
        
        else if(state==beginRound){
        	theOutput = "NEW CHALLENGE " + cid 
        			+ " YOU WILL PLAY " + rid + "MATCH \n" 
        			+ "BEGIN ROUND " + rid + " OF " + rounds + "\n"
        			+  "YOUR OPPONENT IS PLAYER " + pid + "\n"
        			+ "STARTING TILE IS TLTJ- AT 000" + "\n" 
        			+ "THE REMAINING " + useDeck.size()
        			+ "TILES ARE"
        			+ " [ " + buildDeck() + "]";
        }
        */
        //GAME <gid> PLACE <tile> AT <x> <y> <orientation> NONE 
        else if(state == MoveP1){
        	System.out.println(input.nextToken());
        	System.out.println(input.nextToken());
        	System.out.println("before tile " + input.nextToken());
        	System.out.println(input.nextToken());
        	System.out.println(input.nextToken());
        	Tile = input.nextToken();
        	System.out.println(Tile);
        	System.out.println(input.nextToken());
        	x = input.nextToken();
        	y = input.nextToken();
        	orientation = input.nextToken();
        	
        	//GAME <gid> MOVE <#> PLAYER <pid> <move> 
        	//PLACED <tile> AT <x> <y> <orientation> NONE
        	theOutput = "GAME " + gid + " MOVE" + " 1 " + "PLAYER " + " 1 " + " PLACED " + Tile + " AT " + "0" + " " + "-1" + " " + orientation + " NONE" + "\n" 
                	+ "THANK YOU FOR PLAYING! GOODBYE";
        }
        else if(state == MoveP2){
        	
        }
        
        System.out.println("Server says: " + theOutput);
        return theOutput;
    }
}