package MinimumSpanningTree.KruskalAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class KruskalAlgorithmFinalTest {

	public static void main(String[] args) {
		
		ArrayList<String> vertices = new ArrayList<String>(Arrays.asList("A","B","C","D","E","F","G")); //노드의 정보
		ArrayList<Edge> edges = new ArrayList<Edge>();
		edges.add(new Edge(7,"A","B"));
		edges.add(new Edge(5, "A", "D"));
		edges.add(new Edge(7, "B", "A"));
		edges.add(new Edge(8, "B", "C"));
		edges.add(new Edge(9, "B", "D"));
		edges.add(new Edge(7, "B", "E"));
		edges.add(new Edge(8, "C", "B"));
		edges.add(new Edge(5, "C", "E"));
		edges.add(new Edge(5, "D", "A"));
		edges.add(new Edge(9, "D", "B"));
		edges.add(new Edge(7, "D", "E"));
		edges.add(new Edge(6, "D", "F"));
		edges.add(new Edge(7, "E", "B"));
		edges.add(new Edge(5, "E", "C"));
		edges.add(new Edge(7, "E", "D"));
		edges.add(new Edge(8, "E", "F"));
		edges.add(new Edge(9, "E", "G"));
		edges.add(new Edge(6, "F", "D"));
		edges.add(new Edge(8, "F", "E"));
		edges.add(new Edge(11, "F", "G"));
		edges.add(new Edge(9, "G", "E"));
		edges.add(new Edge(11, "G", "F"));
		
		KruskalAlgorithmFinal kObject = new KruskalAlgorithmFinal();
		System.out.println(kObject.kruskalFunc(vertices, edges));

	}

}
