package Project3;

class point {

	private int X, Y;
	private String Point;
	
	point(String Point, int X, int Y){
		this.X = X;
		this.Y = Y;
		this.Point = Point;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return X;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		X = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return Y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		Y = y;
	}

	/**
	 * @return the point
	 */
	public String getPoint() {
		return Point;
	}

	/**
	 * @param point the point to set
	 */
	public void setPoint(String point) {
		Point = point;
	}
	
	public String toString(){
		return this.Point + " " + this.X + " " + this.Y;
	}

	
	
	
}
