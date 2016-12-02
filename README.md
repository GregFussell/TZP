TZP (Tiger Zone GrouP) Documentation
===========================
GrouP:  Luis Pino(Luispino), Greg Fussell(GregFussell), Logan Freedman(ldfreedman), Zach Scribner(zscrib0619), Jonathan Moriarty(Jona0thann), Tyler Barkley(TylerBarkley)
----------------------------------------------------------------------------------------------------------------------------------------
##Sprint 1:
###|| Sprint Goal ||
Understand domain and business rules.  Also, discuss appropriate architectures and schedule of the development.
##Sprint 2:
###|| Sprint Goal ||
Adding the rest of the TigerZone game functionality (territory merging, tiger placement, merging territories). Also, developing implementation of AI and introducing server connectivity capability.
###~More detail in Wiki~

######(Implemented on Windows machines)

### Instructions to Run Game
#### From Eclipse

1)on our GITHUB master branch click clone or download  

2) download zip

3) extract from said ZIP file to a location of your choosing(desktop is simple)

4) open eclipse

5) click file > import > general(dropdown)> Projects from Folder or Archive > next > directory>

6) select desktop(or whatever directory you put it in) 

7) deselect all 

8) find and select a folder titled "TZP-Master" > finish

9) open package explorer view if it is not already open (Window>show view>package explorer)

10) right click  TigerZone2 >run as>java application

11) select "NetworkInterface" > Ok

the console should print out "Usage: java groupPClient [host name] [port number] [server password] [username] [user password]

12) right click TigerZone2>export>java(dropdown)> Runnable JAR file>next>launch configuration> Network Interface-TigerZone2

13) then, click browse > create a new folder in Desktop called "TigerZoneP" > enter TigerZoneP> use TigerZoneP for the JAR file name and save it>Library Handling should be set to "extract required libraries into generate JAR>finish>Ok>Ok

14) Open Command Line(windowskey> cmd)

15) run the following line in command line

cd desktop\TigerZoneP

16) then run the following line when you're ready to connect to a server or follow the template on the following line

java -jar TigerZoneP.jar 10.136.73.30 4444 TIGERZONE TEAMP IAMP

cd [filepath to folder you want logs in]

java -jar [jarfilename.jar] [IP address] [port number] [SERVERPASSWORD] [TEAM?] [IAM?]

After the first time you follow steps 1-16, you may simply recreate and overwrite the jar file (as in step 13) to update the jar file to reflect changes

### Instructions to run test server

Note- this is now obsolete due to actual server existing, use of the actual server is a better more comprehensive test.

1) follow the steps used 10-14 from run game instructions naming the jar TESTSERVER.JAR instead of TigerZoneP

2) run the following line in command line

3) java -jar TESTSERVER.jar 4400

4) then opening and using a separate commandline instance run TigerZone.jar putting your computers name in place of the IP address(you can find your computer name going to settings>system settings>about)

the printed communication should reflect the server simulating real server output up until the first move.

###|| JUnit testing ||
1) First, download the latest version of JUnit then,

Unzip the junit.zip distribution file to a directory referred to as %JUNIT_HOME%.

Add JUnit to the classpath:
set CLASSPATH=%CLASSPATH%;%JUNIT_HOME%\junit.jar

2) Compile the project using javac command.

3) Run code using java command: java -cp [classPath] TilePlacementTest. 
*classPath* - is the list of directories or jar files where your compiled classes are, if you jave multiple entries separate them using ";" (windows) 


###|| Known bugs/issues ||
Occasionally score discrepencies will arise between our score calculation and the server's.



