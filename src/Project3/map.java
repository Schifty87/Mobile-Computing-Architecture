package Project3;

public class map {

	private String A,B;
	private int speed,dist;
	private double time;
	
	
	public map(String A, String B, int speed, int dist, double time){
		this.A = A;
		this.B = B;
		this.speed = speed;
		this.dist = dist;
		this.time= time;
	}


	/**
	 * @return the a
	 */
	public String getA() {
		return A;
	}


	/**
	 * @param a the a to set
	 */
	public void setA(String a) {
		A = a;
	}


	/**
	 * @return the b
	 */
	public String getB() {
		return B;
	}


	/**
	 * @param b the b to set
	 */
	public void setB(String b) {
		B = b;
	}


	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}


	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}


	/**
	 * @return the dist
	 */
	public int getDist() {
		return dist;
	}


	/**
	 * @param dist the dist to set
	 */
	public void setDist(int dist) {
		this.dist = dist;
	}


	/**
	 * @return the time
	 */
	public double getTime() {
		return time;
	}


	/**
	 * @param time the time to set
	 */
	public void setTime(double time) {
		this.time = time;
	}

	public String toString(){
		return this.A + " " + this.B + " " + this.speed + " " + this.dist + " " + this.time;
	}
	
	
	
}
