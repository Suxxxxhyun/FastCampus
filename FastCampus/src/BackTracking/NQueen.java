package BackTracking;

import java.util.ArrayList;

public class NQueen {
	
	//N : 퀸의 개수, currentRow : 지금 체크애햐야할 행의 개수, currentCandidate : 지금까지 선택된 해(지금까지 선택된 퀸의 위치)
	public void dfsFunc(Integer N, Integer currentRow, ArrayList<Integer> currentCandidate) {
		//배열이 0부터 시작하니까, N이 currentRow(현재 행)와 동일하다는 것은 다 돌았다는 의미임.
		if(currentRow == N) {
			System.out.println(currentCandidate);
			return;
		}
		
		//행에 있는 모든 열을 확인해보기 위해 반복문 사용
		for(int index=0; index<N; index++) {
			//true가 나온다는 것은 그 위치가 적합하다는 의미
			if(this.isAvailable(currentCandidate, index) == true) { //빈 배열, 0
				currentCandidate.add(index);
				//다시 다음줄을 확인하기 위해 재귀함수 호출
				this.dfsFunc(N, currentRow + 1, currentCandidate);
				//조건에 맞지 않는다면, currentCandidate의 마지막에 있는 것을 삭제(pruning기법)
				currentCandidate.remove(currentCandidate.size()-1);
			}
		}
	}
	
	//currentCol - 지금 선택이 된 해당 인덱스 번호
	public boolean isAvailable(ArrayList<Integer> candidate, Integer currentCol) { //빈 배열, 0
		Integer currentRow = candidate.size(); //(0,1), (1,3)으로 퀸을 선택했다면, 다음행은 2가 되어야할텐데, 2가 곧 candidate의 크기와 같음.
		for(int index = 0; index<currentRow; index++) {
			//promising기법, (candidate.get(index) == currentCol) -> 수평조건, candidate.get(index)가 y값, index해당 퀸의 행의 값
			if((candidate.get(index) == currentCol) || (Math.abs(candidate.get(index) - currentCol) == currentRow - index)) {
				return false;
			}
		}
		return true;

	}
}
