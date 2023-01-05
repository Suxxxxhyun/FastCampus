package BubbleSort;

public class MathRandom {

	public static void main(String[] args) {
		
		//0.0과 1.0사이의 난수를 발생시킴. 
		//-> 0.0보다 크거나 같고 1.0보다 작은 난수를 발생시킴
		System.out.println(Math.random());
		
		//여기에 100을 곱하면 결국 0보다 크거나 같고 99보다 작은 난수발생
		System.out.println(Math.random() * 100);
		//근데 난 정수부분만 필요하니 (int)로 형변환시켜줌.
		System.out.println((int)(Math.random() * 100));
		
		//1부터 100까지의 출력은?
		System.out.println((int)(Math.random() * 100)+1);

	}

}
