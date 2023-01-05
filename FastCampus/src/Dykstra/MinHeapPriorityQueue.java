package Dykstra;

import java.util.PriorityQueue;

public class MinHeapPriorityQueue {

	public static void main(String[] args) {
		
		PriorityQueue<Edge> priorityqueue = new PriorityQueue<Edge>();
		
		priorityqueue.add(new Edge(2, "A"));
		priorityqueue.add(new Edge(5, "B"));
		priorityqueue.add(new Edge(1, "C"));
		priorityqueue.add(new Edge(7, "D"));
		
		System.out.println(priorityqueue);
		System.out.println(priorityqueue.peek());
		
		System.out.println();
		
		//Edge edge1 = priorityqueue.poll();
		//System.out.println(edge1);
		System.out.println(priorityqueue.poll());
		System.out.println(priorityqueue);
		
		System.out.println(priorityqueue.size());
		
	}

}
