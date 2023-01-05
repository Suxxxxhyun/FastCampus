package MinimumSpanningTree.KruskalAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class KruskalAlgorithmFinal {

	public HashMap<String, String> parent = new HashMap<String,String>(); //<Ư�� ���, �� Ư�� ����� �θ��� �� ��Ʈ���>
	public HashMap<String, Integer> rank = new HashMap<String,Integer>(); //<Ư�� ���, �� Ư�� ����� rank����>
	
	//�ĸ����ͷ� ���� ����� ��Ʈ��带 ��ȯ���ִ� �޼���
	public String find(String node) {
		//path compression��� -> �� �θ��尡 ��Ʈ��尡 �ƴ϶��, ��Ʈ��带 �ϴ� ã��, ���İ� ������ �ڽĳ��� ���� -> rank�� �����ִ� ����
		if(this.parent.get(node) != node) { //��Ʈ������� �ƴ��� üũ�ϴ� ���, �Ķ���ͷ� ���� node�� �θ�, �ᱹ �ڱ��ڽ�(�Ķ���ͷ� ���� node)���, �̰� �ᱹ ��Ʈ�����
			this.parent.put(node, find(this.parent.get(node)));
		}
		return this.parent.get(node);
		
		//path compression����� ������� �ʰ�, �Ķ���ͷ� ���� ����� ��Ʈ��带 ��ȯ���ִ� �̰͸� �����Ѵٸ�,
		//if(parent.get(node) != node)
		// return find(parent.get(node));
	}
	
	//nodeV�� nodeU�� ���Ķ� ��� �޼��� = UNION
	//union�޼��带 ȣ���ϱ� ����, nodeV�� nodeU�� �����Ұ�� + ����Ŭ�� �Ȼ��涧��, union�޼��带 ȣ���ϰԵȴٰ� ������ �ϰ���!
	public void Union(String nodeV, String nodeU) {
		String root1 = this.find(nodeV);
		String root2 = this.find(nodeU);
		
		//union-by-rank��� 
		if(this.rank.get(root1) > this.rank.get(root2)) {
			this.parent.put(root2, root1);
		} else { //root1�� ��ũ < root2�� ��ũ + root1�� ��ũ == root2�� ��ũ
			this.parent.put(root1, root2);
			if(this.rank.get(root1) == this.rank.get(root2)) { //��ũ�� ���� ������ Ȯ��
				this.rank.put(root2, this.rank.get(root2) + 1);
			}
		}
		
	}
	
	//�ʱ�ȭ, union-find�޼��带 ����ϱ� ����, �� ó������ n���� ���Ҹ� �������� �κ��������� ��������. ���� rank�� ��� 0!
	public void makeSet(String node) {
		this.parent.put(node, node); //�������� �κ������̶��, �� ����� ��Ʈ���� �� �ڱ��ڽ��̰���!
		this.rank.put(node, 0);
	}
	
	//������ ����Ʈ�� vertices�� �׷��� ������ edges�� �Ķ���ͷ� ����.
	public ArrayList<Edge> kruskalFunc(ArrayList<String> vertices, ArrayList<Edge> edges){
		ArrayList<Edge> mst = new ArrayList<Edge>();
		
		Edge currentEdge;
		
		//1. �ʱ�ȭ
		for(int i=0; i<vertices.size(); i++) {
			makeSet(vertices.get(i));
		}
		
		//2. ������ ����ġ ������� ����
		Collections.sort(edges);
		
		for(int i=0; i<edges.size(); i++) {
			currentEdge = edges.get(i); //������ ���� �����ͺ��� currentEdge�� ���� ��.
			if(this.find(currentEdge.nodeV) != find(currentEdge.nodeU)) { //�� Ư������� ��Ʈ��尡 ���� �ٸ��� = ����Ŭ�� ������ �ʴ´ٸ� -> �̶� ���Ķ�!
				this.Union(currentEdge.nodeV, currentEdge.nodeU);
				mst.add(currentEdge);
			}
		}
		
		return mst;
	}

}
