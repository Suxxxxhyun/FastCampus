package MinimumSpanningTree.PrimAlgorithm;

public class Edge02 implements Comparable<Edge02>{
	public String node;
	public int weight;
	
	public Edge02(String node, int weight) {
		this.weight = weight;
		this.node = node;
	}
	
	public String toString() {
		return "(" + this.weight + "," + this.node + ")";
	}
	
	public int compareTo(Edge02 edge) {
		return this.weight - edge.weight;
	}
}

//path클래스를 통해 node1에서 node2로 가중치가 있다.
class Path{
	public String node1;
	public String node2;
	public int weight;
	
	public Path(String node1, String node2, int weight) {
		this.node1 = node1;
		this.node2 = node2;
		this.weight = weight;
	}
	
	public String toString() {
		return "(" + this.node1 + "," + this.node2 + "," + this.weight + ")";
	}
}
