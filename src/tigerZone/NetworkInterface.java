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
	static int startx;
	static int starty;

	//tracks the pid of our opponent for the current challenge
	static String opponentPID;

	 public static void main(String[] args) throws IOException {
		 //TODO configure I/O stream between NetworkInterface and GameLoop
         
	        if (args.length != 5) {
	            System.err.println(
	                "Usage: java EchoClient <host name> <port number> <server password> <username> <user password>");
	            System.exit(1);
	        }
	        AI Flynn;	//AI1
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
	            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
	            String fromServer;
	            String fromUser ="didn't work";
	            
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
	            String opponentScore = "";
	            
	            //while receiving from server
	            while ((fromServer = in.readLine()) != null) {
	            	fromUser = "";
	                if (fromServer.equals("THANK YOU FOR PLAYING! GOODBYE"))
	                    break;
	                System.out.println("from server: " + fromServer);
	                //////////interpret server message//////////
	                //tokenize the current message
	                StringTokenizer tokens = new StringTokenizer(fromServer, " ");
	                String current = "";
	                //piece together tokens to read message dynamically
	                while(tokens.hasMoreTokens()){
	                	current += tokens.nextToken();
	                	switch(current){
	                	case "THIS IS SPARTA!":
	                		System.out.println("");
	                		fromUser = "JOIN " + serverPassword;
	                		state = WAIT;
	                		break;
	                	case "HELLO!":
	                		fromUser = "I AM " + ourPID + " " + ourPassword;
	                		state = WAIT;
	                		break;
	                	case "NEW CHALLENGE":
	                		cid = tokens.nextToken();
	                		tokens.nextToken();
	                		tokens.nextToken();
	                		tokens.nextToken();
	                		rounds = tokens.nextToken();
	                		tokens.nextToken();
	                		state = WAIT;
	                		break;
//	                	case "NEW CHALLENGE YOU WILL PLAY":
//	                		rounds = tokens.nextToken();
//	                		state = WAIT;
//	                		break;
	                	case "BEGIN ROUND":
	                		rid = tokens.nextToken();
	                		state = NEW_ROUND;
	                		break;
	                	case "YOUR OPPONENT IS PLAYER":
	                		opponentPID = tokens.nextToken();
	                		state = WAIT;
	                		break;
	                	case "STARTING TILE IS":
	                		
	                		//deck.add(tokens.nextToken());
	                		//tile = deck.get(0);
	                		tokens.nextToken();//consumes tile
	                		tokens.nextToken();//consumes at
	                		startx = Integer.parseInt(tokens.nextToken());
	                		starty = Integer.parseInt(tokens.nextToken());
	                		rotation = Integer.parseInt(tokens.nextToken());
	                		state = START;
	                		break;
//	                	case "STARTING TILE IS AT":
//	                		startx = Integer.parseInt(tokens.nextToken());
//	                		starty = Integer.parseInt(tokens.nextToken());
//	                		rotation = Integer.parseInt(tokens.nextToken());
//	                		state = START;
//	                		break;
	                	case "THE REMAINING":
	                		tileCount = tokens.nextToken();
	                		tokens.nextToken();
	                		tokens.nextToken();
	                		tokens.nextToken();
	                		while(tokens.hasMoreTokens()){
	                			String token = tokens.nextToken();
	                			if(token.equals("]"))
	                				continue;
	                			deck.add(token);
	                			
	                		}
	                		System.out.println("should be printing deck");
	                		System.out.println(deck.toString());
	                		state = DECK;
	                		break;
//	                	case "THE REMAINING " + tileCount + " TILES ARE":
//
//	                		break;
	                	case "MATCH BEGINS IN":
	                		time = tokens.nextToken();
	                		deck.clear();
	                		state = WAIT;
	                		break;
	                	case "MAKE YOUR MOVE IN GAME":
	                		gid = tokens.nextToken();
	                		tokens.nextToken();
	                		time = tokens.nextToken();
	                		tokens.nextToken();
	                		tokens.nextToken();
	                		tokens.nextToken();
	                		tokens.nextToken();
	                		tile = tokens.nextToken();
	                		state = MAKE_MOVE;
	                		break;
//	                	case "MAKE YOUR MOVE IN GAME WITHIN":
//	                		
//	                		state = MAKE_MOVE;
//	                		break;
//	                	case "MAKE YOUR MOVE IN GAME WITHIN":
//	                		
//	                		state = MAKE_MOVE;
//	                		break;
//	                	case "MAKE YOUR MOVE IN GAME WITHIN":
//	                		
//	                		state = MAKE_MOVE;
//	                		break;
	                	case "GAME":
	                		gid = tokens.nextToken();
	                		tokens.nextToken();
	                		move += tokens.nextToken();
	                		if(move == "FORFEITED:") { 
	                			state = GAME_OVER;
	                			while(tokens.hasMoreTokens()){
	                				move += tokens.nextToken();
	                			}
	                			break;
	                		}
	                		tokens.nextToken();
	                		pid = tokens.nextToken();
	                		tokens.nextToken();//consumes placed
	                		tile = tokens.nextToken();
	                		tokens.nextToken();//consumes at
	                		x = Integer.parseInt(tokens.nextToken());
	                		y = Integer.parseInt(tokens.nextToken());
	                		rotation = Integer.valueOf(tokens.nextToken());
	                		if(pid != ourPID) { state = OPPONENT_MOVE; }
	                		else { state = WAIT; }
	                		break;
//	                	case "GAME MOVE PLAYER":
//
//	                		break;
	                	case "GAME OVER PLAYER":
	                		while(tokens.hasMoreTokens()){
	                			if(tokens.nextToken() == ourPID)
	                				ourScore = tokens.nextToken();
	                			else if(tokens.nextToken() == opponentPID)
	                				opponentScore = tokens.nextToken();
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
	                	
	                	fromUser = "GAME " + gid + " MOVE " + 1 + " PLACE " + tile + " AT " + "0 " + "-1 " + "0" + " NONE" ;
	                	break;
	                case OPPONENT_MOVE:
	                	int tempX = x;
	                	x = (GameLoop.BOARD_WIDTH / 2) - y;
	                	y = (GameLoop.BOARD_LENGTH / 2) + tempX;
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
	                
//	                if(fromUser==null)
//	                {
//	                	 fromUser = stdIn.readLine();
//	                }
	                ////////send info to server
	                if(fromUser.length() >0){
	                	//System.out.println("made it to send info");
	                	System.out.println("from user: " + fromUser);
	                    out.println(fromUser);
	                }
	            }
	            
	        }
	        catch (UnknownHostException e) {
	            System.err.println("Don't know about host " + hostName);
	            System.exit(1);
	        } catch (IOException e) {
	            System.err.println("Couldn't get I/O for the connection to " +
	                hostName);
	            System.exit(1);
	        }
	    }
	 public ArrayCoord adjustToMatrix(int CartX, int CartY){
		 int MatrixX;//(5,5)
		 int MatrixY;
		 MatrixX = CartY - (77);
		 MatrixY = CartX - (77);//cartx=MatrixY+(77-starty)
		 ArrayCoord location = new ArrayCoord(MatrixX,MatrixY);
		 return location;
	 }
	 public ArrayCoord adjustToCartesian(int MatrixX, int MatrixY){
		 int CartX;
		 int CartY;
		 CartX = MatrixY + 77;
		 CartY = MatrixX + 77;
		 ArrayCoord location = new ArrayCoord(CartX,CartY);
		 return location;
	 }
	 

}
