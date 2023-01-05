package BinarySearchTree;

public class NodeMgmt { //NodeMgmt : NodeManagement (전체 노드 관리)
	
	Node head = null;
	
	public class Node{
		Node left;
		Node right;
		int value; //데이터를 정수로 넣을것임.
		
		public Node(int data) {
			this.value = data;
			this.left = null;
			this.right = null;
		}
	}
	
	//왜 this.head로 알 수 있을까? --> sc님께 여쭤보기
	public boolean insertNode(int data) {
		//case1 : 노드가 하나도 없을 때
		if(this.head == null) {
			this.head = new Node(data);
		} // case2 : 노드가 하나 이상 들어가 있을때 
		else {
			Node findNode = this.head;
			while(true) {
				//case2-1: 현재 Node의 왼쪽에 노드가 들어가야할때 
				if(data < findNode.value) {
					if(findNode.left != null) {
						findNode = findNode.left;
					} else {
						findNode.left = new Node(data);
						break;
					}
				} else { //case2-2 : 현재 노드의 오른쪽에 노드가 들어가야할때
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
		//case1 : Node가 하나도 없을때
		if(this.head == null) {
			return null;
		} //case2 : Node가 하나 이상 있을때 
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
	
	
	//delete ) 삭제할 노드가 없는 경우도 처리해야함. -> 이를 위해 삭제할 Node가 없는 경우는 false를 리턴하고 함수를 종료시킴
	public boolean delete(int value) { //삭제할 노드를 찾았다면 searched가 true가 되게끔 구현할거임
		
		boolean searched = false;
		
		Node currParentNode = this.head; //삭제할 노드의 부모노드
		Node currNode = this.head; //삭제할 노드
		
		//예외케이스 1 : 노드가 하나도 없는 경우
		if(this.head == null) {
			return false;
		} //예외케이스 2 : 노드가 단지하나만 있고, 해당 노드가 삭제할 노드일때
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
			
			if(searched == false) { //탐색했더니, 삭제할 노드가 없는 경우
				return false;
			}
			
			//여기까지 실행되면,
			//currNode에는 해당 데이터를 가지고 있는 Node,
			//currParentNode에는 해당 데이터를 가지고 있는 노드의 부모 노드
		}
		
		//case1 : 삭제할 노드가 리프노드인 경우
		if(currNode.left == null && currNode.right == null) {
			if(value < currParentNode.value) { //if조건의 value는 currNode의 value임!
				currParentNode.left = null;
				currNode = null;
			} else {
				currParentNode.right = null;
				currNode = null;
			}
			return true;
		} //case2 : 삭제할 노드가 childNode를 하나 가지고 있는 경우
		else if(currNode.left != null && currNode.right == null) {    //case 2-1 : 삭제할 노드의 childNode가 왼쪽인경우  //case 2-1 : 삭제할 노드의 childNode가 오른쪽인경우
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
		} else {													//case3-1 : 삭제할 노드가 childNode두개 가지고 있고,
			if(value < currParentNode.value) {                     // 삭제할 노드가 부모노드의 왼쪽에 있을 때
				Node changeNode = currNode.right;					//그림으로 먼저 따지면, 일단 18노드 부분이 changeNode가 됨
				Node changeParentNode = currNode.right;
				while(changeNode.left != null) {
					changeParentNode = changeNode;
					changeNode = changeNode.left;
				}
				//여기까지 실행되면, changeNode에는 삭제할 Node의 오른쪽노드 중에서
				//가장 작은 값을 가진 노드가 들어가있게됨.(changeNode에)!
				
				//case3-1-1 : changeNode의 childNode가 없을 때  //case3-1-2 : changeNode의 오른쪽 childNode가 있을 때 
				if(changeNode.right != null) {
					changeParentNode.left = changeNode.right;
				} else {											
					changeParentNode.left = null;
				}
				
				//currParent의 왼쪽 childNode에, 삭제할 Node의 오른쪽 자식 중,
				//가장 작은 값을 가진 changeNode를 연결
				currParentNode.left = changeNode;
				
				//parentNode의 왼쪽childNode가 현재, changeNode이고
				//changeNode의 왼쪽/오른쪽 childNode를 모두, 삭제할 currNode의 
				//기존 왼쪽/오른쪽 노드로 변경
				changeNode.right = currNode.right;
				changeNode.left = currNode.left;
				
				currNode = null;
			} else {														//case3-1 : 삭제할 노드가 childNode두개 가지고 있고,
				Node changeNode = currNode.right;							// 삭제할 노드가 부모노드의 오른쪽에 있을 때
				Node changeParentNode = currNode.right;
				while(changeNode.left != null) {
					changeParentNode = changeNode;
					changeNode = changeNode.left;
				}
				//여기까지 실행되면, changeNode에는 삭제할 Node의 오른쪽노드 중에서
				//가장 작은 값을 가진 노드가 들어가있게됨.(changeNode에)!
				
				//case3-1-2 : changeNode의 오른쪽 childNode가 없을 때 
				if(changeNode.right != null) {
					changeParentNode.left = changeNode.right;
				} else {											
					changeParentNode.left = null;
				}
				
				//currParent의 오른쪽 childNode에, 삭제할 Node의 오른쪽 자식 중,
				//가장 작은 값을 가진 changeNode를 연결
				currParentNode.right = changeNode;
				
				//parentNode의 왼쪽childNode가 현재, changeNode이고
				//changeNode의 왼쪽/오른쪽 childNode를 모두, 삭제할 currNode의 
				//기존 왼쪽/오른쪽 노드로 변경
				// currNode.right 가 changeNode 일 경우, changeNode 가 currNode 자리로 올라가면서,
                // 오른쪽에 다시 자신의 객체를 가리키는 상황이 될 수 있습니다.
                // 이 경우 의도치 않게, 삭제할 객체를 다시 연결하는 상황이 될 수 있습니다.
                // 특별한 코너 케이스이므로, 참고로만 코드를 업데이트를 드리며,
                // 우선은 트리의 핵심 알고리즘 이해에 보다 초점을 맞추시는 것을 추천드립니다.
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
