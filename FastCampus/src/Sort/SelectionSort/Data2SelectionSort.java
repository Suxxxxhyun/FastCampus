package Sort.SelectionSort;

import java.util.ArrayList;
import java.util.Collections;

public class Data2SelectionSort {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(5);
		list.add(4);
		
		if(list.get(0) > list.get(1)) {
			Collections.swap(list, 0, 1);
		}
		
		System.out.println(list);

	}

}
