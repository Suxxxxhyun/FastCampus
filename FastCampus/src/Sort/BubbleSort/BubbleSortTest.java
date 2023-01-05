package Sort.BubbleSort;

import java.util.ArrayList;

public class BubbleSortTest {

	public static void main(String[] args) {
		
		ArrayList<Integer> testData = new ArrayList<Integer>();
		for(int i=0; i<100; i++) {
			testData.add((int)(Math.random() * 100));
		}
		
		BubbleSort bSort = new BubbleSort();
		System.out.println(bSort.sort(testData));	

	}

}
