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
			} //Edge02 compareTo�޼��忡 ������������ �����Ͽ��� �ϴ��� comparator�� �켱������ ����Ǿ� ���������Ǵ� ���� Ȯ���� �� ����.
			//Comparable �������̽��� ���ǵǾ��ִٰ� �ϴ��� Comparator Ŭ���� ���ı������� ������ ��
		});
		
		for(int index=0; index<edges.length; index++) {
			System.out.println(edges[index].distance);
		}

	}

}
