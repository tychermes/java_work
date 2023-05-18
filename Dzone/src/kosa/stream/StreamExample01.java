package kosa.stream;

import java.util.Arrays;
import java.util.List;

public class StreamExample01 {

	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student("홍길동", 50), 
				new Student("박길동", 70), 
				new Student("김길동", 90)); //Arrays.asList는 배열을 'ArrayList'형으로 변환.

		// 방법1 <- 번거로움
//		Stream<Student> studentStream = list.stream(); // 스트림 생성. 하나의 스트림 안애 연결됨.
//		IntStream scoreStream = studentStream.mapToInt(student -> student.getScore());// student객체가 없었어도△ 이 안에서 만들 수 있나봄
//		double avg = scoreStream.average().getAsDouble();
//		System.out.println("평균점수: "+avg);

		// 방법2
		double avg = list.stream().mapToInt(student -> student.getScore())
				.average()
				.getAsDouble();
		System.out.println("평균점수: " + avg);

	}

}
