package MinimumSpanningTree.KruskalAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

//union-find�� �ʿ��� ����
//1. ��� �κ����տ� ����ִ� ���� �� ����� �θ��带 �� �� �־����.
//2. ������ ��尡 ���̰� �������(rank�� ������)
//3. �ڽ��� ��Ʈ�����, �ڽ��� �θ� �ڽ��� ����Ű�� ��
//4. 3�������� �´ٸ� ��Ʈ���, �ƴ϶�� �ڽĳ��

public class KruskalAlgorithm {

	public static HashMap<String, String> parent = new HashMap<String,String>(); //<Ư�� ���, �� Ư�� ����� �θ��� �� ��Ʈ���>
	public static HashMap<String, Integer> rank = new HashMap<String,Integer>(); //<Ư�� ���, �� Ư�� ����� rank����>

	public static void main(String[] args) {
		
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
			if(find(currentEdge.nodeV) != find(currentEdge.nodeU)) { //�� Ư������� ��Ʈ��尡 ���� �ٸ��� = ����Ŭ�� ������ �ʴ´ٸ� -> �̶� ���Ķ�!
				Union(currentEdge.nodeV, currentEdge.nodeU);
				mst.add(currentEdge);
			}
		}
		
		return mst;
	}
	
	//�ʱ�ȭ, union-find�޼��带 ����ϱ� ����, �� ó������ n���� ���Ҹ� �������� �κ��������� ��������. ���� rank�� ��� 0!
	public static void makeSet(String node) {
		parent.put(node, node); //�������� �κ������̶��, �� ����� ��Ʈ���� �� �ڱ��ڽ��̰���!
		rank.put(node, 0);
	}
	
	//�ĸ����ͷ� ���� ����� ��Ʈ��带 ��ȯ���ִ� �޼���
	public static String find(String node) {
		//path compression��� -> �� �θ��尡 ��Ʈ��尡 �ƴ϶��, ��Ʈ��带 �ϴ� ã��, ���İ� ������ �ڽĳ��� ���� -> rank�� �����ִ� ����
		if(parent.get(node) != node) {
			parent.put(node, find(parent.get(node)));
		} 
		return parent.get(node);
		
		//path compression����� ������� �ʰ�, �Ķ���ͷ� ���� ����� ��Ʈ��带 ��ȯ���ִ� �̰͸� �����Ѵٸ�,
		//if(parent.get(node) != node)
		// return find(parent.get(node));
	}
	
	//nodeV�� nodeU�� ���Ķ� ��� �޼��� = UNION
	//union�޼��带 ȣ���ϱ� ����, nodeV�� nodeU�� �����Ұ�� + ����Ŭ�� �Ȼ��涧��, union�޼��带 ȣ���ϰԵȴٰ� ������ �ϰ���!
	public static void Union(String nodeV, String nodeU) {
		String root1 = find(nodeV);
		String root2 = find(nodeU);
		
		//union-by-rank��� 
		if(rank.get(root1) > rank.get(root2)) {
			parent.put(root2, root1);
		} else { //root1�� ��ũ < root2�� ��ũ + root1�� ��ũ == root2�� ��ũ
			parent.put(root1, root2);
			if(rank.get(root1) == rank.get(root2)) { //��ũ�� ���� ������ Ȯ��
				rank.put(root2, rank.get(root2) + 1);
			}
		}
		
	}

}
