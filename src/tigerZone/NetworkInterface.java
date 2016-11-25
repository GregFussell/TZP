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
	
	//passwords and usernames//to be changed based on server///
	static String serverPassword = "password";
	static String ourPassword = "password";
	static String ourPID = "groupP";
	//tracks the pid of our opponent for the current challenge
	static String opponentPID;

	 public static void main(String[] args) throws IOException {
		 //TODO configure I/O stream between NetworkInterface and GameLoop
         
	        if (args.length != 2) {
	            System.err.println(
	                "Usage: java EchoClient <host name> <port number>");
	            System.exit(1);
	        }
	 
	        String hostName = args[0];
	        int portNumber = Integer.parseInt(args[1]);
	 
	        try (
	            Socket tzSocket = new Socket(hostName, portNumber);
	            PrintWriter out = new PrintWriter(tzSocket.getOutputStream(), true);
	            BufferedReader in = new BufferedReader(new InputStreamReader(tzSocket.getInputStream()));
	        ) {
	            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
	            String fromServer;
	            String fromUser;
	            
	            //initializing variables to be configured for game communication
	            int x = 0, y = 0, rotation = 0, state = WAIT;
	            String cid = "";
	            String rid = "";
	            String gid = "";
	            String pid = "";
	            String rounds = "";
	            ArrayList<String> deck = new ArrayList<String>();
	            String move = "";
	            String tile = "";
	            String tileCount = "";
	            String time = "";
	            String ourScore = "";
	            String theirScore = "";
	            
	            //while receiving from server
	            while ((fromServer = in.readLine()) != null) {
	            	
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
	                		state = WAIT;
	                		break;
	                	case "HELLO!":
	                		fromUser = "I AM " + ourPID + " " + ourPassword;
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
	                		deck.add(tokens.nextToken());
	                		tile = deck.get(0);
	                		state = WAIT;
	                		break;
	                	case "STARTING TILE IS AT":
	                		x = Integer.valueOf(tokens.nextToken());
	                		y = Integer.valueOf(tokens.nextToken());
	                		rotation = Integer.valueOf(tokens.nextToken());
	                		state = START;
	                		break;
	                	case "THE REMAINING":
	                		tileCount = tokens.nextToken();
	                		state = WAIT;
	                		break;
	                	case "THE REMAINING TILES ARE":
	                		while(tokens.hasMoreTokens()){
	                			deck.add(tokens.nextToken());
	                		}
	                		state = DECK;
	                		break;
	                	case "MATCH BEGINS IN":
	                		time = tokens.nextToken();
	                		deck.clear();
	                		state = WAIT;
	                		break;
	                	case "MAKE YOUR MOVE IN GAME":
	                		gid = tokens.nextToken();
	                		state = MAKE_MOVE;
	                		break;
	                	case "MAKE YOUR MOVE IN GAME WITHIN":
	                		time = tokens.nextToken();
	                		state = MAKE_MOVE;
	                		break;
	                	case "MAKE YOUR MOVE IN GAME WITHIN SECOND: MOVE PLACE":
	                		tile = tokens.nextToken();
	                		state = MAKE_MOVE;
	                		break;
	                	case "MAKE YOUR MOVE IN GAME WITHIN SECONDS: MOVE PLACE":
	                		tile = tokens.nextToken();
	                		state = MAKE_MOVE;
	                		break;
	                	case "GAME":
	                		gid = tokens.nextToken();
	                		state = WAIT;
	                		break;
	                	case "GAME MOVE PLAYER":
	                		pid = tokens.nextToken();
	                		move += tokens.nextToken();
	                		if(move == "FORFEITED:") { 
	                			state = GAME_OVER;
	                			while(tokens.hasMoreTokens()){
	                				move += tokens.nextToken();
	                			}
	                			break;
	                		}
	                		tokens.nextToken();
	                		tile = tokens.nextToken();
	                		tokens.nextElement();
	                		x = Integer.valueOf(tokens.nextToken());
	                		y = Integer.valueOf(tokens.nextToken());
	                		rotation = Integer.valueOf(tokens.nextToken());
	                		if(pid != ourPID) { state = OPPONENT_MOVE; }
	                		else { state = WAIT; }
	                		break;
	                	case "GAME OVER PLAYER":
	                		while(tokens.hasMoreTokens()){
	                			if(tokens.nextToken() == ourPID)
	                				ourScore = tokens.nextToken();
	                			else if(tokens.nextToken() == opponentPID)
	                				theirScore = tokens.nextToken();
	                		}
	                		state = GAME_OVER;
	                		break;
	                	case "END OF ROUND":
	                		//end current games
	                		state = WAIT;
	                		break;	                	
	                	default:
	                		state = WAIT;
	                		break;
	                	}
	                	current += " ";
	                }
	                
	                /////////send info to games
	                //TODO configure I/O stream with gameloop and finalize conversions 
	                // 		from server protocol into game format
	                switch(state){
	                case WAIT:
	                	break;
	                case MAKE_MOVE:
	                	break;
	                case OPPONENT_MOVE:
	                	int tempX = x;
	                	x = 76 - y;
	                	y = 76 + tempX;
	                	if(rotation != 0) { rotation = (360 - rotation) / 90; }
	                	break;
	                case START:
	                	break;
	                case DECK:
	                	break;
	                case GAME_OVER:
	                	break;
	                case NEW_ROUND:
	                	break;
	                }
	                
	                
	                /////////receive info from games
	                fromUser = stdIn.readLine();
	                
	                ////////send info to server
	                if (fromUser != null) {
	                    out.println(fromUser);
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
