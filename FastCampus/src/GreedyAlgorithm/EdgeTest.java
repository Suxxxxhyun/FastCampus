package GreedyAlgorithm;

import java.util.Arrays;

public class EdgeTest {

	public static void main(String[] args) {
		
		Edge edge1 = new Edge(12, "A");
		Edge edge2 = new Edge(10, "A");
		Edge edge3 = new Edge(13, "A");
		Edge[] edges = new Edge[] {edge1, edge2, edge3};
		Arrays.sort(edges);
		for(int index=0; index<edges.length; index++) {
			System.out.println(edges[index].distance);
		}
	}

}
