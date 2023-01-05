package Queue;

//ArrayList클래스 이용해서 큐 기능 구현하기
import java.util.ArrayList; //ArrayList -> 큐를 담을 저장공간

public class MyQueue<T> {	//T : 타입
	
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
