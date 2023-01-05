package MinimumSpanningTree.KruskalAlgorithm;

public class Edge implements Comparable<Edge>{
	
	public int weight;
	public String nodeV; //특정 노드
	public String nodeU; //또 다른 특정 노드
	
	public Edge(int weight, String nodeV, String nodeU) {
		this.weight = weight;
		this.nodeV = nodeV;
		this.nodeU = nodeU;
	}
	
	public String toString() {
		return "(" + this.weight + "," + this.nodeV + "," + this.nodeU + ")";
	}
	
	//메서드 오버라이딩 -> 부모에게 받은 메서드인 compareTo()를 자식이 다시 재정의하는것, 마치 파일의 덮어쓰기 개념임!
	public int compareTo(Edge edge) {
		return this.weight - edge.weight;
	}
}
