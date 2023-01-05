package BubbleSort;

import java.util.ArrayList;
import java.util.Collections;

public class Data2BubbleSort {

	public static void main(String[] args) {
		
		ArrayList<Integer> sort = new ArrayList<>();
		
		sort.add(2);
		sort.add(1);
		
		if(sort.get(0) > sort.get(1)) {
			Collections.swap(sort, 0, 1);
		}
		
		System.out.println(sort);

	}

}
