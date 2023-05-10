package kosa.oop;

public class Account {
	// 계좌 객체 생성을 위해
	// 상태(=데이터): 계좌번호, 계좌주, 잔액 => 멤버 변수
	// 행동(=기능): 입금하다Deposit, 출금하다Withdraw => 멤버 메서드 
	// (나중에 행동으로서 계좌이체, 잔액확인 등등 추가할 수도 있음)
	
	// public으로 해줘야 다른 클래스에서 getXXX(), setXXX() 메서드 없이 바로 접근 가능.
	private String accountNo; // 계좌번호
	private String ownerName; // 계좌주
	private long balance;	// 잔액


	// 필드(멤버 변수) 바로 밑에는(보통적으로) 생성자 코드를 입력한다.
	// 생성자: [접근제어자] [리턴형X(<-생성자와 메소드의 차이점)] [생성자 이름(=클래스 이름)] () {}
	public Account() {}	// ★★ 디폴트 생성자(파라미터가 없는)는 당연하다고 생각하고 직접 코드로 써주면 좋다. 
	// 왜냐면, 원래는 명시적으로 선언하지 않아도 컴파일러가 디폴트 생성자를 자동으로 만들어주는데,
	// 개발자가 명시적으로 선언한 생성자가 있다면, 컴파일러는 기본 생성자를 추가하지 않는다.
	// 이렇게 디폴트 생성자를 직접 써주지 않는 것이 신입 개발자가 많이 실수하는 부분이다.
	
	// ★오버로딩 => 생성자(or 메서드) 이름이 같고 파라미터를 다르게 작성하는 것.	
	// Source메뉴 -> Generate Constructor Using Fileds... -> 자동 생성!
	public Account(String accountNo, String ownerName, long balance) {
		super();
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	
	// 입금하다 메서드
	public void deposit(int amount) {
		balance += amount;
	}
	

	// 출금하다 메서드
	public int withdraw(int amount) throws Exception {
		if(balance < amount) {
			// 잔액이 부족하면 인위적으로 예외 발생시키기 => 이 함수를 호출하는 곳에서 예외 처리하기
			 //e.getMessage() 출력하면 나오는 스트링 설정.
			throw new Exception("잔액이 부족합니다. 출금이 거절되었습니다.");
		}
		setBalance(balance - amount);
		return amount; // 인출한 금액
	}
	
	public void print() {
		System.out.println("계좌번호: " + accountNo);
		System.out.println("이름: " + ownerName);
		System.out.println("잔액: " + balance);
	}
	
	
	// Getter & Setter ===============================================

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

}
