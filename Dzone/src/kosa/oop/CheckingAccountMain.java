package kosa.oop;

public class CheckingAccountMain {

	public static void main(String[] args) {

		// 2023.05.10 추가한 코드===============================================
		CheckingAccount ca = new CheckingAccount();
		Account account = ca; // CheckingAccount로 생성한 객체를 Account로 캐스팅 가능.

		Account obj = new CheckingAccount(); // 위의 두줄을 이 한줄로도 표현 가능함.
		
//		obj.pay("111-111", 50);	// pay 메소드가 정의되지 않았다는 에러가 뜸.
//		// 부모 클래스로 형변화하면, 부모로부터 상속받은 변수나 부모 메소드를 오버라이딩 한 것이 아닌, 
//		// 자식 클래스만이 가지고 있는 변수나 메소드는 '접근' 불가.
//		
//		CheckingAccount obj2 = obj;	// 잘못된 대입
		CheckingAccount obj3 = (CheckingAccount)obj;
		obj3.setAccountNo("111-111");
		obj3.setOwnerName("홍길동");
		obj3.setBalance(1000);
		obj3.setCardNo("111-111");
		try {
			obj3.pay("111-111", 50);
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		obj3.print();
		
		// 원래 코드 =================================
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
