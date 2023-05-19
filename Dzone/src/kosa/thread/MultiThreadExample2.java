package kosa.thread;

public class MultiThreadExample2 {

	public static void main(String[] args) {
		Thread t1 = new DigitThread();
		Thread t2 = new DigitThread();
		Thread t3 = new AlphabetThread();
		
		t1.start();
		t2.start();
		t3.start();

	}

}
