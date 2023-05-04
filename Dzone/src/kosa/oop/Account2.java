package kosa.oop;

public class Account2 {
	public String accNo, name;
	public int balance;
	public int[] depositArray, withdrawalArray, balanceArray;
	public int dCount, wCount, bCount;
	
	public Account2() {}

	public Account2(String accNo, String name) {
		super();
		this.accNo = accNo;
		this.name = name;
		this.balance = 0;
//		this.dCount = 0;
//		this.wCount = 0;
//		this.depositArray = new int[100];
//		this.withdrawalArray = new int[100];
//		this.balanceArray = new int[200];
	}
	
	// 입금하다
	public void deposit(int amount) {
		this.balance += amount;
//		this.balanceArray[this.bCount++] = this.balance;
//		this.depositArray[this.dCount++] = amount;
	}
	
	// 출금하다
	public void withdraw(int amount) throws Exception {
		if(amount>this.balance) {
			throw new Exception("잔액이 부족합니다.");
		} else {
			this.balance -= amount;			
		}
//		this.balanceArray[this.bCount++] = this.balance;
//		this.withdrawalArray[this.wCount++] = amount;
	}
	
	public void print() {
		System.out.println("-----------------------------------------------------------");
		System.out.println("계좌번호: "+ this.accNo +"\t예금주:"+this.name +"\t잔액: "+ this.balance);
	}
		
}
