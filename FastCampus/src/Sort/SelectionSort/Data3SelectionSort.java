package Sort.SelectionSort;

import java.util.ArrayList;
import java.util.Collections;

public class Data3SelectionSort {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(5);
		list.add(3);
		list.add(6);
		
		for(int idx = 0; idx<list.size()-1; idx++) {
			if(idx == 0) {
				if(list.get(idx) > list.get(idx+1)) {
					Collections.swap(list, idx, idx+1);
				} else if(list.get(idx) > list.get(idx+2)){
					Collections.swap(list, idx, idx+2);
				} 
			} else {
				if(list.get(idx) > list.get(idx+1)) {
					Collections.swap(list, idx, idx+1);
				} 
			}
		}
		
		System.out.println(list);

	}

}
