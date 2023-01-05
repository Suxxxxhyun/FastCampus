package Sort.SelectionSort;

import java.util.ArrayList;

public class SelcetionSortTest {

	public static void main(String[] args) {
		
		ArrayList<Integer> testData = new ArrayList<>();
		/*for(int i=0; i<100; i++) {
			testData.add((int)(Math.random() * 100));
		}*/
		
		testData.add(7);
		testData.add(5);
		testData.add(3);
		testData.add(9);
		
		SelectionSort sSort = new SelectionSort();
		System.out.println(sSort.sort(testData));

	}

}
