package kosa.order;

import java.util.ArrayList;

// Item : 모델명, 가격
public class Item {
	String name;
	int price;

	public Item() {}
	
	public Item(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	
	
	public static void printItemList(ArrayList<Item> itemList) {
		for(Item i : itemList) {
			i.printItem();
		}
	}
	
	public void printItem() {
		System.out.println("---------------------------------------");
		System.out.println("아이템 이름: "+name);
		System.out.println("아이템 가격: "+price+"원");
	}
	
	// Getter & Setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
