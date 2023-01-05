package LinkedList;

public class SingleLinkedListTest {

	public static void main(String[] args) {
		
		SingleLinkedList<Integer> MyLinkedList = new SingleLinkedList<Integer>();
		MyLinkedList.addNode(1);
		System.out.println(MyLinkedList.head.data);
		System.out.println();
		
		
		MyLinkedList.addNode(2);
		System.out.println(MyLinkedList.head.next.data);
		System.out.println();
		
		
		MyLinkedList.addNode(3);
		MyLinkedList.printAll();
		System.out.println();
		
		MyLinkedList.addNodeInside(5,1);
		MyLinkedList.printAll();
		System.out.println();
		
		MyLinkedList.delNode(3);
		MyLinkedList.printAll();
		System.out.println();
		
		MyLinkedList.delNode(1);
		MyLinkedList.printAll();
		System.out.println();
		
		

	}

}
