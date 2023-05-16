package kosa.data;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class MapMission {

	private static final String Collection = null;

	public static void main(String[] args) {
		// 이름, 점수를 한 쌍으로 Map 자료구조로 구현하시오. ex)김자바:80, 박자바:90
		// 1. 응시자 이름만 출력
		// 2. 총점, 평균, 최고점수, 최저점수 : Collections => max(), min()

		Map<String, Integer> map = new HashMap<String, Integer>();
		// 정렬된 Map을 원하면 TreeMap을 사용하면 됨.

		map.put("김자바", 80);
		map.put("이자바", 86);
		map.put("박자바", 90);
		map.put("최자바", 75);

		System.out.println("Map 내용: "+map);
		
		// Map -> Set을 거쳐서 -> Iterator 로 가야 함.★
		// Set에 key값만 보내려면  => keySet() 메소드
		// Set에 value => values() 메소드 : Collection 데이터타입이 됨.(?)
		// Set에 (key, value) 전부 보내려면 => entrySet() 메소드
		System.out.println(" ____________________T's solution ____________________");
		// map => key 값만 추출
		Set<String> set = map.keySet();
		System.out.println("응시자 명단: "+set);
		
		// map => value 값만 추출
		Collection<Integer> values = map.values();
		Iterator<Integer> iter = values.iterator();
		
		int total = 0;
		while(iter.hasNext()) {
			total += iter.next();
		}
		System.out.print("총점: "+total+", 평균: "+(total/map.size()));
		System.out.print(", 최고점수: "+Collections.max(values));;
		System.out.println(", 최저점수: "+Collections.min(values));
		
	
		System.out.println(" _______________________내가 찾은 방법 _______________________");
		// entrySet()만 사용 ===================================
		int sum = 0, max = 0, min = 100;
		for (Entry<String, Integer> e : map.entrySet()) {
			System.out.print(e.getKey() + ", ");
			sum += e.getValue();
			// 최댓값, 최솟값 직접 계산
			max = e.getValue() > max ? e.getValue() : max;
			min = e.getValue() < min ? e.getValue() : min;
		} System.out.println();
		System.out.print("총점: " + sum + ", 평균: " + (sum / map.size()));
		System.out.println(", 최고점수: " + max + ", 최저점수: " + min);
		System.out.println();
		
		// entrySet().iterator() ===================================
		Set set2 =  map.entrySet();
		System.out.println("set: "+set2);
		Iterator<Entry<String, Integer>> entries = set2.iterator(); 
		// 제네릭은 Map.Entry로 안해도 되긴 하네.. 어쨌든 그것도 Entry니까..
		while(entries.hasNext()){
		    Map.Entry<String, Integer> entry = entries.next();
		    System.out.println("[Key]:" + entry.getKey() + " [Value]:" +  entry.getValue());
		} System.out.println();
		
		// keySet() 사용 ===================================
		int sum2 = 0;
		for(String key : map.keySet()){
			System.out.println("[Key]:" + key + " [Value]:" + map.get(key));
			sum2 += map.get(key); // value는 get(key)로 구함.
		} 
		System.out.println("총점: "+sum+", 평균: "+(sum/map.size()));
		// 최댓값, 최솟값 Collection API사용
		System.out.print("최대값: "+Collections.max(map.values()));
		System.out.println(", 최솟값: "+Collections.min(map.values()));
		// Collection 쓸 때에 map.keySet()을 인자로 넣으면 김자바가 나오고, map.values()넣으면 90점 나옴.
		System.out.println();
		
		// keySet().iterator() 사용 ===================================
		Iterator<String> keys = map.keySet().iterator();
		while(keys.hasNext()){
		    String key = keys.next();
		    System.out.println("[Key]:" + key + " [Value]:" +  map.get(key));
		} System.out.println();
	}

}
