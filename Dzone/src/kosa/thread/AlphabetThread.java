package kosa.thread;

public class AlphabetThread extends Thread {
	public void run() {
	for(char ch = 'A'; ch<='Z'; ch++) {
		System.out.println(ch);	
			try { // IO Exception만큼이나 Thread도 예외를 많이 발생시킴.
				Thread.sleep(500); // NotRunnable 상태로 빠지게 함.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
