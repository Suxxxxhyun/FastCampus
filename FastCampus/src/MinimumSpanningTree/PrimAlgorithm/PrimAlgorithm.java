package MinimumSpanningTree.PrimAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PrimAlgorithm {
	
	public ArrayList<Edge> primFunc(String startNode, ArrayList<Edge> edges){
		
		ArrayList<String> connectedNodes = new ArrayList<String>(); //connectedNodes - 연결된 노드집합
		ArrayList<Edge> mst = new ArrayList<Edge>(); //mst - 최종 최소신장트리
		HashMap<String, ArrayList<Edge>> adjacentEdges = new HashMap<String, ArrayList<Edge>>();
		//해당 정점(노드 = String)의 간선들(ArrayList<Edge>)을 value에 넣음
		
		Edge currentEdge,poppedEdge,adjacentEdgeNode;
		ArrayList<Edge> currentEdgeList,candidateEdgeList, adjacentEdgeNodes;
		PriorityQueue<Edge> priorityQueue;
		
		//edges에서 노드들의 정보를 하나씩 받아서 adjacentEdges의 키로 넣기위한 과정
		for(int i=0; i<edges.size(); i++) {
			currentEdge = edges.get(i);
			if(!adjacentEdges.containsKey(currentEdge.node1)) {
				adjacentEdges.put(currentEdge.node1, new ArrayList<Edge>());
			}
			if(!adjacentEdges.containsKey(currentEdge.node2)) {
				adjacentEdges.put(currentEdge.node2, new ArrayList<Edge>());
			}
		} //adjacentEdges의 키 - A,B,D,C,E,F,G
		//adjacentEdges의 value - 모두 배열이 초기화 된 상태로 있음
		
		for(int i=0; i<edges.size(); i++) {
			currentEdge = edges.get(i);
			currentEdgeList = adjacentEdges.get(currentEdge.node1); //빈 ArrayList가 currentEdgeList에 들어감
			currentEdgeList.add(new Edge(currentEdge.weight, currentEdge.node1, currentEdge.node2)); //currentEdgeList -  node1에 연결된 node2, 그리고 가중치
			currentEdgeList = adjacentEdges.get(currentEdge.node2);
			currentEdgeList.add(new Edge(currentEdge.weight, currentEdge.node2, currentEdge.node1)); //currentEdgeList -  node2에 연결된 node1, 그리고 가중치
		}
		//currentEdgeList - A입장에서 연결된 간선의 가중치와 노드, B입장에서 연결된 간선의 가중치와 노드, ... F입장에서 연결된 간선의 가중치와 노드
		//adjacentEdges.get("A")의 value - (7,A,B)/(5,A,D)
		
		connectedNodes.add(startNode);
		//getOrDefault() - 키에 대한 값이 없으면, 디폴트 값으로 value업데이트
		candidateEdgeList = adjacentEdges.getOrDefault(startNode, new ArrayList<Edge>()); //candidateEdgeList - (7,A,B)/(5,A,D)
		priorityQueue = new PriorityQueue<Edge>();
		for(int i=0; i<candidateEdgeList.size(); i++) {
			priorityQueue.add(candidateEdgeList.get(i));
		}
		//위의 for문까지 초기화과정임.
		
		while(priorityQueue.size() > 0) {
			poppedEdge = priorityQueue.poll();
			if(!connectedNodes.contains(poppedEdge.node2)) {
				//해당 edge를 mst에 추가
				connectedNodes.add(poppedEdge.node2);
				mst.add(new Edge(poppedEdge.weight, poppedEdge.node1, poppedEdge.node2));
				
				adjacentEdgeNodes = adjacentEdges.getOrDefault(poppedEdge.node2, new ArrayList<Edge>());
				for(int i=0; i<adjacentEdgeNodes.size(); i++) {
					adjacentEdgeNode = adjacentEdgeNodes.get(i);
					//우선순위큐에 adjacentEdgeNode를 모두 넣을 수 있겠지만, 우선순위큐에 데이터가 들어가는 과정이 트리 구조로 자리를 찾아가는 과정이라, 시간복잡도가 걸려서
					//우선순위큐에 넣는 정보는 사이클이 생기지 않는 놈들만 넣자
					if(!connectedNodes.contains(adjacentEdgeNode.node2)) {
						priorityQueue.add(adjacentEdgeNode);
					}
				}
			}
		}
		
		return mst;
	}
}
