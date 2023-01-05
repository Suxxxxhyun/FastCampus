package Sort.MergeSort;

import java.util.ArrayList;

public class MergeSortTest {

	public static void main(String[] args) {
		
		ArrayList<Integer> testData = new ArrayList<Integer>();
		
		/*for(int index=0; index<100; index++) {
			testData.add((int)(Math.random() * 100));
		}*/
		
		testData.add(6);
		testData.add(5);
		testData.add(3);
		testData.add(7);
		testData.add(2);
		testData.add(4);
		
		MergeSort mSort = new MergeSort();
		System.out.println(mSort.mergesplitFunc(testData));

	}

}
