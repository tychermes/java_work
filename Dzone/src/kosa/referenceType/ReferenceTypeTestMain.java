package kosa.referenceType;

import kosa.oop.Account;
import kosa.oop.CheckingAccount;
import kosa.oop.MinusAccount;

public class ReferenceTypeTestMain {

	public static void main(String[] args) {

		// Account, CheckingAccount, MinusAccount객체를 하나의 배열에 담아보자.
		Account acc = new Account();
		CheckingAccount ca = new CheckingAccount();
		MinusAccount ma = new MinusAccount();

		Account[] accArray = {
				// (String accountNo, String ownerName, long balance)
				new Account("111-111", "홍길동", 10000),
				// (String accountNo, String ownerName, int balance, String cardNo)
				new CheckingAccount("222-222", "박길동", 5000, "222-222-222"),
				// (String accountNo, String ownerName, long balance, long creditLine)
				new MinusAccount("333-3330", "김길동", 5000, 5000) };

		// ===================
		try {
			accArray[0].withdraw(100);
			System.out.println("출금 완료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// ===================
//		try {
//			((CheckingAccount) accArray[1]).pay("222-222-222", 50);
//			((CheckingAccount) accArray[1]).print();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		// 뭐가 해당하는 CheckingAccount인지 모를 때, 아래와 같이 검사.
		for (int i = 0; i < accArray.length; i++) {
			if (accArray[i] instanceof CheckingAccount) {
				try {
					((CheckingAccount) accArray[i]).pay("222-222-222", 50);
					((CheckingAccount) accArray[1]).print();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		// ===================
		try {
			accArray[2].withdraw(100);
			System.out.println("출금 완료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
