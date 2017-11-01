package Project3;

import java.util.ArrayList;

class Trout {

	
	Trout(){}
	
	public map locate(int Xcoord, int Ycoord, ArrayList<map> M, ArrayList<point> P){
		
		int X1 = 0;
		int X2 = 0;
		int Y1 = 0;
		int Y2 = 0;
		int found = 0;
		
		for(int i=0; i<M.size(); i++){
			//identify the individual points
			String A = M.get(i).getA();
			String B = M.get(i).getB();
			//find the coordinates for A
			for(int j=0; j<P.size();j++){
				if(A.equals(P.get(j).getPoint())){
					X1 = P.get(j).getX();
					Y1 = P.get(j).getY();
					
				}
			}
			
			//find the coordinates for B
			for(int j=0; j<P.size();j++){
				if(B.equals(P.get(j).getPoint())){
					X2 = P.get(j).getX();
					Y2 = P.get(j).getY();
					
				}
			}
			//System.out.println(A + " " + X1 + " " + Y1);
			//System.out.println(B + " " + X2 + " " + Y2);
			
			//throw possible coordinates into new ArrayList
			ArrayList<point> N = new ArrayList<point>();
			
			if(X1==X2){
				if(Y1>Y2){
					int temp = Y1;
					do{
						temp--;
						N.add(new point("NN", X1, temp));
						//System.out.println(X1 + " " + temp);
					}while(temp>Y2+1);
					
				}
				else{
					int temp = Y2;
					do{
						temp--;
						N.add(new point("NN", X1, temp));
						//System.out.println(X1 + " " + temp);
					}while(temp>Y1+1);
					
				}
			}
			if(Y1==Y2){
				if(X1>X2){
					int temp = X1;
					do{
						temp--;
						N.add(new point("NN", temp, Y1));
						//System.out.println(temp + " " + Y1);
					}while(temp>X2+1);
					
				}
				else{
					int temp = X2;
					do{
						temp--;
						N.add(new point("NN", temp, Y2));
						//System.out.println(temp + " " + Y1);
					}while(temp>X1+1);
					
				}
			}
			
			
			
			for(int j=0; j<N.size(); j++){
				if(Xcoord == N.get(j).getX() && Ycoord == N.get(j).getY()){
					//System.out.println("Found");
					found = 1;
					return M.get(i);
					
					
				}
			}		
		}
		return null;
	}
	
	public ArrayList<map> down(map M, ArrayList<point> P, int Xcoord, int Ycoord){
		String A = M.getA();
		String B = M.getB();
		int X1 = 0;
		int X2 = 0;
		int Y1 = 0;
		int Y2 = 0;
		String P1 = null;
		String P2 = null;
		
		//find the coordinates for A
		for(int i=0; i<P.size(); i++){
			if(A.equals(P.get(i).getPoint())){
				X1 = P.get(i).getX();
				Y1 = P.get(i).getY();
				P1 = P.get(i).getPoint();
			}
		}
		//find the coordinates for B
		for(int i=0; i<P.size(); i++){
			if(B.equals(P.get(i).getPoint())){
				X2 = P.get(i).getX();
				Y2 = P.get(i).getY();
				P2 = P.get(i).getPoint();
			}
		}
		
		ArrayList<map> M1 = new ArrayList<map>();
		//find the difference in Y coordinate values
		if(Xcoord==X1){
			if(Y1 > Y2){
				int dist1 = Y1 - Ycoord;
				double time1 = (double)dist1/M.getSpeed();
				M1.add(new map("new", P1, M.getSpeed(), dist1, time1));
				int dist2 = Ycoord-Y2;
				double time2 = (double)dist2/M.getSpeed();
				M1.add(new map("new", P2, M.getSpeed(), dist2, time2));
			}
			if(Y2 > Y1){
				int dist1 = Y2 - Ycoord;
				double time1 = (double)dist1/M.getSpeed();
				M1.add(new map("newPoint", P2, M.getSpeed(), dist1, time1));
				int dist2 = Ycoord-Y1;
				double time2 = (double)dist2/M.getSpeed();
				M1.add(new map("newPoint", P1, M.getSpeed(), dist2, time2));
			}
		}
		else{
			if(X1 > X2){
				int dist1 = X1 - Xcoord;
				double time1 = (double)dist1/M.getSpeed();
				M1.add(new map("newPoint", P1, M.getSpeed(), dist1, time1));
				int dist2 = Xcoord-X2;
				double time2 = (double)dist2/M.getSpeed();
				M1.add(new map("newPoint", P2, M.getSpeed(), dist2, time2));
			}
			if(X2 > X1){
				int dist1 = X2 - Xcoord;
				double time1 = (double)dist1/M.getSpeed();
				M1.add(new map("newPoint", P2, M.getSpeed(), dist1, time1));
				int dist2 = Xcoord-X1;
				double time2 = (double)dist2/M.getSpeed();
				M1.add(new map("newPoint", P1, M.getSpeed(), dist2, time2));
			}
		}
		return M1;
	}
}
