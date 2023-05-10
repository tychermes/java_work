package kosa.oop;

public class MinusAccount extends Account {

	// 난 마이너스 통장을 잘 몰랐다고...ㅜㅜ
	private long creditAmount; // 마이너스된 금액
	private long creditLine; // 마이너스 금액 한도

	public MinusAccount() {}
	
	public MinusAccount(String accountNo, String ownerName, long balance, long creditLine) {
		super(accountNo, ownerName, balance);
		this.creditLine = creditLine;
	}

	// Method Override ============================
	@Override
	public int withdraw(int amount) throws Exception {
		// super도 다른클래스니까 private 변수는 getter 써야 함
		long balance = getBalance(); //TODO: super.getBalance(); 해도 되는데 그렇게 잘 안씀.//아니야..다시 잘 생각해봐
		if(creditAmount + amount <= creditLine) { // 신용금액+출금액이 신용한도를 넘기 전에
			if (balance < amount) {
				setCreitAmount(amount - balance);
			}
//			balance -= amount;	// <- 같은 클래스라고 이렇게 직접 변수를 건들기 보다...
			setBalance(balance - amount); // <- 이렇게 set메소드를 사용하는 게 낫다.
		} else {
			 //e.getMessage()반환이나 e.printStackTrace()출력하면 나오는 스트링 설정.
			throw new Exception("마이너스 한도를 초과하였습니다. 출금이 거절되었습니다.");
		}
		return amount; // 인출한 금액 // 여기서 super.withdraw 할 필요 X! 완전히 재정의
	}
	public void print() {
		super.print();
		System.out.println("마이너스 금액: "+ creditAmount);
		System.out.println("마이너스 한도: "+ creditLine);
		System.out.println();
	}
	// Getter & Setter ==============================
	public long getCreditAmount() {
		return creditAmount;
	}
	
	public void setCreitAmount(long newAmount) {
		this.creditAmount += newAmount;
	}

}
