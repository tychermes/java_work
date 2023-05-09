package kosa.oop;

public class CheckingAccountMain {

	public static void main(String[] args) {
		CheckingAccount ca = new CheckingAccount();
		ca.setAccountNo("111-111");
		ca.setOwnerName("홍길동");
		ca.setBalance(1000);
		ca.setCardNo("111-111");
		
		try {
			ca.pay("111-111", 50);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ca.print();

	}

}
