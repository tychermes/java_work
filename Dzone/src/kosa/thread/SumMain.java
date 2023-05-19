package kosa.thread;

public class SumMain {

	static int sum1;
	static int sum2;
	
	public static void main(String[] args) {
		// t1 : 1~50 합을 구하는 스레드
		// t2 : 51~100 합을 구하는 스레드
		// main : t1합 + t2합 => 결과: 5050
		
		// 방법0: Thread를 1개만 구현하여 재활용
		SumThread0 t0_1 = new SumThread0(1, 50);
		SumThread0 t0_2 = new SumThread0(51, 100);
		
		t0_1.start();
		t0_2.start();
		
		try {
			t0_1.join(); // join을 호출한 스레드(메인)를 '일시정지'함
			// t0_1 스레드가 끝나면 메인스레드가 다시 '실행 대기 상태'가 됨.
			t0_2.join(); // join을 호출한 스레드(메인)를 일시정지함
			// t0_2 스레드가 끝나면 메인스레드가 다시 '실행 대기 상태'가 됨.
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println("총합: "
				+(t0_1.getTotal() + t0_2.getTotal()));
		
		// 방법1: Thread 2개를 각각 구현
		Thread t1 = new SumThread1();
		Thread t2 = new SumThread2();
		
		t1.start();
		t2.start();
		// 
		try {
			Thread.sleep(500); 
			// 충분히 계산할 수 있도록 시간 여유를 두고 출력해야 중간 계산값이 나오는 문제가 없음
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(((SumThread1)t1).getSum()
				+((SumThread2)t2).getSum());
		
		
		// =============================================
		// 방법2: Runnable을 내부클래스로 구현
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// t3 : 1~50 합을 구하는 스레드
				for(int i=1; i<=50; i++) {
					sum1 += i;
				}
			}
		});
		
		Thread t4 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// t4 : 51~100 합을 구하는 스레드
				for(int i=51; i<=100; i++) {
					sum2 += i;
				}
			}
		});
		
		t3.start();
		t4.start();
		
		try {
			Thread.sleep(500); 
			// 충분히 계산할 수 있도록 시간 여유를 두고 출력해야 중간 계산값이 나오는 문제가 없음
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(sum1+sum2);
	}

}
