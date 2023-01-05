package BinarySearchTree;

import BinarySearchTree.NodeMgmt.Node;

public class NodeMgmtTest {

	public static void main(String[] args) {
		
		NodeMgmt myTree = new NodeMgmt();
		myTree.insertNode(2);
		myTree.insertNode(3);
		myTree.insertNode(4);
		myTree.insertNode(6);
		System.out.println(myTree.search(7));
		
		//search메소드가 node를 반환한다고 해서 
		//왜 test할때 Node타입으로 선언함? --> 이것도 sc님께 여쭤보기(node가 이너클래스라서 상속과는 별개의 개념일듯!)
		//--> Node로 타입을 선언해줘야하는 이유 : NodeMgmt testNode = myTree.search(3); 
		//위와 같이 search메소드 자체를 호출할 수는 있지만, search메소드의 반환타입이 Node이기 때문에 Node타입으로 선언해줘야함!
		//만약 search메소드가 int형이었다면? -> int test = myTree.search(3);이렇게 작성해야만함.
		Node testNode = myTree.search(3);
		System.out.println(testNode.value);
		System.out.println(testNode.right.value);
		
		System.out.println();
		System.out.println();
		
		NodeMgmt myTree1 = new NodeMgmt();
		System.out.println(myTree1.insertNode(10));
		System.out.println(myTree1.insertNode(7));	
		System.out.println(myTree1.insertNode(6));
		System.out.println(myTree1.insertNode(8));
		System.out.println(myTree1.insertNode(15));
		System.out.println(myTree1.insertNode(11));
		System.out.println(myTree1.insertNode(13));
		System.out.println(myTree1.insertNode(14));
		System.out.println(myTree1.insertNode(17));
		System.out.println(myTree1.insertNode(16));
		System.out.println(myTree1.insertNode(18));
		System.out.println(myTree1.insertNode(19));
		System.out.println();
		
		System.out.println(myTree1.delete(15));
		myTree1.insertNode(10);
	     myTree1.insertNode(15);
	     myTree1.insertNode(13);
	     myTree1.insertNode(11);
	     myTree1.insertNode(14);
	     myTree1.insertNode(18);
	     myTree1.insertNode(16);
	     myTree1.insertNode(19);
	     myTree1.insertNode(17);
	     myTree1.insertNode(7);
	     myTree1.insertNode(8);
	     myTree1.insertNode(6);

		/*System.out.println(testNode1.left.value);
		System.out.println(testNode1.value);
		System.out.println(testNode1.right.value);*/
		
		System.out.println("HEAD: " + myTree1.head.value);
        System.out.println("HEAD LEFT: " + myTree1.head.left.value);
        System.out.println("HEAD LEFT LEFT: " + myTree1.head.left.left.value);
        System.out.println("HEAD LEFT RIGHT: " + myTree1.head.left.right.value);

        System.out.println("HEAD RIGHT: " + myTree1.head.right.value);
        System.out.println("HEAD RIGHT LEFT: " + myTree1.head.right.left.value);
        System.out.println("HEAD RIGHT RIGHT: " + myTree1.head.right.right.value);

        System.out.println("HEAD RIGHT RIGHT LEFT: " + myTree1.head.right.right.left.value);
        System.out.println("HEAD RIGHT RIGHT RIGHT: " + myTree1.head.right.right.right.value);
        
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("=============================");
        
        NodeMgmt myTree2 = new NodeMgmt();
        myTree2.insertNode(10);
        myTree2.insertNode(7);
        myTree2.insertNode(15);
        myTree2.insertNode(14);
        myTree2.insertNode(16);
        myTree2.insertNode(19);
        
        myTree2.delete(15);
        System.out.println("HEAD: " + myTree2.head.value);
        System.out.println("HEAD LEFT: " + myTree2.head.left.value);
        System.out.println("HEAD RIGHT: " + myTree2.head.right.value);
        System.out.println("HEAD LEFT LEFT: " + myTree2.head.left.left.value);
        System.out.println("HEAD LEFT RIGHT: " + myTree2.head.left.right.value);
        System.out.println("HEAD LEFT LEFT RIGHT: " + myTree2.head.left.right.value);
		
	}

}
