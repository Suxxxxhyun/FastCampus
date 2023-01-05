package MinimumSpanningTree.PrimAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PriorityQueuePractice {

	public static void main(String[] args) {
		
		//�ּ���
		PriorityQueue<Edge> priorityqueue = new PriorityQueue<Edge>();
		priorityqueue.add(new Edge(2,"A","B"));
		priorityqueue.add(new Edge(5,"B","D"));
		priorityqueue.add(new Edge(3,"C","A"));
		
		while(priorityqueue.size() > 0) {
			System.out.println(priorityqueue.poll());
		}
		
		System.out.println();
		//�����ϰ��� �ϴ� ���������� '����� ��� ����'�� ��� ���� ������ Ȯ���ϴ� ��� -> containsKey()�޼ҵ� ���
		HashMap<String, ArrayList<Edge>> graph = new HashMap<String,ArrayList<Edge>>();
		graph.put("A", new ArrayList<Edge>());
		graph.put("B", new ArrayList<Edge>());
		
		System.out.println(graph.containsKey("C"));
		System.out.println(graph.containsKey("B"));
		
		//ã�� Ű�� ���� ���� ������, ����Ʈ �� ��ȯ�ϱ� -> getOrDefault()�޼ҵ� ���
		System.out.println(graph.getOrDefault("C", new ArrayList<Edge>()));
	}

}
