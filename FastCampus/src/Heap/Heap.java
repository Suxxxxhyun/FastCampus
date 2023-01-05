package Heap;

import java.util.ArrayList;
import java.util.Collections;
//�����͸� �迭�� �����ǵ�, �� �����͵��� �������� ������ ���� �ƴϹǷ� arraylist�̿�

public class Heap { //MaxHeap�� ����
	
	public ArrayList<Integer> heapArray = null;
	
	public Heap(Integer data) {
		heapArray = new ArrayList<>();
		
		heapArray.add(null); //�迭 0���� null�� ó���ϱ� ���Ѱ��� -> heap������ 1�� �ε������� �����Ұ���.
		heapArray.add(data);
	}
	
	//insert��, �ٲ������ ���ƾ�����, �� swap���� ���ƾ����� �Ǵ��ϴ� �޼���
	public boolean moveUp(Integer inserted_idx) {
		if(inserted_idx <= 1) {	//��Ʈ���
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
		Integer inserted_idx, parent_idx; //inserted_idx : �������� �ε�����ȣ, parent_idx : �θ����� �ε��� ��ȣ
		
		if(heapArray == null) { //�����͸� �� ������ null�� �� �� �ִ� ��� --> �̶��� �ε�����ȣ�� ������ʿ���� �������Ѱ� �������.
			heapArray = new ArrayList<>();
			
			heapArray.add(null);
			heapArray.add(data);
			
			return true;
		} 
		
		this.heapArray.add(data);
		inserted_idx = this.heapArray.size() - 1; //4���� �����Ͱ� �ִٸ� ���� 0��, 1��, 2��, 3�� -> �� �������� �ε�����ȣ�� ��ü�����Ͱ����� 1�� ���ذͰ� ����.
		
		while(this.moveUp(inserted_idx)) {
			parent_idx = inserted_idx / 2;
			Collections.swap(this.heapArray, inserted_idx , parent_idx);
			inserted_idx = parent_idx;
		}
		
		return true;
	}
	
	//�����޼��� - ��Ʈ��带 �����ϴ� �޼��� (Heap����, �߰��� �ִ� ��带 �����ϴ� ���� ����.)
	public Integer pop() {
		Integer returned_data, popped_idx, left_child_popped_idx, right_child_popped_idx;
		
		if(this.heapArray == null) {
			return null;
		} else {
			returned_data = this.heapArray.get(1);
			this.heapArray.set(1, this.heapArray.get(this.heapArray.size() - 1));
			this.heapArray.remove(this.heapArray.size()-1);
			popped_idx = 1; //���� 20�� 8�� �ڸ��ٲ�� 20�� ������ ������ ��Ȳ��!. ���� ����!
			
			while(this.move_down(popped_idx)) {
				left_child_popped_idx = popped_idx * 2;
				right_child_popped_idx = popped_idx * 2 + 1;
				
				//case2 : ������ �ڽĳ�常 ������
				if(right_child_popped_idx >= this.heapArray.size()) {
					if(this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
						Collections.swap(heapArray, popped_idx, left_child_popped_idx);
						popped_idx = left_child_popped_idx;
					}
				} else {										//case 3: ����/������ �ڽ� ��尡 ��� ������
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
	
	//pop�Ҷ�, swap���� ���ƾ����� �Ǵ��ϴ� �޼���
	public boolean move_down(Integer popped_idx) {
		Integer left_child_popped_idx, right_child_popped_idx; //popped_idx�� �����ڽİ� ������ �ڽ�
		
		left_child_popped_idx = popped_idx * 2;
		right_child_popped_idx = popped_idx * 2 + 1;
		
		//case1 : ���� �ڽĳ�嵵 ������ --> �� ���ʳ������ �������� ����. (�ڽ� ��尡 �ϳ��� ������)
		// �� �������� ����? ���ʿ� ��������Ʈ�������� ���ʺ��� �־��ڳ�! �ٵ� ���� ���� �������� �ִٴ°� ���� �ȵ�.
		if(left_child_popped_idx >= this.heapArray.size()) { /*************���Ⱑ ���� �߿� ! ������ �������� size�� left_child_idx�� �̿��ߴٴ���!********/
			return false; 
		} else if(right_child_popped_idx >= this.heapArray.size()) {   //case2 : ������ �ڽĳ�常 ������
			if(this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
				return true;
			} else {
				return false;
			}
		} else {										//case 3: ����/������ �ڽ� ��尡 ��� ������
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
