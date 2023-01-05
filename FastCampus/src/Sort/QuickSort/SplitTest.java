package Sort.QuickSort;

import java.util.ArrayList;
import java.util.Arrays;

public class SplitTest {

	public static void main(String[] args) {
		
		Integer[] array = {4,1,2,5,7};
		
		//asList() 메서드는 Arrays의 private 정적 클래스인 ArrayList클래스를 리턴한다.
		ArrayList<Integer> testData = new ArrayList<Integer>(Arrays.asList(array));
		System.out.println(testData);
		
		Split split = new Split();
		split.splitFunc(testData);

	}

}
