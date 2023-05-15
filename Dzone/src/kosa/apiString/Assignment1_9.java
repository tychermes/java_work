package kosa.apiString;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Assignment1_9 {
	
	public static int solution(String str) {
		String answer = "";
		
		for(char x: str.toCharArray()){
//			if(Character.isDigit(x)) answer += x; //<-이래서 API를 찾아봐야해...
			if(x>= 48 && x<=57) answer += x;
		}
		return Integer.parseInt(answer);
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str;
		
		
//		do {
			System.out.print("하나의 문자열을 입력하세요 (단, 문자열은 영어 알파벳과 숫자로만 구성되고, 길이<100): ");
			str = sc.nextLine().trim();
//			if(str.length()>100) {
//				System.out.println("문자열의 길이가 100자를 넘습니다.");
//				continue;
//			}
			
			System.out.println(solution(str));

//			int maxIndex=0;
//			String[] strArray = str.split(" ");
//			for(int i=0; i<str.length(); i++) {
//				if(!(Pattern.matches("^[a-zA-Z]*$", str) || Pattern.matches("^[0-9]*$", str))) {
//					if(strArray[i].length() > maxIndex) {
//						maxIndex = strArray[i].length();
//					}
//				} else {
//					System.out.println("알파벳이 아닌 문자가 포함되어 있습니다.");
//				}
//			}
//			System.out.println(maxIndex);	// TODO: 하다가 말았음....
			
//		} while(true);
	}


}
