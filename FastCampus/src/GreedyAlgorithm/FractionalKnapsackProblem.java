package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsackProblem {
	
	//5행 2열(가로 5개, 세로 2개)
	//Integer[][] objectList = {{10,10}, {15,12}, {20,10}, {25,8}, {30,5}}; 
	public void knapsackFunc(Integer[][] objectList, double capacity) { //capacity : 무게 제한 K를 의미함
		double totalValue = 0.0;
		double fraction = 0.0;
		
		//Integer[] => {10,10} .. 이런식으로 세트로 받는다는 의미
		Arrays.sort(objectList, new Comparator<Integer[]>() {

			@Override
			public int compare(Integer[] objectItem1, Integer[] objectItem2) {
				return (objectItem2[1] / objectItem2[0]) - (objectItem1[1] / objectItem1[0]);
			}
		});
		
		for(int index=0; index<objectList.length; index++) {
			//물건을 쪼갤 필요가 없는경우
			if((capacity - (double)objectList[index][0]) > 0 ){
				capacity -= (double)objectList[index][0];
				totalValue += (double)objectList[index][1];
				System.out.println("무게: " + objectList[index][0] + ",가치: " + objectList[index][1]);
			} else {
				fraction = capacity / (double)objectList[index][0];
				totalValue += (double)objectList[index][1] * fraction;
				System.out.println("무게: " + objectList[index][0] + ",가치: " + objectList[index][1] + ",비율 : " + fraction);
				break;
			}
		}
		System.out.println("총 담을 수 있는 가치 : " + totalValue);
	} 
}
