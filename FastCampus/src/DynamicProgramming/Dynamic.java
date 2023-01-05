package DynamicProgramming;

//Memoization기법을 사용함 -> 시간복잡도는 덜하지만, 공간복잡도에서 효율성 떨어짐 -> 재귀랑 비교했을때!

public class Dynamic {
	
	public static int dynamicFunc(int data) {
		Integer[] cache = new Integer[data + 1];
		cache[0] = 0;
		cache[1] = 1;
		for(int index = 2; index < data + 1; index++) {
			cache[index] = cache[index - 1] + cache[index - 2];
		}
		return cache[data];
	}

	public static void main(String[] args) {
		
		System.out.println(dynamicFunc(5));

	}

}
