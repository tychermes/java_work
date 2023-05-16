package kosa.data;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapExample {

	public static void main(String[] args) {
		// Map 인터페이스 : (key, value), (key, value), ... => HashMap 클래스, TreeMap 클래스
		Map<String, String> map = new HashMap<String, String>(); // HashMap은 순서 보장X
		map.put("1", "SSG");
		map.put("2", "키움");
		map.put("3", "LG");
		
		System.out.println("요소의 사이즈: "+map.size());

		if(map.containsValue("SSG")) {
			map.remove("1"); // 반드시 key값으로 제거
		}

		System.out.println("요소의 사이즈: "+map.size());
		
		// Map 전체 목록 출력(key, value) : 키 값 없이 그냥 전체를 출력한다면?
		System.out.println(map.get("2"));	// 키 값을 다 알아야만 데이터를 뽑을 수 있음
		// Map에서는 바로 Iterator로 데이터를 뽑아낼 수 없음
		// Map -> Set을 거쳐서 -> Iterator 로 가야 함.★
		// Set에 key값만 보내려면  => keySet() 메소드
		// Set에 value => values() 메소드 : Collection 데이터타입이 됨.(?)
		// Set에 (key, value) 전부 보내려면 => entrySet() 메소드
		
		Set set = map.entrySet();	// 키 밸류 값을 Set에 넘겨줌
		Iterator iterator = set.iterator(); // Set의 Iterator를 가져옴. (여기선 그냥 제네릭 생략했음. 명시해도 됨.)
		while(iterator.hasNext()) {
			Map.Entry<String, String> e = (Map.Entry<String, String>) iterator.next();
			// 엔트리는 내부클래스~~ TODO
			System.out.println("key: "+e.getKey()+", value: "+e.getValue());
		} System.out.println();
		
		// LinkedHashMap도 => Set 전달 => Iterator 해보기..
		Map<String, String> linkedHashMap = new LinkedHashMap<String, String>();
		linkedHashMap.put("1", "스벅");
		linkedHashMap.put("2", "투썸");
		linkedHashMap.put("3", "폴바셋");
		Set set2 = linkedHashMap.entrySet();
		Iterator iterator2 = set2.iterator();
		while(iterator2.hasNext()) {
			Map.Entry<String, String> e = (Map.Entry<String, String>) iterator2.next();
			System.out.println("key: "+e.getKey()+", value: "+e.getValue());
		} System.out.println();
		
		// TreeMap도 => Set 전달 => Iterator 해보기..
		Map<String, String> treeMap = new TreeMap<String, String>();
		treeMap.put("1", "마우스");
		treeMap.put("2", "키보드");
		map.put("3", "프린터");
		Set set3 = treeMap.entrySet();
		Iterator iterator3 = set3.iterator();
		while(iterator3.hasNext()) {
			Map.Entry<String, String> e = (Map.Entry<String, String>) iterator3.next();
			System.out.println("key: "+e.getKey()+", value: "+e.getValue());
		} System.out.println();
	}

}
