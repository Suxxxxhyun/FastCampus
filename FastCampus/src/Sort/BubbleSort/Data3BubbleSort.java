package Sort.BubbleSort;

import java.util.ArrayList;
import java.util.Collections;

public class Data3BubbleSort {

	public static void main(String[] args) {
		
		ArrayList<Integer> sort = new ArrayList<>();
		
		sort.add(3);
		sort.add(1);
		sort.add(2);
		
		for(int idx=0; idx<sort.size()-1; idx++) {
			/*if(idx == 2) {
				break;
			}*/
			if(sort.get(idx) > sort.get(idx+1)) {
				Collections.swap(sort, idx, idx+1);
			}
		}
		
		System.out.println(sort);


	}

}
