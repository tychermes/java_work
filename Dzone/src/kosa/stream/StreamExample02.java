package kosa.stream;

import java.util.stream.IntStream;


public class StreamExample02 {
	public static int sum = 0; // 왜 퍼블릭 스태틱으로 선언했지? 보윤이 말로는 스트림이라서 (잘 기억은 안남) 라는데...
	public static void main(String[] args) {
		IntStream stream = IntStream.rangeClosed(1, 100); // 1~100까지 (끝수까지 포함)
//		IntStream stream2 = IntStream.range(1, 101); // 1~100까지 (끝수 미포함)
		
		stream.forEach(a -> sum += a); // a라는 변수는 위에서 선언을 안해도 자연히 변수(람다식)선언부인 거라...
		System.out.println("총합: "+sum);

	}

}
