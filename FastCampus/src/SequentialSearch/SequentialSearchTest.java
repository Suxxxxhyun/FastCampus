package SequentialSearch;

import java.util.ArrayList;

public class SequentialSearchTest {

	public static void main(String[] args) {
		
		ArrayList<Integer> testData = new ArrayList<Integer>();
		
		for(int i=0; i<10; i++) {
			testData.add((int)(Math.random() * 100));
		}
		
		System.out.println(testData);
		
		SequentialSearch sSearch = new SequentialSearch();
		System.out.println(sSearch.searchFunc(testData, 99));

	}

}
