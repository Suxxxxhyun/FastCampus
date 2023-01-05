package Sort.QuickSort;

import java.util.ArrayList;
import java.util.Arrays;

public class Split {
	public void splitFunc(ArrayList<Integer> dataList) {
		if(dataList.size() <= 1) {
			return;
		}
		
		int pivot = dataList.get(0);
		
		ArrayList<Integer> leftArr = new ArrayList<Integer>();
		ArrayList<Integer> rightArr = new ArrayList<Integer>();
		
		for(int index=1; index<dataList.size(); index++) {
			if(dataList.get(index) > pivot) {
				rightArr.add(dataList.get(index));
			} else {
				leftArr.add(dataList.get(index));
			}
		}
		
		ArrayList<Integer> mergedArr = new ArrayList<Integer>();
		mergedArr.addAll(leftArr);
		mergedArr.addAll(Arrays.asList(pivot)); //pivot ��ü�� int�ϱ� ��ü�迭�� ������� asList�޼�������
		mergedArr.addAll(rightArr);
		
		/*System.out.println(leftArr);
		System.out.println(pivot);
		System.out.println(rightArr);*/
		System.out.println(mergedArr);
	}
}
