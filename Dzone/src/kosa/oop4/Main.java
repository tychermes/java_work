package kosa.oop4;


public class Main {

	public static void main(String[] args) {
		Object obj[] = {
				new Reader("둘리"), 
				new Worker("길동"), 
				new Student("마이콜")
				};
		
		for(int i=0; i<obj.length; i++) {
			if(obj[i] instanceof Speakable) {
				System.out.println(((Speakable)obj[i]).speak());
				// 이 때, obj[i].speak();로만 호출한다면, 오류 남.
				// 부모 타입으로 캐스팅 됐을 때에는 자식 타입의 메소드를 사용할 수 없으므로, 
				// 다시 자식타입(인터페이스도 해당)으로 강제캐스팅 해주어야 함.
			} 
		}
	
	}
	
}
