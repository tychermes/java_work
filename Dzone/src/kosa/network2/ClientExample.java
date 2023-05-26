package kosa.network2;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientExample {

	public static void main(String[] args) {
		Socket socket = null;
		
		try {
			 // 포트번호 9000은 서버 프로그램에서 정했음.
//			socket = new Socket("127.0.0.1", 9000); // "127.0.0.1"은 로컬호스트ip
			socket = new Socket("192.168.0.95", 9000); // 내 ip.
			
//			InputStream in = socket.getInputStream();
//			OutputStream os = socket.getOutputStream();
//			
//			// 서버 프로그램에는 먼저 받고 쓰는 식의 코드를 작성했음. 그러면 클라이언트는 먼저 쓰고 받아야 함.
////			String msg = "Hello Server!!";
//			String msg = "이 편지는 영국에서 최초로 시작되어 일년에 한바퀴를 돌면서 받는 사람에게 행운을 주었고 지금은 당신에게로 옮겨진 이 편지는 4일 안에 당신 곁을 떠나야 합니다. 이 편지를 포함해서 7통을 행운이 필요한 사람에게 보내 주셔야 합니다. 복사를 해도 좋습니다. 혹 미신이라 하실지 모르지만 사실입니다. 영국에서 HGXWCH이라는 사람은 1930년에 이 편지를 받았습니다. 그는 비서에게 복사해서 보내라고 했습니다. 며칠 뒤에 복권이 당첨되어 20억을 받았습니다. 어떤 이는 이 편지를 받았으나 96시간 이내 자신의 손에서 떠나야 한다는 사실을 잊었습니다. 그는 곧 사직되었습니다. 나중에야 이 사실을 알고 7통의 편지를 보냈는데 다시 좋은 직장을 얻었습니다. 미국의 케네디 대통령은 이 편지를 받았지만 그냥 버렸습니다. 결국 9일 후 그는 암살당했습니다. 기억해 주세요. 이 편지를 보내면 7년의 행운이 있을 것이고 그렇지 않으면 3년의 불행이 있을 것입니다. 그리고 이 편지를 버리거나 낙서를 해서는 절대로 안됩니다. 7통입니다. 이 편지를 받은 사람은 행운이 깃들것입니다. 힘들겠지만 좋은게 좋다고 생각하세요. 7년의 행운을 빌면서...";
//			os.write(msg.getBytes()); // msg.getBytes(msg)로 실수했었음.
//			
//			byte[] byteArray = new byte[100];
//			in.read(byteArray);
//			
//			System.out.println("서버가 보낸 메시지: "+new String(byteArray));
			
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
