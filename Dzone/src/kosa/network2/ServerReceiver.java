package kosa.network2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerReceiver extends Thread {

	Socket socket;
	
	public ServerReceiver() {}
	
	
	public ServerReceiver(Socket socket) {
		super();
		this.socket = socket;
	}


	@Override
	public void run() {
		try {
			BufferedReader br 
			= new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
				while(true) {
					String str = br.readLine();
					if(str == null) break;
					System.out.println("서버 수신: "+str);
				}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
}
