package kosa.network;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {

	public static void main(String[] args) {
		
		ServerSocket serverSocket = null; // 서버소켓
		Socket socket = null; // 접속한 클라이언트 소켓
		
		try {
			serverSocket = new ServerSocket(9000); // 포트는 그냥 9000번으로.
			System.out.println("서버 실행 중....");
			socket = serverSocket.accept(); // 서버가 클라이언트 요청을 대기하다가, 요청이 오면 소켓을 받아들임.
			
			// 클라이언트 요청이 들어오면 소켓에 스트림 연결.
			InputStream in = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			byte[] byteArray = new byte[100];
//			in.read(byteArray); // 자꾸만 byteArray를 집어넣는 걸 깜빡함!!! 주의!!!
			System.out.print("클라이언트에서 보낸 메시지: ");
			while(true) {
				if(in.read(byteArray) == -1) {
					break;
				} else {					
					System.out.print(new String(byteArray));
					// String클래스에 byte[]을 (바이트배열) 인자로 넣어서 생성 가능!
				}
			}
			
			String msg = "Hello Client!!";
			os.write(msg.getBytes()); // getBytes()는 Byte[]을 (바이트배열) 반환함.
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
				serverSocket.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
}
