package kosa.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMission {

	public static void main(String[] args) {
		// 1~10까지의 값을 List에 담아서 Stream을 이용해서 출력하시오.
		// 스트림 생성 방법 1.
		Integer[] arr = {1,2,3,4,5,6,7,8,9,10};
		List<Integer> numList = Arrays.asList(arr);
		
		Stream<Integer> streamInt = numList.stream();
		streamInt.forEach(num -> System.out.print(num+", "));
		System.out.println();
//		streamInt.forEach(System.out::println);	// 스트림이 빌 때 까지 이미 처리 되었다는 에러가 뜸.
		
		// 스트림 생성 방법 2.
		IntStream intStream = IntStream.rangeClosed(1, 10);
		intStream.forEach(num -> System.out.print(num+", "));
		System.out.println();
		
		// 문자열 배열을 List로 변환 후 Stream을 이용해서 출력하시오.
		String[] strArr = {"산", "들", "바람"};
		List<String> strList = Arrays.asList(strArr);
		Stream<String> streamStr = strList.stream();
		streamStr.forEach(System.out::print);
		System.out.println();
		// 아래와 같은 방법도 가능함.
		Stream<String> stream1 = strList.stream();
		Stream<String> stream2 = Arrays.stream(strArr);
		stream2.sorted().forEach(System.out::print); // 정렬해서 나와서 들바람산 출력
	}

}
