import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String [] args){
		Point start = getStart();
		Point goal = getGoal();
		System.out.println("Distance between two points: "+start+" to "+goal);
		System.out.println(getNodeDistance(start,goal));
		
		ArrayList<Data> list = new ArrayList<Data>();
		loadData(list);
		
		for(Data x : list){
			System.out.println(x);
		}
		
	}// main
	
	// Gets starting point from the user
	public static Point getStart(){
		Scanner s = new Scanner(System.in);
		int x = 0;
		int y = 0;
		do{
			System.out.println("Enter starting x coordinate (Start): ");
			x = s.nextInt();
		}while(x>12 || x<0);
		do{
			System.out.println("Enter starting y coordinate (Start): ");
			y = s.nextInt();
		}while(y>16 || y<0);
		
		return new Point(x,y);
	}
	
	// Gets ending point (goal) from the user
	public static Point getGoal(){
		Scanner s = new Scanner(System.in);
		int x = 0;
		int y = 0;
		do{
			System.out.println("Enter ending x coordinate (Goal): ");
			x = s.nextInt();
		}while(x>12 || x<0);
		do{
			System.out.println("Enter ending y coordinate (Goal): ");
			y = s.nextInt();
		}while(y>16 || y<0);
		
		return new Point(x,y);
	}
	
	// Distance between two points
	public static double getNodeDistance(Point p1, Point p2){
		//Distance formula ===> sqrt[(x2-x1)^2 + (y2-y1)^2]
		return Math.sqrt((Math.pow(p2.getX() - p1.getX(), 2)) + (Math.pow(p2.getY() - p1.getY(), 2)));
	}
	
	// Load heuristic data into list of respective objects
	// 		Heuristic(String,String,int,int,double)
	public static void loadData(ArrayList<Data> data){
		try{
			Scanner s = new Scanner(new File("data.csv"));
			while(s.hasNext()){
				String tempHeuristic [] = s.nextLine().split(",");
				data.add(new Data(tempHeuristic[0],tempHeuristic[1],Integer.parseInt(tempHeuristic[2]),Integer.parseInt(tempHeuristic[3]),Double.parseDouble(tempHeuristic[4])));
			}
		}catch(Exception e){
			System.out.println("Error "+e);
		}
	}
	
}//Main
