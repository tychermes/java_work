package kosa.order;

import java.util.ArrayList;
import java.util.List;

// Member : 이름, 주소
public class Member {
	private String name, address;
	private List<Order> personalOrderList;	
	// TODO: ★★ Member 클래스에는 이렇게 List<Order>를 멤버로 가지고 있는데, ★★ 
	// 왜 Order 클래스에는 List<Member>를 멤버로 가지지 않지??? 단지 Member클래스만 멤버로 가지잖아..

	public Member() {}
	
	public Member(String name, String address) {
		super();
		this.name = name;
		this.address = address;
		this.personalOrderList = new ArrayList<Order>();
	}

	public static void printMemberList(ArrayList<Member> memberList) {
		for(Member m : memberList) {
			System.out.println("---------------------------------------");
			m.printMember();
		}
	}
	
	public void printMember() {
		System.out.println("회원 이름: "+name);
		System.out.println("회원 주소: "+address);
	}
	
	public void addPersonalOrder(Order order) {
		personalOrderList.add(order);
	}

	public void printPersonalOrder() {
		System.out.println("---------------------------------------");
//		printMember();
		Order.printOrderList((ArrayList<Order>)personalOrderList);
	}
	
	// Getter & Setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
