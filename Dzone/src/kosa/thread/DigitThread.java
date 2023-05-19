package kosa.thread;

// 숫자를 출력하는 스레드 클래스
public class DigitThread extends Thread {

	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println(i);
			try { // IO Exception만큼이나 Thread도 예외를 많이 발생시킴.
				Thread.sleep(1000); // NotRunnable 상태로 빠지게 함.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
