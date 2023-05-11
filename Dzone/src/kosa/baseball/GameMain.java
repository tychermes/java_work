package kosa.baseball;

//class RandomAction implements Action {
//
//}

public class GameMain {
	
	public static void main(String[] args) {
		// 난수 생성
//		RandomAction ran = new RandomAction(); // 람다식으로 안했을 때.
		// △ RandomAction은 한 번 쓰는데 이름있는 클래스로 따로 정의가 필요함? 
		// ▼ TODO: 람다로 안될까? 해보자...
		// ▼ 람다식 이전에 클래스 멤버였던 변수를 쓰려면 이렇게 메인에서 선언&초기화 해주면 된다!
		String[] random = new String[Action.LENGTH];
		Action ran = () -> {
			System.out.print("난수 정답: ");
			for(int i=0; i<random.length; i++) {
				random[i] = String.valueOf((int)(Math.random()*9)+1);// 0~9까지
				// ▽ 중복이면 다시 난수 생성
				for (int j=0; j<i; j++) {
					while(random[i].equals(random[j])) {
						random[i] = String.valueOf((int)(Math.random()*9)+1);
					}
				}
				System.out.print(random[i]);
			}
			System.out.println(" <-실제로는 사용자에게 보여지지 않아야 함.");
		};
		ran.act();

		CheckAction check;
		InputAction input;
		int count = 0;

		do {
			input = new InputAction();
			input.act();
			// ▽람다식으로 안했을 때에는 아래와 같이 RandomAction 클래스를 객체 생성하여 
			// 					첫번째 인자로 ran.getRandom() 를 넣음.
//			check = new CheckAction(ran.getRandom(), input.getInput());
			check = new CheckAction(random, input.getInput()); //<-람다식으로 변경했을 때.
			check.act();
			check.setCount(++count);
			
		} while(check.getStrike() < Action.LENGTH); // < 3
		
		System.out.println(check.getCount()+"번째 성공");
		System.out.println("프로그램을 종료합니다.");

	}
	
}
