package kosa.thread.syncronization;

public class SharedArea {
	Account account1; // 이몽룡 계좌
	Account account2; // 성춘향 계좌

//	void transfer(int amount) { // 계좌 이체
//		synchronized (this) {
////			try {
//				account1.withdraw(1000000);
//				System.out.print("이몽룡 계좌: 100만원 인출, ");
//				account2.deposit(1000000);
//				System.out.println("성춘향 계좌: 100만원 입금.");
////			} catch (Exception e) {
////				e.printStackTrace();
////			}
//		}
//	}
//	
//	int getTotal() { // 잔액 합계
//		synchronized (this) {
//			return account1.getBalance() + account2.getBalance();
//		}
//	}

}
