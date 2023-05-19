package kosa.thread;

public class MultiThreadExample1 {

	public static void main(String[] args) {
		Thread thread = new DigitThread();
		thread.start();
		for(char ch = 'A'; ch<='Z'; ch++) {
			System.out.println(ch);	
//			if(ch=='N') {
				try { // IO Exception만큼이나 Thread도 예외를 많이 발생시킴.
					Thread.sleep(1000); // NotRunnable 상태로 빠지게 함.
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
//			}
		}
		// 매 실행마다 결과는 같을 수도 있지만 조금씩 달라질 수도 있음!!
	}

}
