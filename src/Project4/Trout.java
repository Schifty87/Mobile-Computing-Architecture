package Project4;

import java.util.ArrayList;

public class Trout {
Trout(){}
	
	/*figure out where exactly the point is located
	 * important in figuring out connections, distance, and time*/
	public Map locate(int Xcoord, int Ycoord, ArrayList<Map> M, ArrayList<Coordinate> P){
		
		int X1 = 0;
		int X2 = 0;
		int Y1 = 0;
		int Y2 = 0;
		int found = 0;
		
		for(int i=0; i<M.size(); i++){
			//identify the individual points
			String A = M.get(i).getInitial();
			String B = M.get(i).getNeighbor();
			//find the coordinates for A
			for(int j=0; j<P.size();j++){
				if(A.equals(P.get(j).getNode())){
					X1 = P.get(j).getX();
					Y1 = P.get(j).getY();				
				}
			}
			
			//find the coordinates for B
			for(int j=0; j<P.size();j++){
				if(B.equals(P.get(j).getNode())){
					X2 = P.get(j).getX();
					Y2 = P.get(j).getY();
					
				}
			}
			
			//throw possible coordinates into new ArrayList
			ArrayList<Coordinate> N = new ArrayList<Coordinate>();
			
			/*figure out where the point is located
			 * if X or Y coordinates are equal to eachother,
			 * only have to manipulate other values*/
			if(X1==X2){
				if(Y1>Y2){
					int temp = Y1;
					do{
						temp--;
						N.add(new Coordinate("NN", X1, temp));
					}while(temp>Y2+1);
					
				}
				else{
					int temp = Y2;
					do{
						temp--;
						N.add(new Coordinate("NN", X1, temp));
					}while(temp>Y1+1);
					
				}
			}
			if(Y1==Y2){
				if(X1>X2){
					int temp = X1;
					do{
						temp--;
						N.add(new Coordinate("NN", temp, Y1));
					}while(temp>X2+1);
					
				}
				else{
					int temp = X2;
					do{
						temp--;
						N.add(new Coordinate("NN", temp, Y2));
					}while(temp>X1+1);
					
				}
			}
			
			
			/*Go through coordinate array
			 * if it is found, then return
			 * the map element that contains it*/
			for(int j=0; j<N.size(); j++){
				if(Xcoord == N.get(j).getX() && Ycoord == N.get(j).getY()){
					found = 1;
					return M.get(i);
					
					
				}
			}		
		}
		//point was not found between nodes
		return null;
	}
	
	/*determine the distance and speed of new point to it's neighbors
	 * create new connections to be later added to the original in the main*/
	public ArrayList<Map> down(Map M, ArrayList<Coordinate> P, int Xcoord, int Ycoord, String name){
		String A = M.getInitial();
		String B = M.getNeighbor();
		int X1 = 0;
		int X2 = 0;
		int Y1 = 0;
		int Y2 = 0;
		String P1 = null;
		String P2 = null;
		
		//find the coordinates for A
		for(int i=0; i<P.size(); i++){
			if(A.equals(P.get(i).getNode())){
				X1 = P.get(i).getX();
				Y1 = P.get(i).getY();
				P1 = P.get(i).getNode();
			}
		}
		//find the coordinates for B
		for(int i=0; i<P.size(); i++){
			if(B.equals(P.get(i).getNode())){
				X2 = P.get(i).getX();
				Y2 = P.get(i).getY();
				P2 = P.get(i).getNode();
			}
		}
		
		ArrayList<Map> M1 = new ArrayList<Map>();
		
		/*find the difference in Y coordinate values
		 * Either the X or Y coords are going to be different
		 * find new connections both to and from new coordinate*/
		if(Xcoord==X1){
			if(Y1 > Y2){
				int dist1 = Y1 - Ycoord;
				double time1 = (double)dist1/M.getSpeed();
				M1.add(new Map(name, P1, M.getSpeed(), dist1, time1));
				M1.add(new Map(P1, name, M.getSpeed(), dist1, time1));
				int dist2 = Ycoord-Y2;
				double time2 = (double)dist2/M.getSpeed();
				M1.add(new Map(name, P2, M.getSpeed(), dist2, time2));
				M1.add(new Map(P2, name, M.getSpeed(), dist2, time2));
			}
			if(Y2 > Y1){
				int dist1 = Y2 - Ycoord;
				double time1 = (double)dist1/M.getSpeed();
				M1.add(new Map(name, P2, M.getSpeed(), dist1, time1));
				M1.add(new Map(P2, name, M.getSpeed(), dist1, time1));
				int dist2 = Ycoord-Y1;
				double time2 = (double)dist2/M.getSpeed();
				M1.add(new Map(name, P1, M.getSpeed(), dist2, time2));
				M1.add(new Map(P1, name, M.getSpeed(), dist2, time2));
			}
		}
		else{
			if(X1 > X2){
				int dist1 = X1 - Xcoord;
				double time1 = (double)dist1/M.getSpeed();
				M1.add(new Map(name, P1, M.getSpeed(), dist1, time1));
				M1.add(new Map(P1, name, M.getSpeed(), dist1, time1));
				int dist2 = Xcoord-X2;
				double time2 = (double)dist2/M.getSpeed();
				M1.add(new Map(name, P2, M.getSpeed(), dist2, time2));
				M1.add(new Map(P2, name, M.getSpeed(), dist2, time2));
			}
			if(X2 > X1){
				int dist1 = X2 - Xcoord;
				double time1 = (double)dist1/M.getSpeed();
				M1.add(new Map(name, P2, M.getSpeed(), dist1, time1));
				M1.add(new Map(P2, name, M.getSpeed(), dist1, time1));
				int dist2 = Xcoord-X1;
				double time2 = (double)dist2/M.getSpeed();
				M1.add(new Map(name, P1, M.getSpeed(), dist2, time2));
				M1.add(new Map(P1, name, M.getSpeed(), dist2, time2));
			}
		}
		return M1;
	}
	
	//search coordinate array to determine if user input already exists
	public String alreadyMade(int X, int Y, ArrayList<Coordinate> P){
		for(int i=0;i<P.size();i++){
			if(P.get(i).getX()==X && P.get(i).getY()==Y){
				return P.get(i).getNode();
			}
		}
		return null;
	}
}
