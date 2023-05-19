package kosa.thread.syncronization;

class TransferThread extends Thread {
	SharedArea sharedArea;

	TransferThread(SharedArea area) {
		sharedArea = area;
	}

	public void run() {
		for (int cnt = 0; cnt < 12; cnt++) {

			// 스레드의 동기화
			synchronized (sharedArea) {

				// 동기화 블록
				sharedArea.account1.withdraw(1000000);
				System.out.print("이몽룡 계좌 : 100만원 인출, ");
				sharedArea.account2.desposit(1000000);
				System.out.println("성춘향 계좌 : 100만원 입금");
			}
		}
	}
}