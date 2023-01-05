package Sort.BubbleSort;

import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort {
	
	//정렬된 리스트를 리턴해주는 sort메서드 --> 파라미터로 정렬이 안된 리스트를 받게됨.
	public ArrayList<Integer> sort(ArrayList<Integer> dataList){ 
		for(int index = 0; index < dataList.size() - 1; index++) { //밖의 for반복문은 전체 체크를 몇번하는가 
			//한번도 자리교환이 안되는 경우를 확인해주기 위해 boolean swap변수 선언
			boolean swap = false;
			
			for(int index2=0; index2 < dataList.size() - 1 - index; index2++) { //두개씩 비교해주기 위한 반복문
				if(dataList.get(index2) > dataList.get(index2 + 1)) {
					Collections.swap(dataList, index2, index2 + 1);
					swap = true;
				}
			}
			
			if(swap == false) {
				break;
			}
		}
		
		return dataList;
	}
}
