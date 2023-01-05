package RecursiveCall;

//Memoization기법을 사용하지 않음 -> 시간복잡도는 효율성 떨어지고, 공간복잡도에서 좋음 -> DP랑 비교했을때!

public class Fibonacci {
	
	public static int Fibonacci(int x) {
		if(x == 0) {
			return 0;
		} else if(x == 1) {
			return 1;
		} else {
			return Fibonacci(x - 2) + Fibonacci(x - 1);
		}
	}

	public static void main(String[] args) {
		
		System.out.println(Fibonacci(10));

	}

}
