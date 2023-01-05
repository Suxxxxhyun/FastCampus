package Sort.SelectionSort;

import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort {
	public ArrayList<Integer> sort(ArrayList<Integer> dataList){
		int lowest; // ���� ���� ���� �ֱ� ���� ����
		//��, 1��° �����ϸ�, �� �߿��� ���� ���� ���� lowest�� �־��ٰ���.
		for(int stand = 0; stand < dataList.size()-1; stand++) {
			lowest = stand; //�� �տ� �ִ� ���� lowest��� �����Ұ���.
			for(int index = stand+1; index<dataList.size(); index++) {
				if(dataList.get(lowest) > dataList.get(index)) {
					lowest = index;
				}
			}
			Collections.swap(dataList, lowest, stand);
		}
		return dataList;
	}
}
