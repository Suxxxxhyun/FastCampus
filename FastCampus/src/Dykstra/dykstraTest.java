package Dykstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class dykstraTest {

	public static void main(String[] args) {
		
		HashMap<String, ArrayList<Edge>> graph = new HashMap<String, ArrayList<Edge>>();
		
		graph.put("A", new ArrayList<Edge>(Arrays.asList(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D"))));
		graph.put("B", new ArrayList<Edge>());
		graph.put("C", new ArrayList<Edge>(Arrays.asList(new Edge(5, "B"), new Edge(2, "D"))));
		graph.put("D", new ArrayList<Edge>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
		graph.put("E", new ArrayList<Edge>(Arrays.asList(new Edge(1, "F"))));
		graph.put("F", new ArrayList<Edge>(Arrays.asList(new Edge(5, "A"))));
		
		for(String key : graph.keySet()) {
			System.out.println(key);
			System.out.println(graph.get(key));
		}
		
		System.out.println();
		
		ArrayList<Edge> nodelist = graph.get("A");
		for(int i=0; i<nodelist.size(); i++) {
			System.out.println(nodelist.get(i));
		}
		
		DijkstraPath dOject = new DijkstraPath();
		System.out.println(dOject.dijkstraFunc(graph, "A"));
	}

}
