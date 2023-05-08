package kosa.order;

import java.util.List;
import java.util.ArrayList;

public class OrderMain {
	/*
	 * 주문관리 프로그램을 구현하자.
	 * 
	 * Member : 이름, 주소
	 * Item : 모델명, 가격
	 * Order : 주문번호, 회원내역, 제품내역, 수량, 주문금액
	 * 
	 * 결과> 주문번호 : 1 
	 * 회원이름: 홍길동
	 * 회원주소: 가산 
	 * 주문한 상품 
	 * 모델명: 갤럭시23 
	 * 주문한 상품 가격 : 100원
	 * 주문수량 : 10개
	 * 주문금액 : 1000원
	 */
	public static void main(String[] args) {
		
		// 멤버, 아이템, 주문 리스트를 생성
		List<Member> memberList = new ArrayList<Member>();
		List<Item> itemList = new ArrayList<Item>();
		List<Order> orderList = new ArrayList<Order>();
		
		// 멤버 목록 생성
		memberList.add(new Member("홍길동", "가산"));
		memberList.add(new Member("김길동", "관악"));
		memberList.add(new Member("이길동", "성남"));
		memberList.add(new Member("박길동", "수원"));
		
		// 아이템 목록 생성
		itemList.add(new Item("갤럭시S23", 100));
		itemList.add(new Item("갤럭시S23 Plus", 200));
		itemList.add(new Item("갤럭시S23 Ultra", 300));
		
		// 주문은 for문 등 사용해서 한꺼번에 진행이 불가능하고, 따로따로 해줘야 함.
		orderList.add(new Order(memberList.get(0), itemList.get(0), 10));
		orderList.add(new Order(memberList.get(1), itemList.get(2), 50));
		orderList.add(new Order(memberList.get(2), itemList.get(1), 100));
		
		
		Order.printOrderList((ArrayList<Order>)orderList);
//		// ▽ 아래 개별 프린트 대신에, ▲ 위와 같이 Static 메소드로 전체출력 하면 조금 더 깔끔하다.
//		orderList.get(0).printOrder();
//		orderList.get(1).printOrder();
//		orderList.get(2).printOrder();
		
	}

}
