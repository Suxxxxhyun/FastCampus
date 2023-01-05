package HashTable;

public class MyHashChaining {
	
	public Slot[] hashTable; // �ؽ����̺���, slot�� ���� �����̰�, �� �ؽ����̺��� �Ϲ������� 
	//�迭�� �����ϱ� ������ Slot[] ���� �ڵ��ۼ�.

	public MyHashChaining(Integer size) {
		this.hashTable = new Slot[size];
	}

	public class Slot{
		String key;
		String value; //���⵵�� ���߱� ���� string���� ����.
		Slot next; //�浹�� �Ͼ���, ��ũ�帮��Ʈ�� ���ʴ�� �����͸� �����ϱ⶧���� ���� ��带 �����ϴ� next���� �ʿ���
		Slot(String key, String value) {
			this.key = key;
			this.value = value;
			this.next = null;
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
		if(this.hashTable[address] != null) { //�̹� �ش� ������ �ִٸ�
			Slot findSlot = this.hashTable[address]; //��ũ�帮��Ʈ�� ���κ��̶�� �����ϸ��
			Slot prevSlot = this.hashTable[address]; //��ũ�帮��Ʈ�� ���κ��̶�� �����ϸ��
			while(findSlot != null) {
				if(findSlot.key == key) {
					findSlot.value = value;
					return true;
				} else {
					prevSlot = findSlot;
					findSlot = findSlot.next;
				}
			}
			prevSlot.next = new Slot(key, value);
		} else {
			this.hashTable[address] = new Slot(key, value);
		}
		return true;
	}

	//�����͸� ��������(����ϴ� �޼���)
	public String getData(String key) {
		Integer address = this.hashFucn(key);
		if(this.hashTable[address] != null) {
			Slot findSlot = this.hashTable[address];
			while(findSlot != null) {
				if(findSlot.key == key) {
					return findSlot.value;
				} else {
					findSlot = findSlot.next;
				}
			}
			return null;
		} else {
			return null;
		}
	}
	
	//chaining��� --> ���� slotŬ����, saveData�޼���, getData�޼��� �κ��� �����Ǿ����
	
}
