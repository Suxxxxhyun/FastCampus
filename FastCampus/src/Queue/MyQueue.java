package Queue;

//ArrayListŬ���� �̿��ؼ� ť ��� �����ϱ�
import java.util.ArrayList; //ArrayList -> ť�� ���� �������

public class MyQueue<T> {	//T : Ÿ��
	
	private ArrayList<T> queue = new ArrayList<>();
	
	public T dequeue() {
		if(queue.isEmpty()) {
			return null;
		} else {
			return queue.remove(0);
		}
	}
	
	public void enqueue(T value) {
		queue.add(value);
	}
	
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	
	public static void main(String[] args) {
		
		MyQueue<Integer> queue1 = new MyQueue<Integer>();
		queue1.enqueue(3);
		System.out.println(queue1.dequeue());
	}
}
