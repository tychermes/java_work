package kosa.oop;

public class Book {

	public int price;
	public float finalPrice;
	public String name;
	
	public Book() {}
	
	public Book(String name, int price) {
		super();
		this.price = price;
		this.name = name;
	}
	
	public float discount() {
		if(this.price >= 30000) {
			finalPrice = price * (1 - 0.3f);
		} else if(this.price >= 20000) {
			finalPrice = price * (1 - 0.2f);
		} else if(this.price >= 15000) {
			finalPrice = price * (1 - 0.15f);
		} else {
			finalPrice = price;
		}
		return finalPrice;
	}
	
	public void printPrice() {
		System.out.println(name+"교재는 정가는 "+price
				+"원, 할인된 가격은"+finalPrice+"원 입니다.");
	}
}
