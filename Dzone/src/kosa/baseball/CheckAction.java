package kosa.baseball;

public class CheckAction implements Action {

	private String[] random;
	private String[] input;
	private int strike, ball, count;
	
	public CheckAction() {}
	
	public CheckAction(String[] random, String[] input) {
		super();
		this.random = random;
		this.input = input;
	}

	@Override
	public void act() {
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < 3; j++) {
				if (input[i].equals(random[j])) {
					if (i == j) {
						strike++;
					} else {
						ball++;
					}
				}
			}
		}
		System.out.println(strike + "S" + ball + "B");
	}

	// Getter & Setter ===========================
	public int getStrike() {
		return strike;
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public String[] getRandom() {
		return random;
	}

	public void setRandom(String[] random) {
		this.random = random;
	}

	public String[] getInput() {
		return input;
	}

	public void setInput(String[] input) {
		this.input = input;
	}

	
}
