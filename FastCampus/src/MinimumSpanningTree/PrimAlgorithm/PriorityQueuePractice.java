package MinimumSpanningTree.PrimAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PriorityQueuePractice {

	public static void main(String[] args) {
		
		//최소힙
		PriorityQueue<Edge> priorityqueue = new PriorityQueue<Edge>();
		priorityqueue.add(new Edge(2,"A","B"));
		priorityqueue.add(new Edge(5,"B","D"));
		priorityqueue.add(new Edge(3,"C","A"));
		
		while(priorityqueue.size() > 0) {
			System.out.println(priorityqueue.poll());
		}
		
		System.out.println();
		//연결하고자 하는 인접정점이 '연결된 노드 집합'에 들어 있지 않은지 확인하는 방법 -> containsKey()메소드 사용
		HashMap<String, ArrayList<Edge>> graph = new HashMap<String,ArrayList<Edge>>();
		graph.put("A", new ArrayList<Edge>());
		graph.put("B", new ArrayList<Edge>());
		
		System.out.println(graph.containsKey("C"));
		System.out.println(graph.containsKey("B"));
		
		//찾는 키에 대한 값이 없을때, 디폴트 값 반환하기 -> getOrDefault()메소드 사용
		System.out.println(graph.getOrDefault("C", new ArrayList<Edge>()));
	}

}
