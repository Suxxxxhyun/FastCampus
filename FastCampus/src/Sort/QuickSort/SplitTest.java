package Sort.QuickSort;

import java.util.ArrayList;
import java.util.Arrays;

public class SplitTest {

	public static void main(String[] args) {
		
		Integer[] array = {4,1,2,5,7};
		
		//asList() �޼���� Arrays�� private ���� Ŭ������ ArrayListŬ������ �����Ѵ�.
		ArrayList<Integer> testData = new ArrayList<Integer>(Arrays.asList(array));
		System.out.println(testData);
		
		Split split = new Split();
		split.splitFunc(testData);

	}

}
