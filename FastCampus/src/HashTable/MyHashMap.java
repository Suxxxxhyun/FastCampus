package HashTable;

import java.util.HashMap;

public class MyHashMap {

	public static void main(String[] args) {
		
		HashMap<Integer,String> map1 = new HashMap();
		map1.put(1, "���");
		map1.put(2, "�ٳ���");
		map1.put(3, "����");
		
		HashMap<String,String> map2 = new HashMap();
		map2.put("DaveLee", "33334444");
		map2.put("Dave", "22221111");
		map2.put("David", "44445555");
		
		System.out.println(map1.get(2));
	}

}
