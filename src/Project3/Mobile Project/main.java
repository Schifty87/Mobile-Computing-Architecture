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
		int X = 6;
		int Y = 8;
		
		if(Trout.locate(X, Y, M, P)==null){
			System.out.println("Point not found");
		}
		else{
			/*add new point
			//adding new point method
			****************/
			
			System.out.println(Trout.locate(X, Y, M, P));
			ArrayList<map> M5 = Trout.down(Trout.locate(X, Y, M, P),P,X,Y);
			for(int i=0; i<M5.size(); i++){
				System.out.println(M5.get(i));
			}
		}
		
		
		
		
		
	}
}
