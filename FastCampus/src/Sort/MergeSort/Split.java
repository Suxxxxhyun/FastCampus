package Sort.MergeSort;

import java.util.ArrayList;

//�յڷ� �ڸ���

public class Split {
	public void splitFunc(ArrayList<Integer> dataList) {
		if(dataList.size() <= 1) {
			return;
		} //���� �������� ����� 1���ϱ� �и��� ������ ����.
		
		int medium = dataList.size() / 2;
		
		ArrayList<Integer> leftArr = new ArrayList<Integer>();
		ArrayList<Integer> rightArr = new ArrayList<Integer>();
		
		leftArr = new ArrayList<Integer>(dataList.subList(0, medium));
		//0���� medium - 1�� �ε�����ȣ���� �ش� �迭 �������� ���� �迭�� ����
		rightArr = new ArrayList<Integer>(dataList.subList(medium, dataList.size()));
		//dataList.size�� 5���ٸ�, 0���� 1���� leftArr, 2���� ������������ rightArr�� �� ����.
	}
	
}
