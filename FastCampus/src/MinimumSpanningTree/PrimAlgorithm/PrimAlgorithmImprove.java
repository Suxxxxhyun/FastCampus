package MinimumSpanningTree.PrimAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PrimAlgorithmImprove {
	public ArrayList<Path> improvedPrimFunc(HashMap<String, HashMap<String, Integer>> graph, String startNode){
		
		ArrayList<Path> mst = new ArrayList<Path>(); //최소신장트리
		PriorityQueue<Edge02> keys = new PriorityQueue<Edge02>(); 
		//다익스트라의 거리저장배열의 역할과 동일 + 우선순위큐에는 값을 업데이트해주는 메서드가 없음, but, 우선순위큐에 remove(특정 객체)는 가능 -> 그럼 삭제할때는 remove(Edge02객체) 이렇게 해줘야함! 
		HashMap<String, Edge02> keysObjects = new HashMap<String, Edge02>(); 
		HashMap<String,String> mstPath = new HashMap<String,String>(); //각각의 노드가 어느 노드로 연결이 되는지 정보를 담는 변수
		Edge02 edgeObject, poppedEdge, linkedEdge; //edgeObject - 우선순위큐에서 remove()메서드 사용시, remove()메서드의 파라미터를 명시적으로 적어줘야함. -> 이떄 명시적으로 적는 객체의 정보를 edgeObject에 넣을것임
		Integer totalWeight = 0; //가중치 합을 출력하는 변수
		HashMap<String, Integer> linkedEdges; //시작정점을 A라고 했을때, A의 인접한 인접정점과 간선의 가중치 정보를 담는 변수
		
		for(String key : graph.keySet()) {
			if(key == startNode) { //시작정점의 가중치를 0으로
				edgeObject = new Edge02(key, 0); //A,0
				mstPath.put(key,key); //A,A
			} else { //시작정점외에 나머지 정점의 가중치를 무한대로 설정
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
			
			linkedEdges = graph.get(poppedEdge.node); //linkedEdges = 인접간선정보, linkedEdges = graph.get(A); // linkedEdges[(B,7),(D,5)]
			for(String adjacent : linkedEdges.keySet()) {
				if(keysObjects.containsKey(adjacent)) { //B, D
					linkedEdge = keysObjects.get(adjacent); //B, INF
					
					if(linkedEdges.get(adjacent) < linkedEdge.weight) { //7 < INF
						linkedEdge.weight = linkedEdges.get(adjacent); //linkedEdge (B, 7)
						mstPath.put(adjacent, poppedEdge.node); //B,A
						//System.out.println(keys);
						keys.remove(linkedEdge); 
						//System.out.println(keys);
						keys.add(linkedEdge); //우선순위큐에 (B,7)로 값이 업데이트됨. (D,5)
						//System.out.println(keys);
						//우선순위 큐(최소힙) 구조에서, 이미 들어가 있는 데이터의 값 변경시, 최소값을 가지는 데이터를 루트노드로 올려놓도록 재구성하는 기능이 필요함
						//우선순위큐는 데이터 값을 변경하면, 내가 원하는대로 정렬될것같지만, 정렬이 되지않는 특징이 있음 -> pqPractice에서 확인가능!
						
					}
				}
			}
		}
		
		System.out.println(totalWeight);
		return mst;
	}
}
