package kosa.network3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 하나의 소켓을 쓰레드화 하려고 만든 클래스임...
public class PerClientThread extends Thread {

	Socket socket = null;
	PrintWriter writer = null; // 칠판에 그림에도 소켓 당 하나씩의 writer를 가지고 있음
	static List<PrintWriter> list = Collections.synchronizedList(new ArrayList<PrintWriter>());
	// Critical Section 발생 가능성 => synchronized로 안정적으로 사용할 수 있도록 자바에서 제공함.
	// But static으로 만들지 않으면 나만의 리스트가 되어버림. PerClientThread를 생성하는 족족... 각각의 리스트가 다 생겨버림
 	
	public PerClientThread() {}
	
	public PerClientThread(Socket socket) {
		super();
		this.socket = socket;
		try {
			writer = new PrintWriter(socket.getOutputStream());
			
			list.add(writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void sendAll(String msg) {

		for(PrintWriter writer : list) {
			writer.println(msg);
			writer.flush();
		}
	}

	@Override
	public void run() {
		// 
		String name = "";
		try {
			// BufferedReader를 쓰는 이유가 뭐지?
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			name = br.readLine();
			sendAll("## "+name+"님이 입장하셨습니다. ##");
			while(true) {
				String msg = br.readLine();
				String msg2 = URLDecoder.decode(msg, "utf-8"); // 한글 입력 시, 디코딩을 해야할 까 안해도 될까?
				
				if(msg2.equals("끝")) break;
				
				msg2 = name+": "+msg2;
				sendAll(msg2);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sendAll("## "+name+"님이 퇴장하셨습니다. ##");
			list.remove(writer);
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
