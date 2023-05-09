package kosa.bank;

public class Account {
	private String id;
	private long balance;
	
	public Account(String id, long balance) {
		super();
		this.id = id;
		this.balance = balance;
	}

	// Method ======================================
	public void deposit(long amount) {
		balance += amount;
	}
	
	public boolean withdraw(long amount) {
		if (balance >= amount) {
			balance -= amount;
			return true;
		} else {
			return false;			
		}
	}

	public String getId() {
		return id;
	}

	public long getBalance() {
		return balance;
	}
	
}
