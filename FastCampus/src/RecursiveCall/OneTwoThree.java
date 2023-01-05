package RecursiveCall;

public class OneTwoThree {
	
	public static int onetwothree(int x) {
		if(x <= 1) {
			return 1;
		} else if( x == 2){
			return 2;
		} else if( x == 3 ) {
			return 4;
		} else {
			return onetwothree(x - 3) + onetwothree(x - 2) + onetwothree(x - 1);
		}
	}

	public static void main(String[] args) {
		
		System.out.println(onetwothree(5));

	}

}
