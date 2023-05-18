package kosa.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BufferedExample {

	public static void main(String[] args) {
		// Scanner => 입력 스트림
		// System.in(외부 키보드) => InputStream => InputStreamReader => BufferedReader
		InputStream inStream = System.in;
		InputStreamReader isReader = new InputStreamReader(inStream); // 생성자 인자로 InputStream이 들어와야 함
		// InputStreamReader는 주 스트림(InputStream)에 연결한 보조스트림이 됨. 이제 문자는 잘 읽어들임.
		BufferedReader buffreader = new BufferedReader(isReader); // 생성자 인자로 Reader가 들어와야 함
		// InputStreamReader는 보조스트림1(InputStreamReader)에 연결한 보조스트림2가 됨.이제 버퍼로 통으로 읽어들임.
		// △ 그런데 위와 같이 하면 3줄이나 써야하므로 이렇게는 잘 안씀

		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			// 버퍼드 리더 생성할 때 이 한줄로 끝
			br = new BufferedReader(new InputStreamReader(System.in)); // System.in은 '키보드'.
			bw = new BufferedWriter(new FileWriter("output.txt"));
			
			System.out.print("입력: ");
			String str = "";
			while((str = br.readLine())!=null) {
				str += "\n";
				bw.write(str);
			}
			System.out.println("파일에 쓰기 완료.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				bw.close(); // ★특히, 쓰기 시 close()를 안하면 파일이 쓰여지지 않음.★
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
