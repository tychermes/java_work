package kosa.food;

public class Order {


	private Food food;
	private int amount;
	private int total; // T's 추가: 한 영수증 당 총 금액
	
	public Order() {}
	
	public Order(Food food, int amount) {
		super();
		this.food = food;
		this.amount = amount;
		this.total = food.getPrice() * amount;
	}
	
	public void show() {
		food.show();
		System.out.println("주문 수량: "+amount);
		System.out.println("주문 금액: "+total);
	}
	
	
	// Getter & Setter ===========================
	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public int getTotal() {
		return total;
	}

	@Override
	public String toString() {
		return "Order [food=" + food + ", amount=" + amount + "]";
	}
	

}
