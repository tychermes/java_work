package kosa.network3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.URLDecoder;

public class ClientReceiver extends Thread {
	
	Socket socket;
	
	public ClientReceiver() { }
	
	public ClientReceiver(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		try { // 소켓으로부터 읽어들임.
			BufferedReader br 
			= new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
				while(true) {
					String str = br.readLine();
					if(str == null) break;
					String str2 = URLDecoder.decode(str, "utf-8");
					System.out.println("클라이언트 수신: "+str2); //이게 str로 했더니 닉네임이 이상하게 나왔던 거 같음...
				}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close(); // 이렇게 해주면~
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
