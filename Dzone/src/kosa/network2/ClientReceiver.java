package kosa.network2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

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
					System.out.println("클라이언트 수신: "+str);
				}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
