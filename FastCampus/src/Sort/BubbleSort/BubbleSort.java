package Sort.BubbleSort;

import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort {
	
	//���ĵ� ����Ʈ�� �������ִ� sort�޼��� --> �Ķ���ͷ� ������ �ȵ� ����Ʈ�� �ްԵ�.
	public ArrayList<Integer> sort(ArrayList<Integer> dataList){ 
		for(int index = 0; index < dataList.size() - 1; index++) { //���� for�ݺ����� ��ü üũ�� ����ϴ°� 
			//�ѹ��� �ڸ���ȯ�� �ȵǴ� ��츦 Ȯ�����ֱ� ���� boolean swap���� ����
			boolean swap = false;
			
			for(int index2=0; index2 < dataList.size() - 1 - index; index2++) { //�ΰ��� �����ֱ� ���� �ݺ���
				if(dataList.get(index2) > dataList.get(index2 + 1)) {
					Collections.swap(dataList, index2, index2 + 1);
					swap = true;
				}
			}
			
			if(swap == false) {
				break;
			}
		}
		
		return dataList;
	}
}
