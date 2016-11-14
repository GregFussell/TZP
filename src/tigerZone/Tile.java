package tigerZone;

import java.util.ArrayList;

public class Tile {

	Subtile subtiles[][];

	int position[] = new int[2];
	int id;

	boolean shield;

	public Tile(String territories, int identifier) {
		subtiles = new Subtile[5][5];
		for (int i = 0; i < 5; i++) {
			for(int j =0; j < 5; j++){
				subtiles[i][j] = new Subtile(territories.charAt(j*5+i),i,j);
			}
		}
		id = identifier;
		dfs(new Territory(subtiles[1][0].territoryType),subtiles[0][0]);
	}
	public void findTerritories(ArrayCoord subtile){
		
		    
		  
	}
	public void dfs(Territory territory, Subtile subtile)  
	{  
//	  if (subtile.territory==null){
//		  return;
//	  }
	  //System.out.print(subtile.territoryType + "\t");  
		subtile.territory=territory;
	  ArrayList<Subtile> adj= findadj(subtile);  
	  for (int i = 0; i < adj.size(); i++) {  
		  for(Subtile sub:adj){
			  if
		  }
		  Subtile n=adj.get(i);
		  if(n.territory!=null)
			  continue;
		  if(n.territoryType=='x')
			  continue;
		  else if(n.territoryType==territory.type)
		  {
			  n.territory=territory;
			  dfs(n.territory,n);
		  }
		  else if(subtile.territoryType=='j' && n.territoryType=='l'){
			  territory.Lakes.add(n.territory);
			  dfs(new Territory(n.territoryType),n);
		  }
		  else if(subtile.territoryType=='j' && n.territoryType=='d'){
			  territory.Dens.add(n.territory);
			  dfs(new Territory(n.territoryType),n);
		  }
		  else{
			  dfs(new Territory(n.territoryType),n);
		  }
			  
//		  if(n!=null && !n.visited)  
//		  {  
//			  dfs(adj,n);  
//			  n.visited=true;  
//		  }
	  }
	}
	public ArrayList<Subtile> findadj(Subtile subtile)
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
