package kosa.oop;

public class StaticExample {

	int total;	// 객체가 생성 될 때 메모리에 로드
	static int grandTotal;	// 처음부터 메모리에 로드됨.
	
	public static void add() {	// 처음부터 메모리에 로드됨.
		grandTotal += 10;
//		total += 20; // 에러: 아직 메모리에 로드되지도 않은 일반 멤버변수를 사용할 수 없음.
	}
	
	public static void main(String[] args) {
		add();
	}

}
