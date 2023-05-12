package kosa.oop7;

@FunctionalInterface //컴파일러에게 함수형 인터페이스임을 알리는 annotation
interface Interface___ {
	Class___ abstractMethod(); // B객체를 리턴하는 추상메서드
}

class Class___ {
	// ▽ 인터페이스에 오버라이딩 할 abstractMethod메소드 안에서 사용되어져야 할 메소드.
	public Class___() {
		System.out.println("Class___의 생성자 호출");
	}
}

public class ReferenceExample04 {

	public static void main(String[] args) {
		
		// 1.(함수형 인터페이스의 추상 메서드를) 익명 클래스로 구현
		Interface___ interface1 = new Interface___() {
			
			@Override
			public Class___ abstractMethod() {
				return new Class___();
			}
		};
		interface1.abstractMethod();
		
		
		// 2. (함수형 인터페이스의 추상 메서드를) 람다식으로 구현
		Interface___ interface2_1 = () -> {
			return new Class___();
		};
		Interface___ interface2_2 = () ->  new Class___(); //더 간결하게
		interface2_1.abstractMethod();
		interface2_2.abstractMethod();
		
		
		// 3.(함수형 인터페이스의 추상 메서드를) 생성자 참조형으로 구현 (람다 축약)
		Interface___ interface3 = Class___::new;
		interface3.abstractMethod();
		// 모든 경우가 아니라, 해당 객체만 리턴하는 것이라면 참조형으로 쓰는 것이 조금 더 편리하다.
		
	}

}
