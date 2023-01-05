package GreedyAlgorithm;

public class Edge implements Comparable<Edge>{
	public Integer distance;
	public String vertex;
	
	public Edge(int distance, String vertex) {
		this.distance = distance;
		this.vertex = vertex;
	}

	@Override
	public int compareTo(Edge o) {
		//return this.distance - o.distance; //오름차순
		return o.distance - this.distance; //내림차순
	}
	//빼는 순서에 따라 오름차순, 내림차순 결정할 수 있다.
}
