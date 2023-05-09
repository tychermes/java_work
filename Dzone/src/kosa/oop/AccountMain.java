package kosa.oop;

public class AccountMain {
	// 잔액이 부족하면 인위적으로 예외 발생시키기
	public static void main(String[] args) {

		// 객체 생성(생성자 호출) =인스턴스 화
		// account와 account2는 주소값을 담고,'인스턴스 변수' or '객체' 라고 부름
		// 생성자로 멤버 변수들을 초기화
		Account account = new Account("1111-1111", "홍길동", 10000);
		Account account2 = new Account("2222-2222", "아무개", 30000);		
		
		
//		StringBuffer sBuffer = new StringBuffer("안녕", 20);
//		StringBuffer sBuffer = new StringBuffer("안녕");
//		sBuffer.append("나는");
//		sBuffer.append("")
		
//		account.accountNo = "1111-1111";
//		account.ownerName = "홍길동";
//		account.balance = 10000;
//		
//		account2.accountNo = "2222-2222";
//		account2.ownerName = "아무개";
//		account2.balance = 30000;
		
		account.deposit(5000);	// 5000원 입금
		
		
		// withdraw() 메서드에서 throws로 예외를 떠넘겼으므로 여기에서 try-catch로 예외처리
		try {
			account.withdraw(3000);	// 3000원 출금
			System.out.println("출금 완료");
		} catch (Exception e) {
			// TODO: withdraw(int amount) throws Exception 의 예외처리를 이곳에서!
			e.printStackTrace(); // 콘솔 출력값: "잔액이 부족합니다."
			// 콘솔 출력값으로 에러문 전체가 그대로 뜨지만, 프로그램은 종료되지 않는다.
		} finally {
			// 오류가 나든 안나든, 무조건 실행되는 부분
			System.out.println();
		}

		account.print();
		account2.print();
		
//		System.out.println("계좌번호: " + account.getAccountNo());
//		System.out.println("잔액: " + account.getOwnerName());
//		System.out.println("계좌번호: " + account.getBalance());
//		System.out.println();
//		
//		System.out.println("계좌번호: " + account2.getAccountNo());
//		System.out.println("잔액: " + account2.getOwnerName());
//		System.out.println("계좌번호: " + account2.getBalance());
//		System.out.println();

	}

}
