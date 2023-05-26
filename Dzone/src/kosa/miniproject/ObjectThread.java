package kosa.miniproject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class ObjectThread extends Thread {

	Socket socket;
	int memberNum;

	public ObjectThread(Socket socket, int memberNum) {
		this.socket = socket;
		this.memberNum = memberNum;
	}

	@Override
	public void run() {
		super.run();
		try {
			while (true) {
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				ServerMain.empList  = (List<Employee>)ois.readObject();
				System.out.println("client로 부터 Obj: " + ServerMain.empList.toString());
				
//				// 서버에서 할 일: CSV파일에서 전 사원 리스트 가져오기!
				ServerMain.empList = Employee.initEmployeeList();
				
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				oos.writeObject(ServerMain.empList);
				oos.flush();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close(); // 클라이언트 1명 연결 끊기 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}