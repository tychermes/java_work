package kosa.io;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterExampleT {

	public static void main(String[] args) {
		// 키보드로부터 문자열을 입력 받아 파일에 쓰기.
		// 조건: 더이상 파일에 쓰고싶지 않다면 "q"를 입력. q 전까지의 문자열을 파일에 쓰기.
		// FileWriter : write(문자열)
		// 파일명: poem2.txt // new FileWriter 할 때 자동으로 생성되므로 미리 생성해놓을 필요X
		// 파일 생성 유무를 체크: 리프래쉬를 해야 함.(프로젝트명 우클릭- refresh)
		// 스트림 close() 까지.

		Scanner sc = new Scanner(System.in);
		String str = "";	// null 이라고 초기화 했더니.. 정말로 txt안에 null이라는 문자열이 들어가있음; 참나
		String poem = "";
		FileWriter writer = null;
		
		while(!(str=sc.nextLine()).equals("q")) {
			poem += str;
			poem += "\n";
		}
		
		try {
			writer = new FileWriter("poem2.txt");
			writer.write(poem);
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
