package kosa.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortExample02 {

	public static void main(String[] args) {
		List<Person> list = new ArrayList<Person>();
		
		list.add(new Person("홍길동", 20));
		list.add(new Person("박길동", 10));
		list.add(new Person("김길동", 40));
		list.add(new Person("조길동", 60));
		list.add(new Person("곽길동", 30));

		System.out.println(list); // add한 순서대로 출력됨
		
		// 그냥 정렬
		Collections.sort(list); // Person 클래스 안에 Comparable 의 compareTo()를 먼저 오버라이딩 해주어야 함.
		// Person 클래스에 implements Comparable<Person> 하고 오버라이딩 작성해야 함.
		System.out.println(list); // 나이 기준 오름차순으로 출력됨

		// 새로운 정렬 기준 만들기
		Collections.sort(list, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				// 이름을 기준으로 오름차순
				// String: 앞쪽문자열.compareTo(뒷쪽문자열)
				if(o1.getName().compareTo(o2.getName()) > 0) { 
					//△리턴: a value greater than 0 if this string is lexicographically greater than the string argument.
					return 1; // 자리를 변경하라.
				} else if(o1.getName().compareTo(o2.getName()) < 0) {
					//△리턴: a value less than 0 if this string is lexicographically less than the string argument
					return -1; // 그대로 두어라.
				}  // compareTo()가 0을 리턴하는 경우: the value 0 if the argument string is equal to this string
				return 0;
				// return o1.getName().compareTo(o2.getName()); // 그냥 이렇게 해도 (리턴 값이 똑같기 때문에) 무방함
			} // 람다식, 참조형식으로 변환 가능..(chatGPT이용)
		});
		System.out.println(list); // 나이 기준 오름차순으로 출력됨
		
	}

}
