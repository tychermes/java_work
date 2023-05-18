package kosa.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import kosa.video.Video;

public class Main {

	Member m;

	// 객체 직렬화 메소드
	public void write() {
		m = new Member("홍길동", new Video(1, "title", "actor"));
		ObjectOutputStream oos = null;
		try {							// 파일명은 .txt로 해도, 아니면 뭐가 돼도 상관 없음
			oos = new ObjectOutputStream(new FileOutputStream("Object.ser"));
			oos.writeObject(m); // 멤버 객체가 파일로 전달됨.
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 객체 역직렬화 메소드
	public void read() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("Object.ser"));
			m = (Member)ois.readObject(); // Member 객체로 캐스팅 필요
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {

		Main sm = new Main(); // 메소드가 static이 아니므로 호출을 위해 Main 객체를 하나 생성하자.
		
		sm.write();	// 직렬화. 멤버 객체가 생성되고, 파일 안으로 직렬화 된다.

		sm.m = null; // 메모리 상에 있는 멤버 객체에 null 대입으로 kill 함.
		// 아래에서 파일을 read할 건데, 그 결과가 현재 메모리에 있는 Member객체인지, 
		// 아니면 파일 안에 있는 Member객체를 역직렬화 해서 가져 온 건지 모호하므로/

		sm.read(); // 역직렬화.
		
		System.out.println(sm.m);
		
	}

}
