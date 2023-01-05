package DepthFirstSearch;

import java.util.ArrayList;
import java.util.HashMap;

public class DFSSearch {
	
	public ArrayList<String> dfsFunc(HashMap<String, ArrayList<String>> graph, String startNode){
		
		ArrayList<String> visited = new ArrayList<String>();
		ArrayList<String> needVisit = new ArrayList<String>();
		
		needVisit.add(startNode);
		
		while(needVisit.size() > 0) {
			String node = needVisit.remove(needVisit.size() - 1); //BFS와 이 부분만 다름(needvisit을 큐 -> 스택으로만 바꿈)
			if(!visited.contains(node)) {
				visited.add(node);
				needVisit.addAll(graph.get(node));
			}
		}
		
		return visited;
	}
}
