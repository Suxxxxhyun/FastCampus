package BackTracking;

import java.util.ArrayList;

public class NQueenTest {

	public static void main(String[] args) {
		
		NQueen nObject = new NQueen();
		//4x4개에서 퀸4개를 배치, 맨위에서 부터 체크해야하기 때문에 행의 인덱스 번호 - 0, 선택된 해가 없으니까 걍 new ArrayList로 넘겨줌.
		nObject.dfsFunc(4, 0, new ArrayList<Integer>());

	}

}
