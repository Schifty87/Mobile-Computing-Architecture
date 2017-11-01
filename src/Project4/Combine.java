package Project4;

public class Combine {
	private int X1, X2, Y1, Y2;
	private String A, B;
	private double time;
	private boolean mark;
	
	
	public Combine(String A, String B, double time, int X1, int Y1, int X2, int Y2){
		this.A = A;
		this.B = B;
		this.time = time;
		this.X1 = X1;
		this.Y1 = Y1;
		this.X2 = X2;
		this.Y2 = Y2;		
		this.setMark(false);
	}


	/**
	 * @return the x1
	 */
	public int getX1() {
		return X1;
	}


	/**
	 * @param x1 the x1 to set
	 */
	public void setX1(int x1) {
		X1 = x1;
	}


	/**
	 * @return the x2
	 */
	public int getX2() {
		return X2;
	}


	/**
	 * @param x2 the x2 to set
	 */
	public void setX2(int x2) {
		X2 = x2;
	}


	/**
	 * @return the y1
	 */
	public int getY1() {
		return Y1;
	}


	/**
	 * @param y1 the y1 to set
	 */
	public void setY1(int y1) {
		Y1 = y1;
	}


	/**
	 * @return the y2
	 */
	public int getY2() {
		return Y2;
	}


	/**
	 * @param y2 the y2 to set
	 */
	public void setY2(int y2) {
		Y2 = y2;
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
		return this.A + "\t" + this.B + "\t" + this.time + "\t" + this.X1 + "\t" + this.Y1 + "\t" +  + this.X2 + "\t" + this.Y2;
		
	}


	public boolean getMark() {
		return mark;
	}


	public void setMark(boolean mark) {
		this.mark = mark;
	}
}
