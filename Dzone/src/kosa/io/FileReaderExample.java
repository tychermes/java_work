package kosa.io;

import java.io.FileReader;
import java.util.Arrays;

public class FileReaderExample {

	public static void main(String[] args) {
		// 파일(poem.txt)에 있는 문자 데이터를 읽어오기
		FileReader reader = null; 
		char arr[] = new char[10]; // 문자 10개를 읽어들이면, 마지막에 10개 찌꺼기가 출력될 경우가 있음.
		// => while문 블록 안쪽 맨 윗줄에 Arrays.fill(arr, ' ');로 해결
		// 선언과 생성을 같이하면 안됨. 스트림을 열 때 try-catch 블록에 들어가버리면 
		// 나중에 finally에서 해당 변수를 close()해 줄 수 없기 때문.
		try { // FileReader 객체 생성과 read()는 예외 발생 가능성이 있어서 강제 예외처리 필요.
			// 스트림 생성
			reader = new FileReader("poem.txt"); // 프로젝트 경로 내에 있기 때문에 디렉토리 구조 더 쓸 필요x
			while(true) {
				Arrays.fill(arr, ' ');
//				// int data = reader.read(); // 1개 문자 읽기. 
				int data = reader.read(arr); // 배열의 크기만큼 문자 읽기. 
				if(data==-1) break;
//				System.out.print((char)data); // 해당 아스키코드 값을 char로 캐스팅 출력. 
				System.out.print(arr); // 해당 아스키코드 값을 char로 캐스팅 출력. 
				// TODO: 한글 입력도 받을 수 있는데, 그럼 유니코드도 자동으로 char로 변환 가능한 건가? char는 1Byte라서 다 가능한가?
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close(); // 심지어 	close()도 예외 발생 가능성이 있어서 강제 예외처리 필요.		
			} catch (Exception e) {
				
			}
		}
	}

}
