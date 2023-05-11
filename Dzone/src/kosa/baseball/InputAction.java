package kosa.baseball;

import java.util.Scanner;

public class InputAction implements Action {

	private String[] input;

	public InputAction() {
		super();
		this.input = new String[LENGTH];
	}

	@Override
	public void act() {
		Scanner sc = new Scanner(System.in);
		System.out.print("임의의 수 3자리를 입력하세요: ");
		// TODO: ▽ 3개 초과의 숫자를 입력하면 Exception발생 할 줄 알았는데 안하네..? 왜??
		input = sc.nextLine().trim().split("");
	}
	
	// Getter & Setter ===========================
	public String[] getInput() {
		return input;
	}

	public void setInput(String[] input) {
		this.input = input;
	}
}