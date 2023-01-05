package LinkedList;

public class DoubleLinkedList<T> {
	
	public Node<T> head = null;
	public Node<T> tail = null; //�������
	
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
			node.next.prev = node; //���� prev���� next�� ��� null�� �ʱ�ȭ��.
			//�������� �߰��� ����� next�� null�̾��������,
			//�� �߰��� ����� prev���� ���� ���(node)�� �����Ѿ��ϱ⶧����
			//���� ���� �ۼ�.
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
	
	//�տ��� ���� �˻��ϴ� �޼���
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
			} // 57���ο� node�� ���������, node.next�� null�� �Ǵ� while���� ���������� ��.
			return null;
		}
	}
	
	//�ڿ��� ���� �˻��ϴ� �޼���
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
			}// 74���ο� prev���� null��� ���� head���� �Դٴ� �ǹ�.
			return null;
		}
	}
	
	//���� ��� �տ� ��带 �߰��ϴ� �޼���
	public boolean insertToFront(T existedData, T addData) {
		if(this.head == null) {
			this.head = new Node<T>(addData);
			this.tail = this.head;
			return true;
		} else if(this.head.data == existedData) { //head�� �̹� ���� ��� ���ٸ�, �� �տ� ��带 �߰�
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
