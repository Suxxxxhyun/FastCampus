package Heap;

public class HeapTest {

	public static void main(String[] args) {
		
		Heap heapTest = new Heap(15);
		heapTest.insert(10);
		heapTest.insert(8);
		heapTest.insert(5);
		heapTest.insert(4); 
		heapTest.insert(20); //test insert 20넣을 경우 위치 바꾸기
		System.out.println(heapTest.heapArray);
		
		
		heapTest.pop();
		System.out.println(heapTest.heapArray);

	}

}
