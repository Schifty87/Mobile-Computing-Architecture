package Project4;

// Evaluation Function f(x) = h(x) + g(x)
public class Evaluation implements Comparable<Evaluation>{
	
	private String node;
	private double heuristicEval;	// Result of evaluation function [f(x) = h(x) + g(x)] from given node
	private double cost;
	
	public Evaluation(String node, double heuristicEval, double cost){
		this.node = node;
		this.heuristicEval = heuristicEval;
		this.setCost(cost);
	}

	public String getNode() {
		return node;
	}


	public void setNode(String node) {
		this.node = node;
	}


	public double getHeuristicEval() {
		return heuristicEval;
	}


	public void setHeuristicEval(double heuristicEval) {
		this.heuristicEval = heuristicEval;
	}
	
	public int compareTo(Evaluation e) {
		if(this.equals(e)){
			return 0;
		}else if(getHeuristicEval() > e.getHeuristicEval()){
			return 1;
	    }else{
	    	return -1;
	    }
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

}
