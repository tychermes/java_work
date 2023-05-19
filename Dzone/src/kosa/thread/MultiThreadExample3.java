package kosa.thread;

public class MultiThreadExample3 {

	public static void main(String[] args) {
		Thread thread = new Thread(new SmallLetters());
		thread.start();
		char[] chArray = {'ㄱ', 'ㄴ', 'ㄷ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅅ'};

		for(char ch: chArray) {
			System.out.println(ch);
			try { // IO Exception만큼이나 Thread도 예외를 많이 발생시킴.
				Thread.sleep(500); // NotRunnable 상태로 빠지게 함.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
