package kosa.network3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URLEncoder;

public class ClientSender extends Thread {

	Socket socket;

	public ClientSender() {}

	public ClientSender(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			// 키보드로부터 입력 받기 reader 열어줌
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
			// 출력을 (콘솔에 하는 것처럼) 소켓에 하는 방법
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			while(true) {
				String str = br.readLine();
				if(str.equals("bye")) {
					String str2 = URLEncoder.encode("끝", "utf-8");
					writer.println(str2);
					writer.flush();
					break; // 키보드로 bye 입력받으면 그만.
				}
				String str2 = URLEncoder.encode(str, "utf-8");
				writer.println(str2); // 위 블록의 지역변수와 헷갈리지 말기!
				writer.flush(); // 비움
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
