package BackTracking;

import java.util.ArrayList;

public class NQueenTest {

	public static void main(String[] args) {
		
		NQueen nObject = new NQueen();
		//4x4������ ��4���� ��ġ, �������� ���� üũ�ؾ��ϱ� ������ ���� �ε��� ��ȣ - 0, ���õ� �ذ� �����ϱ� �� new ArrayList�� �Ѱ���.
		nObject.dfsFunc(4, 0, new ArrayList<Integer>());

	}

}
