package kosa.oop2;

public class Main {

	public static void main(String[] args) {

		// 아래는 간단히 테스트 하도록 Person을 2명으로 만들었다.
		Study myStudy = new Study();
		Person p1 = new Person("홍길동", myStudy);	
		// ===== 여기까지 Person과 Study 객체의  기본적인 연관관계를 만들고 처리함.
		p1.doIt();	// 기능 수행.
		Work myWork = new Work();
		Person p2 = new Person("가나다", myWork);	
		// ===== 여기까지 Person과 Work 객체의  기본적인 연관관계를 만들고 처리함.
		p2.doIt();	// 기능 수행.
		
		
		// 코드의 독립성을 위해서는, 아래처럼 Person을 한명으로 만들어 사용.
		Study study = new Study();
		Work work = new Work();
		Person p = new Person("나나나", work); // study와 work를 번갈아 바꿔서 실행해보자.
		p.doIt();	// 기능 수행.
		
		Person per = new Person("아바라", new Role() {

			@Override
			public void doing() {
				System.out.println("Driver 역할");
			}
			
		});
		per.doIt();
	}
}
