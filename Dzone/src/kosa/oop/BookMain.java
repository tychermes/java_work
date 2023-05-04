package kosa.oop;

/*
 * 객체 과제> 책값을 계산하는 프로그램을 만들어 보자.
 * 교재 JAVA, JSP, Oracle 각각 가격이 30000, 25000, 15000 이다.
 * 교재 DC는 30000원 이상 25% 할인
 * 20000원 이상 20% 할인
 * 15000원 이상 15%할인
 * 
 * 결과> Java 교재는 정가는 30000원 할인된 가격은22500원 입니다.
 * JSP 교재는 정가는 20000원 할인된 가격은16000원 입니다.
 * Oracle 교재는 정가는 15000원 할인된 가격은12750원 입니다.
 * 총금액: 51250원
 * 
 * 객체지향 
 * 책값 DC하는 메서드를 구현
 * 책값을 출력하는  메서드도 따로 구현 
 * 
 * 객체모델링을 위한 상태와 행동으로 추상화 작업을 수행 한 후
 * 상태  ==> 변수
 * 행동 ==> 메서드   : 클래스를 완성한다.
 */
public class BookMain {

	public static void main(String[] args) {
		
		int total = 0;
		String[] names = {"JAVA", "JSP", "Oracle"};
		int[] price = {30000, 20000, 15000};
		Book[] books = new Book[3];
		
		// T: 배열 선언, 생성과 초기화를 '동시에' for문 밖에서 하는 방법.
		Book[] array = {
				new Book("JAVA", 3000),
				new Book("JSP", 20000),
				new Book("Oracle", 15000)				
		};
		
		for(int i=0; i<3; i++) {
			// 내 방법: 배열 선언은 for 밖에 하고, 생성과 초기화는 for 안에서 하는 방법.
			books[i] = new Book(names[i], price[i]);
			books[i].discount(); 
			total += books[i].finalPrice;
			books[i].printPrice();
		}
		System.out.println("총 금액: "+total+"원");
	}
}

