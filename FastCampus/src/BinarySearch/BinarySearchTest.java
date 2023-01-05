package BinarySearch;

import java.util.ArrayList;
import java.util.Collections;

public class BinarySearchTest {

	public static void main(String[] args) {
		
		ArrayList<Integer> testData = new ArrayList<Integer>();
		
		for(int index=0; index<100; index++) {
			testData.add((int)(Math.random() * 100));
		}
		
		Collections.sort(testData);
		System.out.println(testData);
		
		BinarySearch bSearch = new BinarySearch();
		System.out.println(bSearch.searchFunc(testData, 4));
	}

}
