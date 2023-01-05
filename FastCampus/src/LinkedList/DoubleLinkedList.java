package LinkedList;

public class DoubleLinkedList<T> {
	
	public Node<T> head = null;
	public Node<T> tail = null; //꼬리노드
	
	public class Node<T> {
		T data;
		Node<T> prev = null;
		Node<T> next = null;
		
		public Node(T data) {
			this.data = data;
		}
	}
	
	public void addNode(T data) {
		if(this.head == null) {
			this.head = new Node<T>(data);
			this.tail = this.head;
		} else {
			Node<T> node = this.head;
			while(node.next != null) {
				node = node.next;
			}
			node.next = new Node<T>(data);
			node.next.prev = node; //기존 prev값과 next값 모두 null로 초기화함.
			//마지막에 추가한 노드의 next는 null이어야하지만,
			//그 추가한 노드의 prev값은 이전 노드(node)를 가리켜야하기때문에
			//위와 같이 작성.
			this.tail = node.next;
		}
	}
	
	public void printAll() {
		if(this.head != null) {
			Node<T> node = this.head;
			System.out.println(node.data);
			while(node.next != null) {
				node = node.next;
				System.out.println(node.data);
			}
		}
	}
	
	//앞에서 부터 검색하는 메서드
	public T searchFromHead(T isData) {
		if(this.head == null) {
			return null;
		} else {
			Node<T> node = this.head;
			while(node!= null) {
				if(node.data == isData) {
					return node.data;
				} else {
					node = node.next;
				}
			} // 57라인에 node가 꼬리노드라면, node.next가 null이 되니 while문을 빠져나오게 됨.
			return null;
		}
	}
	
	//뒤에서 부터 검색하는 메서드
	public T searchFromTail(T isData) {
		if(this.head == null) {
			return null;
		} else {
			Node<T> node = this.tail;
			while(node != null) {
				if(node.data == isData) {
					return node.data;
				} else {
					node = node.prev;
				}
			}// 74라인에 prev값이 null라는 것은 head까지 왔다는 의미.
			return null;
		}
	}
	
	//임의 노드 앞에 노드를 추가하는 메서드
	public boolean insertToFront(T existedData, T addData) {
		if(this.head == null) {
			this.head = new Node<T>(addData);
			this.tail = this.head;
			return true;
		} else if(this.head.data == existedData) { //head가 이미 임의 노드 였다면, 그 앞에 노드를 추가
			Node<T> newHead = new Node<T>(addData);
			newHead.next = this.head;
			this.head = newHead;
			return true;
		} else {
			Node<T> node = this.head;
			while(node != null) {
				if(node.data == existedData) {
					Node<T> nodePrev = node.prev;
					
					nodePrev.next = new Node<T>(addData);
					nodePrev.next.next = node;
					
					nodePrev.next.prev = nodePrev;
					node.prev = nodePrev.next;
					return true;
				} else {
					node = node.next;
				}
			}
			return false;
		}
	}
}
