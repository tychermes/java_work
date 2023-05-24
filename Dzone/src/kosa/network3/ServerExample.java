package kosa.network3;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {

	public static void main(String[] args) {
		
		// 윈도우 공용 방화벽 꺼야만 accept() 연결됨.
		ServerSocket serverSocket = null; // 서버소켓
		Socket socket = null; // 접속한 클라이언트 소켓
		
		try {
			serverSocket = new ServerSocket(9000); // 포트는 그냥 9000번으로.
			System.out.println("서버 실행 중....");
			
			// 클라이언트 1명이 아니라 여러명이므로 계속 기다려야 함.
			while(true) {
				socket = serverSocket.accept(); // 서버가 클라이언트 요청을 대기하다가, 요청이 오면 소켓을 받아들임.
				Thread thread = new PerClientThread(socket);
				thread.start();
				System.out.println("클라이언트 연결 완료");				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 채팅프로그램에서는 소켓을 닫아주면 프로그램이 끝나버려서 안됨.
				//socket.close(); 
				//serverSocket.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
}
