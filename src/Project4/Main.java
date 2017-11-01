package Project4;

import java.io.File; 
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static Point start; // Start point (x,y)
	static Point goal; // Goal point (x,y)
	
	static Coordinate SS;
	static Coordinate EE;
	
	public static void main(String [] args){

		//initialize two arrays to be created from CSV files
 		ArrayList<Map> map = new ArrayList<Map>();
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
		
		
		//load coordinates and map
		loadMap(map);
		loadCoordinate(coordinates);
		
		/*bring in Trout class holds methods to:
		 * 1) determine if user-entered points are nodes
		 * 2) determine distance/time from point to nodes
		 * 3) determine if point exists on a road*/
		Trout Trout = new Trout();
		Boolean B;
		
		//ask for valid coordinates
		do{
			
			B = true;
			getInput();// Get start and goal points from user
			if(Trout.alreadyMade(start.getX(), start.getY(), coordinates)==null && Trout.locate(start.getX(), start.getY(), map, coordinates) == null){
				System.out.println("Starting point does not exist");
				B = false;
			}
			if(Trout.alreadyMade(goal.getX(), goal.getY(), coordinates)==null && Trout.locate(goal.getX(), goal.getY(), map, coordinates) == null){
				System.out.println("Ending point does not exist");
				B = false;
			}		
		}while(B != true);
					
		int X = start.getX();
		int Y = start.getY();
		
		
		/*following if/else statement will be repeated twice
		 * one for start and another for end*/
		
		//determine if the point already exists
		if(Trout.alreadyMade(X, Y, coordinates)!=null){
			//locate the ID of the point
			String SS = Trout.alreadyMade(X,Y,coordinates);
			
			
			//change ID of the point in the coordinates array
			for(int i=0; i<coordinates.size(); i++){
				if(coordinates.get(i).getNode().equals(SS)){
					coordinates.get(i).setNode("START");
				}
			}
			
			//change the name of points in map array
			for(int i=0; i<map.size(); i++){
				if(map.get(i).getInitial().equals(SS)){
					map.get(i).setInitial("START");
				}
				if(map.get(i).getNeighbor().equals(SS)){
					map.get(i).setNeighbor("START");
				}
			}		
		}
		
		//the point does not exist
		else{
			//create new coordinate object
			SS = new Coordinate("START",X,Y);
			//add coordinate object to coordinate array
			coordinates.add(SS);
			
			ArrayList<Map> M5 = Trout.down(Trout.locate(X, Y, map, coordinates),coordinates,X,Y, "START");
			for(int i=0; i<M5.size(); i++){
				map.add(M5.get(i));
			}
		}

		/** Find goal location **/
		X = goal.getX(); // goal input
		Y = goal.getY(); // goal input
		
	
		if(Trout.alreadyMade(X, Y, coordinates)!=null){
			String EE = Trout.alreadyMade(X,Y,coordinates);

			for(int i=0; i<coordinates.size(); i++){
				if(coordinates.get(i).getNode().equals(EE)){
					coordinates.get(i).setNode("END");
				}
			}
			for(int i=0; i<map.size(); i++){
				if(map.get(i).getInitial().equals(EE)){
					map.get(i).setInitial("END");
				}
				if(map.get(i).getNeighbor().equals(EE)){
					map.get(i).setNeighbor("END");
				}
			}			
		}	
		else{
			EE = new Coordinate("END",X,Y);
			coordinates.add(EE);
			
			//System.out.println(Trout.locate(X, Y, map, coordinates));
			ArrayList<Map> M5 = Trout.down(Trout.locate(X, Y, map, coordinates),coordinates,X,Y, "END");
			for(int i=0; i<M5.size(); i++){
				map.add(M5.get(i));
			}
		}
		
		/*Combine map and coordinate arrays 
		 * with updated data based on start 
		 * and goal coordinates*/
		ArrayList <Combine> C = new ArrayList <Combine>();	
		for(int i=0; i<map.size(); i++){
			for(int j=0; j<coordinates.size(); j++){
				if(map.get(i).getInitial().equals(coordinates.get(j).getNode())){
					for(int k=0; k<coordinates.size(); k++){
						if(map.get(i).getNeighbor().equals(coordinates.get(k).getNode())){
							C.add(new Combine(coordinates.get(j).getNode(), coordinates.get(k).getNode(), map.get(i).getTime(), coordinates.get(j).getX(), coordinates.get(j).getY(), coordinates.get(k).getX(), coordinates.get(k).getY()));
						}
					}
				}
			}
		}
		
		/*print out all connections*/
		for(int i=0; i<C.size(); i++){
			System.out.println(C.get(i));
		}
		
		/*print out all nodes and coordinates*/
		for(int i=0; i<coordinates.size(); i++){
			System.out.println(coordinates.get(i));
		}
		
			
		Coordinate START = new Coordinate("START", start.getX(), start.getY());
		Coordinate END = new Coordinate("END", goal.getX(), goal.getY());
		
		//run the A* Search
		search(C,START,END);		
	}// main
	
	// Gets starting point from the user
	public static void getInput(){
		Scanner s = new Scanner(System.in);
		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 0;
		do{
			System.out.println("Enter starting x coordinate [0-12] (Start): ");
			x1 = s.nextInt();
		}while(x1>12 || x1<0);
		do{
			System.out.println("Enter starting y coordinate [0-16] (Start): ");
			y1 = s.nextInt();
		}while(y1>16 || y1<0);
		do{
			System.out.println("Enter starting x coordinate [0-12] (Goal): ");
			x2 = s.nextInt();
		}while(x2>12 || x2<0);
		do{
			System.out.println("Enter starting y coordinate [0-16] (Goal): ");
			y2 = s.nextInt();
		}while(y2>16 || y2<0);
		
		start = new Point(x1,y1);
		goal = new Point(x2,y2);
		
	}
	

	// Distance between two points
	public static double getDistance(Combine p1, Coordinate p2){
		//Distance formula ===> sqrt[(x2-x1)^2 + (y2-y1)^2]
		return (Math.sqrt((Math.pow(p2.getX() - p1.getX2(), 2)) + (Math.pow(p2.getY() - p1.getY2(), 2))));
	}

	// Load map into list of respective objects
	// 		Map(String,String,int,int,double)
	public static void loadMap(ArrayList<Map> map){
		try{
			Scanner s = new Scanner(new File("data.csv"));
			while(s.hasNext()){
				String temp [] = s.nextLine().split(",");
				map.add(new Map(temp[0],temp[1],Integer.parseInt(temp[2]),Integer.parseInt(temp[3]),Double.parseDouble(temp[4])));
			}
		}catch(Exception e){
			System.out.println("Error "+e);
		}
	}
	
	// Load coordinates into array list
	//		Coordinate(String,int,int)
	public static void loadCoordinate(ArrayList<Coordinate> coordinates){
		try{
			Scanner s = new Scanner(new File("CoordinatesV2.csv"));
			while(s.hasNext()){
				String temp [] = s.nextLine().split(",");
				coordinates.add(new Coordinate(temp[0],Integer.parseInt(temp[1]),Integer.parseInt(temp[2])));
			}
		}catch(Exception e){
			System.out.println("Error "+e);
		}
	}
	
	// Print coordinates for each node
	public static void printCoordinates(ArrayList<Coordinate> coordinates){
		System.out.println("Node Coordinates: ");
		for(Coordinate x : coordinates){
			System.out.println(x);
		}
	}
	
	// Print data from file
	public static void printMap(ArrayList<Map> map){
		System.out.println("Map: ");
		System.out.println("Node - Neighbor - Speed Limit - Distance (between nodes) - Time (between nodes)");
		for(Map x : map){
			System.out.println(x);
		}
	}
	
	/** A* Search Method **/
	//TODO
	public static void search(ArrayList<Combine> map, Coordinate SS, Coordinate EE){
		double timeCost = 0;
		PriorityQueue<Evaluation> queue = new PriorityQueue<Evaluation>();
		String path = SS.getNode();
		String t = "";
		for(int i = 0; i<map.size(); i++){
			if(map.get(i).getA().equals(SS.getNode())){
				queue.add(new Evaluation(map.get(i).getB(),evaluationFunction(map.get(i).getTime(),getDistance(map.get(i),EE)),map.get(i).getTime()));//TODO Problem with heuristic function

			}
		}
		//System.out.println(queue.remove().getNode());
		//System.out.println(queue.remove().getNode());

		///*
		while(queue.isEmpty() == false){
			timeCost += queue.peek().getCost();
			t = queue.remove().getNode();
			System.out.println(t);
			path += "---> "+t;
			if(t.equals(EE.getNode())){
				break;
			}else{
				for(int i = 0; i<map.size(); i++){
					if(map.get(i).getA().equals(t)){
						queue.add(new Evaluation(map.get(i).getB(),evaluationFunction(map.get(i).getTime(),getDistance(map.get(i),EE)),map.get(i).getTime()));
					}
				}
			}
		}//*/
		// Print statements. Initiated after search breaks.
		System.out.println("==================");
		System.out.println("A* Search Path: ");
		System.out.println("==================");
		System.out.println(path); 
		System.out.println("******************");
		System.out.println("Total Time to Destination: ");
		System.out.println(timeCost+" hours");
		System.out.println("==================");
	}
	
	// Evaluation function with adjusted weights for accuracy
	public static double evaluationFunction(double a, double b){
		return a+(b/10);
	}
	
}//Main













