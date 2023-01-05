package Sort.QuickSort;

import java.util.ArrayList;

public class QuickSortTest {

	public static void main(String[] args) {
		
		ArrayList<Integer> testData = new ArrayList<Integer>();
		
		for(int i=0; i<100; i++) {
			testData.add((int)(Math.random() * 100));
		}
		
		QuickSort qSort = new QuickSort();
		System.out.println(qSort.sort(testData));

	}

}
