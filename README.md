TZP (Tiger Zone GrouP) Documentation
===========================
GrouP:  Luis Pino(Luispino), Greg Fussell(GregFussell), Logan Freedman(ldfreedman), Zach Scribner(zscrib0619), Jonathan Moriarty(Jona0thann), Tyler Barkley(TylerBarkley)
----------------------------------------------------------------------------------------------------------------------------------------
##Sprint 1:

###||Product Backlog||
Give the player(AI) the ability to play an implementation of Carcassonne called “Tiger Zone”.  The players will have the following capabilities:
	Placing tiles -- The user can place tiles that are randomly selected by the server.
	Rotating tiles -- Tiles can be rotated by the user to access more valid movements.
	Placing meeples -- A user can place a meeple on an unclaimed territory to earn points.
	Completing cities, roads, etc -- The user can complete structures to earn immediate points and have meeples returned.
	Earning points -- iterate through all territories with meeples adding points, for fields with farmers, 3 for every bordering 		city, for incomplete cities 1 for every tile to the player that has the greatest number of meeples on the city (which could be 		both players).
Having another iteration of Carcassonne allows players to try another version if the basic Carcassonne becomes too boring.  This story will take approximately three weeks to realize and will entail the development team familiarizing ourselves with the game and collaborating on implementation.  Testing and implementing AI will involve more discussion/research on good software engineering techniques.  
In order to know if acceptance criteria are met we will ensure the game rules are met and correct point values are awarded. We will also make sure our product successfully communicates with the server and opponent AI.

##|| Sprint Goal ||
Understand domain and business rules.  Also, discuss appropriate architectures and schedule of the development.

##|| Sprint Backlog ||
System design artifacts:
   “Clean” architecture
Development planning artifacts:
   Testing artifacts(Unit, Integration, end-to-end/acceptance)
FIT/Fitnesse
Ubiquitous language (“tiles”, “sub-tiles”, “territory”)

##|| Sprint Review ||
We decided to implement “clean” architecture. 
The team defined the development planning artifacts such as product backlog, use cases, sprint backlog, UML diagrams, Testing
The team decided on Fitnesse for acceptance testing.
To avoid confusion, we agreed on a Ubiquitous language

##|| Burndown Chart (in hours) ||
Discuss product’s domain
5
Discuss architecture and design artifacts
3
UML creation
2
Diagram creation
1.5

##|| Sprint Retrospective ||
Works: Meeting in person, creating diagrams, agile methods
Does not work: Sharing ideas just over online/group messaging

Domain Model



Entities:
Player
Current Tile;
Games[]
int availableMeeples;
int score;


Game
players[];
Territories[];
Deck;
Tiles[][];


Deck
Tiles[]


Tiles
Territory subtiles[9]; 
bool shield;


Subtiles
Territory;
bool shield;
parentTile;


Territory
Type;
bool completed;
Terrain Type;
int numberOfTiles;
border;
int player1Meeples;
int player2Meeples;
int shields;
Subtiles[]


Application Services (Adapters)
Code that will communicate between the server (external elements) and application


External Details (Actors)
-- Server
-- AI


Design process diagram
Steps we will take to implement the product








































Testing diagram:
Steps we will take to complete unit, integration, and finally acceptance tests to ensure product is satisfactory. 

























































Activity diagram:
Flow chart of how game play will execute.









