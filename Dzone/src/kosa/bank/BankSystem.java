package kosa.bank;
/* 
 * 설계한 클래스 다이어그램 보고 의미 이해하기!
 * 1. 고객 등록: 이름 입력, 잔고 입력
 * 2. 고객ID입력 (이름 없으면 "등록된 고객이 아닙니다." 뜨게끔.)
 * 3. 전체 고객 출력(ID,name,account 정보)
 *		(배열 5개면 3개만 했을 떄 출력시 nullpointException 발생 가능성.
 *		=> 처리방법!: 애초에 배열을 잘라서 가져오든지:Good! / customerNum인덱스를 get해오든지.)
 * 4. 출금액 입력하세요 -> 정상적 출금.출금후 잔고 출력 / 잔고가 부족합니다 출력
 * 5. 입금액 입력하세요 -> 정상적 입금.입금후 잔고 출력 
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BankSystem {
	private MyBank myBank; // MyBank
	public static final int MAX_CUSTOMER_NUM = 5;  
	// ★★★ 등록 고객 수는  MAX_CUSTOMER_NUM 을 초과하면 안됨
	
	public BankSystem() {
		myBank = new MyBank();
		showMenu();
	}

	public void showMenu() { // show method 만들기
		String menu = null;
		String id = null;
		String name = null;
		long amount = 0;

		do {

			System.out.println("****메뉴를 입력하세요****");
			System.out.println("1. 고객등록");
			System.out.println("2. 고객보기(1명)");
			System.out.println("3. 고객전체보기");
			System.out.println("4. 고객예금출금");
			System.out.println("5. 고객예금입금");
			System.out.println("***끝내기***");
			System.out.println("***************");
			System.out.print(">>");

			menu = readFromKeyboard();

			if (menu.equals("1")) { // 고객등록

				System.out.print("ID를 입력하세요: ");
				id = readFromKeyboard();

				System.out.print("이름을 입력하세요: ");
				name = readFromKeyboard();

				System.out.print("잔고를 입력하세요: ");
				amount = Long.parseLong(readFromKeyboard());

				myBank.addCustomer(id, name, amount);

			} else if (menu.equals("2")) {
				System.out.print("고객ID를 입력하세요: ");
				id = readFromKeyboard();
				Customer cust = myBank.getCustomer(id);
				try {
					System.out.println(cust.getId() + ":" + cust.getName() + ": " + cust.getAccount().getBalance());
				} catch (Exception e) {
					System.out.println("찾으시는 고객이 없습니다.");
					e.getStackTrace();
				}

			} else if (menu.equals("3")) {

				Customer[] allCust = myBank.getAllCustomers();	// 원본 배열이 아닌 고객수 만큼 길이를 잘라낸 배열로 반환
				for (int i = 0; i < allCust.length; i++) {
					System.out.println(allCust[i].getId() + ": " + allCust[i].getName() + " :"
							+ allCust[i].getAccount().getBalance());
				}

			} else if (menu.equals("4")) {

				System.out.print("고객의 ID를 입력하세요.: ");
				id = readFromKeyboard();
				if (myBank.getCustomersNum() < MAX_CUSTOMER_NUM) {
					Customer cust = myBank.getCustomer(id);

					if (cust == null) {
						System.out.println("등록된 고객이 아닙니다.");

					} else {
						System.out.print("출금액을 입력하세요: ");
						try {
							amount = Long.parseLong(readFromKeyboard());
							if (amount <= 0) { // ★★★출금액은 0원 초과 해야 함. (0 또는 음수값이면 안됨)
								System.out.println("0원를 초과하는 출금액을 입력하세요.");
							} else if (cust.getAccount().withdraw(amount)) {
								System.out.println("정상적으로 출금되었습니다.");
								System.out.println("출금후 잔고는 :" + cust.getAccount().getBalance());
							} else {
								System.out.println("잔고가 부족합니다.");
							} // inner-inner else
						} catch (NumberFormatException e) {
							// ★★★출금액은 문자나 문자열이 아닌 정수여야 함.
							System.out.println("출금액은 양의 정수로 입력하세요.");
						}

					} // inner-inner else
				} else { // ★★★ 등록 고객 수는  maxCustomerNum 을 초과하면 안됨
					System.out.println("고객은 최대 "+MAX_CUSTOMER_NUM+"명 이상 등록할 수 없습니다.");
				}// inner else
			} else if (menu.equals("5")) {
				System.out.print("고객의 ID를 입력하세요.: ");
				id = readFromKeyboard();

				Customer cust = myBank.getCustomer(id);

				if (cust == null) {
					System.out.println("등록된 고객이 아닙니다.");

				} else {
					System.out.print("입금액을 입력하세요: ");
					try {
						amount = Long.parseLong(readFromKeyboard());
						if (amount <= 0) { // ★★★입금액은 0원 초과 해야 함. (0 또는 음수값이면 안됨)
							System.out.println("0원를 초과하는 입금액을 입력하세요.");
						} else {
							cust.getAccount().deposit(amount);
							System.out.println("정상적으로 입금되었습니다.");
							System.out.println("입금후 잔고는 :" + cust.getAccount().getBalance());
						} // inner-inner else
					} catch (NumberFormatException e) {
						// ★★★입금액은 문자나 문자열이 아닌 정수여야 함.
						System.out.println("입금액은 양의 정수로 입력하세요.");
					}
				} // inner else
			} else if (!menu.equals("q")) { // ★★★메뉴 잘못 고르는 경우 추가.
				System.out.println("잘못된 메뉴 번호를 고르셨습니다.");
			} // outer else

		} while (!menu.equals("q"));

		System.out.println("프로그램을 종료합니다."); // ★★★종료 메시지 출력
	}

	public String readFromKeyboard() {
		String input = null;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			input = br.readLine().trim(); // ★★★ both 사이드 공백제거 trim()추가
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return input;
	}

	public static void main(String[] args) {
		BankSystem bank = new BankSystem();

	}

}