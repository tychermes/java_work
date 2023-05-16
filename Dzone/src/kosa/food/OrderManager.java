package kosa.food;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class OrderManager {
	
	private LinkedList<Order> orderQueue;
	private ArrayList<Food> foodList;
	

	int totalSales;

	
	public OrderManager() {
		super();
		this.orderQueue = new LinkedList<Order>();
		this.foodList = new ArrayList<Food>();
		this.setFoodList(foodList);
	
	}

	// Function ==================================
	public void printTotalSales() {
		System.out.println("총 매출액: "+getTotalSales()+"원");
	}
	
	public void requestOrder() {
		System.out.println(foodList.toString());

		System.out.print("주문할 메뉴를 선택하세요: ");
		String name = Main.sc.nextLine().trim();
		System.out.print("수량을 입력하세요: ");
		int amount = Integer.parseInt(Main.sc.nextLine().trim());
		
		Iterator<Food> iter = foodList.iterator();
		Food food = null;
		boolean isContains = false;
		try {
			while(iter.hasNext()) {
				food = iter.next();
				if(name.equals(food.getFoodName())) {
					isContains = true;
					orderQueue.offer(new Order(food, amount));
					break;
				}
			}
			System.out.println((isContains)?"주문 완료":"선택하신 메뉴가 리스트에 없습니다.");
		} catch (Exception e) {
			System.out.println("메뉴 리스트에 메뉴가 한 개도 없음.");
		}
		
		// 교수님은 
//		// orderQueue.offer(new Order(new Food(name, price), amount)); 이렇게 하는데? ㅋㅋ손님 맘대로 금액 정하는 시스템인가봄.
		System.out.println(orderQueue.toString());

	}
	
	public void printFoodMenu() {
		for(Food f : foodList) {
			System.out.println(f.getFoodName());
		}
	}

	
	public void processOrder() {
		System.out.println(orderQueue.toString());
//		while(!orderQueue.isEmpty()) { // 일괄 처리 하려면 이렇게.
		if(!orderQueue.isEmpty()) { // 한 개씩 처리하려면 이렇게.
			setTotalSales(getTotalSales() + (orderQueue.peek().getFood().getPrice() * orderQueue.peek().getAmount()));
			orderQueue.poll();
		}
	}
	
	// Getter & Setter ===========================
	public LinkedList<Order> getOrderQueue() {
		return orderQueue;
	}

	public void setOrderQueue(LinkedList<Order> orderQueue) {
		this.orderQueue = orderQueue;
	}

	public int getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}
	
	public ArrayList<Food> getFoodList() {
		return foodList;
	}

	public void setFoodList(ArrayList<Food> foodList) {
		foodList.add(new Food("돈까스", 9000));
		foodList.add(new Food("냉모밀", 7000));
		foodList.add(new Food("제육덮밥", 9000));
		foodList.add(new Food("비빔밥", 8000));
	}

}
