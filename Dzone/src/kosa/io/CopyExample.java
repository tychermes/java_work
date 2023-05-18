package kosa.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class CopyExample {

	public static void main(String[] args) {
		// poem2.txt => poem3.txt : 문자 스트림으로 복사를 구현해보자
		FileReader reader = null;
		FileWriter writer = null;
		char arr[] = new char[10];
		String poem2 ="";
		
		try {
			reader = new FileReader("poem2.txt");
			writer = new FileWriter("poem3.txt");
			
			while(true) {
				Arrays.fill(arr, ' ');	// 마지막으로 읽어들이는 char배열에 혹시나 있을 쓰레기 값 제거
				int data = reader.read(arr); // 배열의 크기만큼 문자 읽기. 
				if(data==-1) break;	// 파일이 끝날 때 까지
				poem2 += String.valueOf(arr); // String에 char형 배열을 계속 덧붙이고
//				// writer.write(arr);	// char 배열의 크기만큼 poem3.txt에 계속 쓰기. 교수님도 이 방법.
			}
			System.out.println("문자 복사 완료.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// sample.jpg => sample2.jpg : 바이트 스트림으로 이미지 복사를 구현해보자
		String inputFileName = "sample.jpg";
		String outputFileName = "sample2.jpg";
		InputStream is = null;
		OutputStream os = null;
		byte[] data = new byte[1024];
		int dataLength = 0;
		try {
			is = new FileInputStream(inputFileName);
			os = new FileOutputStream(outputFileName);
			
			while(true) {
				dataLength = is.read(data); // data 배열의 크기만큼 (여기서는 1024)바이트 읽기. 
				if(dataLength==-1) break;	// 파일이 끝날 때 까지
				os.write(data, 0, dataLength);	// 읽어들인 data배열에서 0~1024 전까지 만큼을 sample2로 쓰기(출력)
			}
			System.out.println("이미지 복사 완료.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				os.flush();// 내부 버퍼 잔류 바이트를 출력하고 버퍼를 비움. // TODO: 왜?왜하는데? 
				//검색해보니 OutputStream에서는 아무 일도 수행하지 않는다던데 오히려 inputStream에서 필요한 거 아니야?
				if(os!=null) {
					os.close();
				}
				if(is!=null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
