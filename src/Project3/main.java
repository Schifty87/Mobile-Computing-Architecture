package Project3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class main {

	public static void main(String[] args) throws FileNotFoundException{
		// TODO Auto-generated method stub
		
		ArrayList<point> P = new ArrayList<point>();
		ArrayList<map> M = new ArrayList<map>();
		
		File file = new File("Coordinates.csv");
		Scanner s = new Scanner(file);
		while(s.hasNext()){ //while there is something populating the next line
			String line = s.nextLine();
			String[] array = line.split(",");
			int X = Integer.parseInt(array[1]);
			int Y = Integer.parseInt(array[2]);
			P.add(new point(array[0],X,Y));
		}
		
		
		
		File file1 = new File("data.csv");
		Scanner s1 = new Scanner(file1);
		while(s1.hasNext()){ //while there is something populating the next line
			String line = s1.nextLine();
			String[] array = line.split(",");
			int X = Integer.parseInt(array[2]);
			int Y = Integer.parseInt(array[3]);
			double T = Double.parseDouble(array[4]);
			M.add(new map(array[0],array[1],X,Y,T));
		}
		
		Trout Trout = new Trout();
		
		/*Add your points!!
		 *****************
		 ********************/
		int X = 0;
		int Y = 0;
		
		if(Trout.locate(X, Y, M, P)==null && Trout.alreadyMade(X, Y, P)==null){
			System.out.println("Point does not exist on a road");
		}
		
		
		//determine if the point already exists
		if(Trout.alreadyMade(X, Y, P)!=null){
			System.out.println("Point already exists");
			//Print out the point that already exists
			System.out.println(Trout.alreadyMade(X,Y,P));
			String SS = Trout.alreadyMade(X,Y,P);
			
			
			//change name of point in P array
			for(int i=0; i<P.size(); i++){
				if(P.get(i).getPoint().equals(SS)){
					P.get(i).setPoint("SS");
				}
			}
			
			//change the name of points in map array
			for(int i=0; i<M.size(); i++){
				if(M.get(i).getA().equals(SS)){
					M.get(i).setA("SS");
				}
				if(M.get(i).getB().equals(SS)){
					M.get(i).setB("SS");
				}
			}
			
		}
		
		//the point does not exist
		else{
			/*add new point
			//adding new point method
			****************/
			P.add(new point("SS", X, Y));
			
			
			System.out.println(Trout.locate(X, Y, M, P));
			ArrayList<map> M5 = Trout.down(Trout.locate(X, Y, M, P),P,X,Y, "SS");
			for(int i=0; i<M5.size(); i++){
				//System.out.println(M5.get(i));
				M.add(M5.get(i));
			}
		}
		
		
		/***********************
		 * find end location****
		 ***********************/
		
		X = 0;
		Y = 8;
		
		//determine if the point already exists
		if(Trout.alreadyMade(X, Y, P)!=null){
			System.out.println("Point already exists");
			//Print out the point that already exists
			System.out.println(Trout.alreadyMade(X,Y,P));
			String EE = Trout.alreadyMade(X,Y,P);
			
			//change name of point in P array
			for(int i=0; i<P.size(); i++){
				if(P.get(i).getPoint().equals(EE)){
					P.get(i).setPoint("EE");
				}
			}
			
			//change the name of points in map array
			for(int i=0; i<M.size(); i++){
				if(M.get(i).getA().equals(EE)){
					M.get(i).setA("EE");
				}
				if(M.get(i).getB().equals(EE)){
					M.get(i).setB("EE");
				}
			}
			
		}
		
		//point does not exist
		else{
			/*add new point
			//adding new point method
			****************/
			P.add(new point("EE", X, Y));
			
			System.out.println(Trout.locate(X, Y, M, P));
			ArrayList<map> M5 = Trout.down(Trout.locate(X, Y, M, P),P,X,Y, "EE");
			for(int i=0; i<M5.size(); i++){
				//System.out.println(M5.get(i));
				M.add(M5.get(i));
			}
		}
		
		for(int i=0; i<M.size(); i++){
			System.out.println(M.get(i));
		}
		for(int i=0; i<P.size(); i++){
			System.out.println(P.get(i));
		}
		
		
		ArrayList <Combine> C = new ArrayList <Combine>();
		
		for(int i=0; i<M.size(); i++){
			for(int j=0; j<P.size(); j++){
				if(M.get(i).getA().equals(P.get(j).getPoint())){
					for(int k=0; k<P.size(); k++){
						if(M.get(i).getB().equals(P.get(k).getPoint())){
							C.add(new Combine(P.get(j).getPoint(), P.get(k).getPoint(), M.get(i).getTime(), P.get(j).getX(), P.get(j).getY(), P.get(k).getX(), P.get(k).getY()));
						}
					}
				}
			}
		}
		
		for(int i=0; i<C.size(); i++){
			System.out.println(C.get(i));
		}
		
		
	}
}
