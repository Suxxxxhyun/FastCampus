package RecursiveCall;

public class Factorial {
	
	/*public static int Fac(int x) {
		
		if( x > 1) {
			return x * Fac(x-1);
		} else {
			return 1;
		}
	}*/
	
	public static int Fac(int x) {
		if( x <= 1) {
			return 1;
		} else {
			return x * Fac(x-1);
		}
	}

	public static void main(String[] args) {
		
		System.out.println(Fac(5));

	}

}
