package kosa.oop3;

// 멀티쓰레드로 동작하도록 만들고 싶다면, Thread클래스를 상속받거나, Runnable인터페이스를 구현
public class MyThread implements Runnable {

	// 1~10까지를 증가하는 수를 다른 쓰레드에서 1초마다 출력할 수 있도록.
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			System.out.println(i);
		}
		
	}

	public static void main(String[] args) {
		// 1~10까지를 증가하는 수를 다른 쓰레드에서 1초마다 출력하도록 
		MyThread my = new MyThread();
		Thread t = new Thread(my);
		t.start();	// 쓰레드 실행 시작
		
		// 메인 쓰레드에서 1초마다 11~20을 출력하도록 실행
		for(int i=11; i<=20; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			System.out.println(i);
		}
	}

}
