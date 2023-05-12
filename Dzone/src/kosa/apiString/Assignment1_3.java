package kosa.apiString;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Assignment1_3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str;
		
		do {
			System.out.print("하나의 문자열을 입력하세요 (단, 문자열은 영어 알파벳으로만 구성되고, 길이<100): ");
			str = sc.nextLine().trim();
			if(str.length()>100) {
				System.out.println("문자열의 길이가 100자를 넘습니다.");
				continue;
			}

//			// 자꾸 java.lang.ArrayIndexOutOfBoundsException 떠서 그냥 API 이용하겠음...
//			boolean isOnlyAlphabet = true;
//			for(int i=0; i<strArray.length && isOnlyAlphabet; i++) {
//				char[] lowerCharArray = strArray[i].toLowerCase().toCharArray();
//				char lowerChar = lowerCharArray[i];
//				for(int j=0; j<strArray[i].length() && isOnlyAlphabet; j++) {
//					if(lowerChar>='a' && lowerChar<='z') {
//						isOnlyAlphabet = true;
//					} else {
//						isOnlyAlphabet = false;
//						// break;
//					}
//				}
//				if(strArray[i].length() > maxIndex) {
//					maxIndex = i;
//				}
//			}

			int maxIndex=0;
			String[] strArray = str.split(" ");
			for(int i=0; i<str.length(); i++) {
				if(!Pattern.matches("^[a-zA-Z]*$", str)) {
					if(strArray[i].length() > maxIndex) {
						maxIndex = strArray[i].length();
					}
				} else {
					System.out.println("알파벳이 아닌 문자가 포함되어 있습니다.");
				}
			}
//			System.out.println(maxIndex);
			
		} while(true);
	}

}
