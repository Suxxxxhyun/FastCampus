package HashTable;

public class MyHashLinearProbing {
	public Slot[] hashTable; // 해쉬테이블은, slot이 모여진 구조이고, 그 해쉬테이블은 일반적으로 
	//배열로 저장하기 때문에 Slot[] 으로 코드작성.

	public MyHashLinearProbing(Integer size) {
		this.hashTable = new Slot[size];
	}

	public class Slot{
		String key;	//해당 슬롯이 내 키에 해당하는 값을 확인할 필요가 있음.
		String value; //복잡도를 낮추기 위해 string으로 선언.
		Slot(String key, String value) {
			this.key = key;
			this.value = value;
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
		if(this.hashTable[address] != null) { //이미 슬롯이 있다면
			if(this.hashTable[address].key == key) { //내가 저장하려는 키와 같다면
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
							return false; //배열의 사이즈를 넘어버리게 됨. // 저장실패
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
	} //첫번째 if문에서 해당 슬롯이 비었는지 비어있지않은지 유무를 확인 --> 비어있다면 40줄 slot생성
	  //그리고 두번째 if문에서, 내가 저장하려는 키값과 같은지 확인 --> 키값이 같다면, 데이터만 업데이트
	  //내가 찾으려는 키값과 같지않아? 리니어프로빙기법에 의해서 32번째 줄로 감.
	

	//데이터를 가져오는(출력하는 메서드)
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
	
	//LinearProbing기법 --> 기존 slot클래스, saveData메서드, getData메서드 부분이 수정되어야함
}
