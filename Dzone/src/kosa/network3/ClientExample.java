package kosa.network3;

import java.net.Socket;

public class ClientExample {

	public static void main(String[] args) {
		Socket socket = null;
		
		try {
			 // 포트번호 9000은 서버 프로그램에서 정했음.
//			socket = new Socket("127.0.0.1", 9000); // "127.0.0.1"은 로컬호스트ip
			socket = new Socket("192.168.0.185", 9000); // 192.168.0.100 보윤(서버)'s ip.

			Thread receiver = new ClientReceiver(socket);
			Thread sender = new ClientSender(socket);

			receiver.start(); // run()메소드를 호출하며 동작
			sender.start();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// socket.close(); // 채팅프로그램에서는 소켓을 닫아주면 프로그램이 끝나버려서 안됨.	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
