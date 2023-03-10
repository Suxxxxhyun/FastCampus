package MinimumSpanningTree.PrimAlgorithm;

import java.util.HashMap;

public class PrimAlgorithmImproveTest {

	public static void main(String[] args) {
		
		//현재 노드(key), 현재노드에서 인접한 정점과 가중치(value)
		HashMap<String, HashMap<String, Integer>> mygraph = new HashMap<String, HashMap<String, Integer>>();
		
		HashMap<String, Integer> edges;
		edges = new HashMap<String, Integer>();
		edges.put("B", 7);
		edges.put("D", 5);
		mygraph.put("A", edges);
		
		edges = new HashMap<String, Integer>();
		edges.put("A", 7);
		edges.put("D", 9);
		edges.put("C", 8);
		edges.put("E", 7);
		mygraph.put("B", edges);

		edges = new HashMap<String, Integer>();
		edges.put("B", 8);
		edges.put("E", 5);
		mygraph.put("C", edges);

		edges = new HashMap<String, Integer>();
		edges.put("A", 5);
		edges.put("B", 9);
		edges.put("E", 7);
		edges.put("F", 6);
		mygraph.put("D", edges);

		edges = new HashMap<String, Integer>();
		edges.put("B", 7);
		edges.put("C", 5);
		edges.put("D", 7);
		edges.put("F", 8);
		edges.put("G", 9);
		mygraph.put("E", edges);

		edges = new HashMap<String, Integer>();
		edges.put("D", 6);
		edges.put("E", 8);
		edges.put("G", 11);
		mygraph.put("F", edges);

		edges = new HashMap<String, Integer>();
		edges.put("E", 9);
		edges.put("F", 11);
		mygraph.put("G", edges);
		
		System.out.println(mygraph);
		
		PrimAlgorithmImprove pObject = new PrimAlgorithmImprove();
		System.out.println(pObject.improvedPrimFunc(mygraph, "A"));
	}

}
