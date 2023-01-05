package HashTable;

public class MyHashTest {

	public static void main(String[] args) {
		
		MyHash mainObject = new MyHash(20);
		mainObject.saveData("DaveLee", "01022223333");
		mainObject.saveData("fun-coding", "01033334444");
		mainObject.saveData("David", "01044445555");
		mainObject.saveData("Dave", "01055556666");
		System.out.println(mainObject.getData("DaveLee"));
		
		//충돌이 발생하는 이유, 우리가 애초에 해쉬함수부분을 
		//키에 대한 첫번째 글자를 숫자로 바꿔, 해쉬테이블의 크기만큼 나눈 나머지가 저장되기때문에
		//즉, 같은 글자인 D라면 (키값이 다르지만) 결국 해쉬테이블의 크기만큼 나눈 나머지도 같으니까
		//해쉬함수로 얻어진 그 결과값이 중복됨을 알 수 있음.
		//이것을 충돌이라고 함.
		
		MyHashChaining mainObject2 = new MyHashChaining(20);
		mainObject2.saveData("DaveLee", "01022223333");
		mainObject2.saveData("fun-coding", "01033334444");
		mainObject2.saveData("David", "01044445555");
		mainObject2.saveData("Dave", "01055556666");
		System.out.println(mainObject2.getData("DaveLee"));
		System.out.println(mainObject2.getData("Dave"));
		
		MyHashLinearProbing mainObject3 = new MyHashLinearProbing(20);
		mainObject3.saveData("DaveLee", "01022223333");
		mainObject3.saveData("fun-coding", "01033334444");
		mainObject3.saveData("David", "01044445555");
		mainObject3.saveData("Dave", "01055556666");
		System.out.println(mainObject3.getData("David"));
		
		
	}

}
