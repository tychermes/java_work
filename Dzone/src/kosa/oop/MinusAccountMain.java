package kosa.oop;

import java.util.ArrayList;
import java.util.List;

public class MinusAccountMain {

	public static void main(String[] args) {
		List<MinusAccount> minusAccountList = new ArrayList<MinusAccount>();

		minusAccountList.add(new MinusAccount("111-111", "홍길동", 0, 10000));
		
		try {
			minusAccountList.get(0).withdraw(3000);
			System.out.println("출금 완료");
		} catch (Exception e) {
			e.printStackTrace(); 
			// 콘솔 출력값: "마이너스 한도를 초과하였습니다. 출금이 거절되었습니다."
		} finally {
			System.out.println();
		}
		minusAccountList.get(0).print();
		
		try {
			minusAccountList.get(0).withdraw(7100);
			System.out.println("출금 완료");
		} catch (Exception e) {
			e.printStackTrace(); 
			// 콘솔 출력값: "마이너스 한도를 초과하였습니다. 출금이 거절되었습니다."
		} finally {
			System.out.println();
		}
		minusAccountList.get(0).print();
	}
	
	

}
