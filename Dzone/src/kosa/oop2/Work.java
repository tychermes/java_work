package kosa.oop2;

public class Work implements Role {

	// Role 이라는 추상클래스를 상속받아서 아래 코드를 무조건 구현해야 함.
	@Override
	public void doing() {
		System.out.println("Work 역할");

	}

}
