package tigerZone;

import java.io.*;
import java.net.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class NetworkInterface {
	
	//states of active games
	static final int WAIT = 0;
	static final int MAKE_MOVE = 1;
	static final int OPPONENT_MOVE = 2;
	static final int START = 3;
	static final int DECK = 4;
	static final int GAME_OVER = 5;
	static final int NEW_ROUND = 6;
	

	//tracks the pid of our opponent for the current challenge
	static String opponentPID;

	 public static void main(String[] args) throws IOException {
		 //TODO configure I/O stream between NetworkInterface and GameLoop
         
	        if (args.length != 5) {
	            System.err.println(
	                "Usage: java groupPClient <host name> <port number> <server password> <username> <user password>");
	            System.exit(1);
	        }
	 
	        String hostName = args[0];
	        int portNumber = Integer.parseInt(args[1]);
	    	String serverPassword = args[2];
	    	String ourPID = args[3];
	    	String ourPassword = args[4];
	 
	        try (
	            Socket tzSocket = new Socket(hostName, portNumber);
	            PrintWriter out = new PrintWriter(tzSocket.getOutputStream(), true);
	            BufferedReader in = new BufferedReader(new InputStreamReader(tzSocket.getInputStream()));
	        ) {
	            //BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
	            String fromServer;
	            String fromUser;

	            //initializing variables to be configured for game communication
	            int x = 0, y = 0, rotation = 0, startRotation = 0, state = WAIT, movenum = 0;
	            int[] newMove = new int[5];
	            String cid = "";
	            String rid = "";
	            String gid = "";
	            String first = "";
	            String second = "";
	            String pid = "";
	            String rounds = "";
	            String deck[] = null;
	            String move = "";
	            String tile = "";
	            int tileCount = 0;
	            String time = "";
	            String ourScore = "";
	            String opponentScore = "";
	            
	            GameLoop gameA = null;
	            GameLoop gameB = null;

	            //while receiving from server
	            while ((fromServer = in.readLine()) != null) {
	            	x = 0; y = 0; rotation = 0; state = WAIT;
	            	System.out.println("Server: " + fromServer);
	                if (fromServer.equals("THANK YOU FOR PLAYING! GOODBYE"))
	                    break;
	                
	                //////////interpret server message//////////
	                //tokenize the current message
	                StringTokenizer tokens = new StringTokenizer(fromServer, " ");
	                String current = "";
	                //piece together tokens to read message dynamically
	                while(tokens.hasMoreTokens()){
	                	current += tokens.nextToken();
	                	switch(current){
	                	case "THIS IS SPARTA!":
	                		fromUser = "JOIN " + serverPassword;
	                		out.println(fromUser);
	                		state = WAIT;
	                		break;
	                	case "HELLO!":
	                		fromUser = "I AM " + ourPID + " " + ourPassword;
	                		out.println(fromUser);
	                		state = WAIT;
	                		break;
	                	case "NEW CHALLENGE":
	                		cid = tokens.nextToken();
	                		state = WAIT;
	                		break;
	                	case "NEW CHALLENGE YOU WILL PLAY":
	                		rounds = tokens.nextToken();
	                		state = WAIT;
	                		break;
	                	case "BEGIN ROUND":
	                		rid = tokens.nextToken();
	                		state = NEW_ROUND;
	                		break;
	                	case "YOUR OPPONENT IS PLAYER":
	                		opponentPID = tokens.nextToken();
	                		state = WAIT;
	                		break;
	                	case "STARTING TILE IS":
	                		tile = tokens.nextToken();
	                		state = WAIT;
	                		break;
	                	case "STARTING TILE IS AT":
	                		x = Integer.valueOf(tokens.nextToken());
	                		y = Integer.valueOf(tokens.nextToken());
	                		startRotation = Integer.valueOf(tokens.nextToken());
	                		state = START;
	                		break;
	                	case "THE REMAINING":
	                		tileCount = Integer.valueOf(tokens.nextToken());
	                		state = WAIT;
	                		break;
	                	case "THE REMAINING TILES ARE":
	                		deck = new String[tileCount+1]; tokens.nextToken();
	                		deck[0] = tile;
	                		for(int i = 1; i < tileCount + 1; i++){
	                			deck[i] = tokens.nextToken();
	                		} tokens.nextToken();
	                		state = DECK;
	                		break;
	                	case "MATCH BEGINS IN":
	                		time = tokens.nextToken();
	                		deck = null;
	                		state = WAIT;
	                		break;
	                	case "MAKE YOUR MOVE IN GAME":
	                		gid = tokens.nextToken();
	                		if(first == ""){
	                			first = gid;
	                		}
	                		else if(second == ""){
	                			second = gid;
	                		}
	                		state = MAKE_MOVE;
	                		break;
	                	case "MAKE YOUR MOVE IN GAME WITHIN":
	                		time = tokens.nextToken();
	                		tokens.nextToken();
	                		tokens.nextToken();
	                		movenum = Integer.valueOf(tokens.nextToken());
	                		state = MAKE_MOVE;
	                		break;
	                	case "MAKE YOUR MOVE IN GAME WITHIN PLACE":
	                		tile = tokens.nextToken();
	                		state = MAKE_MOVE;
	                		break;
	                	case "GAME":
	                		gid = tokens.nextToken();
	                		state = WAIT;
	                		break;
	                	case "GAME MOVE":
	                		movenum = Integer.valueOf(tokens.nextToken());
	                		break;
	                	case "GAME MOVE PLAYER":
	                		pid = tokens.nextToken();
	                		state = WAIT;
	                		break;
	                	case "GAME MOVE PLAYER PLACED":
	                		tile = tokens.nextToken();
	                		tokens.nextToken();
	                		x = Integer.valueOf(tokens.nextToken());
	                		y = Integer.valueOf(tokens.nextToken());
	                		rotation = Integer.valueOf(tokens.nextToken());
	                		if(pid != ourPID) { state = OPPONENT_MOVE; }
	                		else { state = WAIT; }
	                		break;
	                	case "GAME MOVE PLAYER PLACED NONE":
	                		newMove[3] = 3;
	                		newMove[4] = -1;
	                		break;
	                	case "GAME MOVE PLAYER PLACED CROCODILE":
	                		newMove[3] = 2;
	                		newMove[4] = -1;
	                		break;
	                	case "GAME MOVE PLAYER PLACED TIGER":
	                		newMove[3] = 1;
	                		newMove[4] = Integer.valueOf(tokens.nextToken());
	                		break;
	                	case "GAME MOVE PLAYER TILE":
	                		tile = tokens.nextToken();
	                		tokens.nextToken();
	                		break;
	                	case "GAME MOVE PLAYER TILE PASSED":		
	                		rotation = -1;
	                		break;
	                	case "GAME MOVE PLAYER TILE RETRIEVED":
	                		rotation = -1;
	                		break;
	                	case "GAME MOVE PLAYER TILE ADDED":			
	                		rotation = -1;
	                		break;
	                	case "GAME MOVE PLAYER FORFEITED:":
	                		state = GAME_OVER;
	                		move += "FORFEITED:";
                			while(tokens.hasMoreTokens()){
                				move += " " + tokens.nextToken();
                			}
	                		break;
	                	case "GAME OVER PLAYER":
	                		while(tokens.hasMoreTokens()){
	                			String temp = tokens.nextToken();
	                			if(temp == ourPID)
	                				ourScore = tokens.nextToken();
	                			else if(temp == opponentPID)
	                				opponentScore = tokens.nextToken();
	                		}
	                		state = GAME_OVER;
	                		break;
	                	case "END OF ROUND":
	                		state = WAIT;
	                		break;
	                	case "END OF CHALLENGES":
	                		
	                		break;
	                	default:
	                		state = WAIT;
	                		break;
	                	} 
	                	current += " "; 
	                }
	                
	                /////////send info to games
	                switch(state){
	                case WAIT:
	                	break;
	                case MAKE_MOVE:
	                	//add conversions
	                	int AI[] = new int[5];
	                	if(gid == first){
	                		AI = gameA.makeMoveFlynn(tile);
	                	}
	                	else{
	                		AI = gameB.makeMoveFlynn(tile);
	                	}
	                	if(AI[0] == -1){
	                		fromUser = "GAME " + gid + " MOVE " + movenum + " TILE " + tile + " UNPLACEABLE PASS";
	                	}
	                	else{
	                		x = AI[2] - (GameLoop.BOARD_WIDTH / 2);
	                		y = (GameLoop.BOARD_LENGTH / 2) - AI[1];
	                		if(AI[0] != 0) { rotation = 360 - (AI[0] * 90); }
	                		else { rotation = AI[0]; }
	                		fromUser = "GAME " + gid + " MOVE " + movenum + " PLACE " + tile + " AT " + x + " " + y + " " + rotation;
	                		if(AI[3] == 3){ // none
	                			fromUser += " NONE";
	                		}
	                		else if(AI[3] == 2){ //croc
	                			fromUser += " CROCODILE";
	                		}
	                		else if(AI[3] == 1){ // tiger
	                			fromUser += " TIGER " + AI[4];
	                		}
	                	}
	                	System.out.println("Client: "  + fromUser);
	                	out.println(fromUser);
	                	break;
	                case OPPONENT_MOVE:
	                	if(rotation != -1){
		                	int tempX = x;
		                	x = (GameLoop.BOARD_WIDTH / 2) - y;
		                	y = (GameLoop.BOARD_LENGTH / 2) + tempX;
		                	if(rotation != 0) { rotation = (360 - rotation) / 90; }
		                	newMove[0] = rotation;
		                	newMove[1] = x;
		                	newMove[2] = y;
		                	if(gid == first){
		                		gameA.opponentMove(tile, newMove);
		                	}else{
		                		gameB.opponentMove(tile, newMove);
		                	}
	                	}
	                	else {
	                		if(gid == first){
	                			gameA.removeUnplaceable();
	                		}
	                		else {
	                			gameB.removeUnplaceable();
	                		}
	                	}
	                	break;
	                case START:
	                	break;
	                case DECK:
	                	if(startRotation != 0) { startRotation = (360 - startRotation) / 90; }
	                	gameA = new GameLoop(deck, startRotation);
	                	gameB = new GameLoop(deck, startRotation);
	                	break;
	                case GAME_OVER:
	                	if(gid == first){
	                		//gameA.scoreEndGame();
	                		gameA = null;
	                	}else{
	                		//gameB.scoreEndGame();
	                		gameB = null;
	                	}
	                	first = "";
	                	second = "";
	                	ourScore = "";
	                	opponentScore = "";
	                	startRotation = 0;
	                	break;
	                case NEW_ROUND:
	                	break;
	                }
	                
	                
	            }
	            
	        } catch (UnknownHostException e) {
	            System.err.println("Don't know about host " + hostName);
	            System.exit(1);
	        } catch (IOException e) {
	            System.err.println("Couldn't get I/O for the connection to " +
	                hostName);
	            System.exit(1);
	        }
	    }
	

}
