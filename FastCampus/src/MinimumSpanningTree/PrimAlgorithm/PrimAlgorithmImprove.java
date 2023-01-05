package MinimumSpanningTree.PrimAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PrimAlgorithmImprove {
	public ArrayList<Path> improvedPrimFunc(HashMap<String, HashMap<String, Integer>> graph, String startNode){
		
		ArrayList<Path> mst = new ArrayList<Path>(); //�ּҽ���Ʈ��
		PriorityQueue<Edge02> keys = new PriorityQueue<Edge02>(); 
		//���ͽ�Ʈ���� �Ÿ�����迭�� ���Ұ� ���� + �켱����ť���� ���� ������Ʈ���ִ� �޼��尡 ����, but, �켱����ť�� remove(Ư�� ��ü)�� ���� -> �׷� �����Ҷ��� remove(Edge02��ü) �̷��� �������! 
		HashMap<String, Edge02> keysObjects = new HashMap<String, Edge02>(); 
		HashMap<String,String> mstPath = new HashMap<String,String>(); //������ ��尡 ��� ���� ������ �Ǵ��� ������ ��� ����
		Edge02 edgeObject, poppedEdge, linkedEdge; //edgeObject - �켱����ť���� remove()�޼��� ����, remove()�޼����� �Ķ���͸� ��������� ���������. -> �̋� ��������� ���� ��ü�� ������ edgeObject�� ��������
		Integer totalWeight = 0; //����ġ ���� ����ϴ� ����
		HashMap<String, Integer> linkedEdges; //���������� A��� ������, A�� ������ ���������� ������ ����ġ ������ ��� ����
		
		for(String key : graph.keySet()) {
			if(key == startNode) { //���������� ����ġ�� 0����
				edgeObject = new Edge02(key, 0); //A,0
				mstPath.put(key,key); //A,A
			} else { //���������ܿ� ������ ������ ����ġ�� ���Ѵ�� ����
				edgeObject = new Edge02(key, Integer.MAX_VALUE);
				mstPath.put(key,null);
			}
			keys.add(edgeObject); //(A,0), (B, INF) (C,INF)...
			keysObjects.put(key, edgeObject); //[A, (A,0)], [B, (B,INF)], [C, (C,INF)]...
		}
		
		while(keys.size() > 0) {
			//System.out.println(keys);
			poppedEdge = keys.poll(); //(A,0)
			//System.out.println(keys);
			keysObjects.remove(poppedEdge.node); //keysObjects.remove(A)
			
			mst.add(new Path(mstPath.get(poppedEdge.node), poppedEdge.node, poppedEdge.weight)); // A,A,0 - MST
			totalWeight += poppedEdge.weight;
			
			linkedEdges = graph.get(poppedEdge.node); //linkedEdges = ������������, linkedEdges = graph.get(A); // linkedEdges[(B,7),(D,5)]
			for(String adjacent : linkedEdges.keySet()) {
				if(keysObjects.containsKey(adjacent)) { //B, D
					linkedEdge = keysObjects.get(adjacent); //B, INF
					
					if(linkedEdges.get(adjacent) < linkedEdge.weight) { //7 < INF
						linkedEdge.weight = linkedEdges.get(adjacent); //linkedEdge (B, 7)
						mstPath.put(adjacent, poppedEdge.node); //B,A
						//System.out.println(keys);
						keys.remove(linkedEdge); 
						//System.out.println(keys);
						keys.add(linkedEdge); //�켱����ť�� (B,7)�� ���� ������Ʈ��. (D,5)
						//System.out.println(keys);
						//�켱���� ť(�ּ���) ��������, �̹� �� �ִ� �������� �� �����, �ּҰ��� ������ �����͸� ��Ʈ���� �÷������� �籸���ϴ� ����� �ʿ���
						//�켱����ť�� ������ ���� �����ϸ�, ���� ���ϴ´�� ���ĵɰͰ�����, ������ �����ʴ� Ư¡�� ���� -> pqPractice���� Ȯ�ΰ���!
						
					}
				}
			}
		}
		
		System.out.println(totalWeight);
		return mst;
	}
}
