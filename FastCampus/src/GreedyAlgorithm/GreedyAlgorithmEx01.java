package GreedyAlgorithm;

import java.util.ArrayList;

public class GreedyAlgorithmEx01 {

	//�Ű����� coinList�� ������ ������ �ޱ� ���Ѱ���.
	public void coinFunc(Integer price, ArrayList<Integer> coinList) {
		Integer totalCoinCount = 0; //�� ������ ����
		Integer coinNum = 0; //������ 4720���̶�� �� ���� �޲ٱ� ���� ������ ��
		
		//ArrayList<Integer> details = new ArrayList<Integer>();
		
		for(int index=0; index<coinList.size(); index++) {
			coinNum = price/coinList.get(index);
			totalCoinCount += coinNum;
			price -= coinNum * coinList.get(index);
			//details.add(coinNum);
			System.out.println(coinList.get(index) + "��: " + coinNum + "��");
		}
		
		System.out.println("�� ���� ����: " + totalCoinCount);
	}

}
