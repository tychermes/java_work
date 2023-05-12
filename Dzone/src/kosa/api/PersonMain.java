package kosa.api;

public class PersonMain {

	public static void main(String[] args) {

		Person p1 = new Person("홍길동", 20);
		Person p2 = new Person("홍길동", 20);
		
		// Object 클래스의 equals 메소드 Return 값: 
		// true if this object is the same as the obj argument; false otherwise.
		// obj - the ★reference★ object with which to compare.
		if(p1.equals(p2)) { // Object안에 equals()메소드가 있다.
			System.out.println("같다.");
		} else {
			System.out.println("다르다.");
		}	// 내가 재정의 하지 않았다면 "다르다"가 출력됨. 여기서는 재정의 했으므로 "같다" 출력.

		// 내가 재정의한 Person 클래스의 equals 메소드 Return 값: 
		// true if the given object's name field represents a String 
		// equivalent to this string of name field.
		// && the given object's age field represents int
		// equivalent to this int of name field.
		// --- false otherwise.
		
		
		String s1 = "abc";
		String s2 = new String("abc");

		// String 클래스의 equals 메소드 Return 값: 
		// true if the given object represents a String equivalent to this string, 
		// --- false otherwise.
		if(s1.equals(s2)) {
			System.out.println("같다.");
		} else {
			System.out.println("다르다.");
		} 
		System.out.println(s1);	// System.out.println은 인자 객체의 toString메소드 자동 호출.
		// String 타입 객체의  toString 메소드는 Returns: the string itself.
		
		System.out.println(p1);
		// 원래 Object 타입 객체의 toString 메소드 Returns: a string representation of the object.
		// 스트링 내용: getClass().getName() + '@' + Integer.toHexString(hashCode())
		// 내가 재정의 해줬기 때문에: "Person [name=" + name + ", age=" + age + "]" 반환.
			
		// 만약 대입 연산자를 이용해서 변수로 복사하면 주소값까지 복사해서, 하나의 객체 내용을 바꾸면 다른 것도 같이 바뀌어버림.
		// Object의 clone()메소드 - 다른 주소값으로 새로 객체를 생성해서 복제함. => 한 객체 안의 내용을 바꿔도 다른 객체가 바뀌지 않음.
	
	
		// ▽ 박싱 언박싱 수동으로 하는 방법. 그런데 잘 안씀. 자동 박싱, 언박싱 되기 때문에.
		Byte byteWrapper = new Byte((byte) 10);
		byte bytePrimitive = byteWrapper.byteValue();
		
		
		// ★ NumberFormatException 발생하는 코드(정수 형태가 아닌 실수/문자/문자열을 parsing 시도할 때)
//		int intPrimitive = Integer.parseInt("q"); 

		// TODO: 교안 예제 12-4, 12-5 등... 정리 할 게 많다 ㅠㅠ
		
		// 자동(묵시적) 박싱&언박싱 예제 만들기!=======================================
		int intData = 512;
		
	    // 묵시적인 박싱
	    Integer integerData1 = intData; // = new Integer(intData); 가 아닌, 그냥 = 대입연산으로 박싱 가능 (묵시적,자동)
	    System.out.println(integerData1);	    
	    // 묵시적인 언박싱
	    int sum1 = integerData1 + 100;
	    System.out.println(sum1);
	    
	    
	    // 명시적인 박싱
	    Integer integerData2 = (Integer)intData; // 이것도 완전 객체생성은 아니고, 명시적 캐스팅
	    System.out.println(integerData2);	    
	    // 명시적인 언박싱
	    int sum2 = (int)integerData2 + 100;
	    System.out.println(sum2);
		
	}

}
