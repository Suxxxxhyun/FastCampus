package BubbleSort;

public class MathRandom {

	public static void main(String[] args) {
		
		//0.0�� 1.0������ ������ �߻���Ŵ. 
		//-> 0.0���� ũ�ų� ���� 1.0���� ���� ������ �߻���Ŵ
		System.out.println(Math.random());
		
		//���⿡ 100�� ���ϸ� �ᱹ 0���� ũ�ų� ���� 99���� ���� �����߻�
		System.out.println(Math.random() * 100);
		//�ٵ� �� �����κи� �ʿ��ϴ� (int)�� ����ȯ������.
		System.out.println((int)(Math.random() * 100));
		
		//1���� 100������ �����?
		System.out.println((int)(Math.random() * 100)+1);

	}

}
