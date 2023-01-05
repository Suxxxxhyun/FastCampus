package GreedyAlgorithm;

import java.util.ArrayList;

public class GreedyAlgorithmEx01 {

	//매개변수 coinList는 동전의 종류를 받기 위한것임.
	public void coinFunc(Integer price, ArrayList<Integer> coinList) {
		Integer totalCoinCount = 0; //총 동전의 개수
		Integer coinNum = 0; //동전이 4720원이라면 그 돈을 메꾸기 위한 동전의 수
		
		//ArrayList<Integer> details = new ArrayList<Integer>();
		
		for(int index=0; index<coinList.size(); index++) {
			coinNum = price/coinList.get(index);
			totalCoinCount += coinNum;
			price -= coinNum * coinList.get(index);
			//details.add(coinNum);
			System.out.println(coinList.get(index) + "원: " + coinNum + "개");
		}
		
		System.out.println("총 동전 갯수: " + totalCoinCount);
	}

}
