package tigerZone;

import java.util.ArrayList;

public class Tile {

	Subtile subtiles[][];
	static int counter = 0;
	int position[] = new int[2];
	boolean Boar;
	//TODO add a get method so we can get a subtile based on an ArrayCoord, then we should name ArrayCoords with names like rightsidemiddle for clarity
	boolean shield;

	public Tile(String territories) {
		id=counter;
		counter++;
		subtiles = new Subtile[5][5];
		for (int i = 0; i < 5; i++) {
			for(int j =0; j < 5; j++){
				subtiles[i][j] = new Subtile(territories.charAt(j*5+i),i,j);
			}
		}

		//dfs(new Territory(subtiles[1][0].territoryType),subtiles[0][0]);
	}
	public ArrayList<Subtile> findadj(Subtile subtile)//finds adjacent subtiles given a subtile for purposes of merging within a tile
	{
		   ArrayList<Subtile> adj = new ArrayList<Subtile>();
		   if(subtile.loc.y>0 && subtiles[subtile.loc.x][subtile.loc.y-1]!=null  )
			   adj.add(subtiles[subtile.loc.x][subtile.loc.y-1]);
		   if(subtile.loc.y<4 && subtiles[subtile.loc.x][subtile.loc.y+1]!=null)
			   adj.add(subtiles[subtile.loc.x][subtile.loc.y+1]);
		   if(subtile.loc.x >0  && subtiles[subtile.loc.x-1][subtile.loc.y]!=null)
			   adj.add(subtiles[subtile.loc.x-1][subtile.loc.y]);
		   if(subtile.loc.x<4 && subtiles[subtile.loc.x+1][subtile.loc.y]!=null)
			   adj.add(subtiles[subtile.loc.x+1][subtile.loc.y]);
		   return adj;
	}

	public Subtile[][] Rotate(Subtile[][] subtiles, int rotationDegree) {
		if(rotationDegree==0)
		{
			return subtiles;
		}
		else
		{
			Subtile newSubtiles[][] = new Subtile[5][5];
			for(int j=subtiles[0].length-1; j>=0; j--){
			    for(int k=0; k<subtiles.length; k++){
			        newSubtiles[k][j] = subtiles[subtiles.length-j-1][k];
			    }
			}
			return Rotate(newSubtiles,rotationDegree-1);
		}

	}
	public void Rotate(int rotationDegree)
	{
		subtiles = Rotate(subtiles,rotationDegree%4);
	}
	
}
