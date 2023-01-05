package MinimumSpanningTree.PrimAlgorithm;

import java.util.HashMap;
import java.util.PriorityQueue;

public class pqPractice {

	public static void main(String[] args) {
		
		Edge02 edgeObject, linkedObject;
		
		HashMap<String,Edge02> map = new HashMap<String,Edge02>();
		
		PriorityQueue<Edge02> pq = new PriorityQueue<Edge02>();
		edgeObject = new Edge02("A",6);
		pq.add(edgeObject);
		map.put("A", edgeObject);
		//map [A,A,6]
		
		edgeObject = new Edge02("E",Integer.MAX_VALUE);
		//System.out.println(edgeObject); edgeObject ��ü �ּ� : MinimumSpanningTree.PrimAlgorithm.Edge02@2f92e0f4
		pq.add(edgeObject);
		map.put("B", edgeObject);
		//map [B,E,INF]
		
		edgeObject = new Edge02("C",7);
		pq.add(edgeObject);
		map.put("C", edgeObject);
		//map [c,c,7]
		
		System.out.println(map);
		System.out.println(pq);
		System.out.println();
		
		
		//�� �޸�(��ü�� ����Ǵ� ����)�� ����ǰ� �ִ� Ŭ���� ��ü Edge02 <- �̰��� �����ϰ� �ִ� �������� edgeObject, linkedObject
		//�⺻ �ڷ����� ���ø޸𸮿� ������ ������ ���� ���� ����, but �����ڷ���(��ü,�迭,�������̽�), ���� �����Ͱ��� ���޸𸮿� ����,  �������� edgeObject, linkedObject�� ���ø޸𸮿� ����(Edge02��ü�� ��ġ���� ���� �����)                                              
		linkedObject = map.get("B");
		linkedObject.weight = 3;
		
		System.out.println(map);
		System.out.println(pq);
		//���޸𸮿� Edge02
		//�ּڰ��� - edgeObject, linkedObject
		
		System.out.println(pq);
		System.out.println(pq);
		
		System.out.println(linkedObject); //linkedObject��ü �ּ� - MinimumSpanningTree.PrimAlgorithm.Edge02@2f92e0f4
		
		A a = new A();
		System.out.println(a.a);
		System.out.println(a);
		
		A b = new A();
		System.out.println(b.a);
		
		//���ø޸�(�������� ����ǰ� �ִ� ����)
		int c = 5;
		c = 3;
		System.out.println(c);
		
	}

}

class A{
	int a = 5;
	
	
}
