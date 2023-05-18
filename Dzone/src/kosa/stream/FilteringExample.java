package kosa.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FilteringExample {

	public static void main(String[] args) {
		
		// Student 객체에서 score(정수)값만 가지고 사용하도록(출력하도록) 스트림 열기.
		List<Student> sList = new ArrayList<Student>();
		sList.add(new Student("홍길동", 50));
		sList.add(new Student("김길동", 70));
		sList.add(new Student("박길동", 90));
		sList.stream().mapToInt(s->s.getScore()).forEach(score->System.out.println(score));
		System.out.println();
		
		// Student 객체에서 name(문자열)만 가지고 사용하도록(출력하도록) 스트림 열기.
		List<Student> sList2 = new ArrayList<Student>();
		sList2.add(new Student("홍길동", 50));
		sList2.add(new Student("김길동", 70));
		sList2.add(new Student("박길동", 90));
		sList2.stream().map(s->s.getName()).forEach(name->System.out.println(name));
		System.out.println();
		
		// 중복 제거 (객체의 멤버 스트링만 비교 구분) // 이해가 잘 안된다.. 인터넷에서 봐야됨....
		Student[] sArr = {
				new Student("홍길동", 50),
				new Student("홍길동", 70),
				new Student("박길동", 90)
				};
		List<Student> studentList = Arrays.asList(sArr);
		Stream<Student> studentStream1 = studentList.stream();
//		studentStream1.distinct();	//distinct()의 판단 기준: equals()
//		studentStream1.forEach(System.out::println); // 왜 스트림이 이미 처리됐다고 나오지?
		studentStream1.map(s->s.getName()).distinct().forEach(name -> System.out.println(name)); // distinct()도 스트림 처리이므로 꼭 이렇게 해줘야만 함.
		System.out.println();
	
		// 중복 제거 (객체 자체를 비교 구분--------------------------------w)
		Stream<Student> studentStream2 = studentList.stream();
		studentStream2.distinct().forEach(s -> System.out.println(s.getName())); 
		// TODO: Student 클래스에 equals() 이름 비교 기준으로 오버라이딩 했는데 왜 distinct()가 안먹힐까?
		System.out.println("△중복제거 안됐음\n");
		
		// 폰 갤러리에... filter() T's 코드 사진 있는데.. ("홍"으로 시작하는 것만 추출) 이해가 잘 안됨.
		studentList.stream().filter(n -> n.getName().startsWith("홍")).forEach(n -> System.out.println(n.getName()));
	}

}
