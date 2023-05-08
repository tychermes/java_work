package kosa.order;

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
