package kosa.order;

import java.util.ArrayList;

// Order : 주문번호, 회원내역, 제품내역, 수량, 주문금액
public class Order {
	
	public static int orderCount = 0;
	
	private int orderNo, quantity, amount;
	private Member member;
	private Item item;
	
	public Order() {}
	
	public Order(Member member, Item item, int quantity) {
		super();
		this.quantity = quantity;
		this.member = member;
		this.item = item;

		this.orderNo = ++orderCount;
		this.amount = quantity * item.getPrice();
	}
	
//	public Order(String memberName, String itemName, int quantity) {
//		super();
//		this.quantity = quantity;
//		if() {
//			
//		}
//		this.item = item;
//
//		this.orderNo = ++orderCount;
//		this.amount = quantity * item.getPrice();
//	}
	
	public static void printOrderList(ArrayList<Order> orderList) {
		for(Order o : orderList) {
			o.printOrder();
		}
	}
	
	public void printOrder() {
		System.out.println("---------------------------------------");
		System.out.println("주문번호: "+orderNo);
		System.out.println("회원이름: "+member.getName());
		System.out.println("회원주소: "+member.getAddress());
		System.out.println("주문한 상품 모델명: "+item.getName());
		System.out.println("주문한 상품 가격: "+item.getPrice()+"원");
		System.out.println("주문한 수량: "+quantity+"개");
		System.out.println("주문한 금액: "+amount+"원");
	}

	
	// Getter & Setter
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
}
