package BreadthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class HashMapCRUD {
	
	public static void main(String[] args) {
	
		//����
		HashMap<String, Integer> mapData1 = new HashMap<String, Integer>(); //������� ��1
		HashMap<String, Integer> mapData2 = new HashMap<String, Integer>(mapData1); //������� ��2 -> mapData1�� ��� ���� ���� HashMap����
		HashMap<String, Integer> mapData3 = new HashMap<String, Integer>(10); //������� ��3
		HashMap<String, ArrayList<String>> mapData4 = new HashMap<String, ArrayList<String>>(); //������� ��4
	
		//������ �߰�(put�޼��� �̿�)
		mapData1.put("A", 1);
		mapData1.put("B", 2);
		System.out.println(mapData2); //mapData2
		mapData2.put("A", 1);
		mapData2.put("B", 2);
		mapData2.put("C", 3);
		System.out.println(mapData2); //mapData2
		System.out.println();
		
		//������ �б�
		System.out.println(mapData1);
		System.out.println(mapData1.get("A"));
		System.out.println();
		
		//������ ���� - �����Ҷ��� �߰��Ҷ��� ���������� put�޼��� �̿�
		mapData1.put("B", 3);
		System.out.println(mapData1);
		System.out.println();
		
		//������ ���� - remove�޼��� �̿�
		mapData1.remove("A");
		System.out.println(mapData1);
		System.out.println();
		
		//BFS
		HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>(); //������� ��4
		graph.put("A", new ArrayList<String>(Arrays.asList("B", "C")));
		graph.put("B", new ArrayList<String>(Arrays.asList("A", "D")));
		graph.put("C", new ArrayList<String>(Arrays.asList("A", "G", "H", "I")));
		graph.put("D", new ArrayList<String>(Arrays.asList("B", "E", "F")));
		graph.put("E", new ArrayList<String>(Arrays.asList("D")));
		graph.put("F", new ArrayList<String>(Arrays.asList("D")));
		graph.put("G", new ArrayList<String>(Arrays.asList("C")));
		graph.put("H", new ArrayList<String>(Arrays.asList("C")));
		graph.put("I", new ArrayList<String>(Arrays.asList("C", "J")));
		graph.put("J", new ArrayList<String>(Arrays.asList("I")));
		
		System.out.println(graph);
	}
}
