package kosa.order;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderMain {
	/*
	 * 주문관리 프로그램을 구현하자.
	 * 
	 * Member : 이름, 주소 Item : 모델명, 가격 Order : 주문번호, 회원내역, 제품내역, 수량, 주문금액
	 * 
	 * 결과> 주문번호 : 1 회원이름: 홍길동 회원주소: 가산 주문한 상품 모델명: 갤럭시23 주문한 상품 가격 : 100원 주문수량 : 10개
	 * 주문금액 : 1000원
	 */
	public static void main(String[] args) {

		// 멤버, 아이템, 주문 리스트를 생성
		List<Member> memberList = new ArrayList<Member>();
		List<Item> itemList = new ArrayList<Item>();
		List<Order> orderList = new ArrayList<Order>();

		// Manually Generating
//		// 멤버 목록 직접 생성
//		memberList.add(new Member("홍길동", "가산"));
//		memberList.add(new Member("김길동", "관악"));
//		memberList.add(new Member("이길동", "성남"));
//		memberList.add(new Member("박길동", "수원"));		
//		// 아이템 목록 직접 생성
//		itemList.add(new Item("갤럭시S23", 100));
//		itemList.add(new Item("갤럭시S23 Plus", 200));
//		itemList.add(new Item("갤럭시S23 Ultra", 300));

		Scanner sc = new Scanner(System.in);
		String menu;

		// 사용자 입력 받기
		boolean flag = true;
		while (flag) {
			System.out.println("_________________________________________________________________________");
			System.out.println("1.아이템 추가   2.아이템 삭제   3.전체 아이템 정보 출력   4.회원 추가   5.회원 삭제   6.전체 회원 정보 출력   ");
			System.out.println("7.주문 추가   8.개별 회원 주문 출력   9.전체 회원 주문 출력   q.종료");
			System.out.println("_________________________________________________________________________");				
			System.out.print("메뉴 입력: ");
			menu = sc.nextLine().trim();

			switch (menu) {
			case "1":
				// 아이템 추가
				System.out.print("추가할 아이템 이름을 입력하세요: ");
				String itemName = sc.nextLine().trim();
				System.out.print("추가할 아이템 가격을 입력하세요: ");
				int itemPrice = Integer.parseInt(sc.nextLine().trim());
				itemList.add(new Item(itemName, itemPrice));
				break;
			case "2":
				// 아이템 삭제
				System.out.print("삭제할 아이템 이름을 입력하세요: ");
				String delItemStr = sc.nextLine().trim();
				boolean isExist = false;
				for (Item i : itemList) {
					if (i.getName().contains(delItemStr)) {
						String iName = i.getName();
						itemList.remove(i);
						System.out.println(iName + " 아이템 삭제 완료.");
						isExist = true;
						break;
					}
				}
				if (!isExist) {
					System.out.println("해당 이름의 아이템이 존재하지 않습니다.");
				}
				// 확인차 출력
				Item.printItemList((ArrayList<Item>) itemList);
				break;
			case "3":
				// 전체 아이템 출력
				Item.printItemList((ArrayList<Item>) itemList);
				break;
			case "4":
				// 회원(멤버) 추가
				System.out.print("등록할 회원 이름을 입력하세요: ");
				String memberName = sc.nextLine().trim();
				System.out.print("등록할 회원 주소를 입력하세요: ");
				String memberAddress = sc.nextLine().trim();
				memberList.add(new Member(memberName, memberAddress));
				break;
			case "5":
				// 회원 삭제
				System.out.print("삭제할 회원 이름을 입력하세요: ");
				String delMemberStr = sc.nextLine().trim();
				boolean isExist2 = false;
				for (Member m : memberList) {
					if (m.getName().contains(delMemberStr)) {
						String mName = m.getName();
						memberList.remove(m);
						System.out.println(mName + " 회원 삭제 완료.");
						isExist2 = true;
						break;
					}
				}
				if (!isExist2) {
					System.out.println("해당 이름의 회원이 존재하지 않습니다.");
				}
				break;
			case "6":
				// 전체 회원 정보 출력
				Member.printMemberList((ArrayList<Member>) memberList);
				break;
			case "7":
				// 주문 추가 (특정 회원에 대하여) --★회원객체 아니고 스트링으로 비교해서 주문 생성하려니까 너무 어렵다!!★
				// 회원 객체 받아오기(SearchMember)
				System.out.print("주문할 회원 이름을 입력하세요: ");
				String memberString = sc.nextLine().trim();				
				Member mem = new Member();
				boolean isMem = false;
				for (Member m : memberList) {
					if (m.getName().contains(memberString)) {
						mem = m;
						System.out.println("mem: " + mem.getName());
						isMem = true;
						break;
					}
				}
				if(!isMem) {
					System.out.println("해당 이름의 회원이 존재하지 않습니다.");
					break; //★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
				}

				// 아이템 객체 받아오기(SearchItem)
				System.out.print("주문할 아이템 이름을 입력하세요: ");
				String itemString = sc.nextLine().trim();
				Item itm = new Item();
				boolean isItem = false;
				for (Item i : itemList) {
					if (i.getName().contains(itemString)) {
						itm = i;
						isItem = true;
						System.out.println("itm: " + itm.getName());
						break;
					}
				}
				if(!isItem) {
					System.out.println("해당 이름의 아이템이 존재하지 않습니다.");
					break; //★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
				}

				if(isMem && isItem) {
					// 마지막으로 아이템 수량 int 받고, 주문 객체 생성
					System.out.print("주문할 아이템 수량을 입력하세요: ");
					int quantity = Integer.parseInt(sc.nextLine().trim());
					Order order = new Order(mem, itm, quantity);
					orderList.add(order);
					mem.addPersonalOrder(order); // 멤버 객체에도 personalOrder를 넣어주자.
					// 확인차 전체 주문 출력
					Order.printOrderList((ArrayList<Order>) orderList);
				}
				break;
			case "8":
				// 개별 회원 주문 출력
				// 회원 객체 받아오기(SearchMember)
				System.out.print("주문할 회원 이름을 입력하세요: ");
				String memString = sc.nextLine().trim();				
				Member mem2 = new Member();
				boolean isMem2 = false;
				for (Member m : memberList) {
					if (m.getName().contains(memString)) {
						mem2 = m;
						System.out.println("mem: " + mem2.getName());
						isMem2 = true;
						break;
					}
				}
				if(!isMem2) {
					System.out.println("해당 이름의 회원이 존재하지 않습니다.");
					break; //탈출을 해줘야 오동작이 방지된다!!★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
				} else {	// 개별 회원 주문 출력
					mem2.printPersonalOrder();
				}
				break;
			case "9":
				// 전체 회원 주문 출력
				Order.printOrderList((ArrayList<Order>) orderList);
				break;
			case "q":
				// 종료
				System.out.println("프로그램을 종료합니다.");
				flag = false;
				break;
			default:
				System.out.println("메뉴를 잘못 입력했습니다.");
				break;
			}
		}

//		// 주문은 for문 등 사용해서 한꺼번에 진행이 불가능하고, 따로따로 해줘야 함.
//		orderList.add(new Order(memberList.get(0), itemList.get(0), 10));
//		orderList.add(new Order(memberList.get(1), itemList.get(2), 50));
//		orderList.add(new Order(memberList.get(2), itemList.get(1), 100));

//		Order.printOrderList((ArrayList<Order>) orderList);
//		// ▽ 아래 개별 프린트 대신에, ▲ 위와 같이 Static 메소드로 전체출력 하면 조금 더 깔끔하다.
//		orderList.get(0).printOrder();
//		orderList.get(1).printOrder();
//		orderList.get(2).printOrder();

	}

}
