package HashTable;

public class MyHashTest {

	public static void main(String[] args) {
		
		MyHash mainObject = new MyHash(20);
		mainObject.saveData("DaveLee", "01022223333");
		mainObject.saveData("fun-coding", "01033334444");
		mainObject.saveData("David", "01044445555");
		mainObject.saveData("Dave", "01055556666");
		System.out.println(mainObject.getData("DaveLee"));
		
		//�浹�� �߻��ϴ� ����, �츮�� ���ʿ� �ؽ��Լ��κ��� 
		//Ű�� ���� ù��° ���ڸ� ���ڷ� �ٲ�, �ؽ����̺��� ũ�⸸ŭ ���� �������� ����Ǳ⶧����
		//��, ���� ������ D��� (Ű���� �ٸ�����) �ᱹ �ؽ����̺��� ũ�⸸ŭ ���� �������� �����ϱ�
		//�ؽ��Լ��� ����� �� ������� �ߺ����� �� �� ����.
		//�̰��� �浹�̶�� ��.
		
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
