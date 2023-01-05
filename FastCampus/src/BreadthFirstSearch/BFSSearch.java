package BreadthFirstSearch;

import java.util.ArrayList;
import java.util.HashMap;

public class BFSSearch {
	
	public ArrayList<String> bfsFunc(HashMap<String, ArrayList<String>> graph, String startNode){
		
		ArrayList<String> visited = new ArrayList<String>();
		ArrayList<String> needVisit = new ArrayList<String>();
		
		needVisit.add(startNode);
		
		//needVisit.size > 0 = �湮�ؾߵ� ��尡 ���� �����ִٴ� �ǹ�
		int count = 0;
		while(needVisit.size() > 0) {
			count += 1;
			String node = needVisit.remove(0);
			
			//�湮�� ���� ���ٸ�
			if(!visited.contains(node)) {
				visited.add(node);
				needVisit.addAll(graph.get(node));
			}
		}
		
		System.out.println(count);
		return visited;
	}
}
