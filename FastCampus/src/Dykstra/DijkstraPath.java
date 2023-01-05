package Dykstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DijkstraPath {
	
	public HashMap<String, Integer> dijkstraFunc(HashMap<String, ArrayList<Edge>> graph, String start){
		
		Edge edgeNode, adjacentNode;
		ArrayList<Edge> nodeList;
		int currentDistance, weight, distance;
		String currentNode, adjacent;

		
		HashMap<String, Integer> distances = new HashMap<String, Integer>(); //거리저장배열
		
		for(String key:graph.keySet()) {
			distances.put(key, Integer.MAX_VALUE);
		}
		
		distances.put(start, 0);
		
		PriorityQueue<Edge> priorityqueue = new PriorityQueue<Edge>();
		priorityqueue.add(new Edge(distances.get(start), start));
		
		//알고리즘작성
		while(priorityqueue.size() > 0) {
			edgeNode = priorityqueue.poll();
			currentDistance = edgeNode.distance; //1
			currentNode = edgeNode.vertex;
			
			if(distances.get(currentNode) < currentDistance) {
				continue;
			}
			
			nodeList = graph.get(currentNode); //b와 d
			for(int index=0; index<nodeList.size(); index++) {
				adjacentNode = nodeList.get(index);
				adjacent = adjacentNode.vertex; //b
				weight = adjacentNode.distance; //5
				distance = currentDistance + weight; //c의 1 + b의 5, 1
				
				if(distance < distances.get(adjacent)) {
					distances.put(adjacent, distance);
					priorityqueue.add(new Edge(distance, adjacent));
				}
			}
		}
		
		return distances;
	}
}
