package HashTable;

public class MyHashChaining {
	
	public Slot[] hashTable; // 해쉬테이블은, slot이 모여진 구조이고, 그 해쉬테이블은 일반적으로 
	//배열로 저장하기 때문에 Slot[] 으로 코드작성.

	public MyHashChaining(Integer size) {
		this.hashTable = new Slot[size];
	}

	public class Slot{
		String key;
		String value; //복잡도를 낮추기 위해 string으로 선언.
		Slot next; //충돌이 일어날경우, 링크드리스트에 차례대로 데이터를 저장하기때문에 다음 노드를 참조하는 next변수 필요함
		Slot(String key, String value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}
										//이름과 전화번호를 저장하는 상태였다면,
	public int hashFucn(String key) { //이때 키라고하는것은, ex) String name = "Dave"; 이떄 Dave가 키가 됨.
		return (int)(key.charAt(0)) % this.hashTable.length; // 이때 hashTable.length라고 하는것은 
									// MyHash(20)이라고 하면 20개의 배열에 대한 hashTable생성, 그 길이(20)을 말함.
	}

	//데이터를 저장하는 메서드 
	public boolean saveData(String key, String value) {
		Integer address = this.hashFucn(key);
		if(this.hashTable[address] != null) { //이미 해당 슬롯이 있다면
			Slot findSlot = this.hashTable[address]; //링크드리스트의 헤드부분이라고 생각하면됨
			Slot prevSlot = this.hashTable[address]; //링크드리스트의 헤드부분이라고 생각하면됨
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

	//데이터를 가져오는(출력하는 메서드)
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
	
	//chaining기법 --> 기존 slot클래스, saveData메서드, getData메서드 부분이 수정되어야함
	
}
