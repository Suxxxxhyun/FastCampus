package BinarySearchTree;

public class NodeMgmt { //NodeMgmt : NodeManagement (��ü ��� ����)
	
	Node head = null;
	
	public class Node{
		Node left;
		Node right;
		int value; //�����͸� ������ ��������.
		
		public Node(int data) {
			this.value = data;
			this.left = null;
			this.right = null;
		}
	}
	
	//�� this.head�� �� �� ������? --> sc�Բ� ���庸��
	public boolean insertNode(int data) {
		//case1 : ��尡 �ϳ��� ���� ��
		if(this.head == null) {
			this.head = new Node(data);
		} // case2 : ��尡 �ϳ� �̻� �� ������ 
		else {
			Node findNode = this.head;
			while(true) {
				//case2-1: ���� Node�� ���ʿ� ��尡 �����Ҷ� 
				if(data < findNode.value) {
					if(findNode.left != null) {
						findNode = findNode.left;
					} else {
						findNode.left = new Node(data);
						break;
					}
				} else { //case2-2 : ���� ����� �����ʿ� ��尡 �����Ҷ�
					if(findNode.right != null) {
						findNode = findNode.right;
					} else {
						findNode.right = new Node(data);
						break;
					}
				}
			}
		}
		return true;
	}
	
	
	public Node search(int data) {
		//case1 : Node�� �ϳ��� ������
		if(this.head == null) {
			return null;
		} //case2 : Node�� �ϳ� �̻� ������ 
		else {
			Node findNode = this.head;
			while(findNode != null) {
				if(findNode.value == data) {
					return findNode;
				} else if (data < findNode.value){
					findNode = findNode.left;
				} else {
					findNode = findNode.right;
				}
			}
			return null;
		}
	}
	
	
	//delete ) ������ ��尡 ���� ��쵵 ó���ؾ���. -> �̸� ���� ������ Node�� ���� ���� false�� �����ϰ� �Լ��� �����Ŵ
	public boolean delete(int value) { //������ ��带 ã�Ҵٸ� searched�� true�� �ǰԲ� �����Ұ���
		
		boolean searched = false;
		
		Node currParentNode = this.head; //������ ����� �θ���
		Node currNode = this.head; //������ ���
		
		//�������̽� 1 : ��尡 �ϳ��� ���� ���
		if(this.head == null) {
			return false;
		} //�������̽� 2 : ��尡 �����ϳ��� �ְ�, �ش� ��尡 ������ ����϶�
		else {
			if(this.head.value == value && this.head.left == null && this.head.right == null) {
				this.head = null;
				return true;
			}
			
			while(currNode != null) {
				if(currNode.value == value) {
					searched = true;
					break;
				} else if (value < currNode.value) {
					currParentNode = currNode;
					currNode = currNode.left;
				} else {
					currParentNode = currNode;
					currNode = currNode.right;
				}
			}
			
			if(searched == false) { //Ž���ߴ���, ������ ��尡 ���� ���
				return false;
			}
			
			//������� ����Ǹ�,
			//currNode���� �ش� �����͸� ������ �ִ� Node,
			//currParentNode���� �ش� �����͸� ������ �ִ� ����� �θ� ���
		}
		
		//case1 : ������ ��尡 ��������� ���
		if(currNode.left == null && currNode.right == null) {
			if(value < currParentNode.value) { //if������ value�� currNode�� value��!
				currParentNode.left = null;
				currNode = null;
			} else {
				currParentNode.right = null;
				currNode = null;
			}
			return true;
		} //case2 : ������ ��尡 childNode�� �ϳ� ������ �ִ� ���
		else if(currNode.left != null && currNode.right == null) {    //case 2-1 : ������ ����� childNode�� �����ΰ��  //case 2-1 : ������ ����� childNode�� �������ΰ��
			if(value < currParentNode.value) {
				currParentNode.left = currNode.left;
				currNode = null;
			} else {
				currParentNode.right = currNode.left;
				currNode = null;
			}
			return true;
		}
		else if(currNode.left == null && currNode.right != null) {
			if(value < currParentNode.value) {
				currParentNode.left = currNode.right;
				currNode = null;
			} else {
				currParentNode.right = currNode.right;
				currNode = null;
			}
			return true;
		} else {													//case3-1 : ������ ��尡 childNode�ΰ� ������ �ְ�,
			if(value < currParentNode.value) {                     // ������ ��尡 �θ����� ���ʿ� ���� ��
				Node changeNode = currNode.right;					//�׸����� ���� ������, �ϴ� 18��� �κ��� changeNode�� ��
				Node changeParentNode = currNode.right;
				while(changeNode.left != null) {
					changeParentNode = changeNode;
					changeNode = changeNode.left;
				}
				//������� ����Ǹ�, changeNode���� ������ Node�� �����ʳ�� �߿���
				//���� ���� ���� ���� ��尡 ���ְԵ�.(changeNode��)!
				
				//case3-1-1 : changeNode�� childNode�� ���� ��  //case3-1-2 : changeNode�� ������ childNode�� ���� �� 
				if(changeNode.right != null) {
					changeParentNode.left = changeNode.right;
				} else {											
					changeParentNode.left = null;
				}
				
				//currParent�� ���� childNode��, ������ Node�� ������ �ڽ� ��,
				//���� ���� ���� ���� changeNode�� ����
				currParentNode.left = changeNode;
				
				//parentNode�� ����childNode�� ����, changeNode�̰�
				//changeNode�� ����/������ childNode�� ���, ������ currNode�� 
				//���� ����/������ ���� ����
				changeNode.right = currNode.right;
				changeNode.left = currNode.left;
				
				currNode = null;
			} else {														//case3-1 : ������ ��尡 childNode�ΰ� ������ �ְ�,
				Node changeNode = currNode.right;							// ������ ��尡 �θ����� �����ʿ� ���� ��
				Node changeParentNode = currNode.right;
				while(changeNode.left != null) {
					changeParentNode = changeNode;
					changeNode = changeNode.left;
				}
				//������� ����Ǹ�, changeNode���� ������ Node�� �����ʳ�� �߿���
				//���� ���� ���� ���� ��尡 ���ְԵ�.(changeNode��)!
				
				//case3-1-2 : changeNode�� ������ childNode�� ���� �� 
				if(changeNode.right != null) {
					changeParentNode.left = changeNode.right;
				} else {											
					changeParentNode.left = null;
				}
				
				//currParent�� ������ childNode��, ������ Node�� ������ �ڽ� ��,
				//���� ���� ���� ���� changeNode�� ����
				currParentNode.right = changeNode;
				
				//parentNode�� ����childNode�� ����, changeNode�̰�
				//changeNode�� ����/������ childNode�� ���, ������ currNode�� 
				//���� ����/������ ���� ����
				// currNode.right �� changeNode �� ���, changeNode �� currNode �ڸ��� �ö󰡸鼭,
                // �����ʿ� �ٽ� �ڽ��� ��ü�� ����Ű�� ��Ȳ�� �� �� �ֽ��ϴ�.
                // �� ��� �ǵ�ġ �ʰ�, ������ ��ü�� �ٽ� �����ϴ� ��Ȳ�� �� �� �ֽ��ϴ�.
                // Ư���� �ڳ� ���̽��̹Ƿ�, ����θ� �ڵ带 ������Ʈ�� �帮��,
                // �켱�� Ʈ���� �ٽ� �˰��� ���ؿ� ���� ������ ���߽ô� ���� ��õ�帳�ϴ�.
				if (currNode.right != changeNode) {
	                 changeNode.right = currNode.right;
	             }
				changeNode.left = currNode.left;
				
				currNode = null;
			}
			return true;
																	
			
			
		}
		
		
		
	}
	
	
}
