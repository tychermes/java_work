package kosa.miniproject;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import kosa.network2.ServerReceiver;
import kosa.network2.ServerSender;
import kosa.network4.PerClinetThread;

public class ServerMain {

	public static List<Employee> empList = new ArrayList<Employee>();
	public static int MemberNum = 0;
	private static ServerSocket serSocket;
	public static ServerMain serverMain = new ServerMain();

	public ServerMain() { }

	public static void main(String[] args) {
		serverMain.connect();
	}
	
	public static void connect() {
		try {
			serSocket = new ServerSocket(9000);
			while (true) {
				System.out.println("클라이언트 연결 대기중...");
				Socket socket = serSocket.accept();
				MemberNum++;
				System.out.println("클라이언트 연결 - "+MemberNum+"명");
				new ObjectThread(socket, MemberNum).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
