package RecursiveCall;

import java.util.ArrayList;
import java.util.List;

public class SubList {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList();
		
		for(int i=0; i<10; i++) {
			list.add(i);
		}
		
		//����Ʈ �ڸ���
		System.out.println(list.subList(0, 3));

	}

}
