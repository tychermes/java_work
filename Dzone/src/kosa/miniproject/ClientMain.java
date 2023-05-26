package kosa.miniproject;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientMain {
	
//	public static List<DBMember> realMemberList = new ArrayList<DBMember>();
	static Manager manager = new Manager();
	public static List<Employee> empList = new ArrayList<Employee>();
	public static Employee me;
	
	public static Scanner sc = new Scanner(System.in);
	
	private Socket socket = new Socket();
	private boolean socketFlag = false;
	
	public static void main(String[] args) {
		ClientMain client = new ClientMain();
		client.updateEmpList();
		
		Menu menu = new Menu();
		menu.listMemberMenu(client);
		menu.listGroupwareMenu(client);
	}

	public ClientMain() { }

	public void updateEmpList() {
		Scanner scanner = new Scanner(System.in);
		InetSocketAddress sockAddr = new InetSocketAddress("127.0.0.1", 9000);
		
		try {
			if(!socket.isConnected()) {
				socket.connect(sockAddr);				
			}
			InetAddress inetAddr;
			if ((inetAddr = socket.getInetAddress()) != null) {
				System.out.println("연결: " + inetAddr);
			} else {
				System.out.println("연결되지 않았습니다.");
			}
			do {
				// send
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				oos.writeObject(empList);
				oos.flush();
				// recv
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				empList = (ArrayList<Employee>) ois.readObject();
				System.out.println("Server로 부터 전송된 Object: " + empList.toString());
				
			} while(socketFlag);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
}
