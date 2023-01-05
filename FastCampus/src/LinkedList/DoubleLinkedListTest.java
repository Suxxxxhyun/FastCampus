package LinkedList;

public class DoubleLinkedListTest {

	public static void main(String[] args) {
		
		DoubleLinkedList<Integer> MyLinkedList = new DoubleLinkedList<Integer>();
		
		MyLinkedList.addNode(2);
		MyLinkedList.addNode(4);
		MyLinkedList.addNode(5);
		MyLinkedList.addNode(8);
		
		MyLinkedList.printAll();
		System.out.println();
		
		System.out.println(MyLinkedList.searchFromTail(5));
		System.out.println(MyLinkedList.searchFromHead(5));
		
		System.out.println();
		
		System.out.println(MyLinkedList.insertToFront(5, 9));
		MyLinkedList.printAll();

	}

}
