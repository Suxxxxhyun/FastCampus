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
		//return this.distance - o.distance; //��������
		return o.distance - this.distance; //��������
	}
	//���� ������ ���� ��������, �������� ������ �� �ִ�.
}
