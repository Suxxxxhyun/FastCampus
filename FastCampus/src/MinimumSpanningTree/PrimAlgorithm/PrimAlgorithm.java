package MinimumSpanningTree.PrimAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PrimAlgorithm {
	
	public ArrayList<Edge> primFunc(String startNode, ArrayList<Edge> edges){
		
		ArrayList<String> connectedNodes = new ArrayList<String>(); //connectedNodes - ����� �������
		ArrayList<Edge> mst = new ArrayList<Edge>(); //mst - ���� �ּҽ���Ʈ��
		HashMap<String, ArrayList<Edge>> adjacentEdges = new HashMap<String, ArrayList<Edge>>();
		//�ش� ����(��� = String)�� ������(ArrayList<Edge>)�� value�� ����
		
		Edge currentEdge,poppedEdge,adjacentEdgeNode;
		ArrayList<Edge> currentEdgeList,candidateEdgeList, adjacentEdgeNodes;
		PriorityQueue<Edge> priorityQueue;
		
		//edges���� ������ ������ �ϳ��� �޾Ƽ� adjacentEdges�� Ű�� �ֱ����� ����
		for(int i=0; i<edges.size(); i++) {
			currentEdge = edges.get(i);
			if(!adjacentEdges.containsKey(currentEdge.node1)) {
				adjacentEdges.put(currentEdge.node1, new ArrayList<Edge>());
			}
			if(!adjacentEdges.containsKey(currentEdge.node2)) {
				adjacentEdges.put(currentEdge.node2, new ArrayList<Edge>());
			}
		} //adjacentEdges�� Ű - A,B,D,C,E,F,G
		//adjacentEdges�� value - ��� �迭�� �ʱ�ȭ �� ���·� ����
		
		for(int i=0; i<edges.size(); i++) {
			currentEdge = edges.get(i);
			currentEdgeList = adjacentEdges.get(currentEdge.node1); //�� ArrayList�� currentEdgeList�� ��
			currentEdgeList.add(new Edge(currentEdge.weight, currentEdge.node1, currentEdge.node2)); //currentEdgeList -  node1�� ����� node2, �׸��� ����ġ
			currentEdgeList = adjacentEdges.get(currentEdge.node2);
			currentEdgeList.add(new Edge(currentEdge.weight, currentEdge.node2, currentEdge.node1)); //currentEdgeList -  node2�� ����� node1, �׸��� ����ġ
		}
		//currentEdgeList - A���忡�� ����� ������ ����ġ�� ���, B���忡�� ����� ������ ����ġ�� ���, ... F���忡�� ����� ������ ����ġ�� ���
		//adjacentEdges.get("A")�� value - (7,A,B)/(5,A,D)
		
		connectedNodes.add(startNode);
		//getOrDefault() - Ű�� ���� ���� ������, ����Ʈ ������ value������Ʈ
		candidateEdgeList = adjacentEdges.getOrDefault(startNode, new ArrayList<Edge>()); //candidateEdgeList - (7,A,B)/(5,A,D)
		priorityQueue = new PriorityQueue<Edge>();
		for(int i=0; i<candidateEdgeList.size(); i++) {
			priorityQueue.add(candidateEdgeList.get(i));
		}
		//���� for������ �ʱ�ȭ������.
		
		while(priorityQueue.size() > 0) {
			poppedEdge = priorityQueue.poll();
			if(!connectedNodes.contains(poppedEdge.node2)) {
				//�ش� edge�� mst�� �߰�
				connectedNodes.add(poppedEdge.node2);
				mst.add(new Edge(poppedEdge.weight, poppedEdge.node1, poppedEdge.node2));
				
				adjacentEdgeNodes = adjacentEdges.getOrDefault(poppedEdge.node2, new ArrayList<Edge>());
				for(int i=0; i<adjacentEdgeNodes.size(); i++) {
					adjacentEdgeNode = adjacentEdgeNodes.get(i);
					//�켱����ť�� adjacentEdgeNode�� ��� ���� �� �ְ�����, �켱����ť�� �����Ͱ� ���� ������ Ʈ�� ������ �ڸ��� ã�ư��� �����̶�, �ð����⵵�� �ɷ���
					//�켱����ť�� �ִ� ������ ����Ŭ�� ������ �ʴ� ��鸸 ����
					if(!connectedNodes.contains(adjacentEdgeNode.node2)) {
						priorityQueue.add(adjacentEdgeNode);
					}
				}
			}
		}
		
		return mst;
	}
}
