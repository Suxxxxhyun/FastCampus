package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class Edge02Test {

	public static void main(String[] args) {
		
		Edge02 edge1 = new Edge02(12, "A");
		Edge02 edge2 = new Edge02(10, "A");
		Edge02 edge3 = new Edge02(13, "A");
		Edge02[] edges = new Edge02[] {edge1, edge2, edge3};
		Arrays.sort(edges, new Comparator<Edge02>() {

			@Override
			public int compare(Edge02 objectItem1, Edge02 objectItem2) {
				return objectItem2.distance - objectItem1.distance;
			} //Edge02 compareTo메서드에 오름차순으로 구현하였다 하더라도 comparator가 우선순위로 적용되어 내림차순되는 것을 확인할 수 있음.
			//Comparable 인터페이스가 정의되어있다고 하더라도 Comparator 클래스 정렬기준으로 정렬이 됨
		});
		
		for(int index=0; index<edges.length; index++) {
			System.out.println(edges[index].distance);
		}

	}

}
