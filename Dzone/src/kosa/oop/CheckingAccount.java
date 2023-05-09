package kosa.oop;

public class CheckingAccount extends Account {
	
	private String cardNo;
	
	public CheckingAccount() {}
	
	public CheckingAccount(String cardNo) {
		// 생성자의 첫번째 줄에는 부모 생성자를 호출함.(밑으로 내려가면 에러남)
		super();	// 부모의 생성자 중 어떤 생성자를 호출하겠느냐= > 부모의 기본 생성자를 호출하겠다.
		// 생성자를 호출한다는 것은, 부모의 객체도 함께 생성 한다는 의미. 
		// 그래서 부모가 먼저 생성 완료가 되고,
		this.cardNo = cardNo;
	}
	
	

	public CheckingAccount(String accountNo, String ownerName, int balance,  String cardNo) {
		// 생성자의 첫번째 줄에는 부모 생성자를 호출함.(밑으로 내려가면 에러남)
		// 아무 부모 생성자도 호출하지 않으면, 부모의 디폴트 생성자를 자동으로 호출함.
		super(accountNo, ownerName, balance); // 부모의 생성자 중 어떤 생성자를 호출하겠느냐
		// 생성자를 호출한다는 것은, 부모의 객체도 함께 생성 한다는 의미. 
		// 그래서 부모가 먼저 생성 완료가 되고, 부모의 변수와 메소드를 사용할 수 있는 것임.
		this.cardNo = cardNo;
	}

	public int pay(String cardNo, int amount) throws Exception {
		if(!cardNo.equals(this.cardNo) || getBalance()<amount) {
			throw new Exception("결제 불능");
		}		
		return withdraw(amount);
		
	}
	

	// Getter & Setter ===============================================
	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	
	

}
