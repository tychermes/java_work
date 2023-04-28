package kosa.basic;

import java.util.Scanner;

public class VariableExample02 {
	// 타입 캐스팅 '암묵적' vs '명시적(강제적)'
	public static void main(String[] args) {

		// int <==> char (char를 int와 연산하면 더 큰 표현 범위를 가진 int형으로 암묵적 변환됨)
		int i;
		// A~Z까지 출력하는 코드
		for (i = 65; i < 91; i++) {
			System.out.print((char)i+", ");
		}
		System.out.println();
		
		// 위와 같이 A~Z까지 출력하는 코드
		char c = 'A';	// 대문자 A가 아스키 65부터 시작한다는 정보를 모를 경우에 이렇게.
		for (i = 0; i < 26; i++) {
			System.out.print((char)(c+i)+", ");	// char를 int와 연산하면 int형으로 암묵적 변환되므로 다시 char로 강제적 형변환 해줌.
		}
		System.out.println();
		
		// int <==> String (int를 String과 연산하면 더 큰 범위를 가진 String형으로 암묵적 변환됨)
		String strNum = "1000";
		int intNum = Integer.parseInt(strNum);	// String과의 타입 변환에는 Integer API 사용
		System.out.println(intNum);
		int result = intNum + 100;
		
//		String strNum2 = "안녕!";
//		int intNum2 = Integer.parseInt(strNum2); // 숫자형식 아닌 쌩 문자열을 파싱하면 런타임 numberFormat Exeption 발생
		
		// int ==> String 방법1
		int intNum3 = 300;
//		String strNum = intNum3;	// 정수를 문자열에 그냥 대입하면 에러 발생
		String strNum3 = String.valueOf(intNum3); // 문자형이니까 냅다 String 클래스 쓰고 ctrl+스페이스바 눌러서 메소드 찾자.
		System.out.println(strNum3);
		
		// int ==> String 방법2
		int intNum4 = 400;
		String strNum4 = String.valueOf(intNum4); // 정수를  문자열로 바꾸는 방법1
		String strNum5 = intNum4 + "";	// 정수를 문자열로 바꾸는 방법2
		System.out.println(strNum4 + ", " +strNum5);
		
		String str = 7 + "7" + 7;
		System.out.println(str);
		
		// 형변환 예제 만들기
		// String ==> int
		int numInt01;
		String numStr01;
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 문자열을 입력해 주세요: ");
		numStr01 = 	sc.nextLine();
		numInt01 = Integer.parseInt(numStr01);
		System.out.printf("입력받은 문자열은 %s은(는) 정수형 %d로 변환되었습니다.\n", numStr01, numInt01);
		System.out.printf("(변환된 정수형 %d에 100을 더하면 = %d)\n", numInt01, numInt01+100); // 입력값이 80 이면 출력값은 180 이 됨. 
		
		// String ==> int
		int numInt02;
		String numStr02;
		System.out.println("정수형 숫자를 입력해 주세요: ");
		numInt02 = 	sc.nextInt();
		sc.nextLine();
		numStr02 = String.valueOf(numInt02);
		System.out.printf("입력받은 정수 %d은(는) 문자열 %s로 변환되었습니다.\n", numInt02, numStr02);
		System.out.printf("(변환된 문자열 %s에 100을 더하면  %s)\n", numStr02, numStr02+100); // 입력값이 80 이면 출력값은 80100 이 됨. 

		sc.close();	// 스캐너 닫기
	}
}
