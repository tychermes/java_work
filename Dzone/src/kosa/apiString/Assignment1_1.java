 package kosa.apiString;

import java.util.Scanner;

public class Assignment1_1 {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      
      String str;
      char inputLowerChar;
      int count=0;
      boolean isOnlyAlphabet = true;
      
      do {
         System.out.print("하나의 문자열을 입력하세요 (단, 문자열은 영어 알파벳으로만 구성되고, 길이<100): ");
         str = sc.nextLine().trim();
         if(str.length()>100) {
            System.out.println("문자열의 길이가 100자를 넘습니다.");
            continue;
         }
         
         System.out.print("갯수를 셀 문자를 입력하세요: ");
         String input = sc.nextLine().trim();
         inputLowerChar = input.toLowerCase().charAt(0);
         // inputLowerChar = Character.toLowerCase(input.charAt(0)); // 이 방법도 됨.
         
         char[] charArray = str.toLowerCase().toCharArray();
         for(int i=0; i<str.length() && isOnlyAlphabet; i++) {
            char lowerChar = charArray[i];
            if(lowerChar>='a' && lowerChar<='z') {
               isOnlyAlphabet = true;
               if(lowerChar==inputLowerChar) {
                  count++;
               }
            } else {
               isOnlyAlphabet = false;
               // break; // <- isOnlyAlphabet을 for조건에 넣어줘서 여기 break는 필요없게 됐음.
            }
         }
         if(isOnlyAlphabet) { // 답
            System.out.println(count);            
         } else {
            System.out.println("알파벳이 아닌 문자가 포함되어 있습니다.");
         }
      } while(!isOnlyAlphabet);
   
   }

}