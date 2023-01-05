package Sort.InsertionSort;

import java.util.ArrayList;

public class InsertionSortTest {

	public static void main(String[] args) {
		
		ArrayList<Integer> testData = new ArrayList<>();
		
		for(int index=0; index<100; index++) {
			testData.add((int)(Math.random() * 100));
		}
		
		InsertionSort iSort = new InsertionSort();
		System.out.println(iSort.sort(testData));

	}

}
