package Heap;

import java.util.ArrayList;
import java.util.Collections;
//데이터를 배열에 넣을건데, 그 데이터들의 개수들이 정해진 것이 아니므로 arraylist이용

public class Heap { //MaxHeap의 구현
	
	public ArrayList<Integer> heapArray = null;
	
	public Heap(Integer data) {
		heapArray = new ArrayList<>();
		
		heapArray.add(null); //배열 0번을 null로 처리하기 위한과정 -> heap구현은 1번 인덱스부터 시작할거임.
		heapArray.add(data);
	}
	
	//insert시, 바꿔야할지 말아야할지, 즉 swap할지 말아야할지 판단하는 메서드
	public boolean moveUp(Integer inserted_idx) {
		if(inserted_idx <= 1) {	//루트노드
			return false;
		}
		Integer parent_idx = inserted_idx / 2;
		if(this.heapArray.get(inserted_idx) > this.heapArray.get(parent_idx)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean insert(Integer data) {
		Integer inserted_idx, parent_idx; //inserted_idx : 현재노드의 인덱스번호, parent_idx : 부모노드의 인덱스 번호
		
		if(heapArray == null) { //데이터를 다 꺼내서 null이 될 수 있는 경우 --> 이때는 인덱스번호를 계산할필요없이 데이터한개 넣으면됨.
			heapArray = new ArrayList<>();
			
			heapArray.add(null);
			heapArray.add(data);
			
			return true;
		} 
		
		this.heapArray.add(data);
		inserted_idx = this.heapArray.size() - 1; //4개의 데이터가 있다면 각각 0번, 1번, 2번, 3번 -> 즉 현재노드의 인덱스번호는 전체데이터개수의 1을 빼준것과 같음.
		
		while(this.moveUp(inserted_idx)) {
			parent_idx = inserted_idx / 2;
			Collections.swap(this.heapArray, inserted_idx , parent_idx);
			inserted_idx = parent_idx;
		}
		
		return true;
	}
	
	//삭제메서드 - 루트노드를 삭제하는 메서드 (Heap에서, 중간에 있는 노드를 삭제하는 경우는 없다.)
	public Integer pop() {
		Integer returned_data, popped_idx, left_child_popped_idx, right_child_popped_idx;
		
		if(this.heapArray == null) {
			return null;
		} else {
			returned_data = this.heapArray.get(1);
			this.heapArray.set(1, this.heapArray.get(this.heapArray.size() - 1));
			this.heapArray.remove(this.heapArray.size()-1);
			popped_idx = 1; //이제 20과 8이 자리바뀌고 20이 완전히 삭제된 상황임!. 이제 시작!
			
			while(this.move_down(popped_idx)) {
				left_child_popped_idx = popped_idx * 2;
				right_child_popped_idx = popped_idx * 2 + 1;
				
				//case2 : 오른쪽 자식노드만 없을때
				if(right_child_popped_idx >= this.heapArray.size()) {
					if(this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
						Collections.swap(heapArray, popped_idx, left_child_popped_idx);
						popped_idx = left_child_popped_idx;
					}
				} else {										//case 3: 왼쪽/오른쪽 자식 노드가 모두 있을때
					if(this.heapArray.get(left_child_popped_idx) > this.heapArray.get(right_child_popped_idx)) {
						if(this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
							Collections.swap(heapArray, popped_idx, left_child_popped_idx);
							popped_idx = left_child_popped_idx;
						}
					} else {
						if(this.heapArray.get(popped_idx) < this.heapArray.get(right_child_popped_idx)) {
							Collections.swap(heapArray, popped_idx, right_child_popped_idx);
							popped_idx = right_child_popped_idx;
						}
					}
				}
			}
			
			
			return returned_data; 
		}
	}
	
	//pop할때, swap할지 말아야할지 판단하는 메서드
	public boolean move_down(Integer popped_idx) {
		Integer left_child_popped_idx, right_child_popped_idx; //popped_idx의 왼쪽자식과 오른쪽 자식
		
		left_child_popped_idx = popped_idx * 2;
		right_child_popped_idx = popped_idx * 2 + 1;
		
		//case1 : 왼쪽 자식노드도 없을때 --> 즉 왼쪽노드조차 없을때를 말함. (자식 노드가 하나도 없을때)
		// 왜 오른쪽이 없냐? 애초에 완전이진트리였으니 왼쪽부터 넣었자내! 근데 왼쪽 없고 오른쪽이 있다는게 말이 안됨.
		if(left_child_popped_idx >= this.heapArray.size()) { /*************여기가 가장 중요 ! 왼쪽이 없을때를 size와 left_child_idx를 이용했다는점!********/
			return false; 
		} else if(right_child_popped_idx >= this.heapArray.size()) {   //case2 : 오른쪽 자식노드만 없을때
			if(this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
				return true;
			} else {
				return false;
			}
		} else {										//case 3: 왼쪽/오른쪽 자식 노드가 모두 있을때
			if(this.heapArray.get(left_child_popped_idx) > this.heapArray.get(right_child_popped_idx)) {
				if(this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
					return true;
				} else {
					return false;
				}
			} else {
				if(this.heapArray.get(popped_idx) < this.heapArray.get(right_child_popped_idx)) {
					return true;
				} else {
					return false;
				}
			}
		}
		
	}
	
	
	
	
}
