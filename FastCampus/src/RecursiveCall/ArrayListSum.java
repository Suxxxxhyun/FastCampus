package RecursiveCall;

import java.util.ArrayList;

public class ArrayListSum {
	
	public static int ArraySum(ArrayList<Integer> dataList) {
		
		if(dataList.size() <= 0) {
			return 0;
		} else {
			return dataList.get(0) + ArraySum(new ArrayList<Integer>(dataList.subList(1, dataList.size())));
		}
	}

	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();
		
		for(int i=0; i<10; i++) {
			list.add(i);
		}
		
		System.out.println(ArraySum(list));

	}

}
