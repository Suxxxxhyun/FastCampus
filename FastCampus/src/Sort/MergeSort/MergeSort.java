package Sort.MergeSort;

import java.util.ArrayList;

public class MergeSort {
	
	//정렬된 배열을 리턴하는 함수
	public ArrayList<Integer> mergeFunc(ArrayList<Integer> leftList, ArrayList<Integer> rightList){
			
		ArrayList<Integer> mergedList = new ArrayList<Integer>();
			
		int leftPoint = 0;
		int rightPoint = 0;
		//두개로 분리한 각각의 배열의 인덱스를 0번으로 가리키기 위해 변수 선언
			
		//Case1 : left/right 둘 다 남아있을 때
		while(leftList.size() > leftPoint && rightList.size() > rightPoint) {
			if(leftList.get(leftPoint) > rightList.get(rightPoint)) {
				mergedList.add(rightList.get(rightPoint));
				rightPoint += 1;
			} else {
				mergedList.add(leftList.get(leftPoint));
				leftPoint += 1;
			}
		}
			
		//Case2 : right데이터가 없을때 (left데이터만 있거나, left,right둘다 없거나)
		while(leftList.size() > leftPoint) {
			mergedList.add(leftList.get(leftPoint));
			leftPoint += 1;
		}
		//Case3 : left데이터가 없을때 (right데이터만 있거나, left,right둘다 없거나)
		while(rightList.size() > rightPoint) {
			mergedList.add(rightList.get(rightPoint));
			rightPoint += 1;
		}
			
		return mergedList;
	}
	
	public ArrayList<Integer> mergesplitFunc(ArrayList<Integer> dataList) {
		if(dataList.size() <= 1) {
			return dataList;
		} //받은 데이터의 사이즈가 1개니까 분리할 이유가 없음.
		
		int medium = dataList.size() / 2;
		
		ArrayList<Integer> leftArr = new ArrayList<Integer>();
		ArrayList<Integer> rightArr = new ArrayList<Integer>();
		
		leftArr = this.mergesplitFunc(new ArrayList<Integer>(dataList.subList(0, medium)));
		//0부터 medium - 1번 인덱스번호까지 해당 배열 아이템을 서브 배열로 추출
		rightArr = this.mergesplitFunc(new ArrayList<Integer>(dataList.subList(medium, dataList.size())));
		//dataList.size가 5였다면, 0부터 1까지 leftArr, 2부터 마지막까지는 rightArr에 들어갈 것임.
		
		return this.mergeFunc(leftArr, rightArr);
	}
}
