package SequentialSearch;

import java.util.ArrayList;

public class SequentialSearch {
	public int searchFunc(ArrayList<Integer> dataList, Integer searchItem) {
		for(int index=0; index<dataList.size(); index++) {
			if(dataList.get(index) == searchItem) {
				return index;
			}
		}
		
		return -1;
	}
}
