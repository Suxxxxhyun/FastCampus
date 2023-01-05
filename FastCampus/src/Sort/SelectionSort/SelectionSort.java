package Sort.SelectionSort;

import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort {
	public ArrayList<Integer> sort(ArrayList<Integer> dataList){
		int lowest; // 가장 작은 값을 넣기 위한 변수
		//즉, 1번째 실행하면, 그 중에서 가장 작은 값을 lowest에 넣어줄것임.
		for(int stand = 0; stand < dataList.size()-1; stand++) {
			lowest = stand; //맨 앞에 있는 것이 lowest라고 가정할것임.
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
