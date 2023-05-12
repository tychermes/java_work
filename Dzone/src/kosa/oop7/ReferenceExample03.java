package kosa.oop7;

@FunctionalInterface // 컴파일러에게 함수형 인터페이스임을 알리는 annotation
interface Interface__ {
	int abstractMethod(String str);
}

public class ReferenceExample03 {

	public static void main(String[] args) {
		
		// 1.(함수형 인터페이스의 추상 메서드를) 익명 클래스로 구현
		Interface__ interface1 = new Interface__() {
			
			@Override
			public int abstractMethod(String str) {
				// 자바 API 메소드를 이용
				return str.length();
			}
		};
		System.out.println(interface1.abstractMethod("안녕하세요"));

		// 2.(함수형 인터페이스의 추상 메서드를) 람다식으로 구현
		Interface__ interface2_1 = (String str) -> { return str.length(); };
		Interface__ interface2_2 = str -> str.length(); //더 간결하게(interface에 이미 타입이 정의되므로.)
		System.out.println(interface2_1.abstractMethod("안녕하세요"));
		System.out.println(interface2_2.abstractMethod("안녕하세요"));
		
		// 3.(함수형 인터페이스의 추상 메서드를) 참조형으로 구현 (람다 축약)
		Interface__ interface3 = String::length; // length()아님 주의.
		System.out.println(interface3.abstractMethod("안녕하세요"));
		
	}

}
