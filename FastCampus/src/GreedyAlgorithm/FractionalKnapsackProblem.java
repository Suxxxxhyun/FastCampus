package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsackProblem {
	
	//5�� 2��(���� 5��, ���� 2��)
	//Integer[][] objectList = {{10,10}, {15,12}, {20,10}, {25,8}, {30,5}}; 
	public void knapsackFunc(Integer[][] objectList, double capacity) { //capacity : ���� ���� K�� �ǹ���
		double totalValue = 0.0;
		double fraction = 0.0;
		
		//Integer[] => {10,10} .. �̷������� ��Ʈ�� �޴´ٴ� �ǹ�
		Arrays.sort(objectList, new Comparator<Integer[]>() {

			@Override
			public int compare(Integer[] objectItem1, Integer[] objectItem2) {
				return (objectItem2[1] / objectItem2[0]) - (objectItem1[1] / objectItem1[0]);
			}
		});
		
		for(int index=0; index<objectList.length; index++) {
			//������ �ɰ� �ʿ䰡 ���°��
			if((capacity - (double)objectList[index][0]) > 0 ){
				capacity -= (double)objectList[index][0];
				totalValue += (double)objectList[index][1];
				System.out.println("����: " + objectList[index][0] + ",��ġ: " + objectList[index][1]);
			} else {
				fraction = capacity / (double)objectList[index][0];
				totalValue += (double)objectList[index][1] * fraction;
				System.out.println("����: " + objectList[index][0] + ",��ġ: " + objectList[index][1] + ",���� : " + fraction);
				break;
			}
		}
		System.out.println("�� ���� �� �ִ� ��ġ : " + totalValue);
	} 
}
