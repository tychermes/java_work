package kosa.thread;

public class SumThread1 extends Thread {
	private int sum = 0;

	@Override
	public void run() {
		// 1~50 합을 구하는 스레드
		for(int i=1; i<=50; i++) {
			sum += i;
		}
	}
	
	public int getSum() {
		return sum;
	}
}
