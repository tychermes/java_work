package kosa.basic;

public class IfExample {

	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "abc";	
		// 스트링이 위와 같이 생성되었을 때는 스트링 풀에서 같은 문자열이 있는 지 먼저 확인하고 
		// 있으면 같은 주소를 참조항. 실제적으로 하나만 생성된 것임.
		String str3 = new String("abc");
		// 항상 새로운 주소에 문자열을 만듦.
		
		if (str1 == str2) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");			
		}
		
		if (str1 == str3) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");			
		}
		// String 끼리의 == 비교는 문자열 끼리 비교가 아니라 주소값의 비교이다.
		// String 문자열의 내용을 비교하려면, 스트링 객체의 equals() 메소드 사용. 
		if (str1.equals(str3)) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");			
		}
	}

}
