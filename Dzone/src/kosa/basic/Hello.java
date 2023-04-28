package kosa.basic;

// 클래스: 첫문자가 대문자, 합성어: 다음단어 첫문자도 대문자. HelloWorld
// 메소드: 첫문자가 소문자, 합성어: 다음단어 첫문자만 대문자. setName
// 변수명: 기본은 소문자, 합성어: str_msg 와 같이 단어 사이에 언더바 사용. 상수변수: 모두 대문자
public class Hello {	

	/* 함수 정의 */
	public static void printMessage(String msg) {
		System.out.println(msg);
	}
	
	public static void main(String[] args) {
		System.out.println("Hello!!");

		String msg = "안녕!!"; 	// 변수 선언 및 초기화
		printMessage(msg);	// 함수 호출
	}
}