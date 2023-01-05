package LinkedList;

public class SingleLinkedList<T> {
	
	public class Node<T>{
		T data;
		Node<T> next = null;
		
		public Node(T data) {
			this.data = data;
		}
	}
	
	public Node<T> head = null;
	
	//꼬리노드쪽에 노드를 추가하기 위한 메서드
	public void addNode(T data) {
		if(head == null) {
			head = new Node<T>(data);
		} else {
			Node<T> node = this.head;
			while(node.next != null) {
				node = node.next;
			} //끝에 노드까지 가기위함.
			node.next = new Node<T>(data);
		}
	}
	
	public void printAll() {
		if(head != null) {
			Node<T> node = this.head;
			System.out.println(node.data);
			while(node.next != null) {
				node = node.next;
				System.out.println(node.data);
			}
		}
	}
	
	
	public Node<T> search(T data){
		if(this.head == null) {
			return null;
		} else {
			Node<T> node = this.head;
			while(node != null) {
				if(node.data == data) {
					return node;
				} else {
					node = node.next;
				}
			}
			return null;
		}
	}
	
	
	//링크드리스트안에 해당 데이터(isData)뒤에 노드를 추가하는 메서드
	public void addNodeInside(T data, T isData) {
		Node<T> searchedNode = this.search(isData);
		
		if(searchedNode == null) {
			this.addNode(data);
		} else {
			Node<T> nextNode = searchedNode.next;
			searchedNode.next = new Node<T>(data);
			searchedNode.next.next = nextNode;
		}
	}
	
	public boolean delNode(T isData) {
		if(this.head == null) {
			return false;
		} else {
			Node<T> node = this.head;
			if(node.data == isData) {
				this.head = this.head.next;
				return true;
			} else {
				while(node.next != null) {
					if(node.next.data == isData) {
						node.next = node.next.next;
						return true;
					}
					node = node.next;
				}
				return false;
			}
			
		}
	}
}
