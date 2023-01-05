package BackTracking;

import java.util.ArrayList;

public class NQueen {
	
	//N : ���� ����, currentRow : ���� üũ������� ���� ����, currentCandidate : ���ݱ��� ���õ� ��(���ݱ��� ���õ� ���� ��ġ)
	public void dfsFunc(Integer N, Integer currentRow, ArrayList<Integer> currentCandidate) {
		//�迭�� 0���� �����ϴϱ�, N�� currentRow(���� ��)�� �����ϴٴ� ���� �� ���Ҵٴ� �ǹ���.
		if(currentRow == N) {
			System.out.println(currentCandidate);
			return;
		}
		
		//�࿡ �ִ� ��� ���� Ȯ���غ��� ���� �ݺ��� ���
		for(int index=0; index<N; index++) {
			//true�� ���´ٴ� ���� �� ��ġ�� �����ϴٴ� �ǹ�
			if(this.isAvailable(currentCandidate, index) == true) { //�� �迭, 0
				currentCandidate.add(index);
				//�ٽ� �������� Ȯ���ϱ� ���� ����Լ� ȣ��
				this.dfsFunc(N, currentRow + 1, currentCandidate);
				//���ǿ� ���� �ʴ´ٸ�, currentCandidate�� �������� �ִ� ���� ����(pruning���)
				currentCandidate.remove(currentCandidate.size()-1);
			}
		}
	}
	
	//currentCol - ���� ������ �� �ش� �ε��� ��ȣ
	public boolean isAvailable(ArrayList<Integer> candidate, Integer currentCol) { //�� �迭, 0
		Integer currentRow = candidate.size(); //(0,1), (1,3)���� ���� �����ߴٸ�, �������� 2�� �Ǿ�����ٵ�, 2�� �� candidate�� ũ��� ����.
		for(int index = 0; index<currentRow; index++) {
			//promising���, (candidate.get(index) == currentCol) -> ��������, candidate.get(index)�� y��, index�ش� ���� ���� ��
			if((candidate.get(index) == currentCol) || (Math.abs(candidate.get(index) - currentCol) == currentRow - index)) {
				return false;
			}
		}
		return true;

	}
}
