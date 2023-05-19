package kosa.thread.syncronization;

class PrintThread extends Thread {
	SharedArea sharedArea;

	PrintThread(SharedArea area) {
		sharedArea = area;
	}

	public void run() {
		for (int cnt = 0; cnt < 3; cnt++) {

			// 스레드의 동기화
			synchronized (sharedArea) {

				// 동기화블록
				int sum = sharedArea.account1.balance + sharedArea.account2.balance;
				System.out.println("계좌 잔액 합계 : " + sum);
			}
			try {

				// 스레드가 경과되는 시간
				Thread.sleep(1);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}