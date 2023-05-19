package kosa.thread;

public class SumThread2 extends Thread {
	private int sum = 0;
	
	@Override
	public void run() {
		// 51~100 합을 구하는 스레드
		for(int i=51; i<=100; i++) {
			sum += i;
		}
	}
	
	public int getSum() {
		return sum;
	}
}
