package GreedyAlgorithm;

public class Edge02 implements Comparable<Edge02>{
	public Integer distance;
	public String vertex;
	
	public Edge02(Integer distance, String vertex) {
		this.distance = distance;
		this.vertex = vertex;
	}

	@Override
	public int compareTo(Edge02 o) {
		return this.distance - o.distance; //오름차순
	}
	
	
}
