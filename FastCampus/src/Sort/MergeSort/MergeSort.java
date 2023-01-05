package Sort.MergeSort;

import java.util.ArrayList;

public class MergeSort {
	
	//���ĵ� �迭�� �����ϴ� �Լ�
	public ArrayList<Integer> mergeFunc(ArrayList<Integer> leftList, ArrayList<Integer> rightList){
			
		ArrayList<Integer> mergedList = new ArrayList<Integer>();
			
		int leftPoint = 0;
		int rightPoint = 0;
		//�ΰ��� �и��� ������ �迭�� �ε����� 0������ ����Ű�� ���� ���� ����
			
		//Case1 : left/right �� �� �������� ��
		while(leftList.size() > leftPoint && rightList.size() > rightPoint) {
			if(leftList.get(leftPoint) > rightList.get(rightPoint)) {
				mergedList.add(rightList.get(rightPoint));
				rightPoint += 1;
			} else {
				mergedList.add(leftList.get(leftPoint));
				leftPoint += 1;
			}
		}
			
		//Case2 : right�����Ͱ� ������ (left�����͸� �ְų�, left,right�Ѵ� ���ų�)
		while(leftList.size() > leftPoint) {
			mergedList.add(leftList.get(leftPoint));
			leftPoint += 1;
		}
		//Case3 : left�����Ͱ� ������ (right�����͸� �ְų�, left,right�Ѵ� ���ų�)
		while(rightList.size() > rightPoint) {
			mergedList.add(rightList.get(rightPoint));
			rightPoint += 1;
		}
			
		return mergedList;
	}
	
	public ArrayList<Integer> mergesplitFunc(ArrayList<Integer> dataList) {
		if(dataList.size() <= 1) {
			return dataList;
		} //���� �������� ����� 1���ϱ� �и��� ������ ����.
		
		int medium = dataList.size() / 2;
		
		ArrayList<Integer> leftArr = new ArrayList<Integer>();
		ArrayList<Integer> rightArr = new ArrayList<Integer>();
		
		leftArr = this.mergesplitFunc(new ArrayList<Integer>(dataList.subList(0, medium)));
		//0���� medium - 1�� �ε�����ȣ���� �ش� �迭 �������� ���� �迭�� ����
		rightArr = this.mergesplitFunc(new ArrayList<Integer>(dataList.subList(medium, dataList.size())));
		//dataList.size�� 5���ٸ�, 0���� 1���� leftArr, 2���� ������������ rightArr�� �� ����.
		
		return this.mergeFunc(leftArr, rightArr);
	}
}
