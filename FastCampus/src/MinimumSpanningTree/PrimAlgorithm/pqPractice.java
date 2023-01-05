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
		//System.out.println(edgeObject); edgeObject 객체 주소 : MinimumSpanningTree.PrimAlgorithm.Edge02@2f92e0f4
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
		
		
		//힙 메모리(객체가 저장되는 공간)에 저장되고 있는 클래스 객체 Edge02 <- 이곳에 접근하고 있는 참조변수 edgeObject, linkedObject
		//기본 자료형은 스택메모리에 생선된 공간에 실제 값을 저장, but 참조자료형(객체,배열,인터페이스), 실제 데이터값은 힙메모리에 저장,  참조변수 edgeObject, linkedObject는 스택메모리에 저장(Edge02객체의 위치값이 각각 저장됨)                                              
		linkedObject = map.get("B");
		linkedObject.weight = 3;
		
		System.out.println(map);
		System.out.println(pq);
		//힙메모리에 Edge02
		//주솟값이 - edgeObject, linkedObject
		
		System.out.println(pq);
		System.out.println(pq);
		
		System.out.println(linkedObject); //linkedObject객체 주소 - MinimumSpanningTree.PrimAlgorithm.Edge02@2f92e0f4
		
		A a = new A();
		System.out.println(a.a);
		System.out.println(a);
		
		A b = new A();
		System.out.println(b.a);
		
		//스택메모리(변수들이 저장되고 있는 공간)
		int c = 5;
		c = 3;
		System.out.println(c);
		
	}

}

class A{
	int a = 5;
	
	
}
