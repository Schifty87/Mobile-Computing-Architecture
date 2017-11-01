package Project4;


public class Map {

	private String initial;	//staring node
	private String neighbor; // starting nodes neighbor
	private int speed;	// speed limit between nodes
	private int distance;	// distance between nodes
	private double time;	// time between nodes
	
	public Map(String initial, String neighbor, int speed, int distance, double time){
		this.initial = initial;
		this.neighbor = neighbor;
		this.speed = speed;
		this.distance = distance;
		this.time = time;
	}

	public String getInitial() {
		return initial;
	}

	public void setInitial(String initial) {
		this.initial = initial;
	}

	public String getNeighbor() {
		return neighbor;
	}

	public void setNeighbor(String neighbor) {
		this.neighbor = neighbor;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}
	
	public String toString(){
		return initial+"->"+neighbor+" | "+speed+"mph"+" | "+distance+" miles"+" | "+time+" hours";
	}
	
}
