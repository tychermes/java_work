package kosa.bank;


public class MyBank {
	
	private Customer[] customers;
	// 생성자 안에서 말고, 여기에서 ▽ 아래와 같이 초기화 해줘도 됨.
	// private Customer[] customers = new Customer[BankSystem.MAX_CUSTOMER_NUM];
	private int customersNum = 0;
		
	public MyBank() {
		super();
		customers = new Customer[BankSystem.MAX_CUSTOMER_NUM];
	}

	// Method ======================================
	public void addCustomer(String id, String name, long balance) {
		customers[customersNum++] = new Customer(id, name, balance);
	}
	

	public Customer getCustomer(String id) {
		for(int i=0; i<customersNum; i++) {
			if(customers[i].getId().equals(id)) {
				return customers[i];
			}
		}
		return null;
		// getCustomer를 불러오는 곳에서 Exception(NullPointerException) 처리 해줌.
	}

	
	// Getter ======================================	
	public Customer[] getAllCustomers() {
		// XXX 아래 내용은 구현했다가, 괜히 for 루프 사용만 늘려서 지움. 대신getCustomersNum()으로 넘겨줌. XXX
		// OOO [T's 수정!!] 아니야 위에 잘했어... 불러오는 쪽이 갑이므로 그쪽이 원하는대로 딱 잘라서 가져와야 함! OOO
		Customer[] realCustomers = new Customer[customersNum];
		for(int i=0; i<customersNum; i++) {
			realCustomers[i] = this.customers[i];
		}
//		// 아래 API를 사용한 한줄은, 위의 for문을 사용한 4줄과 같다!
//		// System.arraycopy(customers, 0, realCustomers, 0, customersNum);
		return realCustomers;
	}

	public int getCustomersNum() {
		return customersNum;
	}
	
}
