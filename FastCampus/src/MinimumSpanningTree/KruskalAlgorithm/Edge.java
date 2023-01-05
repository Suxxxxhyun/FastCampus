package MinimumSpanningTree.KruskalAlgorithm;

public class Edge implements Comparable<Edge>{
	
	public int weight;
	public String nodeV; //Ư�� ���
	public String nodeU; //�� �ٸ� Ư�� ���
	
	public Edge(int weight, String nodeV, String nodeU) {
		this.weight = weight;
		this.nodeV = nodeV;
		this.nodeU = nodeU;
	}
	
	public String toString() {
		return "(" + this.weight + "," + this.nodeV + "," + this.nodeU + ")";
	}
	
	//�޼��� �������̵� -> �θ𿡰� ���� �޼����� compareTo()�� �ڽ��� �ٽ� �������ϴ°�, ��ġ ������ ����� ������!
	public int compareTo(Edge edge) {
		return this.weight - edge.weight;
	}
}
