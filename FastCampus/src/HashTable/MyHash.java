package HashTable;

public class MyHash {
	
	public Slot[] hashTable; // �ؽ����̺���, slot�� ���� �����̰�, �� �ؽ����̺��� �Ϲ������� 
							//�迭�� �����ϱ� ������ Slot[] ���� �ڵ��ۼ�.
	
	public MyHash(Integer size) {
		this.hashTable = new Slot[size];
	}
	
	public class Slot{
		String value; //���⵵�� ���߱� ���� string���� ����.
		Slot(String value) {
			this.value = value;
		}
	} //������ ���Ե��� value�� ������ �� ����.
									//�̸��� ��ȭ��ȣ�� �����ϴ� ���¿��ٸ�,
	public int hashFucn(String key) { //�̶� Ű����ϴ°���, ex) String name = "Dave"; �̋� Dave�� Ű�� ��.
		return (int)(key.charAt(0)) % this.hashTable.length; // �̶� hashTable.length��� �ϴ°��� 
															// MyHash(20)�̶�� �ϸ� 20���� �迭�� ���� hashTable����, �� ����(20)�� ����.
	} //���� Ű�� string�� ����̱⶧����, charAt���� ���� ����
	
	//�����͸� �����ϴ� �޼��� 
	public boolean saveData(String key, String value) {
		Integer address = this.hashFucn(key);
		if(this.hashTable[address] != null) {
			this.hashTable[address].value = value;
		} else {
			this.hashTable[address] = new Slot(value);
		}
		return true;
	}
	
	//�����͸� ��������(����ϴ� �޼���)
	public String getData(String key) {
		Integer address = this.hashFucn(key);
		if(this.hashTable[address] != null) { //�ش� ������ �ִٴ� ��
			return this.hashTable[address].value;
		} else {
			return null;
		}
	}
	
	//chaining��� --> ���� slotŬ����, saveData�޼���, getData�޼��� �κ��� �����Ǿ����
	
}
