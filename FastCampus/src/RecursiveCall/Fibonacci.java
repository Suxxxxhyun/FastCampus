package RecursiveCall;

//Memoization����� ������� ���� -> �ð����⵵�� ȿ���� ��������, �������⵵���� ���� -> DP�� ��������!

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
