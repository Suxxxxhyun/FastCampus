package Sort.MergeSort;

import java.util.ArrayList;

//앞뒤로 자르기

public class Split {
	public void splitFunc(ArrayList<Integer> dataList) {
		if(dataList.size() <= 1) {
			return;
		} //받은 데이터의 사이즈가 1개니까 분리할 이유가 없음.
		
		int medium = dataList.size() / 2;
		
		ArrayList<Integer> leftArr = new ArrayList<Integer>();
		ArrayList<Integer> rightArr = new ArrayList<Integer>();
		
		leftArr = new ArrayList<Integer>(dataList.subList(0, medium));
		//0부터 medium - 1번 인덱스번호까지 해당 배열 아이템을 서브 배열로 추출
		rightArr = new ArrayList<Integer>(dataList.subList(medium, dataList.size()));
		//dataList.size가 5였다면, 0부터 1까지 leftArr, 2부터 마지막까지는 rightArr에 들어갈 것임.
	}
	
}
