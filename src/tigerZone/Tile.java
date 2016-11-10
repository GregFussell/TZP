package tigerZone;
//tile class!
public class Tile {
	
	Subtile fields[];
	
	int position[] = new int[2];
	int id;
	
	boolean shield;
	
	public Tile(String territories, int identifier) {
		fields = new Subtile[9];
		for(int i = 0; i < 9; i++){
			fields[i] = new Subtile(territories.charAt(i));
		}
		
//		fields[0] = new Subtile(zero);
//		fields[1] = new Subtile(one);
//		fields[2] = new Subtile(two);
//		fields[3] = new Subtile(three);
//		fields[4] = new Subtile(four);
//		fields[5] = new Subtile(five);
//		fields[6] = new Subtile(six);
//		fields[7] = new Subtile(seven);
//		fields[8] = new Subtile(eight);
		id = identifier;
	}
	
	public void Rotate()
	{
		Subtile temp;
		temp = fields[6];
		fields[6]=fields[8];
		fields[8]=fields[2];
		fields[2]=fields[0];
		fields[0]=temp;
		
		temp=fields[3];
		fields[3]=fields[7];
		fields[7]=fields[5];
		fields[5]=fields[1];
		fields[1]=temp;
		
	}
}
