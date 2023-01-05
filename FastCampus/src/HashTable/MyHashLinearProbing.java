package HashTable;

public class MyHashLinearProbing {
	public Slot[] hashTable; // �ؽ����̺���, slot�� ���� �����̰�, �� �ؽ����̺��� �Ϲ������� 
	//�迭�� �����ϱ� ������ Slot[] ���� �ڵ��ۼ�.

	public MyHashLinearProbing(Integer size) {
		this.hashTable = new Slot[size];
	}

	public class Slot{
		String key;	//�ش� ������ �� Ű�� �ش��ϴ� ���� Ȯ���� �ʿ䰡 ����.
		String value; //���⵵�� ���߱� ���� string���� ����.
		Slot(String key, String value) {
			this.key = key;
			this.value = value;
		}
	}
										//�̸��� ��ȭ��ȣ�� �����ϴ� ���¿��ٸ�,
	public int hashFucn(String key) { //�̶� Ű����ϴ°���, ex) String name = "Dave"; �̋� Dave�� Ű�� ��.
		return (int)(key.charAt(0)) % this.hashTable.length; // �̶� hashTable.length��� �ϴ°��� 
									// MyHash(20)�̶�� �ϸ� 20���� �迭�� ���� hashTable����, �� ����(20)�� ����.
	}

	//�����͸� �����ϴ� �޼��� 
	public boolean saveData(String key, String value) {
		Integer address = this.hashFucn(key);
		if(this.hashTable[address] != null) { //�̹� ������ �ִٸ�
			if(this.hashTable[address].key == key) { //���� �����Ϸ��� Ű�� ���ٸ�
				this.hashTable[address].value = value;
				return true;
			} else {
				Integer currAddress = address + 1;
				while(this.hashTable[currAddress] != null) {
					if(this.hashTable[currAddress].key == key) { 
						this.hashTable[currAddress].value = value;
						return true;
					} else {
						currAddress++;
						if(currAddress >= this.hashTable.length) {
							return false; //�迭�� ����� �Ѿ������ ��. // �������
						}
					}
				}
				this.hashTable[currAddress] = new Slot(key,value);
				return true;
			}
		} else {
			this.hashTable[address] = new Slot(key, value);
		}
		return true;
	} //ù��° if������ �ش� ������ ������� ������������� ������ Ȯ�� --> ����ִٸ� 40�� slot����
	  //�׸��� �ι�° if������, ���� �����Ϸ��� Ű���� ������ Ȯ�� --> Ű���� ���ٸ�, �����͸� ������Ʈ
	  //���� ã������ Ű���� �����ʾ�? ���Ͼ����κ������ ���ؼ� 32��° �ٷ� ��.
	

	//�����͸� ��������(����ϴ� �޼���)
	public String getData(String key) {
		Integer address = this.hashFucn(key);
		if(this.hashTable[address] != null) {
			if(this.hashTable[address].key == key) {
				return this.hashTable[address].value;
			} else {
				Integer currAddress = address + 1;
				while(this.hashTable[currAddress] != null) {
					if(this.hashTable[currAddress].key == key) {
						return this.hashTable[currAddress].value;
					} else {
						currAddress++;
						if(currAddress >= this.hashTable.length) {
							return null;
						}
					}
				}
				return null;
			}
		} else {
			return null;
		}
	}
	
	//LinearProbing��� --> ���� slotŬ����, saveData�޼���, getData�޼��� �κ��� �����Ǿ����
}
