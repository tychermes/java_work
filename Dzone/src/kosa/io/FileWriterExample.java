package kosa.io;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterExample {

	public static void main(String[] args) {
		// 키보드로부터 문자열을 입력 받아 파일에 쓰기.
		// 조건: 더이상 파일에 쓰고싶지 않다면 "q"를 입력. q 전까지의 문자열을 파일에 쓰기.
		// FileWriter : write(문자열)
		// 파일명: poem2.txt // new FileWriter 할 때 자동으로 생성되므로 미리 생성해놓을 필요X
		// 파일 생성 유무를 체크: 리프래쉬를 해야 함.(프로젝트명 우클릭- refresh)
		// 스트림 close() 까지.

		Scanner sc = new Scanner(System.in);
		String str = null;
		FileWriter writer = null;

		try {
			writer = new FileWriter("poem2.txt");
//			char[] chArr = null;

			do {
				System.out.print("입력: ");
				str = sc.nextLine();
				if (str.equals("q")) return;
//				chArr = str.toCharArray();
//				for(char ch : chArr) {	// 꼭 char로 한글자씩 안해도 됨.
				writer.write(str); // String 문자열은 그냥 write해도 됨.
				// 하긴 read 예제에서도 한 번에 배열의 크기까지 읽어들였으니까...
//				}				
			} while (true);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
