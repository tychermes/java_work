package kosa.api;

import java.util.Arrays;

public class StringExample {

	public static void main(String[] args) {
		
		// 1.String 클래스 생성 방법의 차이점
		String str = "ABC";	// 스트링 상수 로 생성하면
		String str2 = "ABC"; // 똑같은 문자열 내용이 있다면 그대로 주소를 가지고 옴.
		String str3 = new String("ABC"); // 문자열의 내용이 같다 하더라도 새 메모리로 객체 생성
		// 결론: 스트링 상수로 생성하는 것이 좋음.
		
		if(str == str2) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
		
		
		// 2.String 클래스 특징 => ★불변성 특징★
		str.concat("DEF");	// ABCDEF 나올 것을 의도했더라도,
		// str 자신은 변경할 수 없지만, 새로운 변수를 선언해서 그 리턴형으로서는 문자열이 덧붙여짐.
		System.out.println(str); // 막상 결과는 ABC밖에 출력 안됨.
		String str4 = str.concat("DEF"); 
		System.out.println(str4);
		// concat(), replace()등 리턴 값으로 새 스트링 객체에 저장.

		// 물론, 메소드로는 안되지만, 연산자(+)를 사용하여 변경할 수 있다.
		String sql = "select * from board ";
		int num = 10;
		if(num==10) {
			sql += "where num = 10";
		}
		System.out.println(sql);
		
		// StringBuffer, StringBuilder => ★가변성 특징★
		StringBuffer sb = new StringBuffer("ABC");
		sb.append("DEF");
		System.out.println(sb);
		
		// 해당 문자열의 전체 문자열 내 위치 파악 => indexOf("문자열") => 해당 문자열의 인덱스, 없으면 -1 리턴 
		System.out.println(sql.indexOf("where")); // 20
		System.out.println(sql.indexOf("$"));	// -1
		
		// 문자열 길이
		System.out.println(sql.length()); // 34
		
		// Quiz > charAt(), length() 이용하여 sql 문자열 전체를 출력
		for(int i=0; i<sql.length(); i++) {
			System.out.print(sql.charAt(i));
		}
		System.out.println();
		
		// 문자열 부분추출 : subString(5)=>인덱스5부터 끝까지, subString(5,10)=>인덱스5번에서 9번째까지.
		// sql 변수에서 "board" 문자열만 추출해보자.
		System.out.println(sql.substring(sql.indexOf("board"), sql.indexOf("board")+5));
		System.out.println(sql.substring(sql.indexOf("board"), sql.indexOf(" where")));
		
		// Quiz > . 앞의 내용을 head에 넣고, .뒤의 내용을 pattern에 넣기.
		String fileName = "kosa.jpg";
		String head = "";
		String pattern = "";
		
		// T's:
		head = fileName.substring(0, fileName.indexOf("."));
		pattern = fileName.substring(fileName.indexOf(".")+1);

		// 내 답... 
		// ArrayIndexOutOfBoundsException:오류뜸 =>.이 예약어라서 "\\." 으로 해줬어야 함.
		String[] strArray = fileName.split("\\.");
		head = strArray[0];
		pattern = strArray[1];
		
		System.out.println(head + " : "+ pattern);

		if(fileName.endsWith(".jpg")) {
			System.out.println("이미지 파일");
		}
		
		
		// 안전장치를 활용하여 문자열이 (실직적으로) 동일한지 조사하기
		String id = "kosa";
		String m_id = "Kosa ";	// K가 대문자고 공백이 존재...
		
		if(id.trim().equalsIgnoreCase(m_id.trim())) {
			System.out.println("같다");
		}
		if(id.toLowerCase().trim().equals(m_id.toLowerCase().trim())) {
			System.out.println("같다");
		}
		if(id.toUpperCase().trim().equals(m_id.toUpperCase().trim())) {
			System.out.println("같다");
		}
		
		// 문자열 => String[] 변환
		String fruits = "사과, 포도, 수박, 배";
		String arr[] = fruits.split(",");
		System.out.println(Arrays.toString(arr));
		
		String str5 = "abcdef";
		char charArray[] = str5.toCharArray();
		System.out.println(Arrays.toString(charArray));
		
		String str6 = "abcdef";
		byte[] byteArray = str6.getBytes();
		System.out.println(Arrays.toString(byteArray));
		
		
		int n = 10;
		String s1 = String.valueOf(n);
		String s2 = ""+n;
		String s3 = n+"";
		System.out.println("s1:"+s1.getClass().getName()+"  s2:"+s2.getClass().getName()+"  s3:"+s3.getClass().getName());
	}

}
